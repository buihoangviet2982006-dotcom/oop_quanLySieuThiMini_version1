package quanlysieuthi.hoadon;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import quanlysieuthi.interfaces.INhapXuat;

public class HoaDon  implements INhapXuat{
    private String maHD;
    private String ngayTao;
    private String hinhThucTT;
    private double tongTien;
    private String maNV;
    private String maKH;

    // Constructor mặc định
    public HoaDon() {}

    // Constructor đầy đủ
    public HoaDon(String maHD,String maNV, String maKH, String ngayTao, String hinhThucTT, double tongTien) {
        this.maHD = maHD;
        this.ngayTao = ngayTao;
        this.hinhThucTT = hinhThucTT;
        this.tongTien = tongTien;
        this.maNV = maNV;
        this.maKH = maKH;
    }

    // Copy Constructor
    public HoaDon(HoaDon other) {
        this.maHD = other.maHD;
        this.ngayTao = other.ngayTao;
        this.hinhThucTT = other.hinhThucTT;
        this.tongTien = other.tongTien;
        this.maNV = other.maNV;
        this.maKH = other.maKH;
    }

    // Getter và Setter
    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getHinhThucTT() {
        return hinhThucTT;
    }

    public void setHinhThucTT(String hinhThucTT) {
        this.hinhThucTT = hinhThucTT;
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

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    // Hàm nhập
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma hoa don: ");
        maHD = sc.nextLine();
        System.out.print("Nhap ngay tao: ");
        ngayTao = sc.nextLine();
        System.out.print("Nhap hinh thuc thanh toan: ");
        hinhThucTT = sc.nextLine();
        System.out.print("Nhap tong tien: ");
        tongTien = Double.parseDouble(sc.nextLine());
        System.out.print("Nhap ma nhan vien: ");
        maNV = sc.nextLine();
        System.out.print("Nhap ma khach hang: ");
        maKH = sc.nextLine();
    }

    // Hàm xuất
    public void xuat() {
        System.out.println("----- Thong tin hoa don -----");
        System.out.println("Ma HD: " + maHD);
        System.out.println("Ma NV: " + maNV);
        System.out.println("Ma KH: " + maKH);
        System.out.println("Ngay tao: " + ngayTao);
        System.out.println("Hinh thuc thanh toan: " + hinhThucTT);
        System.out.println("Tong tien: " + String.format("%,.0f VND",tongTien ));

    }
    public void ghiFile(String tenFile) throws IOException{
        DataOutputStream outStream = new DataOutputStream(new FileOutputStream(tenFile,Boolean.TRUE));
        outStream.writeUTF(maHD);
        outStream.writeUTF(maNV);
        outStream.writeUTF(maKH);
        outStream.writeUTF(ngayTao);
        outStream.writeUTF(hinhThucTT);
        outStream.writeDouble(tongTien);

        outStream.close();
    }

}
