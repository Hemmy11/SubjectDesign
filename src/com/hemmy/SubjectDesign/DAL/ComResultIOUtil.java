package com.hemmy.SubjectDesign.DAL;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.hemmy.SubjectDesign.Model.ComResult;

public class ComResultIOUtil{
	ObjectInputStream inObject = null;
	ObjectOutputStream outObject = null;


	public ComResult readObject(String name) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		inObject = new ObjectInputStream(new FileInputStream(new File("d:/"+name+"/ComResult.dat")));
		ComResult com = (ComResult) inObject.readObject();
		inObject.close();
		return com;
	}

	public void writeComResult(ComResult com) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		outObject = new ObjectOutputStream(new FileOutputStream(new File("d:/"+com.getCompetition().getName()+"/ComResult.dat")));
		outObject.writeObject(com);
		outObject.flush();
		outObject.close();

	}


}
