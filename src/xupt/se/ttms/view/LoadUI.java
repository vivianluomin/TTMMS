package xupt.se.ttms.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import xupt.se.ttms.view.tmpl.ImagePanel;

public class LoadUI extends JFrame {
	
	private int frmWidth=1024;
	private int frmHeight=700;
	protected ImagePanel headPan = new ImagePanel("resource/image/header.jpg");
	private JTextField userText;
	private JPasswordField passwordText;

	protected JButton btnManagerLoad = new JButton("登录");	

	public LoadUI(){
		this.setSize(frmWidth, frmHeight);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setTitle("汉唐剧院票务管理系统");
		this.setLayout(null);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				onWindowClosing();
			}
		});		
		
		init();
	}
	
	
	
	private void init(){
		headPan.setBounds(0, 0, frmWidth, 80);
		headPan.setLayout(null);
		this.add(headPan);
		
		
		// 创建 JLabel
        JLabel userLabel = new JLabel("User:");
        /* 这个方法定义了组件的位置。
         * setBounds(x, y, width, height)
         * x 和 y 指定左上角的新位置，由 width 和 height 指定新的大小。
         */
        userLabel.setBounds(frmWidth/4,frmHeight/3,80,25);
        this.add(userLabel);

        /* 
         * 创建文本域用于用户输入
         */
         userText = new JTextField(20);
        userText.setBounds(frmWidth/4+100,frmHeight/3,165,25);
        this.add(userText);

        // 输入密码的文本域
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(frmWidth/4,frmHeight/3+50,80,25);
        this.add(passwordLabel);

        /* 
         *这个类似用于输入的文本域
         * 但是输入的信息会以点号代替，用于包含密码的安全性
         */
        passwordText = new JPasswordField(20);
        passwordText.setBounds(frmWidth/4+100,frmHeight/3+50,165,25);
        this.add(passwordText);
        
 
        
        btnManagerLoad.setBounds(frmWidth/4+200,frmHeight/3+100, 120, 25);
        this.add(btnManagerLoad);
        btnManagerLoad.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
        	
        });
        
		
	}
	
	private void onWindowClosing(){
		System.exit(0);
	}

	public static void main(String[] args) {
		new LoadUI().setVisible(true);

	}

}
