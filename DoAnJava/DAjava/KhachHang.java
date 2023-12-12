package DAjava;

import java.util.Scanner;

public class KhachHang implements iNhapXuat{
    private String tenKH, diaChi, SDT;
    public KhachHang() {;
    }
    public KhachHang(String tenKh, String diaChi, String SDT){
        this.tenKH = tenKh;
        this.diaChi = diaChi;
        this.SDT = SDT;
    }

    public String getTenKh() {
        return tenKH;
    }

    public void setTenKh(String tenKh) {
        this.tenKH = tenKh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String sDT) {
        this.SDT = sDT;
    }


    @Override
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ten khach hang: ");
        this.tenKH = sc.nextLine();
        System.out.print("Nhap dia chi khach hang: ");
        this.diaChi = sc.nextLine();
        System.out.print("Nhap SDT khach hang: ");
        this.SDT = sc.nextLine();
    }
    @Override
    public void xuat(){
        System.out.println("HashKH: "+ this.hashCode()+ ", Ten khach hang: "+this.tenKH+", Dia chi: "+this.diaChi+", SDT: "+this.SDT);
    }

    @Override
    public String toString(){
        return this.hashCode()+ ", "+ this.tenKH+ ", "+ this.diaChi+ ", "+ this.SDT+ "\n";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((tenKH == null) ? 0 : tenKH.hashCode());
        result = prime * result + ((diaChi == null) ? 0 : diaChi.hashCode());
        result = prime * result + ((SDT == null) ? 0 : SDT.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        KhachHang other = (KhachHang) obj;
        if (tenKH == null) {
            if (other.tenKH != null)
                return false;
        } else if (!tenKH.equals(other.tenKH))
            return false;
        if (diaChi == null) {
            if (other.diaChi != null)
                return false;
        } else if (!diaChi.equals(other.diaChi))
            return false;
        if (SDT == null) {
            if (other.SDT != null)
                return false;
        } else if (!SDT.equals(other.SDT))
            return false;
        return true;
    }
    
}
