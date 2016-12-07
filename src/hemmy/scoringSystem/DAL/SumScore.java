package hemmy.scoringSystem.DAL;
/**
 * SumScore（每轮总得分）与文件数据交互
 */
import java.io.*;
import java.util.ArrayList;

public class SumScore{
 OutputStreamWriter out = null;
 ObjectInputStream inObject = null;
	ObjectOutputStream outObject = null;
	
	
	public void writeSum(hemmy.scoringSystem.Model.SumScore sum) throws IOException{
		StringBuffer str = new StringBuffer(" ");
		str.append("本轮总分为:"+sum.getSumScore());
		out = new OutputStreamWriter(new FileOutputStream("d:/score.txt",true));
		out.write(str.toString());
		out.flush();
		out.close();
		
	}

	public void writeSumUtil(hemmy.scoringSystem.Model.SumScore sum) throws IOException{
		File file = new File("d:/scoreSum.dat");		
		if(file.length()<1){
			outObject = new ObjectOutputStream(new FileOutputStream(file,true));
		}else{
			outObject = new MyObjectOutputStream(new FileOutputStream(file,true));
		}
		outObject.writeObject(sum);
		outObject.flush();
		outObject.close();
		
	}
	public void writeNull() throws IOException{
		File file = new File("d:/scoreSum.dat");		
		if(file.length()<1){
			outObject = new ObjectOutputStream(new FileOutputStream(file,true));
		}else{
			outObject = new MyObjectOutputStream(new FileOutputStream(file,true));
		}
		outObject.writeObject(null);
		outObject.flush();
		outObject.close();
		
	}
	
	public ArrayList<hemmy.scoringSystem.Model.SumScore> readSum() throws IOException, ClassNotFoundException{
		ArrayList<hemmy.scoringSystem.Model.SumScore> ss = new ArrayList<hemmy.scoringSystem.Model.SumScore>();
		inObject = new ObjectInputStream(new FileInputStream("d:/scoreSum.dat"));
		hemmy.scoringSystem.Model.SumScore obj = null;
	        while((obj= (hemmy.scoringSystem.Model.SumScore) inObject.readObject())!=null){ //如果为null就读取到文件结尾了。
	           ss.add(obj);
	}
	        inObject.close();
			return ss;	
	
}
	public void deleteSum(){
		File file = new File("d:/scoreSum.dat");	
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
