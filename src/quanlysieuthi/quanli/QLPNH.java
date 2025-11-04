package quanlysieuthi.quanli;

import java.io.IOException;
import java.util.Scanner;

import quanlysieuthi.tienich.DuongDan;

public class QLPNH extends QLST{
    @Override
    public void menu(){
        Scanner sc = new Scanner(System.in);
        int chon;
        do {
            System.out.println("----------------------------------------------");
            System.out.println("        QUAN LY PHIEU NHAP HANG");
            System.out.println("----------------------------------------------");
            System.out.println("1. Nhap danh sach phieu nhap hang"); 
            System.out.println("2. Them phieu nhap hang");
            System.out.println("3. Xuat danh sach phieu nhap hang");
            System.out.println("4. Sua phieu nhap hang");
            System.out.println("5. Xoa phieu nhap hang");
            System.out.println("6. Thong ke so luong phieu nhap hang");
            System.out.println("7. Ghi FILE");
            System.out.println("8. Doc FILE");
            System.out.println("9. Thoat");
            System.out.print("Chon: ");
            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1: 
                    dsPNH.nhap();
                    break;
                case 2:
                    dsPNH.them();
                    break;
                case 3:
                    dsPNH.xuat();
                    break;
                case 4:
                    dsPNH.sua();
                    break;
                case 5: {
                    if (dsPNH.getSoLuong() == 0) {
                        System.out.println("Danh sach phieu nhap hang rong!");
                        break;
                    }
                    System.out.print("Nhap maPNH can xoa: ");
                    String ma = sc.nextLine();
                    
                    // Kiem tra ton tai
                    if (dsPNH.timTheoMa(ma) == null) { //
                        System.out.println("Khong tim thay phieu co maPNH = " + ma);
                        break;
                    }

                    int soLuongCTDaXoa = dsCTPNH.xoaTheoMaPNH(ma); //
                    if (soLuongCTDaXoa > 0) {
                        System.out.println("=> Da tu dong xoa " + soLuongCTDaXoa + " chi tiet phieu nhap lien quan.");
                    }

                    dsPNH.xoa(ma); 
                    break;
                }
                case 6:
                    dsPNH.thongKeSoLuong();
                    break;
                case 7:
                    try {
                        dsPNH.ghiFile(DuongDan.PHIEUNHAP_FILE_PATH);
                    } catch (IOException e) {
                        System.out.println("Ghi File loi!!!");
                    }
                case 8:
                    try {
                        dsPNH.docFile(DuongDan.PHIEUNHAP_FILE_PATH);
                    } catch (IOException e) {
                        System.out.println("Doc File loi!!!");
                    } 
                    break;
                case 9:
                    System.out.println("Thoat danh sach phieu nhap hang");
                    return;
                default:
                    return;
            }
        } while (true); 
    }    
}
