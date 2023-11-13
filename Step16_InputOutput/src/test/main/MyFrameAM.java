package test.main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;

public class MyFrameAM extends JFrame implements ActionListener{
	
	JTextField nums, names, addr;
	
	public MyFrameAM (String title) {
		
	super(title);
	setBounds(100, 100, 900, 200);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLayout(new BorderLayout());
	
	nums=new JTextField(10);
	names=new JTextField(10);
	addr=new JTextField(50);
	
	JButton addBtn = new JButton("회원정보추가");
	JButton seeBtn = new JButton("회원목록보기");
	
	add(nums);
	add(names);
	add(addr);
	add(addBtn);
	add(seeBtn);
	
	addBtn.addActionListener(this);
	seeBtn.addActionListener(this);
	
	addBtn.setActionCommand("add");
	seeBtn.setActionCommand("see");
	
	FileFilter filter = new FileFilter() {
		
		@Override
		public String getDescription() {
			return "텍스트 파일 ( *.txt )";
		}
		
		@Override
		public boolean accept(File f) {
			if(f.isDirectory())
			return true;
		}
		
		String fileName=f.getName();
		int dotIndex=fileName.lastIndexOf(".");
		if(dotIndex==0 || dotIndex==-1) {
			return false;
		}
		String ext=fileName.subString(dotIndex+1);
		if(ext.equals("txt")) {
			return true;
		}
		return false;
	}
	}
	};
	
//	JTable table = new JTable();
//	
//	String [] colNames = {"번호", "이름", "주소"};
//	
//	DefaultTableModel model = new DefaultTableModel(colNames,0);
//	
//	table.setModel(model);
//	
//	JScrollPane scroll=new JScrollPane(table);
//	
//	add(scroll, BorderLayout.CENTER);
	
	}
		
		public static void main(String args) {
			MyFrameAM f = new MyFrameAM("회원관리");
			f.setVisible(true);
		}
		


	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		String strNums = nums.getText();
		String strNames = names.getText();
		String strAddr = addr.getText();
		
		try {
			int nums = Integer.parseInt(strNums);
		}catch(Exception err){
			err.printStackTrace();
		}
//		Scanner sc = new Scanner(System.in);
//		while(true) {
//			Vector<Object> row =new Vector<>();
//			for(int i=0; i<3; i++) {
//			row
//			Object mifo.scanner.nextLine();
//			row.add(mifo);
//			}
		
		
		
	}
}
