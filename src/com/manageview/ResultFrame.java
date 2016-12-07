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
 * 查询结果界面
 * 
 *
 */
public class ResultFrame extends JPanel{
    private JScrollPane scrollPane;
    private JTable table;
    private	JComboBox comboBox ;//选择比赛名字
    private JComboBox comboBox2;//选择要查询的奖项种类
    private JButton btnNewButton;//确定查找按钮
	public ResultFrame(){
    	 this.setBorder(new EmptyBorder(5,5,5,5));
    	 this.setLayout(new BorderLayout(0,0)); scrollPane=new JScrollPane();
    	 this.add(scrollPane,BorderLayout.CENTER);
         comboBox = new JComboBox();
         comboBox.addItem("×××比赛1");
         comboBox.addItem("×××比赛2");
    	 comboBox.setBounds(10, 7, 90, 21);
    	 this.add(comboBox);
   	 
    	 comboBox2 = new JComboBox();
         comboBox2.addItem("比赛排名");
         comboBox2.addItem("满分奖");
    	 comboBox2.setBounds(117, 7, 90, 21);
    	 this.add(comboBox2);
    	 
 		btnNewButton = new JButton("\u786E\u5B9A\u67E5\u627E");
 		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 13));
 		btnNewButton.setBounds(221, 7, 99, 21);
 		btnNewButton.setBackground(Color.LIGHT_GRAY);
 		this.add(btnNewButton);
 		btnNewButton.addActionListener(new ActionListener(){//确定查找按钮的事件监听，更新table数据
 			@Override
 			public void actionPerformed(ActionEvent e) {
 				   
 				
 			}
 		});
    	 
    	 
    	 //用于显示比赛排名
    	 String[] paramter={"选手姓名","比赛排名"}; //表头列名
    	 String[] s1 = { "小王", "1"};
         String[] s2 = { "小芳", "2"};
         String[] s3 = { "小王", "3"};
         String[] s4 = { "小芳", "4"};
         String[] s5 = { "小王", "5"};
         String[] s6 = { "小芳", "6"};
         String[] s7 = { "小王", "7"};
         String[] s8 = { "小芳", "8"};
         String[] s9 = { "小王", "9"};
         String[] s10 = {"小芳", "10"};
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