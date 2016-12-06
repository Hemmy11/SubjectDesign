package com.hemmy.SubjectDesign.BLL;

public interface MatchMessage {
	void reviseComMessage();//修改对战信息状态（分数，胜负）；
	com.hemmy.SubjectDesign.Model.MatchMessage searchMatchMessage(String name);//根据选手名字，查询选手对战信息
	int getSumScore(int sumSocre);//获取选手该场比赛总分；
	boolean isSecondINput();//判断第二个选手是否输入
	boolean isWhoWin(int comScore1,int comScore2);//判断胜负；
	

}
