package xupt.se.ttms.model;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import xupt.se.ttms.view.sellticket.SeatCallback;

public class Seat {
	
	public static int NO_SELECT = 0;
	public static int SELECT = 1;
	
	private int x;
	private int y;
	private JLabel icon;
	private int statu;
	
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
				callback.selectSeat(x, y);
				
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
	public void setIcon(JLabel icon) {
		this.icon = icon;
	}
	
	
	
	public void setCallback(SeatCallback callback) {
		this.callback = callback;
	}
	
	
	
	
	

}
