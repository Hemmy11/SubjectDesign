package com.manageview;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
/**
 * ��Ӧ�ڹ���Ա����Ĳ�ѯ��ս��Ϣ
 * ��ѯ�ճ̱�
 */
public class ShowComTime extends JPanel{
	private JScrollPane scrollPane;
    private JTable table;
    private JComboBox comName;//ѡ��������ֵ�������
    private JComboBox comboBox;//ѡ�����ʱ���������
    private JLabel comTime;
    private JButton yesFindButton;//ȷ�����ҵİ�ť
    public JTable getTable() {
		return table;
	}


	public void setTable(JTable table) {
		this.table = table;
	}


	public JComboBox getComName() {
		return comName;
	}


	public void setComName(JComboBox comName) {
		this.comName = comName;
	}


	public JComboBox getComboBox() {
		return comboBox;
	}


	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}


	public JLabel getComTime() {
		return comTime;
	}


	public void setComTime(JLabel comTime) {
		this.comTime = comTime;
	}


	public JButton getYesFindButton() {
		return yesFindButton;
	}


	public void setYesFindButton(JButton yesFindButton) {
		this.yesFindButton = yesFindButton;
	}
	public ShowComTime(){		
    	 this.setBorder(new EmptyBorder(5,5,5,5));
    	 this.setLayout(new BorderLayout(0,0));
    	 scrollPane=new JScrollPane();
  	    comName =new JComboBox();
  		comName.setBounds(10,10,80,21);
  		comName.addItem("A����");
  		comName.addItem("B����");
  		this.add(comName);
 		
 	    comboBox = new JComboBox();
 		comboBox.setBounds(171, 10, 117, 21);
 		comboBox.addItem("2016-11-27");
 		comboBox.addItem("2016-11-28");
 		comboBox.addItem("2016-11-29");
 		comboBox.addItem("2016-11-30");
 		comboBox.addItem("2016-12-01");
 		this.add(comboBox);
 		
 		comTime = new JLabel("\u6BD4\u8D5B\u65F6\u95F4\uFF1A");
 		comTime.setFont(new Font("΢���ź�", Font.PLAIN, 14));
 		comTime.setBounds(100, 12, 81, 15);
 		this.add(comTime);
 		
 	    yesFindButton=new JButton("����");
 		yesFindButton.setBounds(300,10,80,22);
 		yesFindButton.setFont(new Font("΢���ź�", Font.PLAIN, 12));
 		yesFindButton.setBackground(Color.LIGHT_GRAY);
 		this.add(yesFindButton);
 		yesFindButton.addActionListener(new ActionListener(){//���Ұ�ť���¼�����������table�������
 			@Override
 			public void actionPerformed(ActionEvent e) {
 				
 				
 			}
 		});
 		
    	 
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
    	 this.setVisible(true);
     }
	
	
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

}