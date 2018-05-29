package xupt.se.ttms.view.sellticket;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import xupt.se.util.ConstantUtil;

public class MovieStudioItem extends JPanel{
	private int mWidth = ConstantUtil.frmWidth-200;
	private int mHeight = 100;
	private JLabel mStudioName;
	private JLabel mTime;
	private JLabel mPrice;
	private JButton mBtn;

	
	public MovieStudioItem(){
		this.setSize(mWidth, mHeight);
		this.setLayout(null);
		this.setBackground(Color.pink);
		initContent();
	}
	
	
	private void initContent(){
		mStudioName = new JLabel("放映厅1");
		mStudioName.setFont(new Font(null,Font.BOLD,18));
		mStudioName.setBounds(30, 0, mWidth/4, mHeight);
		mStudioName.setHorizontalAlignment(JLabel.LEFT);
		mStudioName.setOpaque(false);
		this.add(mStudioName);
		
		mTime = new JLabel("14:30 - 16:00");
		mTime.setFont(new Font(null,Font.BOLD,18));
		mTime.setBounds(30+mWidth/4, 0, mWidth/4, mHeight);
		mTime.setHorizontalAlignment(JLabel.LEFT);
		this.add(mTime);
		
		mPrice = new JLabel("24元");
		mPrice.setFont(new Font(null,Font.BOLD,18));
		mPrice.setBounds(30+mWidth/2, 0, mWidth/4, mHeight);
		mPrice.setHorizontalAlignment(JLabel.LEFT);
		this.add(mPrice);
		
		mBtn  = new JButton("购票");
		mBtn.setFont(new Font(null,Font.PLAIN,14));
		mBtn.setBounds(mWidth-200, mHeight/3, 80, 40);
		mBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		this.add(mBtn);
		
		JLabel line = new JLabel();
		line.setBounds(0, mHeight-1, mWidth, 1);
		line.setOpaque(true);
		line.setBackground(Color.GRAY);
		this.add(line);
		
	}

	public static void main(String[] args) {
		new MovieStudioItem().setVisible(true);

	}

}
