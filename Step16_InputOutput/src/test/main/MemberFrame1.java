package test.main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import test.dto.MemberDto;

public class MemberFrame1 extends JFrame implements ActionListener{

	JTextField inputNum, inputName, inputAddr;
	DefaultTableModel model;
	
	List<MemberDto> list=new ArrayList<>();
	
	public MemberFrame1(String title) {
		super(title);
		setLayout(new BorderLayout());
		
		JLabel label1=new JLabel("번호");
		JLabel label2=new JLabel("이름");
		JLabel label3=new JLabel("주소");
		
		inputNum=new JTextField(10);
		inputName=new JTextField(10);
		inputAddr=new JTextField(10);
		
		JButton addBtn=new JButton("추가");
		
		JPanel panel=new JPanel();
		panel.add(label1);
		panel.add(inputNum);
		panel.add(label2);
		panel.add(inputName);
		panel.add(label3);
		panel.add(inputAddr);
		panel.add(addBtn);
		
		add(panel, BorderLayout.NORTH);
		
		addBtn.addActionListener(this);
		
		addBtn.setActionCommand("add"); //명칭부여 
		
		JTable table=new JTable();
		String[] colNames= {"번호", "이름", "주소"};
		
		model=new DefaultTableModel(colNames,0); 
		//colNames 를 table 형식으로 표현하고 빈공백 표의 값을 넣을지 인덱스값 
		table.setModel(model);
		JScrollPane scroll=new JScrollPane(table);
		//테이블 감싸기
		add(scroll, BorderLayout.CENTER);
		refreshTable();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command=e.getActionCommand();
		//눌러진 버튼의 action command 값을 읽어온다.
		if(command.equals("add")) {
			int num=Integer.parseInt(inputNum.getText());
			String name=inputName.getText();
			String addr=inputName.getText();
			//MemberDto 객체에 회원 한명의 정보를 담는다.
			MemberDto dto = new MemberDto();
			dto.setNum(num);
			dto.setName(name);
			dto.setAddr(addr);
			//회원 한명의 정보를 List 에 담는다.
			list.add(dto);
			saveToFile();
			
		}
		refreshTable();
	}
	
	//테이블에 회원목록을 다시 출력해주는 메소드
	public void refreshTable() {
		//파일에 저장된 목록을 읽어온다.
		loadFromFile();
		//현재 테이블에 출력된 모든내용 삭제
		model.setRowCount(0);
		//반복문 돌면서 테이블 row 추가하기
		for(MemberDto tmp:list) {
			//MemberDto에 담긴 내용을 Object[] 에 담기
			Object[] row= {tmp.getNum(), tmp.getName(), tmp.getAddr()};
			
			
		}
		
	}
	
}
