package quanlysieuthi.quanli;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import quanlysieuthi.Phieu.ChiTietPhieuNhap;
import quanlysieuthi.Phieu.PhieuNhapHang;
import quanlysieuthi.SanPham.SanPham;
import quanlysieuthi.danhsach.DSChiTietHD;
import quanlysieuthi.danhsach.DSChiTietPNH;
import quanlysieuthi.danhsach.DSHoaDon;
import quanlysieuthi.danhsach.DSKH;
import quanlysieuthi.danhsach.DSLSP;
import quanlysieuthi.danhsach.DSNV;
import quanlysieuthi.danhsach.DSNhaCungCap;
import quanlysieuthi.danhsach.DSPhieuNhapHang;
import quanlysieuthi.danhsach.DSSP;
import quanlysieuthi.hoadon.ChiTietHoaDon;
import quanlysieuthi.hoadon.HoaDon;

public class QLST {
    public static DSSP dsSP = new DSSP();
    public static DSChiTietHD dsCTHD = new DSChiTietHD();
    public static DSHoaDon dsHD = new DSHoaDon();
    public static DSPhieuNhapHang dsPNH = new DSPhieuNhapHang();
    public static DSChiTietPNH dsCTPNH = new DSChiTietPNH();
    public static DSNhaCungCap dsNCC = new DSNhaCungCap();
    public static DSKH dsKH = new DSKH();
    public static DSNV dsNV = new DSNV();
    public static DSLSP dslsp = new DSLSP();

    public QLST(){}
    
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
        while (chonTim!=1 && chonTim!=2) {
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
                if(sp==null){
                    System.out.println("Khong tim thay san pham!!");
                    continue;
                }
            }else {
                System.out.print("Ten SP:");
                String tenSP = sc.nextLine();
                if(tenSP.equals("0")) break;    

                sp = dsSP.timTheoTenSP(tenSP);
                if(sp==null){
                    System.out.println("Khong tim thay san pham!!");
                    continue;
                }                
                maSP = sp.getMaSP();
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
        while (chonTim!=1 && chonTim!=2) {
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
                if(sp==null){
                    System.out.println("Khong tim thay san pham!!");
                    continue;
                }
            }else {
                System.out.print("Ten SP:");
                String tenSP = sc.nextLine();
                if(tenSP.equals("0")) break;    

                sp = dsSP.timTheoTenSP(tenSP);
                if(sp==null){
                    System.out.println("Khong tim thay san pham!!");
                    continue;
                }                
                maSP = sp.getMaSP();
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
    
    public void menu(){}
}
