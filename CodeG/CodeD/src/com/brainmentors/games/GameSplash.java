package com.brainmentors.games;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import jaco.mp3.player.MP3Player;

public class GameSplash extends JWindow {
	MP3Player player ;
	Timer timer;
	JProgressBar progressBar = new JProgressBar();
	int counter =1;
	private void animation(){
		timer = new Timer(50,(e)->{
			if(counter>100){
				timer.stop();
				stopSong();
				GameSplash.this.setVisible(false);
				GameSplash.this.dispose();
				TicTacToe obj = new TicTacToe();
				obj.setVisible(true);
			}
			progressBar.setValue(counter);
			counter++;
		});
		timer.start();
	}
	private void playSong(){
		 player = new MP3Player(GameSplash.class.getResource("pop.mp3"));
		player.play();
	}
	private void stopSong(){
		if(player!=null){
		player.stop();
		}
	}

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
					frame.playSong();
					frame.animation();
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
		
		JLabel lblTicTacToe = new JLabel("Tic Tac Toe Game");
		lblTicTacToe.setFont(new Font("Arial", Font.BOLD, 30));
		lblTicTacToe.setForeground(Color.RED);
		lblTicTacToe.setHorizontalAlignment(SwingConstants.CENTER);
		//lblTicTacToe.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblTicTacToe.setBounds(108, 121, 342, 57);
		contentPane.add(lblTicTacToe);
		
		JButton btnStartGame = new JButton("Start Game");
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadNext();
			}
		});
		btnStartGame.setBounds(367, 6, 117, 29);
		contentPane.add(btnStartGame);
		
		JButton btnExitGame = new JButton("Exit Game");
		btnExitGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			System.exit(0);
			}
		});
		btnExitGame.setBounds(367, 57, 117, 29);
		contentPane.add(btnExitGame);
		
		
		progressBar.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		progressBar.setStringPainted(true);
		progressBar.setBounds(6, 331, 430, 20);
		contentPane.add(progressBar);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(GameSplash.class.getResource("/com/brainmentors/games/tictactoe.gif")));
		lblNewLabel.setBounds(6, 6, 473, 296);
		contentPane.add(lblNewLabel);
	}
}
