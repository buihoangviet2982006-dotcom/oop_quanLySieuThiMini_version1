package quanlysieuthi.quanli;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import quanlysieuthi.Nguoi.KhachHang;
import quanlysieuthi.Nguoi.NhaCungCap;
import quanlysieuthi.Nguoi.NhanVien;
import quanlysieuthi.Phieu.ChiTietPhieuNhap;
import quanlysieuthi.Phieu.PhieuNhapHang;
import quanlysieuthi.SanPham.SanPham;
import quanlysieuthi.danhsach.DSChiTietHD;
import quanlysieuthi.danhsach.DSChiTietPNH;
import quanlysieuthi.danhsach.DSHoaDon;
import quanlysieuthi.danhsach.DSKH;
import quanlysieuthi.danhsach.DSNV;
import quanlysieuthi.danhsach.DSNhaCungCap;
import quanlysieuthi.danhsach.DSPhieuNhapHang;
import quanlysieuthi.danhsach.DSSP;
import quanlysieuthi.hoadon.ChiTietHoaDon;
import quanlysieuthi.hoadon.HoaDon;
import quanlysieuthi.tienich.DuongDan;

public class QLST {
    private DSSP dsSP;
    private DSChiTietHD dsCTHD;
    private DSHoaDon dsHD;
    private DSPhieuNhapHang dsPNH;
    private DSChiTietPNH dsCTPNH;
    private DSNhaCungCap dsNCC;
    private DSKH dsKH;
    private DSNV dsNV;
    public QLST(){
        dsSP = new DSSP();
        dsCTHD = new DSChiTietHD();
        dsHD = new DSHoaDon();
        dsCTPNH = new DSChiTietPNH();
        dsPNH = new DSPhieuNhapHang();
        dsNCC = new DSNhaCungCap();
        dsKH = new DSKH();
        dsNV = new DSNV();
    }
    public QLST(DSSP dsSP,DSChiTietHD dsCTHD,DSHoaDon dsHD,DSChiTietPNH dsCTPNH,DSPhieuNhapHang dsPNH,DSNhaCungCap dsNCC,DSKH dsKH,DSNV dsNV){
        this.dsCTHD = dsCTHD;
        this.dsHD = dsHD;
        this.dsCTPNH = dsCTPNH;
        this.dsPNH = dsPNH;
        this.dsSP = dsSP;
        this.dsNCC = dsNCC;
        this.dsKH = dsKH;
        this.dsNV = dsNV;
    }
    public void QLSP(){
        Scanner sc = new Scanner(System.in);
        int chon = 0;
        do{
            System.out.println("----------------------------------------------");
            System.out.println("             QUAN LY SAN PHAM");
            System.out.println("----------------------------------------------");
            System.out.println("1.Nhap danh sach san pham");
            System.out.println("2.Xuat danh sach san pham");
            System.out.println("3.Them san pham");
            System.out.println("4.Sua san pham");
            System.out.println("5.Xoa san pham");
            System.out.println("6.Tim san pham");
            System.out.println("7.Ghi FILE");
            System.out.println("8.Doc FILE");
            System.out.println("9.Thoat");
            System.out.println("Chon: ");
            chon = Integer.parseInt(sc.nextLine());
            switch (chon) {
                case 1:
                    dsSP.nhap();
                    break;
                case 2:
                    dsSP.xuat();
                    break;
                case 3:
                    dsSP.them();
                    System.out.println("them thanh cong");
                    break;            
                case 4:
                    dsSP.sua();
                    System.out.println("sua thanh cong");
                    break;            
                case 5:              
                    dsSP.xoa();
                    System.out.println("xoa thanh cong");
                    break;
                case 6:
                    SanPham sp;
                    sp = dsSP.tim();
                    if(sp!=null){
                        System.out.printf("| %-10s | %-15s | %-5s | %-15s | %-10s | %-15s | %-10s | %-10s | %-29s |\n","Ma San Pham","Ten San Pham","So Luong","Don Gia","Xuat Xu","Ma Loai San Pham","Ngay San Xuat","Thong Tin Them 1","Thong Tin Them 2" );
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------");
                        sp.xuat();
                    }else{
                        System.out.println("khong tim thay san pham ");
                    }
                case 7:
                    try {
                        dsSP.ghiFile(DuongDan.SANPHAM_FILE_PATH);
                        System.out.println("Ghi File thanh cong");
                        break;
                    } catch (IOException e) {
                        System.out.println("Ghi File loi!!!");
                    }
                case 8:
                    try {
                        dsSP.docFile(DuongDan.SANPHAM_FILE_PATH);
                        System.out.println("Doc File thanh cong");
                        break;                        
                    } catch (IOException e) {
                        System.out.println("Doc File loi!!!");
                    }                
                default:
                    return;
            }
        }while(true);
    }        
    
    public void QLHD(){
        Scanner sc = new Scanner(System.in);
        int chon;
        do {
            System.out.println("----------------------------------------------");
            System.out.println("             QUAN LY HOA DON");
            System.out.println("----------------------------------------------");
            System.out.println("1. Nhap danh sach hoa don"); 
            System.out.println("2. Them hoa don");
            System.out.println("3. Xuat danh sach hoa don");
            System.out.println("4. Sua hoa don");
            System.out.println("5. Xoa hoa don");
            System.out.println("6. Tim hoa don");
            System.out.println("7. Ghi FILE");
            System.out.println("8. Doc FILE");
            System.out.println("9. Thoat");
            System.out.print("Chon: ");
            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1: 
                    dsHD.nhap();
                    break;
                case 2:
                    dsHD.them();
                    break;
                case 3:
                    dsHD.xuat();
                    break;
                case 4:
                    dsHD.sua();
                    break;
                case 5:
                    dsHD.xoa();
                    break;
                case 6:
                    dsHD.timHoaDon();
                    break;
                case 7:
                    try {
                        dsHD.ghiFile(DuongDan.HOADON_FILE_PATH);
                        System.out.println("Ghi File thanh cong");
                        break;
                    } catch (IOException e) {
                        System.out.println("Ghi File loi!!!");
                    }
                case 8:
                    try {
                        dsHD.docFile(DuongDan.HOADON_FILE_PATH);
                        System.out.println("Doc File thanh cong");
                        break;                        
                    } catch (IOException e) {
                        System.out.println("Doc File loi!!!");
                    }                                    
                case 9:
                    System.out.println("Thoat danh sach hoa don");
                    break;
                default:
                    System.out.println("Lua chon khong hop le");
            }
        } while (chon != 9); 
    }         
    
    public void QLCTHD(){
        Scanner sc = new Scanner(System.in);
        int chon;
        int n=0,soLuong=0;
        String maHD,maSP;
        SanPham sp;
        do {
            System.out.println("----------------------------------------------");
            System.out.println("     QUAN LY CHI TIET HOA DON");
            System.out.println("----------------------------------------------");
            System.out.println("1. Nhap danh sach chi tiet hoa don"); 
            System.out.println("2. Them chi tiet hoa don");
            System.out.println("3. Xuat danh sach chi tiet hoa don");
            System.out.println("4. Sua chi tiet hoa don");
            System.out.println("5. Xoa chi tiet hoa don");
            System.out.println("6. Tim chi tiet hoa don");
            System.out.println("7. Ghi FILE");
            System.out.println("8. Doc FILE");
            System.out.println("9. Thoat");
            System.out.print("Chon: ");
            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1: 
                    System.out.println("Nhap so luong chi tiet hoa don can nhap");
                    n = Integer.parseInt(sc.nextLine());
                    for(int i=0;i < n;i++){
                        System.out.println("--- Nhap chi tiet hoa don thu " + (dsCTHD.getSoLuong() + 1) + " ---"); // Cập nhật lời nhắc
                        System.out.println("Nhap ma hoa don");
                        maHD = sc.nextLine();
                        do{
                            System.out.println("Nhap ma san pham");
                            maSP = sc.nextLine();
                            sp = dsSP.timTheoMaSP(maSP);
                            if(sp==null){
                                System.out.println("Loi ko tim thay san pham");
                            }
                        }while(sp==null);
                        do{
                            System.out.println("Nhap so luong");
                            soLuong = Integer.parseInt(sc.nextLine());
                            if(sp.getSoLuong()-soLuong<0){
                                System.out.println("Loi so luong vuot qua so luong san pham");
                            }
                        }while(sp.getSoLuong()-soLuong<0);
                        dsCTHD.them(new ChiTietHoaDon(maHD, maSP,soLuong, sp.getDonGia()));
                        dsSP.updateSoLuong(maSP,sp.getSoLuong()-soLuong); // Cap nhat so luong
                    }
                    System.out.println("Nhap danh sach thanh cong");
                    break;
                case 2:
                    System.out.println("Nhap so luong chi tiet hoa don can them");
                    n = Integer.parseInt(sc.nextLine());
                    for(int i=0;i < n;i++){
                        System.out.println("--- Them chi tiet hoa don thu " + (dsCTHD.getSoLuong()+1) + " ---");
                        System.out.println("Nhap ma hoa don");
                        maHD = sc.nextLine();
                        do{
                            System.out.println("Nhap ma san pham");
                            maSP = sc.nextLine();
                            sp = dsSP.timTheoMaSP(maSP);
                            if(sp==null){
                                System.out.println("Loi ko tim thay san pham");
                            }
                        }while(sp==null);
                        do{
                            System.out.println("Nhap so luong");
                            soLuong = Integer.parseInt(sc.nextLine());
                            if(sp.getSoLuong()-soLuong<0){
                                System.out.println("Loi so luong vuot qua so luong san pham");
                            }
                        }while(sp.getSoLuong()-soLuong<0);
                        dsCTHD.them(new ChiTietHoaDon(maHD, maSP,soLuong, sp.getDonGia()));
                        dsSP.updateSoLuong(maSP,sp.getSoLuong()-soLuong); // Cap nhat so luong
                    }
                    System.out.println("Them thanh cong");
                    break;
                case 3:
                    dsCTHD.xuat();
                    break;
                case 4:
                    dsCTHD.sua();
                    break;
                case 5:
                    dsCTHD.xoa();
                    break;
                case 6:
                    ChiTietHoaDon cthd = dsCTHD.tim();
                    if (cthd != null) {
                        System.out.println("Thong tin chi tiet hoa don:");
                        cthd.xuat();
                    } else {
                        System.out.println("Khong tim thay chi tiet");
                    }
                    break;
                case 7:
                    try {
                        dsCTHD.ghiFile(DuongDan.CTHOADON_FILE_PATH);
                        System.out.println("Ghi File thanh cong");
                        break;                        
                    } catch (IOException e) {
                        System.out.println("Ghi File loi!!!");
                    }
                case 8:
                    try {
                        dsCTHD.docFile(DuongDan.CTHOADON_FILE_PATH);
                        System.out.println("Doc File thanh cong");
                        break;
                    } catch (IOException e) {
                        System.out.println("Doc File loi!!!");
                    } 
                case 9:
                    System.out.println("Thoat danh sach chi tiet hoa don");
                    break;
                default:
                    System.out.println("Lua chon khong hop le");
            }
        } while (chon != 9); 
    }

    public void QLPNH(){
        Scanner sc = new Scanner(System.in);
        int chon;
        do {
            System.out.println("----------------------------------------------");
            System.out.println("        QUAN LY PHIEU NHAP HANG");
            System.out.println("----------------------------------------------");
            System.out.println("1. Nhap danh sach phieu nhap hang"); 
            System.out.println("2. Them phieu nhap hang");
            System.out.println("3. Xuat danh sach phieu nhap hang");
            System.out.println("4. Sua phieu nhap hang");
            System.out.println("5. Xoa phieu nhap hang");
            System.out.println("6. Ghi FILE");
            System.out.println("7. Doc FILE");
            System.out.println("8. Thoat");
            System.out.print("Chon: ");
            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1: 
                    dsPNH.nhap(); // Hàm nhap() của DSPhieuNhapHang vốn dĩ đã là append
                    break;
                case 2:
                    dsPNH.them();
                    break;
                case 3:
                    dsPNH.xuat();
                    break;
                case 4:
                    dsPNH.sua();
                    break;
                case 5:
                    dsPNH.xoa();
                    break;
                case 6:
                    try {
                        dsPNH.ghiFile(DuongDan.PHIEUNHAP_FILE_PATH);
                        System.out.println("Ghi File thanh cong");
                        break;
                    } catch (IOException e) {
                        System.out.println("Ghi File loi!!!");
                    }
                case 7:
                    try {
                        dsPNH.docFile(DuongDan.PHIEUNHAP_FILE_PATH);
                        System.out.println("Doc File thanh cong");
                        break;
                    } catch (IOException e) {
                        System.out.println("Doc File loi!!!");
                    } 
                case 8:
                    System.out.println("Thoat danh sach phieu nhap hang");
                    break;
                default:
                    System.out.println("Lua chon khong hop le");
            }
        } while (chon != 8); 
    }

    public void QLCTPNH(){
        Scanner sc = new Scanner(System.in);
        int chon;
        int n=0,soLuong=0;
        String maPNH,maSP;
        SanPham sp;
        do {
            System.out.println("----------------------------------------------");
            System.out.println("        QUAN LY CHI TIET PHIEU NHAP HANG");
            System.out.println("----------------------------------------------");
            System.out.println("1. Nhap danh sach chi tiet phieu nhap"); 
            System.out.println("2. Them chi tiet phieu nhap");
            System.out.println("3. Xuat danh sach chi tiet phieu nhap");
            System.out.println("4. Sua chi tiet phieu nhap");
            System.out.println("5. Xoa chi tiet phieu nhap");
            System.out.println("6. Tim chi tiet phieu nhap");
            System.out.println("7. Ghi FILE");
            System.out.println("8. Doc FILE");
            System.out.println("9. Thoat");
            System.out.print("Chon: ");
            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1:
                    System.out.println("Nhap so luong chi tiet phieu nhap hang can nhap");
                    n = Integer.parseInt(sc.nextLine());
                    for(int i=0;i < n;i++){
                        System.out.println("--- Nhap chi tiet phieu nhap thu " + (dsCTPNH.getSoLuong() + 1) + " ---"); // Cập nhật lời nhắc
                        System.out.println("Nhap ma phieu nhap hang");
                        maPNH = sc.nextLine();
                        do{
                            System.out.println("Nhap ma san pham");
                            maSP = sc.nextLine();
                            sp = dsSP.timTheoMaSP(maSP);
                            if(sp==null){
                                System.out.println("Loi ko tim thay san pham");
                            }
                        }while(sp==null);
                        System.out.println("Nhap so luong");
                        soLuong = Integer.parseInt(sc.nextLine());
                        dsCTPNH.them(new ChiTietPhieuNhap(maPNH, maSP,soLuong, sp.getDonGia()));
                        dsSP.updateSoLuong(maSP,sp.getSoLuong()+soLuong); // Cap nhat so luong
                    }
                    System.out.println("Nhap danh sach thanh cong");
                    break;
                case 2:
                    System.out.println("Nhap so luong chi tiet phieu nhap hang can them");
                    n = Integer.parseInt(sc.nextLine());
                    for(int i=0;i < n;i++){
                        System.out.println("--- Them chi tiet phieu nhap thu " + (dsCTPNH.getSoLuong()+1) + " ---");
                        System.out.println("Nhap ma phieu nhap hang");
                        maPNH = sc.nextLine();
                        do{
                            System.out.println("Nhap ma san pham");
                            maSP = sc.nextLine();
                            sp = dsSP.timTheoMaSP(maSP);
                            if(sp==null){
                                System.out.println("Loi ko tim thay san pham");
                            }
                        }while(sp==null);
                        System.out.println("Nhap so luong");
                        soLuong = Integer.parseInt(sc.nextLine());
                        dsCTPNH.them(new ChiTietPhieuNhap(maPNH, maSP,soLuong, sp.getDonGia()));
                        dsSP.updateSoLuong(maSP,sp.getSoLuong()+soLuong); // Cap nhat so luong
                    }
                    System.out.println("Them thanh cong");
                    break;
                case 3:
                    dsCTPNH.xuat();
                    break;
                case 4:
                    dsCTPNH.sua();
                    break;
                case 5:
                    dsCTPNH.xoa();
                    break;
                case 6:
                    ChiTietPhieuNhap ctpn = dsCTPNH.tim();
                     if (ctpn != null) {
                        System.out.println("Thong tin chi tiet phieu nhap:");
                        ctpn.xuat();
                    } else {
                        System.out.println("Khong tim thay chi tiet");
                    }
                    break;
                case 7:
                    try {
                        dsCTPNH.ghiFile(DuongDan.CTPHIEUNHAP_FILE_PATH);
                        System.out.println("Ghi File thanh cong");
                        break;
                    } catch (IOException e) {
                        System.out.println("Ghi File loi!!!");
                    }
                case 8:
                    try {
                        dsCTPNH.docFile(DuongDan.CTPHIEUNHAP_FILE_PATH);
                        System.out.println("Doc File thanh cong");
                        break;
                    } catch (IOException e) {
                        System.out.println("Doc File loi!!!");
                    } 
                case 9:
                    System.out.println("Thoat danh sach chi tiet phieu nhap");
                    break;
                default:
                    System.out.println("Lua chon khong hop le");
            }
        } while (chon != 9);
    }

    public void QLNCC(){
        Scanner sc = new Scanner(System.in);
        int chon = 0;
        do{
            System.out.println("----------------------------------------------");
            System.out.println("             QUAN LY NHA CUNG CAP");
            System.out.println("----------------------------------------------");
            System.out.println("1.Nhap danh sach nha cung cap");
            System.out.println("2.Xuat danh sach nha cung cap");
            System.out.println("3.Them");
            System.out.println("4.Sua");
            System.out.println("5.Xoa");
            System.out.println("6.Tim");
            System.out.println("7.Thoat");
            System.out.println("Chon: ");
            chon = Integer.parseInt(sc.nextLine());
            switch (chon) {
                case 1:
                    dsNCC.nhap();
                    break;
                case 2:
                    dsNCC.xuat();
                    break;
                case 3:
                    dsNCC.them();
                    System.out.println("them thanh cong");
                    break;            
                case 4:
                    dsNCC.sua();
                    System.out.println("sua thanh cong");
                    break;            
                case 5:              
                    dsNCC.xoa();
                    System.out.println("xoa thanh cong");
                    break;
                case 6:
                    NhaCungCap ncc;
                    ncc = dsNCC.tim();
                    if(ncc!=null){ 
                        ncc.xuat();
                    }else{
                        System.out.println("khong tim thay ");
                    } 
                    break;      
                default:
                    return;
            }
        }while(true);
    } 

    public void QLKH(){
        Scanner sc = new Scanner(System.in);
        int chon = 0;
        do{
            System.out.println("----------------------------------------------");
            System.out.println("             QUAN LY NHA KHACH HANG");
            System.out.println("----------------------------------------------");
            System.out.println("1.Nhap danh sach khach hang");
            System.out.println("2.Xuat danh sach khach hang");
            System.out.println("3.Them");
            System.out.println("4.Sua");
            System.out.println("5.Xoa");
            System.out.println("6.Tim");
            System.out.println("7.Thoat");
            System.out.println("Chon: ");
            chon = Integer.parseInt(sc.nextLine());
            switch (chon) {
                case 1:
                    dsKH.nhap();
                    break;
                case 2:
                    dsKH.xuat();
                    break;
                case 3:
                    dsKH.them();
                    System.out.println("them thanh cong");
                    break;            
                case 4:
                    dsKH.sua();
                    System.out.println("sua thanh cong");
                    break;            
                case 5:              
                    dsKH.xoa();
                    System.out.println("xoa thanh cong");
                    break;
                case 6:
                    KhachHang kh;
                    kh = dsKH.tim();
                    if(kh!=null){ 
                        kh.xuat();
                    }else{
                        System.out.println("khong tim thay ");
                    } 
                    break;      
                default:
                    return;
            }
        }while(true);
    } 

    public void QLNV(){
        Scanner sc = new Scanner(System.in);
        int chon = 0;
        do{
            System.out.println("----------------------------------------------");
            System.out.println("             QUAN LY NHAN VIEN");
            System.out.println("----------------------------------------------");
            System.out.println("1.Nhap danh sach nhan vien");
            System.out.println("2.Xuat danh sach nhan vien");
            System.out.println("3.Them");
            System.out.println("4.Sua");
            System.out.println("5.Xoa");
            System.out.println("6.Tim");
            System.out.println("7.Thoat");
            System.out.println("Chon: ");
            chon = Integer.parseInt(sc.nextLine());
            switch (chon) {
                case 1:
                    dsNV.nhap();
                    break;
                case 2:
                    dsNV.xuat();
                    break;
                case 3:
                    dsNV.them();
                    System.out.println("them thanh cong");
                    break;            
                case 4:
                    dsNV.sua();
                    System.out.println("sua thanh cong");
                    break;            
                case 5:              
                    dsNV.xoa();
                    System.out.println("xoa thanh cong");
                    break;
                case 6:
                    NhanVien nv;
                    nv = dsNV.tim();
                    if(nv!=null){ 
                        nv.xuat();
                    }else{
                        System.out.println("khong tim thay ");
                    } 
                    break;      
                default:
                    return;
            }
        }while(true);
    } 
    
    public void menuThongKe(){
        Scanner sc = new Scanner(System.in);
        int chon =0;
        do{
            System.out.println("----------------------------------------------");
            System.out.println("                  THONG KE");
            System.out.println("----------------------------------------------");
            System.out.println("1. Thong ke tong tien hoa don theo khoang ngay");
            System.out.println("2. Thong ke tong tien theo quy");
            System.out.println("3. Thong ke tong tien hoa don theo ma KH");
            System.out.println("4. Thoat");
            System.out.print("Chon: ");  
            chon = Integer.parseInt(sc.nextLine());
            switch (chon) {
                case 1:
                    dsHD.ThongKeTheoKhoangNgay();
                    break;
                case 2:
                    System.out.print("Nhap nam can thong ke :");
                    int nam = Integer.parseInt(sc.nextLine());
                    double[] tongThu = dsHD.ThongKeTongThuTheoQuy(nam);
                    double[] tongChi = dsPNH.ThongKeTongChiTheoQuy(nam);
                    int[] soLuongHD = dsHD.ThongKeHoaDonTheoQuy(nam);

                    System.out.println("=============================THONG KE TONG TIEN THEO QUY======================================");
                    System.out.printf("|%-10s|%-15s|%-15s|%-15s|%-15s|%-15s|\n", "","Quy 1","Quy 2","Quy 3","Quy 4","Tong Cong");
                    System.out.println("----------------------------------------------------------------------------------------------");
                    double tongCongThu = 0;
                    System.out.printf("|%-10s|", "Tong Thu");
                    for(int i=0;i<4;i++){
                        System.out.printf("%-15s|",String.format("%,.0f", tongThu[i]));
                        tongCongThu+=tongThu[i];
                    }
                    System.out.printf("%-15s|\n",String.format("%,.0f", tongCongThu) );
                    System.out.println("---------------------------------------------------------------------------------------------");

                    int tongCongHD = 0;
                    System.out.printf("|%-10s|", "Hoa Don");
                    for(int i=0;i<4;i++){
                        System.out.printf("%-15d|",soLuongHD[i]);
                        tongCongHD+=soLuongHD[i];
                    }
                    System.out.printf("%-15d|\n",tongCongHD);
                    System.out.println("---------------------------------------------------------------------------------------------");

                    double tongCongChi = 0;
                    System.out.printf("|%-10s|", "Tong Chi");
                    for(int i=0;i<4;i++){
                        System.out.printf("%-15s|",String.format("%,.0f", tongChi[i]));
                        tongCongChi+=tongChi[i];
                    }
                    System.out.printf("%-15s|\n",String.format("%,.0f", tongCongChi) );
                    System.out.println("---------------------------------------------------------------------------------------------");

                    double tongLoiNhuan = 0;
                    System.out.printf("|%-10s|", "Loi Nhuan");
                    for(int i=0;i<4;i++){
                        System.out.printf("%-15s|",String.format("%,.0f",tongThu[i]-tongChi[i]));
                        tongLoiNhuan+=tongThu[i]-tongChi[i];
                    }
                    System.out.printf("%-15s|\n",String.format("%,.0f", tongLoiNhuan) );
                    System.out.println("---------------------------------------------------------------------------------------------");                    
                    break;
                case 3:
                    dsHD.ThongKeTongTienKHTheoQuy();  
                    break;
                default:
                    return;
            }          
        }while(true);
    }
    
    public void mua(){
        Scanner sc = new Scanner(System.in);
        String maHD,maKH,maNV,maSP,httt;
        int soLuong;
        double tongTien=0;
        SanPham sp;
        System.out.print("Nhap ma hoa don");
        maHD = sc.nextLine();
        System.out.print("Nhap ma nhan vien");
        maNV = sc.nextLine();
        System.out.print("Nhap ma khach hang");
        maKH = sc.nextLine();
        
        int chonTim = 0;
        System.out.println("Chon cach tim san pham");
        System.out.println("1.Tim san pham theo ma");
        System.out.println("2.Tim san pham theo ten");
        chonTim = Integer.parseInt(sc.nextLine());
        while (chonTim!=1 || chonTim!=2) {
            System.out.println("Lua chon khong hop le. Vui long chon 1 (Ma) hoac 2 (Ten).");
            chonTim = Integer.parseInt(sc.nextLine());
        }


        System.out.println("----------------------------------------------");
        System.out.println("Nhap chi tiet san pham (nhap 0 de ket thuc)");
        System.out.println("----------------------------------------------");
        while (true) {        
            if(chonTim==1){
                System.out.print("Ma SP: ");
                maSP = sc.nextLine();
                if(maSP.equals("0")) break;            

                sp = dsSP.timTheoMaSP(maSP);

            }else {
                System.out.print("Ten SP:");
                String tenSP = sc.nextLine();
                if(tenSP.equals("0")) break;    

                sp = dsSP.timTheoTenSP(tenSP);
                maSP = sp.getMaSP();
            }
            if(sp==null){
                System.out.println("Khong tim thay san pham!!");
                continue;
            }
            do{
                System.out.print("So luong: ");
                soLuong = Integer.parseInt(sc.nextLine());
                if(sp.getSoLuong() - soLuong < 0){
                    System.out.println("So luong khong duoc vuot qua so luong con lai.Vui long nhap lai!");
                }
            }while(sp.getSoLuong() - soLuong < 0);
            System.out.println("=>Thanh tien: " + String.format("%,.0f VND", (double)soLuong*sp.getDonGia()) +"\n" );
            sp.setSoLuong(sp.getSoLuong()-soLuong);
            tongTien += soLuong*sp.getDonGia();
            dsCTHD.them(new ChiTietHoaDon(maHD,maSP,soLuong,sp.getDonGia()));
        }
        System.out.println("----------------------------------------------");    
        System.out.println("=>Tong tien: " + String.format("%,.0f VND", tongTien));    
        System.out.print("Hinh thuc thanh toan");
        httt = sc.nextLine();

        String ngayTaoHoaDon = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        HoaDon hd = new HoaDon(maHD,maNV,maKH,ngayTaoHoaDon,httt,tongTien);
        dsHD.them(hd);
        hd.xuat();
    }
    
    public void nhapHang(){
        Scanner sc = new Scanner(System.in);
        String maPNH,maNCC,maNV,maSP;
        int soLuong;
        double tongTien=0;
        SanPham sp;
        System.out.println("nhap ma phieu nhap hang ");
        maPNH = sc.nextLine();
        System.out.println("nhap ma nha cung cap ");
        maNCC = sc.nextLine();
        System.out.println("nhap ma nhan vien ");
        maNV = sc.nextLine();

        int chonTim = 0;
        System.out.println("Chon cach tim san pham");
        System.out.println("1.Tim san pham theo ma");
        System.out.println("2.Tim san pham theo ten");
        chonTim = Integer.parseInt(sc.nextLine());
        while (chonTim!=1 || chonTim!=2) {
            System.out.println("Lua chon khong hop le. Vui long chon 1 (Ma) hoac 2 (Ten).");
            chonTim = Integer.parseInt(sc.nextLine());
        }

        System.out.println("----------------------------------------------");
        System.out.println("Nhap chi tiet san pham (nhap 0 de ket thuc)");
        System.out.println("----------------------------------------------");

        while(true){
            if(chonTim==1){
                System.out.print("Ma SP: ");
                maSP = sc.nextLine();
                if(maSP.equals("0")) break;            

                sp = dsSP.timTheoMaSP(maSP);

            }else {
                System.out.print("Ten SP:");
                String tenSP = sc.nextLine();
                if(tenSP.equals("0")) break;    

                sp = dsSP.timTheoTenSP(tenSP);
                maSP = sp.getMaSP();
            }
            if(sp==null){
                System.out.println("Khong tim thay san pham!!");
                continue;
            }
            do{
                System.out.print("So luong: ");
                soLuong = Integer.parseInt(sc.nextLine());
                if(soLuong<0) System.out.println("So luong phai khac am.Vui long nhap lai!");
            }while(soLuong<0);

            System.out.println("=>Thanh tien: " + String.format("%,.0f VND", (double)soLuong*sp.getDonGia()) +"\n" );

            tongTien+= soLuong*sp.getDonGia();
            sp.setSoLuong(sp.getSoLuong()+soLuong);
            dsCTPNH.them(new ChiTietPhieuNhap(maPNH, maSP, soLuong, sp.getDonGia()));
        }
        System.out.println("----------------------------------------------");    
        System.out.println("=>Tong tien: " + String.format("%,.0f VND", tongTien) + "\n");  

        String ngayTaoPhieuNhapHang = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        PhieuNhapHang pnh = new PhieuNhapHang(maPNH,maNCC,maNV,ngayTaoPhieuNhapHang,tongTien);
        dsPNH.them(pnh);
        pnh.xuat();

    }
    
    public void menu(){
        Scanner sc = new Scanner(System.in);
        int chon = 0;
        do{
            System.out.println("==============================================");
            System.out.println("          CHUONG TRINH QUAN LY SIEU THI");
            System.out.println("==============================================");
            System.out.println("1.Quan ly san pham");
            System.out.println("2.Quan ly hoa don");
            System.out.println("3.Quan ly chi tiet hoa don");
            System.out.println("4.Quan ly phieu nhap");
            System.out.println("5.Quan ly chi tiet phieu nhap");
            System.out.println("6.Quan ly nha cung cap");
            System.out.println("7.Quan ly khach hang");
            System.out.println("8.Quan ly nhan vien");
            System.out.println("9.Mua hang");
            System.out.println("10.Nhap hang");
            System.out.println("11.Thong ke");
            System.out.println("12.Thoat");
            System.out.println("Chon :");
            chon = Integer.parseInt(sc.nextLine());
            switch (chon) {
                case 1:
                    QLSP();
                    break;
                case 2:
                    QLHD();
                    break;
                case 3:
                    QLCTHD();
                    break;
                case 4:
                    QLPNH();
                    break;
                case 5:
                    QLCTPNH();
                    break;
                case 6:
                    QLNCC();
                    break;
                case 7:
                    QLKH();
                    break;
                case 8:
                    QLNV();
                    break;
                case 9:
                    mua();
                    break;  
                case 10:
                    nhapHang();
                    break; 
                case 11:
                    menuThongKe();
                    break;             
                default:
                    return;
            }
        }while(true);
    }
}
