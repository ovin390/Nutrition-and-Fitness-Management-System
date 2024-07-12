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
import project.ConnectionProvider;
import java.sql.*;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;

public class NewMember extends JFrame {

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
					NewMember frame = new NewMember();
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
	public NewMember() {
		setUndecorated(true);
		try
		{
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setLocation(new Point(175, 100));
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
		btnNewButton.setBackground(UIManager.getColor("Button.background"));
		btnNewButton.setIcon(new ImageIcon(NewMember.class.getResource("/image/close.png")));
		btnNewButton.setBounds(947, 0, 53, 42);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Member ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 83, 85, 13);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(10, 106, 122, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("First Name");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(487, 83, 91, 13);
		panel.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(487, 106, 122, 21);
		panel.add(textField_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Last Name");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(10, 166, 85, 13);
		panel.add(lblNewLabel_1_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 189, 122, 21);
		panel.add(textField_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Date Of Birth");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(487, 166, 122, 13);
		panel.add(lblNewLabel_1_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(487, 189, 122, 21);
		panel.add(textField_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Gender");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_4.setBounds(10, 260, 72, 13);
		panel.add(lblNewLabel_1_4);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(10, 283, 122, 21);
		panel.add(textField_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("State");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_5.setBounds(487, 260, 72, 13);
		panel.add(lblNewLabel_1_5);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(487, 283, 122, 21);
		panel.add(textField_5);
		
		JButton btnNewButton_1 = new JButton("Save");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=textField.getText();
				String fname=textField_1.getText();
				String lname=textField_2.getText();
				String dob=textField_3.getText();
				String gender=textField_4.getText();
				String state=textField_5.getText();
				String hid=textField_6.getText();
				String iid=textField_7.getText();	
				try
				{
					Connection con=ConnectionProvider.getCon();
					PreparedStatement ps=con.prepareStatement("insert into user values (?,?,?,?,?,?,?,?)");
					ps.setString(1, id);
					ps.setString(2, fname);
					ps.setString(3, lname);
					ps.setString(4, dob);
					ps.setString(5, gender);
					ps.setString(6, state);
					ps.setString(7, hid);
					ps.setString(8, iid);				
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null,"Successfully saved");
					setVisible(false);
					new NewMember().setVisible(true);				
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}		
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBackground(UIManager.getColor("Button.background"));
		btnNewButton_1.setBounds(32, 522, 101, 31);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Reset");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new NewMember().setVisible(true);
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1_1.setBackground(UIManager.getColor("Button.background"));
		btnNewButton_1_1.setBounds(198, 522, 101, 31);
		panel.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_1_6 = new JLabel("Health ID");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_6.setBounds(10, 340, 85, 13);
		panel.add(lblNewLabel_1_6);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(10, 363, 122, 21);
		panel.add(textField_6);
		
		JLabel lblNewLabel_1_7 = new JLabel("Instructor ID");
		lblNewLabel_1_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_7.setBounds(487, 340, 108, 13);
		panel.add(lblNewLabel_1_7);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(487, 363, 122, 21);
		panel.add(textField_7);
		
		JButton btnNewButton_1_1_1 = new JButton("Add Health Status");
		btnNewButton_1_1_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				new health_status().setVisible(true);
			}
		});
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1_1_1.setBackground(UIManager.getColor("Button.background"));
		btnNewButton_1_1_1.setBounds(362, 522, 180, 31);
		panel.add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_1_1_1 = new JButton("Add Phone Number");
		btnNewButton_1_1_1_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				new phone().setVisible(true);
			}
		});
		btnNewButton_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1_1_1_1.setBackground(UIManager.getColor("Button.background"));
		btnNewButton_1_1_1_1.setBounds(597, 522, 180, 31);
		panel.add(btnNewButton_1_1_1_1);
	}
}