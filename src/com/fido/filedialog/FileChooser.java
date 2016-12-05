package com.fido.filedialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 * 
 * ѡ���ϴ���Ƭ�Ի���
 *
 */
public class FileChooser extends JFrame {  
    
    
    private static final long serialVersionUID = 1L;  
    private JPanel contentPane;  
    private JFileChooser fileChooser;  
    private ImagePreviewer imageLabel;  
    private ImagePreviewer previewer;  
      
    /** 
     * Launch the application. 
     */  
      
    /** 
     * Create the frame. 
     */  
    public FileChooser() {  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setBounds(100, 100, 629, 428);  
        contentPane = new JPanel();  
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));  
        contentPane.setLayout(new BorderLayout(0, 0));  
        setContentPane(contentPane);  
          
        JPanel panel = new JPanel();  
        contentPane.add(panel, BorderLayout.NORTH);  
           
          
        imageLabel = new ImagePreviewer((JFileChooser) null);  
        contentPane.add(imageLabel, BorderLayout.CENTER);  
        initFileChooser();  
    }  
      
    /** 
     * ��ʼ���ļ�ѡ���� 
     */  
    public void initFileChooser() {  
        fileChooser = new JFileChooser();// �����ļ�ѡ����  
        previewer = new ImagePreviewer(fileChooser);// ����ͼƬԤ����ǩ  
        fileChooser.setFileFilter(new FileNameExtensionFilter("ͼƬ�ļ�", "jpg",  
                "gif", "png"));  
        // Ϊָ�����Ա������¼�������  
        fileChooser.addPropertyChangeListener("SelectedFileChangedProperty",  
                new PropertyChangeListener() {  
                    public void propertyChange(PropertyChangeEvent evt) {  
                        // ���Ըı�ʱ����Ԥ����ǩ��ͼƬ  
                        previewer.setImageFile((File) evt.getNewValue());  
                    }  
                });  
        fileChooser.setAccessory(previewer);  
    }  
      
    /** 
     * ѡ��ͼƬ�ļ���ť���¼������� 
     *  
     * @param e 
     */  
   public int do_button_actionPerformed(ActionEvent e) {  
        int option = fileChooser.showOpenDialog(this);// ��ʾ���ļ��Ի���  
        if (option == JFileChooser.APPROVE_OPTION) {  
            // ��ȡѡ����ļ�����  
            File file = fileChooser.getSelectedFile();  
            // ���´�����ͼƬ  
            imageLabel.setImageFile(file);
        }  
          return option;
               
    }

	public JFileChooser getFileChooser() {
		return fileChooser;
	}

	public void setFileChooser(JFileChooser fileChooser) {
		this.fileChooser = fileChooser;
	}  
}  
  
/** 
 * �Զ���ͼƬԤ����ǩ 
 *  
 */  
class ImagePreviewer extends JLabel {  
    public ImagePreviewer(JFileChooser chooser) {  
        // ��ʼ��С  
        setPreferredSize(new Dimension(200, 200));  
        setHorizontalAlignment(JLabel.CENTER);// ˮƽ����  
        setBorder(new LineBorder(Color.GRAY));// ���ñ߿�  
        setOpaque(true);// ��ǩ��͸��  
        setBackground(Color.WHITE);// ���ñ���ɫ  
        setText("û������ͼƬ");// Ĭ���ı�  
    }  
      
    /** 
     * ���ñ�ǩͼƬ�ķ��� 
     *  
     * @param file 
     */  
    public void setImageFile(File file) {  
        setText("");// ���ͼƬԤ����ǩ���ı�  
        if (file == null) {// ����ļ�����Ϊ��  
            setText("û������ͼƬ");// ����Ĭ����ʾ�ı�  
            return;// ��ֹ����  
        }  
        // ����ͼ�����  
        ImageIcon icon = new ImageIcon(file.getPath());  
        if (icon.getIconWidth() > getWidth()) {// ����ͼ���С  
            icon = new ImageIcon(icon.getImage().getScaledInstance(getWidth(),  
                    -1, Image.SCALE_DEFAULT));  
        }  
        setIcon(icon);// Ϊ��ǩ����ͼ��  
        repaint();// ���»��ƽ���  
    }  
}   