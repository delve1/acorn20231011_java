package test.main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import test.dao.ProductDao;
import test.dto.ProductDto;

public class ProductFrame extends JFrame implements ActionListener{
	
	JTextField inputPnum, inputPname, inputPrice, 
	inputQty, inputOrigin, inputDom, inputSig; 
	//qty = quantity 수량 dom = date of manufacture 제조일
	//sig = significant 특이사항
	
	List<ProductDto> list = new ArrayList<>();
	DefaultTableModel model;
	JTable table;
	
	public ProductFrame(String title) {
		super(title);
		setLayout(new BorderLayout());
		
		JLabel label1 = new JLabel("상품명");
		JLabel label2 = new JLabel("가격");
		JLabel label3 = new JLabel("수량");
		JLabel label4 = new JLabel("원산지");
		JLabel label5 = new JLabel("제조일");
		JLabel label6 = new JLabel("특이사항");
		
		inputPname = new JTextField(20);
		inputPrice = new JTextField(10);
		inputQty = new JTextField(5);
		inputOrigin = new JTextField(20);
		inputDom = new JTextField(15);
		inputSig = new JTextField(25);
		
		JButton addBtn = new JButton("추가");
		JButton deleteBtn = new JButton("선택된 물품정보 삭제");
		
		JPanel panel = new JPanel();
		panel.add(label1);
		panel.add(inputPname);
		panel.add(label2);
		panel.add(inputPrice);
		panel.add(label3);
		panel.add(inputQty);
		panel.add(label4);
		panel.add(inputOrigin);
		panel.add(label5);
		panel.add(inputDom);
		panel.add(label6);
		panel.add(inputSig);
		panel.add(addBtn);
		panel.add(deleteBtn);
		
		add(panel, BorderLayout.SOUTH);
		
		addBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		
		addBtn.setActionCommand("add");
		deleteBtn.setActionCommand("delete");
		
		table = new JTable();
		
		String[] colNames = {"상품번호", "상품명", "가격", 
				"수량", "원산지", "제조일", "특이사항", "총가격", "전체가격"};
		
		model = new DefaultTableModel(colNames,0) {
		
				
			@Override
			public boolean isCellEditable(int row, int column) {
				if(column==0) {
					return false;
				}else {
					return true;
				}
			}
		};
		
		table.addPropertyChangeListener((e)->{
			System.out.println("리스너 동작!");
			System.out.println(e.getPropertyName());
			System.out.println(table.isEditing());
			
			if(e.getPropertyName().equals("tableCellEditor") && !table.isEditing()) {
				int selectedIndex = table.getSelectedRow();
				
				int pnum = (int)model.getValueAt(selectedIndex, 0);
				String pname = (String)model.getValueAt(selectedIndex, 1);
				String price = (String)model.getValueAt(selectedIndex, 2);
				String qty = (String)model.getValueAt(selectedIndex, 3);
				String origin = (String)model.getValueAt(selectedIndex, 4);
				String dom = (String)model.getValueAt(selectedIndex, 5);
				String sig = (String)model.getValueAt(selectedIndex, 6);
				
				ProductDto dto=new ProductDto(pnum, pname, price, qty,
						origin, dom, sig);
				
				new ProductDao().update(dto);
				
				table.clearSelection();
			}
		});
		
		table.setModel(model);
		JScrollPane scroll=new JScrollPane(table);
		add(scroll, BorderLayout.CENTER);
		refreshTable();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String command=e.getActionCommand();
		if(command.equals("add")) {
			String pname=inputPname.getText();
			String price=inputPrice.getText();
			String qty=inputQty.getText();
			String origin=inputOrigin.getText();
			String dom=inputDom.getText();
			String sig=inputSig.getText();
			
			ProductDto dto = new ProductDto();
			
			dto.setPname(pname);
			dto.setPrice(price);
			dto.setQty(qty);
			dto.setOrigin(origin);
			dto.setDom(dom);
			dto.setSig(sig);
			
			new ProductDao().insert(dto);
		}else if(command.equals("delete")) {
			int row = table.getSelectedRow();
			if(row==-1) {
				JOptionPane.showMessageDialog(this, "삭제할 row 를 선택해 주세요");
				 return;
			}
			ProductDto dto=list.get(row);
			int num=dto.getPnum();
			new ProductDao().delete(num);
		}
		refreshTable();
	}
	
	public void refreshTable() {
		list = new ProductDao().getList();
		model.setRowCount(0);
		for(ProductDto tmp:list) {
			Object[] row = {tmp.getPnum(),tmp.getPname(),tmp.getPrice(),tmp.getQty(),
					tmp.getOrigin(),tmp.getDom(),tmp.getSig()};
			model.addRow(row);
			}
		}
	
	
	
	public static void main(String[] args) {
		JFrame f = new ProductFrame("물품관리");
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setBounds(100, 100, 1600, 500);
		f.setVisible(true);
	}
}
