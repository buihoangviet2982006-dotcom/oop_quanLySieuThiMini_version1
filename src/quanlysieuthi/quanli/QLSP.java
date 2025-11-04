package quanlysieuthi.quanli;

import java.io.IOException;
import java.util.Scanner;

import quanlysieuthi.Phieu.ChiTietPhieuNhap;
import quanlysieuthi.SanPham.DoGiaDung;
import quanlysieuthi.SanPham.SanPham;
import quanlysieuthi.SanPham.ThucPham;
import quanlysieuthi.hoadon.ChiTietHoaDon;
import quanlysieuthi.tienich.DuongDan;

public class QLSP extends QLST {

    @Override
    public void menu() {
        Scanner sc = new Scanner(System.in);
        int chon = 0;
        do {
            System.out.println("----------------------------------------------");
            System.out.println("             QUAN LY SAN PHAM");
            System.out.println("----------------------------------------------");
            System.out.println("1.Nhap danh sach san pham");
            System.out.println("2.Xuat danh sach san pham");
            System.out.println("3.Them san pham");
            System.out.println("4.Sua san pham");
            System.out.println("5.Xoa san pham");
            System.out.println("6.Tim san pham");
            System.out.println("7.Thong ke so luong san pham");
            System.out.println("8.Ghi FILE");
            System.out.println("9.Doc FILE");
            System.out.println("10.Thoat");
            System.out.print("Chon: ");

            // RANG BUOC: Bat loi nhap chu
            try {
                chon = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Loi: Vui long nhap mot con so.");
                continue;
            }

            switch (chon) {
                case 1: { // nhap
                    // *** RANG BUOC MOI: Kiem tra dsHSX co rong khong ***
                    if (dsHSX.getSoLuong() == 0) {
                        System.out.println("LOI: Danh sach Hang San Xuat dang rong.");
                        System.out.println("Vui long vao 'Quan Ly Hang San Xuat' de them hang truoc.");
                        break; // Quay lai menu
                    }
                    
                    int n = 0;
                    while (true) {
                        try {
                            System.out.print("Nhap so luong san pham: ");
                            n = Integer.parseInt(sc.nextLine());
                             if (n < 0) {
                                System.out.println("So luong khong thể am.");
                            } else {
                                break;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Loi: Vui long nhap mot con so.");
                        }
                    }

                    for (int i = 0; i < n; i++) {
                        System.out.println("\n---San Pham Thu " + (i + 1) + " ---");

                        // 1. CHON LOAI SAN PHAM (DGD / TP)
                        int chonLoai;
                        while (true) {
                            try {
                                System.out.println("Chon loai san pham:");
                                System.out.println("1. Do Gia Dung");
                                System.out.println("2. Thuc Pham");
                                System.out.print("Chon: ");
                                chonLoai = Integer.parseInt(sc.nextLine());
                                if (chonLoai == 1 || chonLoai == 2) {
                                    break;
                                }
                                System.out.println("Loi: Vui long chon 1 hoac 2.");
                            } catch (NumberFormatException e) {
                                System.out.println("Loi: Vui long nhap mot con so.");
                            }
                        }

                        // 3. RANG BUOC: Nhap Ma SP (Kiem tra tinh duy nhat)
                        String maSP;
                        while (true) {
                            System.out.print("Nhap ma san pham: ");
                            maSP = sc.nextLine();
                            if (maSP.trim().isEmpty()) {
                                System.out.println("Loi: Ma SP khong duoc de trong.");
                                continue;
                            }
                            
                            if (dsSP.timTheoMaSP(maSP) != null) {
                                System.out.println("Loi: Ma SP '" + maSP + "' da ton tai!");
                            } else {
                                break; // Ma SP hop le
                            }
                        }

                        System.out.print("Nhap ten san pham: ");
                        String tenSP = sc.nextLine();

                        // 4. RANG BUOC: Nhap So Luong (Bat loi so, so am)
                        int soLuong;
                        while (true) {
                            try {
                                System.out.print("Nhap so luong: ");
                                soLuong = Integer.parseInt(sc.nextLine());
                                if (soLuong < 0) {
                                    System.out.println("Loi: So luong khong duoc am.");
                                } else {
                                    break;
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Loi: Vui long nhap mot con so.");
                            }
                        }

                        // 5. RANG BUOC: Nhap Don Gia (Bat loi so, so am)
                        double donGia;
                        while (true) {
                            try {
                                System.out.print("Nhap don gia: ");
                                donGia = Double.parseDouble(sc.nextLine());
                                if (donGia < 0) {
                                    System.out.println("Loi: Don gia khong duoc am.");
                                } else {
                                    break;
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Loi: Vui long nhap mot con so.");
                            }
                        }

                        // 6. RANG BUOC: Nhap Ma Hang (Kiem tra ton tai TRONG dsHSX va KHONG RONG)
                        String maHang;
                        while (true) {
                            System.out.print("Nhap ma hang: ");
                            maHang = sc.nextLine();
                            
                            if (maHang.trim().isEmpty()) {
                                System.out.println("Loi: Ma hang khong duoc de trong.");
                                continue;
                            }
                            
                            if (dsHSX.timTheoMa(maHang) == null) {
                                System.out.println("Loi: Ma hang '" + maHang + "' khong ton tai!");
                                System.out.print("Ban co muon xem danh sach hang san xuat? (y/n): ");
                                if(sc.nextLine().equalsIgnoreCase("y")) {
                                    dsHSX.xuat();
                                }
                            } else {
                                break; // Ma hang hop le
                            }
                        }

                        System.out.print("Nhap ngay san xuat (dd/MM/yyyy): ");
                        String nsx = sc.nextLine(); 

                        // 7. Nhap thong tin rieng va tao doi tuong
                        SanPham sp;
                        if (chonLoai == 1) { // DoGiaDung
                            System.out.print("Nhap chat lieu: ");
                            String chatLieu = sc.nextLine();
                            int baoHanh;
                            while (true) {
                                try {
                                    System.out.print("Nhap thoi gian bao hanh (thang): ");
                                    baoHanh = Integer.parseInt(sc.nextLine());
                                    if (baoHanh < 0) {
                                        System.out.println("Loi: Bao hanh khong duoc am.");
                                    } else {
                                        break;
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("Loi: Vui long nhap mot con so.");
                                }
                            }
                            sp = new DoGiaDung(maSP, tenSP, soLuong, donGia, maHang, nsx, chatLieu, baoHanh);
                        } else { // ThucPham
                            System.out.print("Nhap han su dung (dd/MM/yyyy): ");
                            String hsd = sc.nextLine();
                            System.out.print("Nhap loai bao quan (VD: Lanh, Dong Lanh, Thuong): ");
                            String loaiBaoQuan = sc.nextLine();
                            sp = new ThucPham(maSP, tenSP, soLuong, donGia, maHang, nsx, hsd, loaiBaoQuan);
                        }

                        dsSP.them(sp); // Goi ham them 1 SP cua DSSP
                    }
                    System.out.println("==> Nhap " + n + " san pham thanh cong!");
                    break;
                }
                case 2: // xuat
                    dsSP.xuat();
                    break;
                case 3: { // them
                    // *** RANG BUOC MOI: Kiem tra dsHSX co rong khong ***
                    if (dsHSX.getSoLuong() == 0) {
                        System.out.println("LOI: Danh sach Hang San Xuat dang rong.");
                        System.out.println("Vui long vao 'Quan Ly Hang San Xuat' de them hang truoc.");
                        break; // Quay lai menu
                    }
                    
                    int n = 0;
                     while (true) {
                        try {
                            System.out.print("Nhap so luong san pham muon them: ");
                            n = Integer.parseInt(sc.nextLine());
                             if (n < 0) {
                                System.out.println("So luong khong thể am.");
                            } else {
                                break;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Loi: Vui long nhap mot con so.");
                        }
                    }

                    for (int i = 0; i < n; i++) {
                        System.out.println("\n--- Them San Pham Thu " + (i + 1) + " ---");

                        // 1. CHON LOAI SAN PHAM (DGD / TP)
                        int chonLoai;
                        while (true) {
                            try {
                                System.out.println("Chon loai san pham:");
                                System.out.println("1. Do Gia Dung");
                                System.out.println("2. Thuc Pham");
                                System.out.print("Chon: ");
                                chonLoai = Integer.parseInt(sc.nextLine());
                                if (chonLoai == 1 || chonLoai == 2) {
                                    break;
                                }
                                System.out.println("Loi: Vui long chon 1 hoac 2.");
                            } catch (NumberFormatException e) {
                                System.out.println("Loi: Vui long nhap mot con so.");
                            }
                        }

                        // 3. RANG BUOC: Nhap Ma SP (Kiem tra tinh duy nhat)
                        String maSP;
                        while (true) {
                            System.out.print("Nhap ma san pham: ");
                            maSP = sc.nextLine();
                            if (maSP.trim().isEmpty()) {
                                System.out.println("Loi: Ma SP khong duoc de trong.");
                                continue;
                            }
                            
                            if (dsSP.timTheoMaSP(maSP) != null) {
                                System.out.println("Loi: Ma SP '" + maSP + "' da ton tai!");
                            } else {
                                break; // Ma SP hop le
                            }
                        }

                        System.out.print("Nhap ten san pham: ");
                        String tenSP = sc.nextLine();

                        // 4. RANG BUOC: Nhap So Luong (Bat loi so, so am)
                        int soLuong;
                        while (true) {
                            try {
                                System.out.print("Nhap so luong: ");
                                soLuong = Integer.parseInt(sc.nextLine());
                                if (soLuong < 0) {
                                    System.out.println("Loi: So luong khong duoc am.");
                                } else {
                                    break;
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Loi: Vui long nhap mot con so.");
                            }
                        }

                        // 5. RANG BUOC: Nhap Don Gia (Bat loi so, so am)
                        double donGia;
                        while (true) {
                            try {
                                System.out.print("Nhap don gia: ");
                                donGia = Double.parseDouble(sc.nextLine());
                                if (donGia < 0) {
                                    System.out.println("Loi: Don gia khong duoc am.");
                                } else {
                                    break;
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Loi: Vui long nhap mot con so.");
                            }
                        }

                        // 6. RANG BUOC: Nhap Ma Hang (Kiem tra ton tai TRONG dsHSX va KHONG RONG)
                        String maHang;
                        while (true) {
                            System.out.print("Nhap ma hang: ");
                            maHang = sc.nextLine();
                            
                            if (maHang.trim().isEmpty()) {
                                System.out.println("Loi: Ma hang khong duoc de trong.");
                                continue;
                            }
                            
                            if (dsHSX.timTheoMa(maHang) == null) {
                                System.out.println("Loi: Ma hang '" + maHang + "' khong ton tai!");
                                System.out.print("Ban co muon xem danh sach hang san xuat? (y/n): ");
                                if(sc.nextLine().equalsIgnoreCase("y")) {
                                    dsHSX.xuat();
                                }
                            } else {
                                break; // Ma hang hop le
                            }
                        }

                        System.out.print("Nhap ngay san xuat (dd/MM/yyyy): ");
                        String nsx = sc.nextLine(); 

                        // 7. Nhap thong tin rieng va tao doi tuong
                        SanPham sp;
                        if (chonLoai == 1) { // DoGiaDung
                            System.out.print("Nhap chat lieu: ");
                            String chatLieu = sc.nextLine();
                            int baoHanh;
                            while (true) {
                                try {
                                    System.out.print("Nhap thoi gian bao hanh (thang): ");
                                    baoHanh = Integer.parseInt(sc.nextLine());
                                    if (baoHanh < 0) {
                                        System.out.println("Loi: Bao hanh khong duoc am.");
                                    } else {
                                        break;
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("Loi: Vui long nhap mot con so.");
                                }
                            }
                            sp = new DoGiaDung(maSP, tenSP, soLuong, donGia, maHang, nsx, chatLieu, baoHanh);
                        } else { // ThucPham
                            System.out.print("Nhap han su dung (dd/MM/yyyy): ");
                            String hsd = sc.nextLine();
                            System.out.print("Nhap loai bao quan (VD: Lanh, Dong Lanh, Thuong): ");
                            String loaiBaoQuan = sc.nextLine();
                            sp = new ThucPham(maSP, tenSP, soLuong, donGia, maHang, nsx, hsd, loaiBaoQuan);
                        }

                        dsSP.them(sp); // Goi ham them 1 SP cua DSSP
                    }
                    System.out.println("==> Them " + n + " san pham thanh cong!");
                    break;
                }
                case 4: { // sua
                    
                    // *** RANG BUOC MOI: Kiem tra dsHSX co rong khong ***
                    if (dsHSX.getSoLuong() == 0) {
                        System.out.println("LOI: Danh sach Hang San Xuat dang rong.");
                        System.out.println("Vui long vao 'Quan Ly Hang San Xuat' de them hang truoc.");
                        System.out.println("(Hien tai khong the sua san pham vi khong co ma hang hop le de chon)");
                        break; // Quay lai menu
                    }
                    
                    System.out.print("Nhap ma san pham can sua: ");
                    String maSP_Cu = sc.nextLine();
                    SanPham spCu = dsSP.timTheoMaSP(maSP_Cu);

                    if (spCu == null) {
                        System.out.println("Loi: Khong tim thay san pham voi ma '" + maSP_Cu + "'.");
                        break;
                    } 
                    
                    System.out.println("--- Nhap thong tin moi cho San Pham '" + maSP_Cu + "' ---");

                    // 1. CHON LOAI SAN PHAM (DGD / TP)
                    int chonLoai;
                    while (true) {
                        try {
                            System.out.println("Chon loai san pham:");
                            System.out.println("1. Do Gia Dung");
                            System.out.println("2. Thuc Pham");
                            System.out.print("Chon: ");
                            chonLoai = Integer.parseInt(sc.nextLine());
                            if (chonLoai == 1 || chonLoai == 2) {
                                break;
                            }
                            System.out.println("Loi: Vui long chon 1 hoac 2.");
                        } catch (NumberFormatException e) {
                            System.out.println("Loi: Vui long nhap mot con so.");
                        }
                    }

                    // 3. RANG BUOC: Nhap Ma SP (Kiem tra tinh duy nhat)
                    String maSP;
                    while (true) {
                        System.out.print("Nhap ma san pham: ");
                        maSP = sc.nextLine();
                        if (maSP.trim().isEmpty()) {
                            System.out.println("Loi: Ma SP khong duoc de trong.");
                            continue;
                        }
                        SanPham spTimThay = dsSP.timTheoMaSP(maSP);
                        
                        // Chi bao loi neu maSP moi bi trung voi 1 SP KHAC (khong phai chinh no)
                        if (spTimThay != null && !maSP.equalsIgnoreCase(maSP_Cu)) {
                            System.out.println("Loi: Ma SP '" + maSP + "' bi trung voi mot san pham khac!");
                        } else {
                            break; // Ma SP hop le
                        }
                    }

                    System.out.print("Nhap ten san pham: ");
                    String tenSP = sc.nextLine();

                    // 4. RANG BUOC: Nhap So Luong (Bat loi so, so am)
                    int soLuong;
                    while (true) {
                        try {
                            System.out.print("Nhap so luong: ");
                            soLuong = Integer.parseInt(sc.nextLine());
                            if (soLuong < 0) {
                                System.out.println("Loi: So luong khong duoc am.");
                            } else {
                                break;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Loi: Vui long nhap mot con so.");
                        }
                    }

                    // 5. RANG BUOC: Nhap Don Gia (Bat loi so, so am)
                    double donGia;
                    while (true) {
                        try {
                            System.out.print("Nhap don gia: ");
                            donGia = Double.parseDouble(sc.nextLine());
                            if (donGia < 0) {
                                System.out.println("Loi: Don gia khong duoc am.");
                            } else {
                                break;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Loi: Vui long nhap mot con so.");
                        }
                    }

                    // 6. RANG BUOC: Nhap Ma Hang (Kiem tra ton tai TRONG dsHSX va KHONG RONG)
                    String maHang;
                    while (true) {
                        System.out.print("Nhap ma hang: ");
                        maHang = sc.nextLine();
                        
                        if (maHang.trim().isEmpty()) {
                            System.out.println("Loi: Ma hang khong duoc de trong.");
                            continue;
                        }
                        
                        if (dsHSX.timTheoMa(maHang) == null) {
                            System.out.println("Loi: Ma hang '" + maHang + "' khong ton tai!");
                            System.out.print("Ban co muon xem danh sach hang san xuat? (y/n): ");
                            if(sc.nextLine().equalsIgnoreCase("y")) {
                                dsHSX.xuat();
                            }
                        } else {
                            break; // Ma hang hop le
                        }
                    }

                    System.out.print("Nhap ngay san xuat (dd/MM/yyyy): ");
                    String nsx = sc.nextLine(); 

                    // 7. Nhap thong tin rieng va tao doi tuong
                    SanPham spMoi;
                    if (chonLoai == 1) { // DoGiaDung
                        System.out.print("Nhap chat lieu: ");
                        String chatLieu = sc.nextLine();
                        int baoHanh;
                        while (true) {
                            try {
                                System.out.print("Nhap thoi gian bao hanh (thang): ");
                                baoHanh = Integer.parseInt(sc.nextLine());
                                if (baoHanh < 0) {
                                    System.out.println("Loi: Bao hanh khong duoc am.");
                                } else {
                                    break;
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Loi: Vui long nhap mot con so.");
                            }
                        }
                        spMoi = new DoGiaDung(maSP, tenSP, soLuong, donGia, maHang, nsx, chatLieu, baoHanh);
                    } else { // ThucPham
                        System.out.print("Nhap han su dung (dd/MM/yyyy): ");
                        String hsd = sc.nextLine();
                        System.out.print("Nhap loai bao quan (VD: Lanh, Dong Lanh, Thuong): ");
                        String loaiBaoQuan = sc.nextLine();
                        spMoi = new ThucPham(maSP, tenSP, soLuong, donGia, maHang, nsx, hsd, loaiBaoQuan);
                    }

                    dsSP.suaTheoMaSP(maSP_Cu, spMoi); // Goi ham sua cua DSSP
                    System.out.println("==> Sua san pham thanh cong!");
                    break;
                }
                case 5: { // xoa
                    int chonXoa = 0;
                    while (true) {
                        try {
                            System.out.println("1.Xoa theo ma san pham");
                            System.out.println("2.Xoa theo ten san pham");
                            System.out.print("Chon: ");
                            chonXoa = Integer.parseInt(sc.nextLine());
                            if (chonXoa == 1 || chonXoa == 2)
                                break;
                            System.out.println("Chi chon 1 hoac 2.");
                        } catch (NumberFormatException e) {
                            System.out.println("Loi: Vui long nhap mot con so.");
                        }
                    }
                    
                    String maSPCanXoa = null;
                    String tenSPCanXoa = null; // Chi dung cho viec xoa theo ten
                    SanPham spTimDeXoa = null;

                    if (chonXoa == 1) {
                        System.out.print("Nhap ma san pham muon xoa: ");
                        maSPCanXoa = sc.nextLine();
                        spTimDeXoa = dsSP.timTheoMaSP(maSPCanXoa);
                    } else {
                        System.out.print("Nhap ten san pham muon xoa: ");
                        tenSPCanXoa = sc.nextLine();
                        spTimDeXoa = dsSP.timTheoTenSP(tenSPCanXoa);
                        if(spTimDeXoa != null) {
                            maSPCanXoa = spTimDeXoa.getMaSP(); // Lay ma SP tu ten
                        }
                    }

                    if (spTimDeXoa == null) {
                        System.out.println("Loi: Khong tim thay san pham can xoa.");
                        break; // Thoat case 5
                    }

                    // --- KIEM TRA RANG BUOC TOAN VEN ---
                    boolean biRangBuoc = false;
                    
                    // 1. Kiem tra trong Chi Tiet Hoa Don
                    for (ChiTietHoaDon cthd : dsCTHD.getDanhSach()) {
                        if (cthd.getMaSP().equalsIgnoreCase(maSPCanXoa)) {
                            System.out.println("LOI: Khong the xoa. San pham dang ton tai trong Hoa Don " + cthd.getMaHD());
                            biRangBuoc = true;
                            break;
                        }
                    }
                    if (biRangBuoc) break; // Thoat khoi case 5 neu bi rang buoc

                    // 2. Kiem tra trong Chi Tiet Phieu Nhap
                    for (ChiTietPhieuNhap ctpn : dsCTPNH.getDanhSach()) {
                        if (ctpn.getMaSP().equalsIgnoreCase(maSPCanXoa)) {
                            System.out.println("LOI: Khong the xoa. San pham dang ton tai trong Phieu Nhap " + ctpn.getMaPNH());
                            biRangBuoc = true;
                            break;
                        }
                    }
                    if (biRangBuoc) break; // Thoat khoi case 5 neu bi rang buoc
                    // -------------------------------------

                    // Neu vuot qua cac kiem tra, tien hanh xoa:
                    System.out.println("...San pham khong co rang buoc. Tien hanh xoa...");
                    if (chonXoa == 1) {
                        dsSP.xoaTheoMaSP(maSPCanXoa); // Ham nay se in "Xoa thanh cong"
                    } else {
                        dsSP.xoaTheoTenSP(tenSPCanXoa); // Ham nay se in "Xoa thanh cong"
                    }
                    break;
                }
                
                case 6: { // tim
                    SanPham sp = null;
                    int chonTim = 0;
                    while (true) {
                        try {
                            System.out.println("1.Tim theo ma san pham");
                            System.out.println("2.Tim theo ten san pham");
                            System.out.print("Chon: ");
                            chonTim = Integer.parseInt(sc.nextLine());
                             if (chonTim == 1 || chonTim == 2)
                                break;
                            System.out.println("Chi chon 1 hoac 2.");
                        } catch (NumberFormatException e) {
                            System.out.println("Loi: Vui long nhap mot con so.");
                        }
                    }

                    if (chonTim == 1) {
                        System.out.print("Nhap ma san pham can tim: ");
                        String maSP = sc.nextLine();
                        sp = dsSP.timTheoMaSP(maSP);
                    } else {
                        System.out.print("Nhap ten san pham can tim: ");
                        String tenSP = sc.nextLine();
                        sp = dsSP.timTheoTenSP(tenSP);
                    }

                    // Logic xuat san pham tim thay (da co san)
                    if (sp != null) {
                        System.out.printf("| %-10s | %-15s | %-5s | %-15s | %-10s | %-7s | %-10s | %-21s | %-29s |\n",
                                "Ma San Pham", "Ten San Pham", "So Luong", "Don Gia", "Ma Hang", "Ma Loai",
                                "Ngay San Xuat", "Thong Tin Them 1", "Thong Tin Them 2");
                        System.out.println(
                                "-------------------------------------------------------------------------------------------------------------------------------------------------------------");
                        sp.xuat();
                    } else {
                        System.out.println("khong tim thay san pham ");
                    }
                    break;
                }
                case 7:
                    dsSP.thongKeSoLuongLoaiSanPham();
                    break;
                case 8:
                    try {
                        dsSP.ghiFile(DuongDan.SANPHAM_FILE_PATH);
                    } catch (IOException e) {
                        System.out.println("Ghi File loi!!!");
                    }
                    break; 
                case 9:
                    try {
                        dsSP.docFile(DuongDan.SANPHAM_FILE_PATH);
                    } catch (IOException e) {
                        System.out.println("Doc File loi!!!");
                    }
                    break; 
                case 10:
                    return; // Thoat khoi menu QLSP
                default:
                    System.out.println("Lua chon khong hop le. Vui long chon tu 1-10.");
            }
        } while (true);
    }
}