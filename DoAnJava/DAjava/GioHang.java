package DAjava;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


public class GioHang{
    ArrayList<SanPham> gioHang;

    public GioHang() {
        gioHang = new ArrayList<>();
    }

    public ArrayList<SanPham> getDanhSachSP() {
        return gioHang;
    }

    public void setDanhSachSP(ArrayList<SanPham> gioHang) {
        this.gioHang = gioHang;
    }
    public void themVaoGio(SanPham sp){
        this.gioHang.add(sp);
    }
    public void themVaoGio(String maOrten){
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
                if(maSP.equals(maOrten)){
                    if(LSP.equals("SmartPhone")){
                        this.gioHang.add(new SmartPhone(maSP, tenSP, mauSac, boNho, pin, donGia));
                    }else if(LSP.equals("SmartWatch")){
                        this.gioHang.add(new SmartWatch(maSP, tenSP, mauSac, boNho, pin, donGia));
                    }else if(LSP.equals("Tablet")){
                        this.gioHang.add(new Tablet(maSP, tenSP, mauSac, boNho, pin, donGia));
                    }
                }
            }
            br.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
    public void inGioHang(){
        System.out.println("------Gio Hang------");
        for (SanPham sanPham : gioHang) {
            sanPham.xuat();
        }
        System.out.println("--------------------");
    }
    public void inTenSPvaDonGia(){
        for (SanPham sanPham : gioHang) {
            System.out.println(sanPham.getTenSP()+ "    |   "+ sanPham.getDonGia());
        }
    }

    public void xoaKhoiGioHang(int vitri){
        this.gioHang.remove(vitri);
    }
    public void xoaKhoiGioHang(String maorten){
        for (SanPham sanPham : gioHang) {
            if(sanPham.getMaSP().equals(maorten) || sanPham.getTenSP().equals(maorten)){
                this.gioHang.remove(sanPham);
            }
        }
    }
    public void xoaTatCa(){
        this.gioHang.clear();
    }

    public int tinhTien(){
        int tong = 0;
        for (SanPham sanPham : gioHang) {
            tong += sanPham.getDonGia();
        }
        return tong;
    }
    public int gioHangSize(){
        int count = 0;
        for (SanPham sanPham : gioHang) {
            count++;
        }
        return count;
    }
}
