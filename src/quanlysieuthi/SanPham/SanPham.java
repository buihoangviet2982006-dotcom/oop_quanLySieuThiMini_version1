package quanlysieuthi.SanPham;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

public abstract class SanPham {
    private String maSP;
    private String tenSP;
    private int soLuong;
    private double donGia;
    private String xuatXu;
    private String maLoaiSP;
    private String nsx;

    // Constructor mac dinh
    public SanPham() {}

    // Constructor co tham so
    public SanPham(String maSP, String tenSP, int soLuong, double donGia,
                   String xuatXu, String maLoaiSP, String nsx) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.xuatXu = xuatXu;
        this.maLoaiSP = maLoaiSP;
        this.nsx = nsx;
    }

    // Copy constructor
    public SanPham(SanPham other) {
        this.maSP = other.maSP;
        this.tenSP = other.tenSP;
        this.soLuong = other.soLuong;
        this.donGia = other.donGia;
        this.xuatXu = other.xuatXu;
        this.maLoaiSP = other.maLoaiSP;
        this.nsx = other.nsx;
    }

    // Getter & Setter
    public String getMaSP() { return maSP; }
    public void setMaSP(String maSP) { this.maSP = maSP; }

    public String getTenSP() { return tenSP; }
    public void setTenSP(String tenSP) { this.tenSP = tenSP; }

    public int getSoLuong() { return soLuong; }
    public void setSoLuong(int soLuong) { this.soLuong = soLuong; }

    public double getDonGia() { return donGia; }
    public void setDonGia(double donGia) { this.donGia = donGia; }

    public String getXuatXu() { return xuatXu; }
    public void setXuatXu(String xuatXu) { this.xuatXu = xuatXu; }

    public String getMaLoaiSP() { return maLoaiSP; }
    public void setMaLoaiSP(String maLoaiSP) { this.maLoaiSP = maLoaiSP; }

    public String getNsx() { return nsx; }
    public void setNsx(String nsx) { this.nsx = nsx; }

    // Ham nhap
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma san pham: ");
        maSP = sc.nextLine();
        System.out.print("Nhap ten san pham: ");
        tenSP = sc.nextLine();
        System.out.print("Nhap so luong: ");
        soLuong = Integer.parseInt(sc.nextLine());
        System.out.print("Nhap don gia: ");
        donGia = Double.parseDouble(sc.nextLine());
        System.out.print("Nhap xuat xu: ");
        xuatXu = sc.nextLine();
        System.out.print("Nhap ma loai san pham: ");
        maLoaiSP = sc.nextLine();
        System.out.print("Nhap ngay san xuat: ");
        nsx = sc.nextLine();
    }

    // Ham xuat thong tin san pham
    public void xuat() {
        System.out.printf("| %-11s | %-15s | %-8d | %-15s | %-10s | %-16s | %-13s |",maSP,tenSP,soLuong,String.format("%,.0f VND",donGia),xuatXu,maLoaiSP,nsx);
    }

    public abstract void ghiFile(String tenFile) throws IOException;
    public abstract void docFile(String tenFile) throws IOException;

    protected void ghiThongTinChung(DataOutputStream out) throws IOException{
        out.writeUTF(maSP);
        out.writeUTF(tenSP);
        out.writeInt(soLuong);
        out.writeDouble(donGia);
        out.writeUTF(xuatXu);
        out.writeUTF(nsx);
    }
    protected void docThongTinChung(DataInputStream inp) throws IOException{
        maSP=inp.readUTF();
        tenSP=inp.readUTF();
        soLuong=inp.readInt();
        donGia=inp.readDouble();
        xuatXu=inp.readUTF();
        nsx=inp.readUTF();
    }
}
