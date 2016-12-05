package com.hemmy.SubjectDesign.Model;
/**
 * @author Hemmy
 * mean:大型比赛类,包含该比赛的信息（比赛编号，比赛名称）
 * function:
 */
public class Competition {
	private int id;
	private String name;
	private boolean isFinished=false;
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

}
