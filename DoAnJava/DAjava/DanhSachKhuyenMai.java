package DAjava;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class DanhSachKhuyenMai implements iReaderWriter {
    private ArrayList<KhuyenMai> dsKM;

    public DanhSachKhuyenMai(){
        this.dsKM = new ArrayList<>();
    }

    //  Thêm vào danh sách
    public void themVaoDanhSach(KhuyenMai KM){
        this.dsKM.add(KM);
    }
    // Xóa khỏi danh sách
    public void xoaKhoiDanhSach(String maKM){
        for (KhuyenMai khuyenMai : dsKM) {
            if(khuyenMai.getMaKM().equals(maKM)){
                this.dsKM.remove(khuyenMai);
                return;
            }
        }
        System.out.println("Khong tim thay ma khuyen mai !");
    }
    public void clearDanhSach(){
        this.dsKM.clear();
    }
    //  Sửa danh sách
    public void suaKhuyenMai(String maKM){
        for (KhuyenMai khuyenMai : dsKM) {
            if(khuyenMai.getMaKM().equals(maKM)){
                KhuyenMai KMnew = new KhuyenMai();
                KMnew.nhap();
                khuyenMai = KMnew;
                return;
            }
        }
        System.out.println("Khong tim thay ma khuyen mai !");
    }
    //  In danh sách
    public void inDanhSach(){
        for (KhuyenMai khuyenMai : dsKM) {
            khuyenMai.xuat();
        }
    }
    //  Get
    public KhuyenMai layKM(int dkKM){
        if (dkKM > 5) {
            return layKM("KM5");
        }
        for (KhuyenMai khuyenMai : dsKM) {
            if(khuyenMai.getDKKM() == dkKM){
                return khuyenMai;
            }
        }
        return null;
    }
    public KhuyenMai layKM(String maKM){
        for (KhuyenMai khuyenMai : dsKM) {
            if(khuyenMai.getMaKM().equals(maKM)){
                return khuyenMai;
            }
        }
        return null;
    }
    // Ghi data
    @Override
    public void ghiDataXuongFile(){
        try {
            FileWriter fw = new FileWriter("dataKhuyenMai.txt");
            for (KhuyenMai khuyenMai : dsKM) {
                fw.write(khuyenMai.toString());
            }
            fw.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public void ghiDataXuongFile(File f){
        try {
            FileWriter fw = new FileWriter(f);
            for (KhuyenMai khuyenMai : dsKM) {
                fw.write(khuyenMai.toString());
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
            BufferedReader br = new BufferedReader(new FileReader("dataKhuyenMai.txt"));
            String line;
            while((line = br.readLine()) != null){
                String[] parts = line.split(",");
                String maKM = parts[0].trim();
                String tenKM = parts[1].trim();
                int dkKM = Integer.parseInt(parts[2].trim());
                double  giaTriKM = Double.parseDouble(parts[3].trim());
                this.dsKM.add(new KhuyenMai(maKM, tenKM, dkKM, giaTriKM));
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
                String maKM = parts[0].trim();
                String tenKM = parts[1].trim();
                int dkKM = Integer.parseInt(parts[2].trim());
                double  giaTriKM = Double.parseDouble(parts[3].trim());
                this.dsKM.add(new KhuyenMai(maKM, tenKM, dkKM, giaTriKM));
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
