package com.manageview;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

/*
 * ��Ӧ����Ա����Ĳ�ѯ�����ť
 */
public class ShowComInfo extends JPanel {
    private JScrollPane scrollPane;
    private JTable table;
	public ShowComInfo(){
    	 this.setBorder(new EmptyBorder(5,5,5,5));
    	 this.setLayout(new BorderLayout(0,0));
    	 scrollPane=new JScrollPane();
    	 this.add(scrollPane,BorderLayout.CENTER);
 		JTextField textField01 = new JTextField();
 		textField01.setBounds(88, 10, 66, 21);
 		this.add(textField01);
 		textField01.setColumns(10);
 		
 		JComboBox findcomboBox = new JComboBox();
 		findcomboBox.setBounds(10, 10, 68, 21);
 		findcomboBox.addItem("����");
 		findcomboBox.addItem("���");
 		this.add(findcomboBox);
 		
 		JButton findInfoButton = new JButton("\u67E5\u627E");
 		findInfoButton.setBounds(164, 9, 73, 23);
 		findInfoButton.setBackground(Color.LIGHT_GRAY);
 		this.add(findInfoButton);
    	
 		
    	 Object [] paramter={"����","���","�Ա�","����","��ַ"}; //��ͷ����

    	 
    	 
    	 Object [] s1 = { "С��", "213213","��", "19","504b"};
         Object [] s2 = { "С��", "142321", "Ů","20","504b"};
         Object [] s3 = { "С��", "213213", "��","19","504b"};
         Object [] s4 = { "С��", "142321", "��","20","504b"};
         Object [] s5 = { "С��", "213213", "��","19","504b"};
         Object [] s6 = { "С��", "142321", "Ů","20","504b"};
         Object [] s7 = { "С��", "213213", "��","19","504b"};
         Object [] s8 = { "С��", "142321", "��","20","504b"};
         Object [] s9 = { "С��", "213213", "Ů","19","504b"};
         Object [] s10 = { "С��", "142321", "��","20","504b"};
    	 Object [][] info={s1,s2,s3,s4,s5,s6,s7,s8,s9,s10};
    	 
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