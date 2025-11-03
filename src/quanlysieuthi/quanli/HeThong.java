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
            System.out.println("10.Mua hang");
            System.out.println("11.Nhap hang");
            System.out.println("12.Thong ke");
            System.out.println("13.Thoat");
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
                    qlst = new QLST();
                    qlst.mua();
                    break;  
                case 11:
                    qlst = new QLST();
                    qlst.nhapHang();
                    break; 
                case 12:
                    qlst = new QLST();
                    qlst.menuThongKe();
                    break;             
                default:
                    return;
            }
        }while(true);
    }    
}
