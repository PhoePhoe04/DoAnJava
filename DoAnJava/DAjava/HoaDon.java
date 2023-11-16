package DAjava;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class HoaDon {
    private Date d;
    private int maHD;
    private GioHang gioHang;
    private KhachHang khachHang;
    private KhuyenMai khuyenMai;
    private NhanVien nhanVien;

    public HoaDon(){};
    public HoaDon(GioHang gioHang, KhachHang khachHang, KhuyenMai khuyenMai, NhanVien nhanVien){
        this.d = new Date(System.currentTimeMillis());
        this.maHD = khachHang.getTenKh().hashCode();
        if(this.maHD < 0){
            this.maHD *= -1;
        }
        this.gioHang = gioHang;
        this.khachHang =khachHang;
        this.khuyenMai = khuyenMai;
        this.nhanVien = nhanVien;
    }
    
    public static int apDungUuDai(int tong, double giaTriKM){
        return (int) (tong - tong*giaTriKM);
    }
    public void inHoaDon(){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd H:m:s");
        System.out.println("----Hoa don----");
        System.out.println("Thoi gian: "+ df.format(d));
        System.out.println("Ma hoa don: "+ maHD);
        System.out.println("-----------------------------------");
        gioHang.inTenSPvaDonGia();
        System.out.println("-----------------------------------");
        System.out.println("Ban nhan duoc uu dai "+ khuyenMai.getMaKM() + " khi mua hang lan dau ben chung toi.");
        System.out.println("Tong tien : "+ gioHang.tinhTien());
        System.out.println("Sau khi nhan ap dung uu dai giam "+ khuyenMai.getGiaTriKM()*100+ " Tong tien: "+ HoaDon.apDungUuDai(gioHang.tinhTien(), khuyenMai.getGiaTriKM()));
        System.out.println();
        System.out.println("Cam on quy khach "+ this.khachHang.getTenKh()+ " da mua san pham cua chung toi.");
    }
}
