package quanlysieuthi.danhsach;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays; 
import java.util.Scanner;

import quanlysieuthi.Nguoi.NhanVien;
import quanlysieuthi.interfaces.IDanhSach;
import quanlysieuthi.interfaces.INhapXuat;

public class DSNV implements IDanhSach<NhanVien>, INhapXuat {
    private NhanVien[] danhSachNV;

    public DSNV() {
        danhSachNV = new NhanVien[0];
    }

    public DSNV(NhanVien[] danhSachNV) {
        this.danhSachNV = danhSachNV;
    }

    public DSNV(DSNV danhSachNV) {
        this.danhSachNV = new NhanVien[danhSachNV.getSoLuong()];
        for (int i = 0; i < danhSachNV.getSoLuong(); i++) {
            this.danhSachNV[i] = new NhanVien(danhSachNV.getNhanVien(i));
        }
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

    public NhanVien[] getDanhSach() {
        return danhSachNV;
    }

    public void setDanhSach(NhanVien[] danhSachNV) {
        this.danhSachNV = danhSachNV;
    }


    public void nhap() {
        if (danhSachNV.length == 0) {
            Scanner sc = new Scanner(System.in);
            int n = 0;
            System.out.println("Nhap so luong nhan vien muon them vao:");
            n = Integer.parseInt(sc.nextLine());
            danhSachNV = new NhanVien[n];
            for (int i = 0; i < n; i++) {
                System.out.println("Nhap nhan vien thu " + (i + 1) + ":");
                NhanVien nv = new NhanVien();
                nv.nhap();
                while (tim(nv.getMaNV()) != null) {
                    System.out.println("Ma nhan vien da ton tai! Vui long nhap lai.");
                    System.out.print("Nhap ma NV: ");
                    nv.setMaNV(sc.nextLine());
                }
                danhSachNV[i] = nv;
            }
        } else {
            them();
        }
    }

    public void xuat() {
        if (danhSachNV.length == 0) {
            System.out.println("Danh sach trong!");
            return;
        }
        System.out.println("\n------------------------------------------- DANH SACH NHAN VIEN ----------------------------------------------------");
        System.out.printf("| %-10s | %-10s | %-10s | %-8s | %-10s | %-12s | %-15s | %-20s | %-13s |\n",
                "Ma NV", "Ho", "Ten", "Gioi Tinh", "Chuc Vu", "SDT", "Dia Chi", "Email", "Luong (VND)");
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        for (NhanVien nv : danhSachNV) {
            nv.xuat(); 
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------");

    }


    public void them() {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        System.out.println("Nhap so luong nhan vien muon them");
        n = Integer.parseInt(sc.nextLine());
        danhSachNV = Arrays.copyOf(danhSachNV, danhSachNV.length + n);
        for (int i = danhSachNV.length - n; i < danhSachNV.length; i++) {
            System.out.println("Nhap nhan vien thu " + (i + 1) + ":");
            NhanVien nv = new NhanVien();
            nv.nhap();
            while (tim(nv.getMaNV()) != null) {
                System.out.println("Ma nhan vien da ton tai! Vui long nhap lai.");
                System.out.print("Nhap ma NV: ");
                nv.setMaNV(sc.nextLine());
            }
            danhSachNV[i] = nv;
        }
    }

 
    public void them(NhanVien nv) {
        if (tim(nv.getMaNV()) != null) {
            System.out.println("MaNV da ton tai!");
            return;
        }
        danhSachNV = Arrays.copyOf(danhSachNV, danhSachNV.length + 1);
        danhSachNV[danhSachNV.length - 1] = nv;
    }


    public void xoa() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma nhan vien muon xoa");
        xoa(sc.nextLine());
    }


    public void xoa(String maNV) {
        int vt = -1;
        for (int i = 0; i < danhSachNV.length; i++) {
            if (maNV.equalsIgnoreCase(danhSachNV[i].getMaNV())) {
                vt = i;
                break;
            }
        }

        if (vt == -1) {
            System.out.println("Khong tim thay ma nhan vien!");
            return;
        }


        for (int j = vt; j < danhSachNV.length - 1; j++) {
            danhSachNV[j] = danhSachNV[j + 1];
        }

        danhSachNV = Arrays.copyOf(danhSachNV, danhSachNV.length - 1);
        System.out.println("Xoa thanh cong!");
    }

    public void sua(String maNV, NhanVien nv) {
        for (int i = 0; i < danhSachNV.length; i++) {
            if (maNV.equalsIgnoreCase(danhSachNV[i].getMaNV())) {
                danhSachNV[i] = nv;
                return;
            }
        }
        System.out.println("khong tim thay nhan vien");
    }


    public void sua() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma nhan vien muon sua");
        String maNV = sc.nextLine();
        if (tim(maNV) == null) {
            System.out.println("khong tim thay nhan vien");
            return;
        }

        System.out.println("Nhap thong tin nhan vien moi:");
        NhanVien nv = new NhanVien();
        nv.nhap(); 

        while (tim(nv.getMaNV()) != null && maNV.equalsIgnoreCase(nv.getMaNV()) == false) {
            System.out.println("Ma nhan vien moi da ton tai! Vui long nhap lai");
            System.out.print("Nhap ma NV: ");
            nv.setMaNV(sc.nextLine());
        }
        

        sua(maNV, nv);
    }


    public NhanVien tim() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma nhan vien muon tim");
        String maNV = sc.nextLine();
        NhanVien nv = tim(maNV);
        
        if (nv == null) {
             System.out.println("Khong tim thay nhan vien " + maNV);
        }
        return nv;
    }

    public NhanVien tim(String maNV) {
        for (int i = 0; i < danhSachNV.length; i++) {
            if (danhSachNV[i] != null && maNV.equalsIgnoreCase(danhSachNV[i].getMaNV())) {
                return danhSachNV[i];
            }
        }
        return null;
    }


    public int thongKeSoLuongNhanVien() {
        System.out.println("So nhan vien hien co la : " + danhSachNV.length);
        return danhSachNV.length;
    }

    // --- THEM MOI ---
    public void ghiFile(String tenFile) throws IOException {
        DataOutputStream xoaFile = new DataOutputStream(new FileOutputStream(tenFile, false)); 
        xoaFile.close();  
        for(int i = 0; i < danhSachNV.length; i++){
            danhSachNV[i].ghiFile(tenFile);
        }
        System.out.println("Ghi file thanh cong");
    }

    // --- THEM MOI ---
    public void docFile(String tenFile) throws IOException {
        if(danhSachNV.length != 0){
            System.out.println("Loi!! danh sach dang chua du lieu.");
            return;
        }
        DataInputStream inpStream = new DataInputStream(new FileInputStream(tenFile));
        try {
            while (true) {
                them(new NhanVien(inpStream.readUTF(), inpStream.readUTF(), inpStream.readUTF(),
                                  inpStream.readUTF(), inpStream.readUTF(), inpStream.readUTF(),
                                  inpStream.readUTF(), inpStream.readUTF(), inpStream.readDouble()));
            }
        } catch (Exception e) {}
        finally{
            inpStream.close();
            System.out.println("Doc file thanh cong");
        }
    }
}