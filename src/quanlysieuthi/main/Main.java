package quanlysieuthi.main;

import quanlysieuthi.SanPham.DoGiaDung;
import quanlysieuthi.SanPham.SanPham;
import quanlysieuthi.SanPham.ThucPham;
import quanlysieuthi.danhsach.DSSP;
import quanlysieuthi.quanli.QLST;
import quanlysieuthi.danhsach.DSChiTietHD;
import quanlysieuthi.danhsach.DSChiTietPNH;
import quanlysieuthi.danhsach.DSHoaDon;
import quanlysieuthi.danhsach.DSPhieuNhapHang;

import java.io.IOException;

import quanlysieuthi.Phieu.ChiTietPhieuNhap;
import quanlysieuthi.Phieu.PhieuNhapHang;

public class Main {
    public static void main(String[] args) throws IOException {
        DSSP ds = new DSSP();
        ds.them(new DoGiaDung("DGD002", "chao", 15, 1200000, "Viet Nam", "DGD", "10/01/2021", "gang", 24000));
        ds.them(new DoGiaDung("DGD003", "am dien", 20, 250000.4, "Nhat Ban", "DGD", "05/03/2022", "inox", 18));
        ds.them(new DoGiaDung("DGD004", "may xay sinh to", 8, 500000000, "Han Quoc", "DGD", "01/06/2021", "nhua", 12));
        ds.them(new DoGiaDung("DGD005", "binh giu nhiet", 25, 150, "Trung Quoc", "DGD", "20/09/2020", "inox", 12));
        ds.them(new DoGiaDung("DGD006", "quat dien", 30, 300, "Viet Nam", "DGD", "15/07/2021", "nhua", 24));


        ds.them(new ThucPham("TP002", "thit ga", 50, 100, "Viet Nam", "TP", "01/10/2025", "05/10/2025", "mat"));
        ds.them(new ThucPham("TP003", "ca hoi", 20, 400, "Na Uy", "TP", "25/09/2025", "05/10/2025", "dong lanh"));
        ds.them(new ThucPham("TP004", "sua tuoi", 100, 20, "Ha Lan", "TP", "15/09/2025", "15/10/2025", "lanh"));
        ds.them(new ThucPham("TP005", "banh mi", 60, 10, "Viet Nam", "TP", "02/10/2025", "04/10/2025", "thuong"));
        ds.them(new ThucPham("TP006", "nuoc ngot", 200, 15, "My", "TP", "10/09/2025", "10/12/2025", "nhiet do phong"));

        // ds.docFile("D:\\do_an_oop\\src\\quanlysieuthi\\dulieu\\sanpham.txt");
        QLST ql = new QLST(ds,new DSChiTietHD(),new DSHoaDon(),new DSChiTietPNH(),new DSPhieuNhapHang());
        ql.menu();

    }
}
