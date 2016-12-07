package com.competitorview;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.mainview.RadioPanel;

/**
 * 
 * 选手修改信息，有些信息不能修改
 *
 */
public class InfogaiFrame extends JFrame{
	private JTextField nametextField;//名字输入框
	private JTextField addresstextField;//地址输入框
	private JPanel panel;
	private JLabel nameLabel;
	private JLabel sexLabel ;
	private JComboBox comboBox;//年龄下拉框
	private RadioPanel rp;//单选框组
	private JRadioButton man;//男单选框
	private JRadioButton lady;//女单选框
	private JLabel ageLabel;
	private JLabel addreLabel;
	private JButton yesButton;//确定按钮
	private JLabel titleLabel;
	private JButton cancelButton;//取消按钮
	
	
	
	
	public JTextField getNametextField() {
		return nametextField;
	}

	public void setNametextField(JTextField nametextField) {
		this.nametextField = nametextField;
	}

	public JTextField getAddresstextField() {
		return addresstextField;
	}

	public void setAddresstextField(JTextField addresstextField) {
		this.addresstextField = addresstextField;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JLabel getNameLabel() {
		return nameLabel;
	}

	public void setNameLabel(JLabel nameLabel) {
		this.nameLabel = nameLabel;
	}

	public JLabel getSexLabel() {
		return sexLabel;
	}

	public void setSexLabel(JLabel sexLabel) {
		this.sexLabel = sexLabel;
	}

	public JComboBox getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}

	public RadioPanel getRp() {
		return rp;
	}

	public void setRp(RadioPanel rp) {
		this.rp = rp;
	}

	public JRadioButton getMan() {
		return man;
	}

	public void setMan(JRadioButton man) {
		this.man = man;
	}

	public JRadioButton getLady() {
		return lady;
	}

	public void setLady(JRadioButton lady) {
		this.lady = lady;
	}

	public JLabel getAgeLabel() {
		return ageLabel;
	}

	public void setAgeLabel(JLabel ageLabel) {
		this.ageLabel = ageLabel;
	}

	public JLabel getAddreLabel() {
		return addreLabel;
	}

	public void setAddreLabel(JLabel addreLabel) {
		this.addreLabel = addreLabel;
	}

	public JButton getYesButton() {
		return yesButton;
	}

	public void setYesButton(JButton yesButton) {
		this.yesButton = yesButton;
	}

	public JLabel getTitleLabel() {
		return titleLabel;
	}

	public void setTitleLabel(JLabel titleLabel) {
		this.titleLabel = titleLabel;
	}

	public JButton getButton() {
		return cancelButton;
	}

	public void setButton(JButton button) {
		this.cancelButton = button;
	}

	public JFrame getFrame(){
		return this;
	}
    
	public InfogaiFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setBounds(300, 300, 450, 300);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		this.getContentPane().add(panel);
		panel.setLayout(null);
		
		nameLabel = new JLabel("\u59D3\u540D\uFF1A");
		nameLabel.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		nameLabel.setBounds(120, 48, 48, 17);
		panel.add(nameLabel);
		
		nametextField = new JTextField();
		nametextField.setBounds(178, 47, 151, 21);
		panel.add(nametextField);
		nametextField.setColumns(10);
		nametextField.setText("郑海敏");
		nametextField.setEditable(false);
		
		sexLabel = new JLabel("性别：");
		sexLabel.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		sexLabel.setBounds(120, 103, 54, 15);
		panel.add(sexLabel);
		
		rp=new RadioPanel();
		rp.setBounds(178,100,151,27);
		man=new JRadioButton("男");
		man.setBounds(18, 0, 43, 25);
		man.setSelected(true);
		man.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		lady=new JRadioButton("女");
		lady.setBounds(86, 0, 42, 25);
		lady.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		lady.setEnabled(false);;
		rp.setLayout(null);
		rp.add(man);
		rp.add(lady);
		rp.getBtnGroup().add(man);
		rp.getBtnGroup().add(lady);
		panel.add(rp);
		
	    ageLabel = new JLabel("\u5E74\u9F84\uFF1A");
		ageLabel.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		ageLabel.setBounds(120, 150, 54, 15);
		panel.add(ageLabel);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		comboBox.setBounds(178, 150, 151, 17);
		
		comboBox.addItem("25");
		panel.add(comboBox);
		
		addreLabel = new JLabel("\u5730\u5740\uFF1A");
		addreLabel.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		addreLabel.setBounds(120, 200, 103, 15);
		panel.add(addreLabel);
		
		addresstextField = new JTextField();
		addresstextField.setBounds(178, 200, 151, 21);
		panel.add(addresstextField);
		addresstextField.setColumns(10);
		addresstextField.setText("G5-504D");
		

		
		yesButton = new JButton("\u786E\u5B9A");
		yesButton.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		yesButton.setBounds(120, 234, 93, 23);
		yesButton.setBackground(Color.LIGHT_GRAY);
		
		panel.add(yesButton);
		yesButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) { //修改信息的确定按钮
				 int n=JOptionPane.showConfirmDialog(null, "修改成功","修改信息",JOptionPane.DEFAULT_OPTION);
				 if(n==JOptionPane.YES_OPTION){
					    getFrame().setVisible(false);
				 }
		        
		
			}
		});
		
		titleLabel = new JLabel("选手信息修改");
		titleLabel.setFont(new Font("微软雅黑", Font.PLAIN, 22));
		titleLabel.setBounds(178, 10, 151, 27);
		panel.add(titleLabel);
		
		cancelButton = new JButton("\u53D6\u6D88");
		cancelButton.setBackground(Color.LIGHT_GRAY);
		cancelButton.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //取消按钮
				        getFrame().setVisible(false);
			}
		});
		cancelButton.setBounds(257, 234, 93, 23);
		panel.add(cancelButton);
		
	}
}