package DAjava;

import java.util.Scanner;

public class SmartWatch extends SanPham{

    public SmartWatch() {
        this.LSP = "SmartWatch";
    }

    public SmartWatch(String maSP, String tenSP, String mauSac, String boNho, String pin, int donGia) {
        super(maSP, tenSP, mauSac, boNho, pin, donGia);
        this.LSP = "SmartWatch";
    }

    Scanner sc = new Scanner(System.in);

    public static void healthcare(){
        System.out.println("Helthcare: theo doi nhip tim, buoc chay, giac ngu, va cac du lieu suc khoe.");
    }
    public static void thongBao(){
        System.out.println("Thong bao: hien thi thong bao tu dien thoai, bao gom cac cuoc goi, tin nhan, va ung dung khac.");
    }
    public static void music(){
        System.out.println("Music: dieu khien phat nhac tren dien thoai va cac thiet bi khac.");
    }
    public static void thanhToan(){
        System.out.println("Thanh toan thong minh: thanh toan khong can vi hoac the tin dung.");
    }

    @Override
    public void tinhNang(){
        healthcare();
        thongBao();
        music();
        thanhToan();
    }
    @Override
    public void nhap() {
        System.out.print("Nhap vao ma san pham: ");
        this.maSP = sc.nextLine();
        System.out.print("Nhap vao ten san pham: ");
        this.tenSP = sc.nextLine();
        System.out.print("Thoi luong pin: ");
        this.pin = sc.nextLine();
        System.out.print("Mau sac san pham: ");
        this.mauSac = sc.nextLine();
        System.out.print("Bo nho: ");
        this.boNho = sc.nextLine();
        System.out.print("Nhap vao gia cua san pham: ");
        this.donGia = Integer.parseInt(sc.nextLine());
    }
    @Override
    public void xuat() {
        // System.out.println(
        //     "LSP: "+ this.LSP+ " | maSP: "+ this.maSP+ " | tenSP: "+ this.tenSP+ " | mauSac: "+ this.mauSac+ " | boNho: "+ this.boNho+ " | pin: "+ this.pin+ " | donGia: "+ this.donGia+ "\n"
        // );
        System.out.format("%-20s%-15s%-40s%-15s%-10s%-10s%s\n", this.LSP, this.maSP, this.tenSP, this.mauSac, this.boNho, this.pin, this.donGia);
    }
}
