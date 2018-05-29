package xupt.se.ttms.view.sellticket;

import java.awt.Color;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import xupt.se.util.ConstantUtil;

public class MovieStudioUI extends JFrame {
	
	private int frmWidth=ConstantUtil.frmWidth;
	private int frmHeight=ConstantUtil.frmHeight;
	private JPanel content;

	private ScrollPane scorllpane;
	public MovieStudioUI(){
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
		head.setBounds(0, 0, frmWidth, 40);
		head.setFont(new Font(null,Font.BOLD,25));
		head.setForeground(Color.white);
		head.setOpaque(true);
		head.setBackground(Color.PINK);
		head.setHorizontalAlignment(JLabel.CENTER);
		
		this.add(head);	
		
	}
	
	private void initContent(){
		content = new JPanel();
		content.setLayout(null);
		content.setBounds(0, 30, frmWidth, frmHeight - 40);
		content.setBackground(Color.pink);
		for(int i = 0;i<5;i++){
		 MovieStudioItem item = 	new MovieStudioItem();
		 item.setLocation(100, i*110+40);
			content.add(item);
		}
		
		this.add(content);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new MovieStudioUI().setVisible(true);

	}

}
