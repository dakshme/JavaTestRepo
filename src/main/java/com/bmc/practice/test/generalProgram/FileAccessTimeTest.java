package com.bmc.practice.test.generalProgram;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.nio.file.attribute.BasicFileAttributes;


public class FileAccessTimeTest {

	static private long getMiliSecToGivenPastDays(){
	       Calendar fromMidnight = Calendar.getInstance();
	       int daysToSetFilePastAccess = 20; //from todays date go back to 20 days
	       DateFormat df = new SimpleDateFormat("HH:mm:ss");
	       Date dateobj = new Date(); // from today date
	       String currentTime = df.format(dateobj);
	       String[] timeDetails = currentTime.split(":");	       
	       fromMidnight.set(Calendar.HOUR_OF_DAY, Integer.parseInt(timeDetails[0]));
	       fromMidnight.set(Calendar.MINUTE, Integer.parseInt(timeDetails[1]));
	       fromMidnight.set(Calendar.SECOND, Integer.parseInt(timeDetails[2]));
	       fromMidnight.set(Calendar.MILLISECOND, 0);
	       fromMidnight.add(Calendar.DAY_OF_MONTH, -(daysToSetFilePastAccess)); 
	       long timeLeftInMiliSec = fromMidnight.getTimeInMillis();
	       return timeLeftInMiliSec;
	 }
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String fileAbsolutePath = args[0];//"C:\\temp\\test\\abc.txt";
		
		System.out.println("file is "+fileAbsolutePath);
		
		File file = new File(fileAbsolutePath);
		if (file.exists())
		{
			Path path = Paths.get(fileAbsolutePath);
			
			BasicFileAttributes fileAttrs = Files.readAttributes(path, BasicFileAttributes.class);
			FileTime lastAccessTime = fileAttrs.lastAccessTime();
			System.out.println("File time "+lastAccessTime.toString());
			
			//set to some arbitrary old time
			FileTime fileTime = FileTime.fromMillis(getMiliSecToGivenPastDays());
			System.out.println("File new time to set "+fileTime.toString());
	        Files.setAttribute(path, "basic:lastAccessTime", fileTime);     
	        
			BasicFileAttributes fileAttrs1 = Files.readAttributes(path, BasicFileAttributes.class);
			FileTime lastAccessTime1 = fileAttrs1.lastAccessTime();
			System.out.println("File new time is "+lastAccessTime1.toString());
	

		}

	}

}
