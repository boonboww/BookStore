package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.PhanLoai;
import model.Product;
import model.TacGia;

public class ProductDAO implements InterfaceDAO<Product> {
	private List<Product> data = new ArrayList<Product>();

	@Override
	public ArrayList<Product> selectAll() {
		ArrayList<Product> result = new ArrayList<Product>();
		try {
			// b1: tạo connect
			Connection con = JDBCUtil.getConnection();

			// b2: tạo object Preparement
			String sql = "SELECT * FROM sanpham";
			PreparedStatement ps = con.prepareStatement(sql);

			// b3: thực thi SQL
			System.out.println(sql);
			ResultSet rs = ps.executeQuery();

			// b4: get data
			while (rs.next()) {

				String ma_sanpham = rs.getString("ma_sanpham");
				String ten_sanpham = rs.getString("ten_sanpham");
				String ma_phanloai = rs.getString("ma_phanloai");
				double gia_nhap = rs.getDouble("gia_nhap");
				double gia_ban = rs.getDouble("gia_ban");
				int soluong = rs.getInt("soluong");
				String ma_tacgia = rs.getString("ma_tacgia");
				int namxuatban = rs.getInt("namxuatban");
				String nhaxuatban = rs.getString("nhaxuatban");

				TacGia tgX = new TacGiaDAO().selectById(new TacGia(ma_tacgia, null, null, 0));
				PhanLoai plX = new PhanLoaiDAO().selectById(new PhanLoai(ma_phanloai, null));

				result.add(new Product(ma_sanpham, ten_sanpham, plX.getMaPhanLoai(), gia_nhap, gia_ban, soluong,
						tgX.getMaTacGia(), namxuatban, nhaxuatban));
			}

			// b5: đóng connect
			JDBCUtil.closeConnection(con);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Product selectById(Product x) {
		Product result = null;
		try {
			// b1: tạo connect
			Connection con = JDBCUtil.getConnection();

			// b2: tạo object Preparement
			String sql = "SELECT * FROM sanpham WHERE ma_sanpham = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, x.getMaSanPham());
			
			// b3: thực thi SQL
			System.out.println(sql);
			ResultSet rs = ps.executeQuery();

			// b4: get data
			while (rs.next()) {

				String ma_sanpham = rs.getString("ma_sanpham");
				String ten_sanpham = rs.getString("ten_sanpham");
				String ma_phanloai = rs.getString("ma_phanloai");
				double gia_nhap = rs.getDouble("gia_nhap");
				double gia_ban = rs.getDouble("gia_ban");
				int soluong = rs.getInt("soluong");
				String ma_tacgia = rs.getString("ma_tacgia");
				int namxuatban = rs.getInt("namxuatban");
				String nhaxuatban = rs.getString("nhaxuatban");

				TacGia tgX = new TacGiaDAO().selectById(new TacGia(ma_tacgia, null, null, 0));
				PhanLoai plX = new PhanLoaiDAO().selectById(new PhanLoai(ma_phanloai, null));

				result = new Product(ma_sanpham, ten_sanpham, plX.getMaPhanLoai(), gia_nhap, gia_ban, soluong,
						tgX.getMaTacGia(), namxuatban, nhaxuatban);
			}

			// b5: đóng connect
			JDBCUtil.closeConnection(con);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int insert(Product x) {
		int cnt = 0;
		try {
			//b1: tạo connect 
			Connection con = JDBCUtil.getConnection();
			
			//b2: tạo object preparedStament
			String sql = "INSERT INTO sanpham(ma_sanpham,ten_sanpham,ma_phanloai,gia_nhap,gia_ban,soluong,ma_tacgia,namxuatban,nhaxuatban)"+
			"VALUES (?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, x.getMaSanPham());
			ps.setString(2, x.getTenSanPham());
			ps.setObject(3, x.getPhanLoai());
			ps.setDouble(4, x.getGiaNhap());
			ps.setDouble(5,	x.getGiaBan());
			ps.setInt(6, x.getSoLuong());
			ps.setObject(7, x.getTacGia());
			ps.setInt(8, x.getNXB());
			ps.setString(9,	x.getNhaXuatBan());
			
			//b3: thực thi sql
			cnt += ps.executeUpdate();
			
			//b4: log
			System.out.println(sql);
			System.out.println("có " + sql + " dòng được cập nhật");	
			
			//b5: đóng connect
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int insertAll(ArrayList<Product> list) {
		int cnt = 0;
		for (Product x : list) {
			if (insert(x) == 1) {
				cnt++;
			}
		

		}
		System.out.println("có " + cnt + " dòng được cập nhật");
		return cnt;
	}

	@Override
	public boolean delete(Product x) {
		int cnt = 0;
		try {
			//b1: create connect
			Connection con = JDBCUtil.getConnection();
			
			//b2: create Object PreparedStament
			String sql = "DELETE FROM sanpham WHERE ma_sanpham=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, x.getMaSanPham());
			
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
			String sql = "DELETE FROM sanpham";
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
	public boolean update(Product x) {
		int cnt = 0;
		try {
			//b1: Create connect
			Connection con = JDBCUtil.getConnection();
			
			//b2: Create Object PreparedStament
			String sql = "UPDATE sanpham SET ten_sanpham=?,ma_phanloai=?,gia_nhap=?,gia_ban=?,soluong=?,ma_tacgia=?,namxuatban=?,nhaxuatban=?" +
			" WHERE ma_sanpham=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, x.getTenSanPham());
			ps.setString(2, x.getPhanLoai());
			ps.setDouble(3, x.getGiaNhap());
			ps.setDouble(4, x.getGiaBan());
			ps.setInt(5, x.getSoLuong());
			ps.setString(6, x.getTacGia());
			ps.setInt(7, x.getNXB());
			ps.setString(8, x.getNhaXuatBan());
			ps.setString(9, x.getMaSanPham());
			
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
