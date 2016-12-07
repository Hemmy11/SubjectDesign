package com.competitorview;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.fido.table.CompetitorInfo;
import com.manageview.InfoExitFrame;
/**
 * 
 *  选手登录后的首页面
 *
 */
public class CompetitorMFrame {

	private JFrame frame;
	public JPanel getUpPanel() {
		return upPanel;
	}

	public void setUpPanel(JPanel upPanel) {
		this.upPanel = upPanel;
	}

	public JButton getExitButton() {
		return exitButton;
	}

	public void setExitButton(JButton exitButton) {
		this.exitButton = exitButton;
	}

	public JButton getFindRButton() {
		return findRButton;
	}

	public void setFindRButton(JButton findRButton) {
		this.findRButton = findRButton;
	}

	public JButton getFindCButton() {
		return findCButton;
	}

	public void setFindCButton(JButton findCButton) {
		this.findCButton = findCButton;
	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

	public JLabel getPhotoLable() {
		return photoLable;
	}

	public void setPhotoLable(JLabel photoLable) {
		this.photoLable = photoLable;
	}

	public ImageIcon getIcon() {
		return icon;
	}

	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}

	private JPanel upPanel;
	private JButton exitButton;//修改信息按钮
	private JButton findRButton;//查询结果按钮
	private JButton findCButton;//查询比赛日程按钮
	private JLabel label;
	private JLabel photoLable;//用于显示照片
	private ImageIcon icon;//图片
	
	
	
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	private CardLayout card;
	private JPanel panel;
	public CompetitorMFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		upPanel = new JPanel();
		upPanel.setBounds(0, 0, 434, 78);
		frame.getContentPane().add(upPanel);
		upPanel.setLayout(null);
		
		exitButton = new JButton("\u4FEE\u6539\u4FE1\u606F");
		exitButton.setBackground(Color.LIGHT_GRAY);
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //修改信息的事件监听
				InfogaiFrame ief=new InfogaiFrame();
                ief.setVisible(true);
                ief.setResizable(false);
                ief.setDefaultCloseOperation(ief.HIDE_ON_CLOSE);
				
			}
		});
		exitButton.setBounds(10, 40, 88, 27);
		exitButton.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		upPanel.add(exitButton);
		
		findRButton = new JButton("\u67E5\u8BE2\u7ED3\u679C");
		findRButton.setBackground(Color.LIGHT_GRAY);
		findRButton.setBounds(122, 40, 88, 27);
		findRButton.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		upPanel.add(findRButton);
		findRButton.addActionListener(new ActionListener(){ //查找结果的事件监听
			@Override
			public void actionPerformed(ActionEvent e) {
			    ResultCompetitorFrame rcf=new ResultCompetitorFrame();
			    rcf.setBounds(3, 88, 431, 173);
				rcf.getScrollPane().setBounds(5, 25, 419, 138);
				getPanel().add(rcf,"rcf");
				rcf.setLayout(null);
				getCard().show(panel,"rcf");
				
			}
		});
		
	    findCButton = new JButton("\u6BD4\u8D5B\u65E5\u7A0B");
		findCButton.setBackground(Color.LIGHT_GRAY);
		findCButton.setBounds(234, 40, 88, 27);
		findCButton.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		upPanel.add(findCButton);
		findCButton.addActionListener(new ActionListener(){ //查询比赛日程的事件监听
			@Override
			public void actionPerformed(ActionEvent e) {
			  	CompetitorInfo downPanel=new CompetitorInfo();
			    getPanel().add(downPanel,"downPanel");
			    getCard().show(panel,"downPanel");
				
			}
		});
		
		label = new JLabel("\u4F60\u597D\uFF0C+\u7528\u6237\u540D");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		label.setBounds(10, 10, 205, 15);
	   	upPanel.add(label);
	   	
	   	photoLable = new JLabel("\u8FD9\u662F\u7167\u7247");
	   	photoLable.setFont(new Font("微软雅黑", Font.PLAIN, 12));
	   	photoLable.setBackground(Color.WHITE);
	   	photoLable.setBounds(343, 10, 81, 66);
	   	upPanel.add(photoLable);
	   	
	   	icon = new ImageIcon("D:\\素材\\22.jpg"); //读取图片，设置图片
	    icon.setImage(icon.getImage().getScaledInstance(icon.getIconWidth(),
	    icon.getIconHeight(), Image.SCALE_DEFAULT));
	    photoLable.setIcon(icon);//把图片设置到label上
	    
	    card=new CardLayout();
	    panel = new JPanel(card);
	    panel.setBounds(0, 76, 434, 185);
	    frame.getContentPane().add(panel);
	    
	    

	    
	    

	    
	    
	    
	    //初始化显示选手界面
	    ShowInfoPanel sif=new ShowInfoPanel();
	    sif.setBounds(3, 77, 431, 184);
	    getPanel().add(sif,"sif");
	    sif.setLayout(null);
	    getCard().show(panel,"sif");
	
       
	
	}

	public CardLayout getCard() {
		return card;
	}

	public void setCard(CardLayout card) {
		this.card = card;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
}
