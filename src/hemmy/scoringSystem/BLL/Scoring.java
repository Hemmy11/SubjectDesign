package hemmy.scoringSystem.BLL;
/**
 * 保龄球分数计算工具类
 */
import java.util.ArrayList;

public class Scoring {
	
	public int scoringSum(ArrayList<hemmy.scoringSystem.Model.Scoring> ss){
		int sumScore = 0;
		for(int i=0;i<ss.size()-2;i++){
			    if(ss.get(i).getFirScore()==10&&ss.get(i+1).getFirScore()==10&&ss.get(i+1).getSecScore()==10){
			    	sumScore = sumScore+10+ss.get(i+1).getFirScore()+ss.get(i+1).getSecScore();
			    }else if(ss.get(i).getFirScore()==10&&ss.get(i+1).getFirScore()==10){
					sumScore = sumScore+10+10+ss.get(i+2).getFirScore();
				}else if(ss.get(i).getFirScore()==10){
					sumScore = sumScore+10+ss.get(i+1).getFirScore()+ss.get(i+1).getSecScore();
				}else if((ss.get(i).getFirScore()+ss.get(i).getSecScore())==10){
					sumScore = sumScore+10+ss.get(i+1).getFirScore();
				}else{
					sumScore = sumScore+ss.get(i).getFirScore()+ss.get(i).getSecScore();
				}
			
			}
		
		return sumScore;
		

	}
 
}
