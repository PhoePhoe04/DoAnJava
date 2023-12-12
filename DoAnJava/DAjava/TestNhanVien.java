package DAjava;

import java.io.File;
import java.util.Scanner;

public class TestNhanVien {
    public static void main(String[] args) {
        DanhSachNhanVien danhSachNhanVien = new DanhSachNhanVien();
        Scanner sc = new Scanner(System.in);
        File f = new File("C:\\Users\\Phuc Duy\\Desktop\\DoAnJava\\DoAnJava\\DAjava\\Data\\testDataNhanVien.txt");

        int luaChon;
        do {
            System.out.println("======================= MENU =======================\n");
            System.out.println(
                    "1. Them nhan vien.\n"
                +   "2. Xuat danh sach nhan vien.\n"
                +   "3. Tim kiem nhan vien.\n"
                +   "4. Sua thong tin nhan vien.\n"
                +   "5. Xoa nhan vien.\n"
                +   "6. Ghi du lieu xuong File.\n"
                +   "7. Lay du lieu tu File.\n"
                +   "8. Lam rong danh sach.\n"
                +   "0. Thoat.\n"
            );
            System.out.println("====================================================\n");
            System.out.print("Nhap lua chon cua ban: ");
            
            try {
                luaChon = sc.nextInt();
                System.out.println();
            } catch (Exception e) {
                System.out.println("\nLua chon khong hop le, hay nhap vao mot so nguyen.\n");
                luaChon = -1;
                sc.next();
            }

            if(luaChon == 1){
                danhSachNhanVien.themNhanVien();
                System.out.println();
            }else if(luaChon == 2){
                danhSachNhanVien.xuatdsNhanVien();
            }else if(luaChon == 3){
                System.out.print("Nhap vao ma nhan vien muon tim. ");
                sc.nextLine();
                String maNV = sc.nextLine();
                danhSachNhanVien.timKiemNhanVien(maNV);
                System.out.println();
            }else if(luaChon == 4){
                System.out.println("Nhap vao ma nhan vien muon sua.");
                sc.nextLine();
                String maNV = sc.nextLine();
                danhSachNhanVien.suaNhanVien(maNV);
                System.out.println();
            }else if(luaChon == 5){
                System.out.println("Nhap vao ma nhan vien muon xoa.");
                sc.nextLine();
                String maNV = sc.nextLine();
                danhSachNhanVien.xoaNhanVien(maNV);
                System.out.println();
            }else if(luaChon == 6){
                danhSachNhanVien.ghiDataXuongFile(f);
            }else if(luaChon == 7){
                danhSachNhanVien.docDataTuFile(f);
            }else if(luaChon == 8){
                danhSachNhanVien.clearDanhSach();
            }
        } while (luaChon != 0);
    }
    
   
}
