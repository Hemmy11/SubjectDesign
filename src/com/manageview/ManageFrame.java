package com.manageview;

import java.awt.CardLayout;
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
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.fido.table.TestTable;
/**
 * ����Ա��ʼ����
 */
public class ManageFrame {

	private JFrame frame;
	private JTextField textField;
	private JTextField comName;
	private JPanel downPanel;
    private CardLayout card;
	public CardLayout getCard() {
		return card;
	}

	public void setCard(CardLayout card) {
		this.card = card;
	}

	public JPanel getDownPanel() {
		return downPanel;
	}

	public void setDownPanel(JPanel downPanel) {
		this.downPanel = downPanel;
	}

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					String lookAndFeel ="com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel";
//					UIManager.setLookAndFeel(lookAndFeel);
//					ManageFrame window = new ManageFrame();
//					window.frame.setVisible(true);
//					window.frame.setResizable(false);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	

	/**
	 * Create the application.
	 */
	public ManageFrame() {
		initialize();
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100,450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		 card =new CardLayout();
			downPanel = new JPanel(card);
			downPanel.setBounds(0, 69, 434, 192);
			frame.getContentPane().add(downPanel);
		
		JPanel upPanel = new JPanel();
		upPanel.setBounds(0, 0, 434, 69);
		frame.getContentPane().add(upPanel);
		upPanel.setLayout(null);
		
		JButton addButton = new JButton("\u9009\u624B\u5F55\u5165");
		addButton.setBackground(Color.LIGHT_GRAY);
		addButton.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		addButton.setBounds(10, 36, 92, 23);
		upPanel.add(addButton);
		addButton.addActionListener(new ActionListener() {  
			public void actionPerformed(ActionEvent e) {  //ѡ��¼��
				AddCount ac=new AddCount();
				ac.setBounds(0, 70, 434, 191);
				getDownPanel().add(ac,"ac");
				ac.setLayout(null);
				card.show(downPanel,"ac");
			}
		});
		
		JButton countscoreButton = new JButton("\u6BD4\u8D5B\u8BA1\u5206");
		countscoreButton.setBackground(Color.LIGHT_GRAY);
		countscoreButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //���ڱ����Ʒֵ��¼�����
				   CountFrame cf=new CountFrame();
				   cf.setDefaultCloseOperation(cf.HIDE_ON_CLOSE);

			}
		});
		countscoreButton.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		countscoreButton.setBounds(117, 36, 92, 23);
		upPanel.add(countscoreButton);
		
		JButton findButton = new JButton("\u67E5\u8BE2\u529F\u80FD");
		findButton.setBackground(Color.LIGHT_GRAY);
		findButton.addActionListener(new ActionListener() {  //���˲�ѯ���ܣ�����ѡ�����
			public void actionPerformed(ActionEvent e) {
				Object[] possibleValues = { "�����ճ�", "ѡ����Ϣ"};
				Object selectedValue = JOptionPane.showInputDialog(null, 
				"��ѡ����Ҫ��ѯ����Ϣ", "ѡ���ѯ����",
				JOptionPane.INFORMATION_MESSAGE, null,
				possibleValues, possibleValues[0]);
				if(selectedValue==null){
					return;
				}
				else{   //�ж��Ƿ�Ϊ�գ������������󣬲�Ȼ���ǽ���
					ShowComTime sct=new ShowComTime();
					getDownPanel().add(sct,"sct");
					TestTable tt=new TestTable();
					getDownPanel().add(tt,"tt");
    				if(selectedValue.equals(possibleValues[0])){
    				    sct.getScrollPane().setBounds(10, 41, 415, 142);
    				    sct.setBounds(5, 66, 479, 195);
    				    sct.setLayout(null);
    				    getCard().show(downPanel,"sct");
    				}
    				else if(selectedValue.equals(possibleValues[1])){
    					tt.setBounds(3, 68, 450, 193);
    					tt.getScrollPane().setBounds(10, 47, 414, 135);
    					tt.setLayout(null);
    					getCard().show(downPanel,"tt");
    				}
                }
					


			}
		});
						
		findButton.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		findButton.setBounds(333, 36, 92, 23);
		upPanel.add(findButton);
		
		JLabel label = new JLabel("\u4F60\u597D\uFF0C\u7BA1\u7406\u5458\uFF01");
		label.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		label.setBounds(10, 5, 98, 16);
		upPanel.add(label);
		
		
		JButton resultButton = new JButton("\u6BD4\u8D5B\u7ED3\u679C");
		resultButton.setBackground(Color.LIGHT_GRAY);
		resultButton.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		resultButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {  //���ڲ�ѯ������¼�����
				
				ResultFrame rf=new ResultFrame();	
				getDownPanel().add(rf,"rf");
				rf.getScrollPane().setBounds(10, 40, 415, 142);
				rf.setLayout(null);
				getCard().show(downPanel,"rf");
			}
		});
		resultButton.setBounds(221, 36, 102, 23);
		upPanel.add(resultButton);
		
		
		
		



		
		
		//��ѯ�������ʾ����
//		ResultFrame rf=new ResultFrame();			
//		getDownPanel().add(rf,"rf");
//		rf.setBounds(5, 0, 479, 195);
//		rf.getScrollPane().setBounds(10, 40, 415, 142);
//		rf.setLayout(null);
//		getCard().show(downPanel,"rf");
       
		
		//�����ǿ�Ƭ����Ҫ����һ����ֵ����Ȼ��һ����ťҪ�����β��ж�����ʾ
		JPanel newPanel=new JPanel();
        getDownPanel().add(newPanel,"dw");  
		getCard().show(downPanel,"dw");
	
		

		
		
	}



}
