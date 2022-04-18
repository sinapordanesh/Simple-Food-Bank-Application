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
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
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
	private int familyId = 1;
	private Order order;
	private TextOutput orderInfo;
	private int orderNumber;
	private ArrayList<Family> families = new ArrayList<Family>();


	/**
	 * Launch the application.
	 */
	public static void success(Order order, int orderNumber) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUISuccess window = new GUISuccess(order, orderNumber);
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
	public GUISuccess(Order order, int orderNumber) {
		this.order = order;
		this.orderNumber = orderNumber;
		this.orderInfo = new TextOutput(order);
		this.families = order.getFamilies();
		String outputFileName = String.format("Order_%d.txt", orderNumber);
		orderInfo.generateFile(outputFileName);
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
				frame.setVisible(false);
				int nextOrder = orderNumber+1;
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
				System.exit(0);;
			}
		});
		
		btnExit.setFont(new Font("Lantinghei TC", Font.BOLD, 13));
		btnExit.setBackground(Color.LIGHT_GRAY);
		btnExit.setBounds(542, 224, 91, 62);
		frame.getContentPane().add(btnExit);
		
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(255, 255, 255));
		textArea.setFont(new Font("Lantinghei TC", Font.PLAIN, 10));
		textArea.setBounds(20, 105, 405, 181);
		frame.getContentPane().add(textArea);
		textArea.setEditable(false);
		
		
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setUnitIncrement(1);		
		class MyAdjustmentListner implements AdjustmentListener {

			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				int numOfFamilies = families.size();
				String displayOutput = "";
				
				if(familyId <= numOfFamilies) {
					displayOutput = "Order for Family ID: " + familyId + "\n\n";
					Family currentFamily = families.get(familyId-1);
					ArrayList<Food> familyFoods = currentFamily.getHamper().getFoodItems();
					int foodCount = 0;
					for(Food food: familyFoods) {
						if(foodCount < 9) {
							displayOutput = displayOutput +"Food ID: "+food.getItemId()+"\t\t"+
								"Food: "+food.getName()+"\n";
								foodCount++;
									
						} else {
							displayOutput = displayOutput + "    ...\t\t       ...\n";
						}

					}
					familyId++;
				} else {
					displayOutput = "\n"
							+ "------------------------ End of the Order Form ------------------------";
					familyId = 1;
				}
				
				textArea.setText(displayOutput);

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
