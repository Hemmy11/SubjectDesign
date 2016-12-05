package hemmy.scoringSystem.UI;
/**
 * 计算页，记录玩家得分信息并计算每轮总分
 */
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import hemmy.scoringSystem.ExceptionDealUtily.ScoreException;
import hemmy.scoringSystem.Model.Scoring;
import hemmy.scoringSystem.Model.SumScore;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

public class ScoringPage extends JFrame implements ActionListener{
	final private JPanel scoringPanel = new JPanel();
	final private Label time = new Label("NO.1 Time");
	final private Label lb_firScore = new Label("The First Score:");
	final private Label lb_secScore = new Label("The Second Score:");
	final private JTextField jtf_firScore = new JTextField(10);
	final private JTextField jtf_secScore = new JTextField(10);
	final private JButton jb_next = new JButton("Next Time");
	final private JPanel jp1 = new JPanel();
	final private JPanel jp2 = new JPanel();
	final private JPanel jp3 = new JPanel();
	final private JPanel jp4 = new JPanel();
	final private JPanel jp5 = new JPanel();
	private SumScore sum = new SumScore();
	private ArrayList<Scoring> table = new ArrayList<Scoring>();
	public ScoringPage(){
		this.setTitle("Bowling ScoringSystem");
		this.setBounds(500, 250, 500, 200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		time.setFont(new Font("Microsoft YaHei",Font.PLAIN, 15));
		jp1.add(time);
		time.setPreferredSize(new Dimension(150, 25));
		jp2.add(lb_firScore);
		lb_firScore.setPreferredSize(new Dimension(125, 25));
		jp2.add(jtf_firScore);
		jtf_firScore.setPreferredSize(new Dimension(125, 25));
		jp3.add(lb_secScore);
		lb_secScore.setPreferredSize(new Dimension(125, 25));
		jp3.add(jtf_secScore);
		jtf_secScore.setPreferredSize(new Dimension(125, 25));
		jp4.add(jb_next);
		jb_next.setPreferredSize(new Dimension(125, 25));
		jb_next.addActionListener(this);
		jp5.setLayout(new BorderLayout());
		jp5.add(jp2, BorderLayout.NORTH);
		jp5.add(jp3, BorderLayout.SOUTH);
		scoringPanel.setLayout(new BorderLayout());
		scoringPanel.add(jp1, BorderLayout.NORTH);
		scoringPanel.add(jp5, BorderLayout.CENTER);
		scoringPanel.add(jp4, BorderLayout.SOUTH);
		this.add(scoringPanel,BorderLayout.NORTH);

		
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(jb_next)){
			try {
			Scoring socre = new Scoring();
		if(jb_next.getText().equals("Next Time")){	//判断是前十轮还是额外轮
			int times;
			//判断time字符长度来截取代表轮数的字符串
			if(time.getText().length()==9){
			times = Integer.parseInt(time.getText().substring(3, 4));
			}else if(time.getText().length()==10){
				times = Integer.parseInt(time.getText().substring(3, 5));
			}else{
				times = 10;
			}
			//将Scoring写进集合
			socre.setTime(times);
			if(Integer.parseInt(jtf_firScore.getText())<0||Integer.parseInt(jtf_firScore.getText())>10||(Integer.parseInt(jtf_firScore.getText())+Integer.parseInt(jtf_secScore.getText()))>10){
				
						throw  new ScoreException();
					 }
			socre.setFirScore(Integer.parseInt(jtf_firScore.getText()));
			socre.setSecScore(Integer.parseInt(jtf_secScore.getText()));
			
			table.add(socre);
			//当集合中有三轮成绩开始计算分数并记录前一轮总分
			if(table.size()>2){
				sum.setSumScore(new hemmy.scoringSystem.BLL.Scoring().scoringSum(table));
				try {
					new hemmy.scoringSystem.DAL.Scoring().writeScoring(table.get(table.size()-3));
					new hemmy.scoringSystem.DAL.SumScore().writeSum(sum);
					new hemmy.scoringSystem.DAL.SumScore().writeSumUtil(sum);
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			//判断最后一轮两次的得分以决定是否增加一轮
			if(time.getText().length()==10){
				if(Integer.parseInt(jtf_firScore.getText())==10){
					time.setText("The extre Time");
					jtf_firScore.setText("");
					jtf_secScore.setText("");
					jb_next.setText("Finish");
				}else if((Integer.parseInt(jtf_firScore.getText())+Integer.parseInt(jtf_secScore.getText()))==10){
					time.setText("The extre Time");
					jtf_secScore.setText("0");
					jtf_firScore.setText("");
					jtf_secScore.setEditable(false);
					jb_next.setText("Finish");
					
				}else{
					Scoring score1 = new Scoring();
					score1.setTime(10);
					score1.setFirScore(0);
					score1.setSecScore(0);
					table.add(score1);
					table.add(score1);
					sum.setSumScore(new hemmy.scoringSystem.BLL.Scoring().scoringSum(table));
					try {
						new hemmy.scoringSystem.DAL.Scoring().writeScoring(table.get(table.size()-2));
						new hemmy.scoringSystem.DAL.SumScore().writeSum(sum);
						new hemmy.scoringSystem.DAL.SumScore().writeSumUtil(sum);
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					//跳转到最后一页
					LastPage lp = null;
						try {
							lp = new LastPage();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					this.dispose();
					lp.setVisible(true);
					}
				
			}else{
				times++;				
 				time.setText("NO."+times+" Time");
				jtf_firScore.setText("");
				jtf_secScore.setText("");

			}
		}else{
			socre.setTime(11);
			if(Integer.parseInt(jtf_firScore.getText())<0||Integer.parseInt(jtf_firScore.getText())>10){
				
				throw  new ScoreException();
			 }
			socre.setFirScore(Integer.parseInt(jtf_firScore.getText()));
			socre.setSecScore(Integer.parseInt(jtf_secScore.getText()));
			table.add(socre);
			sum.setSumScore(new hemmy.scoringSystem.BLL.Scoring().scoringSum(table));
			try {
				new hemmy.scoringSystem.DAL.Scoring().writeScoring(table.get(table.size()-3));
				new hemmy.scoringSystem.DAL.SumScore().writeSum(sum);
				new hemmy.scoringSystem.DAL.SumScore().writeSumUtil(sum);
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Scoring score2 = new Scoring();
			score2.setTime(12);
			score2.setFirScore(0);
			score2.setSecScore(0);
			table.add(score2);
			sum.setSumScore(new hemmy.scoringSystem.BLL.Scoring().scoringSum(table));
			try {
				new hemmy.scoringSystem.DAL.Scoring().writeScoring(table.get(table.size()-3));
				new hemmy.scoringSystem.DAL.SumScore().writeSum(sum);
				new hemmy.scoringSystem.DAL.SumScore().writeSumUtil(sum);
				new hemmy.scoringSystem.DAL.Scoring().writeScoring(table.get(table.size()-2));
			
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//跳转到最后一页
			LastPage lp = null;
				try {
					lp = new LastPage();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			this.dispose();
			lp.setVisible(true);
			}
		    } catch (NumberFormatException e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this,"请输入分数！"); 
			} catch (ScoreException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(this,"输入得分有误，请重新输入！"); 
				jtf_firScore.setText("");
				jtf_secScore.setText("");

			}		
		}	
	}
}

	


	

