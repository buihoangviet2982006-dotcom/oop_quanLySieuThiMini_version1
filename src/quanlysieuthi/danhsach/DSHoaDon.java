package quanlysieuthi.danhsach;

import java.util.Scanner;
import quanlysieuthi.hoadon.HoaDon;

public class DSHoaDon {
    private HoaDon[] danhSachHD;

    // Constructor
    public DSHoaDon() {
        danhSachHD = new HoaDon[0];
    }

    // Getter
    public int getSoLuong() {
        return danhSachHD.length;
    }

    public HoaDon getHoaDon(int i) {
        if (i >= 0 && i < danhSachHD.length) {
            return danhSachHD[i];
        }
        return null;
    }

    public HoaDon timTheoMa(String maHD) {
        for (int i = 0; i < danhSachHD.length; i++) {
            if (danhSachHD[i].getMaHD().equalsIgnoreCase(maHD)) {
                return danhSachHD[i];
            }
        }
        return null;
    }

    public void them() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong hoa don can them: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            boolean hopLe = false;
            while (!hopLe) {
                System.out.println("\nNhap hoa don thu " + (danhSachHD.length + 1) + ":");
                HoaDon hd = new HoaDon();
                hd.nhap();

                if (timTheoMa(hd.getMaHD()) != null) {
                    System.out.println("MaHD da ton tai! Moi nhap lai.");
                } else {
                    HoaDon[] newArr = new HoaDon[danhSachHD.length + 1];
                    for (int j = 0; j < danhSachHD.length; j++) {
                        newArr[j] = danhSachHD[j];
                    }
                    newArr[danhSachHD.length] = hd;
                    danhSachHD = newArr;
                    hopLe = true;
                }
            }
        }
        System.out.println("Them thanh cong!");
    }

    public void them(HoaDon hd) {
        if (timTheoMa(hd.getMaHD()) != null) {
            System.out.println("MaHD da ton tai");
            return;
        }
        HoaDon[] newArr = new HoaDon[danhSachHD.length + 1];
        for (int i = 0; i < danhSachHD.length; i++) {
            newArr[i] = danhSachHD[i];
        }
        newArr[danhSachHD.length] = hd;
        danhSachHD = newArr;
    }

    public void xuat() {
        if (danhSachHD.length == 0) {
            System.out.println("Danh sach trong");
            return;
        }
        System.out.println("\nDanh sach hoa don");
        for (int i = 0; i < danhSachHD.length; i++) {
            danhSachHD[i].xuat();
        }
    }

    public void sua() {
        Scanner sc = new Scanner(System.in);
        if (danhSachHD.length == 0) {
            System.out.println("Danh sach trong");
            return;
        }
        System.out.print("Nhap maHD can sua: ");
        String ma = sc.nextLine();
        HoaDon hd = timTheoMa(ma);
        if (hd == null) {
            System.out.println("Khong tim thay hoa don co maHD = " + ma);
            return;
        }
        System.out.println("Nhap lai thong tin cho hoa don " + ma + ":");
        hd.nhap();
        System.out.println("Da sua thong tin");
    }

    public void xoa() {
        Scanner sc = new Scanner(System.in);
        if (danhSachHD.length == 0) {
            System.out.println("Danh sach rong");
            return;
        }
        System.out.print("Nhap maHD can xoa: ");
        String ma = sc.nextLine();
        int vt = -1;
        for (int i = 0; i < danhSachHD.length; i++) {
            if (danhSachHD[i].getMaHD().equalsIgnoreCase(ma)) {
                vt = i;
                break;
            }
        }
        if (vt == -1) {
            System.out.println("Khong tim thay hoa don co maHD = " + ma);
            return;
        }

        HoaDon[] newArr = new HoaDon[danhSachHD.length - 1];
        for (int i = 0, j = 0; i < danhSachHD.length; i++) {
            if (i != vt) {
                newArr[j++] = danhSachHD[i];
            }
        }
        danhSachHD = newArr;
        System.out.println("Da xoa hoa don co maHD = " + ma);
    }

    public void timHoaDon() {
        Scanner sc = new Scanner(System.in);
        if (danhSachHD.length == 0) {
            System.out.println("Danh sach trong");
            return;
        }
        System.out.print("Nhap maHD can tim: ");
        String ma = sc.nextLine();
        HoaDon hd = timTheoMa(ma);
        if (hd == null) {
            System.out.println("Khong tim thay hoa don co maHD = " + ma);
        } else {
            System.out.println("Thong tin hoa don:");
            hd.xuat();
        }
    }

}
