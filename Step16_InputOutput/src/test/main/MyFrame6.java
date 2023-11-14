package test.main;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import test.dto.MemberDto;

public class MyFrame6 extends JFrame implements ActionListener{

	String[] labels = {"num", "name", "addr"};
	JTextField []fields = new JTextField[3];
	
	public MyFrame6(String title) {
		super(title);
		
		setBounds(100, 100, 500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		JPanel topPanel=new JPanel(new GridLayout(6,4,10,5));
		
		for(int i=0; i<3; i++) {
			topPanel.add(new JLabel(labels[i]));
			fields[i] = new JTextField(30);
			topPanel.add(fields[i]);
		}
		topPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		this.add("North",topPanel);
		
		//표 형식으로 출력할 JTable
		JTable table=new JTable();
		//테이블의 칼럼명을 미리 배열로 준비한다.
		String[] colNames= {"번호", "이름", "주소"};
		//테이블에 연결할 모델객체 생성 (테이블에 출력할 데이터를 여기에 추가하면 테이블에 출력된다)
		DefaultTableModel model=new DefaultTableModel(colNames, 0);
		//모델을 테이블에 연결한다.
	    table.setModel(model);
	    //테이블을 스크롤 페널로 감싸고 
	    JScrollPane scroll=new JScrollPane(table);
	    
		JButton saveBtn = new JButton("저장");
		
		saveBtn.addActionListener(this);
		
		add(saveBtn);
		


	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	public static void main(String[] args) {
		// members.dat 파일에 저장된 MemberDto 객체를 읽어와서 회원의 번호, 이름, 주소를 콘솔에 출력해 보세요
		
		MyFrame6 f =new MyFrame6("제목 없음");
		f.setVisible(true);
		
		FileInputStream fis=null;
		ObjectInputStream ois=null;
		try {
			fis = new FileInputStream("c:/acorn202310/myFolder/members.dat");
			ois = new ObjectInputStream(fis);
			//읽어낸 Object 를 원래 type 인 MemberDto type 으로 casting 한다.
			MemberDto dto=(MemberDto)ois.readObject();
			String info=String.format("%d %s %s", dto.getNum(), dto.getName(), dto.getAddr());
			System.out.println(info);
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if(fis!=null)fis.close();
				if(ois!=null)ois.close();
			}catch(Exception e) {}
		}
	}

}
