package com.fido.datamethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Date;

/**
 * 
 * ��̭����
 *
 */
public class GroupOutTable {
	  private ArrayList<Competitor> comListGroup=new ArrayList<Competitor>(); //���ѡ�֣�����λ��˳�����˭��˭����
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
			ObjectInputStream in=new ObjectInputStream(new FileInputStream("F://����//ѡ������")); //�����л�,����ѡ����Ϣ
        	   for(int i=0;i<peopleNum;i++){
        		       comListGroup.add((Competitor) in.readObject());   //��������16��ѡ�ֶ���,�ŵ�List����
        	   }  
        	   Date[] dayTime=new Date[ Logarithm.log(100, 10)];
        	   for(int j=0;j<this.getComListGroup().size();j++){
        		         
        	   }
        	   
         }
}
