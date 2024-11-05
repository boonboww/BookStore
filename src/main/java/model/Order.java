package model;

import java.sql.Date;

public class Order {
	private String maDonHang;
	private String tenDonHang;
	private String diaChiNguoiMua;
	private String diaChiNguoiNhan;
	private String trangThai;
	private String hinhThucThanhToan;
	private String trangThaiThanhToan;
	private double soTienThanhToan;
	private Date ngayDatHang;
	private Date ngayGiaoHang;

	
	
	public Order() {
	}



	public Order(String maDonHang, String tenDonHang, String diaChiNguoiMua, String diaChiNguoiNhan, String trangThai,
			String hinhThucThanhToan, String trangThaiThanhToan, double soTienThanhToan, Date ngayDatHang,
			Date ngayGiaoHang) {
		this.maDonHang = maDonHang;
		this.tenDonHang = tenDonHang;
		this.diaChiNguoiMua = diaChiNguoiMua;
		this.diaChiNguoiNhan = diaChiNguoiNhan;
		this.trangThai = trangThai;
		this.hinhThucThanhToan = hinhThucThanhToan;
		this.trangThaiThanhToan = trangThaiThanhToan;
		this.soTienThanhToan = soTienThanhToan;
		this.ngayDatHang = ngayDatHang;
		this.ngayGiaoHang = ngayGiaoHang;
	}



	public String getMaDonHang() {
		return maDonHang;
	}



	public void setMaDonHang(String maDonHang) {
		this.maDonHang = maDonHang;
	}



	public String getTenDonHang() {
		return tenDonHang;
	}



	public void setTenDonHang(String tenDonHang) {
		this.tenDonHang = tenDonHang;
	}



	public String getDiaChiNguoiMua() {
		return diaChiNguoiMua;
	}



	public void setDiaChiNguoiMua(String diaChiNguoiMua) {
		this.diaChiNguoiMua = diaChiNguoiMua;
	}



	public String getDiaChiNguoiNhan() {
		return diaChiNguoiNhan;
	}



	public void setDiaChiNguoiNhan(String diaChiNguoiNhan) {
		this.diaChiNguoiNhan = diaChiNguoiNhan;
	}



	public String getTrangThai() {
		return trangThai;
	}



	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}



	public String getHinhThucThanhToan() {
		return hinhThucThanhToan;
	}



	public void setHinhThucThanhToan(String hinhThucThanhToan) {
		this.hinhThucThanhToan = hinhThucThanhToan;
	}



	public String getTrangThaiThanhToan() {
		return trangThaiThanhToan;
	}



	public void setTrangThaiThanhToan(String trangThaiThanhToan) {
		this.trangThaiThanhToan = trangThaiThanhToan;
	}



	public double getSoTienThanhToan() {
		return soTienThanhToan;
	}



	public void setSoTienThanhToan(double soTienThanhToan) {
		this.soTienThanhToan = soTienThanhToan;
	}



	public Date getNgayDatHang() {
		return ngayDatHang;
	}



	public void setNgayDatHang(Date ngayDatHang) {
		this.ngayDatHang = ngayDatHang;
	}



	public Date getNgayGiaoHang() {
		return ngayGiaoHang;
	}



	public void setNgayGiaoHang(Date ngayGiaoHang) {
		this.ngayGiaoHang = ngayGiaoHang;
	}



	@Override
	public String toString() {
		return "Order [maDonHang=" + maDonHang + ", tenDonHang=" + tenDonHang + ", diaChiNguoiMua=" + diaChiNguoiMua
				+ ", diaChiNguoiNhan=" + diaChiNguoiNhan + ", trangThai=" + trangThai + ", hinhThucThanhToan="
				+ hinhThucThanhToan + ", trangThaiThanhToan=" + trangThaiThanhToan + ", soTienThanhToan="
				+ soTienThanhToan + ", ngayDatHang=" + ngayDatHang + ", ngayGiaoHang=" + ngayGiaoHang + "]";
	}
	
	
}
