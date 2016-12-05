package com.fido.datamethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * 
 * 淘汰赛制
 *
 */
public class GroupOutTable {
	  private ArrayList<Competitor> comListGroup=new ArrayList<Competitor>(); //存放选手，根据位置顺序决定谁跟谁比赛
	  private CompetitonTest ct=new CompetitonTest();
	  private Date[]dayTime=new Date[(int) Logarithm.log(16, 2)];//2的对数//存放日期
	  
         public Date[] getDayTime() {
		return dayTime;
	}

	public void setDayTime(Date[] dayTime) {
		this.dayTime = dayTime;
	}

		public CompetitonTest getCt() {
		return ct;
	}

	public void setCt(CompetitonTest ct) {
		this.ct = ct;
	}

		public ArrayList<Competitor> getComListGroup() {
		return comListGroup;
	}

	public void setComListGroup(ArrayList<Competitor> comList) {
		this.comListGroup = comList;
	}
	public void createTime() throws ParseException{
	      DateFormat format=DateFormat.getDateInstance();//用来生成时间
      for(int j=0;j<dayTime.length;j++){  //16个人，需要比赛4天，其中第四天要处理两场（决出一二，三四），共16场比赛
    	   String str="2016-12-0"+String.valueOf(j+1);
    	   dayTime[j]=format.parse(str);
      }
	}

		public void create(int peopleNum) throws FileNotFoundException, IOException, ClassNotFoundException, ParseException{ 
			ObjectInputStream in=new ObjectInputStream(new FileInputStream("F://测试//选手资料")); //反序列化,读出选手信息
        	   for(int i=0;i<peopleNum;i++){
        		       comListGroup.add((Competitor) in.readObject());   //读出来的16个选手对象,放到List里面
        	   }  
        	   createTime();

		      for(int j=0;j<this.getComListGroup().size();j=j+2){   //第一天是直接分配的，不用看结果
	  		         Competiton com=new Competiton(dayTime[0],this.getComListGroup().get(j),this.getComListGroup().get(j+1),false);
	  		         ct.getComList().add(com);//放进总的日程表类里面  	
		      }  
         }
		public void createLater(){
			int start=0;
			int startSize=0;
			int tempInt=0;
		    Competitor[] temp=new Competitor[2];
            for(int day=1;day<dayTime.length;day++){
            	 startSize=ct.getComList().size();
           	    //以后的都要根据前一天的结果来决定
           	   ArrayList<Competitor> winCompetitor = new ArrayList<Competitor>();
           	   
           	   for(int i=start;i<startSize;i++){ //把赢的选手都拿出来
           		     boolean whoWin=ct.getComList().get(i).isWinCom();
           		     //下面这段死坑爹....丢
           		     if(day==dayTime.length-1){ //倒数第二天（即还剩四个人的时候要特殊处理，因为不能直接淘汰，第三四名还要比一次）
           		    	if(whoWin==true){ //如果是第一个
              		    	 winCompetitor.add(ct.getComList().get(i).getFirst());
              		    	 temp[tempInt]=ct.getComList().get(i).getSecond();
              		     }
              		     else{
              		    	 winCompetitor.add(ct.getComList().get(i).getSecond());
              		    	 temp[tempInt]=ct.getComList().get(i).getFirst();
              		     }
           		    	 tempInt++;
           		     }   
           		     
           		     else{
           		     if(whoWin==true){ //如果是第一个
           		    	 winCompetitor.add(ct.getComList().get(i).getFirst());
           		     }
           		     else{
           		    	 winCompetitor.add(ct.getComList().get(i).getSecond());
           		     }
           		     }
           	   }
           	   for(int h=0;h<winCompetitor.size();h=h+2){
           		    Competiton com=new Competiton(dayTime[day],winCompetitor.get(h),winCompetitor.get(h+1),false);
           		    ct.getComList().add(com);
           	   }
           	   if(day==dayTime.length-1){
           		   Competiton com=new Competiton(dayTime[day],temp[0],temp[1],false);
           		   ct.getComList().add(com);
           	   }
           	   start=startSize;
              }
		}
		public void show(){
			 for(int i=0;i<ct.getComList().size();i++){
				 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");    
		    	 String str=sdf.format(ct.getComList().get(i).getComTime());
				 System.out.print(str+" ");
				 System.out.print(ct.getComList().get(i).getFirst()+" ");
				 System.out.println(ct.getComList().get(i).getSecond());
			 }
		}
		public static void main(String [] args) throws FileNotFoundException, ClassNotFoundException, IOException, ParseException{
			   GroupOutTable  go=new GroupOutTable();
			   go.create(16);
			   go.createLater();
			   go.show();
		}
}
