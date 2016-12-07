package com.manageview;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 * 选手录入按钮之后的界面
 *
 */
public class AddCount extends JPanel{
	public JComboBox getComboBox() {
		return comboBox;
	}
	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}
	public JLabel getSelectLabel() {
		return selectLabel;
	}
	public void setSelectLabel(JLabel selectLabel) {
		this.selectLabel = selectLabel;
	}
	public JButton getAddButton() {
		return addButton;
	}
	public void setAddButton(JButton addButton) {
		this.addButton = addButton;
	}
	public JLabel getCountLabel() {
		return countLabel;
	}
	public void setCountLabel(JLabel countLabel) {
		this.countLabel = countLabel;
	}
	public JButton getComTimeButton() {
		return comTimeButton;
	}
	public void setComTimeButton(JButton comTimeButton) {
		this.comTimeButton = comTimeButton;
	}
	public JButton getYesButton() {
		return yesButton;
	}
	public void setYesButton(JButton yesButton) {
		this.yesButton = yesButton;
	}
	public JLabel getNewcomLabel() {
		return newcomLabel;
	}
	public void setNewcomLabel(JLabel newcomLabel) {
		this.newcomLabel = newcomLabel;
	}
	private JComboBox comboBox; //选择比赛的名称的下拉框
	private JLabel selectLabel;
	private JButton addButton;//录入信息按钮
	private JLabel countLabel;//显示已录入人数
	private JButton comTimeButton;//生成日程表按钮
	private JButton yesButton;//确定创建比赛的按钮
	private JTextField comName;//创建比赛时输入比赛名
	public JTextField getComName() {
		return comName;
	}
	public void setComName(JTextField comName) {
		this.comName = comName;
	}
	private JLabel newcomLabel;
      public AddCount(){
    	  init();
      }
       public void init(){
    		comboBox = new JComboBox();
    		comboBox.setBounds(96, 30, 110, 21);
    		this.add(comboBox);
    		
    		 selectLabel = new JLabel("\u8BF7\u9009\u62E9\u6BD4\u8D5B\uFF1A");
    		selectLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
    		selectLabel.setBounds(10, 30, 95, 15);
    		this.add(selectLabel);
    		
    	     addButton = new JButton("\u5F55\u5165\u4FE1\u606F");
    		addButton.setBackground(Color.LIGHT_GRAY);
    		addButton.setFont(new Font("微软雅黑", Font.PLAIN, 13));
    		addButton.setBounds(215, 29, 90, 23);
    		this.add(addButton);
    		addButton.addActionListener(new ActionListener(){
    			@Override
    			public void actionPerformed(ActionEvent e) { //按下了录入信息，弹出录入选手信息的详细界面
    				InfoExitFrame ief=new InfoExitFrame();
    				ief.setVisible(true);
    				ief.setResizable(false);
    				ief.setDefaultCloseOperation(ief.HIDE_ON_CLOSE);
    				
    			}
    		});
    		
    	    newcomLabel = new JLabel("\u521B\u5EFA\u65B0\u7684\u6BD4\u8D5B\uFF1A");
    		newcomLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
    		newcomLabel.setBounds(10, 109, 110, 15);
    		this.add(newcomLabel);
    		
    		
    	    comName = new JTextField();
    		comName.setBounds(111, 109, 118, 21);
    		this.add(comName);
    		comName.setColumns(10);
    		
    		yesButton = new JButton("\u786E\u5B9A\u521B\u5EFA");
    		yesButton.setFont(new Font("微软雅黑", Font.PLAIN, 13));
    		yesButton.setBounds(246, 108, 90, 23);
    		yesButton.setBackground(Color.LIGHT_GRAY);
    		this.add(yesButton);
    		yesButton.addActionListener(new ActionListener(){
    			@Override
    			public void actionPerformed(ActionEvent e) { //输入比赛名，创建比赛的事件监听
    				 int n=JOptionPane.showConfirmDialog(null, "创建成功","创建信息",JOptionPane.DEFAULT_OPTION);
    				 if(n==JOptionPane.YES_OPTION){
    					       getComName().setText(null);
    				 }

    				
    			}
    		});
    		
    		
    		 comTimeButton = new JButton("\u751F\u6210\u65E5\u7A0B\u8868");
    		comTimeButton.setFont(new Font("微软雅黑", Font.PLAIN, 13));
    		comTimeButton.setBounds(314, 29, 110, 23);
    		comTimeButton.setBackground(Color.LIGHT_GRAY);
    		this.add(comTimeButton);
    		comTimeButton.addActionListener(new ActionListener(){
    			@Override
    			public void actionPerformed(ActionEvent e) { //生成日程表的事件监听
    				Object[] possibleValues = { "循环赛制", "淘汰赛制"};
    				Object selectedValue = JOptionPane.showInputDialog(null, 
    				"请选择赛制", "选择赛制种类",
    				JOptionPane.INFORMATION_MESSAGE, null,
    				possibleValues, possibleValues[0]);
    				if(selectedValue==null){
    					return;
    				}
    				else{  

        				if(selectedValue.equals(possibleValues[0])){ //循环赛制
        
        				}
        				else if(selectedValue.equals(possibleValues[1])){//淘汰赛制
 
        				}
        				JOptionPane.showMessageDialog(null,"生成日程表成功！");
                    }
    				
    				
    				
    			}
    		});
    		
    		 countLabel = new JLabel("\u5DF2\u5F55\u5165\u4EBA\u6570\uFF1A\u00D7\u00D7");
    		countLabel.setFont(new Font("微软雅黑", Font.PLAIN, 13));
    		countLabel.setBounds(10, 65, 138, 15);
    		this.add(countLabel);

       }
}
