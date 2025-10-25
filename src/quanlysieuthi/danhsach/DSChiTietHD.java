package quanlysieuthi.danhsach;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import quanlysieuthi.hoadon.ChiTietHoaDon;
import quanlysieuthi.interfaces.IDanhSach;
import quanlysieuthi.interfaces.INhapXuat; 

public class DSChiTietHD implements IDanhSach<ChiTietHoaDon>, INhapXuat { 
    private ChiTietHoaDon[] danhSachCTHD;

    // Constructor
    public DSChiTietHD() {
        danhSachCTHD = new ChiTietHoaDon[0];
    }

    // Getter
    public int getSoLuong() {
        return danhSachCTHD.length;
    }

    public ChiTietHoaDon[] getDanhSach(){return danhSachCTHD;}
    public void setDanhSach(ChiTietHoaDon[] danhSachCTHD){this.danhSachCTHD=danhSachCTHD;}

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


    public ChiTietHoaDon timChiTiet(String maHD, String maSP) {
        for (int i = 0; i < danhSachCTHD.length; i++) {
            if (danhSachCTHD[i].getMaHD().equalsIgnoreCase(maHD) && 
                danhSachCTHD[i].getMaSP().equalsIgnoreCase(maSP)) {
                return danhSachCTHD[i];
            }
        }
        return null;
    }


    public int timViTri(String maHD, String maSP) {
        for (int i = 0; i < danhSachCTHD.length; i++) {
            if (danhSachCTHD[i].getMaHD().equalsIgnoreCase(maHD) && 
                danhSachCTHD[i].getMaSP().equalsIgnoreCase(maSP)) {
                return i;
            }
        }
        return -1;
    }


    public ChiTietHoaDon tim() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma hoa don (MaHD) can tim: ");
        String maHD = sc.nextLine();
        System.out.print("Nhap ma san pham (MaSP) can tim: ");
        String maSP = sc.nextLine();
        return timChiTiet(maHD, maSP);
    }




    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong chi tiet hoa don: ");
        int n = Integer.parseInt(sc.nextLine());
        danhSachCTHD = new ChiTietHoaDon[n];
        for (int i = 0; i < n; i++) {
            System.out.println("\nNhap chi tiet hoa don thu " + (i + 1) + ":");
            danhSachCTHD[i] = new ChiTietHoaDon();
            danhSachCTHD[i].nhap();

        }
    }

    public void them() {
        Scanner sc = new Scanner(System.in);
        System.out.print("So luong chi tiet hoa don can them: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("\nNhap chi tiet hoa don thu " + (danhSachCTHD.length + 1) + ":");
            ChiTietHoaDon cthd = new ChiTietHoaDon();
            cthd.nhap();



            ChiTietHoaDon[] newArr = new ChiTietHoaDon[danhSachCTHD.length + 1];
            for (int j = 0; j < danhSachCTHD.length; j++) {
                newArr[j] = danhSachCTHD[j];
            }
            newArr[danhSachCTHD.length] = cthd;
            danhSachCTHD = newArr;
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



    public void sua() {
        Scanner sc = new Scanner(System.in);
        if (danhSachCTHD.length == 0) {
            System.out.println("Danh sach rong");
            return;
        }
        System.out.print("Nhap ma HD can sua: ");
        String maHD = sc.nextLine();
        System.out.print("Nhap ma SP can sua: ");
        String maSP = sc.nextLine();

        ChiTietHoaDon cthd = timChiTiet(maHD, maSP);
        if (cthd == null) {
            System.out.println("Khong tim thay chi tiet voi MaHD = " + maHD + " va MaSP = " + maSP);
            return;
        }
        System.out.println("Nhap lai thong tin cho chi tiet hoa don nay:");

        System.out.print("Nhap so luong moi: ");
        cthd.setSoLuong(Integer.parseInt(sc.nextLine()));
        System.out.print("Nhap don gia moi: ");
        cthd.setDonGia(Double.parseDouble(sc.nextLine()));

        System.out.println("Da sua thong tin!");
    }

    public void xoa() {
        Scanner sc = new Scanner(System.in);
        if (danhSachCTHD.length == 0) {
            System.out.println("Danh sach rong");
            return;
        }
        System.out.print("Nhap ma HD can xoa: ");
        String maHD = sc.nextLine();
        System.out.print("Nhap ma SP can xoa: ");
        String maSP = sc.nextLine();

        int vt = timViTri(maHD, maSP);
        
        if (vt == -1) {
            System.out.println("Khong tim thay chi tiet voi MaHD = " + maHD + " va MaSP = " + maSP);
            return;
        }
        ChiTietHoaDon[] newArr = new ChiTietHoaDon[danhSachCTHD.length - 1];
        for (int i = 0, j = 0; i < danhSachCTHD.length; i++) {
            if (i != vt) {
                newArr[j++] = danhSachCTHD[i];
            }
        }
        danhSachCTHD = newArr;
        System.out.println("Da xoa chi tiet");
    }


    public void timChiTietHD() {
        Scanner sc = new Scanner(System.in);
        if (danhSachCTHD.length == 0) {
            System.out.println("Danh sach trong");
            return;
        }
        System.out.print("Nhap ma HD can tim: ");
        String maHD = sc.nextLine();
        System.out.print("Nhap ma SP can tim: ");
        String maSP = sc.nextLine();

        ChiTietHoaDon cthd = timChiTiet(maHD, maSP);
        if (cthd == null) {
            System.out.println("Khong tim thay chi tiet");
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
                                        inpStream.readDouble()));
            }
        } catch (Exception e) {}
    }
}