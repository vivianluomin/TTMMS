package xupt.se.ttms.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import xupt.se.ttms.view.tmpl.ImagePanel;

public class LoadUI extends JFrame {
	
	private int frmWidth=500;
	private int frmHeight=400;
	protected ImagePanel headPan = new ImagePanel("resource/image/bg.jpg");
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
		
//		JLayeredPane layerpane = new JLayeredPane();
//		headPan.setBounds(0, 0, frmWidth, frmHeight);
//		headPan.setLayout(null);
//		//this.add(headPan);
//		layerpane.add(headPan, 0,1);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, frmWidth, frmHeight);
		panel.setLayout(null);
		
		
		// 创建 JLabel
        JLabel userLabel = new JLabel("User:");
        userLabel.setFont(new Font(null,Font.PLAIN,16));
        /* 这个方法定义了组件的位置。
         * setBounds(x, y, width, height)
         * x 和 y 指定左上角的新位置，由 width 和 height 指定新的大小。
         */
        userLabel.setBounds(frmWidth/4,frmHeight/3,80,25);
        panel.add(userLabel);
        

        /* 
         * 创建文本域用于用户输入
         */
         userText = new JTextField(20);
         
        userText.setBounds(frmWidth/4+100,frmHeight/3,165,25);
        panel.add(userText);

        // 输入密码的文本域
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font(null,Font.PLAIN,16));
        passwordLabel.setBounds(frmWidth/4,frmHeight/3+50,80,25);
        panel.add(passwordLabel);

        /* 
         *这个类似用于输入的文本域
         * 但是输入的信息会以点号代替，用于包含密码的安全性
         */
        passwordText = new JPasswordField(20);
        passwordText.setBounds(frmWidth/4+100,frmHeight/3+50,165,25);
        panel.add(passwordText);
        
 
        
        btnManagerLoad.setBounds(frmWidth/4+200,frmHeight/3+100, 120, 25);
        panel.add(btnManagerLoad);
        btnManagerLoad.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new MainUI().setVisible(true);
				LoadUI.this.setVisible(false);
				
			}
        	
        });
        
		panel.setBackground(new Color(255, 228, 225));
		this.setContentPane(panel);
	}
	
	private void onWindowClosing(){
		System.exit(0);
	}

	public static void main(String[] args) {
		new LoadUI().setVisible(true);

	}

}
