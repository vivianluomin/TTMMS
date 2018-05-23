package xupt.se.ttms.view.sellticket;

import java.awt.Color;

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
	
	public NowShowMovieItem(ImagePanel Image,String movieName){
		this.setSize(frmWidth, frmHeight);
		this.setLayout(null);
		image = Image;
		image.setBounds(0, 25, frmWidth, frmHeight-35);
		image.setLayout(null);
		Name = new JLabel();
		Name.setBounds(0, 0, frmWidth, 20);
		Name.setHorizontalAlignment(JLabel.CENTER);
		Name.setText(movieName);
		Name.setForeground(Color.BLACK);
		this.add(Name, 0);
		this.add(image, 1);
		
	}
	
	
	public static void main(String[] args) {
		ImagePanel image = new ImagePanel("resource/image/film0.jpg");
	
		new NowShowMovieItem(image,"后来的我们").setVisible(true);

	}

}
