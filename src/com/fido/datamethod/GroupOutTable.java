package com.fido.datamethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Date;

/**
 * 
 * 淘汰赛制
 *
 */
public class GroupOutTable {
	  private ArrayList<Competitor> comListGroup=new ArrayList<Competitor>(); //存放选手，根据位置顺序决定谁跟谁比赛
	  private CompetitonTest ct=new CompetitonTest();
	  
         public CompetitonTest getCt() {
		return ct;
	}

	public void setCt(CompetitonTest ct) {
		this.ct = ct;
	}

		public ArrayList<Competitor> getComListGroup() {
		return comListGroup;
	}

	public void setComListGroup(ArrayList<Competitor> comList) {
		this.comListGroup = comList;
	}

		public void create(int peopleNum) throws FileNotFoundException, IOException, ClassNotFoundException{ 
			ObjectInputStream in=new ObjectInputStream(new FileInputStream("F://测试//选手资料")); //反序列化,读出选手信息
        	   for(int i=0;i<peopleNum;i++){
        		       comListGroup.add((Competitor) in.readObject());   //读出来的16个选手对象,放到List里面
        	   }  
        	   Date[] dayTime=new Date[ Logarithm.log(100, 10)];
        	   for(int j=0;j<this.getComListGroup().size();j++){
        		         
        	   }
        	   
         }
}
