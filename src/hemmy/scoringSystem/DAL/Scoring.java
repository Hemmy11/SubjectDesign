package hemmy.scoringSystem.DAL;
/**
 * Scoring��ÿ�ֵ÷���������ļ����ݽ���
 */
import java.io.*;
public class Scoring {
	OutputStreamWriter out = null;
	
	public void writeScoring(hemmy.scoringSystem.Model.Scoring scoring) throws IOException{
		StringBuffer str = new StringBuffer(" ");
		str.append("��"+scoring.getTime()+"�ֵ÷����Ϊ:"+scoring.getFirScore()+" "+scoring.getSecScore());
		out = new OutputStreamWriter(new FileOutputStream("c:/score.txt",true));
		out.write(str.toString());
		out.flush();
		out.close();
		
	}

}
