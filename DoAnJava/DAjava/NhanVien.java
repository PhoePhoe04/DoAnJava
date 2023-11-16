package DAjava;

import java.io.Serializable;

public abstract class NhanVien implements Serializable{
    protected String chucVu, maNv, tenNv, ngaySinh, diaChi;

    public NhanVien() {
    }
    public NhanVien(String chucVu, String maNv, String tenNv, String ngaySinh, String diaChi) {
        this.chucVu = chucVu;
        this.maNv = maNv;
        this.tenNv = tenNv;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
    }
    public NhanVien(String maNv, String tenNv, String ngaySinh, String diaChi) {
        this.maNv = maNv;
        this.tenNv = tenNv;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
    }


    public String getMaNv() {
        return maNv;
    }
    public void setMaNv(String maNv) {
        this.maNv = maNv;
    }

    public String getTenNv() {
        return tenNv;
    }
    public void setTenNv(String tenNv) {
        this.tenNv = tenNv;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }
    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public abstract void nhap();
    public abstract void xuat();

    @Override
    public String toString(){
        return this.chucVu+ ", "+ this.maNv+ ", "+ this.tenNv+ ", "+ this.ngaySinh+ ", "+ this.diaChi;
    }
}
