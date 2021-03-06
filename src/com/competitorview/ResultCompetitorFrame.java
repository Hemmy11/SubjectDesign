package com.competitorview;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
/**
 * 
 * 选手查询结果界面
 *
 */
public class ResultCompetitorFrame extends JPanel{
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
	public JButton getCommitButton() {
		return commitButton;
	}
	public void setCommitButton(JButton commitButton) {
		this.commitButton = commitButton;
	}
	private JScrollPane scrollPane;
    private JTable table;
    private	JComboBox comboBox ;//选择查询种类的下拉框
    private JButton commitButton;//查询按钮
    
	public ResultCompetitorFrame(){
    	 this.setBorder(new EmptyBorder(5,5,5,5));
    	 this.setLayout(new BorderLayout(0,0));
    	 scrollPane=new JScrollPane();
    	 this.add(scrollPane,BorderLayout.CENTER);
         comboBox = new JComboBox();
         comboBox.addItem("对战结果");
         comboBox.addItem("比赛排名");
         comboBox.addItem("满分奖");
    	 comboBox.setBounds(10, 0, 80, 21);
    	 this.add(comboBox);
    	 
    	 commitButton=new JButton("查询");
    	 commitButton.setBounds(100,0,80,20);
    	 commitButton.setBackground(Color.LIGHT_GRAY);
    	 this.add(commitButton);
    	 commitButton.addActionListener(new ActionListener(){ //查找按钮的事件监听,更新table的数据
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
    	 this.setVisible(true);
     }
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

}
