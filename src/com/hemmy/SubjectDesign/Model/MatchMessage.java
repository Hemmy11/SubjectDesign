package com.hemmy.SubjectDesign.Model;

import java.util.Date;

/**
 * @author Hemmy
 * mean:对战信息类，包括对战时间，对战选手，对战胜负,对战选手得分
 * function:用于管理员生成日程表，以及查看对战信息
 */
public class MatchMessage implements com.hemmy.SubjectDesign.BLL.MatchMessage{
	private Date date;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Competitor getCom1() {
		return com1;
	}
	public void setCom1(Competitor com1) {
		this.com1 = com1;
	}
	public Competitor getCom2() {
		return com2;
	}
	public void setCom2(Competitor com2) {
		this.com2 = com2;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	private Competitor com1;
	private Competitor com2;
	public int getCom1Score() {
		return com1Score;
	}
	public void setCom1Score(int com1Score) {
		this.com1Score = com1Score;
	}
	public int getCom2Score() {
		return com2Score;
	}
	public void setCom2Score(int com2Score) {
		this.com2Score = com2Score;
	}
	private int com1Score=0;
	private int com2Score=0;
	private int result=0;//0表示未比赛，1表示选手1获胜，2表示选手2获胜
	@Override
	public void reviseComMessage() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public MatchMessage searchMatchMessage(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int getSumScore(int sumSocre) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean isSecondINput() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isWhoWin(int comScore1, int comScore2) {
		// TODO Auto-generated method stub
		return false;
	}

}
