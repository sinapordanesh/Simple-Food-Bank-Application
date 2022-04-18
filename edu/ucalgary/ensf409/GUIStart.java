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
//import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JPanel;

public class GUIStart extends JFrame implements ActionListener, MouseListener {

	JFrame frame;
	private JTextField txtEx;
	private int numOfFamilies = 0;
	private String stringInput;
	private int orderNumber;
	//private Image image;
	/**
	 * Launch the application.
	 * @param orderNumber 
	 */
	public static void start(int orderNumber) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try{
					GUIStart window = new GUIStart(orderNumber);
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
	public GUIStart(int orderNumber) {
		this.orderNumber = orderNumber;
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
		frame.setTitle("FoodBank 409");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtEx = new JTextField();
		txtEx.setFont(new Font("Lantinghei TC", Font.PLAIN, 13));
		txtEx.setHorizontalAlignment(SwingConstants.LEFT);
		txtEx.setText("e.g 3");
		txtEx.addMouseListener(this);
		txtEx.setToolTipText("Integer format only");
		txtEx.setBounds(225, 200, 229, 40);
		frame.getContentPane().add(txtEx);
		txtEx.setColumns(10);
	
		
		JButton btnNewButton = new JButton("ENTER");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.addActionListener(this);//new ActionListener() /*{
		/*
			public void actionPerformed(ActionEvent e) {
				stringInput = txtEx.getText();
				if(validateInput()) {
					numOfFamilies = Integer.parseInt(stringInput);
				}
			}
		});*/
		
		btnNewButton.setFont(new Font("Lantinghei TC", Font.BOLD, 13));
		btnNewButton.setBounds(462, 201, 77, 40);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Please enter the number of families for a single order");
		lblNewLabel_1.setFont(new Font("Lantinghei TC", Font.PLAIN, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(213, 160, 345, 39);
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
		
		/*
		JLabel lblNewLabel_2 = new JLabel("");
		image = new ImageIcon(this.getClass().getResource("aaa.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(image));
		lblNewLabel_2.setBounds(53, 118, 129, 143);
		frame.getContentPane().add(lblNewLabel_2);
		*/

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource().equals(txtEx)) {
			txtEx.setText("");
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getSource().equals(txtEx)) {
			txtEx.setText("");
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		stringInput = txtEx.getText();
		if(validateInput()) {
			numOfFamilies = Integer.parseInt(stringInput);
			JOptionPane.showMessageDialog(this, "Total Families for single order is " + stringInput);
			this.frame.setVisible(false);
			GUIFamilyInfo.familyInfo(numOfFamilies,this.orderNumber);
		}
		
	}

	private boolean validateInput() {
		boolean allInputValid = true;
		if(stringInput.isEmpty()) {
			JOptionPane.showMessageDialog(this, "You have entered empty string, please try again");
			return false;
		}
		
		for(int i = 0; i<stringInput.length(); i++) {
			if((stringInput.charAt(i) < 48) || (stringInput.charAt(i) > 57)) {
				allInputValid = false;
			}
		}
		
		if(Integer.parseInt(stringInput) == 0) {
			allInputValid = false;
			JOptionPane.showMessageDialog(this, "Order must contains at least one famliy");
			return false;
		}
		
		if(allInputValid == false) {
			JOptionPane.showMessageDialog(this, "Your have entered an invalid input,"
					+ " the input should be an integer format");
		} 
		
		return allInputValid;
	}


}
