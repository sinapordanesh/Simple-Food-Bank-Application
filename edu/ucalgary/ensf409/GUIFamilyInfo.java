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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.event.*;
import javax.swing.*;

public class GUIFamilyInfo extends JFrame implements ActionListener, MouseListener {

	private JFrame frame;
	private JTextField txtEx;
	private JTextField txtEg;
	private JTextField txtEg_1;
	private JTextField txtEg_2;
	
	
	private ArrayList<Integer[]> families = new ArrayList<Integer[]>();
	private int numberOfFamilies;
	private String numAdultMale = "0";
	private String numAdultFemale = "0";
	private String numChildOver8 = "0";
	private String numChildUnder8 = "0";
	private int familyID = 0;
	private boolean success;
	private Order order;
	private int orderNumber;
	/**
	 * Launch the application.
	 * @param orderNumber 
	 * @return 
	 */
	public static void familyInfo(int numberOfFamilies, int orderNumber) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIFamilyInfo window = new GUIFamilyInfo(numberOfFamilies, orderNumber);
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
	public GUIFamilyInfo(int numberOfFamilies, int orderNumber) {
		this.numberOfFamilies = numberOfFamilies;
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
		txtEx.setText("e.g 1");
		txtEx.addMouseListener(this);
		txtEx.setToolTipText("Integer format only");
		txtEx.setBounds(129, 173, 104, 40);
		frame.getContentPane().add(txtEx);
		txtEx.setColumns(10);
		
		JButton btnNewButton = new JButton("NEXT");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.addActionListener(this);
		btnNewButton.setFont(new Font("Lantinghei TC", Font.BOLD, 13));
		btnNewButton.setBounds(505, 173, 77, 97);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Please enter the number of each family " +
				"memeber type for single family");
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
		txtEg.setToolTipText("Integer format only");
		txtEg.setText("e.g 1");
		txtEg.addMouseListener(this);
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
		txtEg_1.setToolTipText("Integer format only");
		txtEg_1.setText("e.g 2");
		txtEg_1.addMouseListener(this);
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
		txtEg_2.setToolTipText("Integer format only");
		txtEg_2.setText("e.g 0");
		txtEg_2.addMouseListener(this);
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

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource().equals(txtEx)) {
			txtEx.setText("");
		}
		
		if(e.getSource().equals(txtEg)) {
			txtEg.setText("");
		}
		
		if(e.getSource().equals(txtEg_1)) {
			txtEg_1.setText("");
		}
		
		if(e.getSource().equals(txtEg_2)) {
			txtEg_2.setText("");
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getSource().equals(txtEx)) {
			txtEx.setText("");
		}
		
		if(e.getSource().equals(txtEg)) {
			txtEg.setText("");
		}
		
		if(e.getSource().equals(txtEg_1)) {
			txtEg_1.setText("");
		}
		
		if(e.getSource().equals(txtEg_2)) {
			txtEg_2.setText("");
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {

		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		numAdultMale = txtEx.getText();
		numAdultFemale = txtEg.getText();
		numChildOver8 = txtEg_1.getText();
		numChildUnder8 = txtEg_2.getText();
		

		
		if(validateInput()) {
			
			this.familyID++;
			JOptionPane.showMessageDialog(this, "Family ID: "+familyID+" added.");
			Integer[] members = { Integer.parseInt(numAdultMale),Integer.parseInt(numAdultFemale),
					Integer.parseInt(numChildOver8), Integer.parseInt(numChildUnder8), familyID};
			families.add(members);
			
			txtEx.setText("");
			txtEg.setText("");
			txtEg_1.setText("");
			txtEg_2.setText("");
			
			if(familyID == this.numberOfFamilies) {
				JOptionPane.showMessageDialog(this, "Creating Hampers for "+familyID
						+" families");
				
				ArrayList<Family> listOfFamilies = new ArrayList<Family>();
				Iterator<Integer[]> iter = families.iterator();
				while(iter.hasNext()) {
					Integer[] memberC = iter.next();
					Family family = new Family(memberC[0],memberC[1],memberC[2],memberC[3],memberC[4]);
					listOfFamilies.add(family);
				}

				Order order = new Order(listOfFamilies);
				order.calcHampers();
				this.success = order.getPassed();
				this.frame.setVisible(false);
				if(success == true) {
					GUISuccess.success(order,this.orderNumber); 
					
				} else {
					GUIFailed.failed(this.orderNumber);
				}
			}

		}
		
	}

	private boolean validateInput() {
		boolean allInputValid = true;
		
		if(numAdultMale.isEmpty()||numAdultFemale.isEmpty()||numChildOver8.isEmpty()||numChildUnder8.isEmpty()) {
			JOptionPane.showMessageDialog(this, "You have entered empty string, " +
					"please try again");
			return false;
		}
		
		for(int i = 0; i<numAdultMale.length(); i++) {
			if((numAdultMale.charAt(i) < 48) || (numAdultMale.charAt(i) > 57)) {
				allInputValid = false;
			}
		}
		
		for(int i = 0; i<numAdultFemale.length(); i++) {
			if((numAdultFemale.charAt(i) < 48) || (numAdultFemale.charAt(i) > 57)) {
				allInputValid = false;
			}
		}
		
		for(int i = 0; i<numChildOver8.length(); i++) {
			if((numChildOver8.charAt(i) < 48) || (numChildOver8.charAt(i) > 57)) {
				allInputValid = false;
			}
		}
		
		for(int i = 0; i<numChildUnder8.length(); i++) {
			if((numChildUnder8.charAt(i) < 48) || (numChildUnder8.charAt(i) > 57)) {
				allInputValid = false;
			}
		}
		


		
		if(allInputValid == false) {
			JOptionPane.showMessageDialog(this, "Your have entered an invalid input,"
					+ " the input should be an integer format");
		} 
		

		if(((Integer.parseInt(numAdultMale) == 0) && (Integer.parseInt(numAdultFemale) == 0)
			&& (Integer.parseInt(numChildOver8) == 0) && (Integer.parseInt(numChildUnder8)) == 0)) {
			JOptionPane.showMessageDialog(this, "The family should conatains at least one "
					+ "family member");
			return false;
		}

		return allInputValid;
	}
}
