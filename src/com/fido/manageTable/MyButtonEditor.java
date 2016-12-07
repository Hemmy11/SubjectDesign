package com.fido.manageTable;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
/**
 * 
 * ��Ӧ����Ա�鿴ѡ����Ƭ��button
 *
 */
public class MyButtonEditor extends AbstractCellEditor implements
TableCellEditor {

/**
* serialVersionUID
*/
private static final long serialVersionUID = -6546334664166791132L;

private JPanel panel;

private JButton button;

public MyButtonEditor() {

initButton();

initPanel();

panel.add(this.button, BorderLayout.CENTER);
}

private void initButton() {
button = new JButton();

button.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {  //���²鿴��ť����Ӧѡ����Ƭ
              JFrame jf=new JFrame();
              JPanel panel=new JPanel();
              panel.setSize(200,200);
              jf.getContentPane().add(panel);
              JLabel photoLabel=new JLabel();
              ImageIcon image=new ImageIcon("D://PPT�ز�//��ɫ.jpg");
              jf.setBounds(600,300,200,200);
              image.setImage(image.getImage().getScaledInstance(jf.getWidth(),jf.getHeight(),Image.SCALE_DEFAULT)); 
              photoLabel.setIcon(image);
              panel.add(photoLabel);
              jf.setVisible(true);
              jf.setResizable(false);
  
              

    }
});

}

private void initPanel() {
panel = new JPanel();

panel.setLayout(new BorderLayout());
}

@Override
public Component getTableCellEditorComponent(JTable table, Object value,
    boolean isSelected, int row, int column) {

button.setText("�鿴");
button.setFont(new Font("΢���ź�", Font.BOLD, 12));
button.setBackground(Color.LIGHT_GRAY);

return panel;
}

@Override
public Object getCellEditorValue() {
	// TODO Auto-generated method stub
	return null;
}


}