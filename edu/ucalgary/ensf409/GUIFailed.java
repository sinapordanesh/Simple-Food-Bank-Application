/**
 @author Jinsu Kwak <a href="mailto:jinsu.kwak@ucalgary.ca">
 jinsu.kwak@ucalgary.ca</a>
 @UCID 30097737
 @version 1.0
 @since 1.0
 */

// descre
/// discrptive

package edu.ucalgary.ensf409;
import java.awt.EventQueue;

//more discrptive message, ex) we are not enough calories due to WG or Protein... ext
//due to insusficcet inventory
//

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JPanel;

public class GUIFailed extends JFrame implements ActionListener, MouseListener {

	private JFrame frame;
	private boolean on;
	private int orderNumber;

	/**
	 * Launch the application.
	 * @param orderNumber 
	 */
	public static void failed(int orderNumber) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIFailed window = new GUIFailed(orderNumber);
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
	public GUIFailed(int orderNumber) {
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
		frame.setTitle("Sorry :(");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("We are Sorry! :(");
		lblNewLabel_1.setFont(new Font("Helvetica", Font.BOLD, 34));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(149, 62, 345, 39);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("FoodBank 409");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lantinghei TC", Font.PLAIN, 20));
		lblNewLabel.setBounds(6, 6, 141, 29);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(6, 32, 648, 2);
		frame.getContentPane().add(panel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("we don't have enough foods to complete your order");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Lantinghei TC", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(54, 104, 530, 40);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JButton btnTryAgain = new JButton("Try Again");
		btnTryAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int nextOrder = orderNumber+1;
				frame.setVisible(false);
				GUIStart.start(nextOrder);	
			}
		});
		btnTryAgain.setFont(new Font("Lantinghei TC", Font.BOLD, 13));
		btnTryAgain.setBackground(Color.LIGHT_GRAY);
		btnTryAgain.setBounds(449, 224, 91, 62);
		frame.getContentPane().add(btnTryAgain);
		
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Lantinghei TC", Font.BOLD, 13));
		btnExit.setBackground(Color.LIGHT_GRAY);
		btnExit.setBounds(542, 224, 91, 62);
		frame.getContentPane().add(btnExit);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
		
	}
	
}
