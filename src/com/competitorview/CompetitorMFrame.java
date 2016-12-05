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
 *  Ñ¡ÊÖµÇÂ¼ºóµÄÊ×Ò³Ãæ
 *
 */
public class CompetitorMFrame {

	private JFrame frame;
	private CardLayout card;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String lookAndFeel ="com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel";
					UIManager.setLookAndFeel(lookAndFeel);
					CompetitorMFrame window = new CompetitorMFrame();
					window.frame.setVisible(true);
					window.frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
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
		
		
		JPanel upPanel = new JPanel();
		upPanel.setBounds(0, 0, 434, 78);
		frame.getContentPane().add(upPanel);
		upPanel.setLayout(null);
		
		JButton exitButton = new JButton("\u4FEE\u6539\u4FE1\u606F");
		exitButton.setBackground(Color.LIGHT_GRAY);
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InfogaiFrame ief=new InfogaiFrame();
                ief.setVisible(true);
                ief.setResizable(false);
                ief.setDefaultCloseOperation(ief.HIDE_ON_CLOSE);
				
			}
		});
		exitButton.setBounds(10, 40, 88, 27);
		exitButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		upPanel.add(exitButton);
		
		JButton findRButton = new JButton("\u67E5\u8BE2\u7ED3\u679C");
		findRButton.setBackground(Color.LIGHT_GRAY);
		findRButton.setBounds(122, 40, 88, 27);
		findRButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		upPanel.add(findRButton);
		findRButton.addActionListener(new ActionListener(){
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
		
		JButton findCButton = new JButton("\u6BD4\u8D5B\u65E5\u7A0B");
		findCButton.setBackground(Color.LIGHT_GRAY);
		findCButton.setBounds(234, 40, 88, 27);
		findCButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		upPanel.add(findCButton);
		findCButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
			  	CompetitorInfo downPanel=new CompetitorInfo();
			    getPanel().add(downPanel,"downPanel");
			    getCard().show(panel,"downPanel");
				
			}
		});
		
		JLabel label = new JLabel("\u4F60\u597D\uFF0C+\u7528\u6237\u540D");
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		label.setBounds(10, 10, 205, 15);
	   	upPanel.add(label);
	   	
	   	JLabel photoLable = new JLabel("\u8FD9\u662F\u7167\u7247");
	   	photoLable.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
	   	photoLable.setBackground(Color.WHITE);
	   	photoLable.setBounds(343, 10, 81, 66);
	   	upPanel.add(photoLable);
	   	ImageIcon icon = new ImageIcon("D:\\ËØ²Ä\\22.jpg");
	    icon.setImage(icon.getImage().getScaledInstance(icon.getIconWidth(),
	    icon.getIconHeight(), Image.SCALE_DEFAULT));
	    photoLable.setIcon(icon);
	    
	    card=new CardLayout();
	    panel = new JPanel(card);
	    panel.setBounds(0, 76, 434, 185);
	    frame.getContentPane().add(panel);
	    
	    

	    
	    

	    
	    
	    
	    //³õÊ¼»¯ÏÔÊ¾Ñ¡ÊÖ½çÃæ
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
