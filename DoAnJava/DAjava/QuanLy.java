package DAjava;

import java.util.Scanner;

public class QuanLy extends NhanVien{
    public QuanLy(){
        this.chucVu = "QuanLy";
    }
    public QuanLy(String maNV, String tenNV, String ngaySinh, String diaChi, int luong){
        super(maNV, tenNV, ngaySinh, diaChi, luong);
        this.chucVu = "QuanLy";
    }

    @Override
    public void congViec(){

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
