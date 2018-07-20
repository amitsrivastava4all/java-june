package com.brainmentors.testengine.user.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.brainmentors.testengine.user.dto.RightDTO;
import com.brainmentors.testengine.user.dto.UserDTO;

public class DashBoardView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashBoardView frame = new DashBoardView();
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
	
	public void fillDashBoard(UserDTO userDTO){
		if(userDTO!=null){
		userIDlbl.setText("Welcome "+userDTO.getUserid()+" "+userDTO.getRoleName());
		if(userDTO.getRights()!=null){
			for(RightDTO right : userDTO.getRights()){
				JMenuItem menuItem = new JMenuItem(right.getName());
				menuItem.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						System.out.println("Screen Name "+right.getScreenName());
						try{
							int lastIndex = right.getScreenName().lastIndexOf(".java");
							System.out.println("Last Index "+lastIndex);
						String className = right.getScreenName().substring(0,lastIndex);
						System.out.println("ClassNAme "+className);
						Object object = Class.forName(className).newInstance();
						Method method = object.getClass().getMethod("setVisible", boolean.class);
						
						method.invoke(object, true);
						}
						catch(Exception e1){
							System.out.println("Reflection Problem "+e1);
							e1.printStackTrace();
						}
						}
				});
				file.add(menuItem);
				
			}
		}
		}
		
		
		}
	JMenu file = new JMenu("File");
	JLabel userIDlbl = new JLabel("");
	public DashBoardView() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
//		JMenuItem newItem = new JMenuItem("New");
//		file.add(newItem);
//		file.addSeparator();
//		JMenuItem openItem = new JMenuItem("Open");
//		file.add(openItem);
		menuBar.add(file);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		userIDlbl.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		userIDlbl.setBounds(17, 56, 334, 51);
		contentPane.add(userIDlbl);
	}
}
