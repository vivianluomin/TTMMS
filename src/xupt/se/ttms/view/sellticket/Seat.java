package xupt.se.ttms.view.sellticket;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import com.mysql.jdbc.Statement;

import xupt.se.util.DBUtil;



public class Seat{
		
		static SmallSeat[] Seat1s = new SmallSeat[226];  
		private JLabel label1;	
		private static JPanel text1; 
		private JLabel label2 ;  
		private static JTextArea text2; 
		private JButton button1;  
		private static int num;  
		private JLabel label3;   
		String[] numS = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15"};  
		private static int getseat[][]; 
		
	

		
		public Seat() {
			num = 0;
			label1 = new JLabel("��ѡ�����λ��");
			text1 = new JPanel();
			label2 = new JLabel("�ܼƣ�");
			text2 = new JTextArea(8,8);
			button1 = new JButton("ȷ��");
			label3 = new JLabel("��  Ļ");
			getseat = new int[15][3];
			
		}

		public int getnum(){
			return num;
		}
		
		public static JPanel getText1() {
			return text1;
		}

		public static SmallSeat[] getSeat1s() {
			return Seat1s;
		}

		public static void setSeat1s(SmallSeat[] seat1s) {
			Seat1s = seat1s;
		}
		
		
		public static void setGetseat(int row,int col) {
			getseat[num][0] = row;
			getseat[num][1] = col;
		}
		
		
		public static void delGetseat(int row,int col){
			for (int[] is : getseat) {
				if(is[0]==row && is[1]==col)
					{
						is[0] = 0;
						is[1] = 0;
					}
			}
		}
		
		public static int[][] getGetseat() {
			return getseat;
		}

		
		
		public static void numof(){
			num++;
			text2.setText(num*10 +"Ԫ");
		}
		
		public static void numoff(){
			num--;
			text2.setText(num*10 +"Ԫ");
		}
	
		
		
		public JPanel builtBoxs() throws SQLException{
			
			
			
			JPanel panel = new JPanel(); 
			panel.setLayout(new GridLayout(15, 15));   
			panel.setBorder(BorderFactory.createEmptyBorder(25, 10, 10,10));
			int row,col;
			for (int i = 1; i < 226; i++) { 
				
	        	if(i%15 != 0)
	        	{
	        		Seat1s[i] = new SmallSeat("��"+(i/15+1)+"��"+"��"+i%15+"��",(i/15+1),i%15);
	        		row = i/15+1;
	        		col = i%15;
	        	}
	        		
	            else
	            	{
	            		Seat1s[i] = new SmallSeat("��"+i/15+"��"+"��15��",15,i/15); 	
	            		row = 15;
	            		col = i/15;
	            	}
	        	
	        	while(i<7)
				{
					
						Seat1s[i] = new SmallSeat("��"+row+"��"+"��"+col+"��",row,col,true);
					
				}

	            panel.add(Seat1s[i].getBox());           
	        }
			
			return panel;
		}
		
		
		public JPanel addname(){	
			
			  JPanel namePanel = new JPanel();
			  
		        namePanel.setBorder(BorderFactory.createEmptyBorder(25, 10, 10, 10));
		        namePanel.setLayout(new GridLayout(15, 15) );
		        for(int i = 0; i<15;i++)
		        	namePanel.add(new Label(numS[i]));
		        
		        return namePanel;
		        
		}
		
		
		public JLabel altLabel(){
			 label3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
		        label3.setBounds(10, 10, 2, 2);
		        label3.setHorizontalAlignment(SwingConstants.CENTER);      
		        return label3;
		}
			
		
		public JScrollPane setNameLabel(){	
			JPanel panel5 = new JPanel();

			JScrollPane scroller = new JScrollPane(panel5);
			scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);	

			panel5.setLayout(new BoxLayout(panel5, BoxLayout.Y_AXIS));
			panel5.add(text1);
			
			return scroller;
	
		}
		
		public void go(){
			JFrame frame = new JFrame();
			
			text1.setLayout(new BoxLayout(text1,BoxLayout.Y_AXIS));

	        JPanel panel1 = new JPanel();
	        JPanel panel2 = new JPanel();
			JPanel panel3 = new JPanel();
			JPanel panel4 = new JPanel();
			

			panel1.setLayout(new BoxLayout(panel1,BoxLayout.Y_AXIS));
			panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
			panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
		
			
			panel2.add(label1); 
			panel2.add(new JPanel());
			
			panel2.add(setNameLabel());
			
			panel3.add(label2);
			panel3.add(text2);
			panel3.add(button1);
			
			panel1.add(panel2);
			panel1.add(panel4);
			panel1.add(panel3);
			
			button1.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {

				}
		
			});
			
			frame.setBounds(675, 200, 500, 500);
			frame.getContentPane().add(altLabel(), BorderLayout.NORTH);
			frame.getContentPane().add(addname(), BorderLayout.WEST);
			frame.getContentPane().add(panel1, BorderLayout.EAST);
			try {
				frame.getContentPane().add( BorderLayout.CENTER,builtBoxs());
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			frame.setSize(500,500);
			frame.setVisible(true);
		}
	
	}
		