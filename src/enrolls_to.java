import java.awt.EventQueue;

import project.ConnectionProvider;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

public class enrolls_to extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					enrolls_to frame = new enrolls_to();
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
	public enrolls_to() {
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
		btnNewButton.setIcon(new ImageIcon(enrolls_to.class.getResource("/image/close.png")));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(0, 0, 63, 38);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Enter the member id");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(56, 202, 156, 27);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(219, 208, 118, 27);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblEnterThePlan = new JLabel("Enter the plan id");
		lblEnterThePlan.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEnterThePlan.setBounds(56, 283, 156, 27);
		panel.add(lblEnterThePlan);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(219, 289, 118, 27);
		panel.add(textField_1);
		
		JLabel lblEnterTheJoining = new JLabel("Enter the Joining date");
		lblEnterTheJoining.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEnterTheJoining.setBounds(56, 375, 175, 27);
		panel.add(lblEnterTheJoining);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(219, 377, 118, 27);
		panel.add(textField_2);
		
		JButton btnNewButton_1 = new JButton("Save");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String uid=textField.getText();
				String pid=textField_1.getText();
				String date=textField_2.getText();
				try {
					Connection con=ConnectionProvider.getCon();
					PreparedStatement ps=con.prepareStatement("insert into enrolls_to values (?,?,?)");
					ps.setString(1, uid);
					ps.setString(2, pid);
					ps.setString(3, date);
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null,"Successfully saved");
					setVisible(false);
					new enrolls_to().setVisible(true);
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(56, 483, 82, 31);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Reset");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new enrolls_to().setVisible(true);
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1_1.setBounds(245, 483, 82, 31);
		panel.add(btnNewButton_1_1);
	}
}
