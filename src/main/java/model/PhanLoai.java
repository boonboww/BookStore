package model;

public class PhanLoai {
	private String maPhanLoai;
	private String tenPhanLoai;
	public PhanLoai() {
	}
	public PhanLoai(String maPhanLoai, String tenPhanLoai) {
		this.maPhanLoai = maPhanLoai;
		this.tenPhanLoai = tenPhanLoai;
	}
	public String getMaPhanLoai() {
		return maPhanLoai;
	}
	public void setMaPhanLoai(String maPhanLoai) {
		this.maPhanLoai = maPhanLoai;
	}
	public String getTenPhanLoai() {
		return tenPhanLoai;
	}
	public void setTenPhanLoai(String tenPhanLoai) {
		this.tenPhanLoai = tenPhanLoai;
	}
	
}
