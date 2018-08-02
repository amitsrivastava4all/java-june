package com.brainmentors.testengine.question.views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import com.brainmentors.testengine.question.dao.QuestionDAO;
import com.brainmentors.testengine.question.dto.QuestionDTO;
import com.brainmentors.testengine.util.constants.CommonConstants;

public class TakeTestView extends JFrame {

	private JPanel contentPane;
	private ArrayList<QuestionDTO> questions;
	private int index ;
	ButtonGroup bg = new ButtonGroup();
	
	private int time = 20;
	private Timer timer;
	private void showTimeLeft(){
		timer = new Timer(CommonConstants.DELAY, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				timelbl.setText(String.valueOf(time));
				
				if(time==0){
					
					timer.stop();
					finishTest();
				}
				time--;
			}		
		});
		timer.start();
	}
	
	private void selectAns(){
		if(this.questions.get(index).getYourAns()!=null){
			yourAnswer = this.questions.get(index).getYourAns();
			if(yourAnswer.equals("a")){
				ans1.setSelected(true);
			}
			else
			if(yourAnswer.equals("b")){
				ans2.setSelected(true);
			}
			else
			if(yourAnswer.equals("c")){
				ans3.setSelected(true);
			}
			else
			if(yourAnswer.equals("d")){
				ans4.setSelected(true);
			}
		}
		else{
			bg.clearSelection();
		}
	}
	
	private void printQuestion(){
	
		if(index<questions.size()){
			selectAns();
			
			
		QuestionDTO currentQuestion = questions.get(index);
//		if(currentQuestion.getYourAns()==null){
//			bg.clearSelection();
//			
//		}
		qno.setText(String.valueOf(currentQuestion.getId()));
		question.setText(currentQuestion.getName());
		ans1.setText(currentQuestion.getAns1());
		ans2.setText(currentQuestion.getAns2());
		ans3.setText(currentQuestion.getAns3());
		ans4.setText(currentQuestion.getAns4());
		enableDisableButtons();
		
		}
		
	}
	
	private void loadQuestions(){
		QuestionDAO questionDAO = new QuestionDAO();
		try {
			questions = questionDAO.getQuestions();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "Can't Load Questions");
			e.printStackTrace();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, "Can't Load Questions");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TakeTestView frame = new TakeTestView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	private void enableDisableButtons(){
		if(questions.size()==1){
			prevButton.setEnabled(false);
			nextButton.setEnabled(false);
		}
		else
		if(index==0){
		prevButton.setEnabled(false);
		nextButton.setEnabled(true);
		}
		else
			if(index == questions.size()-1){
				nextButton.setEnabled(false);
				prevButton.setEnabled(true);
				
			}
		else
		if(index>0 && index<questions.size()){
			prevButton.setEnabled(true);
			nextButton.setEnabled(true);
		}
		
		
	}
	
	JLabel question = new JLabel("");
	JLabel qno = new JLabel("");
	JRadioButton ans1 = new JRadioButton("");
	JRadioButton ans2 = new JRadioButton("");
	JRadioButton ans3 = new JRadioButton("");
	JRadioButton ans4 = new JRadioButton("");
	JButton prevButton = new JButton("Prev");
	JButton nextButton = new JButton("Next");
	private final JLabel lblTimeLeft = new JLabel("Time Left");
	private final JLabel timelbl = new JLabel("0");
	private String yourAnswer = "";
	private final JButton btnFinishTest = new JButton("Finish Test");
	
	
	
	private void fetchAns(int index ){
		
		
//		if(this.questions.get(index).getYourAns()!=null){
//			yourAnswer = this.questions.get(index).getYourAns();
//			if(yourAnswer.equals("a")){
//				ans1.setSelected(true);
//			}
//			else
//			if(yourAnswer.equals("b")){
//				ans2.setSelected(true);
//			}
//			else
//			if(yourAnswer.equals("c")){
//				ans3.setSelected(true);
//			}
//			else
//			if(yourAnswer.equals("d")){
//				ans4.setSelected(true);
//			}
//		}
		
		if(ans1.isSelected()){
			yourAnswer = "a";
		}
		else
			if(ans2.isSelected()){
				yourAnswer = "b";
			}
			else
		if(ans3.isSelected()){
			yourAnswer = "c";
		}
		else
		if(ans4.isSelected()){
			yourAnswer = "d";
		}
		this.questions.get(index).setYourAns(yourAnswer);
		System.out.println("Question is "+this.questions.get(index));
		yourAnswer="";
	}
	
	private  void finishTest(){
		fetchAns(index);
		
		ResultView rv = new ResultView(questions,checkTest());
		rv.setVisible(true);
		this.setVisible(false);
		this.dispose();
	}
	
	private int checkTest(){
		int score = 0;
		for(QuestionDTO questionDTO : questions){
			if(!questionDTO.getRans().equals(questionDTO.getYourAns())){
				questionDTO.setScore(0);
			}
			score += questionDTO.getScore();
		}
		return score;
	}
	
	
	public TakeTestView() {
		bg.add(ans1);
		bg.add(ans2);
		bg.add(ans3);
		bg.add(ans4);
		loadQuestions();
		printQuestion();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 559, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		question.setBounds(47, 20, 397, 62);
		contentPane.add(question);
		
		
		qno.setBounds(6, 20, 34, 47);
		contentPane.add(qno);
		
		
		ans1.setBounds(18, 123, 273, 23);
		contentPane.add(ans1);
		
		
		ans2.setBounds(18, 158, 273, 23);
		contentPane.add(ans2);
		
		
		ans3.setBounds(18, 193, 273, 23);
		contentPane.add(ans3);
		
		
		ans4.setBounds(18, 228, 273, 23);
		contentPane.add(ans4);
		prevButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				fetchAns(index);
				index = index + -1;
				printQuestion();
			
			}
		});
		
		
		prevButton.setBounds(6, 285, 117, 29);
		contentPane.add(prevButton);
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(index==0){
				fetchAns(0);
				index = index + 1;
				}
				else{
				index = index + 1;
				fetchAns(index);
				}
				printQuestion();
			}
		});
		
		
		nextButton.setBounds(144, 285, 117, 29);
		contentPane.add(nextButton);
		lblTimeLeft.setBounds(479, 20, 61, 16);
		
		contentPane.add(lblTimeLeft);
		timelbl.setHorizontalAlignment(SwingConstants.RIGHT);
		timelbl.setBounds(479, 48, 61, 16);
		
		contentPane.add(timelbl);
		btnFinishTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			finishTest();
			}
		});
		btnFinishTest.setBounds(267, 285, 117, 29);
		
		contentPane.add(btnFinishTest);
		showTimeLeft();
	}
}
