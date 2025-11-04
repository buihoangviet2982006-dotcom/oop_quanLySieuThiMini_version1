package quanlysieuthi.danhsach;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import quanlysieuthi.SanPham.HangSanXuat;
import quanlysieuthi.interfaces.IDanhSach;
import quanlysieuthi.interfaces.INhapXuat;

public class DSHangSanXuat implements IDanhSach<HangSanXuat>, INhapXuat {
    private HangSanXuat[] danhSachHSX;

    public DSHangSanXuat() {
        danhSachHSX = new HangSanXuat[0];
    }

    public DSHangSanXuat(HangSanXuat[] danhSachHSX) {
        this.danhSachHSX = danhSachHSX;
    }

    public DSHangSanXuat(DSHangSanXuat other) {
        this.danhSachHSX = new HangSanXuat[other.getSoLuong()];
        for (int i = 0; i < other.getSoLuong(); i++) {
            this.danhSachHSX[i] = new HangSanXuat(other.getHangSanXuat(i));
        }
    }

    public int getSoLuong() {
        return danhSachHSX.length;
    }

    public HangSanXuat getHangSanXuat(int i) {
        if (i >= 0 && i < danhSachHSX.length) {
            return danhSachHSX[i];
        }
        return null;
    }

    public HangSanXuat[] getDanhSach() {
        return danhSachHSX;
    }

    public void setDanhSach(HangSanXuat[] danhSachHSX) {
        this.danhSachHSX = danhSachHSX;
    }

    public HangSanXuat timTheoMa(String maHang) {
        for (HangSanXuat hsx : danhSachHSX) {
            if (hsx!=null&&hsx.getMaHang().equalsIgnoreCase(maHang)) {
                return hsx;
            }
        }
        return null;
    }

    @Override
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong hang san xuat: ");
        int n = Integer.parseInt(sc.nextLine());
        danhSachHSX = new HangSanXuat[n];
        for (int i = 0; i < n; i++) {
            System.out.println("\nNhap hang san xuat thu " + (i + 1) + ":");
            HangSanXuat hsx = new HangSanXuat();
            hsx.nhap();

            while (timTheoMa(hsx.getMaHang()) != null) {
                System.out.println("Ma Hang da ton tai! Vui long nhap lai.");
                System.out.print("Nhap Ma Hang: ");
                hsx.setMaHang(sc.nextLine());
            }
            danhSachHSX[i] = hsx;
        }
    }

    @Override
    public void xuat() {
        if (danhSachHSX.length == 0) {
            System.out.println("Danh sach hang san xuat rong.");
            return;
        }
        System.out.println("\n------------------------------ DANH SACH HANG SAN XUAT ------------------------------");
        System.out.printf("| %-10s | %-20s | %-30s | %-15s | %-10s |\n", "Ma Hang", "Ten Hang", "Dia Chi", "Lien He", "Nam TL");
        System.out.println("-----------------------------------------------------------------------------------------------");
        for (HangSanXuat hsx : danhSachHSX) {
            // In theo hang (thay vì dùng hsx.xuat() đang in theo chiều dọc)
            System.out.printf("| %-10s | %-20s | %-30s | %-15s | %-10s |\n",
                hsx.getMaHang(), hsx.getTenHang(), hsx.getDiaChi(),
                hsx.getLienHe(), hsx.getNamThanhLap());
        }
        System.out.println("-----------------------------------------------------------------------------------------------");
    }

    @Override
    public void them() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong hang san xuat can them: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("\nNhap hang san xuat thu " + (danhSachHSX.length + 1) + ":");
            HangSanXuat hsx = new HangSanXuat();
            hsx.nhap();

            while (timTheoMa(hsx.getMaHang()) != null) {
                System.out.println("Ma Hang da ton tai! Vui long nhap lai.");
                System.out.print("Nhap Ma Hang: ");
                hsx.setMaHang(sc.nextLine());
            }
            
            danhSachHSX = Arrays.copyOf(danhSachHSX, danhSachHSX.length + 1);
            danhSachHSX[danhSachHSX.length - 1] = hsx;
            System.out.println("Them thanh cong!");
        }
    }
    
    // Them 1 doi tuong
    public void them(HangSanXuat hsx) {
        if (timTheoMa(hsx.getMaHang()) != null) {
            System.out.println("Ma Hang da ton tai!");
            return;
        }
        danhSachHSX = Arrays.copyOf(danhSachHSX, danhSachHSX.length + 1);
        danhSachHSX[danhSachHSX.length - 1] = hsx;
    }


    @Override
    public void sua() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap Ma Hang can sua: ");
        String ma = sc.nextLine();
        HangSanXuat hsx = timTheoMa(ma);

        if (hsx == null) {
            System.out.println("Khong tim thay ma hang " + ma);
            return;
        }
        
        System.out.println("Nhap thong tin moi cho hang " + ma + ":");
        // Tam thoi cho nhap lai tat ca
        // (Co the toi uu chi cho sua ten, dia chi,...)
        hsx.nhap(); 
        
        // Kiem tra neu ma hang moi bi trung (tru truong hop trung voi chinh no)
        while(timTheoMa(hsx.getMaHang()) != null && !hsx.getMaHang().equalsIgnoreCase(ma)) {
             System.out.println("Ma Hang moi da ton tai! Vui long nhap lai.");
             System.out.print("Nhap Ma Hang: ");
             hsx.setMaHang(sc.nextLine());
        }

        System.out.println("Sua thong tin thanh cong!");
    }

    @Override
    public void xoa() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap Ma Hang can xoa: ");
        String ma = sc.nextLine();
        
        int vt = -1;
        for (int i = 0; i < danhSachHSX.length; i++) {
            if (danhSachHSX[i].getMaHang().equalsIgnoreCase(ma)) {
                vt = i;
                break;
            }
        }

        if (vt == -1) {
            System.out.println("Khong tim thay ma hang " + ma);
            // Nen kiem tra rang buoc o day (vi du: neu co SanPham dang dung maHang nay thi khong cho xoa)
            return;
        }

        HangSanXuat[] newArr = new HangSanXuat[danhSachHSX.length - 1];
        for (int i = 0, j = 0; i < danhSachHSX.length; i++) {
            if (i != vt) {
                newArr[j++] = danhSachHSX[i];
            }
        }
        danhSachHSX = newArr;
        System.out.println("Da xoa hang san xuat co ma = " + ma);
    }

    @Override
    public HangSanXuat tim() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap Ma Hang can tim: ");
        String ma = sc.nextLine();
        HangSanXuat hsx = timTheoMa(ma);
        if (hsx == null) {
            System.out.println("Khong tim thay ma hang " + ma);
        }
        return hsx;
    }

    public int thongKeSoLuong() {
        System.out.println("Tong so luong hang san xuat: " + danhSachHSX.length);
        return danhSachHSX.length;
    }

    // --- THEM MOI ---
    public void ghiFile(String tenFile) throws IOException {
        DataOutputStream xoaFile = new DataOutputStream(new FileOutputStream(tenFile, false)); 
        xoaFile.close();  
        for(int i = 0; i < danhSachHSX.length; i++){
            danhSachHSX[i].ghiFile(tenFile);
        }
        System.out.println("Ghi file thanh cong");
    }

    // --- THEM MOI ---
    public void docFile(String tenFile) throws IOException {
        if(danhSachHSX.length != 0){
            System.out.println("Loi!! danh sach dang chua du lieu.");
            return;
        }
        DataInputStream inpStream = new DataInputStream(new FileInputStream(tenFile));
        try {
            while (true) {
                them(new HangSanXuat(inpStream.readUTF(), inpStream.readUTF(), inpStream.readUTF(),
                                    inpStream.readUTF(), inpStream.readUTF()));
            }
        } catch (Exception e) {}
        finally{
            inpStream.close();
            System.out.println("Doc file thanh cong");
        }
    }


    public void xoa(String ma) {
        int vt = -1;
        for (int i = 0; i < danhSachHSX.length; i++) {
            if (danhSachHSX[i].getMaHang().equalsIgnoreCase(ma)) {
                vt = i;
                break;
            }
        }

        if (vt == -1) {
            System.out.println("Khong tim thay ma hang " + ma);
            return;
        }

        HangSanXuat[] newArr = new HangSanXuat[danhSachHSX.length - 1];
        for (int i = 0, j = 0; i < danhSachHSX.length; i++) {
            if (i != vt) {
                newArr[j++] = danhSachHSX[i];
            }
        }
        danhSachHSX = newArr;
        System.out.println("Da xoa hang san xuat co ma = " + ma);
    }


    public void sua(String ma, HangSanXuat hsxMoi) {
        int vt = -1;
        for (int i = 0; i < danhSachHSX.length; i++) {
            if (danhSachHSX[i].getMaHang().equalsIgnoreCase(ma)) {
                vt = i;
                break;
            }
        }
        if (vt == -1) {
            System.out.println("Khong tim thay ma hang " + ma);
            return;
        }
        danhSachHSX[vt] = hsxMoi;
        System.out.println("Sua thong tin thanh cong!");
    }
}