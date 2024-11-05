package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.Result;

import model.TacGia;

public class TacGiaDAO implements InterfaceDAO<TacGia>{
	
	@Override
	public ArrayList<TacGia> selectAll() {
		ArrayList ketQua = new ArrayList();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM tacgia";
			PreparedStatement ps = con.prepareStatement(sql);
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = ps.executeQuery();
			
			// Bước 4: get data trong DB
			while(rs.next()) {
				String maTacGia = rs.getString("ma_tacgia");
				String tenTacGia = rs.getString("ten_tacgia");
				Date ngaySinh = rs.getDate("ngay_sinh");
				int soTacPham = rs.getInt("so_tacpham");
				
				TacGia x = new TacGia(maTacGia, tenTacGia, ngaySinh, soTacPham);
				ketQua.add(x);
			}
			
			// Bước 5: đóng connect
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
	public TacGia selectById(TacGia x) {
		TacGia ketqua = null;
		try {
			//b1 :tạo kết nối JDBC
			Connection con = JDBCUtil.getConnection();
			
			//b2: tạo ra đối tượng Preparedstatement 
			String sql = "SELECT * FROM tacgia WHERE ma_tacgia=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, x.getMaTacGia());
			
			//b3: thực thi câu lệnh SQL 
			System.out.println(sql);
			ResultSet rs = ps.executeQuery();
			
			//b4: get data trong DB
			while(rs.next()) {
				String maTacGia = rs.getString("ma_tacgia");
				String tenTacGia = rs.getString("ten_tacgia");
				Date ngaySinh = rs.getDate("ngay_sinh");
				int soTacPham = rs.getInt("so_tacpham"); 
				ketqua = new TacGia(maTacGia, tenTacGia, ngaySinh, soTacPham);
				break;
			}
			
			
			// b5: đóng kết nối
			JDBCUtil.closeConnection(con);
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public int insert(TacGia x) {
		int ketqua = 0;
		try {
			//b1 : tạo connect
			Connection con = JDBCUtil.getConnection();
			
			//b2: tạo object Statement và set thông tin 
			String sql = "INSERT INTO tacgia(ma_tacgia, ten_tacgia, ngay_sinh, so_tacpham) " + 
			" VALUES (?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, x.getMaTacGia());
			ps.setString(2, x.getTenTacGia());
			ps.setDate(3, x.getNgaySinh());
			ps.setInt(4, x.getSoSanPham());
			
			//b3: Thực thi lệnh SQL 
			ketqua = ps.executeUpdate();
			
			//b4: 
			System.out.println("đã thực thi " + sql);
			System.out.println("có "+ ketqua + " dòng được cập nhật!");
			
			//b5: đóng connect
			JDBCUtil.closeConnection(con);
			
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public int insertAll(ArrayList<TacGia> list) {
		int cnt = 0 ;
		for (TacGia x : list) {
			cnt += insert(x);
		}
		System.out.println("có " + cnt + " dòng được cập nhật");
		return cnt;
	}

	@Override
	public boolean delete(TacGia x) {
		int cnt = 0;
		try {
			//b1 : connect DB
			Connection con = JDBCUtil.getConnection();
			
			//b2: tạo PreparedStament 
			String sql = "DELETE FROM tacgia WHERE ma_tacgia=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, x.getMaTacGia());
			
			//b3: thực thi lệnh SQL 
			System.out.println(sql);
			 cnt += ps.executeUpdate();
			
			//b4: chatlog
			System.out.println("đã thực thi " + sql);
			System.out.println("có " + cnt + " dòng được cập nhật" );
			
			//b5: đóng connect
			JDBCUtil.closeConnection(con);
			
			
					
		} catch (Exception e) {
			e.printStackTrace();;
			
		}
		return true;
	}

	@Override
	public boolean deleteAll() {
		int cnt = 0;
		try {
			//b1 : connect DB
			Connection con = JDBCUtil.getConnection();
			
			//b2: tạo PreparedStament 
			String sql = "DELETE FROM tacgia";
			PreparedStatement ps = con.prepareStatement(sql);
			
			
			//b3: thực thi lệnh SQL 
			System.out.println(sql);
			 cnt += ps.executeUpdate();
			
			//b4: chatlog
			System.out.println("đã thực thi " + sql);
			System.out.println("có " + cnt + " dòng được cập nhật" );
			
			//b5: đóng connect
			JDBCUtil.closeConnection(con);
			
			
					
		} catch (SQLException e) {
			
			System.out.println("Không thể xóa !!! Ràng buộc khóa");
			
		}
		
		return true;
	}

	@Override
	public boolean update(TacGia x) {
		int cnt = 0;
		try {
			//b1: tạo connect 
			Connection con = JDBCUtil.getConnection();
			
			//b2: tạo object PreparedStament
			String sql = "UPDATE tacgia SET ten_tacgia=?,ngay_sinh=?,so_tacpham=? WHERE ma_tacgia=?";
			
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, x.getTenTacGia());
			ps.setDate(2, x.getNgaySinh());
			ps.setInt(3, x.getSoSanPham());
			ps.setString(4, x.getMaTacGia());
			
			
			//b3: thực thi lệnh sql
			cnt += ps.executeUpdate();
			
			//b4: log 
			System.out.println("đã thực thi " + sql);
			System.out.println("có " + cnt + " dòng được cập nhật");
			
			//b4: đóng connect
			JDBCUtil.closeConnection(con);
			} catch (SQLException e) { 
			e.printStackTrace();
		}
		return true;
	}
	}


