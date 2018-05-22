package xupt.se.ttms.view.sellticket;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneLayout;

import xupt.se.util.ConstantUtil;
import xupt.se.util.StringUtil;

import xupt.se.ttms.model.Movie;
import xupt.se.ttms.model.Play;
import xupt.se.ttms.view.tmpl.ImagePanel;

public class PlayView extends JFrame {
	

	private JPanel jPanel;
	private JScrollPane jsp;
	
	String a="asdaddasdasdasdsdddddddddddddddddddddddd"+"<br>"
			+ "asdddddddddddddddddddddddddddddddd"+"<br>"
			+ "saddddddddddddddddddddddddddddddddddddddddddddddddd"+"<br>"
			+ "asdddddddddddddddddddddddddddddddddddddddddddddddddddddd"+"<br>"
			+ "gtttttttttttttttttttttsdvvaaaaaaaaaaaaaaaaaaaaavvvvvvvvvvv";
	
	
	public static void main(String[] args) {
		PlayView test=new PlayView();
		Movie m=new Movie();
		m.setMovieId(1);
		test.showPlay(m);
	}
	
	public PlayView(){
		this.setTitle("选择电影场次");
		jsp = new JScrollPane();
		jsp.setBounds(0, 250, ConstantUtil.frmWidth, ConstantUtil.frmHeight-260);
		
		//jsp.add(jPanel);
		
	}
	
	public void showPlay(Movie movie)
	{
		
		
		
		List<Play> list=new ArrayList<>();
		
		
		for(int i =0;i<7;i++) {
			Play play = new Play();
			play.setMovieId(i+1);
			play.setMovieName("AAAAA");
			play.setStartTime(new Date());
			play.setEndTime(new Date());
			play.setStudioId(3);
			play.setStudioName("meigi");
			play.setTicketNums(12);
			play.setTicketPrice(new BigDecimal(12));
			play.setTicketSold(1);
			play.setTicketStartNum(10);
			list.add(new Play());
		}

		JPanel[] jP=new JPanel[list.size()];
		JButton[] button=new JButton[list.size()];
		
		JPanel header =new JPanel();
		ImagePanel panel = new ImagePanel("resource/image/film0.jpg");
		panel.setLocation(20, 20);
		JLabel jLabel=new JLabel("<html>"+a+"</html>");
		jLabel.setBounds(100, 100, 300,200);
		header.add(jLabel);
		header.add(panel);
		header.setBounds(0, 0, ConstantUtil.frmWidth, 230);
		this.add(header);
		for(int i=0;i<list.size();i++)
		{
			int j = i+1;
			jP[i]=new JPanel();
//			jP[i].setBounds(20, 250+90*i, ConstantUtil.frmWidth, 80);
			JLabel jLabelId=new JLabel("今天第"+j+"场");
	
			JLabel jLabelName=new JLabel(list.get(i).getMovieName());
			JLabel jLabelTime=new JLabel(StringUtil.dateToString(list.get(i).getStartTime(),"yyyy-MM-dd hh:mm")+"-"+StringUtil.dateToString(list.get(i).getEndTime(),"yyyy-MM-dd:hh:mm"));
			JLabel jLabelStudio=new JLabel(list.get(i).getStudioName());
			JLabel jLabelTicketNums=new JLabel(list.get(i).getTicketSold()+"/"+list.get(i).getTicketNums());
			JLabel jLabelPrice=new JLabel(list.get(i).getTicketPrice()+"RMB");
			jP[i].add(jLabelId);
			jP[i].add(jLabelName);
			jP[i].add(jLabelTime);
			jP[i].add(jLabelStudio);
			jP[i].add(jLabelTicketNums);
			jP[i].add(jLabelPrice);
			button[i]=new JButton("选择该场次");
			button[i].addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
						
				}
			});
			jP[i].setBorder(BorderFactory.createLineBorder(Color.red, 1));
			jP[i].add(button[i]);
		}
		
		for(int i=0;i<list.size();i++)
		{
			jsp.add(jP[i]);
			
		}
		jsp.setLayout(new ScrollPaneLayout());
		this.add(jsp);	
		this.setSize(ConstantUtil.frmWidth, ConstantUtil.frmHeight);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);  
	}
}
