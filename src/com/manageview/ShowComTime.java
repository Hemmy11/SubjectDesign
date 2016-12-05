package com.manageview;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
/**
 * ��Ӧ�ڹ���Ա����Ĳ�ѯ��ս��Ϣ
 */
public class ShowComTime extends JPanel{
    private JScrollPane scrollPane;
    private JTable table;
	public ShowComTime(){
    	 this.setBorder(new EmptyBorder(5,5,5,5));
    	 this.setLayout(new BorderLayout(0,0));
    	 scrollPane=new JScrollPane();
    //	 this.add(scrollPane,BorderLayout.CENTER);
 		
 		JComboBox comboBox = new JComboBox();
 		comboBox.setBounds(81, 10, 117, 21);
 		comboBox.addItem("2016-11-27");
 		comboBox.addItem("2016-11-28");
 		comboBox.addItem("2016-11-29");
 		comboBox.addItem("2016-11-30");
 		comboBox.addItem("2016-12-01");
 		this.add(comboBox);
 		
 		JLabel comTime = new JLabel("\u6BD4\u8D5B\u65F6\u95F4\uFF1A");
 		comTime.setFont(new Font("΢���ź�", Font.PLAIN, 14));
 		comTime.setBounds(10, 12, 81, 15);
 		this.add(comTime);
 		
    	 
    	 String[] paramter={"����ʱ��","����ѡ��","����ѡ��","ʤ��","�ȷ�����"}; //��ͷ����
    	 
    	 String[] s1 = { "2016-10-30", "Сǿ", "�ܶ�","Сǿ","110:90"};
         String[] s2 = {"2016-10-30", "Сǿ", "�ܶ�","Сǿ","105:95"};
         String[] s3 = {"2016-10-30", "Сǿ", "�ܶ�","Сǿ","220:90"};
         String[] s4 = { "2016-10-30", "Сǿ", "�ܶ�","Сǿ","225:105"};
         String[] s5 = { "2016-10-30", "Сǿ", "�ܶ�","δ��ʼ","δ��ʼ"};
         String[] s6 = {"2016-10-30", "Сǿ", "�ܶ�","δ��ʼ","δ��ʼ"};
         String[] s7 = { "2016-10-30", "Сǿ", "�ܶ�","δ��ʼ","δ��ʼ"};
         String[] s8 = {"2016-10-30", "Сǿ", "�ܶ�","δ��ʼ","δ��ʼ"};
         String[] s9 = {"2016-10-30", "Сǿ", "�ܶ�","δ��ʼ","δ��ʼ"};
         String[] s10 = {"2016-10-30", "Сǿ", "�ܶ�","δ��ʼ","δ��ʼ"};
    	 String[][] info={s1,s2,s3,s4,s5,s6,s7,s8,s9,s10};
    	
    	 
    	 table=new JTable(info,paramter); 
    	 scrollPane.setViewportView(table);
    	 this.setBounds(5, 86, 434, 175);
    	 this.add(scrollPane);
    //	 this.add(table);
    	 this.setVisible(true);
     }
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

}