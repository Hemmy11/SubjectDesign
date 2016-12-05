package com.competitorview;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.mainview.RadioPanel;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPasswordField;

public class RegisterFrame {

	private JFrame frame;
	private JTextField nametextField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterFrame window = new RegisterFrame();
					window.frame.setVisible(true);
					window.frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RegisterFrame() {
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
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel nameLabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		nameLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		nameLabel.setBounds(120, 105, 74, 17);
		panel.add(nameLabel);
		
		nametextField = new JTextField();
		nametextField.setBounds(190, 104, 141, 21);
		panel.add(nametextField);
		nametextField.setColumns(10);
	
		
		JButton yesButton = new JButton("\u786E\u5B9A");
		yesButton.setBackground(Color.LIGHT_GRAY);
		yesButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		yesButton.setBounds(120, 206, 93, 23);
		panel.add(yesButton);
		
		JLabel titleLabel = new JLabel("\u9009\u624B\u6CE8\u518C");
		titleLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 22));
		titleLabel.setBounds(190, 44, 110, 27);
		panel.add(titleLabel);
	   	ImageIcon icon = new ImageIcon("D:\\ËØ²Ä\\22.jpg");
	    icon.setImage(icon.getImage().getScaledInstance(icon.getIconWidth(),
	    icon.getIconHeight(), Image.SCALE_DEFAULT));
		
		JButton button = new JButton("\u53D6\u6D88");
		button.setBackground(Color.LIGHT_GRAY);
		button.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(250, 206, 93, 23);
		panel.add(button);
		
		JLabel passwordLabel = new JLabel("\u5BC6   \u7801\uFF1A");
		passwordLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		passwordLabel.setBounds(120, 144, 74, 15);
		panel.add(passwordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(190, 142, 141, 21);
		panel.add(passwordField);
		
	}
}
