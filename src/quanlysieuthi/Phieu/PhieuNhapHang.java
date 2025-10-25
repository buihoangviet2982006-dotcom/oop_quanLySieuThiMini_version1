package quanlysieuthi.Phieu;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import quanlysieuthi.interfaces.INhapXuat;

public class PhieuNhapHang implements INhapXuat{
    private String maPNH;
    private String ngayNhap;
    private String maNCC;
    private double tongTien;
    private String maNV;

    // Constructor mặc định
    public PhieuNhapHang() {}

    // Constructor đầy đủ
    public PhieuNhapHang(String maPNH,  String maNCC,String maNV,String ngayNhap, double tongTien ) {
        this.maPNH = maPNH;
        this.ngayNhap = ngayNhap;
        this.maNCC = maNCC;
        this.tongTien = tongTien;
        this.maNV = maNV;
    }

    // Copy constructor
    public PhieuNhapHang(PhieuNhapHang other) {
        this.maPNH = other.maPNH;
        this.ngayNhap = other.ngayNhap;
        this.maNCC = other.maNCC;
        this.tongTien = other.tongTien;
        this.maNV = other.maNV;
    }

    // Getter & Setter
    public String getMaPNH() {
        return maPNH;
    }

    public void setMaPNH(String maPNH) {
        this.maPNH = maPNH;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    // Hàm nhập
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma phieu nhap hang: ");
        maPNH = sc.nextLine();
        System.out.print("Nhap ngay nhap: ");
        ngayNhap = sc.nextLine();
        System.out.print("Nhap ma nha cung cap: ");
        maNCC = sc.nextLine();
        System.out.print("Nhap tong tien: ");
        tongTien = Double.parseDouble(sc.nextLine());
        System.out.print("Nhap ma nhan vien: ");
        maNV = sc.nextLine();
    }

    // Hàm xuất
    public void xuat() {
        System.out.println("----- Thong tin phieu nhap hang -----");
        System.out.println("Ma PNH: " + maPNH);
        System.out.println("Ma nha cung cap: " + maNCC);
        System.out.println("Ma nhan vien: " + maNV);
        System.out.println("Ngay nhap: " + ngayNhap);
        System.out.println("Tong tien: " + String.format("%,.0f VND", tongTien));

    }

    public void ghiFile(String tenFile) throws IOException{
        DataOutputStream outStream = new DataOutputStream(new FileOutputStream(tenFile,Boolean.TRUE));
        outStream.writeUTF(maPNH);
        outStream.writeUTF(maNCC);
        outStream.writeUTF(maNV);
        outStream.writeUTF(ngayNhap);
        outStream.writeDouble(tongTien);

        outStream.close();
    }

}

