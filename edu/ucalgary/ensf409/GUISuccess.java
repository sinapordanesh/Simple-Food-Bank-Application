/**
 @author Jinsu Kwak <a href="mailto:jinsu.kwak@ucalgary.ca">
 jinsu.kwak@ucalgary.ca</a>
 @UCID 30097737
 @version 1.0
 @since 1.0
 */


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Adjustable;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;

public class GUISuccess extends JFrame implements ActionListener, MouseListener {

	private JFrame frame;
	private boolean on;
	private int familyID = 1;
	private Order order;

	/**
	 * Launch the application.
	 */
	public static void success(Order order) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUISuccess window = new GUISuccess(order);
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
	public GUISuccess(Order order) {
		this.order = order;
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
		
		JLabel lblNewLabel_1 = new JLabel("ORDER SUCCESSFUL!");
		lblNewLabel_1.setFont(new Font("Helvetica", Font.BOLD, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBounds(214, 38, 228, 39);
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
		
		JLabel lblNewLabel_1_1 = new JLabel("Order Summary:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("Lantinghei TC", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(16, 66, 122, 40);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JButton btnTryAgain = new JButton("Try Again");
		btnTryAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIStart1.start();
			}
		});
		btnTryAgain.setFont(new Font("Lantinghei TC", Font.BOLD, 13));
		btnTryAgain.setBackground(Color.LIGHT_GRAY);
		btnTryAgain.setBounds(449, 224, 91, 62);
		frame.getContentPane().add(btnTryAgain);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);;
			}
		});
		
		btnExit.setFont(new Font("Lantinghei TC", Font.BOLD, 13));
		btnExit.setBackground(Color.LIGHT_GRAY);
		btnExit.setBounds(542, 224, 91, 62);
		frame.getContentPane().add(btnExit);
		
		/*
		JLabel lblNewLabel_2 = new JLabel("Scroll down to see full detail");
		lblNewLabel_2.setFont(new Font("Lantinghei TC", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(20, 105, 405, 181);
		frame.getContentPane().add(lblNewLabel_2);
		*/
		
		/*
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(20, 105, 405, 181);
		frame.getContentPane().add(panel);
		*/
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(255, 255, 255));
		textArea.setFont(new Font("Lantinghei TC", Font.PLAIN, 13));
		textArea.setBounds(20, 105, 405, 181);
		frame.getContentPane().add(textArea);
		textArea.setEditable(false);
		
		
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setUnitIncrement(10);						//******* increment level
		class MyAdjustmentListner implements AdjustmentListener {

			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				//Adjustable source = e.getAdjustable();
				//if (e.getValueIsAdjusting()) {
				///	return;
				//}
				/*
				int type = e.getAdjustmentType();
				switch(type) {
					case AdjustmentEvent.UNIT_INCREMENT:
						familyID++;
						textArea.setText(Integer.toString(familyID)+"\n"+Integer.toString(familyID));
						break;
					case AdjustmentEvent.UNIT_DECREMENT:
						familyID--;
						textArea.setText(Integer.toString(familyID)+"\n"+Integer.toString(familyID));
						break;
				}*/

				if(e.getValue()<0) {
					familyID--;
					textArea.setText(Integer.toString(familyID)+"\n"+Integer.toString(familyID));
				} else {
					familyID++;
					textArea.setText("Order for Family ID: "+familyID+"\n\n"+
							"Fish	: "+(familyID/3)+"	Food2	: "+(familyID/4)+"\n"+
							"Apple	: "+(familyID/5)+"	Food3	: "+(familyID/2)+"\n"+
							"Orange	: "+(familyID/7)+"\n"+
							"Random	: "+(familyID/1)+"\n"+
							"Food	: "+(familyID/9)+"\n"+
							"Foood	: "+(familyID/13)+"\n"+
							"Fooood	: "+(familyID/10)+"\n");
				}


				frame.repaint();
				
			}
			
		}
		
		scrollBar.addAdjustmentListener(new MyAdjustmentListner());
		
		scrollBar.setBounds(427, 105, 15, 181);
		frame.getContentPane().add(scrollBar);
		

		
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
