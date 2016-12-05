package hemmy.scoringSystem.Model;
/**
 * 玩家每轮总得分信息实体类
 */
import java.io.Serializable;

public class SumScore implements Serializable{
	private int SumScore;

	public int getSumScore() {
		return SumScore;
	}

	public void setSumScore(int sumScore) {
		SumScore = sumScore;
	}

}
