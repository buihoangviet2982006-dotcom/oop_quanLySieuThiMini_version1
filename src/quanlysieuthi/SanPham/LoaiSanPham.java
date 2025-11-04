package quanlysieuthi.SanPham;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;


public class LoaiSanPham {

    private String MaLoai;
    private String TenLoai;
    private String MoTa;

    public LoaiSanPham() {
        this.MaLoai = "Unknown";
        this.TenLoai = "Chua xac dinh";
        this.MoTa = "Khong co mo ta";
    }
    

    public LoaiSanPham(String maLoai, String tenLoai, String moTa) {
        this.MaLoai = maLoai;
        this.TenLoai = tenLoai;
        this.MoTa = moTa;
    }
    

    public LoaiSanPham(LoaiSanPham other) {
        this.MaLoai = other.MaLoai;
        this.TenLoai = other.TenLoai;
        this.MoTa = other.MoTa;
    }

    public String getMaLoai() {
        return MaLoai;
    }
    
    public String getTenLoai() {
        return TenLoai;
    }
    
    public String getMoTa() {
        return MoTa;
    }
    
 
    public void setMaLoai(String maLoai) {
        this.MaLoai = maLoai;
    }
    
    public void setTenLoai(String tenLoai) {
        this.TenLoai = tenLoai;
    }
    
    public void setMoTa(String moTa) {
        this.MoTa = moTa;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
 
        System.out.print("Nhap Ma Loai: ");
        this.MaLoai = sc.nextLine();
        
        System.out.print("Nhap Ten Loai: ");
        this.TenLoai = sc.nextLine();
        
        System.out.print("Nhap Mo Ta: ");
        this.MoTa = sc.nextLine();
    }
    
    public void xuat() {
        System.out.printf("| %-10s | %-15s | %-25s |\n", MaLoai,TenLoai,MoTa);
    }

    // --- THEM MOI ---
    public void ghiFile(String tenFile) throws IOException {
        DataOutputStream outStream = new DataOutputStream(new FileOutputStream(tenFile, Boolean.TRUE));
        outStream.writeUTF(MaLoai);
        outStream.writeUTF(TenLoai);
        outStream.writeUTF(MoTa);
        outStream.close();
    }
}