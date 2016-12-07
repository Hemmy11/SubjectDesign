package com.hemmy.SubjectDesign.Model;

import java.util.Date;

/**
 * @author Hemmy
 * mean:瀵规垬淇℃伅绫伙紝鍖呮嫭瀵规垬鏃堕棿锛屽鎴橀�夋墜锛屽鎴樿儨璐�,瀵规垬閫夋墜寰楀垎
 * function:鐢ㄤ簬绠＄悊鍛樼敓鎴愭棩绋嬭〃锛屼互鍙婃煡鐪嬪鎴樹俊鎭�
 */
public class MatchMessage implements com.hemmy.SubjectDesign.BLL.MatchMessage{
	private Date date;
	
	public MatchMessage(Date date, Competitor com1, Competitor com2) {
		super();
		this.date = date;
		this.com1 = com1;
		this.com2 = com2;
		this.com1Score =0;
		this.com2Score = 0;
		this.result = 0;
	}
	public MatchMessage() { 
		
	}
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
	private int result=0;//0琛ㄧず鏈瘮璧涳紝1琛ㄧず閫夋墜1鑾疯儨锛�2琛ㄧず閫夋墜2鑾疯儨
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
