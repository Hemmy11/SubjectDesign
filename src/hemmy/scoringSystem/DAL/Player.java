package hemmy.scoringSystem.DAL;
/**
 * Player与文件数据交互类
 */

import java.io.*;
public class Player {
	OutputStreamWriter out = null;
	ObjectInputStream inObject = null;
	ObjectOutputStream outObject = null;
	public void writePlayer(hemmy.scoringSystem.Model.Player player) throws IOException{
		StringBuffer str = new StringBuffer(" ");
		str.append("玩家 "+player.getName());
		str.append(" ID "+player.getId());
		out = new OutputStreamWriter(new FileOutputStream("c:/score.txt",true));
		out.write(str.toString());
		out.flush();
		out.close();
		
	}
	public void writeNull() throws IOException{
		File file = new File("c:/scorePlayer.dat");		
		if(file.length()<1){
			outObject = new ObjectOutputStream(new FileOutputStream(file,true));
		}else{
			outObject = new MyObjectOutputStream(new FileOutputStream(file,true));
		}
		outObject.writeObject(null);
		outObject.flush();
		outObject.close();
		
	}
	
	public void writePlayerUtil(hemmy.scoringSystem.Model.Player player) throws IOException{
		File file = new File("c:/scorePlayer.dat");		
		if(file.length()<1){
			outObject = new ObjectOutputStream(new FileOutputStream(file,true));
		}else{
			outObject = new MyObjectOutputStream(new FileOutputStream(file,true));
		}
		outObject.writeObject(player);
		outObject.flush();
		outObject.close();
		
	}
	
	public hemmy.scoringSystem.Model.Player readPlayer() throws IOException, ClassNotFoundException{
		inObject = new ObjectInputStream(new FileInputStream("c:/scorePlayer.dat"));
		hemmy.scoringSystem.Model.Player player = (hemmy.scoringSystem.Model.Player)inObject.readObject();
		inObject.close();
		return player;
		
	}
	
	public void deletePlayer(){
		File file = new File("c:/scorePlayer.dat");	
		file.delete();
	}
	

}
