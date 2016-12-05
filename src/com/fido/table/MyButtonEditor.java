package com.fido.table;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

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
    public void actionPerformed(ActionEvent e) {  //按下查看按钮出照片
           

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

button.setText("查看");
button.setFont(new Font("微软雅黑", Font.BOLD, 12));

return panel;
}

@Override
public Object getCellEditorValue() {
	// TODO Auto-generated method stub
	return null;
}


}