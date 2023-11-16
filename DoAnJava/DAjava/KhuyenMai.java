package DAjava;

public class KhuyenMai {
    private String maKM;
    private String tenKM;
    private int dkKM;
    private double giaTriKM;


    public KhuyenMai(){}
    public KhuyenMai(int dkKM){
        this.maKM = "FIRST";
        this.tenKM = "Mua hang lan dau.";
        this.dkKM = dkKM;
        if(dkKM > 5){
            this.giaTriKM = 0.2;
        }else if(dkKM > 2){
            this.giaTriKM = 0.15;
        }else if(dkKM > 1){
            this.giaTriKM = 0.1;
        }else{
            this.dkKM = 0;
        }
    }
    
    public String getMaKM() {
        return this.maKM;
    }
    public String getTenKM() {
        return this.tenKM;
    }
    public double getGiaTriKM() {
        return this.giaTriKM;
    }
    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }
    public void setTenKM(String tenKM) {
        this.tenKM = tenKM;
    }
    public void setGiaTriKM(int giaTriKM) {
        this.giaTriKM = giaTriKM;
    }

}
