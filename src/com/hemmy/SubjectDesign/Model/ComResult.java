package com.hemmy.SubjectDesign.Model;

import java.util.ArrayList;


/**
 * @author Hemmy
 * mean:比赛 结果类，包含归属的比赛，比赛的排名，满分人员
 * function:用于比赛结果查询
 */
public class ComResult implements com.hemmy.SubjectDesign.BLL.ComResult{
	private Competition competition;
	public Competition getCompetition() {
		return competition;
	}

	public void setCompetition(Competition competition) {
		this.competition = competition;
	}

	public ArrayList<FullMark> getFullList() {
		return fullList;
	}

	public void setFullList(ArrayList<FullMark> fullList) {
		this.fullList = fullList;
	}

	private ArrayList<Rank> rankList;
	private ArrayList<FullMark> fullList;
	
	public ArrayList<Rank> getRankList() {
		return rankList;
	}

	public void setRankList(ArrayList<Rank> rankList) {
		this.rankList = rankList;
	}

	public ComResult(){
		rankList = new ArrayList<Rank>();
		fullList = new ArrayList<FullMark>();
	}

	@Override
	public ArrayList<Rank> getForRank(ArrayList<com.hemmy.SubjectDesign.Model.Competitor> mm) {
		//���ѭ��������������
		Competitor[] sortCom=new Competitor[mm.size()];//��������õķŵ�������
		for(int i=0;i<mm.size();i++){ //�Ѽ�������Ķ������ηŵ���������
                sortCom[i]=mm.get(i);	
		}
		for(int j=1;j<sortCom.length;j++){ //Ĭ�����������һ��ѡ�ֵķ���������
			if(sortCom[j].getSumScore()>sortCom[j-1].getSumScore()){ //����ҵ��˱�Ĭ�ϵĻ�Ҫ���
				        int k=j;
				        Competitor temp=sortCom[j];
		    			 while(k>0&&sortCom[k-1].getSumScore()<temp.getSumScore()){ //��ǰ����������������λ����֮ǰ����������һ����
		    				 sortCom[k]=sortCom[k-1];//���ҵ��ȵ�ǰ��С�ģ��Ͱ�ǰ��ıȵ�ǰ�������������Ų
		    				 k--;//�Ӻ���ǰ
		    			 }//�������ѭ����k��λ��
		    			 sortCom[k]=temp;//�ٰ�ԭ���Ǹ�λ�õ�Ԫ�ش������k��λ����
			}	  
		}
        ArrayList<Rank> sortList=new ArrayList<Rank>();
        for(int h=0;h<sortCom.length;h++){
        	Rank rank=new Rank(sortCom[h],h+1);
        	sortList.add(rank);
        }
		return sortList;  //��������
	}

	@Override
	public ArrayList<FullMark> getFullMark(ArrayList<com.hemmy.SubjectDesign.Model.Competitor> mm) {
		//���ѭ�����ֱ��������ֽ�
		int comNum=mm.size()-1;//��ÿ��ѡ����˵���ܵı�����������������-1
		ArrayList<FullMark> fullCompetitor=new ArrayList<FullMark>();
      for(int i=0;i<mm.size();i++){
    	  if(mm.get(i).getSumScore()==2*comNum){
    		    FullMark full=new FullMark(mm.get(i));
    		    fullCompetitor.add(full);
    	  }
      }
		return fullCompetitor;
	}

	@Override
	public ArrayList<Rank> getOutRank(ArrayList<com.hemmy.SubjectDesign.Model.MatchMessage> mm) {
		//�����̭����ǰ����
		   ArrayList<Rank> rankList=new ArrayList<Rank>();
		   MatchMessage firstTwo=mm.get(mm.size()-2);
           MatchMessage thirdFourth=mm.get(mm.size()-1);
        if(firstTwo.getResult()==1){
     	   Rank rankOne=new Rank(firstTwo.getCom1(),1);
     	   Rank rankTwo=new Rank(firstTwo.getCom2(),2);   
     	    rankList.add(rankOne);
     	    rankList.add(rankTwo);
        }
        else{
     	   Rank rankOne=new Rank(firstTwo.getCom1(),2);
     	   Rank rankTwo=new Rank(firstTwo.getCom2(),1);   
     	    rankList.add(rankTwo);
     	    rankList.add(rankOne);
        }
        if(thirdFourth.getResult()==1){
     	   Rank rankOne=new Rank(thirdFourth.getCom1(),1);
     	   Rank rankTwo=new Rank(thirdFourth.getCom2(),2);   
     	    rankList.add(rankOne);
     	    rankList.add(rankTwo);
        }
        else{
     	   Rank rankOne=new Rank(thirdFourth.getCom1(),2);
     	   Rank rankTwo=new Rank(thirdFourth.getCom2(),1);   
     	    rankList.add(rankTwo);
     	    rankList.add(rankOne);
        }
		return rankList;
	}

}
