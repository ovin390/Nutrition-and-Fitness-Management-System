import java.awt.BorderLayout;

import java.awt.EventQueue;
import javax.swing.*;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Window;
import java.awt.Color;	
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class login extends JFrame {
	
	private JPanel contentPane;
	private JTextField txtSad;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setUndecorated(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 50, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(UIManager.getColor("Button.background"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=JOptionPane.showConfirmDialog(null,"Do you really want to exit application","Select",JOptionPane.YES_NO_OPTION);
				if(a==0)
				{
					System.exit(0);
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon(login.class.getResource("/image/close.png")));
		btnNewButton.setBounds(1313, 0, 53, 53);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Sitka Small", Font.BOLD, 47));
		lblNewLabel.setBounds(1026, 155, 193, 53);
		contentPane.add(lblNewLabel);
		
		final JLabel lblNewLabel_1 = new JLabel("Incorrect username or Password");
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setIcon(new ImageIcon(login.class.getResource("/image/close.png")));
		lblNewLabel_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(971, 218, 281, 13);
		contentPane.add(lblNewLabel_1);
		
		txtSad = new JTextField();
		txtSad.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				lblNewLabel_1.setVisible(false);
				if(txtSad.getText().equals("")) {
					txtSad.setText("");
					txtSad.setForeground(new Color(0,118,221));
				}
				
			}
			public void focusLost(FocusEvent e) {
				lblNewLabel_1.setVisible(false);
				if(txtSad.getText().equals("")) {
					txtSad.setText("");
					txtSad.setForeground(new Color(0,118,221));		
				}
			}
		});
		txtSad.setForeground(UIManager.getColor("List.selectionBackground"));
		txtSad.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtSad.setBounds(1085, 266, 254, 29);
		contentPane.add(txtSad);
		txtSad.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				lblNewLabel_1.setVisible(false);
				if(passwordField.getText().equals("")) {
					passwordField.setText("");
					passwordField.setForeground(new Color(0,118,221));
				}
			}
			public void focusLost(FocusEvent e) {
				lblNewLabel_1.setVisible(false);
				if(passwordField.getText().equals("")) {
					passwordField.setText("");
					passwordField.setForeground(new Color(0,118,221));
				}
			}
		});
		passwordField.setToolTipText("");
		passwordField.setBounds(1085, 323, 254, 29);
		contentPane.add(passwordField);
		
		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtSad.getText().equals("admin")&& passwordField.getText().equals("admin"))
				{
					setVisible(false);
					new home().setVisible(true);
				}
				else {
					lblNewLabel_1.setVisible(true);
				}
			}
		});
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setIcon(new ImageIcon(login.class.getResource("/image/login.png")));
		btnNewButton_1.setBounds(954, 425, 115, 42);
		contentPane.add(btnNewButton_1);
		
		final JCheckBox chckbxNewCheckBox = new JCheckBox("Show Password");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox.isSelected())
				{
					passwordField.setEchoChar((char)0);
				}
				else {
					passwordField.setEchoChar('*');
				}
			}
		});
		chckbxNewCheckBox.setForeground(new Color(0, 0, 0));
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.BOLD, 14));
		chckbxNewCheckBox.setBounds(1130, 426, 162, 40);
		contentPane.add(chckbxNewCheckBox);
		
		JLabel lblNewLabel_3 = new JLabel("Enter the Username");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(881, 270, 158, 20);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Enter the Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(881, 331, 158, 21);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon(login.class.getResource("/image/pastel-blue-vignette-concrete-textured-background.jpg")));
		lblNewLabel_4.setBounds(851, 0, 515, 768);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(login.class.getResource("/image/gymhome.png")));
		lblNewLabel_5.setBounds(0, 0, 852, 768);
		contentPane.add(lblNewLabel_5);
	}
}