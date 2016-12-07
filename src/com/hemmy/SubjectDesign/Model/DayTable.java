package com.hemmy.SubjectDesign.Model;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import com.fido.datamethod.ForTableMethod;
import com.fido.datamethod.Logarithm;
import com.hemmy.SubjectDesign.DAL.CompetitiorIOUtil;
/**
 * @author Hemmy
 * mean:鏃ョ▼琛ㄧ被锛屽寘鍚墍灞炴瘮璧涘強鍏舵瘮璧涙棩绋嬩俊鎭紱
 * function:鐢ㄤ簬鏃ョ▼琛ㄧ殑鐢熸垚鍙婂叾瀛樺偍锛屼互鍙婃棩绋嬫煡璇紱
 */
public class DayTable implements com.hemmy.SubjectDesign.BLL.DayTable{
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
	
	
	@Override
	public DayTable makeTable(String name) throws ClassNotFoundException, IOException, ParseException { //根据选择名字名称生成比赛日程表
		CompetitiorIOUtil cio =new CompetitiorIOUtil();
		ArrayList<com.hemmy.SubjectDesign.Model.Competitor> list =cio.readCompetitor(this.getCompetition().getName());//读选手
		int peopleNum=list.size();//共有多少个选手
		if(name.equals("循环赛制")){
			 HashMap<Integer,Competitor> map =new HashMap<Integer,Competitor>();
			 for(int i=0;i<list.size();i++){
		    	    map.put(i+1,list.get(i)); //可以先生成数字矩阵，后把相应的数字替换成选手对象
	      }
			 ForTableMethod ft=new ForTableMethod(peopleNum);
			 ft.create(peopleNum);//生成了一个矩阵
			 ft.changeArray(map);//将数字矩阵转换为选手对象矩阵
			 Competitor[][] comArray=ft.getComInstance();
			 Date[] time=new Date[list.size()];//比赛天数=选手数-1
		     DateFormat format=DateFormat.getDateInstance();//用来生成时间
		      for(int j=0;j<time.length;j++){
		    	   String str="2016-12-"+String.valueOf(j+1);
		    	   time[j]=format.parse(str);
		      }
		      for(int i=0;i<comArray.length;i++){
		    	  for(int j=0;j<comArray[0].length-1;j++){
		    		        MatchMessage com=new MatchMessage();
		    		        com.setDate(time[j]);//设置时间
		    		        com.setCom1(comArray[i][0]);
		    		        com.setCom2(comArray[i][j+1]);
		    		        this.getDayTable().add(com); //生成每一场小比赛类然将其加入日程表类的list里面
		    	  }
		      }
	            return this;
		}
		else{ //淘汰赛制
			Date[]dayTime=new Date[(int) Logarithm.log(peopleNum, 2)];//2的对数计算共要比赛多少天
			DateFormat format=DateFormat.getDateInstance();//用来生成时间
		      for(int j=0;j<dayTime.length;j++){  //16个人，需要比赛4天，其中第四天要处理两场（决出一二，三四），共16场比赛
		    	   String str="2016-12-0"+String.valueOf(j+1);
		    	   dayTime[j]=format.parse(str);
		      }
		      for(int j=0;j<peopleNum;j=j+2){   //第一天是直接分配的，不用看结果
	  		         MatchMessage com=new MatchMessage(dayTime[0],list.get(j),list.get(j+1));
	  		         this.getDayTable().add(com);
		      }
				int start=0;
				int startSize=0;
				int tempInt=0;
			    Competitor[] temp=new Competitor[2];
	            for(int day=1;day<dayTime.length;day++){
	            	 startSize=peopleNum;
	           	    //以后的都要根据前一天的结果来决定
	           	   ArrayList<Competitor> winCompetitor = new ArrayList<Competitor>();
	           	   
	           	   for(int i=start;i<startSize;i++){ //把赢的选手都拿出来
	           		     int whoWin=this.getDayTable().get(i).getResult();
	           		     //下面这段死坑爹....丢
	           		     if(day==dayTime.length-1){ //倒数第二天（即还剩四个人的时候要特殊处理，因为不能直接淘汰，第三四名还要比一次）
	           		    	if(whoWin==1){ //如果是第一个
	              		    	 winCompetitor.add(this.getDayTable().get(i).getCom1());
	              		    	 temp[tempInt]=this.getDayTable().get(i).getCom2();
	              		     }
	              		     else{
	              		    	 winCompetitor.add(this.getDayTable().get(i).getCom2());
	              		    	 temp[tempInt]=this.getDayTable().get(i).getCom1();
	              		     }
	           		    	 tempInt++;
	           		     }   
	           		     
	           		     else{
	           		     if(whoWin==1){ //如果是第一个
	           		    	 winCompetitor.add(this.getDayTable().get(i).getCom1());
	           		     }
	           		     else{
	           		    	 winCompetitor.add(this.getDayTable().get(i).getCom2());
	           		     }
	           		     }
	           	   }
	           	   for(int h=0;h<winCompetitor.size();h=h+2){
	           		    MatchMessage com=new MatchMessage(dayTime[day],winCompetitor.get(h),winCompetitor.get(h+1));
	           		    this.getDayTable().add(com);
	           	   }
	           	   if(day==dayTime.length-1){
	           		   MatchMessage com=new MatchMessage(dayTime[day],temp[0],temp[1]);
	           		   this.getDayTable().add(com);
	           	   }
	           	   start=startSize;
	              }
			
		}
			
		
		
		return null;
	}
	@Override
	public ArrayList<ComMessage> showDayTable(String name) {
		
		return null;
	}
    
}
