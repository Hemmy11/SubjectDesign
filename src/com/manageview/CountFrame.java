package com.manageview;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class CountFrame extends JFrame{

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public CountFrame()  {
		initialize();
		this.setVisible(true);
		this.setResizable(false);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setBounds(300, 200, 450, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		this.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("\u4FDD\u9F84\u7403\u6BD4\u8D5B\u8BA1\u5206");
		label.setBounds(150, 22, 160, 28);
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 22));
		panel.add(label);
		
		JComboBox timeList = new JComboBox();
		timeList.setBounds(227, 98, 120, 21);
		timeList.addItem("2016-12-01");
		timeList.addItem("2016-12-02");
		panel.add(timeList);
		
		JComboBox comList = new JComboBox();
		comList.setBounds(227, 149, 120, 21);
		comList.addItem("A");
		comList.addItem("B");
		panel.add(comList);
		
		JButton button = new JButton("\u8FDB\u5165\u8BA1\u5206");
		button.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		button.setBounds(172, 204, 93, 23);
		button.setBackground(Color.LIGHT_GRAY);
		panel.add(button);
		
		JLabel dataLabel = new JLabel("\u8BF7\u9009\u62E9\u6BD4\u8D5B\u65E5\u671F\uFF1A");
		dataLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		dataLabel.setBounds(107, 101, 139, 15);
		panel.add(dataLabel);
		
		JLabel comLabel = new JLabel("\u8BF7\u9009\u62E9\u6BD4\u8D5B\u9009\u624B\uFF1A");
		comLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		comLabel.setBounds(107, 152, 139, 15);
		panel.add(comLabel);
	}
}
