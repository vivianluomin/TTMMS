package xupt.se.ttms.model;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import xupt.se.ttms.view.sellticket.MovieSeatUI;
import xupt.se.ttms.view.sellticket.SeatCallback;

public class Seat {
	
	public static int NO_SELECT = 1;
	public static int SELECT = 0;
	
	private int x;
	private int y;
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
	
	private void init(){
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
