package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class GUI implements ActionListener{

	private static JPanel panel;
	private static JFrame frame;
	private static JLabel userLabel;
	private static JTextField userText;
	private static JLabel passwordLabel;
	private static JPasswordField passwordText;
	private static JButton button;
	private static JLabel success;
	

	private static void createGUI() {
		panel = new JPanel();
		frame = new JFrame();
		
		frame.setSize(350,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(panel);
		
		panel.setLayout(null);
		
		userLabel = new JLabel("Username");
		userLabel.setBounds(10,20,80,25); //x,y,width,height
		panel.add(userLabel);
		
		userText = new JTextField(20);
		userText.setBounds(100,20,165,25);
		panel.add(userText);
		
		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10,50,80,25);
		panel.add(passwordLabel);
		
		passwordText = new JPasswordField();
		passwordText.setBounds(100,50,165,25);
		panel.add(passwordText);
		
		button = new JButton("Login");
		button.setBounds(130,80,80,25);
		button.addActionListener(new GUI());
		panel.add(button);
		
		success = new JLabel("");
		success.setBounds(10,110,300,25);
		panel.add(success);
		
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String user = userText.getText();
		String password = new String(passwordText.getPassword());
		System.out.println(user + ", " + password);
		
		if(user.equals("huykaiser") && password.equals("123456")) {
			success.setText("Hello Kaiser!!!");
		}else {
			success.setText("Login failed! You are not Kaiser!!!");
		}
	}
	
	public static void main(String[] args) {
		createGUI();		
	}

}
