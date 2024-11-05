package model;

import java.sql.Date;

public class TacGia {
	private String maTacGia;
	private String tenTacGia;
	private Date ngaySinh;
	private int soSanPham;
	
	public TacGia() {
	}

	public TacGia(String maTacGia, String tenTacGia, Date ngaySinh, int soSanPham) {
		this.maTacGia = maTacGia;
		this.tenTacGia = tenTacGia;
		this.ngaySinh = ngaySinh;
		this.soSanPham = soSanPham;
	}

	public String getMaTacGia() {
		return maTacGia;
	}

	public void setMaTacGia(String maTacGia) {
		this.maTacGia = maTacGia;
	}

	public String getTenTacGia() {
		return tenTacGia;
	}

	public void setTenTacGia(String tenTacGia) {
		this.tenTacGia = tenTacGia;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public int getSoSanPham() {
		return soSanPham;
	}

	public void setSoSanPham(int soSanPham) {
		this.soSanPham = soSanPham;
	}

	@Override
	public String toString() {
		return "TacGia [maTacGia=" + maTacGia + ", tenTacGia=" + tenTacGia + ", ngaySinh=" + ngaySinh + ", soSanPham="
				+ soSanPham + "]";
	}
	
	
	
	
}
