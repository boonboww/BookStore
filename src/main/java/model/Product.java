package model;

import java.util.Objects;

public class Product {
	private String maSanPham;
	private String tenSanPham;
	private String ma_phanLoai;
	private double giaNhap;
	private double giaBan;
	private int soLuong;
	private String ma_tacGia;
	private int NXB;
	private String nhaXuatBan;
	
	public Product() {

	}

	public Product(String maSanPham, String tenSanPham, String phanLoai, double giaNhap, double giaBan, int soLuong,
			String tacGia, int nXB, String nhaXuatBan) {
		
		this.maSanPham = maSanPham;
		this.tenSanPham = tenSanPham;
		this.ma_phanLoai = phanLoai;
		this.giaNhap = giaNhap;
		this.giaBan = giaBan;
		this.soLuong = soLuong;
		this.ma_tacGia = tacGia;
		NXB = nXB;
		this.nhaXuatBan = nhaXuatBan;
	}

	public String getMaSanPham() {
		return maSanPham;
	}

	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public String getPhanLoai() {
		return ma_phanLoai;
	}

	public void setPhanLoai(String phanLoai) {
		this.ma_phanLoai = phanLoai;
	}

	public double getGiaNhap() {
		return giaNhap;
	}

	public void setGiaNhap(double giaNhap) {
		this.giaNhap = giaNhap;
	}

	public double getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getTacGia() {
		return ma_tacGia;
	}

	public void setTacGia(String tacGia) {
		this.ma_tacGia = tacGia;
	}

	public int getNXB() {
		return NXB;
	}

	public void setNXB(int nXB) {
		NXB = nXB;
	}

	public String getNhaXuatBan() {
		return nhaXuatBan;
	}

	public void setNhaXuatBan(String nhaXuatBan) {
		this.nhaXuatBan = nhaXuatBan;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maSanPham);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(maSanPham, other.maSanPham);
	}

	@Override
	public String toString() {
		return "Product [maSanPham=" + maSanPham + ", tenSanPham=" + tenSanPham + ", phanLoai=" + ma_phanLoai
				+ ", giaNhap=" + giaNhap + ", giaBan=" + giaBan + ", soLuong=" + soLuong + ", tacGia=" + ma_tacGia
				+ ", NXB=" + NXB + ", nhaXuatBan=" + nhaXuatBan + "]";
	}
	

	
	
	
}
