package com.fido.datamethod;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileTest {
    private ArrayList<Competitor> list ;
	
	
	public ArrayList<Competitor> getList() {
		return list;
	}


	public void setList(ArrayList<Competitor> list) {
		this.list=list;
	}
   
    public void createInstance(){
    	list=new ArrayList<Competitor>();
    	for(int i=0;i<16;i++){  //����16��ѡ�ֵı��Ϊ1-16
    		char name=(char) (65+i);
    		list.add(new Competitor(i+1,String.valueOf(name))); //��������ΪA-P
    	}
    }
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		      FileTest ft=new FileTest();
		      ft.createInstance();
		      ObjectOutputStream op=new ObjectOutputStream(new FileOutputStream("F://����//ѡ������")); //���л�����
		      for(int i=0;i<ft.getList().size();i++){
		    	  op.writeObject(ft.getList().get(i));
		      }
		      op.flush();
		      op.close();

	}
	
	

}
