package com.brainmentors.testengine.util;

import java.io.PrintWriter;
import java.io.StringWriter;

public interface CommonUtils {
	
	public static String getFileName(String path ) {
		int index = path.lastIndexOf("/");
		System.out.println(index);
		return path.substring(index);
	}
	
	public static String convertPrintStackIntoString(Exception e){
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		String message =  sw.toString();
		return message;
	}
	
	

}
