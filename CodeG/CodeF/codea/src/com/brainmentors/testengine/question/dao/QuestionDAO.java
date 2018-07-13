package com.brainmentors.testengine.question.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.brainmentors.testengine.question.dto.QuestionDTO;
import com.brainmentors.testengine.util.CommonDAO;
import com.brainmentors.testengine.util.constants.QueryConstants;

public class QuestionDAO {
	
	public void bulkUpload(ArrayList<QuestionDTO> questionList) throws SQLException, ClassNotFoundException{
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		try{
			connection = CommonDAO.getConnection();
			pstmt = connection.prepareStatement(QueryConstants.QUESTION_UPLOAD_SQL);
			for(QuestionDTO question : questionList){
				pstmt.setInt(1, question.getId());
			
				pstmt.setString(2, question.getName());
				pstmt.setString(3, question.getAns1());
				pstmt.setString(4, question.getAns2());
				pstmt.setString(5, question.getAns3());
				pstmt.setString(6, question.getAns4());
				pstmt.setString(7, question.getRans());
				pstmt.setInt(8, question.getScore());
				pstmt.addBatch();
				
			}
			int records [] = pstmt.executeBatch();
			System.out.println("Record Uploaded........");
		}
		finally{
			if(pstmt!=null){
				pstmt.close();
			}
			if(connection!=null){
				connection.close();
			}
		}
	}

}
