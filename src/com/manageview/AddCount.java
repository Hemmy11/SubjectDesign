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

import com.fido.table.TestTable;
/**
 * 
 * 选手录入
 *
 */
public class AddCount extends JPanel{
	private JComboBox comboBox;
	private JLabel selectLabel;
	private JButton addButton;
	private JLabel countLabel;
	private JButton comTimeButton;
	private JButton yesButton;
	private JTextField comName;
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
    			public void actionPerformed(ActionEvent e) { //按下了录入信息
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
    			public void actionPerformed(ActionEvent e) {
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
    			public void actionPerformed(ActionEvent e) {
    				Object[] possibleValues = { "循环赛制", "淘汰赛制"};
    				Object selectedValue = JOptionPane.showInputDialog(null, 
    				"请选择赛制", "选择赛制种类",
    				JOptionPane.INFORMATION_MESSAGE, null,
    				possibleValues, possibleValues[0]);
    				if(selectedValue==null){
    					return;
    				}
    				else{   //判断是否为空，在来创建对象，不然覆盖界面

        				if(selectedValue.equals(possibleValues[0])){
        
        				}
        				else if(selectedValue.equals(possibleValues[1])){
 
        				}
                    }
    				
    				
    				
    			}
    		});
    		
    		 countLabel = new JLabel("\u5DF2\u5F55\u5165\u4EBA\u6570\uFF1A\u00D7\u00D7");
    		countLabel.setFont(new Font("微软雅黑", Font.PLAIN, 13));
    		countLabel.setBounds(10, 65, 138, 15);
    		this.add(countLabel);

       }
}
