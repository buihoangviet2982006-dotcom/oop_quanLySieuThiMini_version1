package quanlysieuthi.quanli;

import java.io.IOException; // THEM MOI
import java.util.Scanner;

import quanlysieuthi.Nguoi.KhachHang;
import quanlysieuthi.tienich.DuongDan; // THEM MOI

public class QLKH extends QLST{
    @Override
    public void menu(){
        Scanner sc = new Scanner(System.in);
        int chon = 0;
        do{
            System.out.println("----------------------------------------------");
            System.out.println("             QUAN LY KHACH HANG");
            System.out.println("----------------------------------------------");
            System.out.println("1.Nhap danh sach khach hang");
            System.out.println("2.Xuat danh sach khach hang");
            System.out.println("3.Them");
            System.out.println("4.Sua");
            System.out.println("5.Xoa");
            System.out.println("6.Tim");
            System.out.println("7.Thong ke so luong khach hang");
            System.out.println("8.Ghi FILE"); // THEM MOI
            System.out.println("9.Doc FILE"); // THEM MOI
            System.out.println("10.Thoat"); // THAY DOI SO
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
                case 7:
                    dsKH.thongKeSoLuong();
                    break;    
                // --- THEM MOI ---
                case 8:
                    try {
                        dsKH.ghiFile(DuongDan.KHACHHANG_FILE_PATH);
                    } catch (IOException e) {
                        System.out.println("Ghi File loi!!!");
                    }
                    break;
                case 9:
                    try {
                        dsKH.docFile(DuongDan.KHACHHANG_FILE_PATH);
                    } catch (IOException e) {
                        System.out.println("Doc File loi!!!");
                    }
                    break;
                // --- KET THUC THEM MOI ---
                default:
                    return;
            }
        }while(true);
    }     
}