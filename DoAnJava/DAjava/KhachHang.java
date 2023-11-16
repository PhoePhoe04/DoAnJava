package DAjava;

import java.util.Scanner;

public class KhachHang {
    private String tenKh, diaChi, SDT;

    public KhachHang() {
        tenKh = "";
        diaChi = "";
        SDT = "";
    }
    public KhachHang(String maKh, String tenKh, String diaChi, String SDT) {

        this.tenKh = tenKh;
        this.diaChi = diaChi;
        this.SDT = SDT;
    }

    public String getTenKh() {
        return tenKh;
    }

    public void setTenKh(String tenKh) {
        this.tenKh = tenKh;
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

    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ten khach hang: ");
        this.tenKh = sc.nextLine();
        System.out.print("Nhap dia chi khach hang: ");
        this.diaChi = sc.nextLine();
        System.out.print("Nhap SDT khach hang: ");
        this.SDT = sc.nextLine();
    }

    public void inThongTin(){
        System.out.println("Ten khach hang: "+this.tenKh+", Dia chi: "+this.diaChi+", SDT: "+this.SDT);
    }

}
