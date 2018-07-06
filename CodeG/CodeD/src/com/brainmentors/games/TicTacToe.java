package com.brainmentors.games;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/**
 * This is a TicTacToe Game Class
 * @author amit
 * @version 1.0
 * @since 1 June 2018
 */
public class TicTacToe extends JFrame {
	private void reset(){
		isXorZero = false;
		one.setText("");
		two.setText("");
		three.setText("");
		four.setText("");
		five.setText("");
		six.setText("");
		seven.setText("");
		eight.setText("");
		nine.setText("");
	}
	private boolean isGameOver(){
		return isRowSame(one,two,three) || isRowSame(one,four,seven) || isRowSame(one,five,nine);
	}
	private boolean isRowValueSame(JButton first, JButton second, JButton third){
		return first.getText().equals(second.getText()) && first.getText().equals(third.getText());
	}
	
	private boolean isRowSame(JButton first, JButton second, JButton third ){
		if(isRowNotBlank(first, second, third)){
			if(isRowValueSame(first, second, third)){
				return true;
			}
		}
		return false;
	}
	private boolean isRowNotBlank(JButton first, JButton second, JButton third){
		return isNotBlank(first) && isNotBlank(second) && isNotBlank(third); 
	}
	private boolean isNotBlank(JButton currentButton){
			return currentButton.getText().trim().length()>0;
	}
	private boolean isXorZero ; // default value of boolean is false
	private void printXorZero(JButton currentButton){
		if(currentButton.getText().trim().length()==0){
		currentButton.setText(isXorZero?"X":"0");
		if(isGameOver()){
			JOptionPane.showMessageDialog(this, "Game Over and Win By "+currentButton.getText());
			reset();
			return ;
		}
		isXorZero= !isXorZero;
		}
		else{
			JOptionPane.showMessageDialog(this, "Please Select Another Empty Box");
		}
		
	}
	

	private JPanel contentPane;

	/**
	 * Launch the application.
	 * this is main execution of tic tac toe game
	 * @param String args[]
	 * @return void
	 */
	public static void main(String[] args) {
		
					TicTacToe frame = new TicTacToe();
					frame.setVisible(true);
				
	}

	/**
	 * Create the frame.
	 */
	JButton one = new JButton("");
	JButton two = new JButton("");
	JButton three = new JButton("");
	JButton four = new JButton("");
	JButton five = new JButton("");
	JButton six = new JButton("");
	JButton seven = new JButton("");
	JButton eight = new JButton("");
	JButton nine = new JButton("");
	
	private void askBeforeClose(){
		int choice = JOptionPane.showConfirmDialog(this, "Do u want to leave this game","Game-2018",JOptionPane.YES_NO_OPTION);
		if(choice == JOptionPane.YES_OPTION){
			JOptionPane.showMessageDialog(this, "Thanks for Using...");
			System.exit(0);
		}
		
	}
	
	public TicTacToe() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				askBeforeClose();
			}
		});
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setSize(500,400);
		setLocationRelativeTo(null);
		//setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		one.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printXorZero(one);
			}
		});
		one.setToolTipText("Click to Play");
		one.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		one.setBounds(19, 57, 122, 49);
		contentPane.add(one);
		
		
		two.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printXorZero(two);
			}
		});
		two.setToolTipText("Click to Play");
		two.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		two.setBounds(158, 57, 122, 49);
		contentPane.add(two);
		
		
		three.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printXorZero(three);
			}
		});
		three.setToolTipText("Click to Play");
		three.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		three.setBounds(316, 57, 122, 49);
		contentPane.add(three);
		
		
		four.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printXorZero(four);
			}
		});
		four.setToolTipText("Click to Play");
		four.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		four.setBounds(19, 131, 122, 49);
		contentPane.add(four);
		
		
		five.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printXorZero(five);
			}
		});
		five.setToolTipText("Click to Play");
		five.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		five.setBounds(171, 131, 122, 49);
		contentPane.add(five);
		
		
		six.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printXorZero(six);
			}
		});
		six.setToolTipText("Click to Play");
		six.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		six.setBounds(316, 131, 122, 49);
		contentPane.add(six);
		
		
		seven.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printXorZero(seven);
			}
		});
		seven.setToolTipText("Click to Play");
		seven.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		seven.setBounds(19, 224, 122, 49);
		contentPane.add(seven);
		
		
		eight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printXorZero(eight);
			}
		});
		eight.setToolTipText("Click to Play");
		eight.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		eight.setBounds(171, 224, 122, 49);
		contentPane.add(eight);
		
		
		nine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printXorZero(nine);
			}
		});
		nine.setToolTipText("Click to Play");
		nine.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		nine.setBounds(316, 224, 122, 49);
		contentPane.add(nine);
		
		JLabel lblTictactoegame = new JLabel("TicTacToe-Game-2018");
		lblTictactoegame.setHorizontalAlignment(SwingConstants.CENTER);
		lblTictactoegame.setForeground(Color.RED);
		lblTictactoegame.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		lblTictactoegame.setBounds(82, 18, 304, 16);
		contentPane.add(lblTictactoegame);
	}
}
