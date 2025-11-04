package quanlysieuthi.quanli;

import java.util.Scanner;

public class HeThong {
    public static QLST qlst;
    public HeThong(){
        qlst = new QLST();       
    }
    public static void menuChinh(){
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
            System.out.println("9.Quan ly loai san pham");
            System.out.println("10.Quan ly hang san xuat"); 
            System.out.println("11.Mua hang"); 
            System.out.println("12.Nhap hang"); 
            System.out.println("13.Thong ke");
            System.out.println("14.Luu tat ca du lieu (GHI FILE)");  
            System.out.println("15.Tai tat ca du lieu (DOC FILE)"); 
            System.out.println("16.Xoa tat ca du lieu (TU TRONG)"); 
            System.out.println("17.Thoat");
            System.out.println("Chon :");
            chon = Integer.parseInt(sc.nextLine());
            switch (chon) {
                case 1:
                    qlst = new QLSP();
                    qlst.menu();
                    break;
                case 2:
                    qlst = new QLHD();
                    qlst.menu();
                    break;
                case 3:
                    qlst = new QLCTHD();
                    qlst.menu();
                    break;
                case 4:
                    qlst = new QLPNH();
                    qlst.menu();
                    break;
                case 5:
                    qlst = new QLCTPNH();
                    qlst.menu();
                    break;
                case 6:
                    qlst = new QLNCC();
                    qlst.menu();
                    break;
                case 7:
                    qlst = new QLKH();
                    qlst.menu();
                    break;
                case 8:
                    qlst = new QLNV();
                    qlst.menu();
                    break;
                case 9:
                    qlst = new QLLSP();
                    qlst.menu();
                    break;
                case 10: 
                    qlst = new QLHSX();
                    qlst.menu();
                    break;
                case 11: 
                    qlst = new QLST();
                    qlst.mua();
                    break;  
                case 12: 
                    qlst = new QLST();
                    qlst.nhapHang();
                    break; 
                case 13: 
                    qlst = new QLST();
                    qlst.menuThongKe();
                    break;   
                case 14: 
                    qlst = new QLST();
                    qlst.ghiTatCaFile();
                    break;
                case 15:
                    qlst = new QLST();
                    qlst.docTatCaFile();
                    break;
                case 16:
                    qlst = new QLST();
                    qlst.xoaTatCaDanhSach();
                    break;            
                default:
                    return;
            }
        }while(true);
    }    
}