package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Customer;
import model.Order;
import model.OrderDetails;
import model.PhanLoai;
import model.Product;


public class OrderDetailsDAO implements InterfaceDAO<OrderDetails>{
	

	@Override
	public ArrayList<OrderDetails> selectAll() {
		ArrayList<OrderDetails> result = new ArrayList<OrderDetails>();
		try {
			//b1: create Connect
			Connection con = JDBCUtil.getConnection();
			
			//b2: create Object PreparedStament
			String sql = "SELECT * FROM chitietdonhang";
			PreparedStatement ps = con.prepareStatement(sql);
			
			
			//b3: execute SQL
			System.out.println(sql);
			ResultSet rs = ps.executeQuery();
			
			
			//b4: get data in SQL
			String ma_chitietdonhang = rs.getString("ma_chitietdonhang");
			String ma_donhang = rs.getString("ma_donhang");
			String ma_sanpham = rs.getString("ma_sanpham");
			String ma_khachhang = rs.getString("ma_khachhang");
			int soluong = rs.getInt("soluong");
			double gia_ban = rs.getDouble("gia_ban");
			double giam_gia = rs.getDouble("giam_gia");
			double thue_vat = rs.getDouble("thue_vat");
			double thanhtien = rs.getDouble("thanhtien");
			
			Order ox = new OrderDAO().selectById(new Order(ma_donhang, ma_donhang, sql, ma_chitietdonhang, ma_donhang, ma_sanpham, ma_khachhang, thanhtien, null, null));
			Product px = new ProductDAO().selectById(new Product(ma_sanpham, ma_sanpham, ma_donhang, thue_vat, thanhtien, soluong, ma_sanpham, soluong, ma_khachhang));
			Customer cx = new CustomerDAO().selectById(new Customer(ma_khachhang, ma_khachhang, ma_khachhang, ma_khachhang, ma_khachhang, null, sql, ma_chitietdonhang, ma_donhang, ma_sanpham, ma_khachhang));

			OrderDetails odx = new OrderDetails(ma_chitietdonhang, ox.getMaDonHang(), px.getMaSanPham(),cx.getMaKhachHang(), soluong, giam_gia, thue_vat, soluong, thanhtien);
			result.add(odx);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public OrderDetails selectById(OrderDetails x) {
		OrderDetails result = null;
		try {
			//b1: tạo connect 
			Connection con = JDBCUtil.getConnection();
			
			//b2: tạo object Preparement 
			String sql = "SELECT * FROM chitietdonhang WHERE ma_chitietdonhang=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, x.getMaChitietDonHang());
			
			//b3: thực thi SQL 
			System.out.println(sql);
			ResultSet rs =  ps.executeQuery();
			
			//b4: get data 
			while(rs.next()) {
				String ma_chitietdonhang = rs.getString("ma_chitietdonhang");
				String ma_donhang = rs.getString("ma_donhang");
				String ma_sanpham = rs.getString("ma_sanpham");
				String ma_khachhang = rs.getString("ma_khachhang");
				int soluong = rs.getInt("soluong");
				double gia_ban = rs.getDouble("gia_ban");
				double giam_gia = rs.getDouble("giam_gia");
				double thue_vat = rs.getDouble("thue_vat");
				double thanhtien = rs.getDouble("thanhtien");
				Order ox = new OrderDAO().selectById(new Order(ma_donhang, ma_donhang, sql, ma_chitietdonhang, ma_donhang, ma_sanpham, ma_khachhang, thanhtien, null, null));
				Product px = new ProductDAO().selectById(new Product(ma_sanpham, ma_sanpham, ma_donhang, thue_vat, thanhtien, soluong, ma_sanpham, soluong, ma_khachhang));
				Customer cx = new CustomerDAO().selectById(new Customer(ma_khachhang, ma_khachhang, ma_khachhang, ma_khachhang, ma_khachhang, null, sql, ma_chitietdonhang, ma_donhang, ma_sanpham, ma_khachhang));
				result = new OrderDetails(ma_chitietdonhang, ox.getMaDonHang(), px.getMaSanPham(),cx.getMaKhachHang() , soluong, giam_gia, thue_vat, soluong, thanhtien);
				
			}
			
			//b5: đóng connect
			JDBCUtil.closeConnection(con);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int insert(OrderDetails x) {
		int cnt = 0;
		try {
			//b1 : create connect
			Connection con = JDBCUtil.getConnection();
			
			//b2: create Object PrepareStament 
			String sql = "INSERT INTO chitietdonhang(ma_chitietdonhang,ma_donhang,ma_sanpham,ma_khachhang,soluong,gia_ban,giam_gia,thue_vat,thanhtien)" +
			 "VALUES(?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, x.getMaChitietDonHang());
			ps.setString(2, x.getMaDonHang());
			ps.setString(3, x.getMaSanPham());
			ps.setString(4, x.getMaKhachHang());
			ps.setInt(5, x.getSoLuong());
			ps.setDouble(6, x.getGiaBan());
			ps.setDouble(7, x.getGiamGia());
			ps.setDouble(8, x.getVat());
			ps.setDouble(9, x.getThanhTien());
			
			//b3: execute SQL
			cnt += ps.executeUpdate();
			
			//b4: log 
			System.out.println("đã thực thi " + sql);
			System.out.println("có " + cnt + " dòng được cập nhât");
			
			
			//b5: close connect
			JDBCUtil.closeConnection(con);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int insertAll(ArrayList<OrderDetails> list) {
		int cnt = 0;
		for (OrderDetails x : list) {
			cnt += insert(x);
			
		}System.out.println("có " + cnt + " dòng được cập nhật");
		return cnt;
	}

	@Override
	public boolean delete(OrderDetails x) {
		int cnt = 0;
		try {
			//b1: create connect
			Connection con = JDBCUtil.getConnection();
			
			//b2: create Object PrepareStament
			String sql = "DELETE FROM chitietdonhang WHERE ma_chitietdonhang=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1 , x.getMaChitietDonHang());
			
			
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
			String sql = "DELETE FROM chitietdonhang";
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
	
	
	
//	public int deleteByOrder(Order x) {
//		try {
//			//b1: tạo connect
//			Connection con = JDBCUtil.getConnection();
//			
//			
//			//b2: tạo Object PreparedStament
//			String sql = "DELETE FROM chitietdonhang WHERE ma_chitietdonhang=?";
//			PreparedStatement ps = con.prepareStatement(sql);
//			
//			ps.setString(1, x.get());
//			
//			
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		
//		
////		int cnt = 0 ;
////		for (OrderDetails xxx : data) {
////			if(xxx.getDonHang().equals(x)) {
////				this.data.remove(xxx);
////				cnt++;
////			}
////
////		}
////		return cnt;
//	}

	@Override
	public boolean update(OrderDetails x) {
		int cnt = 0;
		try {
			//b1: tạo connect 
			Connection con = JDBCUtil.getConnection();
			
			//b2: tạo object PreparedStament
			String sql = "UPDATE tacgia SET ma_chitietdonhang=?,ma_donhang=?,ma_sanpham=?,ma_khachhang=?,soluong=?,gia_ban=?,giam_gia=?,thue_vat=?,thanhtien=?" +
			" WHERE ma_chitietdonhang=?";
			
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, x.getMaDonHang());
			ps.setString(2, x.getMaSanPham());
			ps.setString(3, x.getMaKhachHang());
			ps.setInt(4, x.getSoLuong());
			ps.setDouble(5, x.getGiaBan());
			ps.setDouble(6, x.getGiamGia());
			ps.setDouble(7, x.getVat());
			ps.setDouble(8, x.getThanhTien());
			ps.setString(9, x.getMaChitietDonHang());
			
			
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
