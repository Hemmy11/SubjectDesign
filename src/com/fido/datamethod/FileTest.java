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
    	for(int i=0;i<16;i++){  //假设16个选手的编号为1-16
    		char name=(char) (65+i);
    		list.add(new Competitor(i+1,String.valueOf(name))); //姓名假设为A-P
    	}
    }
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		      FileTest ft=new FileTest();
		      ft.createInstance();
		      ObjectOutputStream op=new ObjectOutputStream(new FileOutputStream("F://测试//选手资料")); //序列化对象
		      for(int i=0;i<ft.getList().size();i++){
		    	  op.writeObject(ft.getList().get(i));
		      }
		      op.flush();
		      op.close();

	}
	
	

}
