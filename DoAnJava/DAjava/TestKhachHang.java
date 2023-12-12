package DAjava;

import java.io.File;
import java.util.Scanner;

public class TestKhachHang {
    public static void main(String[] args) {
        DanhSachKhachHang dsKhachHang = new DanhSachKhachHang();
        Scanner sc = new Scanner(System.in);
        File f = new File("C:\\Users\\Phuc Duy\\Desktop\\DoAnJava\\DoAnJava\\DAjava\\Data\\testDataKhachHang.txt");
        int choice;

        do {
            hienThiMenu();

            try {
                System.out.print("Nhap vao lua chon: ");
                choice = sc.nextInt();
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("Hay nhap vao mot so nguyen.");
                sc.nextLine();
                choice = -1;
            }

            sc.nextLine();
            System.out.println();

            if(choice == 1){
                System.out.println("Nhap thong tin khach hang muon them.\n");
                KhachHang kh = new KhachHang();
                kh.nhap();
                dsKhachHang.themKhachHang(kh);
                System.out.println();
            }else if(choice == 2){
                System.out.println("Nhap thong tin khach hang muon tim kiem.\n");
                KhachHang KH = new KhachHang();
                KH.nhap();
                if(dsKhachHang.checkKhachHang(KH)){
                    System.out.println("Khach hang co ton tai trong danh sach.");
                }else{
                    System.out.println("Khach hang khong ton tai trong danh sach.");
                }
            }else if(choice == 3){
                System.out.println("Nhap vao ten khach hang muon tim kiem.\n");
                String ten = sc.nextLine();
                dsKhachHang.timKiemKhachHang(ten);
                System.out.println();
            }else if(choice == 4){
                System.out.println("Nhap vao maHash khach hang muon sua.\n");
                int maHash = sc.nextInt();
                dsKhachHang.suaKhachHang(maHash);
            }else if(choice == 5){
                System.out.println("Nhap vao ten khach hang muon xoa.\n");
                String ten = sc.nextLine();
                dsKhachHang.xoaKhachHang(ten);
            }else if(choice == 6){
                dsKhachHang.xuatdsKhachHang();
                System.out.println();
            }else if(choice == 7){
                dsKhachHang.clearDanhSach();
                System.out.println("Danh sach da duoc don dep.\n");
            }else if(choice == 8){
                dsKhachHang.ghiDataXuongFile(f);
                System.out.println("Du lieu da duoc ghi xuong file.\n");
            }else if(choice == 9){
                dsKhachHang.docDataTuFile(f);
                System.out.println("Du lieu da duoc doc len tu file.\n");
            }

        } while (choice != 0);
    }

    public static void hienThiMenu(){
        System.out.println("================ MENU ================\n");
        System.out.println(
                "1. Them khach hang vao danh sach.\n"
            +   "2. Tim kiem khach hang co ton tai trong danh sach.\n"
            +   "3. Tim kiem khach hang theo ten.\n"
            +   "4. Sua khach hang.\n"
            +   "5. Xoa khach hang.\n"
            +   "6. Xuat danh sach.\n"
            +   "7. Clear danh sach.\n"
            +   "8. Ghi du lieu len file.\n"
            +   "9. Doc du lieu tu file.\n"
            +   "0. Thoat chuong trinh.\n"
        );
        System.out.println("=====================================\n");
    }
}
