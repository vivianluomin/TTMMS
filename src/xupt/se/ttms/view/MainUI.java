package xupt.se.ttms.view;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;

import xupt.se.ttms.view.sellticket.SellTicketUI;
import xupt.se.ttms.view.studio.StudioMgrUI;
import xupt.se.util.ConstantUtil;


public class MainUI extends JFrame{
	
	private JSplitPane mSplite;
	private JButton mMovieManage;
	private JButton mStudioManage;
	private JButton mShowManage;
	private JButton mShellManage;
	private JButton mStafManage;
	private JLabel mUser;
	
	private JPanel leftPane;
	
	public MainUI(){
		this.setSize(ConstantUtil.frmWidth, ConstantUtil.frmHeight);
		this.setResizable(false);
		this.setTitle("汉唐剧院票务管理系统");
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				onWindowClosing();
			}
		});		
		
		init();
	}
	
	private void onWindowClosing(){
		System.exit(0);
	}
	
	private void init(){
		mSplite = new JSplitPane();
		mSplite.setSize(ConstantUtil.frmWidth, ConstantUtil.frmWidth);
		mSplite.setDividerLocation(200);
		this.add(mSplite);
		leftPane = new JPanel();
		leftPane.setLayout(null);
		mShellManage= new JButton("售票");
		mShellManage.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				ChangeRight(new SellTicketUI());
				
			}
			
		});
		mShellManage.setBounds(50, 200, 100, 40);
		mMovieManage = new JButton("影片管理");
		mMovieManage.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ChangeRight(new StudioMgrUI());
			}
			
		});
		mMovieManage.setBounds(50, 300, 100, 40);
		
		mStudioManage = new JButton("演出厅管理");
		mStudioManage.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ChangeRight(new StudioMgrUI());
			}
			
		});
		mStudioManage.setBounds(50, 400, 100, 40);
		
		mShowManage= new JButton("演出计划管理");
		mShowManage.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ChangeRight(new StudioMgrUI());
			}
			
		});
		mShowManage.setBounds(50, 500, 100, 40);
		
		mStafManage= new JButton("员工管理");
		mStafManage.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ChangeRight(new StudioMgrUI());
			}
			
		});
		mStafManage.setBounds(50, 600, 100, 50);
		leftPane.setBounds(0, 0, 200, ConstantUtil.frmHeight);
		mUser = new JLabel("vivian");
		mUser.setFont(new Font(null,Font.BOLD,18));
		mUser.setForeground(Color.black);
		mUser.setIcon(new ImageIcon("resource/image/user.png"));
		mUser.setHorizontalTextPosition(SwingConstants.CENTER);   // 水平方向文本在图片中心
		mUser.setVerticalTextPosition(SwingConstants.BOTTOM); 
		mUser.setHorizontalAlignment(JLabel.CENTER);
		mUser.setBounds(50, 50, 100, 100);
		leftPane.add(mUser);
		leftPane.add(mShellManage);
		leftPane.add(mMovieManage);
		leftPane.add(mStudioManage);
		leftPane.add(mShowManage);
		leftPane.add(mStafManage);
		leftPane.setBackground(new Color(255, 228, 225));
		
		mSplite.setLeftComponent(leftPane);
		
		mSplite.setRightComponent(new SellTicketUI());
		
	}

	
	private void ChangeRight(JPanel pane){
		mSplite.setDividerLocation(200);
		mSplite.setLeftComponent(leftPane);
		mSplite.setRightComponent(pane);
	}
	
	public static void main(String[] args) {
		MainUI mainUI = new MainUI();
		mainUI.setVisible(true);

	}

}
