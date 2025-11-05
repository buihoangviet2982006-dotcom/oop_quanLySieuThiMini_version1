package quanlysieuthi.main;

// 1. Import tat ca cac lop Doi tuong (Entities)
import quanlysieuthi.Nguoi.KhachHang;
import quanlysieuthi.Nguoi.NhaCungCap;
import quanlysieuthi.Nguoi.NhanVien;
import quanlysieuthi.SanPham.DoGiaDung;
import quanlysieuthi.SanPham.HangSanXuat;
import quanlysieuthi.SanPham.LoaiSanPham;
import quanlysieuthi.SanPham.SanPham;
import quanlysieuthi.SanPham.ThucPham;
import quanlysieuthi.hoadon.ChiTietHoaDon;
import quanlysieuthi.hoadon.HoaDon;
import quanlysieuthi.Phieu.ChiTietPhieuNhap;
import quanlysieuthi.Phieu.PhieuNhapHang;

// 2. Import tat ca cac lop Danh sach (Lists)
import quanlysieuthi.danhsach.DSChiTietHD;
import quanlysieuthi.danhsach.DSChiTietPNH;
import quanlysieuthi.danhsach.DSHangSanXuat;
import quanlysieuthi.danhsach.DSHoaDon;
import quanlysieuthi.danhsach.DSKH;
import quanlysieuthi.danhsach.DSLSP;
import quanlysieuthi.danhsach.DSNV;
import quanlysieuthi.danhsach.DSNhaCungCap;
import quanlysieuthi.danhsach.DSPhieuNhapHang;
import quanlysieuthi.danhsach.DSSP;

// 3. Import cac lop Quan ly va Tien ich
import quanlysieuthi.quanli.HeThong;
import quanlysieuthi.quanli.QLST;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        // --- KHOI TAO 10 DANH SACH RONG ---
        QLST.dsSP = new DSSP();
        QLST.dsCTHD = new DSChiTietHD();
        QLST.dsHD = new DSHoaDon();
        QLST.dsPNH = new DSPhieuNhapHang();
        QLST.dsCTPNH = new DSChiTietPNH();
        QLST.dsNCC = new DSNhaCungCap();
        QLST.dsKH = new DSKH();
        QLST.dsNV = new DSNV();
        QLST.dslsp = new DSLSP();
        QLST.dsHSX = new DSHangSanXuat();

        System.out.println("--- DANG TAO DU LIEU TEST (TONG CONG 150 OBJECTS) ---");

        // --- LEVEL 0: THEM CAC DANH SACH DOC LAP (15 data each) ---

        // 1. Them 15 Hang San Xuat (HSX01 -> HSX15)
        for (int i = 1; i <= 15; i++) {
            QLST.dsHSX.them(new HangSanXuat(
                    "HSX" + i, "Hang San Xuat " + i, "Dia Chi HSX " + i,
                    "09000000" + String.format("%02d", i), String.valueOf(2000 + i)
            ));
        }

        // 2. Them 15 Nha Cung Cap (NCC01 -> NCC15)
        for (int i = 1; i <= 15; i++) {
            QLST.dsNCC.them(new NhaCungCap(
                    "NCC" + i, "Nha Cung Cap " + i, "09111111" + String.format("%02d", i),
                    "Dia Chi NCC " + i
            ));
        }

        // 3. Them 15 Nhan Vien (NV01 -> NV15)
        for (int i = 1; i <= 15; i++) {
            QLST.dsNV.them(new NhanVien(
                    "NV" + i, "Ho NV " + i, "Ten " + i, (i % 2 == 0 ? "Nam" : "Nu"),
                    "QL", "09222222" + String.format("%02d", i), "Dia Chi NV " + i,
                    "nv" + i + "@sieu.thi", 5000000 + (i * 100000)
            ));
        }

        // 4. Them 15 Khach Hang (KH01 -> KH15)
        for (int i = 1; i <= 15; i++) {
            QLST.dsKH.them(new KhachHang(
                    "KH" + i, "Ho KH " + i, "Ten " + i, (i % 2 != 0 ? "Nam" : "Nu"),
                    "09333333" + String.format("%02d", i), "Dia Chi KH " + i,
                    "kh" + i + "@email.com"
            ));
        }

        // 5. Them 15 Loai San Pham (LSP01 -> LSP15)
        for (int i = 1; i <= 15; i++) {
            QLST.dslsp.them(new LoaiSanPham(
                    "LSP" + i, "Ten Loai SP " + i, "Mo ta cho loai san pham " + i
            ));
        }

        // --- LEVEL 1: THEM SAN PHAM (Tong cong 25 data) ---

        // 6. Them 10 Do Gia Dung (DGD01 -> DGD10)
        for (int i = 1; i <= 10; i++) {
            QLST.dsSP.them(new DoGiaDung(
                    "DGD" + i, "Noi Com Dien " + i, 50, 1000000 + i*100000, "HSX" + i,
                    "01/01/2024", (i % 2 == 0 ? "Inox" : "Nhua"), i * 2 + 10
            ));
        }

        // 7. Them 10 Thuc Pham (TP01 -> TP10)
        for (int i = 1; i <= 10; i++) {
            QLST.dsSP.them(new ThucPham(
                    "TP" + i, "Sua Tuoi " + i, 100, 50000 + i*1000, "HSX" + (11 - i),
                    "01/10/2025", "30/10/2025", (i % 2 == 0 ? "Dong Lanh" : "Tuoi Song")
            ));
        }

        // 8. Them 5 San Pham "SACH" (CLEAN1 -> CLEAN5)
        for (int i = 1; i <= 5; i++) {
            QLST.dsSP.them(new DoGiaDung(
                    "CLEAN" + i, "San Pham De Xoa " + i, 99, 10000, "HSX" + (i + 10),
                    "01/01/2025", "Go", 1
            ));
        }

        // --- LEVEL 1: THEM HOA DON & PHIEU NHAP (Du lieu thuc te cho Thong Ke) ---

        // 9. Them 12 Hoa Don (HD) rai rac trong 2 nam (2024, 2025)
        // (Chi dung NV1-10, KH1-10)
        QLST.dsHD.them(new HoaDon("HD01", "NV1", "KH1", "15/01/2024", "Tien Mat", 0)); // Q1 2024
        QLST.dsHD.them(new HoaDon("HD02", "NV2", "KH3", "20/03/2024", "Chuyen Khoan", 0)); // Q1 2024
        QLST.dsHD.them(new HoaDon("HD03", "NV3", "KH1", "10/04/2024", "Tien Mat", 0)); // Q2 2024
        QLST.dsHD.them(new HoaDon("HD04", "NV4", "KH5", "15/06/2024", "Tien Mat", 0)); // Q2 2024
        QLST.dsHD.them(new HoaDon("HD05", "NV1", "KH3", "05/09/2024", "Chuyen Khoan", 0)); // Q3 2024
        QLST.dsHD.them(new HoaDon("HD06", "NV2", "KH7", "25/10/2024", "Tien Mat", 0)); // Q4 2024
        QLST.dsHD.them(new HoaDon("HD07", "NV5", "KH1", "15/12/2024", "Chuyen Khoan", 0)); // Q4 2024
        QLST.dsHD.them(new HoaDon("HD08", "NV3", "KH5", "20/01/2025", "Tien Mat", 0)); // Q1 2025
        QLST.dsHD.them(new HoaDon("HD09", "NV4", "KH3", "18/02/2025", "Tien Mat", 0)); // Q1 2025
        QLST.dsHD.them(new HoaDon("HD10", "NV6", "KH7", "30/03/2025", "Chuyen Khoan", 0)); // Q1 2025
        QLST.dsHD.them(new HoaDon("HD11", "NV1", "KH1", "05/04/2025", "Tien Mat", 0)); // Q2 2025
        QLST.dsHD.them(new HoaDon("HD12", "NV2", "KH5", "10/05/2025", "Chuyen Khoan", 0)); // Q2 2025


        // 10. Them 12 Phieu Nhap Hang (PNH) rai rac trong 2 nam (2024, 2025)
        // (Chi dung NCC1-10, NV1-10)
        QLST.dsPNH.them(new PhieuNhapHang("PNH01", "NCC1", "NV5", "10/01/2024", 0)); // Q1 2024
        QLST.dsPNH.them(new PhieuNhapHang("PNH02", "NCC2", "NV6", "25/03/2024", 0)); // Q1 2024
        QLST.dsPNH.them(new PhieuNhapHang("PNH03", "NCC3", "NV7", "15/04/2024", 0)); // Q2 2024
        QLST.dsPNH.them(new PhieuNhapHang("PNH04", "NCC1", "NV8", "30/06/2024", 0)); // Q2 2024
        QLST.dsPNH.them(new PhieuNhapHang("PNH05", "NCC4", "NV9", "10/09/2024", 0)); // Q3 2024
        QLST.dsPNH.them(new PhieuNhapHang("PNH06", "NCC5", "NV10", "20/10/2024", 0)); // Q4 2024
        QLST.dsPNH.them(new PhieuNhapHang("PNH07", "NCC2", "NV1", "10/12/2024", 0)); // Q4 2024
        QLST.dsPNH.them(new PhieuNhapHang("PNH08", "NCC6", "NV2", "15/01/2025", 0)); // Q1 2025
        QLST.dsPNH.them(new PhieuNhapHang("PNH09", "NCC7", "NV3", "20/02/2025", 0)); // Q1 2025
        QLST.dsPNH.them(new PhieuNhapHang("PNH10", "NCC3", "NV4", "25/03/2025", 0)); // Q1 2025
        QLST.dsPNH.them(new PhieuNhapHang("PNH11", "NCC8", "NV5", "10/04/2025", 0)); // Q2 2025
        QLST.dsPNH.them(new PhieuNhapHang("PNH12", "NCC1", "NV6", "15/05/2025", 0)); // Q2 2025


        // --- LEVEL 2: THEM CHI TIET & CAP NHAT LOGIC ---

        System.out.println("...Dang xu ly Chi Tiet Hoa Don va Cap Nhat Kho...");
        // 11. Them 12 Chi Tiet Hoa Don (tuong ung 12 HD)
        // Mang de map HD voi SP va SoLuong
        // {maHD, maSP, soLuongBan}
        String[][] dataHD = {
                {"HD01", "DGD1", "2"},
                {"HD02", "DGD2", "1"},
                {"HD03", "DGD3", "3"},
                {"HD04", "DGD4", "1"},
                {"HD05", "DGD1", "1"}, // KH3 mua lai DGD1
                {"HD06", "DGD5", "5"},
                {"HD07", "DGD6", "2"},
                {"HD08", "DGD7", "1"},
                {"HD09", "DGD2", "2"}, // KH3 mua lai DGD2
                {"HD10", "DGD8", "4"},
                {"HD11", "DGD9", "1"},
                {"HD12", "DGD10", "1"}
        };

        for (String[] data : dataHD) {
            String maHD_ct = data[0];
            String maSP_ct = data[1];
            int soLuongBan = Integer.parseInt(data[2]);

            SanPham sp = QLST.dsSP.timTheoMaSP(maSP_ct);
            if (sp == null) {
                System.out.println("LOI TEST CASE: Khong tim thay SP " + maSP_ct);
                continue;
            }
            double donGia = sp.getDonGia();

            ChiTietHoaDon cthd = new ChiTietHoaDon(maHD_ct, maSP_ct, soLuongBan, donGia);
            QLST.dsCTHD.them(cthd);

            // Cap nhat lai tong tien cho HoaDon cha
            HoaDon hd = QLST.dsHD.timTheoMa(maHD_ct);
            if (hd != null) {
                hd.setTongTien(hd.getTongTien() + cthd.getThanhTien());
            }

            // Cap nhat ton kho (BAN HANG -> TRU KHO)
            sp.setSoLuong(sp.getSoLuong() - soLuongBan);
        }


        System.out.println("...Dang xu ly Chi Tiet Phieu Nhap va Cap Nhat Kho...");
        // 12. Them 12 Chi Tiet Phieu Nhap (tuong ung 12 PNH)
        // {maPNH, maSP, soLuongNhap}
        String[][] dataPNH = {
                {"PNH01", "TP1", "50"},
                {"PNH02", "TP2", "60"},
                {"PNH03", "TP3", "40"},
                {"PNH04", "TP4", "70"},
                {"PNH05", "TP1", "30"}, // Nhap them TP1
                {"PNH06", "TP5", "100"},
                {"PNH07", "TP6", "50"},
                {"PNH08", "TP7", "80"},
                {"PNH09", "TP2", "40"}, // Nhap them TP2
                {"PNH10", "TP8", "60"},
                {"PNH11", "TP9", "90"},
                {"PNH12", "TP10", "100"}
        };

        for (String[] data : dataPNH) {
            String maPNH_ct = data[0];
            String maSP_ct = data[1];
            int soLuongNhap = Integer.parseInt(data[2]);

            SanPham sp = QLST.dsSP.timTheoMaSP(maSP_ct);
            if (sp == null) {
                System.out.println("LOI TEST CASE: Khong tim thay SP " + maSP_ct);
                continue;
            }
            double donGia = sp.getDonGia(); // Gia su gia nhap = gia ban de test

            ChiTietPhieuNhap ctpnh = new ChiTietPhieuNhap(maPNH_ct, maSP_ct, soLuongNhap, donGia);
            QLST.dsCTPNH.them(ctpnh);

            // Cap nhat lai tong tien cho PhieuNhap cha
            PhieuNhapHang pnh = QLST.dsPNH.timTheoMa(maPNH_ct);
            if (pnh != null) {
                pnh.setTongTien(pnh.getTongTien() + ctpnh.getThanhTien());
            }

            // Cap nhat ton kho (NHAP HANG -> CONG THEM VAO KHO)
            sp.setSoLuong(sp.getSoLuong() + soLuongNhap);
        }

        System.out.println("--- TAO DU LIEU HOAN TAT! BAT DAU CHAY MENU CHINH ---");
        System.out.println("--- (Du lieu tu ID 11-15 va CLEAN1-5 se de xoa) ---");
        System.out.println("==============================================");

        // --- GOI MENU CHINH ---
        HeThong.menuChinh();
    }
}