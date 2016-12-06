package com.hemmy.SubjectDesign.DAL;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import com.hemmy.SubjectDesign.Model.Competition;

public class CompetitionIOUtil{
	ObjectInputStream inObject = null;
	ObjectOutputStream outObject = null;
/**
 * 读取总和比赛文档中的大型比赛类
 * @return 大型比赛类集合
 * @throws FileNotFoundException
 * @throws IOException
 * @throws ClassNotFoundException
 */
	public ArrayList<com.hemmy.SubjectDesign.Model.Competition> readCom() throws FileNotFoundException, IOException, ClassNotFoundException{
		ArrayList<com.hemmy.SubjectDesign.Model.Competition> comList = new ArrayList<com.hemmy.SubjectDesign.Model.Competition>();
		inObject = new ObjectInputStream(new FileInputStream(new File("d:/Competitions.dat")));
		com.hemmy.SubjectDesign.Model.Competition com = null;
		while((com=(com.hemmy.SubjectDesign.Model.Competition)inObject.readObject())!=null){
			comList.add(com);
		}
		inObject.close();
		return comList;
	}
	/**
	 * 将大型比赛类写入总和比赛文档中
	 * @param com
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void writeObject(com.hemmy.SubjectDesign.Model.Competition com) throws FileNotFoundException, IOException{
		outObject = new ObjectOutputStream(new FileOutputStream(new File("d:/Competitions.dat")));
		outObject.writeObject(com);
		outObject.flush();
		outObject.close();
	}
 /**
  * 修改大型比赛类的isFinished状态，调用该函数将传入大型比赛类对象的isFinished修改为true
  * @param com
  * @param name
  * @throws FileNotFoundException
  * @throws IOException
  * @throws ClassNotFoundException
  */
	public void reviseObject(com.hemmy.SubjectDesign.Model.Competition com) throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		ArrayList<com.hemmy.SubjectDesign.Model.Competition> temp = readCom();
		for (Competition competition : temp) {
			if(competition.getId()==com.getId()){
				temp.remove(competition);
				com.setFinished(true);
				temp.add(com);
			}
		}
		delete();
		for (Competition competition : temp) {
			writeObject(competition);
		}

	}
/**
 * 创建有关该大型比赛的文档(保存比赛对应选手的文档，对战信息文档，比赛结果文档)
 * @param name
 * @throws IOException 
 */

	public void createCompetitionDoc(String name) throws IOException {
		// TODO Auto-generated method stub
		File fileDir = new File("d:/"+name+"/Competitors.dat");
		File fileDirWar = new File("d:/"+name+"/MatchMessage.dat");
		File fileDirResult = new File("d:/"+name+"/ComResult.dat");
		if(!fileDir.exists()){
			fileDir.getParentFile().mkdirs();
			fileDir.createNewFile();
			fileDirWar.createNewFile();
			fileDirResult.createNewFile();
		}
		
	}
	
	public void delete(){
		File file = new File("d:/Competitions.dat");
		file.delete();
	}

}
class MyObjectOutputStream extends ObjectOutputStream{
	  public MyObjectOutputStream() throws IOException{
		  super();
	  }
	  
	  public MyObjectOutputStream(OutputStream out) throws IOException{
		  super(out);
	  }
	  
	  protected void writeStreamHeader() throws IOException{
		  return;
	  }
}
