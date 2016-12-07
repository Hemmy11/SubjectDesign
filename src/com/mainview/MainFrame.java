package com.mainview;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.competitorview.CompetitorMFrame;
import com.manageview.ManageFrame;
//登录界面
public class MainFrame {

	private JFrame frame;
	private JPanel upPanel;
	private JTextField username;//用户名
	private JLabel plabel;
	private JLabel tittlelabel;//标题
	private JPasswordField passwordField;//密码
    private RadioPanel radioPanel;//返回一个单选框组
    private JRadioButton sRbutton;//选手单选
    private JRadioButton mRbutton;//管理员单选

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String lookAndFeel ="com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel";
					UIManager.setLookAndFeel(lookAndFeel);
					MainFrame window = new MainFrame();
					window.frame.setVisible(true);
					window.frame.setResizable(false); //不可调整大小
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setEnabled(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		upPanel = new JPanel();
		frame.getContentPane().add(upPanel, BorderLayout.CENTER);
		upPanel.setLayout(null);
		
		username = new JTextField();
		username.setBounds(177, 96, 160, 24);
		upPanel.add(username);
		username.setColumns(5);
		
		JLabel nlabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		nlabel.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		nlabel.setBounds(103, 96, 80, 24);
		upPanel.add(nlabel);
		
		plabel = new JLabel("\u5BC6   \u7801\uFF1A");
		plabel.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		plabel.setBounds(103, 136, 72, 24);
		upPanel.add(plabel);
		
		tittlelabel = new JLabel("\u4FDD\u9F84\u7403\u6BD4\u8D5B\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF");
		tittlelabel.setFont(new Font("方正清刻本悦宋简体", Font.PLAIN, 26));
		tittlelabel.setBounds(78, 35, 295, 30);
		upPanel.add(tittlelabel);
		
		radioPanel=new RadioPanel();
		radioPanel.setSize(160, 30);
		radioPanel.setLocation(177, 170);
		upPanel.add(radioPanel);
		radioPanel.setLayout(null);
		
		mRbutton = new JRadioButton("\u7BA1\u7406\u5458");
		mRbutton.setBounds(0, 0, 65, 27);
		mRbutton.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		radioPanel.add(mRbutton);
		
		sRbutton = new JRadioButton("\u9009\u624B");
		sRbutton.setBounds(109, 0, 51, 27);
		sRbutton.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		radioPanel.add(sRbutton);
		
		radioPanel.getBtnGroup().add(mRbutton);
		radioPanel.getBtnGroup().add(sRbutton);
	
		
		JButton lgButton = new JButton("\u767B\u5F55");
		lgButton.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		lgButton.setBackground(Color.LIGHT_GRAY);
		lgButton.setBounds(177, 210, 93, 23);
		lgButton.addActionListener(new ActionListener(){  //登录按钮的注册监听
			 @Override
			public void actionPerformed(ActionEvent e) {
				  if(mRbutton.isSelected()){ //管理员登录
					   if(username.getText().equals("admin")){
						       if(String.valueOf(passwordField.getPassword()).equals("admin")){ //字节数组转换为字符串先
						    	                 frame.setVisible(false);
						    	                 ManageFrame mf=new ManageFrame();
						    	                 mf.getFrame().setVisible(true);
						    	                 mf.getFrame().setResizable(false);
						       }
						       else
						    	   JOptionPane.showMessageDialog(null,"密码错误！");
					   }
					   else
						   JOptionPane.showMessageDialog(null,"用户名错误！");
				  }
				  else if(sRbutton.isSelected()){ //选手登录
				getFrame().setVisible(false);
				CompetitorMFrame window = new CompetitorMFrame(); //选手界面
				window.getFrame().setVisible(true);
				window.getFrame().setResizable(false);
				  }
				  else
					  JOptionPane.showMessageDialog(null,"请选择登录用户的类型！");
				
			}
		});
		upPanel.add(lgButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(177, 136, 160, 24);
		upPanel.add(passwordField);
	
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
