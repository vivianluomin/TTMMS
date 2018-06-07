package xupt.se.ttms.view.sellticket;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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

import xupt.se.ttms.dao.sellticketDAO;
import xupt.se.ttms.model.Seat;
import xupt.se.ttms.model.Studio;
import xupt.se.ttms.model.Ticket;
import xupt.se.util.ConstantUtil;

public class MovieSeatUI  extends JFrame implements SeatCallback{
	
	private int mWidth = ConstantUtil.frmWidth;
	private int mHeight = ConstantUtil.frmHeight;
	
	private JPanel mContent;
	private JLabel mSelectLabel;
	
	private JLabel mRefresh;
	
	private int mStudio_id;
	private int mSched_id;
	private String mTime;
	private double mPrice;
	
	private int mPlay_id;
	
	private JButton mComfirm;
	
	private int row;
	private int clo;
	
	private int selectCnt = 0;
	public List<Seat> mSelectSeats = new ArrayList();
	
	private List<Seat> mSeats = new ArrayList();
	
	private List<Seat> mOrders = new ArrayList();
	
	public MovieSeatUI(int studio_id,int sched_id){
		mStudio_id = studio_id;
		mSched_id = sched_id;
		this.setSize(mWidth, mHeight);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setTitle("奥斯不卡票务管理系统");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				if(mOrders.size()>0){
					sellticketDAO.deletOrder(mOrders);
				}
			}
		});	
		
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
		
		mRefresh = new JLabel();
		mRefresh.setBounds(mWidth-200, 30, 50, 50);
		mRefresh.setIcon(new ImageIcon("resource/image/refresh1.png"));
		mRefresh.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				Refresh();
				mSelectLabel.setText("");
				
				
				//draw();
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		mContent.add(mRefresh);
		
		search();
		draw();
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
				if(mOrders.size()<=0) {
					JOptionPane.showMessageDialog(null, "订单超时，请重新购买");
					return;
				}
				List<Seat> orders = sellticketDAO.getAllOrder(mSched_id);
				if(orders.size()<=0){
					JOptionPane.showMessageDialog(null, "订单超时，请重新购买");
					Refresh();
					return;
				}
				for(int i =0;i<orders.size()&&i<mOrders.size();i++){
					if(orders.get(i).getSeat_id()!= mOrders.get(i).getSeat_id()){
						JOptionPane.showMessageDialog(null, "订单超时，请重新购买");
						Refresh();
						return;
					}
				}
				JOptionPane.showMessageDialog(null, "购买成功");
				List<Ticket> tickets = new ArrayList();
				for(int i =0;i<mSelectSeats.size();i++){
					Seat se = mSelectSeats.get(i);
					mSelectSeats.get(i).setIcon(new ImageIcon("resource/image/seat_no.png"));
					mSelectSeats.get(i).setStatu(Seat.SELECT);
					Ticket t = new Ticket();
					t.setSeat_id(se.getSeat_id());
					t.setRow(se.getX());
					t.setCol(se.getY());
					t.setSched_id(se.getSched_id());
					t.setStudio_id(se.getStudio_id());
					t.setTicket_price(mPrice);
					t.setPlay_id(mPlay_id);
					tickets.add(t);
				}
				
				sellticketDAO.addTicket(tickets);
				
				sellticketDAO.deletOrder(mOrders);
				mOrders.clear();
				
				
			}
			
		});
		
		this.add(mContent);
		
	
	}
	
	private void search(){
		mSeats.clear();
		Studio studio = sellticketDAO.getStudioSeat(mStudio_id);
		 row = studio.getRowCount();
		 clo = studio.getColCount();
		List<Ticket> list = sellticketDAO.getAStudioTicket(mSched_id);
		List<Seat> orders = sellticketDAO.getAllOrder(mSched_id);
		for(int i = 0;i<row*clo;i++){
			JLabel label = new JLabel();
			label.setIcon(new ImageIcon("resource/image/seat.png"));
			
			int x = i/clo;
			int y = i-x*clo;
			label.setBounds( y*80+250,x*80+50, 50, 50);
			Seat seat = new Seat(x,y,label);
			seat.setSched_id(mSched_id);
			seat.setStudio_id(mStudio_id);

			seat.setCallback(this,this);
			mSeats.add(seat);
			//mContent.add(seat.getIcon());
		}
		for(int i = 0;i<list.size();i++){
			int roww = list.get(i).getRow();
			int coll = list.get(i).getCol();
			mSeats.get(roww*clo+coll).setStatu(Seat.SELECT);
			mSeats.get(roww*clo+coll).setIcon(new ImageIcon("resource/image/seat_no.png"));
		}
		
		for(int i = 0;i<orders.size();i++){
			Seat seat = orders.get(i);
			if(seat.getTime()>=System.currentTimeMillis()){
				
				int roww = orders.get(i).getX();
				int coll = orders.get(i).getY();
				 System.out.println(roww);
				 mSeats.get(roww*clo+coll).setStatu(Seat.ORDER);
				mSeats.get(roww*clo+coll).setIcon(new ImageIcon("resource/image/seat_no.png"));
			}else{
				sellticketDAO.deletAOrder(seat);
				System.out.println("delete------"+seat.getTime()+"------"+System.currentTimeMillis());
			}
			
		}
	}
	
	private void Refresh(){
		//if(mOrders.size()<=0) return;
		sellticketDAO.deletOrder(mOrders);
		//search();
		for(int i = 0;i<mOrders.size();i++){
			int roww = mOrders.get(i).getX();
			int coll = mOrders.get(i).getY();
			 System.out.println(roww);
			 mSeats.get(roww*clo+coll).setStatu(Seat.NO_SELECT);
			mSeats.get(roww*clo+coll).setIcon(new ImageIcon("resource/image/seat.png"));
		}
		
		//search();
		//draw();
//
		for(int i = 0;i<row*clo;i++){
			mSeats.get(i).setStatu(Seat.NO_SELECT);
			mSeats.get(i).setIcon(new ImageIcon("resource/image/seat.png"));
			//mContent.add(seat.getIcon());
		}
		List<Ticket> list = sellticketDAO.getAStudioTicket(mSched_id);
		for(int i = 0;i<list.size();i++){
			int roww = list.get(i).getRow();
			int coll = list.get(i).getCol();
			mSeats.get(roww*clo+coll).setStatu(Seat.SELECT);
			mSeats.get(roww*clo+coll).setIcon(new ImageIcon("resource/image/seat_no.png"));
		}
		
		List<Seat> orders = sellticketDAO.getAllOrder(mSched_id);
		for(int i = 0;i<orders.size();i++){
			Seat seat = orders.get(i);
			if(seat.getTime()>=System.currentTimeMillis()){
				
				int roww = orders.get(i).getX();
				int coll = orders.get(i).getY();
				 System.out.println(roww);
				 mSeats.get(roww*clo+coll).setStatu(Seat.ORDER);
				mSeats.get(roww*clo+coll).setIcon(new ImageIcon("resource/image/seat_no.png"));
				
			}else{
				sellticketDAO.deletAOrder(seat);
				System.out.println("delete------"+seat.getTime()+"------"+System.currentTimeMillis());
			}
			
		}
				
		mOrders.clear();
		mSelectSeats.clear();
		selectCnt = 0;
			
	}
	
	private void draw(){
		for(int i = 0;i<row*clo;i++){
		
			mContent.add(mSeats.get(i).getIcon());
		}
	}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		new MovieSeatUI(s).setVisible(true);
//	}
	
	
	public void setData(String time,double price,int play_id){

		 mTime= time;
		 mPrice= price;
		 mPlay_id = play_id;
	}

	@Override
	public void selectSeat(Seat seat) {
		// TODO Auto-generated method stub
		if(selectCnt<4){
			
			//draw();
			String s = mSelectLabel.getText();
			mSelectSeats.add(seat);
			mSelectLabel.setText(s+"  "+"("+seat.getX()+","+seat.getY()+")");
			selectCnt++;
			mOrders.add(seat);
		}else{
			
		}	
		
	}

}
