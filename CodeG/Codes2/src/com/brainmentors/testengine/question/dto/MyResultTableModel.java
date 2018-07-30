package com.brainmentors.testengine.question.dto;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class MyResultTableModel extends AbstractTableModel {
private String columns[] = {"qid","question","Right Answer","Your Answer","Score"};
private ArrayList<QuestionDTO> questionList;
	public MyResultTableModel(ArrayList<QuestionDTO> questionList){
		this.questionList = questionList;
	}
	
	@Override
	public String getColumnName(int column) {
		
			return columns[column];
		
	}
	
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return questionList.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columns.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		QuestionDTO questionDTO = questionList.get(rowIndex);
	switch(columnIndex){	
		case 0:
			return questionDTO.getId();
		case 1:
			return questionDTO.getName();
		case 2:
			return questionDTO.getRans();
		case 3:
			return questionDTO.getYourAns();
		case 4:	
			return questionDTO.getScore();
	}
		// TODO Auto-generated method stub
		return null;
	}

}
