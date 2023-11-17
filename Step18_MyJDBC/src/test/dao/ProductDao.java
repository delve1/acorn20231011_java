package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.dto.ProductDto;
import test.util.DBConnect;

public class ProductDao {
	
	public boolean insert(ProductDto dto) {
		//필요한 객체의 참조값을 담을 지역 변수 미리 선언
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rowCount = 0;
		try {
			//미리 준비한 util 클래스를 이용해서 Connection 객체 얻어오기 
			conn = new DBConnect().getConn();
			//실행할 미완성의 sql 문
			String sql = "insert into product"
					+ " (pnum, pname, price, qty, origin, dom, sig)"
					+ " values(product_seq.nextval, ?, ?, ?, ?, ?, ?)";
			//미완성의 sql 문을 전달하면서 PreparedStatement 객체의 참조값 얻어내기
			pstmt = conn.prepareStatement(sql);
			//PreparedStatement 객체의 메소드를 이용해서 미완성인 sql 문을 완성시키기(? 에 값 바인딩하기)
			pstmt.setString(1, dto.getPname());
			pstmt.setString(2, dto.getPrice());
			pstmt.setString(3, dto.getQty());
			pstmt.setString(4, dto.getOrigin());
			pstmt.setString(5, dto.getDom());
			pstmt.setString(6, dto.getSig());
			//sql 문 실행하기
			rowCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		if (rowCount > 0) {
			return true;
		} else {
			return false;
		}

	}

	
	public boolean update(ProductDto dto) {
		//필요한 객체의 참조값을 담을 지역 변수 미리 선언
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rowCount = 0;
		try {
			//미리 준비한 util 클래스를 이용해서 Connection 객체 얻어오기 
			conn = new DBConnect().getConn();
			//실행할 미완성의 sql 문
			String sql = "update product"
					+ " set pname=?, price=?, qty=?, origin=?, dom=?, sig=?"
					+ " where pnum=?";
			//미완성의 sql 문을 전달하면서 PreparedStatement 객체의 참조값 얻어내기
			pstmt = conn.prepareStatement(sql);
			//PreparedStatement 객체의 메소드를 이용해서 미완성인 sql 문을 완성시키기(? 에 값 바인딩하기)
			pstmt.setString(1, dto.getPname());
			pstmt.setString(2, dto.getPrice());
			pstmt.setString(3, dto.getQty());
			pstmt.setString(4, dto.getOrigin());
			pstmt.setString(5, dto.getDom());
			pstmt.setString(6, dto.getSig());
			pstmt.setInt(7, dto.getPnum());
			//sql 문 실행하기
			rowCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		if (rowCount > 0) {
			return true;
		} else {
			return false;
		}

	}
	
	public boolean delete(int pnum) {
		//DB 에서 SELECT 하기위해서 필요한 객체를 담을 지역변수 미리 만들기 
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int rowCount=0;
		try {
			//Connection 객체의 참조값 얻어오기 
			conn = new DBConnect().getConn();
			//실행할 sql문 미리 준비
			String sql = "delete from product"
					+ " where pnum=?";
			//sql 문을 대신 실행해줄 PreparedStatement 객체의 참조값 얻어오기
			pstmt = conn.prepareStatement(sql);
			//만일 sql 문이 미완성이라면( ? 가 있다면) 여기서 ? 에 값을 바인딩 해준다.
			pstmt.setInt(1, pnum);

			rowCount=pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		if(rowCount>0) {
			return true;
		}else {
			return false;
		}

	}
	
	
	public ProductDto getData(int pnum) {
		ProductDto dto=null;
		//DB 에서 SELECT 하기위해서 필요한 객체를 담을 지역변수 미리 만들기 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//Connection 객체의 참조값 얻어오기 
			conn = new DBConnect().getConn();
			//실행할 sql문 미리 준비
			String sql = "select pname, price, qty, origin, dom, sig "
					+ " from product"
					+ " where pnum=?";
			//sql 문을 대신 실행해줄 PreparedStatement 객체의 참조값 얻어오기
			pstmt = conn.prepareStatement(sql);
			//만일 sql 문이 미완성이라면( ? 가 있다면) 여기서 ? 에 값을 바인딩 해준다.
			pstmt.setInt(1, pnum);
			rs = pstmt.executeQuery();

			//반복문 돌면서 
			if (rs.next()) {// cursor 다음 line 에 select 된 row 가 있다면
				dto=new ProductDto();
				dto.setPnum(pnum);
				dto.setPname(rs.getString("pname"));
				dto.setPrice(rs.getString("price"));
				dto.setQty(rs.getString("qty"));
				dto.setOrigin(rs.getString("origin"));
				dto.setDom(rs.getString("dom"));
				dto.setSig(rs.getString("sig"));
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		
		return dto;
	}


public List<ProductDto> getList(){
	List<ProductDto> list = new ArrayList<>();
	//DB 에서 SELECT 하기위해서 필요한 객체를 담을 지역변수 미리 만들기 
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	try {
		//Connection 객체의 참조값 얻어오기 
		conn = new DBConnect().getConn();
		//실행할 sql문 미리 준비
		String sql = "select pnum, pname, price, qty, origin, dom, sig"
				+ " from product"
				+ " order by pnum asc";
		//sql 문을 대신 실행해줄 PreparedStatement 객체의 참조값 얻어오기
		pstmt = conn.prepareStatement(sql);
		//만일 sql 문이 미완성이라면( ? 가 있다면) 여기서 ? 에 값을 바인딩 해준다.
		rs = pstmt.executeQuery();

		//반복문 돌면서 
		while (rs.next()) {// cursor 다음 line 에 select 된 row 가 있다면
			ProductDto dto=new ProductDto();
			dto.setPnum(rs.getInt("pnum"));
			dto.setPname(rs.getString("pname"));
			dto.setPrice(rs.getString("price"));
			dto.setQty(rs.getString("qty"));
			dto.setOrigin(rs.getString("origin"));
			dto.setDom(rs.getString("dom"));
			dto.setSig(rs.getString("sig"));
			list.add(dto);
		}

	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
		}
	}
	return list;
}
}

