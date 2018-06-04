package xupt.se.ttms.view.sellticket;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import xupt.se.ttms.view.studio.ImageJPanel;
import xupt.se.ttms.view.tmpl.ImagePanel;
import xupt.se.ttms.view.tmpl.MainUITmpl;
import xupt.se.util.ConstantUtil;

public class NowShowMovieItem extends JPanel{
	
	private int frmWidth = 200;
	private int frmHeight = 330;
	private ImagePanel image;
	private JLabel Name;
	private String intro;
	private int play_id;
	
	public NowShowMovieItem(ImagePanel Image,String movieName){
		this.setSize(frmWidth, frmHeight);
		this.setLayout(null);
		this.setBackground(Color.pink);
		image = Image;
		image.setBounds(0, 25, frmWidth, frmHeight-35);
		image.setLayout(null);
		Name = new JLabel();
		Name.setBounds(0, 0, frmWidth, 20);
		Name.setHorizontalAlignment(JLabel.CENTER);
		Name.setFont(new Font(null,Font.BOLD,14));
		Name.setText(movieName);
		Name.setForeground(Color.white);
		this.add(Name, 0);
		this.add(image, 1);
		
		this.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				MovieStudioUI ui = new MovieStudioUI(play_id);
				ui.setIntroduction(intro);
				ui.setPlay_id(play_id);
						ui.setVisible(true);
				
			}
			
		});
		
		
	}
	
	public void setIntro(String intro){
		this.intro = intro;
	}
	
	public String getIntro(){
		return intro;
	}
	
	
	
	
	public int getPlay_id() {
		return play_id;
	}

	public void setPlay_id(int play_id) {
		this.play_id = play_id;
	}

	public static void main(String[] args) {
		ImagePanel image = new ImagePanel("resource/image/film0.jpg");
	
		new NowShowMovieItem(image,"后来的我们").setVisible(true);

	}

}
