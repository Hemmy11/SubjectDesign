package com.competitorview;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
/**
 * 
 * ѡ�ֲ�ѯ�������
 *
 */
public class ResultCompetitorFrame extends JPanel{
    private JScrollPane scrollPane;
    private JTable table;
    private	JComboBox comboBox ;
	public ResultCompetitorFrame(){
    	 this.setBorder(new EmptyBorder(5,5,5,5));
    	 this.setLayout(new BorderLayout(0,0));
    	 scrollPane=new JScrollPane();
    	 this.add(scrollPane,BorderLayout.CENTER);
         comboBox = new JComboBox();
         comboBox.addItem("��ս���");
         comboBox.addItem("��������");
         comboBox.addItem("���ֽ�");
    	 comboBox.setBounds(10, 0, 80, 21);
    	 this.add(comboBox);
    	 
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
    	 this.setVisible(true);
     }
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

}
