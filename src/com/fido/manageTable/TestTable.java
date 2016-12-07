package com.fido.manageTable;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
 * 查询选手资料的界面
 */
public class TestTable extends JPanel {

	private JScrollPane scrollPane;
    private JTable table;
    private JTextField textField01;//输入姓名或者编号的文本框
    private JComboBox comName;//选择比赛名字的下拉框
    private JComboBox findcomboBox;//选择根据姓名还是编号查询的下拉框
    private JButton findInfoButton;//查找按钮
    private
    
    Object [] paramter={"姓名","编号","性别","年龄","地址","照片"}; //表头列名

	 
	 
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



	Object [] s1 = { "小王", "213213","男", "19","504b","查看"};
    Object [] s2 = { "小芳", "142321", "女","20","504b","查看"};
    Object [] s3 = { "小王", "213213", "男","19","504b","查看"};
    Object [] s4 = { "小芳", "142321", "男","20","504b","查看"};
    Object [] s5 = { "小王", "213213", "男","19","504b","查看"};
    Object [] s6 = { "小芳", "142321", "女","20","504b","查看"};
    Object [] s7 = { "小芳", "142321", "女","20","504b","查看"};
    Object [] s8 = { "小芳", "142321", "女","20","504b","查看"};
    Object [] s9 = { "小芳", "142321", "女","20","504b","查看"};
    Object [] s10 = { "小芳", "142321", "女","20","504b","查看"};
    
    
	 Object [][] data ={s1,s2,s3,s4,s5,s6,s7,s8,s9,s10};
	 


    public TestTable() {

    this.setBorder(new EmptyBorder(5,5,5,5));
   	 this.setLayout(new BorderLayout(0,0));
   	 scrollPane=new JScrollPane();
   	 this.add(scrollPane,BorderLayout.CENTER);
		textField01 = new JTextField();
		textField01.setBounds(178, 10, 66, 21);
		this.add(textField01);
		textField01.setColumns(10);
		
 	    comName =new JComboBox();
 		comName.setBounds(10,10,80,21);
 		comName.addItem("A比赛");
 		comName.addItem("B比赛");
 		this.add(comName);
 		
		findcomboBox = new JComboBox();
		findcomboBox.setBounds(100, 10, 68, 21);
		findcomboBox.addItem("姓名");
		findcomboBox.addItem("编号");
		this.add(findcomboBox);
		
	    findInfoButton = new JButton("\u67E5\u627E");
		findInfoButton.setBounds(254, 9, 73, 23);
		findInfoButton.setBackground(Color.LIGHT_GRAY);
		this.add(findInfoButton);
		findInfoButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {//按下查找按钮的事件监听，更新table数据
			          
				
			}
		});

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
                return 6;
            }
            @Override
            public void setValueAt(Object aValue, int row, int column){
                data[row][column] = aValue;
                fireTableCellUpdated(row, column);
            }
            
            @Override
            public boolean isCellEditable(int row, int column) {
                           if(column==5){
                        	   return true;
                           }
                           else
                        	   return false;
            }
            
        });

        table.getColumnModel().getColumn(5).setCellEditor(
                new MyButtonEditor());

        table.getColumnModel().getColumn(5).setCellRenderer(
                new MyButtonRenderer());

        table.setRowSelectionAllowed(false);
        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setReorderingAllowed(false);//表示所有的列都不可以拖动
        scrollPane.setViewportView(table);
   	    this.setBounds(0, 86, 450, 175);
   	    this.setVisible(true);
        this.add(scrollPane);
    }
}