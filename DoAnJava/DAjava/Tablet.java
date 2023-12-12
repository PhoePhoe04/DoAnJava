package DAjava;

import java.util.Scanner;

public class Tablet extends SanPham{

    public Tablet() {
        this.LSP = "Tablet";
    }  
    

    public Tablet(String maSP, String tenSP, String mauSac, String boNho, String pin, int donGia) {
        super(maSP, tenSP, mauSac, boNho, pin, donGia);
        this.LSP = "Tablet";
    }

    Scanner sc = new Scanner(System.in);

    public static void bigScreen(){
        System.out.println("Big Screen: man hinh lon hon so voi smartphone, cung cap trai nghiem tot hon.");
    }
    public static void ungDungNangCao(){
        System.out.println("Ung dung nang cao: co thay chay ung dung phuc tap hon so voi smartphone voi giao dien do hoa lon.");
    }
    public static void ketNoiNgoaiVi(){
        System.out.println("Ket noi ngoai vi: ket noi ban phim hoac chuot ngoai vi de cai thien kha nang banh van ban va tuong tac.");
    }
    
    @Override
    public void tinhNang(){
        bigScreen();
        ungDungNangCao();
        ketNoiNgoaiVi();
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
