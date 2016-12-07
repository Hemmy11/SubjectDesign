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
 * mean:日程表类，包含所属比赛及其比赛日程信息；
 * function:用于日程表的生成及其存储，以及日程查询；
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
	public DayTable makeTable(String name) throws ClassNotFoundException, IOException, ParseException { //����ѡ�������������ɱ����ճ̱�
		CompetitiorIOUtil cio =new CompetitiorIOUtil();
		ArrayList<com.hemmy.SubjectDesign.Model.Competitor> list =cio.readCompetitor(this.getCompetition().getName());//��ѡ��
		int peopleNum=list.size();//���ж��ٸ�ѡ��
		if(name.equals("ѭ������")){
			 HashMap<Integer,Competitor> map =new HashMap<Integer,Competitor>();
			 for(int i=0;i<list.size();i++){
		    	    map.put(i+1,list.get(i)); //�������������־��󣬺����Ӧ�������滻��ѡ�ֶ���
	      }
			 ForTableMethod ft=new ForTableMethod(peopleNum);
			 ft.create(peopleNum);//������һ������
			 ft.changeArray(map);//�����־���ת��Ϊѡ�ֶ������
			 Competitor[][] comArray=ft.getComInstance();
			 Date[] time=new Date[list.size()];//��������=ѡ����-1
		     DateFormat format=DateFormat.getDateInstance();//��������ʱ��
		      for(int j=0;j<time.length;j++){
		    	   String str="2016-12-"+String.valueOf(j+1);
		    	   time[j]=format.parse(str);
		      }
		      for(int i=0;i<comArray.length;i++){
		    	  for(int j=0;j<comArray[0].length-1;j++){
		    		        MatchMessage com=new MatchMessage();
		    		        com.setDate(time[j]);//����ʱ��
		    		        com.setCom1(comArray[i][0]);
		    		        com.setCom2(comArray[i][j+1]);
		    		        this.getDayTable().add(com); //����ÿһ��С������Ȼ��������ճ̱����list����
		    	  }
		      }
	            return this;
		}
		else{ //��̭����
			Date[]dayTime=new Date[(int) Logarithm.log(peopleNum, 2)];//2�Ķ������㹲Ҫ����������
			DateFormat format=DateFormat.getDateInstance();//��������ʱ��
		      for(int j=0;j<dayTime.length;j++){  //16���ˣ���Ҫ����4�죬���е�����Ҫ��������������һ�������ģ�����16������
		    	   String str="2016-12-0"+String.valueOf(j+1);
		    	   dayTime[j]=format.parse(str);
		      }
		      for(int j=0;j<peopleNum;j=j+2){   //��һ����ֱ�ӷ���ģ����ÿ����
	  		         MatchMessage com=new MatchMessage(dayTime[0],list.get(j),list.get(j+1));
	  		         this.getDayTable().add(com);
		      }
				int start=0;
				int startSize=0;
				int tempInt=0;
			    Competitor[] temp=new Competitor[2];
	            for(int day=1;day<dayTime.length;day++){
	            	 startSize=peopleNum;
	           	    //�Ժ�Ķ�Ҫ����ǰһ��Ľ��������
	           	   ArrayList<Competitor> winCompetitor = new ArrayList<Competitor>();
	           	   
	           	   for(int i=start;i<startSize;i++){ //��Ӯ��ѡ�ֶ��ó���
	           		     int whoWin=this.getDayTable().get(i).getResult();
	           		     //����������ӵ�....��
	           		     if(day==dayTime.length-1){ //�����ڶ��죨����ʣ�ĸ��˵�ʱ��Ҫ���⴦����Ϊ����ֱ����̭������������Ҫ��һ�Σ�
	           		    	if(whoWin==1){ //����ǵ�һ��
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
	           		     if(whoWin==1){ //����ǵ�һ��
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
