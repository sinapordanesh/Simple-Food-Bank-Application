/**
 @author Jinsu Kwak <a href="mailto:jinsu.kwak@ucalgary.ca">
 jinsu.kwak@ucalgary.ca</a>
 @UCID 30097737
 @version 1.0
 @since 1.0
 */
package edu.ucalgary.ensf409;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class GUIFamilyInfo {

	private JFrame frame;
	private JTextField txtEx;
	private JTextField txtEg;
	private JTextField txtEg_1;
	private JTextField txtEg_2;
	
	private static ArrayList<Integer[]> families = new ArrayList<Integer[]>();

	/**
	 * Launch the application.
	 * @return 
	 */
	public static ArrayList<Integer[]> familyInfo(int args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIFamilyInfo window = new GUIFamilyInfo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		return families;
	}

	/**
	 * Create the application.
	 */
	public GUIFamilyInfo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(250, 240, 230));
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 660, 340);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtEx = new JTextField();
		txtEx.setFont(new Font("Lantinghei TC", Font.PLAIN, 13));
		txtEx.setHorizontalAlignment(SwingConstants.LEFT);
		txtEx.setText("e.g 1");
		txtEx.setToolTipText("");
		txtEx.setBounds(129, 173, 104, 40);
		frame.getContentPane().add(txtEx);
		txtEx.setColumns(10);
		
		JButton btnNewButton = new JButton("NEXT");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Lantinghei TC", Font.BOLD, 13));
		btnNewButton.setBounds(505, 173, 77, 97);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Please enter the number of each family memeber type for single family");
		lblNewLabel_1.setFont(new Font("Lantinghei TC", Font.PLAIN, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(19, 77, 487, 39);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("FoodBank 409");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lantinghei TC", Font.PLAIN, 35));
		lblNewLabel.setBounds(19, 17, 285, 65);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(29, 77, 592, 3);
		frame.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(29, 71, 592, 3);
		frame.getContentPane().add(panel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Adult Male: ");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("Lantinghei TC", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(35, 173, 77, 40);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Adult Female: ");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1.setFont(new Font("Lantinghei TC", Font.PLAIN, 13));
		lblNewLabel_1_1_1.setBounds(284, 173, 93, 40);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		txtEg = new JTextField();
		txtEg.setFont(new Font("Lantinghei TC", Font.PLAIN, 13));
		txtEg.setToolTipText("");
		txtEg.setText("e.g 1");
		txtEg.setHorizontalAlignment(SwingConstants.LEFT);
		txtEg.setColumns(10);
		txtEg.setBounds(389, 173, 104, 40);
		frame.getContentPane().add(txtEg);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Child over 8:");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_2.setFont(new Font("Lantinghei TC", Font.PLAIN, 13));
		lblNewLabel_1_1_2.setBounds(35, 230, 93, 40);
		frame.getContentPane().add(lblNewLabel_1_1_2);
		
		txtEg_1 = new JTextField();
		txtEg_1.setFont(new Font("Lantinghei TC", Font.PLAIN, 13));
		txtEg_1.setToolTipText("");
		txtEg_1.setText("e.g 2\n");
		txtEg_1.setHorizontalAlignment(SwingConstants.LEFT);
		txtEg_1.setColumns(10);
		txtEg_1.setBounds(129, 230, 104, 40);
		frame.getContentPane().add(txtEg_1);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("Child under 8:");
		lblNewLabel_1_1_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_2_1.setFont(new Font("Lantinghei TC", Font.PLAIN, 13));
		lblNewLabel_1_1_2_1.setBounds(284, 230, 93, 40);
		frame.getContentPane().add(lblNewLabel_1_1_2_1);
		
		txtEg_2 = new JTextField();
		txtEg_2.setFont(new Font("Lantinghei TC", Font.PLAIN, 13));
		txtEg_2.setToolTipText("");
		txtEg_2.setText("e.g 0");
		txtEg_2.setHorizontalAlignment(SwingConstants.LEFT);
		txtEg_2.setColumns(10);
		txtEg_2.setBounds(389, 230, 104, 40);
		frame.getContentPane().add(txtEg_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("Family ID: ");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2.setFont(new Font("Lantinghei TC", Font.ITALIC, 13));
		lblNewLabel_1_2.setBounds(39, 103, 67, 39);
		frame.getContentPane().add(lblNewLabel_1_2);
	}
}
