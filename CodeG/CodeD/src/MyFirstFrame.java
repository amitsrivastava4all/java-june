
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MyFirstFrame extends JFrame{
	private JTextField txtName;
	private JButton button;
	
	
	void sayHello(){
		String name = txtName.getText();
		JOptionPane.showMessageDialog(this, "Hello "+name);
	}
	
	MyFirstFrame(){
		button = new JButton("Ok");
		button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				sayHello();
			}
		});
//		ActionListener l = new ActionListener(){
//			@Override
//			public void actionPerformed(ActionEvent e){
//				//logic
//			}
//		};
//		button.addActionListener(l);
		txtName = new JTextField(20);
		txtName.setBounds(20,100,170,50);
		button.setBounds(210, 100, 100, 50);
		Container cp = this.getContentPane();
		cp.setLayout(null);
		//cp.setLayout(new GridLayout(2, 2));
		//cp.setLayout(new FlowLayout());
		cp.add(txtName);
		cp.add(button);
		//cp.add(txtName,BorderLayout.NORTH);
		//cp.add(button, BorderLayout.SOUTH);
		setTitle("Frame-2018");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,300);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyFirstFrame obj = new MyFirstFrame();
		
		

	}

}
