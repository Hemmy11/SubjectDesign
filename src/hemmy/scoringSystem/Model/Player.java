package hemmy.scoringSystem.Model;
/**
 * 玩家基本信息实体类，包含姓名，ID号
 */
import java.io.*;

import hemmy.scoringSystem.ExceptionDealUtily.NameException;

public class Player implements Serializable{
	private String name;
	private int id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
