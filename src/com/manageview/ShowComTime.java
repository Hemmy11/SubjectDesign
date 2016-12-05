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
 * 对应于管理员界面的查询对战信息
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
 		comTime.setFont(new Font("微软雅黑", Font.PLAIN, 14));
 		comTime.setBounds(10, 12, 81, 15);
 		this.add(comTime);
 		
    	 
    	 String[] paramter={"比赛时间","对阵选手","对阵选手","胜方","比分详情"}; //表头列名
    	 
    	 String[] s1 = { "2016-10-30", "小强", "熊二","小强","110:90"};
         String[] s2 = {"2016-10-30", "小强", "熊二","小强","105:95"};
         String[] s3 = {"2016-10-30", "小强", "熊二","小强","220:90"};
         String[] s4 = { "2016-10-30", "小强", "熊二","小强","225:105"};
         String[] s5 = { "2016-10-30", "小强", "熊二","未开始","未开始"};
         String[] s6 = {"2016-10-30", "小强", "熊二","未开始","未开始"};
         String[] s7 = { "2016-10-30", "小强", "熊二","未开始","未开始"};
         String[] s8 = {"2016-10-30", "小强", "熊二","未开始","未开始"};
         String[] s9 = {"2016-10-30", "小强", "熊二","未开始","未开始"};
         String[] s10 = {"2016-10-30", "小强", "熊二","未开始","未开始"};
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