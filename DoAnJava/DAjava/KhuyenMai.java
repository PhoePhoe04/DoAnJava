package DAjava;

import java.util.Scanner;

public class KhuyenMai implements iNhapXuat{
    private String maKM;
    private String tenKM;
    private int dkKM;
    private double giaTriKM;

    Scanner sc = new Scanner(System.in);

    public KhuyenMai(){}
    public KhuyenMai(String maKM, String tenKM, int dkKM, double giaTriKM){
        this.maKM = maKM;
        this.tenKM = tenKM;
        this.dkKM = dkKM;
        this.giaTriKM = giaTriKM;
    }
    
    public int getDKKM(){
        return this.dkKM;
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
    public void setDKKM(int dKKM){
        this.dkKM = dKKM;
    }

    @Override
    public void nhap(){
        System.out.print("Nhap vao ma khuyen mai: ");
        this.maKM = sc.nextLine();
        System.out.print("Nhap vao ten khuyen mai: ");
        this.tenKM = sc.nextLine();
        System.out.print("Nhap vao dieu kien khuyen mai: ");
        this.dkKM = sc.nextInt();
        System.out.print("Nhap vao gia tri khuyen mai: ");
        this.giaTriKM = sc.nextDouble();
    }

    @Override
    public void xuat(){
        System.out.println("maKM: "+ this.maKM+ " tenKM: "+ this.tenKM+ " dkKM: "+ this.dkKM+ " giaTriKM: "+ this.giaTriKM);
    }
    @Override
    public String toString(){
        return this.maKM+ ", "+ this.tenKM + ", "+ this.dkKM+ ", "+ this.giaTriKM+ "\n";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((maKM == null) ? 0 : maKM.hashCode());
        result = prime * result + ((tenKM == null) ? 0 : tenKM.hashCode());
        result = prime * result + dkKM;
        long temp;
        temp = Double.doubleToLongBits(giaTriKM);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((sc == null) ? 0 : sc.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        KhuyenMai other = (KhuyenMai) obj;
        if (maKM == null) {
            if (other.maKM != null)
                return false;
        } else if (!maKM.equals(other.maKM))
            return false;
        if (tenKM == null) {
            if (other.tenKM != null)
                return false;
        } else if (!tenKM.equals(other.tenKM))
            return false;
        if (dkKM != other.dkKM)
            return false;
        if (Double.doubleToLongBits(giaTriKM) != Double.doubleToLongBits(other.giaTriKM))
            return false;
        if (sc == null) {
            if (other.sc != null)
                return false;
        } else if (!sc.equals(other.sc))
            return false;
        return true;
    } 
}
