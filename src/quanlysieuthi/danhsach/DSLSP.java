package quanlysieuthi.danhsach;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import quanlysieuthi.SanPham.LoaiSanPham;
import quanlysieuthi.interfaces.IDanhSach;
import quanlysieuthi.interfaces.INhapXuat;

public class DSLSP implements IDanhSach<LoaiSanPham>, INhapXuat {
    private LoaiSanPham[] danhSachLSP;

    public DSLSP() {
        danhSachLSP = new LoaiSanPham[0];
    }
    public DSLSP(LoaiSanPham[] loaiSanPham) {
        danhSachLSP = loaiSanPham;
    }
    public DSLSP(DSLSP danhSachLSP) {
        this.danhSachLSP = new LoaiSanPham[danhSachLSP.getSoLuong()];
        for(int i=0;i<danhSachLSP.getSoLuong();i++){
            this.danhSachLSP[i] = new LoaiSanPham(danhSachLSP.getLoaiSanPham(i));
        }
    }

    public int getSoLuong() {
        return danhSachLSP.length;
    }

    public LoaiSanPham[] getDanhSach() {
        return danhSachLSP;
    }

    public void setDanhSach(LoaiSanPham[] danhSachLSP) {
        this.danhSachLSP = danhSachLSP;
    }

    public LoaiSanPham getLoaiSanPham(int i) {
        if (i >= 0 && i < danhSachLSP.length) {
            return danhSachLSP[i];
        }
        return null;
    }


    public LoaiSanPham timTheoMa(String maLoai) {
        for (LoaiSanPham lsp : danhSachLSP) {
            if (lsp.getMaLoai().equalsIgnoreCase(maLoai)) {
                return lsp;
            }
        }
        return null;
    }
    public LoaiSanPham timTheoTen(String tenLoai) {
        for (LoaiSanPham lsp : danhSachLSP) {
            if (lsp.getMaLoai().equalsIgnoreCase(tenLoai)) {
                return lsp;
            }
        }
        return null;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong loai san pham: ");
        int n = Integer.parseInt(sc.nextLine());
        danhSachLSP = new LoaiSanPham[n];
        for (int i = 0; i < n; i++) {
            System.out.println("\nNhap loai san pham thu " + (i + 1) + ":");
            danhSachLSP[i] = new LoaiSanPham();
            danhSachLSP[i].nhap();
        }
    }

    public void xuat() {
        if (danhSachLSP.length == 0) {
            System.out.println("Danh sach loai san pham rong.");
            return;
        }
        System.out.printf("| %-10s | %-15s | %-25s |\n", "Ma Loai", "Ten Loai", "Mo Ta");
        System.out.println("------------------------------------------------------------------");
        for (LoaiSanPham lsp : danhSachLSP) {
            lsp.xuat();
        }
        System.out.println("------------------------------------------------------------------");
    }

    public void them() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong loai san pham can them: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n;i++) {
            System.out.println("\nNhap loai san pham");
            LoaiSanPham lsp = new LoaiSanPham();
            lsp.nhap();

            while(timTheoMa(lsp.getMaLoai()) != null) {
                System.out.println("Ma loai da ton tai! Vui long nhap lai.");
                lsp.setMaLoai(sc.nextLine());;
            }
            
            danhSachLSP = Arrays.copyOf(danhSachLSP, danhSachLSP.length + 1);
            danhSachLSP[danhSachLSP.length - 1] = lsp;
            System.out.println("Them thanh cong!");
        }
    }

    public void them(LoaiSanPham lsp) {
        if (timTheoMa(lsp.getMaLoai()) != null) {
            System.out.println("Ma loai da ton tai!");
            return;
        }
        danhSachLSP = Arrays.copyOf(danhSachLSP, danhSachLSP.length + 1);
        danhSachLSP[danhSachLSP.length - 1] = lsp;
    }

    public void sua() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap Ma Loai can sua: ");
        String ma = sc.nextLine();
        LoaiSanPham lsp = timTheoMa(ma);

        if (lsp == null) {
            System.out.println("Khong tim thay ma loai " + ma);
            return;
        }
        while(true){
            System.out.println("Nhap ma loai san pham moi : ");
            ma = sc.nextLine();
            while(timTheoMa(ma)!=null&&ma.equalsIgnoreCase(lsp.getMaLoai())==false){
                System.out.println("Ma loai da ton tai! Vui long nhap lai");
                ma = sc.nextLine();
            }
            break;
        }
        lsp.setMaLoai(ma);
        System.out.print("Nhap Ten Loai moi: ");
        lsp.setTenLoai(sc.nextLine());
        System.out.print("Nhap Mo Ta moi: ");
        lsp.setMoTa(sc.nextLine());

        System.out.println("Sua thong tin thanh cong!");
    }

    public void xoa() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap Ma Loai can xoa: ");
        String ma = sc.nextLine();
        
        int vt = -1;
        for (int i = 0; i < danhSachLSP.length; i++) {
            if (danhSachLSP[i].getMaLoai().equalsIgnoreCase(ma)) {
                vt = i;
                break;
            }
        }

        if (vt == -1) {
            System.out.println("Khong tim thay ma loai " + ma);
            return;
        }

        LoaiSanPham[] newArr = new LoaiSanPham[danhSachLSP.length - 1];
        for (int i = 0, j = 0; i < danhSachLSP.length; i++) {
            if (i != vt) {
                newArr[j++] = danhSachLSP[i];
            }
        }
        danhSachLSP = newArr;
        System.out.println("Da xoa loai san pham co ma = " + ma);
    }

    public LoaiSanPham tim() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap Ma Loai can tim: ");
        String ma = sc.nextLine();
        LoaiSanPham lsp = timTheoMa(ma);
        if (lsp == null) {
            System.out.println("Khong tim thay ma loai " + ma);
        }
        return lsp;
    }

    public int thongKeSoLuong(){
        System.out.println("So luong loai san pham la : "+danhSachLSP.length);
        return danhSachLSP.length;
    }

    // --- THEM MOI ---
    public void ghiFile(String tenFile) throws IOException {
        DataOutputStream xoaFile = new DataOutputStream(new FileOutputStream(tenFile, false)); 
        xoaFile.close();  
        for(int i = 0; i < danhSachLSP.length; i++){
            danhSachLSP[i].ghiFile(tenFile);
        }
        System.out.println("Ghi file thanh cong");
    }

    // --- THEM MOI ---
    public void docFile(String tenFile) throws IOException {
        if(danhSachLSP.length != 0){
            System.out.println("Loi!! danh sach dang chua du lieu.");
            return;
        }
        DataInputStream inpStream = new DataInputStream(new FileInputStream(tenFile));
        try {
            while (true) {
                them(new LoaiSanPham(inpStream.readUTF(), inpStream.readUTF(), inpStream.readUTF()));
            }
        } catch (Exception e) {}
        finally{
            inpStream.close();
            System.out.println("Doc file thanh cong");
        }
    }


    public void xoa(String ma) {
        int vt = -1;
        for (int i = 0; i < danhSachLSP.length; i++) {
            if (danhSachLSP[i].getMaLoai().equalsIgnoreCase(ma)) {
                vt = i;
                break;
            }
        }

        if (vt == -1) {
            System.out.println("Khong tim thay ma loai " + ma);
            return;
        }

        LoaiSanPham[] newArr = new LoaiSanPham[danhSachLSP.length - 1];
        for (int i = 0, j = 0; i < danhSachLSP.length; i++) {
            if (i != vt) {
                newArr[j++] = danhSachLSP[i];
            }
        }
        danhSachLSP = newArr;
        System.out.println("Da xoa loai san pham co ma = " + ma);
    }

    public void sua(String ma, LoaiSanPham lspMoi) {
        int vt = -1;
        for (int i = 0; i < danhSachLSP.length; i++) {
            if (danhSachLSP[i].getMaLoai().equalsIgnoreCase(ma)) {
                vt = i;
                break;
            }
        }
        if (vt == -1) {
            System.out.println("Khong tim thay ma loai " + ma);
            return;
        }
        danhSachLSP[vt] = lspMoi;
        System.out.println("Sua thong tin thanh cong!");
    }
}