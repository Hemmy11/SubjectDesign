package com.manageview;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
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
    private	JComboBox comboBox ;
    private JComboBox comboBox2;
    private JButton btnNewButton;
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
    	
         JScrollBar bar=scrollPane.getVerticalScrollBar();
//         bar.setUI(UIManager.setLookAndFeel(new com.sun.java.swing.plaf.windows.WindowsLookAndFeel());

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