package quanlysieuthi.Nguoi;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import quanlysieuthi.interfaces.INhapXuat;

public class KhachHang implements INhapXuat{
    private String maKH;
    private String ho;
    private String ten;
    private String gioiTinh;
    private String sdt;
    private String diaChi;
    private String email;


    public KhachHang() {
    }

    public KhachHang(String maKH, String ho, String ten, String gioiTinh,
                     String sdt, String diaChi, String email) {
        this.maKH = maKH;
        this.ho = ho;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.email = email;
    }
    public KhachHang(KhachHang other) {
        this.maKH = other.maKH;
        this.ho = other.ho;
        this.ten = other.ten;
        this.gioiTinh = other.gioiTinh;
        this.sdt = other.sdt;
        this.diaChi = other.diaChi;
        this.email = other.email;
    }
    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã KH: ");
        maKH = sc.nextLine();
        System.out.print("Nhập họ: ");
        ho = sc.nextLine();
        System.out.print("Nhập tên: ");
        ten = sc.nextLine();
        System.out.print("Nhập giới tính: ");
        gioiTinh = sc.nextLine();
        System.out.print("Nhập số điện thoại: ");
        sdt = sc.nextLine();
        System.out.print("Nhập địa chỉ: ");
        diaChi = sc.nextLine();
        System.out.print("Nhập email: ");
        email = sc.nextLine();
    }


    public void xuat() {
        System.out.printf("| %-10s | %-10s | %-10s | %-10s | %-12s | %-15s | %-20s |\n",
                          maKH, ho, ten, gioiTinh, sdt, diaChi, email);
    }

    // --- THEM MOI ---
    public void ghiFile(String tenFile) throws IOException {
        DataOutputStream outStream = new DataOutputStream(new FileOutputStream(tenFile, Boolean.TRUE));
        outStream.writeUTF(maKH);
        outStream.writeUTF(ho);
        outStream.writeUTF(ten);
        outStream.writeUTF(gioiTinh);
        outStream.writeUTF(sdt);
        outStream.writeUTF(diaChi);
        outStream.writeUTF(email);
        outStream.close();
    }
}