package DAjava;

import java.io.File;
import java.util.Scanner;

public class MainNhanVien {
    public static void main(String[] args) {
        DanhSachNhanVien danhSachNhanVien = new DanhSachNhanVien();
        Scanner sc = new Scanner(System.in);
        File f = new File("dataNhanVien.txt");

        int luaChon = 0;
        do {
            System.out.println("=== Quan li nhan vien ===");
            System.out.println("1. Them nhan vien");
            System.out.println("2. Xuat danh sach nhan vien");
            System.out.println("3. Tim kiem nhan vien");
            System.out.println("4. Sua thong tin nhan vien");
            System.out.println("5. Xoa nhan vien");
            System.out.println("6. Ghi du lieu xuong File.");
            System.out.println("7. Lay du lieu tu File.");
            System.out.println("8. Lam rong danh sach.");
            System.out.println("0. Thoat.");
            System.out.print("Nhap lua chon cua ban: ");
            luaChon = sc.nextInt();
            sc.nextLine(); // Đọc kí tự '\n' sau khi đọc lựa chọn

            switch (luaChon) {
                case 1:
                    int choice = 0;
                    do{
                        System.out.println("=== Chon loai nhan vien muon nhap ===");
                        System.out.println(
                                "1. Nhan vien Quan ly.\n"
                            +   "2. Nhan vien Quan ly kho.\n"
                            +   "3. Nhan vien Ban hang.\n"
                            +   "0. Quay lai menu.\n"
                        );
                        choice = sc.nextInt();
                        sc.nextLine();
                        switch(choice){
                            case 1:
                                NhanVien ql = new QuanLy();
                                ql.nhap();
                                danhSachNhanVien.themNhanVien(ql);
                                break;
                            case 2:
                                NhanVien qlk = new QuanLyKho();
                                qlk.nhap();
                                danhSachNhanVien.themNhanVien(qlk);
                                break;
                            case 3:
                                NhanVien bh = new BanHang();
                                bh.nhap();
                                danhSachNhanVien.themNhanVien(bh);
                                break;
                            default:
                                break;
                        }
                    }while(choice != 0);
                    break;
                case 2:
                    danhSachNhanVien.xuatdsNhanVien();
                    break;
                case 3:
                    System.out.print("Nhap ma nhan vien can tim kiem: ");
                    String maNvTimKiem = sc.nextLine();
                    danhSachNhanVien.timKiemNhanVien(maNvTimKiem);
                    break;
                case 4:
                    System.out.print("Nhap ma nhan vien can sua: ");
                    String maNvSua = sc.nextLine();
                    danhSachNhanVien.suaNhanVien(maNvSua);
                    break;
                case 5:
                    System.out.print("Nhap ma nhan vien can xoa: ");
                    String maNvXoa = sc.nextLine();
                    danhSachNhanVien.xoaNhanVien(maNvXoa);
                    break;
                case 6:
                    danhSachNhanVien.ghiDataXuongFile(f);
                    break;
                case 7:
                    danhSachNhanVien.docDataTuFile();
                    break;
                case 8:
                    danhSachNhanVien.clearDanhSach();
                    break;
            }
            System.out.println();
        } while (luaChon != 0);
    }
}
