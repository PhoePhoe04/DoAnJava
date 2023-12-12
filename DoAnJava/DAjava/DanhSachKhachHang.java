package DAjava;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DanhSachKhachHang implements iReaderWriter{
    private ArrayList<KhachHang> dsKhachHang;
    Scanner sc = new Scanner(System.in);
    public DanhSachKhachHang(){
        dsKhachHang=new ArrayList<>();
    }

    // Check
    public boolean checkKhachHang(KhachHang kh){
        for (KhachHang khachHang : dsKhachHang) {
            if(khachHang.equals(kh)){
                return true;
            }
        }
        return false;
    }

    // Thêm khách hàng
    public void themKhachHang(KhachHang khachHang) {
        dsKhachHang.add(khachHang);
    }
    // Xuất danh sách
    public void xuatdsKhachHang() {
        for (KhachHang khachHang : dsKhachHang) {
            khachHang.xuat();
        }
    }
    //  Tìm kiếm
    // public void timKiemKhachHang(String tenKh) {
    //     boolean flag = true;
    //     for (KhachHang khachHang : dsKhachHang) {
    //         if (khachHang.getTenKh().toLowerCase().contains(tenKh.toLowerCase())) {
    //             khachHang.xuat();
    //             flag = false;
    //         }
    //     }
    //     if(flag) System.out.println("Khong co khach hang mang ten : "+ tenKh);
    // }
    public void timKiemKhachHang(String tenKH){
        for (KhachHang khachHang : dsKhachHang) {
            String[] fullName = khachHang.getTenKh().split(" ");
            if(fullName[fullName.length-1].toLowerCase().equals(tenKH.toLowerCase())){
                khachHang.xuat();
            }else{
                continue;
            }
        }
    }
    //  Sửa khách hàng
    public void suaKhachHang(int hashCode) {
        for (KhachHang khachHang : dsKhachHang) {
            if(khachHang.hashCode() == hashCode){
                System.out.println("Nhap lai thong tin cho khach hang.");
                System.out.print("Nhap vao ten: ");
                khachHang.setTenKh(sc.nextLine());
                System.out.print("Nhap vao dia chi: ");
                khachHang.setDiaChi(sc.nextLine());
                System.out.print("Nhap vao SDT: ");
                khachHang.setSDT(sc.nextLine());
            }
        }
    }
    //  Xóa khách hàng
    public void xoaKhachHang(String tenKh) {
        for (int i = 0; i < dsKhachHang.size(); i++) {
            KhachHang khachHang = dsKhachHang.get(i);
            if (khachHang.getTenKh().equals(tenKh)) {
                dsKhachHang.remove(i);
                System.out.println("Da xoa khach hang co ten " + tenKh);
                return;
            }
        }

        System.out.println("Khong tim thay khach hang co ten " + tenKh);
    }
    public void clearDanhSach(){
        this.dsKhachHang.clear();
    }

    // Các phương thức Override
    @Override
    public void ghiDataXuongFile(){
        try {
            FileWriter fw = new FileWriter("dataKhachHang.txt");
            for (KhachHang khachHang : dsKhachHang) {
                fw.write(khachHang.toString());
            }
            fw.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void ghiDataXuongFile(File f){
        try {
            FileWriter fw = new FileWriter(f);
            for (KhachHang khachHang : dsKhachHang) {
                fw.write(khachHang.toString());
            }
            fw.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void docDataTuFile(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("dataKhachHang.txt"));
            String line;
            while((line = br.readLine()) != null){
                String[] parts = line.split(",");
                String tenKh = parts[1].trim();
                String diaChi = parts[2].trim();
                String SDT = parts[3].trim();
                this.dsKhachHang.add(new KhachHang(tenKh, diaChi, SDT));
            }
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
                String tenKh = parts[1].trim();
                String diaChi = parts[2].trim();
                String SDT = parts[3].trim();
                this.dsKhachHang.add(new KhachHang(tenKh, diaChi, SDT));
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public KhachHang layKH(int hashKH){
        for (KhachHang khachHang : dsKhachHang) {
            if(khachHang.hashCode() == hashKH){
                return (KhachHang)khachHang;
            }
        }
        return null;
    }

}
