package DAjava;

public abstract class NhanVien {
    protected String chucVu, maNv, tenNv, ngaySinh, diaChi;
    int luong;

    public NhanVien() {}
    public NhanVien(String chucVu, String maNv, String tenNv, String ngaySinh, String diaChi, int luong) {
        this.chucVu = chucVu;
        this.maNv = maNv;
        this.tenNv = tenNv;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.luong = luong;
    }
    public NhanVien(String maNv, String tenNv, String ngaySinh, String diaChi, int luong) {
        this.maNv = maNv;
        this.tenNv = tenNv;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.luong = luong;
    }

    public int getLuong(){
        return this.luong;
    }
    public void setLuong(int luong){
        this.luong = luong;
    }

    public String getMaNv() {
        return this.maNv;
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
    public abstract void congViec();

    @Override
    public String toString(){
        return this.chucVu+", "+this.maNv+ ", "+ this.tenNv+ ", "+ this.ngaySinh+ ", "+ this.diaChi+", "+this.luong+ "\n";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((chucVu == null) ? 0 : chucVu.hashCode());
        result = prime * result + ((maNv == null) ? 0 : maNv.hashCode());
        result = prime * result + ((tenNv == null) ? 0 : tenNv.hashCode());
        result = prime * result + ((ngaySinh == null) ? 0 : ngaySinh.hashCode());
        result = prime * result + ((diaChi == null) ? 0 : diaChi.hashCode());
        return result;
    } 
}
