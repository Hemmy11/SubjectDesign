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
 * ��ѯѡ�����ϵĽ���
 */
public class TestTable extends JPanel {

	private JScrollPane scrollPane;
    private JTable table;
    private JTextField textField01;//�����������߱�ŵ��ı���
    private JComboBox comName;//ѡ��������ֵ�������
    private JComboBox findcomboBox;//ѡ������������Ǳ�Ų�ѯ��������
    private JButton findInfoButton;//���Ұ�ť
    private
    
    Object [] paramter={"����","���","�Ա�","����","��ַ","��Ƭ"}; //��ͷ����

	 
	 
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



	Object [] s1 = { "С��", "213213","��", "19","504b","�鿴"};
    Object [] s2 = { "С��", "142321", "Ů","20","504b","�鿴"};
    Object [] s3 = { "С��", "213213", "��","19","504b","�鿴"};
    Object [] s4 = { "С��", "142321", "��","20","504b","�鿴"};
    Object [] s5 = { "С��", "213213", "��","19","504b","�鿴"};
    Object [] s6 = { "С��", "142321", "Ů","20","504b","�鿴"};
    Object [] s7 = { "С��", "142321", "Ů","20","504b","�鿴"};
    Object [] s8 = { "С��", "142321", "Ů","20","504b","�鿴"};
    Object [] s9 = { "С��", "142321", "Ů","20","504b","�鿴"};
    Object [] s10 = { "С��", "142321", "Ů","20","504b","�鿴"};
    
    
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
 		comName.addItem("A����");
 		comName.addItem("B����");
 		this.add(comName);
 		
		findcomboBox = new JComboBox();
		findcomboBox.setBounds(100, 10, 68, 21);
		findcomboBox.addItem("����");
		findcomboBox.addItem("���");
		this.add(findcomboBox);
		
	    findInfoButton = new JButton("\u67E5\u627E");
		findInfoButton.setBounds(254, 9, 73, 23);
		findInfoButton.setBackground(Color.LIGHT_GRAY);
		this.add(findInfoButton);
		findInfoButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {//���²��Ұ�ť���¼�����������table����
			          
				
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
        tableHeader.setReorderingAllowed(false);//��ʾ���е��ж��������϶�
        scrollPane.setViewportView(table);
   	    this.setBounds(0, 86, 450, 175);
   	    this.setVisible(true);
        this.add(scrollPane);
    }
}