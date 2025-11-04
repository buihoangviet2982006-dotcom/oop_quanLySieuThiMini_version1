package quanlysieuthi.SanPham;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;


public class HangSanXuat {

    private String MaHang;
    private String TenHang;
    private String DiaChi;
    private String LienHe;      
    private String NamThanhLap; 
    

    public HangSanXuat() {
        this.MaHang = "HSX000";
        this.TenHang = "Chua xac dinh";
        this.DiaChi = "Khong ro";
        this.LienHe = "0000000000";
        this.NamThanhLap = "1900";
    }
    

    public HangSanXuat(String maHang, String tenHang, String diaChi, String lienHe, String namThanhLap) {
        this.MaHang = maHang;
        this.TenHang = tenHang;
        this.DiaChi = diaChi;
        this.LienHe = lienHe;
        this.NamThanhLap = namThanhLap;
    }
    

    public HangSanXuat(HangSanXuat other) {
        this.MaHang = other.MaHang;
        this.TenHang = other.TenHang;
        this.DiaChi = other.DiaChi;
        this.LienHe = other.LienHe;
        this.NamThanhLap = other.NamThanhLap;
    }
    
  
    public String getMaHang() {
        return MaHang;
    }
    
    public String getTenHang() {
        return TenHang;
    }
    
    public String getDiaChi() {
        return DiaChi;
    }
    
    public String getLienHe() {
        return LienHe;
    }
    
    public String getNamThanhLap() {
        return NamThanhLap;
    }
    
  
    public void setMaHang(String maHang) {
        this.MaHang = maHang;
    }
    
    public void setTenHang(String tenHang) {
        this.TenHang = tenHang;
    }
    
    public void setDiaChi(String diaChi) {
        this.DiaChi = diaChi;
    }
    
    public void setLienHe(String lienHe) {
        LienHe = lienHe;
    }
    
    public void setNamThanhLap(String namThanhLap) {
        NamThanhLap = namThanhLap;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("--- NHAP THONG TIN HANG SAN XUAT ---");
        
        System.out.print("Nhap Ma Hang: ");
        this.MaHang = sc.nextLine();
        
        System.out.print("Nhap Ten Hang: ");
        this.TenHang = sc.nextLine();
        
        System.out.print("Nhap Dia Chi: ");
        this.DiaChi = sc.nextLine();
        
        System.out.print("Nhap Thong Tin Lien He (SDT/Email): ");
        this.LienHe = sc.nextLine();
        
        System.out.print("Nhap Nam Thanh Lap: ");
        this.NamThanhLap = sc.nextLine();
    }

    public void xuat() {
        System.out.println("--- THONG TIN HANG SAN XUAT ---");
        System.out.println("Ma Hang: " + MaHang);
        System.out.println("Ten Hang: " + TenHang);
        System.out.println("Dia Chi: " + DiaChi);
        System.out.println("Lien He: " + LienHe);
        System.out.println("Nam Thanh Lap: " + NamThanhLap);
    }

    // --- THEM MOI ---
    public void ghiFile(String tenFile) throws IOException {
        DataOutputStream outStream = new DataOutputStream(new FileOutputStream(tenFile, Boolean.TRUE));
        outStream.writeUTF(MaHang);
        outStream.writeUTF(TenHang);
        outStream.writeUTF(DiaChi);
        outStream.writeUTF(LienHe);
        outStream.writeUTF(NamThanhLap);
        outStream.close();
    }
}