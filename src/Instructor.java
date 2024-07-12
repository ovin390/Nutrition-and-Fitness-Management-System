import java.awt.EventQueue;
import project.ConnectionProvider;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Point;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class Instructor extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Instructor frame = new Instructor();
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
	public Instructor() {
		try
		{
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
		
		setLocation(new Point(175, 100));
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 245, 238));
		panel.setBounds(0, 0, 1000, 600);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(UIManager.getColor("Button.background"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setIcon(new ImageIcon(Instructor.class.getResource("/image/close.png")));
		btnNewButton.setBounds(933, 0, 67, 43);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_2_1 = new JLabel("Enter the Instructor ID");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(10, 180, 171, 31);
		panel.add(lblNewLabel_2_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(13, 221, 168, 31);
		panel.add(textField);
		
		JLabel lblNewLabel_2 = new JLabel("Enter the Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 80, 168, 31);
		panel.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 116, 171, 31);
		panel.add(textField_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Enter the Phone Number");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2.setBounds(10, 384, 180, 31);
		panel.add(lblNewLabel_2_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 420, 171, 31);
		panel.add(textField_2);
		
		JButton btnNewButton_1 = new JButton("Save");
		btnNewButton_1.setBackground(UIManager.getColor("Button.background"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=textField_1.getText();
				String id=textField.getText();
				String phone=textField_2.getText();
				String age=textField_3.getText();		
				try
				{
					Connection con=ConnectionProvider.getCon();
					PreparedStatement ps=con.prepareStatement("insert into instructor values (?,?,?,?)");
					ps.setString(1, name);
					ps.setString(2, id);
					ps.setString(3, phone);
					ps.setString(4, age);
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null,"Successfully saved");
					setVisible(false);
					new Instructor().setVisible(true);			
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}	
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(27, 491, 82, 31);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Reset");
		btnNewButton_1_1.setBackground(UIManager.getColor("Button.background"));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Instructor().setVisible(true);
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1_1.setBounds(216, 491, 82, 31);
		panel.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Enter the Age");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2_1.setBounds(13, 285, 168, 31);
		panel.add(lblNewLabel_2_2_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(13, 321, 168, 31);
		panel.add(textField_3);
	}
}
