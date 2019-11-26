package com.bmc.practice.javaNIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MappedByteBufferExample {

	private static String bigTextFile = "C:\\temp\\test\\MappedByteBuffer.txt";
	 
	public static void main(String[] args) {

        // Create file object
        File file = new File(bigTextFile);
         
        //Delete the file; we will create a new file
        file.delete();
                     
        //Write data to file
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw"))
        {
            // Get file channel in read-write mode
            FileChannel fileChannel = randomAccessFile.getChannel();
 
            // Get direct byte buffer access using channel.map() operation
            MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, 512 * 8 * 8);
 
            //Write the content using put methods
            buffer.put("howtodoinjava.com".getBytes());
            
        } catch (FileNotFoundException e) {  e.printStackTrace();  	}
          catch (IOException e) { 	e.printStackTrace(); 	}
        
      //Read data to file
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(new File(bigTextFile), "r"))
        {
            //Get file channel in read-only mode
            FileChannel fileChannel = randomAccessFile.getChannel();
             
            //Get direct byte buffer access using channel.map() operation
            MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());
             
            // the buffer now reads the file as if it were loaded in memory.
            System.out.println(buffer.isLoaded());  //prints false
            System.out.println(buffer.capacity());  //Get the size based on content size of file, 32768
             
            //You can read the file from this buffer the way you like.
            for (int i = 0; i < buffer.limit(); i++)
            {
                System.out.print((char) buffer.get()); //Print the content of file
            }
        } catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
