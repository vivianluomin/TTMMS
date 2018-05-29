package xupt.se.ttms.view.sellticket;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import xupt.se.ttms.model.Seat;
import xupt.se.util.ConstantUtil;

public class MovieSeatUI  extends JFrame implements SeatCallback{
	
	private int mWidth = ConstantUtil.frmWidth;
	private int mHeight = ConstantUtil.frmHeight;
	
	private JPanel mContent;
	private JLabel mSelectLabel;
	
	private JButton mComfirm;
	
	private int selectCnt = 0;
	
	private List<Seat> mSeats = new ArrayList();
	
	public MovieSeatUI(){
		this.setSize(mWidth, mHeight);
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
		JLabel head = new JLabel("请选择座位");
		head.setBounds(0, 0, mWidth, 40);
		head.setFont(new Font(null,Font.BOLD,25));
		head.setForeground(Color.white);
		head.setOpaque(true);
		head.setBackground(Color.PINK);
		head.setHorizontalAlignment(JLabel.CENTER);
		
		this.add(head);	
	}
	
	private void initContent(){
		mContent = new JPanel();
		mContent.setLayout(null);
		mContent.setBounds(0, 40, mWidth, mHeight-40);
		mContent.setBackground(Color.pink);
		JLabel center = new JLabel("屏幕中央");
		center.setBounds(0, 0, mWidth, 20);
		center.setFont(new Font(null,Font.PLAIN,16));
		center.setForeground(Color.white);
		center.setOpaque(true);
		center.setBackground(Color.PINK);
		center.setHorizontalAlignment(JLabel.CENTER);
		mContent.add(center);
		
		for(int i = 0;i<70;i++){
			JLabel label = new JLabel();
			label.setIcon(new ImageIcon("resource/image/seat.png"));
			
			int x = i/10;
			int y = i-x*10;
			label.setBounds( y*80+150,x*80+50, 50, 50);
			Seat seat = new Seat(x,y,label);
			seat.setCallback(this);
			mSeats.add(seat);
			mContent.add(label);
		}
		
		mSelectLabel = new JLabel();
		mSelectLabel.setBounds(0, mHeight-180, mWidth-200, 40);
		mSelectLabel.setFont(new Font(null,Font.BOLD,25));
		mSelectLabel.setForeground(Color.white);
//		mSelectLabel.setOpaque(true);
//		mSelectLabel.setBackground(Color.PINK);
		mSelectLabel.setHorizontalAlignment(JLabel.CENTER);
		
		mContent.add(mSelectLabel);
		
		mComfirm = new JButton("确定");
		mComfirm.setBounds(mWidth-200,mHeight-150 , 100, 40);
		mContent.add(mComfirm);
		
		mComfirm.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "购买成功"); 
				
			}
			
		});
		
		this.add(mContent);
		
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MovieSeatUI().setVisible(true);
	}

	@Override
	public void selectSeat(int x, int y) {
		// TODO Auto-generated method stub
		if(selectCnt<4){
			String s = mSelectLabel.getText();
			mSelectLabel.setText(s+"  "+"("+x+","+y+")");
			selectCnt++;
		}else{
			
		}
		
		
		
	}

}
