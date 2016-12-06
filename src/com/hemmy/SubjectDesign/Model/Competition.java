package com.hemmy.SubjectDesign.Model;

import java.util.ArrayList;

/**
 * @author Hemmy
 * mean:大型比赛类,包含该比赛的信息（比赛编号，比赛名称）
 * function:
 */
public class Competition implements com.hemmy.SubjectDesign.BLL.Competition{
	private int id;
	private String name;
	private boolean isFinished=false;
	
	public Competition(int id,String name){
		this.id = id;
		this.name = name;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isFinished() {
		return isFinished;
	}
	public void setFinished(boolean isFinished) {
		this.isFinished = isFinished;
	}
	/**
	 * 创建该比赛，将比赛写入存储比赛的文档
	 * @param name
	 */
	@Override
	public void createCompetition(Competition competition) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public ArrayList<ComResult> searchComResult(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean isEnough() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isOver() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void setComResult() {
		// TODO Auto-generated method stub
		
	}

}
