package DAjava;

import java.util.Scanner;

public class BanHang extends NhanVien{
    public BanHang(){
        this.chucVu = "BanHang";
    }
    public BanHang(String maNV, String tenNV, String ngaySinh, String diaChi){
        super(maNV, tenNV, ngaySinh, diaChi);
        this.chucVu = "BanHang";
    }

    @Override
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao ma nhan vien: ");
        this.maNv = sc.nextLine();
        System.out.println("Nhap vao ten nhan vien: ");
        this.tenNv = sc.nextLine();
        System.out.println("Nhap vao ngay sinh: ");
        this.ngaySinh = sc.nextLine();
        System.out.println("Nhap vao diaChi: ");
        this.diaChi = sc.nextLine();
    }
    @Override
    public void xuat(){
        System.out.println(
                "------Thong tin nhan vien------\n"
            +   "chucVu: "+ this.chucVu+ " | maNV: "+ this.maNv+ " | tenNV: "+ this.tenNv+ " | ngaySinh: "+ this.ngaySinh+ " | diaChi: "+ this.diaChi+ "\n"
            +   "-------------------------------"
        );
    }
}