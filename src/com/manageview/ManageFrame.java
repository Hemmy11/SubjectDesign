package com.manageview;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.fido.manageTable.TestTable;

/**
 * ����Ա��ʼ����
 */
public class ManageFrame {

	private JFrame frame;
	private JTextField textField;
	private JTextField comName;
	private JPanel downPanel;
    private CardLayout card;
    private JPanel upPanel;
    private JButton addButton;
    private JButton countscoreButton;
    private JButton findButton;
    private JButton resultButton;
    private JLabel label;
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

	public ManageFrame() {
		initialize();
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100,450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		 card =new CardLayout();
			downPanel = new JPanel(card);
			downPanel.setBounds(0, 69, 434, 192);
			frame.getContentPane().add(downPanel);
		
		upPanel = new JPanel();
		upPanel.setBounds(0, 0, 434, 69);
		frame.getContentPane().add(upPanel);
		upPanel.setLayout(null);
		
		addButton = new JButton("\u9009\u624B\u5F55\u5165");
		addButton.setBackground(Color.LIGHT_GRAY);
		addButton.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		addButton.setBounds(10, 36, 92, 23);
		upPanel.add(addButton);
		addButton.addActionListener(new ActionListener() {  
			public void actionPerformed(ActionEvent e) {  //ѡ��¼�밴ť
				AddCount ac=new AddCount();
				ac.setBounds(0, 70, 434, 191);
				getDownPanel().add(ac,"ac");
				ac.setLayout(null);
				card.show(downPanel,"ac");
			}
		});
		
		countscoreButton = new JButton("\u6BD4\u8D5B\u8BA1\u5206");
		countscoreButton.setBackground(Color.LIGHT_GRAY);
		countscoreButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //���ڱ����Ʒֵ��¼���������ʾ�Ʒֵ��½���
				   CountFrame cf=new CountFrame();
				   cf.setDefaultCloseOperation(cf.HIDE_ON_CLOSE);

			}
		});
		countscoreButton.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		countscoreButton.setBounds(117, 36, 92, 23);
		upPanel.add(countscoreButton);
		
		findButton = new JButton("\u67E5\u8BE2\u529F\u80FD");
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
    				if(selectedValue.equals(possibleValues[0])){ //��ѯ�����ճ�
    				    sct.getScrollPane().setBounds(10, 41, 415, 142);
    				    sct.setBounds(5, 66, 479, 195);
    				    sct.setLayout(null);
    				    getCard().show(downPanel,"sct");
    				}
    				else if(selectedValue.equals(possibleValues[1])){ //��ѯѡ����Ϣ
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
		
		label = new JLabel("\u4F60\u597D\uFF0C\u7BA1\u7406\u5458\uFF01");
		label.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		label.setBounds(10, 5, 98, 16);
		upPanel.add(label);
		
		
	    resultButton = new JButton("\u6BD4\u8D5B\u7ED3\u679C");
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
		
		
		//�����ǿ�Ƭ����Ҫ����һ����ֵ����Ȼ��һ����ťҪ�����β��ж�����ʾ
		JPanel newPanel=new JPanel();
        getDownPanel().add(newPanel,"dw");  
		getCard().show(downPanel,"dw");
	
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JTextField getComName() {
		return comName;
	}

	public void setComName(JTextField comName) {
		this.comName = comName;
	}

	public JPanel getUpPanel() {
		return upPanel;
	}

	public void setUpPanel(JPanel upPanel) {
		this.upPanel = upPanel;
	}

	public JButton getAddButton() {
		return addButton;
	}

	public void setAddButton(JButton addButton) {
		this.addButton = addButton;
	}

	public JButton getCountscoreButton() {
		return countscoreButton;
	}

	public void setCountscoreButton(JButton countscoreButton) {
		this.countscoreButton = countscoreButton;
	}

	public JButton getFindButton() {
		return findButton;
	}

	public void setFindButton(JButton findButton) {
		this.findButton = findButton;
	}

	public JButton getResultButton() {
		return resultButton;
	}

	public void setResultButton(JButton resultButton) {
		this.resultButton = resultButton;
	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}



}
