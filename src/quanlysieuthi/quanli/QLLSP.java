package quanlysieuthi.quanli;

import java.io.IOException; // THEM MOI
import java.util.Scanner;

import quanlysieuthi.SanPham.LoaiSanPham;
import quanlysieuthi.tienich.DuongDan; // THEM MOI

public class QLLSP extends QLST{
    @Override
    public void menu(){
        Scanner sc = new Scanner(System.in);
        int chon = 0;
        do{
            System.out.println("----------------------------------------------");
            System.out.println("             QUAN LY LOAI SAN PHAM");
            System.out.println("----------------------------------------------");
            System.out.println("1.Nhap danh sach loai san pham");
            System.out.println("2.Xuat danh sach loai san pham");
            System.out.println("3.Them");
            System.out.println("4.Sua");
            System.out.println("5.Xoa");
            System.out.println("6.Tim");
            System.out.println("7.Thong ke so luong loai san pham");
            System.out.println("8.Ghi FILE"); // THEM MOI
            System.out.println("9.Doc FILE"); // THEM MOI
            System.out.println("10.Thoat"); // THAY DOI SO
            System.out.println("Chon: ");
            chon = Integer.parseInt(sc.nextLine());
            switch (chon) {
                case 1:
                    dslsp.nhap();
                    break;
                case 2:
                    dslsp.xuat();
                    break;
                case 3:
                    dslsp.them();
                    break;            
                case 4:
                    dslsp.sua();
                    break;            
                case 5:              
                    dslsp.xoa();
                    break;
                case 6:
                    LoaiSanPham lsp;
                    lsp = dslsp.tim();
                    if(lsp!=null){
                        System.out.printf("| %-10s | %-15s | %-25s |\n", "Ma Loai", "Ten Loai", "Mo Ta");
                        System.out.println("------------------------------------------------------------------");
                        lsp.xuat();
                    }else{
                        System.out.println("khong tim thay loai san pham ");
                    }
                    break;
                case 7:
                    dslsp.thongKeSoLuong();
                    break;  
                // --- THEM MOI ---
                case 8:
                    try {
                        dslsp.ghiFile(DuongDan.LOAISANPHAM_FILE_PATH);
                    } catch (IOException e) {
                        System.out.println("Ghi File loi!!!");
                    }
                    break;
                case 9:
                    try {
                        dslsp.docFile(DuongDan.LOAISANPHAM_FILE_PATH);
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