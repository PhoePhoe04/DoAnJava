package DAjava;

import java.util.Scanner;

public class Main {
    static int choice, lc;
    static Kho khoHang = new Kho();
    static DanhSachNhanVien dsnv = new DanhSachNhanVien();
    static DanhSachKhachHang dsKH = new DanhSachKhachHang();
    static DanhSachGioHang dsGH = new DanhSachGioHang();
    static DanhSachKhuyenMai dsKM = new DanhSachKhuyenMai();
    static DanhSachHoaDon dsHD = new DanhSachHoaDon();
    static Scanner sc = new Scanner(System.in);

    static GioHang gioHang = new GioHang();
    static KhachHang khachHang = new KhachHang();


    public static void main(String[] args) {
        layData();
        
        System.out.println("Kinh chao quy khach den voi cua hang di dong DKT.\n");
        System.out.println("Xin quy khach vui long de lai thong tin o duoi.\n");
        khachHang.nhap();
        System.out.println("Chon phim bat ki de tiep tuc.\n");
        sc.nextLine();
        do{
            hienThiMenu();
            
            checkChoice();
            
            sc.nextLine();
            System.out.println();
            if(choice == 1){
                choice1();
                System.out.println();
            }
            else if(choice == 2){
                choice2();
                System.out.println();
            }
            else if(choice == 3){
                System.out.println("Nhap vao ma san pham: ");
                String maSP = sc.nextLine();
                gioHang.themVaoGio(maSP);
                System.out.println();
            }
            else if(choice == 4){
                gioHang.inGioHang();
                System.out.println();
            }
            else if(choice == 5){
                choice5();
                System.out.println();
            }
            else if(choice == 6){
                KhuyenMai khuyenMai = dsKM.layKM(gioHang.gioHangSize());
                dsGH.themVaoDanhSachGH(gioHang);
                dsKH.themKhachHang(khachHang);
                HoaDon hd = new HoaDon(gioHang, khachHang, khuyenMai, dsnv.layNhanVien("BH1"));
                dsHD.themVaoDanhSach(hd);
                luuData();
                hd.xuat();
                choice = 0;
            }
            
        }while(choice != 0);
    }

    public static void layData(){
        dsKH.docDataTuFile();
        dsGH.docDataTuFile();
        dsKM.docDataTuFile();
        khoHang.docDataTuFile();
        dsnv.docDataTuFile();
        dsHD.docDataTuFile();
    }
    public static void luuData(){
        dsKH.ghiDataXuongFile();
        dsGH.ghiDataXuongFile();
        dsHD.ghiDataXuongFile();
    }
    public static void hienThiMenu(){
        System.out.println("======================= Menu =======================");
        System.out.println(
                "1. Xem san pham trong cua shop.\n"
            +   "2. Tim kiem san pham.\n"
            +   "3. Tien hanh mua hang.\n"
            +   "4. Kiem tra gio hang.\n"
            +   "5. Chinh sua gio hang.\n"
            +   "6. Thanh toan.\n"
            +   "0. Roi cua hang."
        );
        System.out.println("====================================================");
    }
    public static void checkChoice(){
        try {
            System.out.print("Moi nhap lua chon: ");
            choice = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Xin hay nhap vao mot so nguyen.\n");
            choice = -1;
        }
    }
    public static void checkLC(){
        try {
            lc = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Xin hay nhap vao mot so nguyen.\n");
            lc = -1;
        }
    }
    


    public static void choice1(){
        int chon;
        do {
            System.out.println("Shop gom co 3 mat hang 'SmartPhone' 'SmartWatch' 'Tablet' .");
            System.out.println("----------------------------------------------------");
            System.out.println(
                    "1. Xem cac mat hang la 'SmartPhone'.\n"
                +   "2. Xem cac mat hang la 'SmartWatch'.\n"
                +   "3. Xem cac mat hang la 'Tablet'.\n"
                +   "4. Xem tat ca cac mat hang co trong shop.\n"
                +   "0. Quay lai menu."
            );
            System.out.println("----------------------------------------------------");
            System.out.print("Moi nhap lua chon: ");
            
            try {
                chon = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("Lua chon khong hop le, hay nhap vao mot so nguyen!.\n");
                chon = -1;
                sc.nextLine();
            }

            System.out.println();
            if(chon == 1){
                khoHang.inSmartPhone();
            }else if(chon == 2){
                khoHang.inSmartWatch();
            }else if(chon == 3){
                khoHang.inTablet();
            }else if(chon == 4){
                khoHang.inKho();
            }
        } while (chon != 0);
    }
    public static void choice2(){
        int chon;
        do{
            System.out.println("--------------------- TIM KIEM ---------------------\n");
            System.out.println(
                    "1. Tim kiem san pham theo maSP hoac tenSP.\n"
                +   "2. Tim kiem san pham theo khoang donGia (min, max).\n"
                +   "3. Tim kiem san pham co donGia tu thap den cao.\n"
                +   "4. Tim kiem san pham co donGia tu cao den thap.\n"
                +   "0. Quay lai menu.\n"
            );
            System.out.println("----------------------------------------------------\n");
            System.out.println("Nhap vao lua chon: ");

            try {
                chon = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("Lua chon khong hop le, hay nhap vao mot so nguyen!.\n");
                chon = -1;
                sc.nextLine();
            }
            
            if(chon == 1){
                sc.nextLine();
                System.out.println("Nhap vao ten san pham hoac ma san pham muon tim kiem.");
                String sp = sc.nextLine();
                khoHang.timkiemSanPham(sp);
                System.out.println();
            }else if(chon == 2){
                sc.nextLine();
                System.out.println("Nhap vao donGia min, max (VD: 1000000 3000000)");
                int min, max;
                do {
                    try {
                        System.out.print("Nhap vao gia tri min: ");
                        min = sc.nextInt();
                        System.out.print("Nhap vao gia tri max: ");
                        max = sc.nextInt();
                        sc.nextLine();
                    } catch (Exception e) {
                        System.out.println("Gia tri nhap vao khong hop le.\n");
                        min = -1;
                        max = -1;
                        sc.nextLine();
                    }
                } while (min < 0 || max < 0);
                System.out.println();
                khoHang.timkiemSanPham(min, max);
                System.out.println();
            }else if(chon == 3){
                khoHang.timkiemSanPhamThapDenCao();
                khoHang.inKho();
                System.out.println();
            }else if(chon == 4){
                khoHang.timkiemSanPhamCaoDenThap();
                khoHang.inKho();
                System.out.println();
            }
        }while(chon != 0);
    }
    public static void choice5(){
        do{
            
            System.out.println("-----------------------------------------------------");
            System.out.println(
                    "1. Xoa san pham trong gio theo maSP.\n"
                +   "2. Xoa san pham trong gio theo vi tri trong gio.\n"
                +   "3. Xoa toan bo gio hang.\n"
                +   "0. Quay lai Menu.\n"
            );
            System.out.println("-----------------------------------------------------");
            checkLC();
            sc.nextLine();
            if(lc == 1){
                System.out.print("Nhap vao maSP: ");
                String maSP = sc.nextLine();
                gioHang.xoaKhoiGioHang(maSP);
            }
            else if(lc == 2){
                if(gioHang.gioHangSize() > 0){
                    System.out.println("Nhap vao vi tri san pham: ");
                    int viTri;
                    try {
                        viTri = sc.nextInt();
                    } catch (Exception e) {
                        System.out.println("Vi tri khong hop le.Vui long nhap lai !");
                        sc.nextLine();
                        viTri = -1;
                    }
                    gioHang.xoaKhoiGioHang(viTri);
                }else{
                    System.out.println("Gio hang hien tai cua ban dang trong.");
                }

            }
            else if(lc == 3){
                gioHang.xoaTatCa();
                System.out.println("Toan bo gio hang da duoc xoa!");
            }
        }while(lc != 0);
    }

}
