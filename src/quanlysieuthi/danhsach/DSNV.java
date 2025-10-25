package quanlysieuthi.danhsach;

import java.util.Scanner;

import quanlysieuthi.Nguoi.NhanVien;
import quanlysieuthi.interfaces.IDanhSach;
import quanlysieuthi.interfaces.INhapXuat;


public class DSNV implements IDanhSach<NhanVien>,INhapXuat{
    private NhanVien[] danhSachNV;

    public DSNV() {
        danhSachNV = new NhanVien[0];
    }

    public int getSoLuong() {
        return danhSachNV.length;
    }

    public NhanVien getNhanVien(int i) {
        if (i >= 0 && i < danhSachNV.length) {
            return danhSachNV[i];
        }
        return null;
    }
    public NhanVien[] getDanhSach(){
        return danhSachNV;
    }
    public void setDanhSach(NhanVien[] danhSachNV){
        this.danhSachNV = danhSachNV;
    }
    public NhanVien timTheoMa(String maNV) {
        for (NhanVien nv : danhSachNV) {
            if (nv.getMaNV().equalsIgnoreCase(maNV)) {
                return nv;
            }
        }
        return null;
    }
    public void nhap(){
        if (danhSachNV.length == 0) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhap so luong nhan vien");
            int n = Integer.parseInt(sc.nextLine());
            danhSachNV = new NhanVien[n];
            for(int i=0;i<n;i++){
                danhSachNV[i] = new NhanVien();
                danhSachNV[i].nhap();
            }
        } else {
            them();
        }
    }
    public void them() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong nhan vien can them: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            boolean hopLe = false;
            while (!hopLe) {
                System.out.println("\nNhap nhan vien thu " + (danhSachNV.length + 1) + ":");
                NhanVien nv = new NhanVien();
                nv.nhap();

                if (timTheoMa(nv.getMaNV()) != null) {
                    System.out.println("MaNV da ton tai! Moi nhap lai.");
                } else {
                    NhanVien[] newArr = new NhanVien[danhSachNV.length + 1];
                    for (int j = 0; j < danhSachNV.length; j++) {
                        newArr[j] = danhSachNV[j];
                    }
                    newArr[danhSachNV.length] = nv;
                    danhSachNV = newArr;
                    hopLe = true;
                }
            }
        }
        System.out.println("Them thanh cong!");
    }

    public void them(NhanVien nv) {
        if (timTheoMa(nv.getMaNV()) != null) {
            System.out.println("MaNV da ton tai!");
            return;
        }
        NhanVien[] newArr = new NhanVien[danhSachNV.length + 1];
        for (int i = 0; i < danhSachNV.length; i++) {
            newArr[i] = danhSachNV[i];
        }
        newArr[danhSachNV.length] = nv;
        danhSachNV = newArr;
    }

    public void xuat() {
        if (danhSachNV.length == 0) {
            System.out.println("Danh sach trong!");
            return;
        }
        System.out.println("\nDanh sach nhan vien:");
        for (NhanVien nv : danhSachNV) {
            nv.xuat();
        }
    }

    public void sua() {
        Scanner sc = new Scanner(System.in);
        if (danhSachNV.length == 0) {
            System.out.println("Danh sach trong!");
            return;
        }
        System.out.print("Nhap maNV can sua: ");
        String ma = sc.nextLine();
        NhanVien nv = timTheoMa(ma);
        if (nv == null) {
            System.out.println("Khong tim thay nhan vien co maNV = " + ma);
            return;
        }
        System.out.println("Nhap lai thong tin cho nhan vien " + ma + ":");
        nv.nhap();
        System.out.println("Da sua thong tin!");
    }

    public void xoa() {
        Scanner sc = new Scanner(System.in);
        if (danhSachNV.length == 0) {
            System.out.println("Danh sach trong!");
            return;
        }
        System.out.print("Nhap maNV can xoa: ");
        String ma = sc.nextLine();
        int vt = -1;
        for (int i = 0; i < danhSachNV.length; i++) {
            if (danhSachNV[i].getMaNV().equalsIgnoreCase(ma)) {
                vt = i;
                break;
            }
        }
        if (vt == -1) {
            System.out.println("Khong tim thay nhan vien co maNV = " + ma);
            return;
        }

        NhanVien[] newArr = new NhanVien[danhSachNV.length - 1];
        for (int i = 0, j = 0; i < danhSachNV.length; i++) {
            if (i != vt) {
                newArr[j++] = danhSachNV[i];
            }
        }
        danhSachNV = newArr;

        System.out.println("Da xoa nhan vien co maNV = " + ma);
    }
    public NhanVien tim(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma nhan vien can tim");
        return timTheoMa(sc.nextLine());
    }    
}