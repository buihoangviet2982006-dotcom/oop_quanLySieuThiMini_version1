package quanlysieuthi.quanli;

import java.io.IOException;
import java.util.Scanner;

import quanlysieuthi.tienich.DuongDan;

public class QLHD extends QLST{
    @Override
    public void menu(){
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
            System.out.println("7. Thong ke so luong hoa don");
            System.out.println("8. Ghi FILE");
            System.out.println("9. Doc FILE");
            System.out.println("10. Thoat");
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
                    dsHD.thongKeSoLuong();
                    break;
                case 8:
                    try {
                        dsHD.ghiFile(DuongDan.HOADON_FILE_PATH);
                        break;
                    } catch (IOException e) {
                        System.out.println("Ghi File loi!!!");
                    }
                case 9:
                    try {
                        dsHD.docFile(DuongDan.HOADON_FILE_PATH);
                        break;                        
                    } catch (IOException e) {
                        System.out.println("Doc File loi!!!");
                    }                                    
                case 10:
                    System.out.println("Thoat danh sach hoa don");
                    break;
                default:
                    System.out.println("Lua chon khong hop le");
            }
        } while (chon != 10); 
    }          
}
