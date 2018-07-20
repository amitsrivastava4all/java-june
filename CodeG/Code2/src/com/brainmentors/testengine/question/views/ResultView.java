package com.brainmentors.testengine.question.views;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import com.brainmentors.testengine.question.dto.MyResultTableModel;
import com.brainmentors.testengine.question.dto.QuestionDTO;

public class ResultView extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel lblscore;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public ResultView(ArrayList<QuestionDTO> questions, int finalScore) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblResults = new JLabel("Results");
		lblResults.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblResults.setBounds(34, 6, 199, 35);
		contentPane.add(lblResults);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 53, 501, 305);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new MyResultTableModel(questions));
		scrollPane.setViewportView(table);
		
		lblscore = new JLabel("Score is "+finalScore);
		lblscore.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblscore.setBounds(78, 382, 175, 35);
		contentPane.add(lblscore);
	}
}
