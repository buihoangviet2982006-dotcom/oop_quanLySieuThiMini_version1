package quanlysieuthi.main;

import quanlysieuthi.SanPham.DoGiaDung;
import quanlysieuthi.SanPham.SanPham;
import quanlysieuthi.SanPham.ThucPham;
import quanlysieuthi.danhsach.DSSP;
import quanlysieuthi.hoadon.HoaDon;
import quanlysieuthi.quanli.QLST;
import quanlysieuthi.thongke.ThongKe;
import quanlysieuthi.tienich.DuongDan;
import quanlysieuthi.danhsach.DSChiTietHD;
import quanlysieuthi.danhsach.DSChiTietPNH;
import quanlysieuthi.danhsach.DSHoaDon;
import quanlysieuthi.danhsach.DSPhieuNhapHang;

import java.io.IOException;

import quanlysieuthi.Phieu.ChiTietPhieuNhap;
import quanlysieuthi.Phieu.PhieuNhapHang;

public class Main {
    public static void main(String[] args) throws IOException {
        // DSSP ds = new DSSP();
        // ds.them(new DoGiaDung("DGD002", "chao", 15, 1200000, "Viet Nam", "DGD", "10/01/2021", "gang", 24000));
        // ds.them(new DoGiaDung("DGD003", "am dien", 20, 250000.4, "Nhat Ban", "DGD", "05/03/2022", "inox", 18));
        // ds.them(new DoGiaDung("DGD004", "may xay sinh to", 8, 500000000, "Han Quoc", "DGD", "01/06/2021", "nhua", 12));
        // ds.them(new DoGiaDung("DGD005", "binh giu nhiet", 25, 150, "Trung Quoc", "DGD", "20/09/2020", "inox", 12));
        // ds.them(new DoGiaDung("DGD006", "quat dien", 30, 300, "Viet Nam", "DGD", "15/07/2021", "nhua", 24));


        // ds.them(new ThucPham("TP002", "thit ga", 50, 100, "Viet Nam", "TP", "01/10/2025", "05/10/2025", "mat"));
        // ds.them(new ThucPham("TP003", "ca hoi", 20, 400, "Na Uy", "TP", "25/09/2025", "05/10/2025", "dong lanh"));
        // ds.them(new ThucPham("TP004", "sua tuoi", 100, 20, "Ha Lan", "TP", "15/09/2025", "15/10/2025", "lanh"));
        // ds.them(new ThucPham("TP005", "banh mi", 60, 10, "Viet Nam", "TP", "02/10/2025", "04/10/2025", "thuong"));
        // ds.them(new ThucPham("TP006", "nuoc ngot", 200, 15, "My", "TP", "10/09/2025", "10/12/2025", "nhiet do phong"));

        // ds.docFile("D:\\do_an_oop\\src\\quanlysieuthi\\dulieu\\sanpham.txt");

        DSHoaDon dsHD = new DSHoaDon();
        DSPhieuNhapHang dsPNH = new DSPhieuNhapHang();
        // == DỮ LIỆU NĂM 2025 (NĂM CẦN TEST) ==
        // Quý 1 (Thu: 1500, HD: 2, Chi: 300)
        dsHD.them(new HoaDon("HD001", "NV01", "KH01", "15/01/2025", "TM", 1000));
        dsHD.them(new HoaDon("HD002", "NV01", "KH02", "31/03/2025", "CK", 500)); // Ngày cuối Q1
        dsPNH.them(new PhieuNhapHang("PNH001", "NCC01", "NV02", "20/02/2025", 300));

        // Quý 2 (Thu: 2000, HD: 1, Chi: 800)
        dsHD.them(new HoaDon("HD003", "NV02", "KH01", "01/04/2025", "TM", 2000)); // Ngày đầu Q2
        dsPNH.them(new PhieuNhapHang("PNH002", "NCC02", "NV02", "10/06/2025", 800));
        
        // Quý 3 (Thu: 0, HD: 0, Chi: 1200)
        // (Không có hóa đơn nào)
        dsPNH.them(new PhieuNhapHang("PNH003", "NCC01", "NV01", "05/08/2025", 1200));

        // Quý 4 (Thu: 3000, HD: 1, Chi: 0)
        dsHD.them(new HoaDon("HD004", "NV01", "KH03", "31/12/2025", "CK", 3000)); // Ngày cuối Q4
        // (Không có phiếu nhập nào)

        // == DỮ LIỆU CÁC NĂM KHÁC (PHẢI BỊ BỎ QUA) ==
        dsHD.them(new HoaDon("HD999", "NV01", "KH01", "12/12/2024", "TM", 99000)); // Năm 2024
        dsPNH.them(new PhieuNhapHang("PNH999", "NCC01", "NV01", "01/01/2026", 88000)); // Năm 2026
        // Dữ liệu lỗi từ ví dụ của bạn (giả sử là 2020)
        dsPNH.them(new PhieuNhapHang("PNH998", "NCC02", "NV01", "12/12/2020", 77000));
        ThongKe tk = new ThongKe(null, dsHD, null, dsPNH, null);

        tk.ThongKeTongTienTheoQuy();

    }
}
