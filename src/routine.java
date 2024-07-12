import java.awt.EventQueue;
import java.sql.*;
import project.ConnectionProvider;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class routine extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					routine frame = new routine();
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
	public routine() {
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
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setIcon(new ImageIcon(routine.class.getResource("/image/close.png")));
		btnNewButton.setBounds(0, 0, 64, 43);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Enter Plan ID");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 98, 168, 31);
		panel.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(10, 134, 168, 31);
		panel.add(textField);
		
		JLabel lblNewLabel_2_1 = new JLabel("Day 1");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(10, 204, 168, 31);
		panel.add(lblNewLabel_2_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 240, 168, 31);
		panel.add(textField_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Day 3");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2.setBounds(10, 314, 168, 31);
		panel.add(lblNewLabel_2_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 350, 168, 31);
		panel.add(textField_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Day 5");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_3.setBounds(10, 425, 168, 31);
		panel.add(lblNewLabel_2_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(10, 461, 168, 31);
		panel.add(textField_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("Day 2");
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_4.setBounds(451, 204, 168, 31);
		panel.add(lblNewLabel_2_4);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(451, 240, 168, 31);
		panel.add(textField_4);
		
		JLabel lblNewLabel_2_5 = new JLabel("Day 4");
		lblNewLabel_2_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_5.setBounds(451, 314, 168, 31);
		panel.add(lblNewLabel_2_5);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(451, 350, 168, 31);
		panel.add(textField_5);
		
		JLabel lblNewLabel_2_6 = new JLabel("Day 6");
		lblNewLabel_2_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_6.setBounds(451, 425, 168, 31);
		panel.add(lblNewLabel_2_6);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(451, 461, 168, 31);
		panel.add(textField_6);
		
		JButton btnNewButton_1 = new JButton("Save");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=textField.getText();
				String day1=textField_1.getText();
				String day2=textField_4.getText();
				String day3=textField_2.getText();
				String day4=textField_5.getText();
				String day5=textField_3.getText();
				String day6=textField_6.getText();
				String name=textField_7.getText();
				try
				{
					Connection con=ConnectionProvider.getCon();
					PreparedStatement ps=con.prepareStatement("insert into routine values (?,?,?,?,?,?,?,?)");
					ps.setString(1, id);
					ps.setString(2, day1);
					ps.setString(3, day2);
					ps.setString(4, day3);
					ps.setString(5, day4);
					ps.setString(6, day5);
					ps.setString(7, day6);
					ps.setString(8, name);

					ps.executeUpdate();
					JOptionPane.showMessageDialog(null,"Successfully saved");
					setVisible(false);
					new routine().setVisible(true);
					
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}	
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(35, 537, 82, 31);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Reset");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new routine().setVisible(true);
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1_1.setBounds(224, 537, 82, 31);
		panel.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_2_7 = new JLabel("Enter Routine Name");
		lblNewLabel_2_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_7.setBounds(451, 98, 168, 31);
		panel.add(lblNewLabel_2_7);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(451, 134, 168, 31);
		panel.add(textField_7);
	}
}
