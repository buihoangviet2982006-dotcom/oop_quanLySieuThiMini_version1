package quanlysieuthi.quanli;

import java.util.Scanner;

import quanlysieuthi.Nguoi.NhanVien;

public class QLNV extends QLST{
    @Override
    public void menu(){
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
            System.out.println("7.Thong ke so luong nhan vien");
            System.out.println("8.Thoat");
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
                case 7:
                    dsNV.thongKeSoLuong();
                    break;     
                default:
                    return;
            }
        }while(true);
    }     
}
