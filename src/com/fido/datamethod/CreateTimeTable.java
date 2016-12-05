package com.fido.datamethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * 
 * ����ѭ�����ճ̱���㷨������ ��
 * ��8����������
 *
 */
public class CreateTimeTable {
	 private int[][] competitor;//��ʾ�ڼ����˵ڼ��������Ķ�����˭��һ������
	 private HashMap<Integer,Competitor> map =new HashMap<Integer,Competitor>(); //key-��ֵ��value-ѡ�ֶ���
	 private Competitor[][] comInstance;
	 
	public CreateTimeTable() {
		
	}
	  public Competitor[][] getComInstance() {
		return comInstance;
	}

	public void setComInstance(Competitor[][] comInstance) {
		this.comInstance = comInstance;
	}

	public HashMap<Integer, Competitor> getMap() {
		return map;
	}

	public void setMap(HashMap<Integer, Competitor> map) {
		this.map = map;
	}

	public int[][] getCompetitor() {
		return competitor;
	}

      public CreateTimeTable(int n) {
		competitor=new int[n][n];
	} 
	public void setCompetitor(int[][] competitor) {
		this.competitor = competitor;
	}


	public void create(int peopleNum){ //����Ϊ�μ����������ɾ���
		if(peopleNum==1)  
	    {  
	        competitor[0][0]=1;//�ݹ�߽磬��Ǻõ�һ��Ԫ��   
	    }
		else  
	    {  
	        int m=peopleNum/2;//����Ϊ�Ŀ��ÿ��ı߳�Ϊԭ����һ��   
	        create(m);//������Ͻ�   
	        int i,j;  
	        for(i=m;i<peopleNum;i++){//���½ǿ������ϽǶ�Ӧ��ÿ�����ӱ߳��õ�   
	          for(j=0;j<m;j++)  {
	            competitor[i][j]=competitor[i-m][j]+m;  
	          }
	        }
	    for(i=0;i<m;i++){//���Ͻǿ������½Ǹ��ƶ��õ�   
	      for(j=m;j<peopleNum;j++)  {
	        competitor[i][j]=competitor[i+m][j-m];  
	        }
	    }
	    for(i=m;i<peopleNum;i++){//���½ǿ������ϽǸ��ƶ��õ�   
	      for(j=m;j<peopleNum;j++)  {
	        competitor[i][j]=competitor[i-m][j-m];  
	      }
	       }
	    }  
	    
	  }
	  public void show(){
		   for(int i=0;i<comInstance.length;i++){
			   for(int j=0;j<comInstance[0].length;j++){
				   System.out.print(comInstance[i][j]+" ");
			   }
			   System.out.println(" ");
		   }
	  }
	  public void changeArray(){ //��int���������Ϊѡ�ֶ�������
		  comInstance=new Competitor[competitor.length][competitor[0].length];
		      for(int i=0;i<competitor.length;i++){
		    	  for(int j=0;j<competitor[0].length;j++){
		        	     comInstance[i][j]=map.get(competitor[i][j]);  //����ֵ�滻�ɶ�Ӧ�Ķ���
		    	  }
		      }
	  }
	
        public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, ParseException {
        	      CreateTimeTable ctt=new CreateTimeTable(16);
        	      ctt.create(16);
        		  ObjectInputStream in=new ObjectInputStream(new FileInputStream("F://����//ѡ������")); //�����л�
        		      for(int i=0;i<16;i++){
        		    	     Competitor com=(Competitor) in.readObject();//��ȡ����
        		    	     ctt.getMap().put(i+1,com);
        	      }
        		      ctt.changeArray();
        		      ctt.show();  
        		      CompetitonTest ct=new CompetitonTest();//�ܵ��ճ̱���
        		      Date[] time=new Date[ctt.getCompetitor().length-1];//��������=ѡ����-1
        		      DateFormat format=DateFormat.getDateInstance();//��������ʱ��
        		      for(int j=0;j<time.length;j++){
        		    	   String str="2016-12-"+String.valueOf(j+1);
        		    	   time[j]=format.parse(str);
        		      }
        		      for(int i=0;i<ctt.getComInstance().length;i++){
        		    	  for(int j=0;j<ctt.getComInstance()[0].length-1;j++){
        		    		        Competiton com=new Competiton();
        		    		        com.setComTime(time[j]);//����ʱ��
        		    		        com.setFirst(ctt.getComInstance()[i][0]);
        		    		        com.setSecond(ctt.getComInstance()[i][j+1]);
        		    		        ct.getComList().add(com);
        		    	  }
        		      }
        		      
        		     for(int i=0;i<ct.getComList().size();i++){
        		    	 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");    
        		    	 String str=sdf.format(ct.getComList().get(i).getComTime());
        		    	 System.out.print(str+" ");
        		    	 System.out.print(ct.getComList().get(i).getFirst().getName()+" ");
        		    	 System.out.print(ct.getComList().get(i).getSecond().getName());
        		    	 System.out.println(" ");
        		     } 
        		      
}
        }
