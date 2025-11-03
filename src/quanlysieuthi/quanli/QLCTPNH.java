package quanlysieuthi.quanli;

import java.io.IOException;
import java.util.Scanner;

import quanlysieuthi.Phieu.ChiTietPhieuNhap;
import quanlysieuthi.SanPham.SanPham;
import quanlysieuthi.tienich.DuongDan;

public class QLCTPNH extends QLST{
    @Override
    public void menu(){
        Scanner sc = new Scanner(System.in);
        int chon;
        int n=0,soLuong=0;
        String maPNH,maSP;
        SanPham sp;
        do {
            System.out.println("----------------------------------------------");
            System.out.println("        QUAN LY CHI TIET PHIEU NHAP HANG");
            System.out.println("----------------------------------------------");
            System.out.println("1. Nhap danh sach chi tiet phieu nhap"); 
            System.out.println("2. Them chi tiet phieu nhap");
            System.out.println("3. Xuat danh sach chi tiet phieu nhap");
            System.out.println("4. Sua chi tiet phieu nhap");
            System.out.println("5. Xoa chi tiet phieu nhap");
            System.out.println("6. Tim chi tiet phieu nhap");
            System.out.println("7. Thong ke so luong chi tiet phieu nhap");
            System.out.println("8. Ghi FILE");
            System.out.println("9. Doc FILE");
            System.out.println("10. Thoat");
            System.out.print("Chon: ");
            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1:
                    System.out.println("Nhap so luong chi tiet phieu nhap hang can nhap");
                    n = Integer.parseInt(sc.nextLine());
                    for(int i=0;i < n;i++){
                        System.out.println("--- Nhap chi tiet phieu nhap thu " + (dsCTPNH.getSoLuong() + 1) + " ---"); // Cập nhật lời nhắc
                        System.out.println("Nhap ma phieu nhap hang");
                        maPNH = sc.nextLine();
                        do{
                            System.out.println("Nhap ma san pham");
                            maSP = sc.nextLine();
                            sp = dsSP.timTheoMaSP(maSP);
                            if(sp==null){
                                System.out.println("Loi ko tim thay san pham");
                            }
                        }while(sp==null);
                        System.out.println("Nhap so luong");
                        soLuong = Integer.parseInt(sc.nextLine());
                        dsCTPNH.them(new ChiTietPhieuNhap(maPNH, maSP,soLuong, sp.getDonGia()));
                        dsSP.updateSoLuong(maSP,sp.getSoLuong()+soLuong); // Cap nhat so luong
                    }
                    System.out.println("Nhap danh sach thanh cong");
                    break;
                case 2:
                    System.out.println("Nhap so luong chi tiet phieu nhap hang can them");
                    n = Integer.parseInt(sc.nextLine());
                    for(int i=0;i < n;i++){
                        System.out.println("--- Them chi tiet phieu nhap thu " + (dsCTPNH.getSoLuong()+1) + " ---");
                        System.out.println("Nhap ma phieu nhap hang");
                        maPNH = sc.nextLine();
                        do{
                            System.out.println("Nhap ma san pham");
                            maSP = sc.nextLine();
                            sp = dsSP.timTheoMaSP(maSP);
                            if(sp==null){
                                System.out.println("Loi ko tim thay san pham");
                            }
                        }while(sp==null);
                        System.out.println("Nhap so luong");
                        soLuong = Integer.parseInt(sc.nextLine());
                        dsCTPNH.them(new ChiTietPhieuNhap(maPNH, maSP,soLuong, sp.getDonGia()));
                        dsSP.updateSoLuong(maSP,sp.getSoLuong()+soLuong); // Cap nhat so luong
                    }
                    System.out.println("Them thanh cong");
                    break;
                case 3:
                    dsCTPNH.xuat();
                    break;
                case 4: { 
                    System.out.print("Nhap ma PNH can sua: ");
                    String maPNH_sua = sc.nextLine();
                    System.out.print("Nhap ma SP can sua: ");
                    String maSP_sua = sc.nextLine();

                    ChiTietPhieuNhap ctpn = dsCTPNH.timChiTiet(maPNH_sua, maSP_sua);
                    if (ctpn == null) {
                        System.out.println("Loi: Khong tim thay chi tiet voi MaPNH = " + maPNH_sua + " va MaSP = " + maSP_sua);
                        break;
                    }

                    SanPham sp_sua = dsSP.timTheoMaSP(maSP_sua);
                    if (sp_sua == null) {
                        System.out.println("Loi: Khong tim thay san pham " + maSP_sua + " trong kho (Du lieu khong dong bo).");
                        break;
                    }

                    int oldQuantity = ctpn.getSoLuong();
                    int currentStock = sp_sua.getSoLuong();
                    int newQuantity;

                    while (true) {
                        try {
                            System.out.print("Nhap so luong moi (so luong cu: " + oldQuantity + "): ");
                            newQuantity = Integer.parseInt(sc.nextLine());
                            if (newQuantity < 0) {
                                System.out.println("So luong khong duoc am.");
                                continue;
                            }
                            
                            int stockDifference = newQuantity - oldQuantity;
                            int newStock = currentStock + stockDifference;

                            if (newStock < 0) {
                                System.out.println("Loi: So luong ton kho se bi am (" + newStock + "). Khong the sua.");
                            } else {
                                System.out.print("Nhap don gia moi (gia cu: " + ctpn.getDonGia() + "): ");
                                double newDonGia = Double.parseDouble(sc.nextLine());

                                ctpn.setSoLuong(newQuantity);
                                ctpn.setDonGia(newDonGia);
                                dsSP.updateSoLuong(maSP_sua, newStock);

                                System.out.println("==> Sua thanh cong! Ton kho moi cua SP " + maSP_sua + ": " + newStock);
                                break;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Vui long nhap mot so hop le.");
                        }
                    }
                    break;
                }
                case 5: { // Xoa chi tiet phieu nhap
                    System.out.print("Nhap ma PNH can xoa: ");
                    String maPNH_xoa = sc.nextLine();
                    System.out.print("Nhap ma SP can xoa: ");
                    String maSP_xoa = sc.nextLine();

                    int viTri = dsCTPNH.timViTri(maPNH_xoa, maSP_xoa);
                    
                    if (viTri == -1) {
                        System.out.println("Loi: Khong tim thay chi tiet voi MaPNH = " + maPNH_xoa + " va MaSP = " + maSP_xoa);
                        break;
                    }

                    ChiTietPhieuNhap ctpn_xoa = dsCTPNH.danhSachCTPNH(viTri); // Using the correct getter
                    SanPham sp_xoa = dsSP.timTheoMaSP(maSP_xoa);

                    if (sp_xoa == null) {
                        System.out.println("Loi: Khong tim thay san pham " + maSP_xoa + " trong kho (Du lieu khong dong bo).");
                        break;
                    }

                    int deletedQuantity = ctpn_xoa.getSoLuong();
                    int currentStock = sp_xoa.getSoLuong();
                    int newStock = currentStock - deletedQuantity; // Rut hang khoi kho

                    if (newStock < 0) {
                        System.out.println("Loi: Khong a xoa. Ton kho se bi am (" + newStock + ").");
                        break;
                    }

                    // Tien hanh xoa khoi mang
                    ChiTietPhieuNhap[] oldArr = dsCTPNH.getDanhSach();
                    ChiTietPhieuNhap[] newArr = new ChiTietPhieuNhap[oldArr.length - 1];
                    for (int i = 0, j = 0; i < oldArr.length; i++) {
                        if (i != viTri) {
                            newArr[j++] = oldArr[i];
                        }
                    }
                    dsCTPNH.setDanhSach(newArr);
                    
                    // Cap nhat kho sau khi xoa thanh cong
                    dsSP.updateSoLuong(maSP_xoa, newStock);

                    System.out.println("==> Xoa thanh cong! Da rut " + deletedQuantity + " SP " + maSP_xoa + " khoi kho. Ton kho moi: " + newStock);
                    break;
                }
                case 6: // Gọi hàm tim()
                    ChiTietPhieuNhap ctpn = dsCTPNH.tim();
                     if (ctpn != null) {
                        System.out.println("Thong tin chi tiet phieu nhap:");
                        ctpn.xuat();
                    } else {
                        System.out.println("Khong tim thay chi tiet");
                    }
                    break;
                case 7:
                    dsCTPNH.thongKeSoLuong();
                    break;
                case 8:
                    try {
                        dsCTPNH.ghiFile(DuongDan.CTPHIEUNHAP_FILE_PATH);
                        break;
                    } catch (IOException e) {
                        System.out.println("Ghi File loi!!!");
                    }
                case 9:
                    try {
                        dsCTPNH.docFile(DuongDan.CTPHIEUNHAP_FILE_PATH);
                        break;
                    } catch (IOException e) {
                        System.out.println("Doc File loi!!!");
                    } 
                case 10:
                    System.out.println("Thoat danh sach chi tiet phieu nhap");
                    break;
                default:
                    System.out.println("Lua chon khong hop le");
            }
        } while (chon != 10); // Cập nhật điều kiện thoát
    }    
}
