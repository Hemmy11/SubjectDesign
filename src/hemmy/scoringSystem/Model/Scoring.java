package hemmy.scoringSystem.Model;
/**
 * 玩家得分信息实体类，包含第几轮，该轮第一次得分，第二次得分
 */
public class Scoring{
	private int firScore;
	private int secScore;
	private int time;
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	

	public int getFirScore() {
		return firScore;
	}
	public void setFirScore(int firScore) {
		this.firScore = firScore;
	}
	public int getSecScore() {
		return secScore;
	}
	public void setSecScore(int secScore) {
		this.secScore = secScore;
	}
}
