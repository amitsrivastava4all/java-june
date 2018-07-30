package com.brainmentors.testengine.user.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.brainmentors.testengine.user.dto.UserDTO;
import com.brainmentors.testengine.util.OffLine;

public class RegisterView extends JFrame {

	private JPanel contentPane;
	private JTextField useridTxt;
	private JTextField nametxt;
	private JPasswordField passwordField;
	JComboBox citycombo = new JComboBox();
	
	private void checkOffLineData(){
		try {
			UserDTO userDTO = OffLine.readObject();
			if(userDTO!=null){
				useridTxt.setText(userDTO.getUserid());
				nametxt.setText(userDTO.getName());
				citycombo.setSelectedItem(userDTO.getCity());
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void doRegister(){
		UserDTO userDTO = null;
		try{
			userDTO = new UserDTO();
			userDTO.setUserid(useridTxt.getText());
			userDTO.setPassword(passwordField.getPassword().toString());
			userDTO.setName(nametxt.getText());
			userDTO.setCity(citycombo.getSelectedItem().toString());
			// Call DAO to Store in DB (Happy )
			throw new SQLException();
		}
		catch(SQLException e){
			// Bad 
			try {
				String result =OffLine.writeObject(userDTO)?"Record Store in OffLine Mode":"Cant Save Offline";
			JOptionPane.showMessageDialog(this, result);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterView frame = new RegisterView();
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
	public RegisterView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserid = new JLabel("Userid");
		lblUserid.setBounds(43, 26, 61, 16);
		contentPane.add(lblUserid);
		
		useridTxt = new JTextField();
		useridTxt.setBounds(137, 21, 130, 26);
		contentPane.add(useridTxt);
		useridTxt.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(43, 75, 61, 16);
		contentPane.add(lblPassword);
		
		nametxt = new JTextField();
		nametxt.setBounds(137, 123, 130, 26);
		contentPane.add(nametxt);
		nametxt.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(147, 70, 120, 26);
		contentPane.add(passwordField);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(43, 128, 61, 16);
		contentPane.add(lblName);
		
		citycombo.addItem("Delhi");
		citycombo.addItem("Mumbai");
		
		citycombo.setBounds(137, 176, 130, 27);
		contentPane.add(citycombo);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(43, 180, 61, 16);
		contentPane.add(lblCity);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			doRegister();
			}
		});
		btnRegister.setBounds(32, 226, 117, 29);
		contentPane.add(btnRegister);
		checkOffLineData();
	}
}
