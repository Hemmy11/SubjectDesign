package com.hemmy.SubjectDesign.Model;

import java.util.ArrayList;


/**
 * @author Hemmy
 * mean:姣旇禌 缁撴灉绫伙紝鍖呭惈褰掑睘鐨勬瘮璧涳紝姣旇禌鐨勬帓鍚嶏紝婊″垎浜哄憳
 * function:鐢ㄤ簬姣旇禌缁撴灉鏌ヨ
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
		//获得循环积分赛的排名
		Competitor[] sortCom=new Competitor[mm.size()];//后面排序好的放到这里面
		for(int i=0;i<mm.size();i++){ //把集合里面的对象依次放到数组里面
                sortCom[i]=mm.get(i);	
		}
		for(int j=1;j<sortCom.length;j++){ //默认数组里面第一个选手的分数是最大的
			if(sortCom[j].getSumScore()>sortCom[j-1].getSumScore()){ //如果找到了比默认的还要大的
				        int k=j;
				        Competitor temp=sortCom[j];
		    			 while(k>0&&sortCom[k-1].getSumScore()<temp.getSumScore()){ //当前的这个待排序的数与位于它之前的所有数逐一排序
		    				 sortCom[k]=sortCom[k-1];//若找到比当前还小的，就把前面的比当前的数大的数往后挪
		    				 k--;//从后往前
		    			 }//最后跳出循环的k的位置
		    			 sortCom[k]=temp;//再把原先那个位置的元素带回这个k的位置中
			}	  
		}
        ArrayList<Rank> sortList=new ArrayList<Rank>();
        for(int h=0;h<sortCom.length;h++){
        	Rank rank=new Rank(sortCom[h],h+1);
        	sortList.add(rank);
        }
		return sortList;  //插入排序
	}

	@Override
	public ArrayList<FullMark> getFullMark(ArrayList<com.hemmy.SubjectDesign.Model.Competitor> mm) {
		//获得循环积分比赛的满分奖
		int comNum=mm.size()-1;//对每个选手来说，总的比赛场数就是总人数-1
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
		//获得淘汰赛的前四名
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
