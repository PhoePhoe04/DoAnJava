package DAjava;

import java.io.File;
import java.util.Scanner;

public class TestGioHang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GioHang gh = new GioHang();
        DanhSachGioHang dSachGioHang = new DanhSachGioHang();
        Kho kho = new Kho();
        kho.docDataTuFile();
        File f = new File("C:\\Users\\Phuc Duy\\Desktop\\DoAnJava\\DoAnJava\\DAjava\\Data\\testDataGioHang.txt");
        int choice;
        do {
            System.out.println("===================== MENU =====================\n");
            System.out.println(
                    "1. Xem san pham.\n"
                +   "2. Them san pham vao gio.\n"
                +   "3. Xoa san pham trong gio.\n"
                +   "4. In san pham.\n"
                +   "5. Xoa toan bo gio hang.\n"
                +   "6. Them gio hang vao danh sach.\n"
                +   "7. Ghi data xuong file.\n"
                +   "8. Doc data tu file\n"
                +   "9. In danh sach.\n"
                +   "0. Thoat.\n"
            );
            System.out.println("================================================\n");
            System.out.print("Nhap vao lua chon: ");
            try {
                choice = sc.nextInt();
            } catch (Exception  e) {
                System.out.println("Lua chon khong hop le, hay nhap vao mot so nguyen.\n");
                choice = -1;
                sc.nextLine();
            }

            if(choice == 1){
                kho.inKho();
                System.out.println();
            }else if(choice == 2){
                sc.nextLine();
                System.out.println("Nhap vao ma san pham muon them.");
                String maSP = sc.nextLine();
                gh.themVaoGio(maSP);
                System.out.println();
            }else if(choice == 3){
                sc.nextLine();
                System.out.println("Nhap vao ma san pham muon xoa.\n");
                String maSP = sc.nextLine();
                gh.xoaKhoiGioHang(maSP);
                System.out.println("Da xoa san pham co ma | "+maSP+" | trong gio.\n");
            }else if(choice == 4){
                gh.inGioHang();
                System.out.println();
            }else if(choice == 5){
                gh.xoaTatCa();
                System.out.println();
            }else if(choice == 6){
                dSachGioHang.themVaoDanhSachGH(gh);
            }else if(choice == 7){
                dSachGioHang.ghiDataXuongFile(f);
            }else if(choice == 8){
                dSachGioHang.docDataTuFile(f);
            }else if(choice == 9){
                dSachGioHang.inDanhSachGioHang();
            }
        } while (choice != 0);
    }
}
