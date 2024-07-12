import java.awt.EventQueue;
import project.ConnectionProvider;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class update_health_status extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					update_health_status frame = new update_health_status();
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
	public update_health_status() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 245, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setIcon(new ImageIcon(update_health_status.class.getResource("/image/close.png")));
		btnNewButton.setBounds(0, 0, 75, 38);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Enter Health ID");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 103, 168, 31);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(10, 139, 168, 31);
		contentPane.add(textField);
		
		JLabel lblNewLabel_2_4 = new JLabel("Enter Instructor ID");
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_4.setBounds(238, 413, 168, 31);
		contentPane.add(lblNewLabel_2_4);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(238, 449, 168, 31);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Enter Fat");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(10, 205, 168, 31);
		contentPane.add(lblNewLabel_2_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 241, 168, 31);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("Enter Calories");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2.setBounds(10, 305, 168, 31);
		contentPane.add(lblNewLabel_2_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(10, 341, 168, 31);
		contentPane.add(textField_3);
		
		JLabel lblNewLabel_2_3 = new JLabel("Enter Remarks");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_3.setBounds(10, 413, 168, 31);
		contentPane.add(lblNewLabel_2_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(10, 449, 168, 31);
		contentPane.add(textField_4);
		
		JButton btnNewButton_1_1 = new JButton("Update");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=textField.getText();
				String fat=textField_2.getText();
				String calories=textField_3.getText();
				String remark=textField_4.getText();
				
				try {
					Connection con=ConnectionProvider.getCon();				
					Statement st=con.createStatement();
					st.executeUpdate("update health_status set Fat='"+fat+"',Calories='"+calories+"',Remarks='"+remark+"' where Hid='"+id+"'");
					JOptionPane.showMessageDialog(null, "Successfully Updated");
					setVisible(false);
					new update_health_status().setVisible(true);
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);	
				}
				
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1_1.setBounds(10, 532, 113, 31);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_2 = new JButton("Reset");
		btnNewButton_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new update_health_status().setVisible(true);
			}
		});
		btnNewButton_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1_1_2.setBounds(238, 532, 113, 30);
		contentPane.add(btnNewButton_1_1_2);
		
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int checkid=0;
				String id=textField.getText();
				try
				{
					Connection con=ConnectionProvider.getCon();
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select * from health_status where Hid='"+id+"'");
					while(rs.next())
					{
						checkid=1;
						textField.setEditable(false);
						textField_2.setText(rs.getString(2));
						textField_3.setText(rs.getString(3));
						textField_4.setText(rs.getString(4));
						textField_1.setText(rs.getString(5));
						textField_1.setEditable(false);
						
						
						
					}
					if(checkid==0)
						JOptionPane.showMessageDialog(null, "Member ID does not Exist");				
				}
				catch(Exception e4){
					JOptionPane.showMessageDialog(null, e4);
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBounds(213, 144, 113, 25);
		contentPane.add(btnNewButton_1);
	}
}
