package com.manageview;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
/**
 * 
 * ��ѯ�������
 * 
 *
 */
public class ResultFrame extends JPanel{
    private JScrollPane scrollPane;
    private JTable table;
    private	JComboBox comboBox ;//ѡ���������
    private JComboBox comboBox2;//ѡ��Ҫ��ѯ�Ľ�������
    private JButton btnNewButton;//ȷ�����Ұ�ť
	public ResultFrame(){
    	 this.setBorder(new EmptyBorder(5,5,5,5));
    	 this.setLayout(new BorderLayout(0,0)); scrollPane=new JScrollPane();
    	 this.add(scrollPane,BorderLayout.CENTER);
         comboBox = new JComboBox();
         comboBox.addItem("����������1");
         comboBox.addItem("����������2");
    	 comboBox.setBounds(10, 7, 90, 21);
    	 this.add(comboBox);
   	 
    	 comboBox2 = new JComboBox();
         comboBox2.addItem("��������");
         comboBox2.addItem("���ֽ�");
    	 comboBox2.setBounds(117, 7, 90, 21);
    	 this.add(comboBox2);
    	 
 		btnNewButton = new JButton("\u786E\u5B9A\u67E5\u627E");
 		btnNewButton.setFont(new Font("΢���ź�", Font.PLAIN, 13));
 		btnNewButton.setBounds(221, 7, 99, 21);
 		btnNewButton.setBackground(Color.LIGHT_GRAY);
 		this.add(btnNewButton);
 		btnNewButton.addActionListener(new ActionListener(){//ȷ�����Ұ�ť���¼�����������table����
 			@Override
 			public void actionPerformed(ActionEvent e) {
 				   
 				
 			}
 		});
    	 
    	 
    	 //������ʾ��������
    	 String[] paramter={"ѡ������","��������"}; //��ͷ����
    	 String[] s1 = { "С��", "1"};
         String[] s2 = { "С��", "2"};
         String[] s3 = { "С��", "3"};
         String[] s4 = { "С��", "4"};
         String[] s5 = { "С��", "5"};
         String[] s6 = { "С��", "6"};
         String[] s7 = { "С��", "7"};
         String[] s8 = { "С��", "8"};
         String[] s9 = { "С��", "9"};
         String[] s10 = {"С��", "10"};
    	 String[][] info={s1,s2,s3,s4,s5,s6,s7,s8,s9,s10};
      	 table=new JTable(info,paramter); 
      	 
      	 
    	 scrollPane.setViewportView(table);
    	 this.setBounds(5, 86, 434, 175);
    	 this.add(scrollPane);
    	 this.setVisible(true);  	 
     }
	public JTable getTable() {
		return table;
	}
	public void setTable(JTable table) {
		this.table = table;
	}
	public JComboBox getComboBox() {
		return comboBox;
	}
	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}
	public JComboBox getComboBox2() {
		return comboBox2;
	}
	public void setComboBox2(JComboBox comboBox2) {
		this.comboBox2 = comboBox2;
	}
	public JButton getBtnNewButton() {
		return btnNewButton;
	}
	public void setBtnNewButton(JButton btnNewButton) {
		this.btnNewButton = btnNewButton;
	}
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

}