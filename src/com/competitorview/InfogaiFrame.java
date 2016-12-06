package com.competitorview;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.mainview.RadioPanel;

/**
 * 
 * Ñ¡ÊÖÐÞ¸ÄÐÅÏ¢
 *
 */
public class InfogaiFrame extends JFrame{
	private JTextField nametextField;
	private JTextField addresstextField;
	public JFrame getFrame(){
		return this;
	}

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public InfogaiFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setBounds(300, 300, 450, 300);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		this.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel nameLabel = new JLabel("\u59D3\u540D\uFF1A");
		nameLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		nameLabel.setBounds(120, 48, 48, 17);
		panel.add(nameLabel);
		
		nametextField = new JTextField();
		nametextField.setBounds(178, 47, 151, 21);
		panel.add(nametextField);
		nametextField.setColumns(10);
		nametextField.setText("Ö£º£Ãô");
		nametextField.setEditable(false);
		
		JLabel sexLabel = new JLabel("ÐÔ±ð£º");
		sexLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		sexLabel.setBounds(120, 103, 54, 15);
		panel.add(sexLabel);
		
		RadioPanel rp=new RadioPanel();
		rp.setBounds(178,100,151,27);
		JRadioButton man=new JRadioButton("ÄÐ");
		man.setBounds(18, 0, 43, 25);
		man.setSelected(true);
		man.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		JRadioButton lady=new JRadioButton("Å®");
		lady.setBounds(86, 0, 42, 25);
		lady.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		lady.setEnabled(false);;
		rp.setLayout(null);
		rp.add(man);
		rp.add(lady);
		rp.getBtnGroup().add(man);
		rp.getBtnGroup().add(lady);
		panel.add(rp);
		
		JLabel ageLabel = new JLabel("\u5E74\u9F84\uFF1A");
		ageLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		ageLabel.setBounds(120, 150, 54, 15);
		panel.add(ageLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		comboBox.setBounds(178, 150, 151, 17);
		
		comboBox.addItem("25");
		panel.add(comboBox);
		
		JLabel addreLabel = new JLabel("\u5730\u5740\uFF1A");
		addreLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		addreLabel.setBounds(120, 200, 103, 15);
		panel.add(addreLabel);
		
		addresstextField = new JTextField();
		addresstextField.setBounds(178, 200, 151, 21);
		panel.add(addresstextField);
		addresstextField.setColumns(10);
		addresstextField.setText("G5-504D");
		
//		JLabel photoLabel = new JLabel("\u7167\u7247\uFF1A");
//		photoLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
//		photoLabel.setBounds(120, 182, 54, 15);
//		panel.add(photoLabel);
//		
//		JButton photoButton = new JButton("\u7167\u7247\u9009\u62E9");
//		photoButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
//		photoButton.setBounds(257, 188, 93, 23);
//		photoButton.setBackground(Color.LIGHT_GRAY);
//		panel.add(photoButton);
		
		JButton yesButton = new JButton("\u786E\u5B9A");
		yesButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		yesButton.setBounds(120, 234, 93, 23);
		yesButton.setBackground(Color.LIGHT_GRAY);
		
		panel.add(yesButton);
		yesButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) { //ÐÞ¸ÄÐÅÏ¢µÄÈ·¶¨°´Å¥
		        JOptionPane.showMessageDialog(null,"ÐÞ¸Ä³É¹¦£¡");
		
			}
		});
		
		JLabel titleLabel = new JLabel("Ñ¡ÊÖÐÅÏ¢ÐÞ¸Ä");
		titleLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 22));
		titleLabel.setBounds(178, 10, 151, 27);
		panel.add(titleLabel);
		
//		JLabel photoShowLabel = new JLabel("");
//		photoShowLabel.setBounds(178, 172, 69, 52);
//	   	ImageIcon icon = new ImageIcon("D:\\ËØ²Ä\\22.jpg");
//	    icon.setImage(icon.getImage().getScaledInstance(icon.getIconWidth(),
//	    icon.getIconHeight(), Image.SCALE_DEFAULT));
//	    photoShowLabel.setIcon(icon);
//		panel.add(photoShowLabel);
//		
		JButton button = new JButton("\u53D6\u6D88");
		button.setBackground(Color.LIGHT_GRAY);
		button.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //È¡Ïû°´Å¥
				        getFrame().setVisible(false);
			}
		});
		button.setBounds(257, 234, 93, 23);
		panel.add(button);
		
	}
}