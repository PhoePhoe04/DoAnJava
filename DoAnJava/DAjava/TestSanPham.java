package DAjava;

import java.io.File;
import java.util.Scanner;

public class TestSanPham {
    public static void main(String[] args) {
        Kho khoHang = new Kho();
        int choice;
        Scanner sc = new Scanner(System.in);
        File f = new File("C:\\Users\\Phuc Duy\\Desktop\\DoAnJava\\DoAnJava\\DAjava\\Data\\testDataSanPham.txt");

        do{
            System.out.println("======================= MENU =======================\n");
            System.out.println(
                    "1. Them vao kho.\n"
                +   "2. Xoa san pham khoi kho.\n"
                +   "3. Tim kiem san pham theo maSP.\n"
                +   "4. Don dep kho.\n"
                +   "5. In toan bo kho.\n"
                +   "6. Ghi du lieu xuong file.\n"
                +   "7. Doc du lieu tu file.\n"
                +   "8. In san pham theo loai.\n"
                +   "9. In san pham theo don gia.\n"
                +   "0. Thoat Menu.\n"
            );
            System.out.println("====================================================\n");
            System.out.print("Moi nhap lua chon: ");

            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Lua chon khong hop le, hay nhap vao mot so nguyen.\n");
                sc.next();
                choice = -1;
            }
            System.out.println();

            if(choice == 1){
                System.out.println();
                khoHang.themVaoKho();
            }else if(choice == 2){
                sc.nextLine();
                System.out.print("Nhap ma san pham muon xoa: ");
                khoHang.xoaSP(sc.nextLine());
            }else if(choice == 3){
                sc.nextLine();
                System.out.print("Nhap vao maSP muon tim: ");
                String maSP = sc.nextLine();
                khoHang.timkiemSanPham(maSP);
                System.out.println();
            }else if(choice == 4){
                khoHang.clearKho();
                System.out.println();
            }else if(choice == 5){
                khoHang.inKho();
                System.out.println();
            }else if(choice == 6){
                khoHang.ghiDataXuongFile(f);
            }else if(choice == 7){
                khoHang.docDataTuFile(f);
            }else if(choice == 8){
                int lc;
                do {
                    System.out.println("Cac loai san pham");
                    System.out.println(
                            "1. SmartPhone.\n"
                        +   "2. SmartWatch.\n"
                        +   "3. Tablet.\n"
                        +   "0. Quay lai MENU.\n"
                    );
                    try {
                        lc = sc.nextInt();
                        sc.nextLine();
                    } catch (Exception e) {
                        sc.nextLine();
                        System.out.println("Lua chon khong hop le, hay nhap vao mot so nguyen.\n");
                        lc = -1;
                    }
                    if(lc == 1){
                        khoHang.inSmartPhone();
                    }else if(lc == 2){
                        khoHang.inSmartWatch();
                    }else if(lc == 3){
                        khoHang.inTablet();
                    }
                } while (lc != 0);
            }else if(choice == 9){
                int lc;
                do {
                    System.out.println("Tim kiem theo don gia.\n");
                    System.out.println(
                            "1. Tim kiem theo gia tri min, max.\n"
                        +   "2. Don gia giam dan.\n"
                        +   "3. Don gia tang dan.\n"
                        +   "0. Quay lai MENU.\n"
                    );
                    System.out.print("Nhap vao lua chon.");
                    try {
                        lc = sc.nextInt();
                        sc.nextLine();
                    } catch (Exception e) {
                        sc.nextLine();
                        System.out.println("Lua cho khong hop le, hay nhap vao mot so nguyen.\n");
                        lc = -1;
                    }
                    
                    if(lc == 1){
                        System.out.println("Nhap vao gia tri min, max : ");
                        int min, max;
                        try {
                            min = sc.nextInt();
                            max = sc.nextInt();
                        } catch (Exception e) {
                            System.out.println("Nhap lai gia tri hop le.");
                            min = -1;
                            max = -1;
                        }
                        khoHang.timkiemSanPham(min, max);
                        System.out.println();
                    }else if(lc == 2){
                        khoHang.timkiemSanPhamCaoDenThap();
                        khoHang.inKho();
                        System.out.println();
                    }else if(lc == 3){
                        khoHang.timkiemSanPhamThapDenCao();
                        khoHang.inKho();
                        System.out.println();
                    }
                } while (lc != 0);
            }
        }while(choice != 0);
    }
}
