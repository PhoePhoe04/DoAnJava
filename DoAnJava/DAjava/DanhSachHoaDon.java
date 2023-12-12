package DAjava;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DanhSachHoaDon implements iReaderWriter{
    private ArrayList<HoaDon> dsHD;

    public DanhSachHoaDon(){
        this.dsHD = new ArrayList<>();

    }
    
    public void themVaoDanhSach(HoaDon hd){
        this.dsHD.add(hd);
    }
    public void xoaKhoiDanhSach(int maHD){
        for (HoaDon hoaDon : dsHD) {
            if(hoaDon.getMaHD() == maHD){
                this.dsHD.remove(hoaDon);
                return;
            }
        }
        System.out.println("Khong ton tai hoa don nay.");
    }
    public void clearDS(){
        this.dsHD.clear();
    }

    public void xuat(){
        for (HoaDon hoaDon : dsHD) {
            hoaDon.xuat();
        }
    }

    @Override
    public void ghiDataXuongFile(){
        try {
            FileWriter fw = new FileWriter("dataHoaDon.txt");
            for (HoaDon hoaDon : dsHD) {
                fw.write(hoaDon.toString());
            }
            fw.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    @Override
    public void docDataTuFile(){
        Kho kho = new Kho();
        kho.docDataTuFile();
        DanhSachGioHang dsGH = new DanhSachGioHang();
        dsGH.docDataTuFile();
        DanhSachKhachHang dsKH = new DanhSachKhachHang();
        dsKH.docDataTuFile();
        DanhSachKhuyenMai dsKM = new DanhSachKhuyenMai();
        dsKM.docDataTuFile();
        DanhSachNhanVien dsNV = new DanhSachNhanVien();
        dsNV.docDataTuFile();

        try {
            BufferedReader br = new BufferedReader(new FileReader("dataHoaDon.txt"));
            String line;
            while((line = br.readLine()) != null){
                String[] parts = line.split(",");
                Date d = new SimpleDateFormat("dd/MM/yyyy H:m:s").parse(parts[1].trim());
                String maGH = parts[2].trim();
                int khachHangHash = Integer.parseInt(parts[3].trim());
                String maKM = parts[4].trim();
                String maNV = parts[5].trim();
                
                GioHang gioHang = dsGH.layGHtheoMa(maGH);
                KhachHang khachHang = dsKH.layKH(khachHangHash);
                KhuyenMai khuyenMai = dsKM.layKM(maKM);
                NhanVien nhanVien = dsNV.layNhanVien(maNV);

                this.themVaoDanhSach(new HoaDon(d, gioHang, khachHang, khuyenMai, nhanVien));
            }
            br.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
