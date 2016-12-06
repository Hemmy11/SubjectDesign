package com.hemmy.SubjectDesign.Model;

import java.util.ArrayList;

import com.hemmy.SubjectDesign.BLL.Competitor;
import com.hemmy.SubjectDesign.BLL.MatchMessage;

/**
 * @author Hemmy
 * mean:比赛 结果类，包含归属的比赛，比赛的排名，满分人员
 * function:用于比赛结果查询
 */
public class ComResult implements com.hemmy.SubjectDesign.BLL.ComResult{
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

	@Override
	public ArrayList<Rank> getForRank(ArrayList<com.hemmy.SubjectDesign.Model.Competitor> mm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<FullMark> getFullMark(ArrayList<com.hemmy.SubjectDesign.Model.Competitor> mm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Rank> getOutRank(ArrayList<com.hemmy.SubjectDesign.Model.MatchMessage> mm) {
		// TODO Auto-generated method stub
		return null;
	}

}
