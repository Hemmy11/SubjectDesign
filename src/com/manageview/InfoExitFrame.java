package com.manageview;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.fido.filedialog.FileChooser;
import com.mainview.RadioPanel;
/**
 * 
 * ѡ����Ϣ¼�����
 *
 */
public class InfoExitFrame extends JFrame{
	public JFrame getFrame(){ //���ص�ǰ����
		return this;
	}
	
	private JTextField nametextField;//���������
	private JTextField addresstextField;//��ַ
	private FileChooser filechoose;//ѡ���ļ��ĶԻ���
	private File filepath;//��Ƭ��·��
	private JLabel photoShowLabel;//��ʾ��Ƭ
	private JButton yesButton;//ȷ���ύѡ����Ϣ�İ�ť
	private JRadioButton man;//�е�ѡ��
	private JRadioButton lady;//Ů��ѡ��
	private JComboBox comboBox;//������ѡ������
	private JButton photoButton;//��Ƭѡ��ť
	private JButton cancelButton;//ȡ����ť
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

	public JLabel getPhotoShowLabel() {
		return photoShowLabel;
	}

	public void setPhotoShowLabel(JLabel photoShowLabel) {
		this.photoShowLabel = photoShowLabel;
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

	public JComboBox getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}



	public JButton getYesButton() {
		return yesButton;
	}

	public void setYesButton(JButton yesButton) {
		this.yesButton = yesButton;
	}

	public JLabel getPhotoShowLable() {
		return photoShowLabel;
	}

	public void setPhotoShowLable(JLabel photoShowLable) {
		this.photoShowLabel = photoShowLable;
	}

	public File getFilepath() {
		return filepath;
	}

	public void setFilepath(File filepath) {
		this.filepath = filepath;
	}

	/**
	 * Launch the application.
	 */


	public FileChooser getFilechoose() {
		return filechoose;
	}

	public void setFilechoose(FileChooser filechoose) {
		this.filechoose = filechoose;
	}

	/**
	 * Create the application.
	 */
	public InfoExitFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setBounds(300, 300, 450,500);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 461);
		this.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel nameLabel = new JLabel("\u59D3\u540D\uFF1A");
		nameLabel.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		nameLabel.setBounds(120, 70, 48, 17);
		panel.add(nameLabel);
		
		nametextField = new JTextField();
		nametextField.setBounds(178, 69, 151, 21);
		panel.add(nametextField);
		nametextField.setColumns(10);
		
		JLabel sexLabel = new JLabel("\u6027\u522B\uFF1A");
		sexLabel.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		sexLabel.setBounds(120, 123, 54, 15);
		panel.add(sexLabel);
		
		RadioPanel rp=new RadioPanel();
		rp.setBounds(178,117,151,27);
		 man=new JRadioButton("��");
		man.setBounds(18, 0, 43, 25);
		man.setFont(new Font("΢���ź�", Font.PLAIN, 13));
		 lady=new JRadioButton("Ů");
		lady.setBounds(86, 0, 42, 25);
		lady.setFont(new Font("΢���ź�", Font.PLAIN, 13));
		rp.setLayout(null);
		rp.add(man);
		rp.add(lady);
		rp.getBtnGroup().add(man);
		rp.getBtnGroup().add(lady);
		panel.add(rp);
		
		JLabel ageLabel = new JLabel("\u5E74\u9F84\uFF1A");
		ageLabel.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		ageLabel.setBounds(120, 176, 54, 15);
		panel.add(ageLabel);
		
	    comboBox = new JComboBox();
		comboBox.setFont(new Font("΢���ź�", Font.PLAIN, 13));
		comboBox.setBounds(178, 176, 151, 17);
		
		for(int i=18;i<=25;i++){
			comboBox.addItem(i);
		}
		
		panel.add(comboBox);
		
		JLabel addreLabel = new JLabel("\u5730\u5740\uFF1A");
		addreLabel.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		addreLabel.setBounds(120, 235, 103, 15);
		panel.add(addreLabel);
		
		addresstextField = new JTextField();
		addresstextField.setBounds(178, 233, 151, 21);
		panel.add(addresstextField);
		addresstextField.setColumns(10);
		
		JLabel photoLabel = new JLabel("\u7167\u7247\uFF1A");
		photoLabel.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		photoLabel.setBounds(120, 313, 54, 15);
		panel.add(photoLabel);
		
	    photoButton = new JButton("\u7167\u7247\u9009\u62E9");
		photoButton.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		photoButton.setBounds(320, 323, 93, 23); 
		photoButton.setBackground(Color.LIGHT_GRAY); 
		photoButton.addActionListener(new ActionListener(){  //Ϊ��Ƭѡ���ṩ�Ի���
			@Override
			public void actionPerformed(ActionEvent e) {//�ϴ���Ƭ��ť���¼�����
				      filechoose=new FileChooser();
				     int option= filechoose.do_button_actionPerformed(e);
				      filepath=filechoose.getFileChooser().getSelectedFile();
				     if(option==filechoose.getFileChooser().APPROVE_OPTION){
				      ImageIcon icon = new ImageIcon(filepath.getPath());
					    icon.setImage(icon.getImage().getScaledInstance(icon.getIconWidth(),
					    icon.getIconHeight(), Image.SCALE_DEFAULT));
   icon=new ImageIcon(icon.getImage().getScaledInstance(getPhotoShowLable().getWidth(), getPhotoShowLable().getHeight(), Image.SCALE_DEFAULT));  
					    getPhotoShowLable().setIcon(icon);
				     }
				     else
				    	 filechoose.setVisible(false);
				 
				
			}
		});
		panel.add(photoButton);
		
		yesButton = new JButton("\u786E\u5B9A");
		yesButton.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		yesButton.setBounds(89, 405, 93, 23);
		yesButton.setBackground(Color.LIGHT_GRAY);
		panel.add(yesButton);
		yesButton.addActionListener(new ActionListener(){  
			@Override
			public void actionPerformed(ActionEvent e) {  //ȷ����ť���¼�����
				
				
				
		 int n=JOptionPane.showConfirmDialog(null, "¼��ɹ�","¼����Ϣ",JOptionPane.DEFAULT_OPTION);
		 if(n==0){
			 int j=JOptionPane.showConfirmDialog(null, "�Ƿ����¼��ѡ����Ϣ","¼����Ϣ",JOptionPane.YES_NO_OPTION);
			 if(j==0){
				 return;
			 }
			 else{
				 setVisible(false);
			 }
		 }

				
				
			}
		});
		
		JLabel titleLabel = new JLabel("\u9009\u624B\u4FE1\u606F\u5F55\u5165");
		titleLabel.setFont(new Font("΢���ź�", Font.PLAIN, 22));
		titleLabel.setBounds(159, 21, 151, 27);
		panel.add(titleLabel);
		
	    photoShowLabel = new JLabel("");
		photoShowLabel.setBounds(178, 283, 137, 111);  
		panel.add(photoShowLabel);
		
	    cancelButton = new JButton("\u53D6\u6D88");
		cancelButton.setBackground(Color.LIGHT_GRAY);
		cancelButton.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //ȡ����ť���¼�����
			         getFrame().setVisible(false);
				 
			}
		});
		cancelButton.setBounds(268, 405, 93, 23);
		panel.add(cancelButton);
		
	}

	public JButton getPhotoButton() {
		return photoButton;
	}

	public void setPhotoButton(JButton photoButton) {
		this.photoButton = photoButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public void setCancelButton(JButton cancelButton) {
		this.cancelButton = cancelButton;
	}
}
