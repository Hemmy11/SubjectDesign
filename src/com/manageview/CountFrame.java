package com.manageview;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hemmy.scoringSystem.UI.ScoringPage;
//比赛计分按钮出现的界面
public class CountFrame extends JFrame{
	private JPanel panel;
    private JLabel label;
    private JComboBox timeList;//选择比赛时间的下拉框
    private JComboBox comList;//当前计分的选手
    private JButton button;//进入计分的按钮
    private JLabel dataLabel;
    private JLabel comLabel;
    private JLabel comName;
    private JComboBox comNameList; //比赛名字选择的下拉框
    public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

	public JComboBox getTimeList() {
		return timeList;
	}

	public void setTimeList(JComboBox timeList) {
		this.timeList = timeList;
	}

	public JComboBox getComList() {
		return comList;
	}

	public void setComList(JComboBox comList) {
		this.comList = comList;
	}

	public JButton getButton() {
		return button;
	}

	public void setButton(JButton button) {
		this.button = button;
	}

	public JLabel getDataLabel() {
		return dataLabel;
	}

	public void setDataLabel(JLabel dataLabel) {
		this.dataLabel = dataLabel;
	}

	public JLabel getComLabel() {
		return comLabel;
	}

	public void setComLabel(JLabel comLabel) {
		this.comLabel = comLabel;
	}

	public JLabel getComName() {
		return comName;
	}

	public void setComName(JLabel comName) {
		this.comName = comName;
	}

	public JComboBox getComNameList() {
		return comNameList;
	}

	public void setComNameList(JComboBox comNameList) {
		this.comNameList = comNameList;
	}


    
	public CountFrame()  {
		initialize();
		this.setVisible(true);
		this.setResizable(false);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setBounds(300, 200, 450, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
	    panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		this.getContentPane().add(panel);
		panel.setLayout(null);
		
	    label = new JLabel("\u4FDD\u9F84\u7403\u6BD4\u8D5B\u8BA1\u5206");
		label.setBounds(150, 22, 160, 28);
		label.setFont(new Font("微软雅黑", Font.PLAIN, 22));
		panel.add(label);
		
	    timeList = new JComboBox();
		timeList.setBounds(227, 121, 120, 21);
		timeList.addItem("2016-12-01");
		timeList.addItem("2016-12-02");
		panel.add(timeList);
		
	    comList = new JComboBox();
		comList.setBounds(227, 174, 120, 21);
		comList.addItem("A");
		comList.addItem("B");
		panel.add(comList);
		
	    button = new JButton("\u8FDB\u5165\u8BA1\u5206");
		button.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		button.setBounds(170, 228, 93, 23);
		button.setBackground(Color.LIGHT_GRAY);
		button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) { //进入计分的事件监听，进入子系统
				ScoringPage scorig = new ScoringPage();
				
			}
		});
		panel.add(button);
		
	    dataLabel = new JLabel("\u8BF7\u9009\u62E9\u6BD4\u8D5B\u65E5\u671F\uFF1A");
		dataLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		dataLabel.setBounds(107, 124, 139, 15);
		panel.add(dataLabel);
		
		comLabel = new JLabel("\u8BF7\u9009\u62E9\u6BD4\u8D5B\u9009\u624B\uFF1A");
		comLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		comLabel.setBounds(107, 177, 139, 15);
		panel.add(comLabel);
		
		comName = new JLabel("\u8BF7\u9009\u62E9\u6BD4\u8D5B\u540D\u79F0\uFF1A");
		comName.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		comName.setBounds(107, 73, 141, 15);
		panel.add(comName);
		
	    comNameList = new JComboBox();
		comNameList.setBounds(227, 72, 120, 21);
		panel.add(comNameList);
	}
}
