package test.cal;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Calculator extends JFrame {
	
	JButton btn1, btn2, btn3, btn4;
	JTextField inputT1;
	JTextField inputT2;
	JLabel label;
	JLabel labelR;

	//프레임 제목
	public Calculator() {
		this.setTitle("계산기");
		
		setBounds(100,100,500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		//객체 생성
		inputT1 = new JTextField(20);
		JButton btn1 = new JButton("+");
		JButton btn2 = new JButton("-");
		JButton btn3 = new JButton("*");
		JButton btn4 = new JButton("/");
		inputT2 = new JTextField(20);
		label = new JLabel("=");
		labelR = new JLabel("결과");
		
		
		try {
			
		btn1.addActionListener((e)->{
			String t1 = inputT1.getText();
			String t2 = inputT2.getText();
			double i1 = Double.parseDouble(t1);
			double i2 = Double.parseDouble(t2);
			double result1 = i1+i2; 
			String result1s = String.format("%f", result1);
			labelR.setText(result1s);
			System.out.println(t1+"+"+t2+" 은 "+result1+" 입니다.");
		});
		
		
		
		
		btn2.addActionListener((e)->{
			String t1 = inputT1.getText();
			String t2 = inputT2.getText();
			double i1 = Double.parseDouble(t1);
			double i2 = Double.parseDouble(t2);
			double result2 = i1-i2;
			String result2s = String.format("%f", result2);
			labelR.setText(result2s);
			System.out.println(t1+"-"+t2+" 은 "+result2+" 입니다.");
		});
		
		
		
		
		btn3.addActionListener((e)->{
			String t1 = inputT1.getText();
			String t2 = inputT2.getText();
			double i1 = Double.parseDouble(t1);
			double i2 = Double.parseDouble(t2);
			double result3 = i1*i2; 
			String result3s = String.format("%f", result3);
			labelR.setText(result3s);
			System.out.println(t1+"*"+t2+" 은 "+result3+" 입니다.");
		});

		
		
		
		btn4.addActionListener((e)->{
			String t1 = inputT1.getText();
			String t2 = inputT2.getText();
			double i1 = Double.parseDouble(t1);
			double i2 = Double.parseDouble(t2);
			double result4 = i1/i2; 
			String result4s = String.format("%f", result4);
			labelR.setText(result4s);
			System.out.println(t1+"/"+t2+" 은 "+result4+" 입니다.");
		});
		
		}catch(Exception e1) {
			
		}
		
		add(inputT1);
		add(inputT2);
		add(label);
		add(labelR);
		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
		
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Calculator();
		System.out.println("값을 입력해주세요.");
	}
	
}
