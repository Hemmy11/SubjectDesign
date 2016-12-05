package hemmy.scoringSystem.DAL;
/**
 * Scoring（每轮得分情况）与文件数据交互
 */
import java.io.*;
public class Scoring {
	OutputStreamWriter out = null;
	
	public void writeScoring(hemmy.scoringSystem.Model.Scoring scoring) throws IOException{
		StringBuffer str = new StringBuffer(" ");
		str.append("第"+scoring.getTime()+"轮得分情况为:"+scoring.getFirScore()+" "+scoring.getSecScore());
		out = new OutputStreamWriter(new FileOutputStream("c:/score.txt",true));
		out.write(str.toString());
		out.flush();
		out.close();
		
	}

}
