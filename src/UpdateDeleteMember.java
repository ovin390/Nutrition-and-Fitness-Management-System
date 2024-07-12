import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Point;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import project.ConnectionProvider;
import java.awt.SystemColor;

public class UpdateDeleteMember extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField txtYyyy;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateDeleteMember frame = new UpdateDeleteMember();
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
	public UpdateDeleteMember() {
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
		panel.setBounds(0, 0, 1000, 610);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setIcon(new ImageIcon(UpdateDeleteMember.class.getResource("/image/close.png")));
		btnNewButton.setBounds(0, 0, 53, 42);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Member ID:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 89, 92, 31);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(102, 97, 101, 23);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.setBackground(SystemColor.menu);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int checkid=0;
				String id=textField.getText();
				try
				{
					Connection con=ConnectionProvider.getCon();
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select * from user where Uid='"+id+"'");
					while(rs.next())
					{
						checkid=1;
						textField.setEditable(false);
						textField_1.setText(rs.getString(2));
						textField_2.setText(rs.getString(3));
						txtYyyy.setText(rs.getString(4));
						textField_3.setText(rs.getString(5));
						//textField_3.setEditable(false);
						textField_4.setText(rs.getString(6));
						textField_5.setText(rs.getString(7));
						textField_6.setText(rs.getString(8));
						
						
					}
					if(checkid==0)
						JOptionPane.showMessageDialog(null, "Member ID does not Exist");				
				}
				catch(Exception e4){
					JOptionPane.showMessageDialog(null, e4);
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setIcon(new ImageIcon(UpdateDeleteMember.class.getResource("/image/search.png")));
		btnNewButton_1.setBounds(236, 96, 119, 24);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("First Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 169, 92, 31);
		panel.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 205, 168, 31);
		panel.add(textField_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Lname Name");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(567, 180, 107, 31);
		panel.add(lblNewLabel_2_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(567, 216, 168, 31);
		panel.add(textField_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("Date Of Birth");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2.setBounds(10, 285, 113, 31);
		panel.add(lblNewLabel_2_2);
		
		txtYyyy = new JTextField();
		txtYyyy.setColumns(10);
		txtYyyy.setBounds(10, 321, 168, 31);
		panel.add(txtYyyy);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Gender");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2_1.setBounds(567, 285, 113, 31);
		panel.add(lblNewLabel_2_2_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(567, 321, 168, 31);
		panel.add(textField_3);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("State");
		lblNewLabel_2_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2_2.setBounds(10, 392, 113, 31);
		panel.add(lblNewLabel_2_2_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(10, 428, 168, 31);
		panel.add(textField_4);
		
		JButton btnNewButton_1_1 = new JButton("Update");
		btnNewButton_1_1.setBackground(SystemColor.menu);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=textField.getText();
				String Fname=textField_1.getText();
				String lname=textField_2.getText();
				String dob=txtYyyy.getText();
				String gender=textField_3.getText();
				String state=textField_4.getText();
				String hid=textField_5.getText();
				String iid=textField_6.getText();
				try {
					Connection con=ConnectionProvider.getCon();
					//PreparedStatement ps=con.prepareStatement("update user set Fname=?,Lname=?,Dob=?,Gender=?,State=? where Uid=?");
					//ps.setString(1, id);
					//ps.setString(2, Fname);
					//ps.setString(3, lname);
					//ps.setString(4, dob);
					//ps.setString(5, gender);
					//ps.setString(6, state);
					//ps.executeUpdate();
					Statement st=con.createStatement();
					st.executeUpdate("update user set Fname='"+Fname+"',Lname='"+lname+"',Dob='"+dob+"',Gender='"+gender+"',State='"+state+"',UHid='"+hid+"',UInid='"+iid+"' where Uid='"+id+"'");
					JOptionPane.showMessageDialog(null, "Successfully Updated");
					setVisible(false);
					new UpdateDeleteMember().setVisible(true);
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);	
				}
			}
		});
		btnNewButton_1_1.setIcon(new ImageIcon(UpdateDeleteMember.class.getResource("/image/save.png")));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1_1.setBounds(22, 533, 119, 31);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Delete");
		btnNewButton_1_1_1.setBackground(SystemColor.menu);
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=JOptionPane.showConfirmDialog(null, "Do you really want to delete ","Select",JOptionPane.YES_NO_OPTION);
				if(a==0)
				{
					String id=textField.getText();
					try {
						Connection con=ConnectionProvider.getCon();
						Statement st=con.createStatement();
						st.executeUpdate("delete from user where Uid='"+id+"'");
						JOptionPane.showMessageDialog(null, "Succcessfully deleted");
						setVisible(false);
						new UpdateDeleteMember().setVisible(true);
					}
					catch(Exception e2)
					{
						JOptionPane.showMessageDialog(null, e2);
					}
				}
			}
		});
		btnNewButton_1_1_1.setIcon(new ImageIcon(UpdateDeleteMember.class.getResource("/image/delete.png")));
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1_1_1.setBounds(191, 535, 119, 26);
		panel.add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_1_2 = new JButton("Reset");
		btnNewButton_1_1_2.setBackground(SystemColor.menu);
		btnNewButton_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new UpdateDeleteMember().setVisible(true);
			}
		});
		btnNewButton_1_1_2.setIcon(new ImageIcon(UpdateDeleteMember.class.getResource("/image/reset.png")));
		btnNewButton_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1_1_2.setBounds(357, 537, 119, 27);
		panel.add(btnNewButton_1_1_2);
		
		JLabel lblNewLabel_2_2_2_1 = new JLabel("Health ID");
		lblNewLabel_2_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2_2_1.setBounds(308, 392, 113, 31);
		panel.add(lblNewLabel_2_2_2_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(308, 428, 168, 31);
		panel.add(textField_5);
		
		JLabel lblNewLabel_2_2_2_2 = new JLabel("Instructor ID");
		lblNewLabel_2_2_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2_2_2.setBounds(567, 392, 113, 31);
		panel.add(lblNewLabel_2_2_2_2);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(567, 428, 168, 31);
		panel.add(textField_6);
	}
}