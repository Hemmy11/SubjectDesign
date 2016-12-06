package com.hemmy.SubjectDesign.BLL;

import java.util.ArrayList;

import com.hemmy.SubjectDesign.Model.FullMark;
import com.hemmy.SubjectDesign.Model.Rank;

public interface ComResult {
	ArrayList<Rank> getForRank(ArrayList<com.hemmy.SubjectDesign.Model.Competitor> mm);//通过排序算法，获得循环积分比赛的名次
	ArrayList<Rank> getOutRank(ArrayList<com.hemmy.SubjectDesign.Model.MatchMessage> mm);//通过比较最后一天比赛结果，获得淘汰赛的名次

	ArrayList<FullMark> getFullMark(ArrayList<com.hemmy.SubjectDesign.Model.Competitor> mm);//通过提取分数为满分的选手，获得比赛的满分奖


}
