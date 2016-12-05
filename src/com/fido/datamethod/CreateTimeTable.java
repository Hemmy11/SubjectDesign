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
 * 生成循环赛日程表的算法（分治 ）
 * 以8个人做测试
 *
 */
public class CreateTimeTable {
	 private int[][] competitor;//表示第几个人第几天遇到的对手是谁的一个矩阵
	 private HashMap<Integer,Competitor> map =new HashMap<Integer,Competitor>(); //key-数值，value-选手对象
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


	public void create(int peopleNum){ //参数为参加人数，生成矩阵
		if(peopleNum==1)  
	    {  
	        competitor[0][0]=1;//递归边界，标记好第一个元素   
	    }
		else  
	    {  
	        int m=peopleNum/2;//划分为四块后，每块的边长为原来的一半   
	        create(m);//求解左上角   
	        int i,j;  
	        for(i=m;i<peopleNum;i++){//左下角可由左上角对应的每个数加边长得到   
	          for(j=0;j<m;j++)  {
	            competitor[i][j]=competitor[i-m][j]+m;  
	          }
	        }
	    for(i=0;i<m;i++){//右上角可由左下角复制而得到   
	      for(j=m;j<peopleNum;j++)  {
	        competitor[i][j]=competitor[i+m][j-m];  
	        }
	    }
	    for(i=m;i<peopleNum;i++){//右下角可由左上角复制而得到   
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
	  public void changeArray(){ //将int类型数组变为选手对象数组
		  comInstance=new Competitor[competitor.length][competitor[0].length];
		      for(int i=0;i<competitor.length;i++){
		    	  for(int j=0;j<competitor[0].length;j++){
		        	     comInstance[i][j]=map.get(competitor[i][j]);  //将数值替换成对应的对象
		    	  }
		      }
	  }
	
        public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, ParseException {
        	      CreateTimeTable ctt=new CreateTimeTable(16);
        	      ctt.create(16);
        		  ObjectInputStream in=new ObjectInputStream(new FileInputStream("F://测试//选手资料")); //反序列化
        		      for(int i=0;i<16;i++){
        		    	     Competitor com=(Competitor) in.readObject();//读取对象
        		    	     ctt.getMap().put(i+1,com);
        	      }
        		      ctt.changeArray();
        		      ctt.show();  
        		      CompetitonTest ct=new CompetitonTest();//总的日程表类
        		      Date[] time=new Date[ctt.getCompetitor().length-1];//比赛天数=选手数-1
        		      DateFormat format=DateFormat.getDateInstance();//用来生成时间
        		      for(int j=0;j<time.length;j++){
        		    	   String str="2016-12-"+String.valueOf(j+1);
        		    	   time[j]=format.parse(str);
        		      }
        		      for(int i=0;i<ctt.getComInstance().length;i++){
        		    	  for(int j=0;j<ctt.getComInstance()[0].length-1;j++){
        		    		        Competiton com=new Competiton();
        		    		        com.setComTime(time[j]);//设置时间
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
