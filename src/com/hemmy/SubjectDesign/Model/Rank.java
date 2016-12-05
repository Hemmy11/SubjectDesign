package com.hemmy.SubjectDesign.Model;
/**
 * @author Hemmy
 * mean:排名类，包含选手以及名次；
 * function:用于比赛排名查询；
 */
public class Rank {
	private String competitor;
	private int rank;
	
	public Rank(Competitor competitor,int rank){
		this.competitor = competitor.getMessage().getName();
		this.rank = rank;
	}

	public String getCompetitor() {
		return competitor;
	}
	public void setCompetitor(String competitor){
		this.competitor = competitor;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}


}
