import java.awt.EventQueue;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import project.ConnectionProvider;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class displayhealthstatus extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					displayhealthstatus frame = new displayhealthstatus();
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
	public displayhealthstatus() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(255, 245, 238));
		panel.setBounds(0, 0, 1000, 600);
		contentPane.add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 180, 1000, 153);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Health ID", "Fat", "Calories", "Remarks", "Instructor ID"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setIcon(new ImageIcon(displayhealthstatus.class.getResource("/image/close.png")));
		btnNewButton.setBounds(0, 0, 69, 44);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Show Data");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con=ConnectionProvider.getCon();
					Statement st=con.createStatement();
					String sql="select * from health_status";
					ResultSet rs=st.executeQuery(sql);
					while(rs.next()) {
						String id=rs.getString("Hid");
						String fat=rs.getString("Fat");
						String calories=rs.getString("Calories");
						String remarks=rs.getString("Remarks");
						String iid=rs.getString("HInid");
						
						String tbData[]= {id,fat,calories,remarks,iid};
						DefaultTableModel tblModel=(DefaultTableModel)table.getModel();
						tblModel.addRow(tbData);
			
					}
					
				}
				catch(Exception e4){
					JOptionPane.showMessageDialog(null, e4);
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(417, 417, 112, 38);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Update");
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				new update_health_status().setVisible(true);
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1_1.setBackground(SystemColor.menu);
		btnNewButton_1_1.setBounds(244, 417, 112, 38);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2_1 = new JButton("Reset");
		btnNewButton_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new displayhealthstatus().setVisible(true);
			}
		});
		btnNewButton_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1_2_1.setBackground(SystemColor.menu);
		btnNewButton_1_2_1.setBounds(608, 417, 112, 38);
		panel.add(btnNewButton_1_2_1);
	}
}
