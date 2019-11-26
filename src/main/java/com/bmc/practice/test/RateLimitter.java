package com.bmc.practice.test;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class RateLimitter {

	public static void main(String[] args) {

		//create queue of fixed size to system max upper limit
		BlockingQueue<RequestData> requestHoldingQueue = new ArrayBlockingQueue<>(Constants.systemUppperLimit);
		//initialize a queue handler to hold requests
		QueueHandler queueHandle = new QueueHandler(requestHoldingQueue);
		
		ClientSignUp signUpClients =  ClientSignUp.getInstance();

		//create a dummy client with 2 dummy request data
		signUpClients.setclientsLicenseData(1, LicenseTypes.LOW);
		//add 2 request for client id 1
		queueHandle.addRequestToQueue(new RequestData(1, System.currentTimeMillis()/1000));		
		queueHandle.addRequestToQueue(new RequestData(1, System.currentTimeMillis()/1000));
		
		//submit more req in order to get some rejection for client id 1
		queueHandle.addRequestToQueue(new RequestData(1, System.currentTimeMillis()/1000));
		queueHandle.addRequestToQueue(new RequestData(1, System.currentTimeMillis()/1000));
		queueHandle.addRequestToQueue(new RequestData(1, System.currentTimeMillis()/1000));
		queueHandle.addRequestToQueue(new RequestData(1, System.currentTimeMillis()/1000));
		queueHandle.addRequestToQueue(new RequestData(1, System.currentTimeMillis()/1000));
		queueHandle.addRequestToQueue(new RequestData(1, System.currentTimeMillis()/1000));
		queueHandle.addRequestToQueue(new RequestData(1, System.currentTimeMillis()/1000));
		queueHandle.addRequestToQueue(new RequestData(1, System.currentTimeMillis()/1000));
		 //this 11th incoming req will be rejected by api for LOW type client
		queueHandle.addRequestToQueue(new RequestData(1, System.currentTimeMillis()/1000));
		
		//register client id 2
		signUpClients.setclientsLicenseData(2, LicenseTypes.MEDIUM);
		queueHandle.addRequestToQueue(new RequestData(2, System.currentTimeMillis()/1000));

		
		//now start Request handler
		RequestHandler reqHandle = new RequestHandler(requestHoldingQueue);
		reqHandle.processRequests(); //start processing all qeueue request now. This can also be ran parallely using a thread
	}
	

}

//THis class will have the data related to client and their plan/pack details. This will be a singleton class
class ClientSignUp {
	
	private Map<Integer, LicenseTypes> clientsLicenseData = new HashMap<>();	
	private static ClientSignUp instance = null;	//singleton instance of client details
	
	private ClientSignUp()  {		
	}
	
	public static ClientSignUp getInstance () {
		
		if(instance == null){
	        synchronized (ClientSignUp.class) {
	            if(instance == null){
	                instance = new ClientSignUp();
	            }
	        }
	    }
	    return instance;	
	}

	public void setclientsLicenseData(int clientId, LicenseTypes lType) {
		clientsLicenseData.put(clientId, lType);
	}

	public LicenseTypes getclientsLicenseData(int clientId) {
		return clientsLicenseData.get(clientId);
	}	
}

//class for holding incoming requests data
class RequestData {

	private int clientId;
	private long reqTimeEpocSec; // incoming request time in seconds
	static final long QUEUED_REQ_TIMEOUT_SEC = 20;  // time out factor in second
	
	RequestData(int clientId, long reqTimeEpocSec) {
		this.clientId = clientId;
		this.reqTimeEpocSec = reqTimeEpocSec;
	}

	public int getClientId() {
		return this.clientId;
	}

	public long getReqTimeEpocSec() {
		return this.reqTimeEpocSec;
	}

	public boolean isRequestExpired(long currentTime) {
		return currentTime - this.reqTimeEpocSec > QUEUED_REQ_TIMEOUT_SEC;
	}

}

//This class in needed to have a queue handle, putting incoming req to queue, rejecting request if system limits breached.
class QueueHandler {
	
	private BlockingQueue<RequestData> requestHoldingQueue; //queue reference holding request objects
	
	private RequestLimitMonitor updateReqCounts = RequestLimitMonitor.getInstance();
	
	private ClientSignUp clientObj = ClientSignUp.getInstance();

	public QueueHandler(BlockingQueue<RequestData> requestHoldingQueue) {
	
		this.requestHoldingQueue = requestHoldingQueue;
	}

	public void addRequestToQueue(RequestData incomingRequest) {
		
		//Before inserting to queue check all allowed limits else reject request
		int clientId = incomingRequest.getClientId();
		int clientReqCount = (updateReqCounts.getClientRequestCountMap().get(clientId)!=null)?updateReqCounts.getClientRequestCountMap().get(clientId):0;
		int systemReqCount = updateReqCounts.getSystemRequestCount();
		
		if ( clientReqCount < clientObj.getclientsLicenseData(clientId).planLimit && 
				systemReqCount < Constants.systemUppperLimit) {
			
			updateReqCounts.incrementRequestCount(clientId); //update req counts
			
			requestHoldingQueue.add(incomingRequest); //now add to queue

		}
		else {
			System.out.println("Not Adding to request queue as system/user resources threashold reached for client "+clientId);
		}
	}
}

//this class is responsible for handling all incoming requests read to queue
class RequestHandler {
	
	private BlockingQueue<RequestData> requestHoldingQueue;
	private RequestLimitMonitor updateReqCounts = RequestLimitMonitor.getInstance();

	public RequestHandler(BlockingQueue<RequestData> requestHoldingQueue) {
		this.requestHoldingQueue = requestHoldingQueue;
	}

	public void processRequests() {
		
		//this while loop can also be forever loop if separate thread processing queue and incoming req flow is continous.
		while (!requestHoldingQueue.isEmpty()) {
			try {
				RequestData req = requestHoldingQueue.take();
				
				long currentTime = System.currentTimeMillis()/1000; //convert to second
				// evaluate if the request has expired or not before processing
				if (req.isRequestExpired(currentTime)) {
					System.out.println("Request for client "+req.getClientId()+" has expired, drop it.");
					continue;
				}

				// now try processing the request here
				System.out.println("Processing request for client... "+req.getClientId());
				Thread.sleep(1000); //dummy sleep for testing print statements
				
				//reduce the request count for this client now
				updateReqCounts.decrementRequestCount(req.getClientId());
				
				System.out.println("Request Processed. Pending request count for client "+updateReqCounts.getClientRequestCountMap().get(req.getClientId()));

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("All messages read from queue");
	}	
}

//this class going to maintain and monitor the limits client and system wise. This will be a singleton class
class RequestLimitMonitor {
	
	//this map will hold client id and their request count
	private Map<Integer, Integer> clientReqCountMap = new ConcurrentHashMap<Integer, Integer>();
	private int systemRequestCount = 0;
		
	private static RequestLimitMonitor instance = null; //single instance of this class

	private RequestLimitMonitor() {		
	}
	
	public static RequestLimitMonitor getInstance( ) {
		
		if (null == instance) {
			synchronized(RequestLimitMonitor.class) {
				if(instance == null){
	                instance = new RequestLimitMonitor();
	            }				
			}
			
		}
		return instance;		
	}

	public Map<Integer, Integer> getClientRequestCountMap() {
		return clientReqCountMap;
	}

	public void setClientRequestCountMap(Integer clientIdKey, Integer clientReqCount) {
		
		this.clientReqCountMap.put(clientIdKey, clientReqCount);
	}
	
	//this method will increase the request count for every client id and system as well,
	// will always plus one to older value.
	public void incrementRequestCount(Integer clientIdKey) {
		
		int clientReqCount = (this.getClientRequestCountMap().get(clientIdKey)!=null)?this.getClientRequestCountMap().get(clientIdKey):0;
		int systemReqCount = this.getSystemRequestCount();
		
		this.clientReqCountMap.put(clientIdKey, ++clientReqCount);  //increase client level count
		this.setSystemRequestCount(++systemReqCount); //increase system level req count
	}
	
	//this method will decrease the request count for every client id and system as well,
	// will always minus one to older value
	public void decrementRequestCount(Integer clientIdKey) {
	
		int clientReqCount = (this.getClientRequestCountMap().get(clientIdKey)!=null)?this.getClientRequestCountMap().get(clientIdKey):0;
		int systemReqCount = this.getSystemRequestCount();
			
		this.clientReqCountMap.put(clientIdKey, --clientReqCount);
		this.setSystemRequestCount(--systemReqCount); 
	}

	public int getSystemRequestCount() {
		return systemRequestCount;
	}

	public void setSystemRequestCount(int systemRequestCount) {
		this.systemRequestCount = systemRequestCount;
	}
	
}

enum LicenseTypes {
	
	LOW(10),
	MEDIUM(20),
	HIGH(50);
	
	int planLimit;
	
	LicenseTypes(int planLimit ){
		this.planLimit = planLimit;
	}
	
	public int getPlanLimit() {
		return planLimit;
	}

	public void setPlanLimit(int planLimit) {
		this.planLimit = planLimit;
	}
	
}

class Constants {

	static final int systemUppperLimit = 1000;
}
