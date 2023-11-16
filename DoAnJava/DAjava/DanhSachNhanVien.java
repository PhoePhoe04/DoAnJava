package DAjava;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class DanhSachNhanVien {
    private ArrayList<NhanVien> dsNhanVien;

    public DanhSachNhanVien() {
        dsNhanVien = new ArrayList<>();
    }
    
    public void themNhanVien(NhanVien nhanVien) {
        dsNhanVien.add(nhanVien);
    }
    public void xuatdsNhanVien() {
        for (NhanVien nhanVien : dsNhanVien) {
            nhanVien.xuat();
        }
    }
    public void timKiemNhanVien(String maNv) {
        for (NhanVien nhanVien : dsNhanVien) {
            if (nhanVien.getMaNv().equals(maNv)) {
                nhanVien.xuat();
                return;
            }
        }

        System.out.println("Khong tim thay nhan vien co ma " + maNv);
    }

    public void suaNhanVien(String maNv) {
        for (NhanVien nhanVien : dsNhanVien) {
            if (nhanVien.getMaNv().equals(maNv)) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Nhap thong tin moi cho nhan vien co ma " + maNv + ":");

                System.out.println("Nhap ten nhan vien: ");
                nhanVien.setTenNv(sc.nextLine());

                System.out.println("Nhap ngay sinh nhan vien: ");
                nhanVien.setNgaySinh(sc.nextLine());

                System.out.println("Nhap dia chi nhan vien: ");
                nhanVien.setDiaChi(sc.nextLine());

                System.out.println("Da sua thong tin cho nhan vien co ma " + maNv);
                return;
            }
        }

        System.out.println("Khong tim thay nhan vien co ma " + maNv);
    }

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
                if(chucVu.equals("QuanLy")){
                    this.dsNhanVien.add(new QuanLy(maNV, tenNV, ngaySinh, diaChi));
                }else if(chucVu.equals("QuanLyKho")){
                    this.dsNhanVien.add(new QuanLyKho(maNV, tenNV, ngaySinh, diaChi));
                }else if(chucVu.equals("BanHang")){
                    this.dsNhanVien.add(new BanHang(maNV, tenNV, ngaySinh, diaChi));
                }
            }
            br.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    // public void ghiDataXuongFile(File f){
    //     try {
    //         OutputStream os = new FileOutputStream(f);
    //         ObjectOutputStream oos = new ObjectOutputStream(os);

    //         for (NhanVien nhanVien : dsNhanVien) {
    //             oos.writeObject(nhanVien);
    //         }

    //         oos.flush();
    //         oos.close();
    //     } catch (Exception e) {
    //         // TODO: handle exception
    //         e.printStackTrace();
    //     }
    // }
    // public void docDataTuFile(File f){
    //     try {
    //         InputStream is = new FileInputStream(f);
    //         ObjectInputStream ois = new ObjectInputStream(is);
    //         NhanVien nv = null;

    //         while(true){
    //             Object oj = ois.readObject();
    //             if(oj == null){
    //                 break;
    //             }
    //             if(oj != null){
    //                 nv = (NhanVien) oj;
    //                 this.dsNhanVien.add(nv);
    //             }
    //         }
    //         ois.close();
    //     } catch (Exception e) {
    //         // TODO: handle exception
    //     }
    // }
}
