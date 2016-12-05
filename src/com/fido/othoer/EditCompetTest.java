package com.fido.othoer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.manageview.InfoExitFrame;

public class EditCompetTest {

	public static void main(String[] args) {
		  InfoExitFrame frame=new InfoExitFrame();
		  frame.setVisible(true);
		  frame.getYesButton().addActionListener(new ActionListener(){
			  @Override
			public void actionPerformed(ActionEvent e) {
				     
				
			}
		  });

	}

}
