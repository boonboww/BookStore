package model;

import java.sql.Date;
import java.util.Objects;

public class Customer {
	private String maKhachHang;
	private String taiKhoan;
	private String matKhau;
	private String tenKhachHang;
	private String gioiTinh;
	private Date ngaySinh;
	private String soDienThoai;
	private String email;
	private String diaChi;
	private String diaChiNhanHang;
	private String diaChiMuaHang;
	private String maOTP;
	private Date timeOutOTP;
	private boolean trangThaiXacThuc;
	
	public Customer() {
	}
	 
	public Customer(String maKhachHang, String taiKhoan, String matKhau, String tenKhachHang, String gioiTinh,
			Date ngaySinh, String soDienThoai, String email, String diaChi, String diaChiNhanHang, String diaChiMuaHang) {
		this.maKhachHang = maKhachHang;
		this.taiKhoan = taiKhoan;
		this.matKhau = matKhau;
		this.tenKhachHang = tenKhachHang;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.diaChi = diaChi;
		this.diaChiNhanHang = diaChiNhanHang;
		this.diaChiMuaHang = diaChiMuaHang;
	}

	
	
	public Customer(String maKhachHang, String taiKhoan, String matKhau, String tenKhachHang, String gioiTinh,
			Date ngaySinh, String soDienThoai, String email, String diaChi, String diaChiNhanHang, String diaChiMuaHang,
			String maOTP, Date timeOutOTP, boolean trangThaiXacThuc) {
		this.maKhachHang = maKhachHang;
		this.taiKhoan = taiKhoan;
		this.matKhau = matKhau;
		this.tenKhachHang = tenKhachHang;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.diaChi = diaChi;
		this.diaChiNhanHang = diaChiNhanHang;
		this.diaChiMuaHang = diaChiMuaHang;
		this.maOTP = maOTP;
		this.timeOutOTP = timeOutOTP;
		this.trangThaiXacThuc = trangThaiXacThuc;
	}

	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getDiaChiNhanHang() {
		return diaChiNhanHang;
	}

	public void setDiaChiNhanHang(String diaChiNhanHang) {
		this.diaChiNhanHang = diaChiNhanHang;
	}

	public String getDiaChiMuaHang() {
		return diaChiMuaHang;
	}

	public void setDiaChiMuaHang(String diaChiMuaHang) {
		this.diaChiMuaHang = diaChiMuaHang;
	}

	
	
	

	public String getMaOTP() {
		return maOTP;
	}

	public void setMaOTP(String maOTP) {
		this.maOTP = maOTP;
	}

	public Date getTimeOutOTP() {
		return timeOutOTP;
	}

	public void setTimeOutOTP(Date timeOutOTP) {
		this.timeOutOTP = timeOutOTP;
	}

	public boolean isTrangThaiXacThuc() {
		return trangThaiXacThuc;
	}

	public void setTrangThaiXacThuc(boolean trangThaiXacThuc) {
		this.trangThaiXacThuc = trangThaiXacThuc;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(maKhachHang, other.maKhachHang);
	}
	@Override
	public int hashCode() {
		return Objects.hash(maKhachHang);
	}
	
	
	
}
