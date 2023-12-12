package DAjava;

import java.util.Scanner;

public class SmartPhone extends SanPham {
    public SmartPhone() {
        this.LSP = "SmartPhone";
    }

    public SmartPhone(String maSP, String tenSP, String mauSac, String boNho, String pin, int donGia){
        super(maSP, tenSP, mauSac, boNho, pin, donGia);
        this.LSP = "SmartPhone";
    }

    Scanner sc = new Scanner(System.in);

    public static void dienThoai_SMS(){
        System.out.println("Dien thoai va SMS: thuc hien cuoc goi va gui tin nhan SMS.");
    }
    public static void ungDung(){
        System.out.println("Ung dung: cai dat va chay hang loat cac ung dung tu cua hang.");
    }
    public static void camera(){
        System.out.println("Camera: chup anh va quay video.");
    }
    public static void GPS(){
        System.out.println("GPS: su dung GPS de dinh vi va cung cap hung dan dieu huong.");
    }
    public static void camBien(){
        System.out.println("Cam bien: su dung cam bien van tay, cam bien anh sang de cai thien trai nghiem nguoi dung.");
    }

    @Override
    public void tinhNang(){
        dienThoai_SMS();
        ungDung();
        camera();
        GPS();
        camBien();
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
