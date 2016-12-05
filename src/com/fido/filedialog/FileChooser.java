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
 * 选择上传照片对话框
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
     * 初始化文件选择器 
     */  
    public void initFileChooser() {  
        fileChooser = new JFileChooser();// 创建文件选择器  
        previewer = new ImagePreviewer(fileChooser);// 创建图片预览标签  
        fileChooser.setFileFilter(new FileNameExtensionFilter("图片文件", "jpg",  
                "gif", "png"));  
        // 为指定属性变更添加事件监听器  
        fileChooser.addPropertyChangeListener("SelectedFileChangedProperty",  
                new PropertyChangeListener() {  
                    public void propertyChange(PropertyChangeEvent evt) {  
                        // 属性改变时设置预览标签的图片  
                        previewer.setImageFile((File) evt.getNewValue());  
                    }  
                });  
        fileChooser.setAccessory(previewer);  
    }  
      
    /** 
     * 选择图片文件按钮的事件处理方法 
     *  
     * @param e 
     */  
   public int do_button_actionPerformed(ActionEvent e) {  
        int option = fileChooser.showOpenDialog(this);// 显示打开文件对话框  
        if (option == JFileChooser.APPROVE_OPTION) {  
            // 获取选择的文件对象  
            File file = fileChooser.getSelectedFile();  
            // 更新窗体中图片  
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
 * 自定义图片预览标签 
 *  
 */  
class ImagePreviewer extends JLabel {  
    public ImagePreviewer(JFileChooser chooser) {  
        // 初始大小  
        setPreferredSize(new Dimension(200, 200));  
        setHorizontalAlignment(JLabel.CENTER);// 水平居中  
        setBorder(new LineBorder(Color.GRAY));// 设置边框  
        setOpaque(true);// 标签不透明  
        setBackground(Color.WHITE);// 设置背景色  
        setText("没有设置图片");// 默认文本  
    }  
      
    /** 
     * 设置标签图片的方法 
     *  
     * @param file 
     */  
    public void setImageFile(File file) {  
        setText("");// 清空图片预览标签的文本  
        if (file == null) {// 如果文件对象为空  
            setText("没有设置图片");// 设置默认提示文本  
            return;// 终止方法  
        }  
        // 创建图标对象  
        ImageIcon icon = new ImageIcon(file.getPath());  
        if (icon.getIconWidth() > getWidth()) {// 设置图标大小  
            icon = new ImageIcon(icon.getImage().getScaledInstance(getWidth(),  
                    -1, Image.SCALE_DEFAULT));  
        }  
        setIcon(icon);// 为标签设置图标  
        repaint();// 重新绘制界面  
    }  
}   