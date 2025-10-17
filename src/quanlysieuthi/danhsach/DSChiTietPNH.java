package quanlysieuthi.danhsach;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import quanlysieuthi.Phieu.ChiTietPhieuNhap;

public class DSChiTietPNH {
    private ChiTietPhieuNhap[] danhSachCTPNH;

    // Constructor
    public DSChiTietPNH() {
        danhSachCTPNH = new ChiTietPhieuNhap[0];
    }

    // Get
    public int getSoLuong() {
        return danhSachCTPNH.length;
    }

    public ChiTietPhieuNhap danhSachCTPNH(int i) {
        if (i >= 0 && i < danhSachCTPNH.length) {
            return danhSachCTPNH[i];
        }
        return null;
    }

    public double getTongTien(String maPNH){
        double tongTien = 0;
        for(int i=0;i<danhSachCTPNH.length;i++){
            if(maPNH.equals(danhSachCTPNH[i].getMaPNH())){
                tongTien+=danhSachCTPNH[i].getThanhTien();
            }
        }
        return tongTien;
    }
    public ChiTietPhieuNhap timTheoMa(String maPNH) {
        for (int i = 0; i < danhSachCTPNH.length; i++) {
            if (danhSachCTPNH[i].getMaPNH().equalsIgnoreCase(maPNH)) {
                return danhSachCTPNH[i];
            }
        }
        return null;
    }

    public void them() {
        Scanner sc = new Scanner(System.in);
        System.out.print("So luong chi tiet phieu nhap can them: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            boolean hopLe = false;
            while (!hopLe) {
                System.out.println("\nNhap chi tiet phieu nhap thu " + (danhSachCTPNH.length + 1) + ":");
                ChiTietPhieuNhap ctpn = new ChiTietPhieuNhap();
                ctpn.nhap();

                if (timTheoMa(ctpn.getMaPNH()) != null) {
                    System.out.println("MaPNH da ton tai! Moi nhap lai.");
                } else {
                    ChiTietPhieuNhap[] newArr = new ChiTietPhieuNhap[danhSachCTPNH.length + 1];
                    for (int j = 0; j < danhSachCTPNH.length; j++) {
                        newArr[j] = danhSachCTPNH[j];
                    }
                    newArr[danhSachCTPNH.length] = ctpn;
                    danhSachCTPNH = newArr;
                    hopLe = true;
                }
            }
        }
        System.out.println("Them thanh cong!");
    }

    public void them(ChiTietPhieuNhap ctpn) {
        if (timTheoMa(ctpn.getMaPNH()) != null) {
            System.out.println("MaPNH da ton tai!");
            return;
        }
        ChiTietPhieuNhap[] newArr = new ChiTietPhieuNhap[danhSachCTPNH.length + 1];
        for (int i = 0; i < danhSachCTPNH.length; i++) {
            newArr[i] = danhSachCTPNH[i];
        }
        newArr[danhSachCTPNH.length] = ctpn;
        danhSachCTPNH = newArr;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong chi tiet phieu nhap can nhap: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            boolean hopLe = false;
            while (!hopLe) {
                System.out.println("\nNhap chi tiet phieu nhap thu " + (danhSachCTPNH.length + 1) + ":");
                ChiTietPhieuNhap ctpn = new ChiTietPhieuNhap();
                ctpn.nhap();

                if (timTheoMa(ctpn.getMaPNH()) != null) {
                    System.out.println("MaPNH da ton tai! Moi nhap lai.");
                } else {
                    ChiTietPhieuNhap[] newArr = new ChiTietPhieuNhap[danhSachCTPNH.length + 1];
                    for (int j = 0; j < danhSachCTPNH.length; j++) {
                        newArr[j] = danhSachCTPNH[j];
                    }
                    newArr[danhSachCTPNH.length] = ctpn;
                    danhSachCTPNH = newArr;
                    hopLe = true;
                }
            }
        }
        System.out.println("Nhap danh sach thanh cong!");
    }

    public void xuat() {
        if (danhSachCTPNH.length == 0) {
            System.out.println("Danh sach chi tiet phieu nhap rong!");
            return;
        }
        System.out.println("\nDanh sach chi tiet phieu nhap hang:");
        for (int i = 0; i < danhSachCTPNH.length; i++) {
            danhSachCTPNH[i].xuat();
        }
    }

    public void sua() {
        Scanner sc = new Scanner(System.in);
        if (danhSachCTPNH.length == 0) {
            System.out.println("Danh sach rong!");
            return;
        }
        System.out.print("Nhap maPNH can sua: ");
        String ma = sc.nextLine();
        ChiTietPhieuNhap ctpn = timTheoMa(ma);
        if (ctpn == null) {
            System.out.println("Khong tim thay chi tiet voi ma PNH = " + ma);
            return;
        }
        System.out.println("Nhap lai thong tin cho chi tiet phieu nhap co ma PNH = " + ma + ":");
        ctpn.nhap();
        System.out.println("Da sua thong tin!");
    }

    public void xoa() {
        Scanner sc = new Scanner(System.in);
        if (danhSachCTPNH.length == 0) {
            System.out.println("Danh sach rong!");
            return;
        }
        System.out.print("Nhap maPNH can xoa: ");
        String ma = sc.nextLine();
        int vt = -1;
        for (int i = 0; i < danhSachCTPNH.length; i++) {
            if (danhSachCTPNH[i].getMaPNH().equalsIgnoreCase(ma)) {
                vt = i;
                break;
            }
        }
        if (vt == -1) {
            System.out.println("Khong tim thay chi tiet voi ma PNH = " + ma);
            return;
        }

        ChiTietPhieuNhap[] newArr = new ChiTietPhieuNhap[danhSachCTPNH.length - 1];
        for (int i = 0, j = 0; i < danhSachCTPNH.length; i++) {
            if (i != vt) {
                newArr[j++] = danhSachCTPNH[i];
            }
        }
        danhSachCTPNH = newArr;
        System.out.println("Da xoa chi tiet voi ma PNH = " + ma);
    }

    public void ghiFile(String tenFile) throws IOException{
        for(int i=0;i<danhSachCTPNH.length;i++){
            danhSachCTPNH[i].ghiFile(tenFile);
        }
    }
    public void docFile(String tenFile) throws IOException{
        DataInputStream inpStream = new DataInputStream(new FileInputStream(tenFile));
        try {
            while (true) {
                them(new ChiTietPhieuNhap(inpStream.readUTF(),inpStream.readUTF(),inpStream.readInt(),
                                        inpStream.readDouble(),inpStream.readDouble()));
            }
        } catch (Exception e) {}
    }
}
