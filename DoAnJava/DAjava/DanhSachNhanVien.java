package DAjava;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class DanhSachNhanVien implements iReaderWriter {
    private ArrayList<NhanVien> dsNhanVien;
    Scanner sc = new Scanner(System.in);

    public DanhSachNhanVien() {
        dsNhanVien = new ArrayList<>();
    }
    
    // Check
    public boolean checkMaNVDaCo(String maNV){
        for (NhanVien nhanVien : dsNhanVien) {
            if(nhanVien.getMaNv().equals(maNV)){
                return true;
            }
        }
        return false;
    }

    // Them nhan vien
    public void themNhanVien() {
        int choice;
        do{
            System.out.println("Chon nhan vien muon nhap");
            System.out.println(
                    "1. Nhan vien Ban Hang.\n"
                +   "2. Nhan vien Quan Ly.\n"
                +   "3. Nhan vien Quan Ly Kho.\n"
                +   "0. Quay lai MENU.\n"
            );
            System.out.print("Nhap lua chon: ");
            try {
                choice = sc.nextInt();
                System.out.println();
            } catch (Exception e) {
                System.out.println("Lua chon khong hop le, hay nhap vao mot so nguyen.\n");
                choice = -1;
                sc.next();
            }
            if(choice == 1){
                NhanVien bh = new BanHang();
                bh.nhap();
                System.out.println();
                if(checkMaNVDaCo(bh.getMaNv())){
                    System.out.println("Ma nhan vien da ton tai trong danh sach.\n");
                }else{
                    this.dsNhanVien.add(bh);
                }
            }else if(choice == 2){
                NhanVien ql = new QuanLy();
                ql.nhap();
                System.out.println();
                if(checkMaNVDaCo(ql.getMaNv())){
                    System.out.println("Ma nhan vien da ton tai trong danh sach.\n");
                }else{
                    this.dsNhanVien.add(ql);
                }
            }else if(choice == 3){
                NhanVien qlk = new QuanLyKho();
                qlk.nhap();
                System.out.println();
                if(checkMaNVDaCo(qlk.getMaNv())){
                    System.out.println("Ma nhan vien da ton tai trong danh sach.\n");
                }else{
                    this.dsNhanVien.add(qlk);
                }
            }
        }while(choice != 0);
    }

    // In danh sach
    public void xuatdsNhanVien() {
        for (NhanVien nhanVien : dsNhanVien) {
            nhanVien.xuat();
        }
    }

    // Tim kiem
    public void timKiemNhanVien(String maNv) {
        for (NhanVien nhanVien : dsNhanVien) {
            if (nhanVien.getMaNv().equals(maNv)) {
                nhanVien.xuat();
                return;
            }
        }
        System.out.println("Khong tim thay nhan vien co ma " + maNv);
    }

    // Sua nhan vien
    public void suaNhanVien(String maNv) {
        for (NhanVien nhanVien : dsNhanVien) {
            if (nhanVien.getMaNv().equals(maNv)) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Nhap thong tin moi cho nhan vien co ma " + maNv + ":");
                System.out.print("Nhap ten nhan vien: ");
                nhanVien.setTenNv(sc.nextLine());
                System.out.print("Nhap ngay sinh nhan vien: ");
                nhanVien.setNgaySinh(sc.nextLine());
                System.out.print("Nhap dia chi nhan vien: ");
                nhanVien.setDiaChi(sc.nextLine());
                System.out.print("Da sua thong tin cho nhan vien co ma " + maNv);
                return;
            }
        }

        System.out.println("Khong tim thay nhan vien co ma " + maNv);
    }

    // Xoa nhan vien
    public void xoaNhanVien(String maNv) {
        for (int i = 0; i < dsNhanVien.size(); i++) {
            NhanVien nhanVien = dsNhanVien.get(i);
            if (nhanVien.getMaNv().equals(maNv)) {
                dsNhanVien.remove(i);
                System.out.println("Da xoa nhan vien co ma " + maNv);
                return;
            }
        }

        System.out.println("Khong tim thay nhan vien co ma " + maNv);
    }
    public void clearDanhSach(){
        this.dsNhanVien.clear();
    }

    // Lay nhan vien
    public NhanVien layNhanVien(String ma){
        for (NhanVien nhanVien : dsNhanVien) {
            if(nhanVien.getMaNv().equals(ma)){
                if(nhanVien.chucVu.equals("BanHang")){
                    return (BanHang) nhanVien;
                }else if(nhanVien.chucVu.equals("QuanLy")){
                    return (QuanLy) nhanVien;
                }else if(nhanVien.chucVu.equals("QuanLyKho")){
                    return (QuanLyKho) nhanVien;
                }
            }
        }
        return null;
    }
    public NhanVien layNV(int hashNV) {
        for (NhanVien nhanVien : dsNhanVien) {
            if(nhanVien.hashCode() == hashNV){
                return (NhanVien) nhanVien;
            }
        }
        return null;
    }

    // Ghi data
    @Override
    public void ghiDataXuongFile(){
        try {
            FileWriter fw = new FileWriter("dataNhanVien.txt");
            for (NhanVien nhanVien : this.dsNhanVien) {
                fw.write(nhanVien.toString());
            }
            fw.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public void ghiDataXuongFile(File f){
        try {
            FileWriter fw = new FileWriter(f);
            for (NhanVien nhanVien : this.dsNhanVien) {
                fw.write(nhanVien.toString());
            }
            fw.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    // Doc data
    @Override
    public void docDataTuFile(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("dataNhanVien.txt"));
            String line;
            while((line = br.readLine()) != null){
                String[] parts = line.split(",");
                String chucVu = parts[0].trim();
                String maNV = parts[1].trim();
                String tenNV = parts[2].trim();
                String ngaySinh = parts[3].trim();
                String diaChi = parts[4].trim();
                int luong = Integer.parseInt(parts[5].trim());
                if(chucVu.equals("QuanLy")){
                    this.dsNhanVien.add(new QuanLy(maNV, tenNV, ngaySinh, diaChi, luong));
                }else if(chucVu.equals("QuanLyKho")){
                    this.dsNhanVien.add(new QuanLyKho(maNV, tenNV, ngaySinh, diaChi, luong));
                }else if(chucVu.equals("BanHang")){
                    this.dsNhanVien.add(new BanHang(maNV, tenNV, ngaySinh, diaChi, luong));
                }
            }
            br.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public void docDataTuFile(File f){
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line;
            while((line = br.readLine()) != null){
                String[] parts = line.split(",");
                String chucVu = parts[0].trim();
                String maNV = parts[1].trim();
                String tenNV = parts[2].trim();
                String ngaySinh = parts[3].trim();
                String diaChi = parts[4].trim();
                int luong = Integer.parseInt(parts[5].trim());
                if(chucVu.equals("QuanLy")){
                    this.dsNhanVien.add(new QuanLy(maNV, tenNV, ngaySinh, diaChi, luong));
                }else if(chucVu.equals("QuanLyKho")){
                    this.dsNhanVien.add(new QuanLyKho(maNV, tenNV, ngaySinh, diaChi, luong));
                }else if(chucVu.equals("BanHang")){
                    this.dsNhanVien.add(new BanHang(maNV, tenNV, ngaySinh, diaChi, luong));
                }
            }
            br.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
