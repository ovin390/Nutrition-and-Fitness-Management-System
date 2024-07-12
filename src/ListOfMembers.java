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
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import project.ConnectionProvider;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListOfMembers extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListOfMembers frame = new ListOfMembers();
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
	public ListOfMembers() {
		
		setLocation(new Point(174, 100));
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
		btnNewButton.setBackground(SystemColor.menu);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setIcon(new ImageIcon(ListOfMembers.class.getResource("/image/close.png")));
		btnNewButton.setBounds(0, 0, 75, 38);
		panel.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 83, 1000, 193);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Member ID", "First Name", "Last Name", "Date Of Birth", "Gender", "State", "Health ID", "Instructor ID"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("Show Data");
		btnNewButton_1.setBackground(SystemColor.menu);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con=ConnectionProvider.getCon();
					Statement st=con.createStatement();
					String sql="select * from user";
					ResultSet rs=st.executeQuery(sql);
					while(rs.next()) {
						String id=rs.getString("Uid");
						String Fname=rs.getString("Fname");
						String Lname=rs.getString("Lname");
						String Dob=rs.getString("Dob");
						String Gender=rs.getString("Gender");
						String State=rs.getString("State");
						String hid=rs.getString("UHid");
						String iid=rs.getString("UInid");
						String tbData[]= {id,Fname,Lname,Dob,Gender,State,hid,iid};
						DefaultTableModel tblModel=(DefaultTableModel)table.getModel();
						tblModel.addRow(tbData);
			
					}
					
				}
				catch(Exception e4){
					JOptionPane.showMessageDialog(null, e4);
				}
			}
		});
		btnNewButton_1.setBounds(381, 338, 112, 38);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Update");
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				new UpdateDeleteMember().setVisible(true);
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1_1.setBackground(SystemColor.menu);
		btnNewButton_1_1.setBounds(208, 338, 112, 38);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Delete");
		btnNewButton_1_2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				new UpdateDeleteMember().setVisible(true);
			}
		});
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1_2.setBackground(SystemColor.menu);
		btnNewButton_1_2.setBounds(556, 338, 112, 38);
		panel.add(btnNewButton_1_2);
		
		JButton btnNewButton_1_2_1 = new JButton("Update Health Status");
		btnNewButton_1_2_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				new update_health_status().setVisible(true);
			}
		});
		btnNewButton_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1_2_1.setBackground(SystemColor.menu);
		btnNewButton_1_2_1.setBounds(736, 338, 196, 38);
		panel.add(btnNewButton_1_2_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Reset");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new ListOfMembers().setVisible(true);
			}
		});
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1_1_1.setBackground(SystemColor.menu);
		btnNewButton_1_1_1.setBounds(48, 338, 112, 38);
		panel.add(btnNewButton_1_1_1);
	}
}
