package xupt.se.ttms.view.sellticket;

import java.awt.Color;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import xupt.se.ttms.dao.sellticketDAO;
import xupt.se.ttms.model.AMovieSechduel;
import xupt.se.util.ConstantUtil;

public class MovieStudioUI extends JFrame {
	
	private int frmWidth=ConstantUtil.frmWidth;
	private int frmHeight=ConstantUtil.frmHeight;
	private JPanel content;
	private JLabel introduction;
	private List<AMovieSechduel> list;
	private int play_id;

	private ScrollPane scorllpane;
	public MovieStudioUI(int play_id){
		this.play_id = play_id;
		this.setSize(frmWidth, frmHeight);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setTitle("汉唐剧院票务管理系统");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(null);
	
//		this.addWindowListener(new WindowAdapter(){
//			public void windowClosing(WindowEvent e){
//				System.exit(0);
//			}
//		});	
		
		initHead();
		initContent();
	}
	
	private void initHead(){
		
		
		JLabel head = new JLabel("请选择该电影场次");
		introduction = new JLabel("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		head.setBounds(0, 0, frmWidth, 40);
		head.setFont(new Font(null,Font.BOLD,25));
		head.setForeground(Color.white);
		head.setOpaque(true);
		head.setBackground(Color.PINK);
		head.setHorizontalAlignment(JLabel.CENTER);
		
		introduction.setBounds(0, 40, frmWidth, 80);
		introduction.setFont(new Font(null,Font.BOLD,14));
		introduction.setForeground(Color.white);
		introduction.setOpaque(true);
		introduction.setBackground(Color.PINK);
		introduction.setHorizontalAlignment(JLabel.CENTER);
		
		this.add(head);	
		this.add(introduction);	
		
	}
	
	private void initContent(){
		content = new JPanel();
		content.setLayout(null);
		content.setBounds(0, 120, frmWidth, frmHeight - 120);
		content.setBackground(Color.pink);
		list = sellticketDAO.getAMovieSechduel(play_id);
		System.out.println(list.size()+"   "+play_id);
		for(int i = 0;i<list.size();i++){
			AMovieSechduel a = list.get(i);
		 MovieStudioItem item = 	new MovieStudioItem();
		 item.setData(a.getStudio_id(), a.getSched_time(), a.getPrice(),a.getSched_id());
		 item.setLocation(100, i*110+20);
			content.add(item);
		}
		
		this.add(content);
	}
	
	public void setIntroduction(String intro){
	
		introduction.setText(intro);
	}
	
	

	public int getPlay_id() {
		return play_id;
	}

	public void setPlay_id(int play_id) {
		this.play_id = play_id;
	}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
//		new MovieStudioUI().setVisible(true);
//
//	}

}
