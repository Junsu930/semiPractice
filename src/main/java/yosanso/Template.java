package yosanso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Template {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@112.220.137.37:1521:XE";
	String user = "yosangso";
	String pw = "yosangso";
	
	public Template() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pw);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public String read() {
		String proName = "";
		try {
			String sql = "SELECT PRODUCT_NM FROM PRODUCT WHERE PRODUCT_NO =1";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				proName = rs.getString("PRODUCT_NM");
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return proName;
		
	}
	
	public String details() {
		String proName = "";
		try {
			String sql = "SELECT EXPLAIN FROM PRODUCT WHERE PRODUCT_NO =2";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				proName = rs.getString("EXPLAIN");
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		return proName;
	}
	
	public Product buyOne(int proNum) {
		
		Product pd = new Product();
		
		try {
			String sql = "SELECT PRODUCT_NO, PRODUCT_NM, CATEGORY, PRICE  FROM PRODUCT WHERE PRODUCT_NO = ?";
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, proNum);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int proNo = rs.getInt("PRODUCT_NO");
				String proNm= rs.getString("PRODUCT_NM");
				char cate = rs.getString("CATEGORY").charAt(0);
				int price = rs.getInt("PRICE");
					
				pd = new Product(proNo, proNm, cate, price);
						
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}	
		return pd;	
	}

}
