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
	
	private int time = 60;
	private Timer timer;
	private void showTimeLeft(){
		timer = new Timer(CommonConstants.DELAY, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				timelbl.setText(String.valueOf(time));
				time--;
				
			}
		});
		timer.start();
	}
	
	private void printQuestion(){
		
		if(index<questions.size()){
		QuestionDTO currentQuestion = questions.get(index);
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
				index = index + -1;
				printQuestion();
			
			}
		});
		
		
		prevButton.setBounds(6, 285, 117, 29);
		contentPane.add(prevButton);
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index = index + 1;
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
		showTimeLeft();
	}
}
