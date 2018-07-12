package com.brainmentors.testengine.question.views;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

import com.brainmentors.testengine.question.helper.QuestionUploadHelper;
import com.brainmentors.testengine.util.CommonUtils;

public class QuestionUploadView extends JFrame{
	Logger logger = Logger.getLogger(QuestionUploadView.class);
	private void uploadIt() {
		JFileChooser jfileChooser = new JFileChooser("/Users/amit/Documents");
		jfileChooser.showOpenDialog(this);
		File file = jfileChooser.getSelectedFile();
		System.out.println("Path is "+file.getAbsolutePath());
		QuestionUploadHelper helper =new QuestionUploadHelper();
		try {
			boolean isUploaded = helper.read(file.getAbsolutePath());
			JOptionPane.showMessageDialog(this, isUploaded?"Uploaded Done":"Not Uploaded");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this,"Can't Upload the File , Contact System Admin") ;
			logger.error(CommonUtils.convertPrintStackIntoString(e));
			//e.printStackTrace();
		}
	}
	
	QuestionUploadView(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,300);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JButton upload = new JButton("Upload");
		upload.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				uploadIt();
				
			}
		});
		getContentPane().add(upload, BorderLayout.NORTH);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuestionUploadView obj = new QuestionUploadView();
		obj.setVisible(true);

	}

}
