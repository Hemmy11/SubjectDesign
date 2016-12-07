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
 *  ѡ�ֵ�¼�����ҳ��
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
	private JButton exitButton;//�޸���Ϣ��ť
	private JButton findRButton;//��ѯ�����ť
	private JButton findCButton;//��ѯ�����ճ̰�ť
	private JLabel label;
	private JLabel photoLable;//������ʾ��Ƭ
	private ImageIcon icon;//ͼƬ
	
	
	
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
			public void actionPerformed(ActionEvent e) { //�޸���Ϣ���¼�����
				InfogaiFrame ief=new InfogaiFrame();
                ief.setVisible(true);
                ief.setResizable(false);
                ief.setDefaultCloseOperation(ief.HIDE_ON_CLOSE);
				
			}
		});
		exitButton.setBounds(10, 40, 88, 27);
		exitButton.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		upPanel.add(exitButton);
		
		findRButton = new JButton("\u67E5\u8BE2\u7ED3\u679C");
		findRButton.setBackground(Color.LIGHT_GRAY);
		findRButton.setBounds(122, 40, 88, 27);
		findRButton.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		upPanel.add(findRButton);
		findRButton.addActionListener(new ActionListener(){ //���ҽ�����¼�����
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
		findCButton.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		upPanel.add(findCButton);
		findCButton.addActionListener(new ActionListener(){ //��ѯ�����ճ̵��¼�����
			@Override
			public void actionPerformed(ActionEvent e) {
			  	CompetitorInfo downPanel=new CompetitorInfo();
			    getPanel().add(downPanel,"downPanel");
			    getCard().show(panel,"downPanel");
				
			}
		});
		
		label = new JLabel("\u4F60\u597D\uFF0C+\u7528\u6237\u540D");
		label.setFont(new Font("΢���ź�", Font.PLAIN, 13));
		label.setBounds(10, 10, 205, 15);
	   	upPanel.add(label);
	   	
	   	photoLable = new JLabel("\u8FD9\u662F\u7167\u7247");
	   	photoLable.setFont(new Font("΢���ź�", Font.PLAIN, 12));
	   	photoLable.setBackground(Color.WHITE);
	   	photoLable.setBounds(343, 10, 81, 66);
	   	upPanel.add(photoLable);
	   	
	   	icon = new ImageIcon("D:\\�ز�\\22.jpg"); //��ȡͼƬ������ͼƬ
	    icon.setImage(icon.getImage().getScaledInstance(icon.getIconWidth(),
	    icon.getIconHeight(), Image.SCALE_DEFAULT));
	    photoLable.setIcon(icon);//��ͼƬ���õ�label��
	    
	    card=new CardLayout();
	    panel = new JPanel(card);
	    panel.setBounds(0, 76, 434, 185);
	    frame.getContentPane().add(panel);
	    
	    

	    
	    

	    
	    
	    
	    //��ʼ����ʾѡ�ֽ���
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
