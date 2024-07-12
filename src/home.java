import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class home extends JFrame {
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home frame = new home();
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
	public home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(80, 29, 1325, 731);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WELCOME");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(591, 0, 186, 70);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("New Member");
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				new NewMember().setVisible(true);	
			}
		});
		btnNewButton.setBackground(new Color(250, 235, 215));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setIcon(null);
		btnNewButton.setBounds(24, 226, 285, 44);
		panel.add(btnNewButton);
		
		//JButton btnNewButton_1 = new JButton("Update & Delete Member");
		//btnNewButton_1.addMouseListener(new MouseAdapter() {
			//public void mouseClicked(MouseEvent e) {
				//new UpdateDeleteMember().setVisible(true);
			//}
		//});
		//btnNewButton_1.setIcon(null);
		//btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		//btnNewButton_1.setBackground(new Color(250, 235, 215));
		//btnNewButton_1.setBounds(24, 188, 285, 44);
		//panel.add(btnNewButton_1);
		
		JButton btnListOfMembers = new JButton("List of Members");
		btnListOfMembers.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				new ListOfMembers().setVisible(true);
			}
		});
		btnListOfMembers.setIcon(null);
		btnListOfMembers.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnListOfMembers.setBackground(new Color(250, 235, 215));
		btnListOfMembers.setBounds(24, 389, 285, 44);
		panel.add(btnListOfMembers);
		
		JButton btnPlan = new JButton("Plan");
		btnPlan.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				new plan().setVisible(true);
			}
		});
		btnPlan.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnPlan.setBackground(new Color(250, 235, 215));
		btnPlan.setBounds(24, 305, 285, 44);
		panel.add(btnPlan);
		
		JButton btnInstructor = new JButton("Add Instructor");
		btnInstructor.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				new Instructor().setVisible(true);
			}
		});
		btnInstructor.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnInstructor.setBackground(new Color(250, 235, 215));
		btnInstructor.setBounds(24, 143, 285, 44);
		panel.add(btnInstructor);
		
		//JButton btnNewButton_1_1 = new JButton("Update & Delete Instructor");
		//btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			//public void mouseClicked(MouseEvent e) {
				//new update_delete_instructor().setVisible(true);
			//}
		//});
		//btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		//btnNewButton_1_1.setBackground(new Color(250, 235, 215));
		//btnNewButton_1_1.setBounds(1023, 77, 246, 44);
		//panel.add(btnNewButton_1_1);
		
		//JButton btnHealthStatus = new JButton("Health Status");
		//btnHealthStatus.addMouseListener(new MouseAdapter() {
			//public void mouseClicked(MouseEvent e) {
				//new health_status().setVisible(true);
			//}
		//});
		//btnHealthStatus.setFont(new Font("Tahoma", Font.BOLD, 14));
		//btnHealthStatus.setBackground(new Color(250, 235, 215));
		//btnHealthStatus.setBounds(1023, 288, 246, 44);
		//panel.add(btnHealthStatus);
		
		//JButton btnRoutine = new JButton("Routine");
		//btnRoutine.addMouseListener(new MouseAdapter() {
			//public void mouseClicked(MouseEvent e) {
				//new routine().setVisible(true);
			//}
		//});
		//btnRoutine.setFont(new Font("Tahoma", Font.BOLD, 14));
		//btnRoutine.setBackground(new Color(250, 235, 215));
		//btnRoutine.setBounds(1023, 188, 246, 44);
		//panel.add(btnRoutine);
		
		//JButton btnLogout = new JButton("Logout");
		//btnLogout.addMouseListener(new MouseAdapter() {
			//public void mouseClicked(MouseEvent e) {
				//int a=JOptionPane.showConfirmDialog(null,"Do you really want to exit application","Select",JOptionPane.YES_NO_OPTION);
				//if(a==0) {
					//setVisible(false);
					//new login().setVisible(true);
				//}
			//}
		//});
		//btnLogout.setFont(new Font("Tahoma", Font.BOLD, 14));
		//btnLogout.setBackground(new Color(250, 235, 215));
		//btnLogout.setBounds(24, 610, 116, 44);
		//panel.add(btnLogout);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int a=JOptionPane.showConfirmDialog(null,"Do you really want to exit application","Select",JOptionPane.YES_NO_OPTION);
				if(a==0) {
					System.exit(0); 
				}
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExit.setBackground(new Color(250, 235, 215));
		btnExit.setBounds(585, 629, 116, 44);
		panel.add(btnExit);
		
		JButton btnListOfInstructors = new JButton("List of Instructors");
		btnListOfInstructors.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				new list_of_instructros().setVisible(true);
			}
		});
		btnListOfInstructors.setIcon(null);
		btnListOfInstructors.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnListOfInstructors.setBackground(new Color(250, 235, 215));
		btnListOfInstructors.setBounds(24, 471, 285, 44);
		panel.add(btnListOfInstructors);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(home.class.getResource("/image/flat-lay-dumbbells-with-copy-space.jpg")));
		lblNewLabel_1.setBounds(10, 10, 1305, 711);
		panel.add(lblNewLabel_1);
		
		//JButton btnNewButton_2 = new JButton("Enrolls To");
		//btnNewButton_2.addMouseListener(new MouseAdapter() {
			//public void mouseClicked(MouseEvent e) {
				//new enrolls_to().setVisible(true);
			//}
		//});
		//btnNewButton_2.setBackground(new Color(255, 239, 213));
		//btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		//btnNewButton_2.setIcon(null);
		//btnNewButton_2.setBounds(1023, 389, 246, 44);
		//panel.add(btnNewButton_2);
		
		//JButton btnNewButton_3 = new JButton("Phone ");
		//btnNewButton_3.setBackground(new Color(255, 239, 213));
		//btnNewButton_3.addActionListener(new ActionListener() {
			//public void actionPerformed(ActionEvent e) {
				//new phone().setVisible(true);
			//}
		//});
		//btnNewButton_3.setIcon(null);
		//btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		//btnNewButton_3.setBounds(1023, 489, 246, 44);
		//panel.add(btnNewButton_3);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}