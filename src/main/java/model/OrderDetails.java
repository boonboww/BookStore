package model;

public class OrderDetails {
	private String maChitietDonHang;
	private String maDonHang;
	private String maSanPham;
	private String maKhachHang;
	private int soLuong;
	private double giaBan;
	private double giamGia;
	private int vat;
	private double thanhTien;
	public OrderDetails() {
	}
	
	public OrderDetails(String maChitietDonHang, String maDonHang, String maSanPham, String maKhachHang, int soLuong,
			double giaBan, double giamGia, int vat, double thanhTien) {
		this.maChitietDonHang = maChitietDonHang;
		this.maDonHang = maDonHang;
		this.maSanPham = maSanPham;
		this.maKhachHang = maKhachHang;
		this.soLuong = soLuong;
		this.giaBan = giaBan;
		this.giamGia = giamGia;
		this.vat = vat;
		this.thanhTien = thanhTien;
	}

	public String getMaChitietDonHang() {
		return maChitietDonHang;
	}

	public void setMaChitietDonHang(String maChitietDonHang) {
		this.maChitietDonHang = maChitietDonHang;
	}

	public String getMaDonHang() {
		return maDonHang;
	}

	public void setMaDonHang(String maDonHang) {
		this.maDonHang = maDonHang;
	}

	public String getMaSanPham() {
		return maSanPham;
	}

	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}

	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}

	public double getGiamGia() {
		return giamGia;
	}

	public void setGiamGia(double giamGia) {
		this.giamGia = giamGia;
	}

	public int getVat() {
		return vat;
	}

	public void setVat(int vat) {
		this.vat = vat;
	}

	public double getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(double thanhTien) {
		this.thanhTien = thanhTien;
	}

	@Override
	public String toString() {
		return "OrderDetails [maChitietDonHang=" + maChitietDonHang + ", maDonHang=" + maDonHang + ", maSanPham="
				+ maSanPham + ", maKhachHang=" + maKhachHang + ", soLuong=" + soLuong + ", giaBan=" + giaBan
				+ ", giamGia=" + giamGia + ", vat=" + vat + ", thanhTien=" + thanhTien + "]";
	}

	
	
	
	
}
