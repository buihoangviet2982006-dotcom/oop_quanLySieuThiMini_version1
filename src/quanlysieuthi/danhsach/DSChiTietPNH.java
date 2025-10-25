package quanlysieuthi.danhsach;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import quanlysieuthi.Phieu.ChiTietPhieuNhap;
import quanlysieuthi.interfaces.IDanhSach;
import quanlysieuthi.interfaces.INhapXuat; 

public class DSChiTietPNH implements IDanhSach<ChiTietPhieuNhap>, INhapXuat { 
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

    // --- SỬA LẠI LOGIC TÌM KIẾM ---
    
    // Hàm tìm kiếm nội bộ chính xác (theo composite key)
    public ChiTietPhieuNhap timChiTiet(String maPNH, String maSP) {
        for (int i = 0; i < danhSachCTPNH.length; i++) {
            if (danhSachCTPNH[i].getMaPNH().equalsIgnoreCase(maPNH) && 
                danhSachCTPNH[i].getMaSP().equalsIgnoreCase(maSP)) {
                return danhSachCTPNH[i];
            }
        }
        return null;
    }

    // Hàm tìm vị trí nội bộ chính xác
    public int timViTri(String maPNH, String maSP) {
        for (int i = 0; i < danhSachCTPNH.length; i++) {
            if (danhSachCTPNH[i].getMaPNH().equalsIgnoreCase(maPNH) && 
                danhSachCTPNH[i].getMaSP().equalsIgnoreCase(maSP)) {
                return i;
            }
        }
        return -1;
    }

    // Hàm tim() của Interface (sửa lại để tìm chính xác)
    public ChiTietPhieuNhap tim() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma phieu nhap (MaPNH) can tim: ");
        String maPNH = sc.nextLine();
        System.out.print("Nhap ma san pham (MaSP) can tim: ");
        String maSP = sc.nextLine();
        return timChiTiet(maPNH, maSP);
    }

    // --- SỬA LẠI LOGIC NHẬP / THÊM (Bỏ kiểm tra trùng MaPNH) ---

    public void them() {
        Scanner sc = new Scanner(System.in);
        System.out.print("So luong chi tiet phieu nhap can them: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("\nNhap chi tiet phieu nhap thu " + (danhSachCTPNH.length + 1) + ":");
            ChiTietPhieuNhap ctpn = new ChiTietPhieuNhap();
            ctpn.nhap();

            // ĐÃ XÓA LOGIC KIỂM TRA TRÙNG MaPNH (vì nó sai)

            ChiTietPhieuNhap[] newArr = new ChiTietPhieuNhap[danhSachCTPNH.length + 1];
            for (int j = 0; j < danhSachCTPNH.length; j++) {
                newArr[j] = danhSachCTPNH[j];
            }
            newArr[danhSachCTPNH.length] = ctpn;
            danhSachCTPNH = newArr;
        }
        System.out.println("Them thanh cong!");
    }

    // Sửa lại hàm them(object) để bỏ kiểm tra trùng lặp sai
    public void them(ChiTietPhieuNhap ctpn) {
        // ĐÃ XÓA LOGIC KIỂM TRA TRÙNG MaPNH (vì nó sai)
        
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
            System.out.println("\nNhap chi tiet phieu nhap thu " + (danhSachCTPNH.length + 1) + ":");
            ChiTietPhieuNhap ctpn = new ChiTietPhieuNhap();
            ctpn.nhap();

            // ĐÃ XÓA LOGIC KIỂM TRA TRÙNG MaPNH (vì nó sai)

            ChiTietPhieuNhap[] newArr = new ChiTietPhieuNhap[danhSachCTPNH.length + 1];
            for (int j = 0; j < danhSachCTPNH.length; j++) {
                newArr[j] = danhSachCTPNH[j];
            }
            newArr[danhSachCTPNH.length] = ctpn;
            danhSachCTPNH = newArr;
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

    // --- SỬA LẠI LOGIC SỬA / XÓA (để tìm chính xác) ---

    public void sua() {
        Scanner sc = new Scanner(System.in);
        if (danhSachCTPNH.length == 0) {
            System.out.println("Danh sach rong!");
            return;
        }
        System.out.print("Nhap maPNH can sua: ");
        String maPNH = sc.nextLine();
        System.out.print("Nhap maSP can sua: ");
        String maSP = sc.nextLine();

        ChiTietPhieuNhap ctpn = timChiTiet(maPNH, maSP);
        if (ctpn == null) {
            System.out.println("Khong tim thay chi tiet voi MaPNH = " + maPNH + " va MaSP = " + maSP);
            return;
        }
        System.out.println("Nhap lai thong tin cho chi tiet phieu nhap nay:");
        // Chỉ cho phép sửa số lượng, đơn giá
        System.out.print("Nhap so luong moi: ");
        ctpn.setSoLuong(Integer.parseInt(sc.nextLine()));
        System.out.print("Nhap don gia moi: ");
        ctpn.setDonGia(Double.parseDouble(sc.nextLine()));

        System.out.println("Da sua thong tin!");
    }

    public void xoa() {
        Scanner sc = new Scanner(System.in);
        if (danhSachCTPNH.length == 0) {
            System.out.println("Danh sach rong!");
            return;
        }
        System.out.print("Nhap maPNH can xoa: ");
        String maPNH = sc.nextLine();
        System.out.print("Nhap maSP can xoa: ");
        String maSP = sc.nextLine();
        
        int vt = timViTri(maPNH, maSP);

        if (vt == -1) {
            System.out.println("Khong tim thay chi tiet voi MaPNH = " + maPNH + " va MaSP = " + maSP);
            return;
        }

        ChiTietPhieuNhap[] newArr = new ChiTietPhieuNhap[danhSachCTPNH.length - 1];
        for (int i = 0, j = 0; i < danhSachCTPNH.length; i++) {
            if (i != vt) {
                newArr[j++] = danhSachCTPNH[i];
            }
        }
        danhSachCTPNH = newArr;
        System.out.println("Da xoa chi tiet");
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
                                        inpStream.readDouble()));
            }
        } catch (Exception e) {}
    }
}