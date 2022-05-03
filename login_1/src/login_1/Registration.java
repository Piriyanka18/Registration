package login_1;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import com.mysql.jdbc.PreparedStatement;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class Registration {

	private JFrame frame;
	private JTextField textname;
	private JTextField textemail;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration window = new Registration();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Registration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registration");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(125, 11, 182, 28);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("User Name");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setBounds(21, 51, 92, 28);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Email");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(21, 99, 92, 28);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Password");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(21, 154, 92, 28);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		textname = new JTextField();
		textname.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textname.setBounds(135, 56, 231, 23);
		frame.getContentPane().add(textname);
		textname.setColumns(10);
		
		textemail = new JTextField();
		textemail.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textemail.setColumns(10);
		textemail.setBounds(135, 104, 231, 23);
		frame.getContentPane().add(textemail);
		
		pass = new JPasswordField();
		pass.setFont(new Font("Times New Roman", Font.BOLD, 14));
		pass.setBounds(135, 159, 231, 23);
		frame.getContentPane().add(pass);
		
		JButton btnsubmit = new JButton("Submit");
		btnsubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration","root","");
					PreparedStatement ps = (PreparedStatement) conn.prepareStatement("insert into register(user_name, email, password) values (?,?,?);");
					ps.setString(1,textname.getText());
					ps.setString(2,textemail.getText());
					ps.setString(3,pass.getText());
					int x = ps.executeUpdate();
					if(x>0) {
						JOptionPane.showMessageDialog(null, "   SUCESSFULY SUBMITED  ","SUCESFUL",JOptionPane.DEFAULT_OPTION);
						//System.out.println("Sucessfuly submit..");
					}else {
						JOptionPane.showMessageDialog(null, "    INVALID SUBMIT   ","ERROR",JOptionPane.ERROR_MESSAGE);
						//System.out.println(" submit failed..");
					}
				}catch(Exception e1) {
					System.out.println(e1);
				}
			}
		});
		btnsubmit.setBackground(Color.LIGHT_GRAY);
		btnsubmit.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnsubmit.setBounds(34, 209, 89, 28);
		frame.getContentPane().add(btnsubmit);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textname.setText(null);
				textemail.setText(null);
				pass.setText(null);
			}
		});
		btnReset.setBackground(Color.LIGHT_GRAY);
		btnReset.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnReset.setBounds(163, 209, 89, 28);
		frame.getContentPane().add(btnReset);
		
		JButton btnexit = new JButton("Exit");
		btnexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnexit.setBackground(Color.LIGHT_GRAY);
		btnexit.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnexit.setBounds(290, 209, 89, 28);
		frame.getContentPane().add(btnexit);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\project\\Java\\images\\8.jpg"));
		lblNewLabel_2.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
