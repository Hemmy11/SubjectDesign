package com.mainview;


/**
 * ���ڵ�¼����ĵ�ѡ�����
 * 
 */

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class RadioPanel extends JPanel{
	private ButtonGroup btnGroup;
	public ButtonGroup getBtnGroup() {
		return btnGroup;
	}
	public void setBtnGroup(ButtonGroup btnGroup) {
		this.btnGroup = btnGroup;
	}
	public RadioPanel() {
				
		btnGroup=new ButtonGroup();
		
		
	}
	

}
