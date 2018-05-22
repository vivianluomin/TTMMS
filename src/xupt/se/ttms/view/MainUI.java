package xupt.se.ttms.view;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import xupt.se.ttms.view.studio.StudioMgrUI;
import xupt.se.util.ConstantUtil;


public class MainUI extends JFrame{
	
	private JSplitPane mSplite;
	private JButton mMovieManage;
	private JButton mStudioManage;
	private JButton mShowManage;
	private JButton mShellManage;
	private JButton mStafManage;
	
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
				ChangeRight(new StudioMgrUI());
				
			}
			
		});
		mShellManage.setBounds(50, 50, 100, 40);
		mMovieManage = new JButton("影片管理");
		mMovieManage.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ChangeRight(new StudioMgrUI());
			}
			
		});
		mMovieManage.setBounds(50, 150, 100, 40);
		
		mStudioManage = new JButton("演出厅管理");
		mStudioManage.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ChangeRight(new StudioMgrUI());
			}
			
		});
		mStudioManage.setBounds(50, 250, 100, 40);
		
		mShowManage= new JButton("演出计划管理");
		mShowManage.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ChangeRight(new StudioMgrUI());
			}
			
		});
		mShowManage.setBounds(50, 350, 100, 40);
		
		mStafManage= new JButton("员工管理");
		mStafManage.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ChangeRight(new StudioMgrUI());
			}
			
		});
		mStafManage.setBounds(50, 450, 100, 40);
		leftPane.setBounds(0, 0, 200, ConstantUtil.frmHeight);
		leftPane.add(mShellManage);
		leftPane.add(mMovieManage);
		leftPane.add(mStudioManage);
		leftPane.add(mShowManage);
		leftPane.add(mStafManage);
		mSplite.setLeftComponent(leftPane);
		
		mSplite.setRightComponent(new StudioMgrUI());
		
	}

	
	private void ChangeRight(JPanel pane){
		mSplite.setLeftComponent(leftPane);
		mSplite.setRightComponent(pane);
	}
	
	public static void main(String[] args) {
		MainUI mainUI = new MainUI();
		mainUI.setVisible(true);

	}

}
