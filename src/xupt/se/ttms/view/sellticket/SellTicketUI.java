package xupt.se.ttms.view.sellticket;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import xupt.se.ttms.dao.sellticketDAO;
import xupt.se.ttms.model.Movie;
import xupt.se.ttms.view.tmpl.ImagePanel;
import xupt.se.ttms.view.tmpl.MainUITmpl;
import xupt.se.util.ConstantUtil;

public class SellTicketUI extends JPanel{
	
	private int frmWidth=ConstantUtil.frmWidth-200;
	private int frmHeight=ConstantUtil.frmHeight;
	private JPanel content;
	private JPanel head;
	private List<Movie> ScheduelMovieList = new ArrayList<>();
	public SellTicketUI(){
		this.setSize(frmWidth, frmHeight);
//		this.setLocationRelativeTo(null);
//		this.setResizable(false);
//		this.setTitle("汉唐剧院票务管理系统");
		this.setLayout(null);
//		this.addWindowListener(new WindowAdapter(){
//			public void windowClosing(WindowEvent e){
//				onWindowClosing();
//			}
//		});	
		
		
		initHead();
		initContent();
	
		
	}
	
	private void initHead(){
		JLabel head = new JLabel("今日放映电影，点击购票");
		head.setForeground(Color.WHITE);
		head.setFont(new Font(null,Font.BOLD,25));
		head.setBounds(0, 0, frmWidth, 30);
		head.setHorizontalAlignment(JLabel.CENTER);
		head.setBackground(Color.pink);
		head.setOpaque(true);
		this.add(head);
		
	}
	
	private void initContent(){
		content = new JPanel();
		content.setLayout(null);
		content.setBounds(0, 30, frmWidth, frmHeight-30);
		ScheduelMovieList.clear();
		ScheduelMovieList.addAll(sellticketDAO.getScheduelMovie());
		ConstantUtil.sechduels = ScheduelMovieList;
		for(int i = 0;i<ScheduelMovieList.size();i++){
			Movie e = ScheduelMovieList.get(i);
			ImagePanel image = new ImagePanel(e.getMovieImage());
			NowShowMovieItem  item = new NowShowMovieItem(image,e.getMovieName());
			item.setIntro(e.getMovieDesc());
			item.setPlay_id(e.getMovieId());
			int k = i/4;
			int j = i - k*4;
			//System.out.println(k+"----"+j);
			item.setLocation(j*250+30, k*340+20);
			content.add(item);
		}
		
	
		content.setVisible(true);
		content.setBackground(Color.PINK);
		
		this.add(content);
		
		
		
	}

	public static void main(String[] args) {
		new SellTicketUI().setVisible(true);

	}

}
