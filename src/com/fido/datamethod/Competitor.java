package com.fido.datamethod;

import java.io.Serializable;

/*
 * 表示选手对象
 */
public class Competitor implements Serializable {
       private int id;//选手唯一ID编号
       private String name;//选手姓名
       public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Competitor() {  //无参构造方法
		
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
