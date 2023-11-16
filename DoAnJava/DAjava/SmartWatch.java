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

    @Override
    public void nhap() {
        System.out.print("\nNhap vao ma san pham: ");
        this.maSP = sc.nextLine();
        System.out.print("\nNhap vao ten san pham: ");
        this.tenSP = sc.nextLine();
        System.out.print("\nThoi luong pin: ");
        this.pin = sc.nextLine();
        System.out.print("\nMau sac san pham: ");
        this.mauSac = sc.nextLine();
        System.out.print("\nBo nho: ");
        this.boNho = sc.nextLine();
        System.out.print("\nNhap vao gia cua san pham: ");
        this.donGia = Integer.parseInt(sc.nextLine());
    }

    @Override
    public void xuat() {
        System.out.println(
            "LSP: "+ this.LSP+ " | maSP: "+ this.maSP+ " | tenSP: "+ this.tenSP+ " | mauSac: "+ this.mauSac+ " | boNho: "+ this.boNho+ " | pin: "+ this.pin+ " | donGia: "+ this.donGia+ "\n"

        );
    }
}
