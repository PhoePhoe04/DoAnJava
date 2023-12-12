package DAjava;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Comparator;

public class Kho implements iReaderWriter{
    ArrayList<SanPham> khoHang;
    Scanner sc = new Scanner(System.in);
    public Kho() {
        khoHang = new ArrayList<>();
    }

    // Check
    public boolean checkMaSPDaCo(String maSP){
        for (SanPham sanPham : khoHang) {
            if(sanPham.getMaSP().equals(maSP)){
                return true;
            }
        }
        return false;
    }

    // Thêm vào kho
    public void themVaoKho(){
        int lc;

        do{
            System.out.println("Chon san pham muon them: ");
            System.out.println(
                    "1. SmartPhone.\n"
                +   "2. SmartWatch.\n"
                +   "3. Tablet.\n"
                +   "0. Thoat.\n"
            );
            System.out.print("Nhap lua chon: ");

            try {
                lc = sc.nextInt();
                System.out.println();
            } catch (Exception e) {
                System.out.println("Xin vui long nhap vao mot so nguyen.\n");
                sc.next();
                lc = -1;
            }
            
            if(lc == 1){
                SanPham sp = new SmartPhone();
                sp.nhap();
                System.out.println();
                if(checkMaSPDaCo(sp.getMaSP())){
                    System.out.println("Ma san pham da ton tai trong kho.\n");
                }else{
                    this.khoHang.add(sp);
                }
            }else if(lc == 2){
                SanPham sw = new SmartWatch();
                sw.nhap();
                System.out.println();
                if(checkMaSPDaCo(sw.getMaSP())){
                    System.out.println("Ma san pham da ton tai trong kho.\n");
                }else{
                    this.khoHang.add(sw);
                }
            }else if(lc == 3){
                SanPham tb = new Tablet();
                tb.nhap();
                System.out.println();
                if(checkMaSPDaCo(tb.getMaSP())){
                    System.out.println("Ma san pham da ton tai trong kho.\n");
                }else{
                    this.khoHang.add(tb);
                }
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
        System.out.println("Kho da duoc don dep !");
    }
    // Các hàm in 
    public void inKho(){
        System.out.println("========================================================= Kho =========================================================\n");
        System.out.printf("%-20s%-15s%-40s%-15s%-10s%-10s%s\n","LSP","Ma San Pham","Ten San Pham","Mau Sac","Bo Nho", "PIN", "Don Gia");
        System.out.println();
        for (SanPham sanPham : khoHang) {
            sanPham.xuat();
        }
        System.out.println("=======================================================================================================================\n");
    }
    public void inSmartPhone(){
        System.out.println("============================================== Cac san pham la SmartPhone =============================================\n");
        System.out.printf("%-20s%-15s%-40s%-15s%-10s%-10s%s\n","LSP","Ma San Pham","Ten San Pham","Mau Sac","Bo Nho", "PIN", "Don Gia");
        for (SanPham sanPham : khoHang) {
            if(sanPham.getLSP().equals("SmartPhone")){
                sanPham.xuat();
            }
        }
        System.out.println("=======================================================================================================================\n");
    }
    public void inSmartWatch(){
        System.out.println("============================================== Cac san pham la SmartWatch =============================================\n");
        System.out.printf("%-20s%-15s%-40s%-15s%-10s%-10s%s\n","LSP","Ma San Pham","Ten San Pham","Mau Sac","Bo Nho", "PIN", "Don Gia");
        for (SanPham sanPham : khoHang) {
            if(sanPham.getLSP().equals("SmartWatch")){
                sanPham.xuat();
            }
        }
        System.out.println("=======================================================================================================================\n");
    }
    public void inTablet(){
        System.out.println("================================================ Cac san pham la Tablet ===============================================\n");
        System.out.printf("%-20s%-15s%-40s%-15s%-10s%-10s%s\n","LSP","Ma San Pham","Ten San Pham","Mau Sac","Bo Nho", "PIN", "Don Gia");
        for (SanPham sanPham : khoHang) {
            if(sanPham.getLSP().equals("Tablet")){
                sanPham.xuat();
            }
        }
        System.out.println("=======================================================================================================================\n");
    }
    // Các hàm tìm kiếm
    public void timkiemSanPham(String maOrten){
        System.out.printf("%-20s%-15s%-40s%-15s%-10s%-10s%s\n","LSP","Ma San Pham","Ten San Pham","Mau Sac","Bo Nho", "PIN", "Don Gia");
        System.out.println();
        for (SanPham sanPham : khoHang) {
            if(sanPham.getMaSP().equals(maOrten) || sanPham.getTenSP().toLowerCase().indexOf(maOrten.toLowerCase()) >= 0){
                sanPham.xuat();
            }
        }
    }
    public void timkiemSanPham(int min, int max){
        System.out.printf("%-20s%-15s%-40s%-15s%-10s%-10s%s\n","LSP","Ma San Pham","Ten San Pham","Mau Sac","Bo Nho", "PIN", "Don Gia");
        System.out.println();
        if(min >= 0 && max >= 0){
            for (SanPham sanPham : khoHang) {
                if(sanPham.getDonGia() >= min && sanPham.getDonGia() <= max){
                    sanPham.xuat();
                }
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
    
    public SanPham laySPtheoMa(String maSP){
        for (SanPham sanPham : khoHang) {
            if(sanPham.getMaSP().equals(maSP)){
                if(sanPham.getLSP().equals("SmartPhone")){
                    SanPham sp = new SmartPhone();
                    sp = (SmartPhone) sanPham;
                    return sp;
                }else if(sanPham.getLSP().equals("SmartWatch")){
                    SanPham sw = new SmartWatch();
                    sw = (SmartWatch) sanPham;
                    return sw;
                }else if(sanPham.getLSP().equals("Tablet")){
                    SanPham tb = new Tablet();
                    tb = (Tablet) sanPham;
                    return tb;
                }
            }
        }
        return null;
    }
    // Ghi dữ liệu lên file
    @Override
    public void ghiDataXuongFile(){
        try {
            FileWriter fw = new FileWriter("dataSanPham.txt");
            for (SanPham sp : this.khoHang) {
                fw.write(sp.toString()+ "\n");
            }
            fw.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
    public void ghiDataXuongFile(File f){
        try {
            FileWriter fw = new FileWriter(f);
            for (SanPham sanPham : khoHang) {
                fw.write(sanPham.toString()+ "\n");
            }
            fw.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    // Đọc dữ liệu từ file
    @Override
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
    public void docDataTuFile(File f){
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
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
