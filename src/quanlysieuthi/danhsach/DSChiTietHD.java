package quanlysieuthi.danhsach;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import quanlysieuthi.hoadon.ChiTietHoaDon;

public class DSChiTietHD {
    private ChiTietHoaDon[] danhSachCTHD;

    // Constructor
    public DSChiTietHD() {
        danhSachCTHD = new ChiTietHoaDon[0];
    }

    // Getter
    public int getSoLuong() {
        return danhSachCTHD.length;
    }

    public ChiTietHoaDon getChiTietHD(int i) {
        if (i >= 0 && i < danhSachCTHD.length) {
            return danhSachCTHD[i];
        }
        return null;
    }

    public double getTongTien(String maHD){
        double tongTien = 0;
        for(int i=0;i<danhSachCTHD.length;i++){
            if(maHD.equals(danhSachCTHD[i].getMaHD())){
                tongTien+=danhSachCTHD[i].getThanhTien();
            }
        }
        return tongTien;
    }
    public ChiTietHoaDon timTheoMa(String maHD) {
        for (int i = 0; i < danhSachCTHD.length; i++) {
            if (danhSachCTHD[i].getMaHD().equalsIgnoreCase(maHD)) {
                return danhSachCTHD[i];
            }
        }
        return null;
    }

    public void them() {
        Scanner sc = new Scanner(System.in);
        System.out.print("So luong chi tiet hoa don can them: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            boolean hopLe = false;
            while (!hopLe) {
                System.out.println("\nNhap chi tiet hoa don thu " + (danhSachCTHD.length + 1) + ":");
                ChiTietHoaDon cthd = new ChiTietHoaDon();
                cthd.nhap();
                if (timTheoMa(cthd.getMaHD()) != null) {
                    System.out.println("MaHD da ton tai! Moi nhap lai.");
                } else {
                    ChiTietHoaDon[] newArr = new ChiTietHoaDon[danhSachCTHD.length + 1];
                    for (int j = 0; j < danhSachCTHD.length; j++) {
                        newArr[j] = danhSachCTHD[j];
                    }
                    newArr[danhSachCTHD.length] = cthd;
                    danhSachCTHD = newArr;
                    hopLe = true;
                }
            }
        }
        System.out.println("Them thanh cong");
    }

    public void them(ChiTietHoaDon cthd) {
        ChiTietHoaDon[] newArr = new ChiTietHoaDon[danhSachCTHD.length + 1];
        for (int i = 0; i < danhSachCTHD.length; i++) {
            newArr[i] = danhSachCTHD[i];
        }
        newArr[danhSachCTHD.length] = cthd;
        danhSachCTHD = newArr;
    }

    public void xuat() {
        if (danhSachCTHD.length == 0) {
            System.out.println("Danh sach chi tiet hoa don rong.");
            return;
        }
        System.out.println("\nDanh sach chi tiet hoa don");
        for (int i = 0; i < danhSachCTHD.length; i++) {
            danhSachCTHD[i].xuat();
        }
    }

    // Sua chi tiet hoa don
    public void sua() {
        Scanner sc = new Scanner(System.in);
        if (danhSachCTHD.length == 0) {
            System.out.println("Danh sach rong");
            return;
        }
        System.out.print("Nhap ma HD can sua: ");
        String ma = sc.nextLine();
        ChiTietHoaDon cthd = timTheoMa(ma);
        if (cthd == null) {
            System.out.println("Khong tim thay chi tiet voi ma HD = " + ma);
            return;
        }
        System.out.println("Nhap lai thong tin cho chi tiet hoa don co ma HD = " + ma + ":");
        cthd.nhap();
        System.out.println("Da sua thong tin!");
    }

    // Xoa chi tiet hoa don
    public void xoa() {
        Scanner sc = new Scanner(System.in);
        if (danhSachCTHD.length == 0) {
            System.out.println("Danh sach rong");
            return;
        }
        System.out.print("Nhap ma HD can xoa: ");
        String ma = sc.nextLine();
        int vt = -1;
        for (int i = 0; i < danhSachCTHD.length; i++) {
            if (danhSachCTHD[i].getMaHD().equalsIgnoreCase(ma)) {
                vt = i;
                break;
            }
        }
        if (vt == -1) {
            System.out.println("Khong tim thay chi tiet voi ma HD = " + ma);
            return;
        }
        ChiTietHoaDon[] newArr = new ChiTietHoaDon[danhSachCTHD.length - 1];
        for (int i = 0, j = 0; i < danhSachCTHD.length; i++) {
            if (i != vt) {
                newArr[j++] = danhSachCTHD[i];
            }
        }
        danhSachCTHD = newArr;
        System.out.println("Da xoa chi tiet voi ma HD = " + ma);
    }

    public void timChiTietHD() {
        Scanner sc = new Scanner(System.in);
        if (danhSachCTHD.length == 0) {
            System.out.println("Danh sach trong");
            return;
        }
        System.out.print("Nhap ma HD can tim: ");
        String ma = sc.nextLine();
        ChiTietHoaDon cthd = timTheoMa(ma);
        if (cthd == null) {
            System.out.println("Khong tim thay chi tiet voi ma HD = " + ma);
        } else {
            System.out.println("Thong tin chi tiet hoa don:");
            cthd.xuat();
        }
    }

    public void ghiFile(String tenFile) throws IOException{
        for(int i=0;i<danhSachCTHD.length;i++){
            danhSachCTHD[i].ghiFile(tenFile);
        }
    }
    public void docFile(String tenFile) throws IOException{
        DataInputStream inpStream = new DataInputStream(new FileInputStream(tenFile));
        try {
            while (true) {
                them(new ChiTietHoaDon(inpStream.readUTF(),inpStream.readUTF(),inpStream.readInt(),
                                        inpStream.readDouble(),inpStream.readDouble()));
            }
        } catch (Exception e) {}
    }
}
