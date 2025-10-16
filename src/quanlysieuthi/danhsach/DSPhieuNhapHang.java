package quanlysieuthi.danhsach;

import java.util.Scanner;
import quanlysieuthi.Phieu.PhieuNhapHang;

public class DSPhieuNhapHang {
    private PhieuNhapHang[] danhSachPNH;

    // constructor
    public DSPhieuNhapHang() {
        danhSachPNH = new PhieuNhapHang[0];
    }

    // get
    public int getSoLuong() {
        return danhSachPNH.length;
    }

    public PhieuNhapHang getPhieuNhapHang(int i) {
        if (i >= 0 && i < danhSachPNH.length) {
            return danhSachPNH[i];
        }
        return null;
    }

    public PhieuNhapHang timTheoMa(String maPNH) {
        for (int i = 0; i < danhSachPNH.length; i++) {
            if (danhSachPNH[i].getMaPNH().equalsIgnoreCase(maPNH)) {
                return danhSachPNH[i];
            }
        }
        return null;
    }

    public void them() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong phieu nhap hang can them: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            boolean hopLe = false;
            while (!hopLe) {
                System.out.println("\nNhap phieu nhap hang thu " + (danhSachPNH.length + 1) + ":");
                PhieuNhapHang p = new PhieuNhapHang();
                p.nhap();

                if (timTheoMa(p.getMaPNH()) != null) {
                    System.out.println("MaPNH da ton tai! Moi nhap lai.");
                } else {
                    PhieuNhapHang[] newArr = new PhieuNhapHang[danhSachPNH.length + 1];
                    for (int j = 0; j < danhSachPNH.length; j++) {
                        newArr[j] = danhSachPNH[j];
                    }
                    newArr[danhSachPNH.length] = p;
                    danhSachPNH = newArr;
                    hopLe = true;
                }
            }
        }
        System.out.println("Them thanh cong!");
    }

    // Thêm 1 phiếu
    public void them(PhieuNhapHang p) {
        if (timTheoMa(p.getMaPNH()) != null) {
            System.out.println("MaPNH da ton tai!");
            return;
        }
        PhieuNhapHang[] newArr = new PhieuNhapHang[danhSachPNH.length + 1];
        for (int i = 0; i < danhSachPNH.length; i++) {
            newArr[i] = danhSachPNH[i];
        }
        newArr[danhSachPNH.length] = p;
        danhSachPNH = newArr;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong phieu nhap hang can nhap: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            boolean hopLe = false;
            while (!hopLe) {
                System.out.println("\nNhap phieu nhap hang thu " + (danhSachPNH.length + 1) + ":");
                PhieuNhapHang p = new PhieuNhapHang();
                p.nhap();

                if (timTheoMa(p.getMaPNH()) != null) {
                    System.out.println("MaPNH da ton tai! Moi nhap lai.");
                } else {
                    PhieuNhapHang[] newArr = new PhieuNhapHang[danhSachPNH.length + 1];
                    for (int j = 0; j < danhSachPNH.length; j++) {
                        newArr[j] = danhSachPNH[j];
                    }
                    newArr[danhSachPNH.length] = p;
                    danhSachPNH = newArr;
                    hopLe = true;
                }
            }
        }
        System.out.println("Nhap danh sach thanh cong!");
    }

    public void xuat() {
        if (danhSachPNH.length == 0) {
            System.out.println("Danh sach trong!");
            return;
        }
        System.out.println("\nDanh sach phieu nhap hang:");
        for (int i = 0; i < danhSachPNH.length; i++) {
            danhSachPNH[i].xuat();
        }
    }

    public void sua() {
        Scanner sc = new Scanner(System.in);
        if (danhSachPNH.length == 0) {
            System.out.println("Danh sach trong!");
            return;
        }
        System.out.print("Nhap maPNH can sua: ");
        String ma = sc.nextLine();
        PhieuNhapHang p = timTheoMa(ma);
        if (p == null) {
            System.out.println("Khong tim thay phieu co maPNH = " + ma);
            return;
        }
        System.out.println("Nhap lai thong tin cho phieu " + ma + ":");
        p.nhap();
        System.out.println("Da sua thong tin!");
    }

    public void xoa() {
        Scanner sc = new Scanner(System.in);
        if (danhSachPNH.length == 0) {
            System.out.println("Danh sach trong!");
            return;
        }
        System.out.print("Nhap maPNH can xoa: ");
        String ma = sc.nextLine();
        int vt = -1;
        for (int i = 0; i < danhSachPNH.length; i++) {
            if (danhSachPNH[i].getMaPNH().equalsIgnoreCase(ma)) {
                vt = i;
                break;
            }
        }
        if (vt == -1) {
            System.out.println("Khong tim thay phieu co maPNH = " + ma);
            return;
        }

        PhieuNhapHang[] newArr = new PhieuNhapHang[danhSachPNH.length - 1];
        for (int i = 0, j = 0; i < danhSachPNH.length; i++) {
            if (i != vt) {
                newArr[j++] = danhSachPNH[i];
            }
        }
        danhSachPNH = newArr;

        System.out.println("Da xoa phieu co maPNH = " + ma);
    }


}