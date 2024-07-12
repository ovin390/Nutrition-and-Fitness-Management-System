import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import project.ConnectionProvider;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class update_delete_instructor extends JFrame {

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
					update_delete_instructor frame = new update_delete_instructor();
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
	public update_delete_instructor() {
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
		btnNewButton.setIcon(new ImageIcon(update_delete_instructor.class.getResource("/image/close.png")));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(0, 0, 63, 38);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Instructor ID:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 99, 113, 31);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(146, 105, 101, 23);
		contentPane.add(textField);
		
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int checkid=0;
				String id=textField.getText();
				try
				{
					Connection con=ConnectionProvider.getCon();
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select * from instructor where Inid='"+id+"'");
					while(rs.next())
					{
						checkid=1;
						textField.setEditable(false);
						textField_1.setText(rs.getString(1));
						textField_2.setText(rs.getString(3));
						textField_3.setText(rs.getString(4));				
					}
					if(checkid==0)
						JOptionPane.showMessageDialog(null, "Instructor ID does not Exist");				
				}
				catch(Exception e4){
					JOptionPane.showMessageDialog(null, e4);
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBounds(269, 105, 113, 25);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Enter Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(21, 175, 168, 31);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(21, 211, 168, 31);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Enter Phone");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2.setBounds(21, 267, 168, 31);
		contentPane.add(lblNewLabel_2_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(21, 303, 168, 31);
		contentPane.add(textField_2);
		
		JButton btnNewButton_1_1 = new JButton("Update");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=textField.getText();
				String name=textField_1.getText();
				String phone=textField_2.getText();
				String age=textField_3.getText();
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
					st.executeUpdate("update instructor set Inname='"+name+"',Inphone='"+phone+"',Age='"+age+"' where Inid='"+id+"'");
					JOptionPane.showMessageDialog(null, "Successfully Updated");
					setVisible(false);
					new update_delete_instructor().setVisible(true);
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);	
				}
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1_1.setBounds(27, 513, 113, 31);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Delete");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=JOptionPane.showConfirmDialog(null, "Do you really want to delete ","Select",JOptionPane.YES_NO_OPTION);
				if(a==0)
				{
					String id=textField.getText();
					try {
						Connection con=ConnectionProvider.getCon();
						Statement st=con.createStatement();
						st.executeUpdate("delete from instructor where Inid='"+id+"'");
						JOptionPane.showMessageDialog(null, "Succcessfully deleted");
						setVisible(false);
						new update_delete_instructor().setVisible(true);
					}
					catch(Exception e2)
					{
						JOptionPane.showMessageDialog(null, e2);
					}
			}
			}
		});
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1_1_1.setBounds(214, 514, 113, 30);
		contentPane.add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_1_2 = new JButton("Reset");
		btnNewButton_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new update_delete_instructor().setVisible(true);
			}
		});
		btnNewButton_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1_1_2.setBounds(410, 514, 113, 30);
		contentPane.add(btnNewButton_1_1_2);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Enter Age");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2_1.setBounds(21, 364, 168, 31);
		contentPane.add(lblNewLabel_2_2_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(21, 400, 168, 31);
		contentPane.add(textField_3);
	}
}
