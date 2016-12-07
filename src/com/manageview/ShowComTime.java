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
 * 对应于管理员界面的查询对战信息
 * 查询日程表
 */
public class ShowComTime extends JPanel{
	private JScrollPane scrollPane;
    private JTable table;
    private JComboBox comName;//选择比赛名字的下拉框
    private JComboBox comboBox;//选择比赛时间的下拉框
    private JLabel comTime;
    private JButton yesFindButton;//确定查找的按钮
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
  		comName.addItem("A比赛");
  		comName.addItem("B比赛");
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
 		comTime.setFont(new Font("微软雅黑", Font.PLAIN, 14));
 		comTime.setBounds(100, 12, 81, 15);
 		this.add(comTime);
 		
 	    yesFindButton=new JButton("查找");
 		yesFindButton.setBounds(300,10,80,22);
 		yesFindButton.setFont(new Font("微软雅黑", Font.PLAIN, 12));
 		yesFindButton.setBackground(Color.LIGHT_GRAY);
 		this.add(yesFindButton);
 		yesFindButton.addActionListener(new ActionListener(){//查找按钮的事件监听，更新table里的数据
 			@Override
 			public void actionPerformed(ActionEvent e) {
 				
 				
 			}
 		});
 		
    	 
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
    	 this.setVisible(true);
     }
	
	
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

}