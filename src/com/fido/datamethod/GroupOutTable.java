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
 * ��̭����
 *
 */
public class GroupOutTable {
	  private ArrayList<Competitor> comListGroup=new ArrayList<Competitor>(); //���ѡ�֣�����λ��˳�����˭��˭����
	  private CompetitonTest ct=new CompetitonTest();
	  private Date[]dayTime=new Date[(int) Logarithm.log(16, 2)];//2�Ķ���//�������
	  
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
	      DateFormat format=DateFormat.getDateInstance();//��������ʱ��
      for(int j=0;j<dayTime.length;j++){  //16���ˣ���Ҫ����4�죬���е�����Ҫ��������������һ�������ģ�����16������
    	   String str="2016-12-0"+String.valueOf(j+1);
    	   dayTime[j]=format.parse(str);
      }
	}

		public void create(int peopleNum) throws FileNotFoundException, IOException, ClassNotFoundException, ParseException{ 
			ObjectInputStream in=new ObjectInputStream(new FileInputStream("F://����//ѡ������")); //�����л�,����ѡ����Ϣ
        	   for(int i=0;i<peopleNum;i++){
        		       comListGroup.add((Competitor) in.readObject());   //��������16��ѡ�ֶ���,�ŵ�List����
        	   }  
        	   createTime();

		      for(int j=0;j<this.getComListGroup().size();j=j+2){   //��һ����ֱ�ӷ���ģ����ÿ����
	  		         Competiton com=new Competiton(dayTime[0],this.getComListGroup().get(j),this.getComListGroup().get(j+1),false);
	  		         ct.getComList().add(com);//�Ž��ܵ��ճ̱�������  	
		      }  
         }
		public void createLater(){
			int start=0;
			int startSize=0;
			int tempInt=0;
		    Competitor[] temp=new Competitor[2];
            for(int day=1;day<dayTime.length;day++){
            	 startSize=ct.getComList().size();
           	    //�Ժ�Ķ�Ҫ����ǰһ��Ľ��������
           	   ArrayList<Competitor> winCompetitor = new ArrayList<Competitor>();
           	   
           	   for(int i=start;i<startSize;i++){ //��Ӯ��ѡ�ֶ��ó���
           		     boolean whoWin=ct.getComList().get(i).isWinCom();
           		     //����������ӵ�....��
           		     if(day==dayTime.length-1){ //�����ڶ��죨����ʣ�ĸ��˵�ʱ��Ҫ���⴦����Ϊ����ֱ����̭������������Ҫ��һ�Σ�
           		    	if(whoWin==true){ //����ǵ�һ��
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
           		     if(whoWin==true){ //����ǵ�һ��
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
