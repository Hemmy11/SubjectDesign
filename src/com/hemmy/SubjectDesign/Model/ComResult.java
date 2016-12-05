package com.hemmy.SubjectDesign.Model;

import java.util.ArrayList;

/**
 * @author Hemmy
 * mean:比赛 结果类，包含归属的比赛，比赛的排名，满分人员
 * function:用于比赛结果查询
 */
public class ComResult {
	private Competition competition;
	public Competition getCompetition() {
		return competition;
	}

	public void setCompetition(Competition competition) {
		this.competition = competition;
	}

	public ArrayList<FullMark> getFullList() {
		return fullList;
	}

	public void setFullList(ArrayList<FullMark> fullList) {
		this.fullList = fullList;
	}

	private ArrayList<Rank> rankList;
	private ArrayList<FullMark> fullList;
	
	public ArrayList<Rank> getRankList() {
		return rankList;
	}

	public void setRankList(ArrayList<Rank> rankList) {
		this.rankList = rankList;
	}

	public ComResult(){
		rankList = new ArrayList<Rank>();
		fullList = new ArrayList<FullMark>();
	}

}