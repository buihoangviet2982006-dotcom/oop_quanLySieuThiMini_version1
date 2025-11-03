package quanlysieuthi.quanli;

import java.util.Scanner;

import quanlysieuthi.Nguoi.NhaCungCap;
import quanlysieuthi.danhsach.DSNhaCungCap;

public class QLNCC extends QLST{
    @Override
    public void menu(){
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
            System.out.println("7.Thong ke theo dia chi nha cung cap");
            System.out.println("8.Thong ke so luong nha cung cap");
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
                    break;            
                case 4:
                    dsNCC.sua();
                    break;            
                case 5:              
                    dsNCC.xoa();
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
                case 7:
                    System.out.println("Nhap dia chi : ");
                    String diaChi = sc.nextLine();
                    DSNhaCungCap ds = dsNCC.thongKeTheoDiaChi(diaChi);
                    if(ds==null){
                        System.out.println("Khong co nha cung cap vơi dia chi "+diaChi );
                    }else{
                        ds.xuat();
                    }
                    break;
                case 8:
                    dsNCC.thongKeSoLuongNhaCungCap();
                    break;
                default:
                    return;
            }
        }while(true);
    }     
}
