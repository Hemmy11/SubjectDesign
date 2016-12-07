package hemmy.scoringSystem.UI;
/**
 * 末页，显示玩家最后得分情况
 */
import javax.swing.*;

import hemmy.scoringSystem.Model.Player;
import hemmy.scoringSystem.Model.Scoring;
import hemmy.scoringSystem.Model.SumScore;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
public class LastPage extends JFrame implements ActionListener{
	final private JPanel lastPagePanel = new JPanel();
	final private Label lb_player = new Label();
	final private Label lb_describe = new Label("'s final score is :");
	final private Label lb_sumScore = new Label();
	final private Label lb_score2 = new Label();
	final private Label lb_score3 = new Label();
	final private Label lb_score4 = new Label();
	final private Label lb_score5 = new Label();
	final private Label lb_score6 = new Label();
	final private Label lb_score7 = new Label();
	final private Label lb_score8 = new Label();
	final private Label lb_score9 = new Label();
	final private Label lb_score10 = new Label();
	final private Label lb_score1 = new Label();
	final private JPanel jp_header = new JPanel();
	final private JPanel jp_content = new JPanel();
	final private JPanel jp_footer = new JPanel();
	final private JButton another = new JButton("Next Player");
	final private JButton exit = new JButton("Exit System");
	
	
	
	public LastPage() throws ClassNotFoundException, IOException{
		this.setTitle("Bowling ScoringSystem");
		this.setBounds(500, 250, 600, 250);
//		this.setVisible(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//从工具文件中读取玩家信息
		hemmy.scoringSystem.Model.Player player = new hemmy.scoringSystem.DAL.Player().readPlayer();
		lb_player.setText("ID :"+player.getId()+" Player "+player.getName());
		//在总分工具文件最后做标记，避免EOFException异常
		new hemmy.scoringSystem.DAL.SumScore().writeNull();
		//从工具文件中读取玩家得分情况
		ArrayList<SumScore> table = new hemmy.scoringSystem.DAL.SumScore().readSum();
		for (SumScore sumScore : table) {
			System.out.println(sumScore.getSumScore());
		}
		lb_score1.setText("Time 1: "+table.get(table.size()-10).getSumScore());
		lb_score2.setText("Time 2: "+table.get(table.size()-9).getSumScore());
		lb_score3.setText("Time 3: "+table.get(table.size()-8).getSumScore());
		lb_score4.setText("Time 4: "+table.get(table.size()-7).getSumScore());
		lb_score5.setText("Time 5: "+table.get(table.size()-6).getSumScore());
		lb_score6.setText("Time 6: "+table.get(table.size()-5).getSumScore());
		lb_score7.setText("Time 7: "+table.get(table.size()-4).getSumScore());
		lb_score8.setText("Time 8: "+table.get(table.size()-3).getSumScore());
		lb_score9.setText("Time 9: "+table.get(table.size()-2).getSumScore());
		lb_score10.setText("Time 10: "+table.get(table.size()-1).getSumScore());
		lb_sumScore.setText(" "+table.get(table.size()-1).getSumScore());
		lb_player.setPreferredSize(new Dimension(160, 30));
		lb_describe.setPreferredSize(new Dimension(100, 30));
		lb_sumScore.setPreferredSize(new Dimension(70, 30));
		lb_player.setFont(new Font("Microsoft YaHei",Font.BOLD, 14));
		lb_describe.setFont(new Font("Microsoft YaHei",Font.PLAIN, 14));
		lb_sumScore.setFont(new Font("Microsoft YaHei",Font.BOLD, 14));
		
		jp_header.add(lb_player);
		jp_header.add(lb_describe);
		jp_header.add(lb_sumScore);
		lb_score1.setPreferredSize(new Dimension(250, 15));
		lb_score2.setPreferredSize(new Dimension(250, 15));
		lb_score3.setPreferredSize(new Dimension(250, 15));
		lb_score4.setPreferredSize(new Dimension(250, 15));
		lb_score5.setPreferredSize(new Dimension(250, 15));
		lb_score6.setPreferredSize(new Dimension(250, 15));
		lb_score7.setPreferredSize(new Dimension(250, 15));
		lb_score8.setPreferredSize(new Dimension(250, 15));
		lb_score9.setPreferredSize(new Dimension(250, 15));
		lb_score10.setPreferredSize(new Dimension(250, 15));
		jp_content.add(lb_score1);
		jp_content.add(lb_score2);
		jp_content.add(lb_score3);
		jp_content.add(lb_score4);
		jp_content.add(lb_score5);
		jp_content.add(lb_score6);
		jp_content.add(lb_score7);
		jp_content.add(lb_score8);
		jp_content.add(lb_score9);
		jp_content.add(lb_score10);
		another.setPreferredSize(new Dimension(250, 30));
		exit.setPreferredSize(new Dimension(250, 30));
		another.addActionListener(this);
		exit.addActionListener(this);
		jp_footer.add(exit);
		lastPagePanel.setLayout(new BorderLayout());
		lastPagePanel.add(jp_header, BorderLayout.NORTH);
		lastPagePanel.add(jp_content, BorderLayout.CENTER);
		lastPagePanel.add(jp_footer, BorderLayout.SOUTH);
		this.add(lastPagePanel);
	
	}


	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	 if (e.getSource().equals(exit)){
			new hemmy.scoringSystem.DAL.Player().deletePlayer();
			new hemmy.scoringSystem.DAL.SumScore().deleteSum();
			this.dispose();
		}
	}

}
