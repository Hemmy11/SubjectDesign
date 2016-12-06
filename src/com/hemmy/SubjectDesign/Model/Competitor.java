package com.hemmy.SubjectDesign.Model;
/**
 * @author Hemmy
 * mean:閫夋墜绫�,鍖呭惈閫夋墜褰掑睘鐨勬瘮璧涳紝缂栧彿锛岄�夋墜绉垎浠ュ強閫夋墜鐨勪俊鎭�
 * function:鐢ㄤ簬閫夋墜瀵瑰簲姣旇禌鐨勫瓨鍌紝
 */
public class Competitor {
	private String id;
	private ComMessage message;
	private Competition competition;
	private String password;
	
	public Competitor(int id,ComMessage message,Competition competition){
		this.id = competition.getId()+"m"+id;
		this.password = message.getAge()+this.id;//鐢卞勾榫勪笌缂栧彿鐢熸垚鍒濆瀵嗙爜锛�
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
