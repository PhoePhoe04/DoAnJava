package DAjava;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Comparator;

public class Kho{
    ArrayList<SanPham> khoHang;
    Scanner sc = new Scanner(System.in);
    public Kho() {
        khoHang = new ArrayList<>();
    }

    // Thêm vào kho
    public void themVaoKho(){
        int lc = 0;

        do{
            System.out.println("Chon san pham muon them: ");
            System.out.println(
                    "1. SmartPhone.\n"
                +   "2. SmartWatch.\n"
                +   "3. Tablet.\n"
            );
            lc = sc.nextInt();
            if(lc == 1){
                SanPham sp = new SmartPhone();
                sp.nhap();
                this.khoHang.add(sp);
            }else if(lc == 2){
                SanPham sw = new SmartWatch();
                sw.nhap();
                this.khoHang.add(sw);
            }else if(lc == 3){
                SanPham tb = new Tablet();
                tb.nhap();
                this.khoHang.add(tb);
            }
        }while(lc != 0);
    }
    // các hàm xóa
    public void xoaSP(int vitri){
        this.khoHang.remove(vitri);
    }
    public void xoaSP(String maSP){
        for (SanPham sanPham : khoHang) {
            if(sanPham.getMaSP().equals(maSP)){
                this.khoHang.remove(sanPham);
            }
        }
    }
    public void clearKho(){
        this.khoHang.clear();
        System.out.println("Kho da duoc don dep!.");
    }
    // Các hàm in 
    public void inKho(){
        for (SanPham sanPham : khoHang) {
            sanPham.xuat();
        }
    }
    public void inSmartPhone(){
        System.out.println("----------Cac san pham la SmartPhone----------");
        for (SanPham sanPham : khoHang) {
            if(sanPham.getLSP().equals("SmartPhone")){
                sanPham.xuat();
            }
        }
        System.out.println("----------------------------------------------");
    }
    public void inSmartWatch(){
        System.out.println("----------Cac san pham la SmartWatch----------");
        for (SanPham sanPham : khoHang) {
            if(sanPham.getLSP().equals("SmartWatch")){
                sanPham.xuat();
            }
        }
        System.out.println("----------------------------------------------");
    }
    public void inTablet(){
        System.out.println("------------Cac san pham la Tablet------------");
        for (SanPham sanPham : khoHang) {
            if(sanPham.getLSP().equals("Tablet")){
                sanPham.xuat();
            }
        }
        System.out.println("----------------------------------------------");
    }
    // Các hàm tìm kiếm
    public void timkiemSanPham(String maOrten){
        for (SanPham sanPham : khoHang) {
            if(sanPham.getMaSP().equals(maOrten) || sanPham.getTenSP().indexOf(maOrten) >= 0){
                sanPham.xuat();
            }
        }
    }
    public void timkiemSanPham(int min, int max){
        for (SanPham sanPham : khoHang) {
            if(sanPham.getDonGia() >= min && sanPham.getDonGia() <= max){
                sanPham.xuat();
            }
        }
    }
    public void timkiemSanPhamThapDenCao(){
        Collections.sort(this.khoHang, new Comparator<SanPham>() {
            @Override
            public int compare(SanPham sp1, SanPham sp2){
                return Integer.compare(sp1.getDonGia(), sp2.getDonGia());
            }
        });
    }
    public void timkiemSanPhamCaoDenThap(){
        Collections.sort(this.khoHang, new Comparator<SanPham>() {
            @Override
            public int compare(SanPham sp1, SanPham sp2){
                return Integer.compare(sp2.getDonGia(), sp1.getDonGia());
            }
        });
    }
    // Ghi dữ liệu lên file
    public void ghiDataLenFile(File f){
        try {
            FileWriter fw = new FileWriter(f);
            for (SanPham sp : this.khoHang) {
                fw.write(sp.toString()+ "\n");
            }
            fw.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
    // Đọc dữ liệu từ file
    public void docDataTuFile(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("dataSanPham.txt"));
            String line;
            while((line = br.readLine()) != null){
                String[] parts = line.split(",");
                String LSP = parts[0].trim();
                String maSP = parts[1].trim();
                String tenSP = parts[2].trim();
                String mauSac = parts[3].trim();
                String boNho = parts[4].trim();
                String pin = parts[5].trim();
                int donGia = Integer.parseInt(parts[6].trim());
                if(LSP.equals("SmartPhone")){
                    this.khoHang.add(new SmartPhone(maSP, tenSP, mauSac, boNho, pin, donGia));
                }else if(LSP.equals("SmartWatch")){
                    this.khoHang.add(new SmartWatch(maSP, tenSP, mauSac, boNho, pin, donGia));
                }else if(LSP.equals("Tablet")){
                    this.khoHang.add(new Tablet(maSP, tenSP, mauSac, boNho, pin, donGia));
                }
            }
            br.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
