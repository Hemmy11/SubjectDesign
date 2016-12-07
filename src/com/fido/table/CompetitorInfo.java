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
 * 对应于选手的查看对手信息
 */
public class CompetitorInfo extends JPanel {

	private JScrollPane scrollPane;
    private JTable table;
    
    
    Object [] paramter={"对手名字","对手编号","对手年龄","比赛时间","对手照片"}; //表头列名

	 
	 
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



	Object [] s1 = { "小王", "213213", "19","2016-11-30","查看"};
    Object [] s2 = { "小芳", "142321", "20","2016-11-30","查看"};
    Object [] s3 = { "小王", "213213", "19","2016-11-30","查看"};
    Object [] s4 = { "小芳", "142321", "20","2016-11-30","查看"};
    Object [] s5 = { "小王", "213213", "19","2016-11-30","查看"};
    Object [] s6 = { "小芳", "142321", "20","2016-11-30","查看"};
    Object [] s7 = { "小芳", "142321", "20","2016-11-30","查看"};
    Object [] s8 = { "小芳", "142321", "20","2016-11-30","查看"};
    Object [] s9 = { "小芳", "142321", "20","2016-11-30","查看"};
    Object [] s10 = { "小芳", "142321", "20","2016-11-30","查看"};
    
    
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
        tableHeader.setReorderingAllowed(false);//表示所有的列都不可以拖动
        scrollPane.setViewportView(table);
        this.setBounds(5, 86, 434, 175);
   	    this.setVisible(true);
        this.add(scrollPane);
    }
}