package DAjava;

import java.util.Scanner;

public class QuanLyKho extends NhanVien{
    public QuanLyKho(){
        this.chucVu = "QuanLyKho";
    }
    public QuanLyKho(String maNV, String tenNV, String ngaySinh, String diaChi, int luong){
        super(maNV, tenNV, ngaySinh, diaChi, luong);
        this.chucVu = "QuanLyKho";
    }

    public static void viTri(){
        System.out.println("Lam viec tai kho.");
    }
    public static void moTaCV(){
        System.out.println("Kiem tra hang hoa, sap xep hang hoa");
    }

    @Override
    public void congViec(){
        viTri();
        moTaCV();
    }
    @Override
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap vao ma nhan vien: ");
        this.maNv = sc.nextLine();
        System.out.print("Nhap vao ten nhan vien: ");
        this.tenNv = sc.nextLine();
        System.out.print("Nhap vao ngay sinh: ");
        this.ngaySinh = sc.nextLine();
        System.out.print("Nhap vao diaChi: ");
        this.diaChi = sc.nextLine();
        System.out.print("Nhap vao luong: ");
        this.luong = sc.nextInt();
    }
    @Override
    public void xuat(){
        System.out.println(
                "------Thong tin nhan vien------\n"
            +   "chucVu: "+ this.chucVu+ " | maNV: "+ this.maNv+ " | tenNV: "+ this.tenNv+ " | ngaySinh: "+ this.ngaySinh+ " | diaChi: "+ this.diaChi+" | luong: "+ this.luong+ "\n"
            +   "-------------------------------"
        );
    }
}
