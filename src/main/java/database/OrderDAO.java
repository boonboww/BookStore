package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Order;

public class OrderDAO implements InterfaceDAO<Order> {
	

	@Override
	public ArrayList<Order> selectAll() {
		ArrayList<Order> result = new ArrayList<Order>();
		try {
			//b1: create connect
			Connection con = JDBCUtil.getConnection();
			
			//b2: create Object PreparedStament
			String sql = "SELECT * FROM donhang";
			PreparedStatement ps = con.prepareStatement(sql);
			
			//b3: execute SQL
			System.out.println(sql);
			ResultSet rs = ps.executeQuery();
			
			//b4: get data in DB
			while(rs.next()) {
				String ma_donhang = rs.getString("ma_donhang");
				String ten_donhang = rs.getString("ten_donhang");
				String diachi_nguoimua = rs.getString("diachi_nguoimua");
				String diachi_nguoinhan = rs.getString("diachi_nguoinhan");
				String trangthai = rs.getString("trangthai");
				String hinhthuc_thanhtoan = rs.getString("hinhthuc_thanhtoan");
				String trangthai_thanhtoan = rs.getString("trangthai_thanhtoan");
				double sotien_thanhtoan = rs.getDouble("sotien_thanhtoan");
				Date ngay_dathang = rs.getDate("ngay_dathang");
				Date ngay_giaohang = rs.getDate("ngay_giaohang");
				
				Order ox = new Order(ma_donhang, ten_donhang, hinhthuc_thanhtoan, diachi_nguoinhan, trangthai_thanhtoan, trangthai_thanhtoan, trangthai, sotien_thanhtoan, ngay_dathang, ngay_giaohang);
				result.add(ox);
			}
			
			//b5: close connect
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Order selectById(Order x) {
		Order ox = null;
		try {
			//b1: create connect
			Connection con = JDBCUtil.getConnection();
			
			//b2: create Object PreparedStament
			String sql = "SELECT * FROM donhang WHERE ma_donhang =?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, x.getMaDonHang());
			
			//b3: execute SQL
			System.out.println(sql);
			ResultSet rs = ps.executeQuery();
			
			//b4: get data in DB
			while(rs.next()) {
				String ma_donhang = rs.getString("ma_donhang");
				String ten_donhang = rs.getString("ten_donhang");
				String diachi_nguoimua = rs.getString("diachi_nguoimua");
				String diachi_nguoinhan = rs.getString("diachi_nguoinhan");
				String trangthai = rs.getString("trangthai");
				String hinhthuc_thanhtoan = rs.getString("hinhthuc_thanhtoan");
				String trangthai_thanhtoan = rs.getString("trangthai_thanhtoan");
				double sotien_thanhtoan = rs.getDouble("sotien_thanhtoan");
				Date ngay_dathang = rs.getDate("ngay_dathang");
				Date ngay_giaohang = rs.getDate("ngay_giaohang");
				
				ox = new Order(ma_donhang, ten_donhang, hinhthuc_thanhtoan, diachi_nguoinhan, trangthai_thanhtoan, trangthai_thanhtoan, trangthai, sotien_thanhtoan, ngay_dathang, ngay_giaohang);
				
			}
			
			//b5: close connect
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ox;
	}

	@Override
	public int insert(Order x) {
		int cnt = 0;
		try {
			//b1: create connect 
			Connection con = JDBCUtil.getConnection();
			
			
			//b2: create Object PreparedStament 
			String sql = "INSERT INTO donhang(ma_donhang,ten_donhang,diachi_nguoimua,diachi_nguoinhan,trangthai,hinhthuc_thanhtoan,trangthai_thanhtoan,sotien_thanhtoan,ngay_dathang,ngay_giaohang)" +
			"VALUES (?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, x.getMaDonHang());
			ps.setString(2, x.getTenDonHang());
			ps.setString(3, x.getDiaChiNguoiMua());
			ps.setString(4, x.getDiaChiNguoiNhan());
			ps.setString(5, x.getTrangThai());
			ps.setString(6, x.getHinhThucThanhToan());
			ps.setString(7, x.getTrangThaiThanhToan());
			ps.setDouble(8, x.getSoTienThanhToan());
			ps.setDate(9, x.getNgayDatHang());
			ps.setDate(10, x.getNgayGiaoHang());
			
			//b3: execute SQL
			cnt += ps.executeUpdate();
			
			//b4: log 
			System.out.println(sql);
			System.out.println("có "+cnt+" dòng được cập nhật");
			
			
			//b5: close connect
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int insertAll(ArrayList<Order> list) {
		int cnt = 0;
		for (Order x : list) {
			if (insert(x)== 1) {
				cnt++;
			}

		}
		System.out.println("có " + cnt + " dòng được cập nhật");
		return cnt;
	}

	@Override
	public boolean delete(Order x) {
		int cnt = 0;
		try {
			//b1: create connect
			Connection con = JDBCUtil.getConnection();
			
			//b2: create Object PreparedStament
			String sql = "DELETE FROM donhang WHERE ma_donhang=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, x.getMaDonHang());
			
			//b3: execute SQL
			cnt += ps.executeUpdate();
			
			
			//b4: log
			System.out.println(sql);
			System.out.println("có " + cnt +  " dòng được cập nhật");
			
			//b5: close connect
			JDBCUtil.closeConnection(con);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean deleteAll() {
		int cnt = 0;
		try {
			//b1: create connect
			Connection con = JDBCUtil.getConnection();
			
			//b2: create Object PreparedStament
			String sql = "DELETE FROM donhang";
			PreparedStatement ps = con.prepareStatement(sql);
			
			
			//b3: execute SQL
			cnt += ps.executeUpdate();
			
			
			//b4: log
			System.out.println(sql);
			System.out.println("có " + cnt +  " dòng được cập nhật");
			
			//b5: close connect
			JDBCUtil.closeConnection(con);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean update(Order x) {
		int cnt = 0;
		try {
			//b1: Create connect
			Connection con = JDBCUtil.getConnection();
			
			//b2: Create Object PreparedStament
			String sql = "UPDATE donhang SET ten_donhang=?,diachi_nguoimua=?,diachi_nguoinhan=?,trangthai=?,hinhthuc_thanhtoan=?,trangthai_thanhtoan=?,sotien_thanhtoan=?,ngay_dathang=?,ngay_giaohang=?" +
			" WHERE ma_donhang=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, x.getTenDonHang());
			ps.setString(2, x.getDiaChiNguoiMua());
			ps.setString(3, x.getDiaChiNguoiNhan());
			ps.setString(4, x.getTrangThai());
			ps.setString(5, x.getHinhThucThanhToan());
			ps.setString(6, x.getTrangThaiThanhToan());
			ps.setDouble(7, x.getSoTienThanhToan());
			ps.setDate(8, x.getNgayDatHang());
			ps.setDate(9, x.getNgayGiaoHang());
			ps.setString(10, x.getMaDonHang());
			
			//b3: execute SQL
			cnt += ps.executeUpdate();
			
			//b4: log
			System.out.println(sql);
			System.out.println("có " + cnt + " dòng được thực thi");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

}
