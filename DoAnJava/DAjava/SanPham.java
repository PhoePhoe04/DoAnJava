package DAjava;


public abstract class SanPham implements iNhapHang, Comparable<SanPham>{
    protected String LSP, maSP, tenSP, mauSac, boNho, pin;
    protected int donGia;
    

    public SanPham() {
    }
    public SanPham(String LSP, String maSP, String tenSP, String mauSac, String boNho, String pin, int donGia){
        this.LSP = LSP;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.mauSac = mauSac;
        this.boNho = boNho;
        this.pin = pin;
        this.donGia = donGia;
    }
    public SanPham(String maSP, String tenSP, String mauSac, String boNho, String pin, int donGia) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.mauSac = mauSac;
        this.boNho = boNho;
        this.pin = pin;
        this.donGia = donGia;
    }

    public String getMaSP() {
        return this.maSP;
    }
    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }
    public String getTenSP() {
        return this.tenSP;
    }
    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }
    public String getLSP() {
        return this.LSP;
    }
    public void setLSP(String lSP) {
        this.LSP = lSP;
    }
    public String getMauSac() {
        return this.mauSac;
    }
    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }
    public String getBoNho() {
        return this.boNho;
    }
    public void setBoNho(String boNho) {
        this.boNho = boNho;
    }
    public String getPin() {
        return this.pin;
    }
    public void setPin(String pin) {
        this.pin = pin;
    }
    public int getDonGia() {
        return this.donGia;
    }
    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    @Override
    public abstract void nhap();
    @Override
    public abstract void xuat();

    @Override
    public String toString(){
        return this.LSP+ ", "+ this.maSP+ ", "+ this.tenSP+ ", "+ this.mauSac+ ", "+ this.boNho+ ", "+ this.pin+ ", "+ donGia;
    }
    @Override
    public int compareTo(SanPham o){
        return this.getMaSP().compareTo(o.getMaSP());
    }
}