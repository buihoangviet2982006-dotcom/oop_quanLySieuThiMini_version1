package quanlysieuthi.Nguoi;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import quanlysieuthi.interfaces.INhapXuat;

public class NhanVien implements INhapXuat{
    private String maNV;
    private String ho;
    private String ten;
    private String gioiTinh;
    private String maChucVu;
    private String sdt;
    private String diaChi;
    private String email;
    private double luong;


    public NhanVien() {
    }


    public NhanVien(String maNV, String ho, String ten, String gioiTinh,
                    String maChucVu, String sdt, String diaChi,
                    String email, double luong) {
        this.maNV = maNV;
        this.ho = ho;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.maChucVu = maChucVu;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.email = email;
        this.luong = luong;
    }


    public NhanVien(NhanVien other) {
        this.maNV = other.maNV;
        this.ho = other.ho;
        this.ten = other.ten;
        this.gioiTinh = other.gioiTinh;
        this.maChucVu = other.maChucVu;
        this.sdt = other.sdt;
        this.diaChi = other.diaChi;
        this.email = other.email;
        this.luong = other.luong;
    }


    public String getMaNV() { return maNV; }
    public void setMaNV(String maNV) { this.maNV = maNV; }

    public String getHo() { return ho; }
    public void setHo(String ho) { this.ho = ho; }

    public String getTen() { return ten; }
    public void setTen(String ten) { this.ten = ten; }

    public String getGioiTinh() { return gioiTinh; }
    public void setGioiTinh(String gioiTinh) { this.gioiTinh = gioiTinh; }

    public String getMaChucVu() { return maChucVu; }
    public void setMaChucVu(String maChucVu) { this.maChucVu = maChucVu; }

    public String getSdt() { return sdt; }
    public void setSdt(String sdt) { this.sdt = sdt; }

    public String getDiaChi() { return diaChi; }
    public void setDiaChi(String diaChi) { this.diaChi = diaChi; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public double getLuong() { return luong; }
    public void setLuong(double luong) { this.luong = luong; }


    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã NV: ");
        maNV = sc.nextLine();
        System.out.print("Nhập họ: ");
        ho = sc.nextLine();
        System.out.print("Nhập tên: ");
        ten = sc.nextLine();
        System.out.print("Nhập giới tính: ");
        gioiTinh = sc.nextLine();
        System.out.print("Nhập mã chức vụ: ");
        maChucVu = sc.nextLine();
        System.out.print("Nhập số điện thoại: ");
        sdt = sc.nextLine();
        System.out.print("Nhập địa chỉ: ");
        diaChi = sc.nextLine();
        System.out.print("Nhập email: ");
        email = sc.nextLine();
        System.out.print("Nhập lương: ");
        luong = Double.parseDouble(sc.nextLine());
    }


    public void xuat() {
        System.out.printf("| %-10s | %-10s | %-10s | %-8s | %-10s | %-12s | %-15s | %-20s | %-10.2f |\n",
                          maNV, ho, ten, gioiTinh, maChucVu, sdt, diaChi, email, luong);
    }

    // --- THEM MOI ---
    public void ghiFile(String tenFile) throws IOException {
        DataOutputStream outStream = new DataOutputStream(new FileOutputStream(tenFile, Boolean.TRUE));
        outStream.writeUTF(maNV);
        outStream.writeUTF(ho);
        outStream.writeUTF(ten);
        outStream.writeUTF(gioiTinh);
        outStream.writeUTF(maChucVu);
        outStream.writeUTF(sdt);
        outStream.writeUTF(diaChi);
        outStream.writeUTF(email);
        outStream.writeDouble(luong);
        outStream.close();
    }
}