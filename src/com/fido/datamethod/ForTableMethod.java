package com.fido.datamethod;

import java.util.ArrayList;
import java.util.HashMap;

import com.hemmy.SubjectDesign.DAL.CompetitiorIOUtil;
import com.hemmy.SubjectDesign.Model.Competitor;
import com.hemmy.SubjectDesign.Model.DayTable;

/**
 * 
 * ѭ�������ɾ���
 *
 */
public class ForTableMethod {
	private int[][] competitor; //��������ѭ�����ճ̱�Ķ�ά����
	private Competitor[][] comInstance;//�����滻��ѡ�ֵ���
    public ForTableMethod(int n) {
		competitor=new int[n][n];
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
	  public void changeArray(HashMap<Integer,Competitor> map){ //��int���������Ϊѡ�ֶ�������
		  comInstance=new Competitor[competitor.length][competitor[0].length];
		      for(int i=0;i<competitor.length;i++){
		    	  for(int j=0;j<competitor[0].length;j++){
		        	     comInstance[i][j]=map.get(competitor[i][j]);  //����ֵ�滻�ɶ�Ӧ�Ķ���
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
