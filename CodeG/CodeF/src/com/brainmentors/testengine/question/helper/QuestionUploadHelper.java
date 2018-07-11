package com.brainmentors.testengine.question.helper;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class QuestionUploadHelper {
	public static void main(String[] args) throws IOException {
		QuestionUploadHelper helper =new QuestionUploadHelper();
		helper.read();
	}
	
	public void read() throws IOException {
		//String path = "/Users/amit/Documents/CoreJavaJuneBatch/TestEngine/src/com/brainmentors/testengine/question/helper/QuestionUploadHelper.java";
		String path = "/Users/amit/Documents/songs/A.mp3";
		File file = new File(path);
		final int EOF = -1;
		
		if(file.exists()) {
			System.out.println("Exist...");
		FileInputStream fs = new FileInputStream(path);
		BufferedInputStream bs = new BufferedInputStream(fs);
		long startTime = System.currentTimeMillis();
		int singleByte = bs.read(); // read single byte
		while(singleByte!=EOF) {
			//System.out.print((char)singleByte);
			 singleByte = bs.read();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Total Time Taken "+(endTime-startTime)+"ms");
		bs.close();
		fs.close();
		}
		else {
			System.out.println("File Not Exist");
		}
		
	}
	
	public void write() {
		
	}

}
