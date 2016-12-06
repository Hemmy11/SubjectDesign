package com.hemmy.SubjectDesign.DAL;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.hemmy.SubjectDesign.Model.ComMessage;
import com.hemmy.SubjectDesign.Model.Competitor;
import com.hemmy.SubjectDesign.Model.MatchMessage;

public class MatchMessageIOUtil {
	ObjectInputStream inObject = null;
	ObjectOutputStream outObject = null;

/**
 * 读取对战信息类
 * @param name
 * @return 返回对战信息类集合
 * @throws IOException
 * @throws ClassNotFoundException
 */
	public ArrayList<MatchMessage> readMatchMessage(String name) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		inObject = new ObjectInputStream(new FileInputStream(new File("d:/"+name+"/ComMessage.dat")));
		ArrayList<MatchMessage> comList = new ArrayList<MatchMessage>();
		MatchMessage com = null;
		while((com=(MatchMessage) inObject.readObject())!=null){
			comList.add(com);
		}
		inObject.close();
		return comList;
	}

/**
 * 将生成的对战信息类集合(即日程表信息)中的每个对战信息对象写入对战信息文档中
 * @param com
 * @throws FileNotFoundException
 * @throws IOException
 */
	public void writeObject(ArrayList<MatchMessage> com) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		outObject = new ObjectOutputStream(new FileOutputStream(new File("d:/"+com.get(0).getCom1().getCompetition().getName()+"/MatchMessage.dat")));
		for (MatchMessage matchMessage : com) {
			outObject.writeObject(matchMessage);
		}
		outObject.flush();
		outObject.close();
		

	}
/**
 * 修改对战信息，将修改后的对战信息覆盖原来的对战信息
 * @param com
 * @throws ClassNotFoundException
 * @throws IOException
 */
	public void reviseObject(MatchMessage com) throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		ArrayList<MatchMessage> temp = readMatchMessage(com.getCom1().getCompetition().getName());
		for (MatchMessage matchMessage : temp) {
			if(matchMessage.getCom1().getId().equals(com.getCom1().getId())&&matchMessage.getCom2().getId().equals(com.getCom2().getId())){
				temp.remove(matchMessage);
				temp.add(com);
			}
		}
		delete(com);
		writeObject(temp);

	}

/**
 * 删除对战信息文档
 * @param com
 */
	public void delete(MatchMessage com) {
		// TODO Auto-generated method stub
		File file = new File("d:/"+com.getCom1().getCompetition().getName()+"/MatchMessage.dat");
		file.delete();

	}


}
