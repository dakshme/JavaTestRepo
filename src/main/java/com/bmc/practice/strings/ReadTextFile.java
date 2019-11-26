package com.bmc.practice.strings;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ReadTextFile {
	
	// Java 8 - Read file line by line - Files.lines(Path path, Charset cs)
	public void readLineByLineJava8(String filePath) {
		StringBuilder fileLines = new StringBuilder();

		// try-with-resource example.so no need to free this.
		try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
			stream.forEach(s -> fileLines.append(s).append("\n"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Using Files.lines \n"+fileLines.toString());
	}

	// Files.readAllBytes(Path path) - Java 7 and above
	public void readAllBytesJava7(String filePath)
    {
        String content = "";
 
        try
        {
            content = new String ( Files.readAllBytes( Paths.get(filePath) ) );
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
 
        System.out.println("Using readAllBytes \n"+ content);
    }

	// Using BufferedReader and FileReader - Below Java 7
	//Read file content into string with - using BufferedReader and FileReader
    //You can use this if you are still not using Java 8
	public void usingBufferedReader(String filePath)
    {
        StringBuilder contentBuilder = new StringBuilder();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
        {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null)
            {
                contentBuilder.append(sCurrentLine).append("\n");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        System.out.println("Read file Using BufferedReader \n"+contentBuilder.toString());
    }

}
