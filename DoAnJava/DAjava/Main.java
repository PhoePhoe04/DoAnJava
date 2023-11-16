package DAjava;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Kho khoHang = new Kho();
        khoHang.docDataTuFile();
        DanhSachNhanVien dsnv = new DanhSachNhanVien();
        dsnv.docDataTuFile();
        GioHang gioHang = new GioHang();
        int choice = 0;
        KhachHang khachHang = new KhachHang();

        System.out.println("Kinh chao quy khach den voi cua hang di dong DKT.\n");
        System.out.println("Xin quy khach vui long de lai thong tin o duoi.\n");
        khachHang.nhap();
        System.out.println("Chon phim bat ki de tiep tuc.\n");
        sc.nextLine();
        do{
            System.out.println("--------Menu--------");
            System.out.println(
                    "1. Xem san pham trong cua shop.\n"
                +   "2. Tim kiem san pham.\n"
                +   "3. Tien hanh mua hang.\n"
                +   "4. Kiem tra gio hang.\n"
                +   "5. Thanh toan.\n"
                +   "0. Roi cua hang."
            );
            System.out.println("---------------------");
            System.out.print("Moi nhap lua chon: ");
            choice = sc.nextInt();
            sc.nextLine();
            System.out.println();
            if(choice == 1){
                int lc = 0;
                do {
                    System.out.println();
                    System.out.println("Shop gom co 3 mat hang 'SmartPhone' 'SmartWatch' 'Tablet' .");
                    System.out.println("---------------------");
                    System.out.println(
                            "1. Xem cac mat hang la 'SmartPhone'.\n"
                        +   "2. Xem cac mat hang la 'SmartWatch'.\n"
                        +   "3. Xem cac mat hang la 'Tablet'.\n"
                        +   "4. Xem tat ca cac mat hang co trong shop.\n"
                        +   "0. Quay lai menu."
                    );
                    System.out.println("---------------------");
                    System.out.print("Moi nhap lua chon: ");
                    lc = sc.nextInt();
                    System.out.println();
                    if(lc == 1){
                        khoHang.inSmartPhone();
                    }else if(lc == 2){
                        khoHang.inSmartWatch();
                    }else if(lc == 3){
                        khoHang.inTablet();
                    }else if(lc == 4){
                        khoHang.inKho();
                    }
                } while (lc != 0);
            }
            else if(choice == 2){
                int lc = 0;
                do{
                    System.out.println(
                            "1. Tim kiem san pham theo maSP hoac tenSP.\n"
                        +   "2. Tim kiem san pham theo khoang donGia (min, max).\n"
                        +   "3. Tim kiem san pham co donGia tu thap den cao.\n"
                        +   "4. Tim kiem san pham co donGia tu cao den thap.\n"
                        +   "0. Quay lai menu.\n"
                    );
                    lc = sc.nextInt();
                    sc.nextLine();
                    if(lc == 1){
                        System.out.println("Nhap vao ten san pham hoac ma san pham muon tim kiem.");
                        String sp = sc.nextLine();
                        khoHang.timkiemSanPham(sp);
                    }else if(lc == 2){
                        System.out.println("Nhap vao donGia min, max (VD: 1000000 3000000)");
                        int min, max;
                        min = sc.nextInt();
                        max = sc.nextInt();
                        khoHang.timkiemSanPham(min, max);
                    }else if(lc == 3){
                        khoHang.timkiemSanPhamThapDenCao();
                        khoHang.inKho();
                    }else if(lc == 4){
                        khoHang.timkiemSanPhamCaoDenThap();
                        khoHang.inKho();
                    }
                }while(lc != 0);
            }
            else if(choice == 3){
                System.out.println("Nhap vao ma san pham hoac ten san muon them vao gio.");
                String maOrten = sc.nextLine();
                gioHang.themVaoGio(maOrten);
            }
            else if(choice == 4){
                gioHang.inGioHang();
            }
            else if(choice == 5){
                KhuyenMai khuyenMai = new KhuyenMai(gioHang.gioHangSize());
                HoaDon hd = new HoaDon(gioHang, khachHang, khuyenMai, null);
                hd.inHoaDon();
                choice = 0;
            }
            
        }while(choice != 0);
    }
}
