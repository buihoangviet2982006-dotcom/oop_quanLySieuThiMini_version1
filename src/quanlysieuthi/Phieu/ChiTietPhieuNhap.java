package quanlysieuthi.Phieu;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import quanlysieuthi.interfaces.INhapXuat;

public class ChiTietPhieuNhap implements INhapXuat{
    private String maPNH;
    private String maSP;
    private int soLuong;
    private double donGia;
    private double thanhTien;

    // Constructor mặc định
    public ChiTietPhieuNhap() {}

    // Constructor đầy đủ
    public ChiTietPhieuNhap(String maPNH, String maSP, int soLuong, double donGia) {
        this.maPNH = maPNH;
        this.maSP = maSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = soLuong*donGia;
    }

    // Copy constructor
    public ChiTietPhieuNhap(ChiTietPhieuNhap other) {
        this.maPNH = other.maPNH;
        this.maSP = other.maSP;
        this.soLuong = other.soLuong;
        this.donGia = other.donGia;
        this.thanhTien = other.thanhTien;
    }

    // Getter & Setter
    public String getMaPNH() {
        return maPNH;
    }

    public void setMaPNH(String maPNH) {
        this.maPNH = maPNH;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
        this.thanhTien = this.soLuong * this.donGia; // cập nhật lại thành tiền
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
        this.thanhTien = this.soLuong * this.donGia; // cập nhật lại thành tiền
    }

    public double getThanhTien() {
        return thanhTien;
    }

    // Hàm nhập
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma phieu nhap hang: ");
        maPNH = sc.nextLine();
        System.out.print("Nhap ma san pham: ");
        maSP = sc.nextLine();
        System.out.print("Nhap so luong: ");
        soLuong = Integer.parseInt(sc.nextLine());
        System.out.print("Nhap don gia: ");
        donGia = Double.parseDouble(sc.nextLine());

        thanhTien = soLuong * donGia; // tự động tính
    }

    // Hàm xuất
    public void xuat() {
        System.out.println("----- chi tiet phieu nhap -----");
        System.out.println("Ma PNH: " + maPNH);
        System.out.println("Ma SP: " + maSP);
        System.out.println("So luong: " + soLuong);
        System.out.println("Don gia: " + donGia);
        System.out.println("Thanh tien: " + thanhTien);
    }

    public void ghiFile(String tenFile) throws IOException{
        DataOutputStream outStream = new DataOutputStream(new FileOutputStream(tenFile,Boolean.TRUE));
        outStream.writeUTF(maPNH);
        outStream.writeUTF(maSP);
        outStream.writeInt(soLuong);
        outStream.writeDouble(donGia);


        outStream.close();
    }
 
}
