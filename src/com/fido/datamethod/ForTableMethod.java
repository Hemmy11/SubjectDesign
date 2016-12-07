package com.fido.datamethod;

import java.util.ArrayList;
import java.util.HashMap;

import com.hemmy.SubjectDesign.DAL.CompetitiorIOUtil;
import com.hemmy.SubjectDesign.Model.Competitor;
import com.hemmy.SubjectDesign.Model.DayTable;

/**
 * 
 * 循环赛生成矩阵
 *
 */
public class ForTableMethod {
	private int[][] competitor; //用来生成循环赛日程表的二维数组
	private Competitor[][] comInstance;//后面替换成选手的类
    public ForTableMethod(int n) {
		competitor=new int[n][n];
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
	  public void changeArray(HashMap<Integer,Competitor> map){ //将int类型数组变为选手对象数组
		  comInstance=new Competitor[competitor.length][competitor[0].length];
		      for(int i=0;i<competitor.length;i++){
		    	  for(int j=0;j<competitor[0].length;j++){
		        	     comInstance[i][j]=map.get(competitor[i][j]);  //将数值替换成对应的对象
		    	  }
		      }
	  }
	public int[][] getCompetitor() {
		return competitor;
	}
	public void setCompetitor(int[][] competitor) {
		this.competitor = competitor;
	}
	public Competitor[][] getComInstance() {
		return comInstance;
	}
	public void setComInstance(Competitor[][] comInstance) {
		this.comInstance = comInstance;
	}
}
