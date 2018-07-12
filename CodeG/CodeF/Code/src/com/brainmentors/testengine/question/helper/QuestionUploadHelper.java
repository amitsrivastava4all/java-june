package com.brainmentors.testengine.question.helper;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.brainmentors.testengine.util.CommonUtils;
import com.brainmentors.testengine.util.constants.PathConstants;

public class QuestionUploadHelper {
	
	public void write() throws IOException {
		String path = "/Users/amit/Documents/CoreJavaJuneBatch/TestEngine/src/amit.txt";
		FileOutputStream fs = new FileOutputStream(path);
		String data = "Hello How are You";
		fs.write(data.getBytes());
		fs.close();
		System.out.println("Write Done...");
		
	}
	
	public static void main(String[] args) throws IOException {
		QuestionUploadHelper helper =new QuestionUploadHelper();
		helper.write();
	}
	
	public boolean read(String path) throws IOException {
		//String path = "/Users/amit/Documents/CoreJavaJuneBatch/TestEngine/src/com/brainmentors/testengine/question/helper/QuestionUploadHelper.java";
		//String path = "/Users/amit/Documents/songs/A.mp3";
		boolean isUploaded = false;
		File file = new File(path);
		String fileName  = CommonUtils.getFileName(path);
		FileOutputStream fo 
		= new FileOutputStream(PathConstants.UPLOAD_PATH+fileName);
		BufferedOutputStream bo = new BufferedOutputStream(fo);
		final int EOF = -1;
		
		if(file.exists()) {
			System.out.println("Exist...");
		FileInputStream fs = new FileInputStream(path);
		BufferedInputStream bs = new BufferedInputStream(fs);
		long startTime = System.currentTimeMillis();
		int singleByte = bs.read(); // read single byte
		while(singleByte!=EOF) {
			bo.write(singleByte);
			//System.out.print((char)singleByte);
			 singleByte = bs.read();
		}
		isUploaded = true;
		long endTime = System.currentTimeMillis();
		//System.out.println("Total Time Taken "+(endTime-startTime)+"ms");
		bo.close();
		fo.close();
		bs.close();
		fs.close();
		}
		else {
			System.out.println("File Not Exist");
		}
		return isUploaded;
		
	}
	
	

}
