package com.fido.table;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
/*
 * ��Ӧ��ѡ�ֵĲ鿴������Ϣ
 */
public class CompetitorInfo extends JPanel {

	private JScrollPane scrollPane;
    private JTable table;
    
    
    Object [] paramter={"��������","���ֱ��","��������","����ʱ��","������Ƭ"}; //��ͷ����

	 
	 
	 public JScrollPane getScrollPane() {
		return scrollPane;
	}



	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}



	public JTable getTable() {
		return table;
	}



	public void setTable(JTable table) {
		this.table = table;
	}



	Object [] s1 = { "С��", "213213", "19","2016-11-30","�鿴"};
    Object [] s2 = { "С��", "142321", "20","2016-11-30","�鿴"};
    Object [] s3 = { "С��", "213213", "19","2016-11-30","�鿴"};
    Object [] s4 = { "С��", "142321", "20","2016-11-30","�鿴"};
    Object [] s5 = { "С��", "213213", "19","2016-11-30","�鿴"};
    Object [] s6 = { "С��", "142321", "20","2016-11-30","�鿴"};
    Object [] s7 = { "С��", "142321", "20","2016-11-30","�鿴"};
    Object [] s8 = { "С��", "142321", "20","2016-11-30","�鿴"};
    Object [] s9 = { "С��", "142321", "20","2016-11-30","�鿴"};
    Object [] s10 = { "С��", "142321", "20","2016-11-30","�鿴"};
    
    
	 Object [][] data ={s1,s2,s3,s4,s5,s6,s7,s8,s9,s10};
	 


    public CompetitorInfo() {

    this.setBorder(new EmptyBorder(5,5,5,5));
   	 this.setLayout(new BorderLayout(0,0));
   	 scrollPane=new JScrollPane();
   	 this.add(scrollPane,BorderLayout.CENTER);
        table = new JTable();
        

        table.setModel(new DefaultTableModel(data,paramter) {

        	
            @Override
            public Object getValueAt(int row, int column) {
                return data[row][column];
            }

            @Override
            public int getRowCount() {
                return 10;
            }

            @Override
            public int getColumnCount() {
                return 5;
            }
            @Override
            public void setValueAt(Object aValue, int row, int column){
                data[row][column] = aValue;
                fireTableCellUpdated(row, column);
            }
            
            @Override
            public boolean isCellEditable(int row, int column) {
                           if(column==4){
                        	   return true;
                           }
                           else
                        	   return false;
            }
            
        });

        table.getColumnModel().getColumn(4).setCellEditor(
                new ComButtonEditor());

        table.getColumnModel().getColumn(4).setCellRenderer(
                new ComButtonRenderer());

        table.setRowSelectionAllowed(false);
        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setReorderingAllowed(false);//��ʾ���е��ж��������϶�
        scrollPane.setViewportView(table);
        this.setBounds(5, 86, 434, 175);
   	    this.setVisible(true);
        this.add(scrollPane);
    }
}