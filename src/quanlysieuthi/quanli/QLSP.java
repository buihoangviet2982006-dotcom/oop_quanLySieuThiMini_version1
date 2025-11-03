package quanlysieuthi.quanli;

import java.io.IOException;
import java.util.Scanner;

import quanlysieuthi.SanPham.SanPham;
import quanlysieuthi.tienich.DuongDan;

public class QLSP extends QLST{
    @Override
    public void menu(){
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
            System.out.println("7.Thong ke so luong san pham");
            System.out.println("8.Ghi FILE");
            System.out.println("9.Doc FILE");
            System.out.println("10.Thoat");
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
                    break;            
                case 4:
                    dsSP.sua();
                    break;            
                case 5:              
                    dsSP.xoa();
                    break;
                case 6:
                    SanPham sp;
                    sp = dsSP.tim();
                    if(sp!=null){
                        System.out.printf("| %-10s | %-15s | %-5s | %-15s | %-10s | %-7s | %-10s | %-21s | %-29s |\n","Ma San Pham","Ten San Pham","So Luong","Don Gia","Ma Hang","Ma Loai","Ngay San Xuat","Thong Tin Them 1","Thong Tin Them 2" );
                        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------");
                        sp.xuat();
                    }else{
                        System.out.println("khong tim thay san pham ");
                    }
                    break;
                case 7:
                    dsSP.thongKeSoLuongLoaiSanPham();
                    break;
                case 8:
                    try {
                        dsSP.ghiFile(DuongDan.SANPHAM_FILE_PATH);
                        break;
                    } catch (IOException e) {
                        System.out.println("Ghi File loi!!!");
                    }
                case 9:
                    try {
                        dsSP.docFile(DuongDan.SANPHAM_FILE_PATH);
                        break;                        
                    } catch (IOException e) {
                        System.out.println("Doc File loi!!!");
                    }                
                default:
                    return;
            }
        }while(true);
    }     
}
