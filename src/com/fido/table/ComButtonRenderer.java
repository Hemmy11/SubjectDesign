package com.fido.table;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class ComButtonRenderer implements TableCellRenderer {
    private JPanel panel;

    private JButton button;
    

    public ComButtonRenderer() {
        initButton();

        initPanel();

        panel.add(button, BorderLayout.CENTER);
    }

    private void initButton() {
        button = new JButton();

    }

    private void initPanel() {
        panel = new JPanel();

        panel.setLayout(new BorderLayout());
    }

    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        
        button.setText("�鿴");
        button.setFont(new Font("΢���ź�", Font.BOLD, 12));
        button.setBackground(Color.LIGHT_GRAY);

        return panel;
    }

}