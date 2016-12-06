package com.hemmy.SubjectDesign.DAL;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.hemmy.SubjectDesign.Model.Competition;
import com.hemmy.SubjectDesign.Model.Competitor;

public class CompetitiorIOUtil  {
	ObjectInputStream inObject = null;
	ObjectOutputStream outObject = null;

	/**
	 * 读取选手文档中的选手
	 * @param name 比赛名称
	 * @return 包含比赛中的所有选手的集合
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public ArrayList<Competitor> readCompetitor(String name) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		inObject = new ObjectInputStream(new FileInputStream(new File("d:/"+name+"/Competitiors.dat")));
		ArrayList<Competitor> comList = new ArrayList<Competitor>();
		Competitor com = null;
		while((com=(Competitor) inObject.readObject())!=null){
			comList.add(com);
		}
		inObject.close();
		return comList;
	}

/**
 * 将选手对象写入文档中
 * @param com
 * @throws FileNotFoundException
 * @throws IOException
 */
	public void writeObject(Competitor com) throws FileNotFoundException, IOException {
		outObject = new ObjectOutputStream(new FileOutputStream(new File("d:/"+com.getCompetition().getName()+"/Competitiors.dat")));
		outObject.writeObject(com);
		outObject.flush();
		outObject.close();
		// TODO Auto-generated method stub

	}

/**
 * 修改选手对象
 * @param com
 * @throws ClassNotFoundException
 * @throws IOException
 */
	public void reviseObject(Competitor com) throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Competitor> temp = readCompetitor(com.getCompetition().getName());
		for (Competitor competitor : temp) {
			if(competitor.getId().equals(com.getId())){
				temp.remove(competitor);
				temp.add(com);
			}
		}
		delete(com);
		for (Competitor competitor : temp) {
			writeObject(competitor);
		}

	}

/**
 * 删除选手对象
 * @param com
 * @throws ClassNotFoundException
 * @throws IOException
 */
	public void deleteCompetitor(Competitor com) throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Competitor> temp = readCompetitor(com.getCompetition().getName());
		for (Competitor competitor : temp) {
			if(competitor.getId().equals(com.getId())){
				temp.remove(competitor);
			}
		}
		delete(com);
		for (Competitor competitor : temp) {
			writeObject(competitor);
		}
	}

    public void delete(Competitor com){
    	File file = new File("d:/"+com.getCompetition().getName()+"/Competitiors.dat");
    	file.delete();
    }

}
