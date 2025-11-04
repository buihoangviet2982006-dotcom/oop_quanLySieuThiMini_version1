package quanlysieuthi.quanli;

import java.io.IOException;
import java.util.Scanner;

import quanlysieuthi.SanPham.SanPham;
import quanlysieuthi.hoadon.ChiTietHoaDon;
import quanlysieuthi.hoadon.HoaDon;
import quanlysieuthi.tienich.DuongDan;

public class QLCTHD extends QLST{
    @Override
    public void menu(){
        Scanner sc = new Scanner(System.in);
        int chon;
        int n=0,soLuong=0;
        String maHD,maSP;
        SanPham sp;
        do {
            System.out.println("----------------------------------------------");
            System.out.println("     QUAN LY CHI TIET HOA DON");
            System.out.println("----------------------------------------------");
            System.out.println("1. Nhap danh sach chi tiet hoa don"); 
            System.out.println("2. Them chi tiet hoa don");
            System.out.println("3. Xuat danh sach chi tiet hoa don");
            System.out.println("4. Sua chi tiet hoa don");
            System.out.println("5. Xoa chi tiet hoa don");
            System.out.println("6. Tim chi tiet hoa don");
            System.out.println("7. Thong ke so luong chi tiet hoa don");
            System.out.println("8. Ghi FILE");
            System.out.println("9. Doc FILE");
            System.out.println("10. Thoat");
            System.out.print("Chon: ");
            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1:
                    if(dsHD.getSoLuong()==0){
                        System.out.println("Danh sach hoa don trong.Vui long nhap danh sach hoa don");
                        break;
                    }
                    System.out.println("Nhap so luong chi tiet hoa don can nhap");
                    n = Integer.parseInt(sc.nextLine());
                    for(int i=0;i < n;i++){
                        System.out.println("--- Nhap chi tiet hoa don thu " + (dsCTHD.getSoLuong() + 1) + " ---"); // Cập nhật lời nhắc
                        while (true) {
                            System.out.println("Nhap ma hoa don");
                            maHD = sc.nextLine();       
                            if(dsHD.timTheoMa(maHD)==null){
                                System.out.println("Ma hoa don khong ton tai.Vui long nhap lai!!");
                                continue;
                            }
                            break;                     
                        }                        
                        do{
                            System.out.println("Nhap ma san pham");
                            maSP = sc.nextLine();
                            sp = dsSP.timTheoMaSP(maSP);
                            if(sp==null){
                                System.out.println("Loi ko tim thay san pham");
                            }
                        }while(sp==null);
                        do{
                            System.out.println("Nhap so luong");
                            soLuong = Integer.parseInt(sc.nextLine());
                            if(sp.getSoLuong()-soLuong<0){
                                System.out.println("Loi so luong vuot qua so luong san pham");
                            }
                        }while(sp.getSoLuong()-soLuong<0);
                        dsCTHD.them(new ChiTietHoaDon(maHD, maSP,soLuong, sp.getDonGia()));

                        dsSP.updateSoLuong(maSP,sp.getSoLuong()-soLuong); // Cap nhat so luong
                        HoaDon hd = dsHD.timTheoMa(maHD);
                        hd.setTongTien(hd.getTongTien()+soLuong*sp.getDonGia());
                    }
                    System.out.println("Nhap danh sach thanh cong");
                    break;
                case 2:
                    if(dsHD.getSoLuong()==0){
                        System.out.println("Danh sach hoa don trong.Vui long nhap danh sach hoa don");
                        break;
                    }                
                    System.out.println("Nhap so luong chi tiet hoa don can them");
                    n = Integer.parseInt(sc.nextLine());
                    for(int i=0;i < n;i++){
                        System.out.println("--- Them chi tiet hoa don thu " + (dsCTHD.getSoLuong()+1) + " ---");
                        while (true) {
                            System.out.println("Nhap ma hoa don");
                            maHD = sc.nextLine();       
                            if(dsHD.timTheoMa(maHD)==null){
                                System.out.println("Ma hoa don khong ton tai.Vui long nhap lai!!");
                                continue;
                            }
                            break;                     
                        }  
                        do{
                            System.out.println("Nhap ma san pham");
                            maSP = sc.nextLine();
                            sp = dsSP.timTheoMaSP(maSP);
                            if(sp==null){
                                System.out.println("Loi ko tim thay san pham");
                            }
                        }while(sp==null);
                        do{
                            System.out.println("Nhap so luong");
                            soLuong = Integer.parseInt(sc.nextLine());
                            if(sp.getSoLuong()-soLuong<0){
                                System.out.println("Loi so luong vuot qua so luong san pham");
                            }
                        }while(sp.getSoLuong()-soLuong<0);
                        dsCTHD.them(new ChiTietHoaDon(maHD, maSP,soLuong, sp.getDonGia()));
                        dsSP.updateSoLuong(maSP,sp.getSoLuong()-soLuong); // Cap nhat so luong

                        HoaDon hd = dsHD.timTheoMa(maHD);
                        hd.setTongTien(hd.getTongTien()+soLuong*sp.getDonGia());
                    }
                    System.out.println("Them thanh cong");
                    break;
                case 3:
                    dsCTHD.xuat();
                    break;
                case 4: { // Sua chi tiet hoa don
                    System.out.print("Nhap ma HD can sua: ");
                    String maHD_sua = sc.nextLine();
                    System.out.print("Nhap ma SP can sua: ");
                    String maSP_sua = sc.nextLine();

                    ChiTietHoaDon cthd = dsCTHD.timChiTiet(maHD_sua, maSP_sua);
                    if (cthd == null) {
                        System.out.println("Loi: Khong tim thay chi tiet voi MaHD = " + maHD_sua + " va MaSP = " + maSP_sua);
                        break;
                    }

                    SanPham sp_sua = dsSP.timTheoMaSP(maSP_sua);
                    if (sp_sua == null) {
                        System.out.println("Loi: Khong tim thay san pham " + maSP_sua + " trong kho (Du lieu khong dong bo).");
                        break;
                    }

                    HoaDon hd = dsHD.timTheoMa(maHD_sua);
                    int oldQuantity = cthd.getSoLuong();
                    int currentStock = sp_sua.getSoLuong();
                    int newQuantity;
                    hd.setTongTien(hd.getTongTien() - cthd.getThanhTien());
                    while (true) {
                        try {
                            System.out.print("Nhap so luong moi (so luong cu: " + oldQuantity + "): ");
                            newQuantity = Integer.parseInt(sc.nextLine());
                            if (newQuantity < 0) {
                                System.out.println("So luong khong duoc am.");
                                continue;
                            }
                            
                            int stockDifference = oldQuantity - newQuantity;
                            int newStock = currentStock + stockDifference;

                            if (newStock < 0) {
                                System.out.println("Loi: So luong ton kho khong du. Ton kho hien tai: " + currentStock + ".Can lay them" + (-stockDifference) + ".");
                            } else {
                                System.out.print("Nhap don gia moi (gia cu: " + cthd.getDonGia() + "): ");
                                double newDonGia = Double.parseDouble(sc.nextLine());

                                cthd.setSoLuong(newQuantity);
                                cthd.setDonGia(newDonGia);
                                dsSP.updateSoLuong(maSP_sua, newStock);
                                hd.setTongTien(hd.getTongTien() + newQuantity*newDonGia);

                                System.out.println("==> Sua thanh cong! Ton kho moi cua SP " + maSP_sua + ": " + newStock);
                                break;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Vui long nhap mot so hop le.");
                        }
                    }
                    break;
                }
                case 5: { // Xoa chi tiet hoa don
                    System.out.print("Nhap ma HD can xoa: ");
                    String maHD_xoa = sc.nextLine();
                    System.out.print("Nhap ma SP can xoa: ");
                    String maSP_xoa = sc.nextLine();

                    int viTri = dsCTHD.timViTri(maHD_xoa, maSP_xoa);
                    
                    if (viTri == -1) {
                        System.out.println("Loi: Khong tim thay chi tiet voi MaHD = " + maHD_xoa + " va MaSP = " + maSP_xoa);
                        break;
                    }

                    ChiTietHoaDon cthd_xoa = dsCTHD.getChiTietHD(viTri);
                    SanPham sp_xoa = dsSP.timTheoMaSP(maSP_xoa);

                    if (sp_xoa == null) {
                        System.out.println("Loi: Khong tim thay san pham " + maSP_xoa + " trong kho (Du lieu khong dong bo).");
                        break;
                    }
                    HoaDon hd = dsHD.timTheoMa(maHD_xoa);
                    hd.setTongTien(hd.getTongTien()-cthd_xoa.getThanhTien());
                    
                    int deletedQuantity = cthd_xoa.getSoLuong();
                    int currentStock = sp_xoa.getSoLuong();
                    int newStock = currentStock + deletedQuantity; // Hoan tra hang ve kho

                    // Tien hanh xoa khoi mang
                    ChiTietHoaDon[] oldArr = dsCTHD.getDanhSach();
                    ChiTietHoaDon[] newArr = new ChiTietHoaDon[oldArr.length - 1];
                    for (int i = 0, j = 0; i < oldArr.length; i++) {
                        if (i != viTri) {
                            newArr[j++] = oldArr[i];
                        }
                    }
                    dsCTHD.setDanhSach(newArr);
                    
                    // Cap nhat kho sau khi xoa thanh cong
                    dsSP.updateSoLuong(maSP_xoa, newStock);

                    System.out.println("==> Xoa thanh cong! Da hoan tra " + deletedQuantity + " SP " + maSP_xoa + " ve kho. Ton kho moi: " + newStock);
                    break;
                }
                case 6:
                    ChiTietHoaDon cthd = dsCTHD.tim();
                    if (cthd != null) {
                        System.out.println("Thong tin chi tiet hoa don:");
                        cthd.xuat();
                    } else {
                        System.out.println("Khong tim thay chi tiet");
                    }
                    break;
                case 7:
                    dsCTHD.thongKeSoLuong();
                    break;
                case 8:
                    try {
                        dsCTHD.ghiFile(DuongDan.CTHOADON_FILE_PATH);                        
                    } catch (IOException e) {
                        System.out.println("Ghi File loi!!!");
                    }
                    break;                    
                case 9:
                    try {
                        dsCTHD.docFile(DuongDan.CTHOADON_FILE_PATH);
                    } catch (IOException e) {
                        System.out.println("Doc File loi!!!");
                    } 
                    break;
                case 10:
                    System.out.println("Thoat danh sach chi tiet hoa don");
                    break;
                default:
                    System.out.println("Lua chon khong hop le");
            }
        } while (chon != 10); 
    }    
}
