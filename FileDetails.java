package com.test;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

public class FileDetails {

	public static void ComplexExample() throws IOException, ParseException	{
		FileInfo file = new FileInfo(new File("C:\\Users\\stadigital\\Downloads\\log.21-05-2020.log.txt"));
		System.out.println("Name: " + file.getName());
		System.out.println("Absolute path: " + file.getAbsolutePath());
		System.out.println("Size: " + file.getSize());
		System.out.println("Last modified: " + file.getLastModified());
		System.out.println("Owner: " + file.getOwner());
		System.out.println("Created: " + file.getCreated());
		System.out.println("Accessed: " + file.getAccessed());
		System.out.println("Written: " + file.getWritten());
	}
		
		
	public static void main(String[] args) throws Exception, ParseException {
		ComplexExample();
	}
	
}
