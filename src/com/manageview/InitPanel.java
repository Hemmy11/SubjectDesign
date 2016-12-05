package com.manageview;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
/**
 * 
 * ����Ա��ʼ���棬��ʾѡ�ֲ�����Ϣ
 *
 */
public class InitPanel extends JPanel{
    private JScrollPane scrollPane;
    private JTable table;
	public InitPanel(){
    	 this.setBorder(new EmptyBorder(5,5,5,5));
    	 this.setLayout(new BorderLayout(0,0));
    	 scrollPane=new JScrollPane();
    	 this.add(scrollPane,BorderLayout.CENTER);
    	 
 		
 		JButton newButton = new JButton("\u751F\u6210\u6BD4\u8D5B\u65E5\u7A0B\u8868");
 		newButton.setFont(new Font("΢���ź�", Font.PLAIN, 13));
 		newButton.setBounds(301, 163, 126, 23);
 		newButton.setBackground(Color.LIGHT_GRAY);
 		this.add(newButton);
 		
 		JButton exitButton = new JButton("\u5F55\u5165\u4FE1\u606F");
 		exitButton.setFont(new Font("΢���ź�", Font.PLAIN, 13));
 		exitButton.setBounds(185, 163, 93, 23);
 		exitButton.setBackground(Color.LIGHT_GRAY);
 		this.add(exitButton);
		JLabel mcountLabel = new JLabel("\u7537\u53C2\u8D5B\u4EBA\u6570\uFF1A");
		mcountLabel.setFont(new Font("΢���ź�", Font.PLAIN, 13));
		mcountLabel.setBounds(10, 150, 90, 15);
		this.add(mcountLabel);
		
		JLabel lcountLabel = new JLabel("\u5973\u53C2\u8D5B\u4EBA\u6570\uFF1A");
		lcountLabel.setFont(new Font("΢���ź�", Font.PLAIN, 13));
		lcountLabel.setBounds(10, 170, 96, 15);
		this.add(lcountLabel);
    	 String[] paramter={"ѡ������","ѡ�ֱ��","ѡ���Ա�","ѡ������"}; //��ͷ����
    	 
    	 String[] s1 = { "С��", "213213", "��","19"};
         String[] s2 = { "С��", "142321", "��","20"};
         String[] s3 = { "С��", "213213", "��","21"};
         String[] s4 = { "С��", "142321", "��","22"};
         String[] s5 = { "С��", "213213", "��","23"};
         String[] s6 = { "С��", "142321", "��","18"};
         String[] s7 = { "С��", "213213", "��","20"};
         String[] s8 = { "С��", "142321", "��","20"};
         String[] s9 = { "С��", "213213", "��","20"};
         String[] s10 = { "С��", "142321", "��","20"};
    	 String[][] info={s1,s2,s3,s4,s5,s6,s7,s8,s9,s10};
    	
    	 
    	 table=new JTable(info,paramter); 
    	 scrollPane.setViewportView(table);
    	 this.setBounds(5, 86, 434, 175);
    	 this.setVisible(true);
     }
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

}
