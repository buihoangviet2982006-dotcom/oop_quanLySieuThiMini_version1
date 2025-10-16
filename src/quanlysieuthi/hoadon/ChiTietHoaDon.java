package quanlysieuthi.hoadon;

import java.util.Scanner;

public class ChiTietHoaDon {
    private String maHD;
    private String maSP;
    private int soLuong;
    private double donGia;
    private double thanhTien;

    // Constructor mặc định
    public ChiTietHoaDon() {}

    // Constructor đầy đủ
    public ChiTietHoaDon(String maHD, String maSP, int soLuong, double donGia) {
        this.maHD = maHD;
        this.maSP = maSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = soLuong * donGia; // tự động tính
    }

    // Copy constructor
    public ChiTietHoaDon(ChiTietHoaDon other) {
        this.maHD = other.maHD;
        this.maSP = other.maSP;
        this.soLuong = other.soLuong;
        this.donGia = other.donGia;
        this.thanhTien = other.thanhTien;
    }

    // Getter & Setter
    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
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
        this.thanhTien = this.soLuong * this.donGia; // cập nhật lại
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
        this.thanhTien = this.soLuong * this.donGia; // cập nhật lại
    }

    public double getThanhTien() {
        return thanhTien;
    }

    // Hàm nhập
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma hoa don: ");
        maHD = sc.nextLine();
        System.out.print("Nhap ma san pham: ");
        maSP = sc.nextLine();
        System.out.print("Nhap so luong: ");
        soLuong =Integer.parseInt(sc.nextLine());
        System.out.print("Nhap don gia");
        donGia = Double.parseDouble(sc.nextLine());

        // Tính thành tiền
        thanhTien = soLuong * donGia;
    }

    // Hàm xuất
    public void xuat() {
        System.out.println("----- Chi tiet hoa don -----");
        System.out.println("Ma HD: " + maHD);
        System.out.println("Ma SP: " + maSP);
        System.out.println("So luong: " + soLuong);
        System.out.println("Đon gia: " + donGia);
        System.out.println("Thanh tien: " + thanhTien);
    }


}

