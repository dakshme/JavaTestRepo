package com.bmc.practice.datastructures;

import java.util.HashSet;

public class LinkList {
	
	Node root=null;
	Node tail=null;
	int nodeCount = 0;
	
	public LinkList() {
		
	}
	
	//node of list - an inner class
	class Node {
		int data;
		Node next;
		
		Node (int data) {
			this.data = data;
		}
	}


	public void addNode(int data) { 
		
	if (root ==null) {
		root = new Node(data);
		root.next=null;
		tail = root;
	}
	else {
		Node temp = new Node(data);
		temp.next=null;		
		tail.next =temp; //insert node at the end of list
		tail = temp; //update tail
	}
	
	this.nodeCount++; //increment node count
		
	}
	
	public boolean insertAfterNode(int data, int newData) {
		Node temp = root;
		boolean status = false;
		
		while (temp != null) {
			
			if (temp.data == data) {
				//add node here
				Node newNode = new Node(newData);
				
				//check if node is tail node
				if(temp == tail) {
					newNode.next = null;
					tail.next = newNode;
					tail = newNode;
				}else {				
					newNode.next=temp.next; //make the post link
					temp.next = newNode; // make prelink
				}
				status=true;
				break; //immediately stop checking once match found
			}
			temp = temp.next;
		}
		
		return status;	
	}
	
	public boolean insertBeforeNode(int data, int newData) {
		
		boolean status = false;
		Node currTemp = root;
		Node prevTemp = root;
		
		while (currTemp != null) {
			
			if (currTemp.data == data) {
				//add node here
				Node newNode = new Node(newData);
				
				//check of node is root node
				if (currTemp == root) {
					newNode.next = root;
					root = newNode;				
				}
				else {
				newNode.next=currTemp; //make the post link				
				prevTemp.next = newNode; // make prelink with prev temp node
				}
				status=true;
				break; //immediately stop checking once match found
			}
			prevTemp=currTemp;
			currTemp = currTemp.next;
		}	
		
		return status;
	}
	
	public void reverseLinkList() {
		
	  Node prev = null; 
	  Node current = root; 
	  Node next = null; 
	  
	  while (current != null) { 
		  
	        next = current.next; 
	        current.next = prev; //revering the link
	        prev = current; 
	        current = next; 
	  }
	  tail=root;  //now root is last node
	  root = prev;
	  
	}
	
	// Method to remove duplicate/repeated nodes from LL using 2 loops,
	// comparing each node with remaining of the list
	public void removeDuplicateNodes() {
		
		Node outLoopNode = root;
		
		while (outLoopNode != null && outLoopNode.next != null) { //outer loop
			
			Node innerLoopNode = outLoopNode; //inner loop will start from outer loop node as start point
			
			while (innerLoopNode.next != null) {
				
				//compare current outer node with remaining of the list
				if (outLoopNode.data == innerLoopNode.next.data) {
					Node delNode = innerLoopNode.next; //delete this node
					innerLoopNode.next = delNode.next; //move to next link
					delNode=null;
					System.gc();
				}
				else {
					
					innerLoopNode = innerLoopNode.next;		//move to in link			
				}
			}
			outLoopNode = outLoopNode.next; //move to next link 
		}
	}
	
	// Method to remove duplicate/repeated nodes from LL using Hash set and single traverse
	public void removeDuplicateNodesUsingHash() {
		
		Node currentNode = root;
		Node prevNode = null; //to store 1 prev node
		// Hash to store seen values 
		HashSet<Integer> hashSet = new HashSet<>(); 
		
		while (currentNode != null ) {
			
			if (hashSet.contains(currentNode.data)) {
				
				//this data has already present somewhere in the list so remove current duplicate node
				prevNode.next = currentNode.next;
				
			} else {
				
				hashSet.add(currentNode.data);
				prevNode = currentNode;
			}
			
			//continue with loop
			currentNode = currentNode.next;
		}
        
	}
	
	public void bubbleSortNodes() {
		
		Node outLoopNode = root;
		
		while (outLoopNode != null && outLoopNode.next != null) { //outer loop
			
			Node innerLoopNode = outLoopNode; //inner loop will start from outer loop node as start point
			
			while (innerLoopNode.next != null) {
				
				//compare current outer node with remaining of the list
				if (outLoopNode.data > innerLoopNode.next.data) {
					
					//rather swapping nodes, swap data only					
					int tempData = innerLoopNode.next.data;
					innerLoopNode.next.data = outLoopNode.data; 
					outLoopNode.data = tempData;
					
				}
				else {
					
					innerLoopNode = innerLoopNode.next;		//move to in link			
				}
			}
			outLoopNode = outLoopNode.next; //move to next link 
		}
	}
	
	public void bubbleSortNetweenNodes(Node startNode, Node endNode) {
		
		Node outLoopNode = startNode;
		
		while (outLoopNode != endNode) { //outer loop
			
			Node innerLoopNode = outLoopNode; //inner loop will start from outer loop node as start point
			
			while (innerLoopNode.next != endNode) {
				
				//compare current outer node with remaining of the list
				if (outLoopNode.data > innerLoopNode.next.data) {
					
					//rather swapping nodes, swap data					
					int tempData = innerLoopNode.next.data;
					innerLoopNode.next.data = outLoopNode.data; 
					outLoopNode.data = tempData;
					
				}
				else {
					
					innerLoopNode = innerLoopNode.next;		//move to in link			
				}
			}
			outLoopNode = outLoopNode.next; //move to next link 
		}
	}
	
	public Node getMiddleNodeOfList( ) {
		
		Node first = root;
		Node second = root;
		
		while (second != tail && second != null) //OR while (second !=null && second.next != null) 
		{			
			first = first.next; //move by one node
			second = (second.next.next != null)?second.next.next:null; //move by  2 nodes						
		}
		return first; //middle node
	}

	int countNodes(Node rootNode)  
    { 
        int count = 0; 
        Node temp = rootNode; 
        while (temp != null) 
        { 
            temp = temp.next; 
            count++; 
        } 
        return count; 
    }
	
	public Node merge2SortedList(Node list1, Node list2) {
		
		Node newHead = null;
		
		//check base condition to true
		if (null == list1 && null == list2)
			System.out.println("both list empty");
		else if (null == list1)
			return list2;
		else if (null == list2)
			return list1;
		
		//get the smallest head first from both the list
		if (list1.data <= list2.data) { 
			newHead = list1;
			list1 = list1.next;
		} else {
			newHead = list2;
			list2 = list2.next;			
		}
		
		//now rec join 2 list based on sorting order
		Node newList = newHead; //to tract link of new growing list
		
		while (list1.next!=null && list2.next!=null ) {
			
			if (list1.data <= list2.data) {
				newList.next = list1;
				newList = list1;
				list1 = list1.next;
			}
			else {
				newList.next = list2;
				newList = list2;
				list2 = list2.next;
			}			
		}
		
		//check of any of the 2 list nodes are still remaining then join with the new list
		if (list1.next != null ) {
			
			newList.next = list1;
			
		} else if (list2.next != null) {
			
			newList.next = list2;			
		}
		
		
		return newHead;
	}
		
	public void printList() {

		Node temp = root;
			
		while (temp != null) {
			System.out.print(temp.data+" --> ");
			temp = temp.next;
		}
		System.out.print("null"+"\n");
	}
		
	public static void main(String[] args) {
		
		LinkList list1 = new LinkList();
		
		list1.addNode(2);
		list1.addNode(5);
		list1.addNode(100);
		list1.addNode(30);
		list1.addNode(5);
		list1.addNode(50);
		list1.addNode(30);
		
		list1.printList();
		
		//insert after
		list1.insertAfterNode(30,50); //insert after tail
		list1.insertAfterNode(100,105); //insert in between
		list1.printList();
		
		//insert before
		list1.insertBeforeNode(2,99); 		//insert before root
		list1.insertBeforeNode(100,90); 		//insert in between
		list1.printList();
		
		//reverse
		System.out.println("Reverse of LL");
		list1.reverseLinkList();
		list1.printList();
		
		//get middle node and sort list among 2 halves
		Node middleNode = list1.getMiddleNodeOfList( );		
		System.out.println("Middle node data "+middleNode.data);
		list1.bubbleSortNetweenNodes(list1.root, middleNode); //sort first half
		list1.bubbleSortNetweenNodes(middleNode.next, list1.tail); //sort second half
		System.out.println("Bubble Sorting of 2 halves of list");
		list1.printList();
		
		//bubble sort list
		list1.bubbleSortNodes();
		System.out.println("Bubble Sorting of the list");
		list1.printList();
		
		//remove duplicate		
		list1.removeDuplicateNodes();
		System.out.println("Remove duplicates from list");
		list1.printList();
		
		list1.addNode(2);
		list1.addNode(5);
		list1.addNode(2);
		list1.addNode(5);
		list1.addNode(77);
		//remove duplicate
		list1.removeDuplicateNodesUsingHash();
		System.out.println("Remove duplicates from list using Hash set");
		list1.printList();
		
		//merger 2 srted list
		LinkList sortList1 = new LinkList();
		LinkList sortList2 = new LinkList();
		sortList1.addNode(3);
		sortList1.addNode(5);
		sortList1.addNode(7);
		sortList1.addNode(9);
		
		sortList2.addNode(1);
		sortList2.addNode(4);
		sortList2.addNode(6);
		sortList2.addNode(7);
		sortList2.addNode(11);
		sortList2.addNode(15);
		Node sortList3 = sortList1.merge2SortedList(sortList1.root, sortList2.root);
		//print
		while (sortList3 != null) {
			System.out.print(sortList3.data+" --> ");
			sortList3 = sortList3.next;
		}
		System.out.print("null"+"\n");

	}
}
