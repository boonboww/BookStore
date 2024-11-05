package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Customer;


public class CustomerDAO implements InterfaceDAO<Customer>{
	private List<Customer> data = new ArrayList<Customer>();

	@Override
	public ArrayList<Customer> selectAll() {
		ArrayList<Customer> result = new ArrayList<Customer>();
		try {
			//b1: tạo connect 
			Connection con = JDBCUtil.getConnection();
			
			//b2: tạo object Preparement 
			String sql = "SELECT * FROM khachhang";
			PreparedStatement ps = con.prepareStatement(sql);
			
			//b3: thực thi SQL 
			System.out.println(sql);
			ResultSet rs =  ps.executeQuery();
			
			//b4: get data 
			while(rs.next()) {
				String maKhachHang = rs.getString("ma_khachhang");
				String taikhoan = rs.getString("taikhoan");
				String matkhau = rs.getString("matkhau");
				String ten_khachhang = rs.getString("ten_khachhang");
				String gioitinh = rs.getString("gioitinh");
				Date ngaysinh = rs.getDate("ngaysinh");
				String phonenumber = rs.getString("phonenumber");
				String email = rs.getString("email");
				String diachi = rs.getString("diachi");
				String diachi_nhanhang = rs.getString("diachi_nhanhang");
				String diachi_muahang = rs.getString("diachi_muahang");
				
				Customer x = new Customer(maKhachHang, taikhoan, matkhau, ten_khachhang, gioitinh, ngaysinh,phonenumber, email, diachi_muahang, diachi, diachi);
				result.add(x);
				
			}
			
			//b5: đóng connect
			JDBCUtil.closeConnection(con);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public Customer selectById(Customer x) {
		Customer result = null;
		try {
			//b1: tạo connect 
			Connection con = JDBCUtil.getConnection();
			
			//b2: tạo object Preparement 
			String sql = "SELECT * FROM khachhang WHERE ma_khachhang=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, x.getMaKhachHang());
			
			//b3: thực thi SQL 
			System.out.println(sql);
			ResultSet rs =  ps.executeQuery();
			
			//b4: get data 
			while(rs.next()) {
				String maKhachHang = rs.getString("ma_khachhang");
				String taikhoan = rs.getString("taikhoan");
				String matkhau = rs.getString("matkhau");
				String ten_khachhang = rs.getString("ten_khachhang");
				String gioitinh = rs.getString("gioitinh");
				Date ngaysinh = rs.getDate("ngaysinh");
				String phonenumber = rs.getString("phonenumber");
				String email = rs.getString("email");
				String diachi = rs.getString("diachi");
				String diachi_nhanhang = rs.getString("diachi_nhanhang");
				String diachi_muahang = rs.getString("diachi_muahang");
				String maOTP = rs.getNString("maOTP");
				Date timeOutOTP = rs.getDate("timeOutOTP");
				Boolean trangThaiXacThuc = rs.getBoolean("trangThaiXacThuc");
				result = new Customer(maKhachHang, taikhoan, matkhau, ten_khachhang, gioitinh, ngaysinh, phonenumber, email, diachi_muahang, diachi, diachi,maOTP,timeOutOTP,trangThaiXacThuc);
				
				
			}
			
			//b5: đóng connect
			JDBCUtil.closeConnection(con);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int insert(Customer x) {
		int cnt = 0;
		try {
			//b1 : create connect
			Connection con = JDBCUtil.getConnection();
			
			//b2: create Object PrepareStament 
			String sql = "INSERT INTO khachhang(ma_khachhang, taikhoan, matkhau, ten_khachhang, gioitinh, ngaysinh, phonenumber, email, diachi, diachi_nhanhang, diachi_muahang,maOTP,timeOutOTP,trangThaiXacThuc)" +
			 "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, x.getMaKhachHang());
			ps.setString(2, x.getTaiKhoan());
			ps.setString(3, x.getMatKhau());
			ps.setString(4, x.getTenKhachHang());
			ps.setString(5, x.getGioiTinh());
			ps.setDate(6, x.getNgaySinh());
			ps.setString(7, x.getSoDienThoai());
			ps.setString(8, x.getEmail());
			ps.setString(9, x.getDiaChi());
			ps.setString(10, x.getDiaChiNhanHang());
			ps.setString(11, x.getDiaChiMuaHang());
			ps.setString(12, x.getMaOTP());
			ps.setDate(13, x.getTimeOutOTP());
			ps.setBoolean(14, x.isTrangThaiXacThuc());
			
			
			
			//b3: execute SQL
			cnt += ps.executeUpdate();
			
			//b4: log 
			System.out.println("đã thực thi " + sql);
			System.out.println("có " + cnt + " dòng được cập nhât");
			
			
			//b5: close connect
			JDBCUtil.closeConnection(con);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return cnt;
	}

	@Override
	public int insertAll(ArrayList<Customer> list) {
		int cnt = 0;
		for (Customer x : list) {
			cnt += insert(x);
		}
		System.out.println("có " + cnt + " dòng được thực thi");
		return cnt;
	}

	@Override
	public boolean delete(Customer x) {
		int cnt = 0;
		try {
			//b1: create connect
			Connection con = JDBCUtil.getConnection();
			
			//b2: create Object PrepareStament
			String sql = "DELETE FROM khachhang WHERE ma_khachhang=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1 , x.getMaKhachHang());
			
			
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
			String sql = "DELETE FROM khachhang";
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
	public boolean update(Customer x) {
		int cnt = 0;
		try {
			//b1: tạo connect 
			Connection con = JDBCUtil.getConnection();
			
			//b2: tạo object PreparedStament
			String sql = "UPDATE khachhang SET taikhoan=?,matkhau=?,ten_khachhang=?,gioitinh=?,ngaysinh=?,phonenumber=?,email=?,diachi=?,diachi_nhanhang=?,diachi_muahang=?" +
			" WHERE ma_khachhang=?";
			
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, x.getTaiKhoan());
			ps.setString(2, x.getMatKhau());
			ps.setString(3, x.getTenKhachHang());
			ps.setString(4, x.getGioiTinh());
			ps.setDate(5, x.getNgaySinh());
			ps.setString(6, x.getSoDienThoai());
			ps.setString(7, x.getEmail());
			ps.setString(8, x.getDiaChi());
			ps.setString(9, x.getDiaChiNhanHang());
			ps.setString(10, x.getDiaChiMuaHang());
			ps.setString(11, x.getMaKhachHang());
			
			
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
	
	public boolean updateXacThucThongTin(Customer x) {
		int cnt = 0;
		try {
			//b1: tạo connect 
			Connection con = JDBCUtil.getConnection();
			
			//b2: tạo object PreparedStament
			String sql = "UPDATE khachhang SET maOTP=?,timeOutOTP=?,trangThaiXacThuc=?" +
			" WHERE ma_khachhang=?";
			
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, x.getMaOTP());
			ps.setDate(2, x.getTimeOutOTP());
			ps.setBoolean(3, x.isTrangThaiXacThuc());
			ps.setString(4, x.getMaKhachHang());
			
			
			
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
	
	public boolean updateTrangThaiXacThuc(Customer x) {
		int cnt = 0;
		try {
			//b1: tạo connect 
			Connection con = JDBCUtil.getConnection();
			
			//b2: tạo object PreparedStament
			String sql = "UPDATE khachhang SET trangThaiXacThuc=?" +
			" WHERE ma_khachhang=?";
			
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setBoolean(1, x.isTrangThaiXacThuc());
			ps.setString(2, x.getMaKhachHang());
			
			
			
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
	
	
	public boolean checkTenTaiKhoan(String tenTaiKhoan) {
		boolean result = false;
		try {
			//b1: tạo connect
			Connection con = JDBCUtil.getConnection();
			
			
			//b2: tạo object PreparedStament để giao tiếp với lệnh SQL
			String sql = "SELECT * FROM khachhang WHERE taikhoan=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, tenTaiKhoan);
			
			
			//b3: thực thi SQL
			System.out.println(sql);
			ResultSet rs = ps.executeQuery();
			
			//b4: check taikhoan đã tồn tại hay chưa 
			while(rs.next()) {
				result = true;
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public Customer selectByName(String tenTaiKhoan) {
		Customer cs = null;
		try {
			//b1: tạo connect
			Connection con = JDBCUtil.getConnection();
			
			
			//b2: tạo object PreparedStament để giao tiếp với lệnh SQL
			String sql = "SELECT * FROM khachhang WHERE taikhoan=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, tenTaiKhoan);
			
			
			//b3: thực thi SQL
			System.out.println(sql);
			ResultSet rs = ps.executeQuery();
			
			//b4: check taikhoan đã tồn tại hay chưa 
			while(rs.next()) {
				String maKhachHang = rs.getString("ma_khachhang");
				String taikhoan = rs.getString("taikhoan");
				String matkhau = rs.getString("matkhau");
				String ten_khachhang = rs.getString("ten_khachhang");
				String gioitinh = rs.getString("gioitinh");
				Date ngaysinh = rs.getDate("ngaysinh");
				String phonenumber = rs.getString("phonenumber");
				String email = rs.getString("email");
				String diachi = rs.getString("diachi");
				String diachi_nhanhang = rs.getString("diachi_nhanhang");
				String diachi_muahang = rs.getString("diachi_muahang");
				String maOTP = rs.getString("maOTP");
				Date timeOutOTP = rs.getDate("timeOutOTP");
				Boolean trangThaiXacThuc = rs.getBoolean("trangThaiXacThuc");
				
				
				cs = new Customer(maKhachHang, taikhoan, matkhau, ten_khachhang, gioitinh, ngaysinh, diachi_nhanhang, email, diachi_muahang, diachi, diachi, maOTP, timeOutOTP, trangThaiXacThuc);
				
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cs;
	}
	
	
	public boolean chagePassword(Customer x, String newPass) {
		int cnt = 0;
		try {
			//b1: tạo connect 
			Connection con = JDBCUtil.getConnection();
			
			//b2: tạo object PreparedStament
			String sql = "UPDATE khachhang SET matkhau=?" +
			" WHERE ma_khachhang=?";
			
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, newPass);
			ps.setString(2, x.getMaKhachHang());
			
			
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
	
	
	public boolean updateInfoUser(Customer x) {
		int cnt = 0;
		try {
			//b1: tạo connect 
			Connection con = JDBCUtil.getConnection();
			
			//b2: tạo object PreparedStament
			String sql = "UPDATE khachhang SET taikhoan=?,ten_khachhang=?,gioitinh=?,ngaysinh=?,phonenumber=?,email=?,diachi=?,diachi_nhanhang=?,diachi_muahang=?" +
			" WHERE ma_khachhang=?";
			
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, x.getTaiKhoan());
			ps.setString(2, x.getTenKhachHang());
			ps.setString(3, x.getGioiTinh());
			ps.setDate(4, x.getNgaySinh());
			ps.setString(5, x.getSoDienThoai());
			ps.setString(6, x.getEmail());
			ps.setString(7, x.getDiaChi());
			ps.setString(8, x.getDiaChiNhanHang());
			ps.setString(9, x.getDiaChiMuaHang());
			ps.setString(10, x.getMaKhachHang());
			
			System.out.println("Thực thi sql");
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
	
	
	
	
	
	// test
	/*
	 * public static void main(String[] args) { CustomerDAO csd = new CustomerDAO();
	 * Customer cs = new Customer("KH01", "PhuKun", "", "tranthienphu", null, null,
	 * null, null, null, null, null); if(csd.updateInfoUser(cs)) {
	 * System.out.println("Success");
	 * 
	 * }else { System.out.println("error"); }
	 * 
	 * }
	 */
	
	}
	

