package hemmy.scoringSystem.UI;
/**
 * 起始页，记录玩家信息
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import hemmy.scoringSystem.ExceptionDealUtily.IDException;
import hemmy.scoringSystem.ExceptionDealUtily.NameException;
import hemmy.scoringSystem.Model.*;
public class WelcomePage extends JFrame implements ActionListener{
	final private JPanel welcomePanel = new JPanel();
	final private JPanel playerPanel = new JPanel();
	final private Label welcomeWords = new Label("Welcome to use ScoringSystem!");
	final private Label lb_name = new Label("player's name :");
	final private Label lb_id = new Label("player's      id:");
	final private JTextField jtf_name = new JTextField(15);
	final private JTextField jtf_id = new JTextField(15);
	final private JButton ensure = new JButton("确定");
	final private JButton concel = new JButton("取消");
	final private JPanel  jp1 = new JPanel();
	final private JPanel jp2 = new JPanel();
	final private JPanel jp3 = new JPanel();
	final private JPanel jp4 = new JPanel();
	private Player player = new Player();
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	WelcomePage(){
		this.setTitle("Bowling ScoringSystem");
		this.setBounds(500, 250, 500, 210);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		welcomeWords.setFont(new Font("Microsoft YaHei",Font.PLAIN, 15));
		welcomePanel.add(welcomeWords);
		welcomeWords.setPreferredSize(new Dimension(250, 30));
		jp1.add(lb_name);
		lb_name.setPreferredSize(new Dimension(125, 30));
		jp1.add(jtf_name);
		jtf_name.setPreferredSize(new Dimension(125, 30));
		jp2.add(lb_id);
		lb_id.setPreferredSize(new Dimension(125, 30));
		jp2.add(jtf_id);
		jtf_id.setPreferredSize(new Dimension(125, 30));
		jp3.add(ensure);
		ensure.setPreferredSize(new Dimension(125, 30));
		jp3.add(concel);
		concel.setPreferredSize(new Dimension(125, 30));
		jp4.add(jp1, BorderLayout.NORTH);
		jp4.add(jp2, BorderLayout.SOUTH);
		this.add(welcomePanel, BorderLayout.NORTH);
		this.add(jp4, BorderLayout.CENTER);
		this.add(jp3, BorderLayout.SOUTH);
		ensure.addActionListener(this);
		concel.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(ensure)){
		
			try {
				if(jtf_name.getText().length()<=0){
				throw new NameException();
				}
				if(jtf_id.getText().length()<=0){
				throw new IDException();
				}
			player.setId(Integer.parseInt(jtf_id.getText()));			
			player.setName(jtf_name.getText());
			
			try {
				new hemmy.scoringSystem.DAL.Player().writePlayer(player);
				new hemmy.scoringSystem.DAL.Player().writePlayerUtil(player);
				new hemmy.scoringSystem.DAL.Player().writeNull();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			ScoringPage sp = new ScoringPage();
			this.dispose();
			sp.setVisible(true);
			} catch (NameException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(this,"请输入玩家名字！"); 
				this.dispose();
				new WelcomePage();
			} catch(IDException e2){
				JOptionPane.showMessageDialog(this,"请输入正确的编号！"); 
				this.dispose();
				new WelcomePage();
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(this,"请输入正确的编号！"); 
				this.dispose();
				new WelcomePage();
			}	
		}else if(e.getSource().equals(concel)){
			jtf_name.setText("");
			jtf_id.setText("");
		}
			
	}

}
