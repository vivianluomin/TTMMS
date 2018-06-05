package xupt.se.ttms.model;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import xupt.se.ttms.dao.sellticketDAO;
import xupt.se.ttms.view.sellticket.MovieSeatUI;
import xupt.se.ttms.view.sellticket.SeatCallback;

public class Seat {
	
	public static int NO_SELECT = 0;
	public static int SELECT = 1;
	public static int ORDER = -1;
	
	private int x;
	private int y;
	private int seat_id;
	private int studio_id;
	private int sched_id;
	private long time;
	private JLabel icon;
	private int statu = Seat.NO_SELECT;
	private MovieSeatUI mParent;
	
	private SeatCallback callback;
	
	public Seat(int x, int y, JLabel icon) {
	
		this.x = x;
		this.y = y;
		this.icon = icon;
		init();
	}
	
	public Seat(){
		
	}
	
	
	
	
	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public int getSeat_id() {
		return seat_id;
	}



	public void setSeat_id(int seat_id) {
		this.seat_id = seat_id;
	}



	public int getStudio_id() {
		return studio_id;
	}



	public void setStudio_id(int studio_id) {
		this.studio_id = studio_id;
	}



	public int getSched_id() {
		return sched_id;
	}



	public void setSched_id(int sched_id) {
		this.sched_id = sched_id;
	}



	public MovieSeatUI getmParent() {
		return mParent;
	}



	public void setmParent(MovieSeatUI mParent) {
		this.mParent = mParent;
	}



	public SeatCallback getCallback() {
		return callback;
	}



	public void setCallback(SeatCallback callback) {
		this.callback = callback;
	}



	public void setIcon(JLabel icon) {
		this.icon = icon;
	}



	private void init(){
		if(icon == null) return;
		
		icon.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if(statu!=Seat.SELECT&&mParent.mSelectSeats.size()<4){
					icon .setIcon( new ImageIcon("resource/image/seat_select.png"));
					Seat.this.setStatu(ORDER);
					Seat.this.setTime(System.currentTimeMillis()+1*60*1000);
					sellticketDAO.addOrder(Seat.this);
					callback.selectSeat(Seat.this);
			
				}
				
				
			}
			
		});
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getStatu() {
		return statu;
	}
	public void setStatu(int statu) {
		this.statu = statu;
	}
	public JLabel getIcon() {
		return icon;
	}
	public void setIcon(ImageIcon icon) {
		this.icon.setIcon(icon);
	}
	
	
	
	public void setCallback(SeatCallback callback,MovieSeatUI parent) {
		mParent = parent;
		this.callback = callback;
	}
	
	
	
	
	

}
