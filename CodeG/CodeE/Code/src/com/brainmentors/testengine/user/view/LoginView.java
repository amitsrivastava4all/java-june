package com.brainmentors.testengine.user.view;

import static com.brainmentors.testengine.util.CommonUtils.convertPrintStackIntoString;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;

import com.brainmentors.testengine.user.dao.UserDAO;
import com.brainmentors.testengine.util.CommonDAO;
import com.brainmentors.testengine.util.CommonUtils;
import com.brainmentors.testengine.util.constants.PathConstants;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class LoginView extends JFrame implements PathConstants {
	Logger logger = Logger.getLogger(LoginView.class);
	private JPanel contentPane;
	private JTextField usertxt;
	private JPasswordField passwordtxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
					frame.logger.debug("Inside Main And Loading LoginView Frame...");
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
	private void checkLogin(){
		String userid = usertxt.getText();
		String password = new String(passwordtxt.getPassword());
		logger.debug("Inside Check Login with "+userid);
		UserDAO loginDAO = new UserDAO();
		try{
			// throw new SQLException()
			logger.debug("Inside Check Login ANd Calling LoginDAO "+userid);
		String message = loginDAO.doLogin(userid, password);
		logger.debug("Inside Check Login and After LoginDAO Message is  "+message);
		JOptionPane.showMessageDialog(this, message);
		}
		catch(ClassNotFoundException e){
			//String message = CommonUtils.convertPrintStackIntoString(e);
			//logger.error("Inside Catch "+message);
			logger.error(convertPrintStackIntoString(e));
			JOptionPane.showMessageDialog(this, "Contact to System Admin Some DB Problem Occur...");
			//e.printStackTrace();
		}
		catch(SQLException e){
		
			//logger.error("Inside Catch "+e);
			JOptionPane.showMessageDialog(this, "Might be DB Credential Change Contact to DB Admin");
			logger.error(convertPrintStackIntoString(e));
		}
		catch(Exception e){
			//logger.error("Inside Catch "+e);
			JOptionPane.showMessageDialog(this, "Some Serious Problem Occur Contact to Admin Team");
			//e.printStackTrace();
			logger.error(convertPrintStackIntoString(e));
		}
	}
	
	public LoginView() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 349, 262);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblLogin.setBounds(131, 32, 159, 34);
		contentPane.add(lblLogin);
		
		JLabel lblUserid = new JLabel("Userid");
		lblUserid.setBounds(36, 96, 61, 16);
		contentPane.add(lblUserid);
		
		usertxt = new JTextField();
		usertxt.setBounds(114, 91, 220, 26);
		contentPane.add(usertxt);
		usertxt.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(36, 151, 61, 16);
		contentPane.add(lblPassword);
		
		passwordtxt = new JPasswordField();
		passwordtxt.setBounds(114, 146, 220, 26);
		contentPane.add(passwordtxt);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			checkLogin();
			}
		});
		btnLogin.setIcon(new ImageIcon(LoginView.class.getResource(LOGIN_ICON)));
		btnLogin.setBounds(48, 191, 117, 43);
		contentPane.add(btnLogin);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(173, 191, 117, 43);
		contentPane.add(btnReset);
	}
}
