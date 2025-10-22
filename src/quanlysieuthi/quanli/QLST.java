package quanlysieuthi.quanli;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import quanlysieuthi.Phieu.ChiTietPhieuNhap;
import quanlysieuthi.Phieu.PhieuNhapHang;
import quanlysieuthi.SanPham.SanPham;
import quanlysieuthi.danhsach.DSChiTietHD;
import quanlysieuthi.danhsach.DSChiTietPNH;
import quanlysieuthi.danhsach.DSHoaDon;
import quanlysieuthi.danhsach.DSPhieuNhapHang;
import quanlysieuthi.danhsach.DSSP;
import quanlysieuthi.hoadon.ChiTietHoaDon;
import quanlysieuthi.hoadon.HoaDon;
import quanlysieuthi.thongke.ThongKe;
import quanlysieuthi.tienich.DuongDan;

public class QLST {
    private DSSP dsSP;
    private DSChiTietHD dsCTHD;
    private DSHoaDon dsHD;
    private DSPhieuNhapHang dsPNH;
    private DSChiTietPNH dsCTPNH;
    private ThongKe tk;
    public QLST(){
        dsSP = new DSSP();
        dsCTHD = new DSChiTietHD();
        dsHD = new DSHoaDon();
        dsCTPNH = new DSChiTietPNH();
        dsPNH = new DSPhieuNhapHang();
        tk = new ThongKe(dsSP, dsCTHD, dsHD, dsCTPNH, dsPNH);
    }
    public QLST(DSSP dsSP,DSChiTietHD dsCTHD,DSHoaDon dsHD,DSChiTietPNH dsCTPNH,DSPhieuNhapHang dsPNH){
        this.dsCTHD = dsCTHD;
        this.dsHD = dsHD;
        this.dsCTPNH = dsCTPNH;
        this.dsPNH = dsPNH;
        this.dsSP = dsSP;
        tk = new ThongKe(dsSP, dsCTHD, dsHD, dsCTPNH, dsPNH);
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
            System.out.println("1. Them hoa don");
            System.out.println("2. Xuat danh sach hoa don");
            System.out.println("3. Sua hoa don");
            System.out.println("4. Xoa hoa don");
            System.out.println("5. Tim hoa don");
            System.out.println("6. Ghi FILE");
            System.out.println("7. Doc FILE");
            System.out.println("8. Thoat");
            System.out.print("Chon: ");
            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1:
                    dsHD.them();
                    break;
                case 2:
                    dsHD.xuat();
                    break;
                case 3:
                    dsHD.sua();
                    break;
                case 4:
                    dsHD.xoa();
                    break;
                case 5:
                    dsHD.timHoaDon();
                    break;
                case 6:
                    try {
                        dsHD.ghiFile(DuongDan.HOADON_FILE_PATH);
                        System.out.println("Ghi File thanh cong");
                        break;
                    } catch (IOException e) {
                        System.out.println("Ghi File loi!!!");
                    }
                case 7:
                    try {
                        dsHD.docFile(DuongDan.HOADON_FILE_PATH);
                        System.out.println("Doc File thanh cong");
                        break;                        
                    } catch (IOException e) {
                        System.out.println("Doc File loi!!!");
                    }                                    
                case 8:
                    System.out.println("Thoat danh sach hoa don");
                    break;
                default:
                    System.out.println("Lua chon khong hop le");
            }
        } while (chon != 8);
    }        
    
    public void QLCTHD(){
        Scanner sc = new Scanner(System.in);
        int chon;
        do {
            System.out.println("----------------------------------------------");
            System.out.println("     QUAN LY CHI TIET HOA DON");
            System.out.println("----------------------------------------------");
            System.out.println("1. Them chi tiet hoa don");
            System.out.println("2. Xuat danh sach chi tiet hoa don");
            System.out.println("3. Sua chi tiet hoa don");
            System.out.println("4. Xoa chi tiet hoa don");
            System.out.println("5. Tim chi tiet hoa don");
            System.out.println("6. Ghi FILE");
            System.out.println("7. Doc FILE");
            System.out.println("8. Thoat");
            System.out.print("Chon: ");
            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1:
                    dsCTHD.them();
                    break;
                case 2:
                    dsCTHD.xuat();
                    break;
                case 3:
                    dsCTHD.sua();
                    break;
                case 4:
                    dsCTHD.xoa();
                    break;
                case 5:
                    dsCTHD.timChiTietHD();
                    break;
                case 6:
                    try {
                        dsCTHD.ghiFile(DuongDan.CTHOADON_FILE_PATH);
                        System.out.println("Ghi File thanh cong");
                        break;                        
                    } catch (IOException e) {
                        System.out.println("Ghi File loi!!!");
                    }
                case 7:
                    try {
                        dsCTHD.docFile(DuongDan.CTHOADON_FILE_PATH);
                        System.out.println("Doc File thanh cong");
                        break;
                    } catch (IOException e) {
                        System.out.println("Doc File loi!!!");
                    } 
                case 8:
                    System.out.println("Thoat danh sach chi tiet hoa don");
                    break;
                default:
                    System.out.println("Lua chon khong hop le");
            }
        } while (chon != 8);        
    }

    public void QLPNH(){
        Scanner sc = new Scanner(System.in);
        int chon;
        do {
            System.out.println("----------------------------------------------");
            System.out.println("        QUAN LY PHIEU NHAP HANG");
            System.out.println("----------------------------------------------");
            System.out.println("1. Them phieu nhap hang");
            System.out.println("2. Xuat danh sach phieu nhap hang");
            System.out.println("3. Sua phieu nhap hang");
            System.out.println("4. Xoa phieu nhap hang");
            System.out.println("5. Ghi FILE");
            System.out.println("6. Doc FILE");
            System.out.println("7. Thoat");
            System.out.print("Chon: ");
            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1:
                    dsPNH.them();
                    break;
                case 2:
                    dsPNH.xuat();
                    break;
                case 3:
                    dsPNH.sua();
                    break;
                case 4:
                    dsPNH.xoa();
                    break;
                case 5:
                    try {
                        dsPNH.ghiFile(DuongDan.PHIEUNHAP_FILE_PATH);
                        System.out.println("Ghi File thanh cong");
                        break;
                    } catch (IOException e) {
                        System.out.println("Ghi File loi!!!");
                    }
                case 6:
                    try {
                        dsPNH.docFile(DuongDan.PHIEUNHAP_FILE_PATH);
                        System.out.println("Doc File thanh cong");
                        break;
                    } catch (IOException e) {
                        System.out.println("Doc File loi!!!");
                    } 
                case 7:
                    System.out.println("Thoat danh sach phieu nhap hang");
                    break;
                default:
                    System.out.println("Lua chon khong hop le");
            }
        } while (chon != 7);
    }

    public void QLCTPNH(){
        Scanner sc = new Scanner(System.in);
        int chon;
        do {
            System.out.println("----------------------------------------------");
            System.out.println("        QUAN LY CHI TIET PHIEU NHAP HANG");
            System.out.println("----------------------------------------------");
            System.out.println("1. Them chi tiet phieu nhap");
            System.out.println("2. Xuat danh sach chi tiet phieu nhap");
            System.out.println("3. Sua chi tiet phieu nhap");
            System.out.println("4. Xoa chi tiet phieu nhap");
            System.out.println("5. Ghi FILE");
            System.out.println("6. Doc FILE");
            System.out.println("7. Thoat");
            System.out.print("Chon: ");
            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1:
                    dsCTPNH.them();
                    break;
                case 2:
                    dsCTPNH.xuat();
                    break;
                case 3:
                    dsCTPNH.sua();
                    break;
                case 4:
                    dsCTPNH.xoa();
                    break;
                case 5:
                    try {
                        dsCTPNH.ghiFile(DuongDan.CTPHIEUNHAP_FILE_PATH);
                        System.out.println("Ghi File thanh cong");
                        break;
                    } catch (IOException e) {
                        System.out.println("Ghi File loi!!!");
                    }
                case 6:
                    try {
                        dsCTPNH.docFile(DuongDan.CTPHIEUNHAP_FILE_PATH);
                        System.out.println("Doc File thanh cong");
                        break;
                    } catch (IOException e) {
                        System.out.println("Doc File loi!!!");
                    } 
                case 7:
                    System.out.println("Thoat danh sach chi tiet phieu nhap");
                    break;
                default:
                    System.out.println("Lua chon khong hop le");
            }
        } while (chon != 7);        
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
                    tk.ThongKeTheoKhoangNgay();
                    break;
                case 2:
                    tk.ThongKeTongTienTheoQuy();
                    break;
                case 3:
                    tk.ThongKeTongTienKHTheoQuy();    
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
        
        System.out.println("----------------------------------------------");
        System.out.println("Nhap chi tiet san pham (nhap 0 de ket thuc)");
        System.out.println("----------------------------------------------");
        while (true) {        
            System.out.print("Ma SP: ");
            maSP = sc.nextLine();
            if(maSP.equals("0")) break;            

            sp = dsSP.timTheoMaSP(maSP);
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
            dsCTHD.them(new ChiTietHoaDon(maHD,maSP,soLuong,sp.getDonGia(),soLuong*sp.getDonGia()));
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

        System.out.println("----------------------------------------------");
        System.out.println("Nhap chi tiet san pham (nhap 0 de ket thuc)");
        System.out.println("----------------------------------------------");

        while(true){
            System.out.print("Ma SP: ");
            maSP = sc.nextLine();
            if(maSP.equals("0")) break;            

            sp = dsSP.timTheoMaSP(maSP);
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
            dsCTPNH.them(new ChiTietPhieuNhap(maPNH, maSP, soLuong, sp.getDonGia(),soLuong*sp.getDonGia()));
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
            System.out.println("6.Mua hang");
            System.out.println("7.Nhap hang");
            System.out.println("8.Thong ke");
            System.out.println("9.Thoat");
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
                    mua();
                    break;  
                case 7:
                    nhapHang();
                    break; 
                case 8:
                    menuThongKe();
                    break;             
                default:
                    return;
            }
        }while(true);
    }
}
