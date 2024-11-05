package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Customer;
import model.PhanLoai;

public class PhanLoaiDAO implements InterfaceDAO<PhanLoai> {

	@Override
	public ArrayList<PhanLoai> selectAll() {
		ArrayList<PhanLoai> result = new ArrayList<PhanLoai>();
		try {
			// b1: tạo connect
			Connection con = JDBCUtil.getConnection();

			// b2: tạo object Preparement
			String sql = "SELECT * FROM phanloai";
			PreparedStatement ps = con.prepareStatement(sql);

			// b3: thực thi SQL
			System.out.println(sql);
			ResultSet rs = ps.executeQuery();

			// b4: get data
			while (rs.next()) {
				String ma_phanloai = rs.getString("ma_phanloai");
				String ten_phanloai = rs.getString("ten_phanloai");
				
				PhanLoai x = new PhanLoai(ma_phanloai, ten_phanloai);
				result.add(x);
			}
			

			// b5: đóng connect
			JDBCUtil.closeConnection(con);

		 } catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public PhanLoai selectById(PhanLoai x) {
		PhanLoai result = null;
		try {
			//b1: tạo connect 
			Connection con = JDBCUtil.getConnection();
			
			//b2: tạo object Preparement 
			String sql = "SELECT * FROM phanloai WHERE ma_phanloai=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, x.getMaPhanLoai());
			
			//b3: thực thi SQL 
			System.out.println(sql);
			ResultSet rs =  ps.executeQuery();
			
			//b4: get data 
			while(rs.next()) {
				String maPhanLoai = rs.getString("ma_phanloai");
				String tenPhanLoai = rs.getString("ten_phanloai");
				
				
				result = new PhanLoai(maPhanLoai, tenPhanLoai);
				
				
			}
			
			//b5: đóng connect
			JDBCUtil.closeConnection(con);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int insert(PhanLoai x) {
		int cnt = 0;
		try {
			//b1 : create connect
			Connection con = JDBCUtil.getConnection();
			
			//b2: create Object PrepareStament 
			String sql = "INSERT INTO phanloai(ma_phanloai,ten_phanloai)" +
			 "VALUES(?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, x.getMaPhanLoai());
			ps.setString(2, x.getTenPhanLoai());
		
			
			
			//b3: execute SQL
			cnt += ps.executeUpdate();
			
			//b4: log 
			System.out.println("đã thực thi " + sql);
			System.out.println("có " + cnt + " dòng được cập nhât");
			
			
			//b5: close connect
			JDBCUtil.closeConnection(con);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int insertAll(ArrayList<PhanLoai> list) {
		int cnt = 0;
		for (PhanLoai x : list) {
			cnt += insert(x);
			
		}System.out.println("có " + cnt + " dòng được cập nhật");
		return cnt;
	}

	@Override
	public boolean delete(PhanLoai x) {
		int cnt = 0;
		try {
			//b1: create connect
			Connection con = JDBCUtil.getConnection();
			
			//b2: create Object PrepareStament
			String sql = "DELETE FROM khachhang WHERE ma_phanloai=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1 , x.getMaPhanLoai());
			
			
			//b3: thực thi SQL
			
			cnt += ps.executeUpdate();
			
			//b4: log
			System.out.println("đã thực thi" + sql);
			System.out.println("có " + cnt + " dòng được cập nhật");
		} catch (Exception e) {
			e.printStackTrace();
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
			String sql = "DELETE FROM phanloai";
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
	public boolean update(PhanLoai x) {
		int cnt = 0;
		try {
			//b1: tạo connect 
			Connection con = JDBCUtil.getConnection();
			
			//b2: tạo object PreparedStament
			String sql = "UPDATE tacgia SET ten_phanloai=?" +
			" WHERE ma_phanloai=?";
			
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, x.getTenPhanLoai());
			ps.setString(2, x.getMaPhanLoai());
			
			
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
