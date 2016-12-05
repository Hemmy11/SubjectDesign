package com.fido.datamethod;

import java.util.Date;

/**
 * 
 * 小比赛类包含比赛时间和两个对战选手
 *
 */
public class Competiton {
      private Date comTime;
      private Competitor first;
      private Competitor second;
      private boolean winCom;//标志这场小比赛里谁赢了
      public boolean isWinCom() {
		return winCom;
	}
	public void setWinCom(boolean winCom) {
		this.winCom = winCom;
	}
	public Competiton() { //无参构造方法

	}
      public Competiton(Date comTime,Competitor first,Competitor second,boolean winCom){
    	  this.comTime=comTime;
    	  this.first=first;
    	  this.second=second;
    	  this.winCom=winCom;
      }
      
	public Date getComTime() {
		return comTime;
	}
	public void setComTime(Date comTime) {
		this.comTime = comTime;
	}
	public Competitor getFirst() {
		return first;
	}
	public void setFirst(Competitor first) {
		this.first = first;
	}
	public Competitor getSecond() {
		return second;
	}
	public void setSecond(Competitor second) {
		this.second = second;
	}
	
      
}
