package quanlysieuthi.main;

import quanlysieuthi.SanPham.DoGiaDung;
import quanlysieuthi.SanPham.LoaiSanPham;
import quanlysieuthi.SanPham.SanPham;
import quanlysieuthi.SanPham.ThucPham;
import quanlysieuthi.danhsach.DSSP;
import quanlysieuthi.hoadon.HoaDon;
import quanlysieuthi.quanli.HeThong;
import quanlysieuthi.quanli.QLST;
import quanlysieuthi.danhsach.DSChiTietHD;
import quanlysieuthi.danhsach.DSChiTietPNH;
import quanlysieuthi.danhsach.DSHoaDon;
import quanlysieuthi.danhsach.DSLSP;
import quanlysieuthi.danhsach.DSPhieuNhapHang;

import java.io.IOException;

import quanlysieuthi.Phieu.PhieuNhapHang;

public class Main {
    public static void main(String[] args) throws IOException {
        DSSP ds = new DSSP();
        ds.them(new DoGiaDung("DGD002", "chao", 15, 1200000, "Viet Nam",  "10/01/2021", "gang", 24000));
        ds.them(new DoGiaDung("DGD003", "am dien", 20, 250000.4, "Nhat Ban",  "05/03/2022", "inox", 18));
        ds.them(new DoGiaDung("DGD004", "may xay sinh to", 8, 500000000, "Han Quoc",  "01/06/2021", "nhua", 12));
        ds.them(new DoGiaDung("DGD005", "binh giu nhiet", 25, 150, "Trung Quoc",  "20/09/2020", "inox", 12));
        ds.them(new DoGiaDung("DGD006", "quat dien", 30, 300, "Viet Nam",  "15/07/2021", "nhua", 24));


        ds.them(new ThucPham("TP002", "thit ga", 50, 100, "Viet Nam",  "01/10/2025", "05/10/2025", "mat"));
        ds.them(new ThucPham("TP003", "ca hoi", 20, 400, "Na Uy",  "25/09/2025", "05/10/2025", "dong lanh"));
        ds.them(new ThucPham("TP004", "sua tuoi", 100, 20, "Ha Lan",  "15/09/2025", "15/10/2025", "lanh"));
        ds.them(new ThucPham("TP005", "banh mi", 60, 10, "Viet Nam",  "02/10/2025", "04/10/2025", "thuong"));
        ds.them(new ThucPham("TP006", "nuoc ngot", 200, 15, "My",  "10/09/2025", "10/12/2025", "nhiet do phong"));


        DSHoaDon dsHD = new DSHoaDon();
        DSPhieuNhapHang dsPNH = new DSPhieuNhapHang();

        // --- Dữ liệu Hóa đơn (Thu) ---
        // Quý 4 / 2025
        dsHD.them(new HoaDon("HD301", "NV01", "KH50", "15/11/2025", "CK", 1000));
        dsHD.them(new HoaDon("HD302", "NV02", "KH51", "31/12/2025", "TM", 2000)); // Ngày cuối năm
        // Quý 1 / 2026
        dsHD.them(new HoaDon("HD303", "NV01", "KH50", "01/01/2026", "TM", 3000)); // Ngày đầu năm
        dsHD.them(new HoaDon("HD304", "NV01", "KH50", "10/02/2026", "CK", 4000)); // Cùng KH50, cùng Q1

        // --- Dữ liệu Phiếu Nhập (Chi) ---
        // Quý 4 / 2025
        dsPNH.them(new PhieuNhapHang("PNH301", "NCC01", "NV02", "20/12/2025", 500));
        // Quý 1 / 2026
        dsPNH.them(new PhieuNhapHang("PNH302", "NCC02", "NV01", "05/01/2026", 800));

        // --- Dữ liệu rác (nằm ngoài khoảng test) ---
        dsHD.them(new HoaDon("HD998", "NV01", "KH99", "01/09/2025", "TM", 999)); // Q3 2025
        dsPNH.them(new PhieuNhapHang("PNH998", "NCC99", "NV01", "01/04/2026", 888)); // Q2 2026
        
        QLST.dsSP = ds;
        QLST.dsHD = dsHD;
        QLST.dsPNH = dsPNH;
        HeThong.menuChinh();

        
    }
}
