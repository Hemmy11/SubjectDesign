package com.hemmy.SubjectDesign.Model;
/**
 * @author Hemmy
 * mean:选手类,包含选手归属的比赛，编号，选手积分以及选手的信息
 * function:用于选手对应比赛的存储，
 */
public class Competitor {
	private String id;
	private ComMessage message;
	private Competition competition;
	private String password;
	
	public Competitor(int id,ComMessage message,Competition competition){
		this.id = competition.getId()+"m"+id;
		this.password = message.getAge()+this.id;//由年龄与编号生成初始密码；
		this.message = message;
		this.competition = competition;
	}
	public String getId() {
		return id;
	}


	public void setId(int id) {
		this.id = competition.getId()+id+"";
	}
	
	public int getSumScore() {
		return sumScore;
	}
	public void setSumScore(int sumScore) {
		this.sumScore = sumScore;
	}
	private int sumScore;
	public ComMessage getMessage() {
		return message;
	}
	public void setMessage(ComMessage message) {
		this.message = message;
	}
	public Competition getCompetition() {
		return competition;
	}
	public void setCompetition(Competition competition) {
		this.competition = competition;
	}

}
