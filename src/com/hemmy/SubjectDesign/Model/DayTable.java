package com.hemmy.SubjectDesign.Model;

import java.util.ArrayList;
/**
 * @author Hemmy
 * mean:日程表类，包含所属比赛及其比赛日程信息；
 * function:用于日程表的生成及其存储，以及日程查询；
 */
public class DayTable {
	public ArrayList<MatchMessage> getDayTable() {
		return dayTable;
	}
	public void setDayTable(ArrayList<MatchMessage> dayTable) {
		this.dayTable = dayTable;
	}
	public Competition getCompetition() {
		return competition;
	}
	public void setCompetition(Competition competition) {
		this.competition = competition;
	}
	private ArrayList<MatchMessage> dayTable;
	private Competition competition;

}
