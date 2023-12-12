package DAjava;

import java.util.Date;
import java.util.Scanner;

public class TestHoaDon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DanhSachHoaDon dsHD = new DanhSachHoaDon();
        int choice;

        do {
            System.out.println("===================== MENU =====================");
            System.out.println(
                    "|  1. Them hoa don vao danh sach.\n"
                +   "|  2. In danh sach.\n"
                +   "|  3. Xoa hoa don khoi danh sach.\n"
                +   "|  4. Xoa toan bo danh sach.\n"
                +   "|  5. Ghi data.\n"
                +   "|  6. Doc data.\n"
                +   "|  0. Thoat."
            );
            System.out.println("================================================");
            System.out.print("Nhap vao lua chon: ");

            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("Lua chon khong hop le, hay nhap vao mot so nguyen.\n");
                choice = -1;
                sc.nextLine();
            }

            if(choice == 1){
                System.out.println("Vao main.java de them hoa don vao file.\n");
            }else if(choice == 2){
                dsHD.xuat();
            }else if(choice == 3){
                
            }else if(choice == 4){
                dsHD.clearDS();
            }else if(choice == 5){
                System.out.println();
            }else if(choice == 6){
                dsHD.docDataTuFile();
                System.out.println();
            }
        } while (choice != 0);
    }
}
