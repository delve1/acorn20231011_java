package test.dto;

import java.io.Serializable;

public class ProductDto implements Serializable{
	
	private int pnum;
	private String pname; 
	private String price;
	private String qty;
	private String origin;
	private String dom;
	private String sig;
	
	public ProductDto() {
		
	}
	
	
	public int getPnum() {
		return pnum;
	}
	
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	
	
	public String getPname() {
		return pname;
	}
	
	public void setPname(String pname) {
		this.pname = pname;
	}
	
	
	public String getPrice() {
		return price;
	}
	
	public void setPrice(String price) {
		this.price = price;
	}
	
	
	public String getQty() {
		return qty;
	}
	
	public void setQty(String qty) {
		this.qty = qty;
	}
	
	
	public String getOrigin() {
		return origin;
	}
	
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
	
	public String getDom() {
		return dom;
	}
	
	public void setDom(String dom) {
		this.dom = dom;
	}
	
	
	public String getSig() {
		return sig;
	}
	
	public void setSig(String sig) {
		this.sig = sig;
	}
	
	
	public ProductDto(int pnum, String pname, 
			String price, String qty, String origin, 
			String dom, String sig) {
		super();
		this.pnum = pnum;
		this.pname = pname;
		this.price = price;
		this.qty = qty;
		this.origin = origin;
		this.dom = dom;
		this.sig = sig;
	}
	
}
