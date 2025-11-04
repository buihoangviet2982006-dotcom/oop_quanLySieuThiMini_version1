package quanlysieuthi.quanli;

import java.io.IOException; // THEM MOI
import java.util.Scanner;
import quanlysieuthi.SanPham.HangSanXuat;
import quanlysieuthi.tienich.DuongDan; // THEM MOI

public class QLHSX extends QLST {
    @Override
    public void menu() {
        Scanner sc = new Scanner(System.in);
        int chon = 0;
        do {
            System.out.println("----------------------------------------------");
            System.out.println("           QUAN LY HANG SAN XUAT");
            System.out.println("----------------------------------------------");
            System.out.println("1.Nhap danh sach hang san xuat");
            System.out.println("2.Xuat danh sach hang san xuat");
            System.out.println("3.Them hang san xuat");
            System.out.println("4.Sua hang san xuat");
            System.out.println("5.Xoa hang san xuat");
            System.out.println("6.Tim hang san xuat");
            System.out.println("7.Thong ke so luong hang san xuat");
            System.out.println("8.Ghi FILE"); // THEM MOI
            System.out.println("9.Doc FILE"); // THEM MOI
            System.out.println("10.Thoat"); // THAY DOI SO
            System.out.println("Chon: ");
            chon = Integer.parseInt(sc.nextLine());
            switch (chon) {
                case 1:
                    dsHSX.nhap();
                    break;
                case 2:
                    dsHSX.xuat();
                    break;
                case 3:
                    dsHSX.them();
                    break;
                case 4:
                    dsHSX.sua();
                    break;
                case 5:
                    dsHSX.xoa();
                    break;
                case 6:
                    HangSanXuat hsx;
                    hsx = dsHSX.tim();
                    if (hsx != null) {
                        // Xuat lai header cho de nhin
                        System.out.printf("| %-10s | %-20s | %-30s | %-15s | %-10s |\n", "Ma Hang", "Ten Hang", "Dia Chi", "Lien He", "Nam TL");
                        System.out.println("-----------------------------------------------------------------------------------------------");
                        System.out.printf("| %-10s | %-20s | %-30s | %-15s | %-10s |\n",
                            hsx.getMaHang(), hsx.getTenHang(), hsx.getDiaChi(),
                            hsx.getLienHe(), hsx.getNamThanhLap());
                    }
                    break;
                case 7:
                    dsHSX.thongKeSoLuong();
                    break;
                // --- THEM MOI ---
                case 8:
                    try {
                        dsHSX.ghiFile(DuongDan.HANGSANXUAT_FILE_PATH);
                    } catch (IOException e) {
                        System.out.println("Ghi File loi!!!");
                    }
                    break;
                case 9:
                    try {
                        dsHSX.docFile(DuongDan.HANGSANXUAT_FILE_PATH);
                    } catch (IOException e) {
                        System.out.println("Doc File loi!!!");
                    }
                    break;
                // --- KET THUC THEM MOI ---
                default:
                    return;
            }
        } while (true);
    }
}