package com.brainmentors.testengine.question.helper;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.brainmentors.testengine.question.dao.QuestionDAO;
import com.brainmentors.testengine.question.dto.QuestionDTO;
import com.brainmentors.testengine.util.CommonUtils;
import com.brainmentors.testengine.util.constants.PathConstants;

public class QuestionUploadHelper {
	
	
	public void writeToDB(String path) throws IOException{
		ArrayList<QuestionDTO> questionList = new ArrayList<>();
		boolean isFirstRowPass = false;
		int cellCounter = 0;
		FileInputStream fs = new FileInputStream(path);
		HSSFWorkbook workBook = new HSSFWorkbook(fs);
		HSSFSheet sheet = workBook.getSheetAt(0);
		
		Iterator<Row> rows = sheet.rowIterator();
		while(rows.hasNext()){
			Row currentRow = rows.next();
			if(!isFirstRowPass){
				isFirstRowPass = true;
				continue;
			}
			cellCounter=0;
			QuestionDTO questionDTO = new QuestionDTO();
			Iterator<Cell> cells = currentRow.cellIterator();
			while(cells.hasNext()){
				Cell currentCell = cells.next();
				cellCounter++;
				if(cellCounter==1){
					questionDTO.setId((int)currentCell.getNumericCellValue());
				}
				else
				if(cellCounter==2){
					questionDTO.setName(currentCell.getStringCellValue());
				}
				else
					if(cellCounter==3){
						questionDTO.setAns1(currentCell.getStringCellValue());
					}
					else
						if(cellCounter==4){
							questionDTO.setAns2(currentCell.getStringCellValue());
						}
						else
							if(cellCounter==5){
								questionDTO.setAns3(currentCell.getStringCellValue());
							}
							else
								if(cellCounter==6){
									questionDTO.setAns4(currentCell.getStringCellValue());
								}
								else
									if(cellCounter==7){
										questionDTO.setRans(currentCell.getStringCellValue());
									}
									else
										if(cellCounter==8){
											questionDTO.setScore((int)currentCell.getNumericCellValue());
										}
				
				
			} // Cell Loop Ends
			questionList.add(questionDTO);
		} // Row Loop Ends
		QuestionDAO questionDAO = new QuestionDAO();
		System.out.println("Questions are :: "+questionList);
		try {
			questionDAO.bulkUpload(questionList);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
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
		String fullName = PathConstants.UPLOAD_PATH+fileName;
		FileOutputStream fo 
		= new FileOutputStream(fullName);
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
		writeToDB(fullName);
		}
		else {
			System.out.println("File Not Exist");
		}
		return isUploaded;
		
	}
	
	

}
