package com.competitorview;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ShowInfoPanel extends JPanel {
	
	
	public ShowInfoPanel(){
		 init();
		 
	}
	public void init(){
	JLabel nameLabel = new JLabel("\u59D3\u540D\uFF1A");
    nameLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
    nameLabel.setBounds(85, 10, 59, 29);
    
    JLabel sexLabel = new JLabel("\u6027\u522B\uFF1A");
    sexLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
    sexLabel.setBounds(85, 49, 54, 15);
    
    JLabel ageLabel = new JLabel("\u5E74\u9F84\uFF1A");
    ageLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
    ageLabel.setBounds(85, 85, 54, 15);
    
    JLabel IDLabel = new JLabel("\u7F16\u53F7\uFF1A");
    IDLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
    IDLabel.setBounds(85, 121, 54, 15);
    
    JLabel addressLabel = new JLabel("\u5730\u5740\uFF1A");
    addressLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
    addressLabel.setBounds(85, 158, 54, 15);
    
    this.add(nameLabel);
    this.add(sexLabel);
    this.add(ageLabel);
    this.add(IDLabel);
    this.add(addressLabel);
	}
}
