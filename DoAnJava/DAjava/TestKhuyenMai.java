package DAjava;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TestKhuyenMai {
    public static void main(String[] args) {
        DanhSachKhuyenMai dsKM = new DanhSachKhuyenMai();
        File f = new File("C:\\Users\\Phuc Duy\\Desktop\\DoAnJava\\DoAnJava\\DAjava\\Data\\testDataKhuyenMai.txt");
        Scanner sc = new Scanner(System.in);
        int choice;

        do{
            hienThiMenu();

            try {
                System.out.println("Nhap lua chon cua ban.");
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Lua chon khong hop le vui long nhap vao 1 so nguyen.");
                sc.next();
                choice = -1;
            }

            if(choice == 1){
                System.out.println("Nhap khuyen mai.");
                KhuyenMai KM = new KhuyenMai();
                KM.nhap();
                dsKM.themVaoDanhSach(KM);
                System.out.println();
            }else if(choice == 2){
                System.out.println("Nhap vao ma khuyen mai muon xoa.");
                dsKM.xoaKhoiDanhSach(sc.nextLine());
                System.out.println();
            }else if(choice == 3){
                System.out.println("Nhap vao ma khuyen mai muon sua.");
                dsKM.suaKhuyenMai(sc.nextLine());
                System.out.println();
            }else if(choice == 4){
                dsKM.ghiDataXuongFile(f);
                System.out.println();
            }else if(choice == 5){
                dsKM.docDataTuFile(f);
                System.out.println();
            }else if(choice == 6){
                dsKM.inDanhSach();
                System.out.println();
            }else if(choice == 7){
                dsKM.clearDanhSach();
                System.out.println();
            }
        }while(choice != 0);
    }

    public static void hienThiMenu(){
        System.out.println("=======MENU=======");
        System.out.println(
                "1. Them vao ma khuyen mai.\n"
            +   "2. Xoa ma khuyen mai.\n"
            +   "3. Sua khuyen mai.\n"
            +   "4. Ghi data xuong file.\n"
            +   "5. Doc data tu file.\n"
            +   "6. In danh sach.\n"
            +   "7. Clear danh sach.\n"
            +   "0. Thoat khoi chuong trinh."
        );
        System.out.println("==================\n");
    }
}
