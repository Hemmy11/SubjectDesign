package com.fido.datamethod;

import java.io.Serializable;

/*
 * ��ʾѡ�ֶ���
 */
public class Competitor implements Serializable {
       private int id;//ѡ��ΨһID���
       private String name;//ѡ������
       public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Competitor() {  //�޲ι��췽��
		
	}
       public Competitor(int id,String name){
    	   this.id=id;
    	   this.name=name;
       }
       

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "id="+id+"name="+name;
	}
}
