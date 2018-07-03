package com.brainmentors.games;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GameSplash extends JWindow {

	private void loadNext(){
		this.setVisible(false);
		this.dispose();
		TicTacToe tic = new TicTacToe();
		tic.setVisible(true);
	}
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameSplash frame = new GameSplash();
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
	public GameSplash() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 518, 373);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(GameSplash.class.getResource("/com/brainmentors/games/tictactoe.gif")));
		lblNewLabel.setBounds(25, 6, 473, 296);
		contentPane.add(lblNewLabel);
		
		JLabel lblTicTacToe = new JLabel("Tic Tac Toe Game");
		lblTicTacToe.setForeground(Color.RED);
		lblTicTacToe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTicTacToe.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblTicTacToe.setBounds(114, 314, 243, 16);
		contentPane.add(lblTicTacToe);
		
		JButton btnStartGame = new JButton("Start Game");
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadNext();
			}
		});
		btnStartGame.setBounds(367, 301, 117, 29);
		contentPane.add(btnStartGame);
		
		JButton btnExitGame = new JButton("Exit Game");
		btnExitGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			System.exit(0);
			}
		});
		btnExitGame.setBounds(367, 342, 117, 29);
		contentPane.add(btnExitGame);
	}

}
