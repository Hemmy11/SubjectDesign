package com.hemmy.SubjectDesign.BLL;

import java.util.ArrayList;

public interface Competition {
	void createCompetition(com.hemmy.SubjectDesign.Model.Competition competition);//创建比赛,自动生成编号
	ArrayList<com.hemmy.SubjectDesign.Model.ComResult> searchComResult(String name);//查询比赛结果
	boolean isEnough();//判断比赛人数是否已满
	boolean isOver();//判断比赛是否结束	
	void setComResult();//得到比赛结果

}
