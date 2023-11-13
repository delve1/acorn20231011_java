package test.main;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class MainClass07 extends JFrame implements ActionListener{
	JButton saveBtn;
	JTextField inputText;
	
	public MainClass07(String title) {
		this.setTitle("입력받은 문자열을 파일에 저장");
		
		setBounds(100, 100, 500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		inputText=new JTextField(30);
		
		JButton saveBtn=new JButton("저장");
				
		saveBtn.addActionListener(this);
		
		add(inputText);
		add(saveBtn);
		
	}
	
	public static void main(String[] args) {
		
		MainClass07 c = new MainClass07("저장");
		c.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String msg = inputText.getText();
		
		System.out.println("저장합니다.");
		
		//파일을 만들거나 이미 만들어진 파일에 대해서 작업할 객체 생성
				File f =new File("C:\\acorn202310\\myFolder/diary.txt");
				try {
				//만일 존재 하지 않으면
					if(!f.exists()) {
						f.createNewFile();
						System.out.println("diary.txt 파일을 만들었습니다!");
					}
					//파일에 문자열을 출력할 객체 생성
					FileWriter fw= new FileWriter(f, true);
					fw.write(msg);
					fw.write("\r\n");
					fw.flush();
					fw.close(); //마무리를 해야 파일도 정상적으로 만들어지고 사용가능하고 자원 누수가 방지된다.
					System.out.println("diary.txt 파일에 문자열을 기록 했습니다.");
				}catch(Exception r) {
					r.printStackTrace();
				}
		
	}
}
