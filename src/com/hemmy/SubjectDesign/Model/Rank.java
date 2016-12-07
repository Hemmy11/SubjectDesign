package com.hemmy.SubjectDesign.Model;
/**
 * @author Hemmy
 * mean:鎺掑悕绫伙紝鍖呭惈閫夋墜浠ュ強鍚嶆锛�
 * function:鐢ㄤ簬姣旇禌鎺掑悕鏌ヨ锛�
 */
public class Rank {
	private Competitor competitor;
	private int rank;
	
	public Rank(Competitor competitor,int rank){
		this.competitor =competitor;
		this.rank = rank;
	}
	public Rank() {
		
	}
	public Competitor getCompetitor() {
		return competitor;
	}
	public void setCompetitor(Competitor competitor){
		this.competitor = competitor;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}


}
