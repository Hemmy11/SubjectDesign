package com.fido.datamethod;

import java.util.Date;

/**
 * 
 * С�������������ʱ���������սѡ��
 *
 */
public class Competiton {
      private Date comTime;
      private Competitor first;
      private Competitor second;
      private boolean winCom;//��־�ⳡС������˭Ӯ��
      public boolean isWinCom() {
		return winCom;
	}
	public void setWinCom(boolean winCom) {
		this.winCom = winCom;
	}
	public Competiton() { //�޲ι��췽��
		   this.winCom=true;//true�Ļ���Ĭ����firstѡ��Ӯ�ˣ������ٸ�
	}
      public Competiton(Date comTime,Competitor first,Competitor second){
    	  this.comTime=comTime;
    	  this.first=first;
    	  this.second=second;
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
