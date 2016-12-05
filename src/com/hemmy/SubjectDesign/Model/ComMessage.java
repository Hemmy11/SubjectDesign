package com.hemmy.SubjectDesign.Model;
import java.awt.Image;
/**
 * @author Hemmy 
 *  mean:选手资料类，包含选手的基本信息（名字，年龄，性别，通讯地址，照片）
 *  function:用于选手信息修改以及查看对手信息
 */
public class ComMessage {
	private String name,address;
	private int age;
	private boolean isMale;
	private Image comImage;
	
	public ComMessage(String name,int age,boolean isMale,String address,Image comImage){
		this.name = name;
		this.age = age;
		this.isMale = isMale;
		this.address = address;
		this.comImage = comImage;
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isMale() {
		return isMale;
	}
	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}
	public Image getComImage() {
		return comImage;
	}
	public void setComImage(Image comImage) {
		this.comImage = comImage;
	}
	
	
	

}
