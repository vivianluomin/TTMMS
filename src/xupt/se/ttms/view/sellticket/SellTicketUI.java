package xupt.se.ttms.view.sellticket;

import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import xupt.se.ttms.view.tmpl.ImagePanel;
import xupt.se.ttms.view.tmpl.MainUITmpl;
import xupt.se.util.ConstantUtil;

public class SellTicketUI extends MainUITmpl{
	
	private int frmWidth=ConstantUtil.frmWidth-200;
	private int frmHeight=ConstantUtil.frmHeight;
	private JScrollPane scrollPane;
	private GridLayout layout;
	private JPanel contant;
	
	protected void initContent(){
		
		
	}

	public static void main(String[] args) {
		new SellTicketUI().setVisible(true);

	}

}
