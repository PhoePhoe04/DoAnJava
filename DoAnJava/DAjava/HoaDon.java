package DAjava;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class HoaDon{
    private Date d;
    private int maHD;
    private GioHang gioHang;
    private KhachHang khachHang;
    private KhuyenMai khuyenMai;
    private NhanVien nhanVien;
    private DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    
    public HoaDon(){
        // this.d = new Date(System.currentTimeMillis());
    };
    public HoaDon(GioHang gioHang, KhachHang khachHang, KhuyenMai khuyenMai, NhanVien nhanVien){
        this.d = new Date();
        this.maHD = khachHang.getTenKh().hashCode() + khachHang.getSDT().hashCode();
        this.maHD *= this.maHD < 0 ? -1 : 1;
        this.gioHang = gioHang;
        this.khachHang =khachHang;
        this.khuyenMai = khuyenMai;
        this.nhanVien = nhanVien;
    }
    public HoaDon(Date d, GioHang gioHang, KhachHang khachHang, KhuyenMai khuyenMai, NhanVien nhanVien){
        this.d = d;
        this.maHD = khachHang.getTenKh().hashCode() + khachHang.getSDT().hashCode();
        this.maHD *= this.maHD < 0 ? -1 : 1;
        this.gioHang = gioHang;
        this.khachHang =khachHang;
        this.khuyenMai = khuyenMai;
        this.nhanVien = nhanVien;
    }

    public int getMaHD(){
        return this.maHD;
    }
    public GioHang getGioHang(){
        return this.gioHang;
    }
    public KhachHang getKH(){
        return this.khachHang;
    }
    public KhuyenMai getKM(){
        return this.khuyenMai;
    }
    public NhanVien getNhanVien(){
        return this.nhanVien;
    }

    public static int apDungUuDai(int tong, double giaTriKM){
        return (int) (tong - tong*giaTriKM);
    }

    public void xuat(){
        System.out.println("----Hoa don----");
        System.out.println("Ma hoa don: "+ this.maHD);
        System.out.println("Thoi gian: "+ df.format(this.d));
        System.out.println("================= HOA DON =================");
        gioHang.inTenSPvaDonGia();
        System.out.println("===========================================");
        System.out.println("Ban nhan duoc uu dai "+ khuyenMai.getMaKM());
        System.out.println("Tong tien : "+ gioHang.tinhTien());
        System.out.println("Sau khi nhan ap dung uu dai giam "+ khuyenMai.getGiaTriKM()*100+ " Tong tien: "+ HoaDon.apDungUuDai(gioHang.tinhTien(), khuyenMai.getGiaTriKM()));
        System.out.println("Chiu trach nhiem hoa don: "+ this.nhanVien.getTenNv());
        System.out.println();
        System.out.println("Cam on quy khach "+ this.khachHang.getTenKh()+ " da mua san pham cua chung toi.\n");
    }

    @Override
    public String toString(){
        return this.maHD+ ", "+ df.format(d)+ ", "+this.gioHang.getMaGH()+ ", "+ this.khachHang.hashCode()+ ", "+ this.khuyenMai.getMaKM()+ ", "+ this.nhanVien.getMaNv()+ "\n";
    }
}
