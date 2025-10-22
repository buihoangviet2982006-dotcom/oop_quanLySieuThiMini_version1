package quanlysieuthi.thongke;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import quanlysieuthi.Phieu.PhieuNhapHang;
import quanlysieuthi.danhsach.DSChiTietHD;
import quanlysieuthi.danhsach.DSChiTietPNH;
import quanlysieuthi.danhsach.DSHoaDon;
import quanlysieuthi.danhsach.DSPhieuNhapHang;
import quanlysieuthi.danhsach.DSSP;
import quanlysieuthi.hoadon.HoaDon;

public class ThongKe {
    private DSChiTietHD dsCTHD;
    private DSHoaDon dsHD;
    private DSPhieuNhapHang dsPNH; 
    private DSChiTietPNH dsCTPNH;
    private DSSP dsSP;

    public ThongKe(){
        dsCTHD = new DSChiTietHD();
        dsHD = new DSHoaDon();
        dsCTPNH = new DSChiTietPNH();
        dsPNH = new DSPhieuNhapHang();
        dsSP = new DSSP();
    }
    public ThongKe(DSSP dsSP,DSChiTietHD dsCTHD,DSHoaDon dsHD,DSChiTietPNH dsCTPNH,DSPhieuNhapHang dsPNH){
        this.dsCTHD = dsCTHD;
        this.dsHD = dsHD;
        this.dsPNH = dsPNH;
        this.dsCTPNH = dsCTPNH;
        this.dsSP = dsSP;
    }

    public void ThongKeTongTienTheoQuy(){
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date;
        Scanner sc = new Scanner(System.in);
        double[] tongThu = new double[4];
        double[] tongChi = new double[4];
        int[] soLuongHD = new int[4];
        System.out.print("Nhap nam can thong ke :");
        int nam = Integer.parseInt(sc.nextLine());

        for(int i=0;i<dsHD.getSoLuong();i++){
            HoaDon hoaDon = dsHD.getHoaDon(i);
            try{
                date = LocalDate.parse(hoaDon.getNgayTao(), df);
            }catch(Exception e){
                System.out.println("Loi ngay thang nam khong hop le.Hoa don "+hoaDon.getMaHD());
                return;
            }
            if(date.getYear()!=nam){
                continue;
            }
            switch (date.getMonthValue()) {
                case 1:case 2:case 3:
                    soLuongHD[0]++;
                    tongThu[0]+=hoaDon.getTongTien();
                    break;
                case 4:case 5:case 6:
                    soLuongHD[1]++;
                    tongThu[1]+=hoaDon.getTongTien();
                    break;
                case 7:case 8:case 9:
                    soLuongHD[2]++;
                    tongThu[2]+=hoaDon.getTongTien();
                    break;
                case 10:case 11:case 12:
                    soLuongHD[3]++;
                    tongThu[3]+=hoaDon.getTongTien();
                    break;                                                                            
                default:
                    break;
            }
        }
        for(int i=0;i<dsPNH.getSoLuong();i++){
            PhieuNhapHang pnh = dsPNH.getPhieuNhapHang(i);
            try{
                date = LocalDate.parse(pnh.getNgayNhap(), df);
            }catch(Exception e){
                System.out.println("Loi ngay thang nam khong hop le.Phieu nhap hang "+pnh.getMaPNH());
                return;
            }
            if(date.getYear()!=nam){
                continue;
            }
            switch (date.getMonthValue()) {
                case 1:case 2:case 3:
                    tongChi[0]+=pnh.getTongTien();
                    break;
                case 4:case 5:case 6:
                    tongChi[1]+=pnh.getTongTien();
                    break;
                case 7:case 8:case 9:
                    tongChi[2]+=pnh.getTongTien();
                    break;
                case 10:case 11:case 12:
                    tongChi[3]+=pnh.getTongTien();
                    break;                                                                            
                default:
                    break;
            }
        }
        System.out.println("=============================THONG KE TONG TIEN THEO QUY======================================");
        System.out.printf("|%-10s|%-15s|%-15s|%-15s|%-15s|%-15s|\n", "","Quy 1","Quy 2","Quy 3","Quy 4","Tong Cong");
        System.out.println("----------------------------------------------------------------------------------------------");
        double tongCongThu = 0;
        System.out.printf("|%-10s|", "Tong Thu");
        for(int i=0;i<4;i++){
            System.out.printf("%-15s|",String.format("%,.0f", tongThu[i]));
            tongCongThu+=tongThu[i];
        }
        System.out.printf("%-15s|\n",String.format("%,.0f", tongCongThu) );
        System.out.println("---------------------------------------------------------------------------------------------");

        int tongCongHD = 0;
        System.out.printf("|%-10s|", "Hoa Don");
        for(int i=0;i<4;i++){
            System.out.printf("%-15d|",soLuongHD[i]);
            tongCongHD+=soLuongHD[i];
        }
        System.out.printf("%-15d|\n",tongCongHD);
        System.out.println("---------------------------------------------------------------------------------------------");

        double tongCongChi = 0;
        System.out.printf("|%-10s|", "Tong Chi");
        for(int i=0;i<4;i++){
            System.out.printf("%-15s|",String.format("%,.0f", tongChi[i]));
            tongCongChi+=tongChi[i];
        }
        System.out.printf("%-15s|\n",String.format("%,.0f", tongCongChi) );
        System.out.println("---------------------------------------------------------------------------------------------");

        double tongLoiNhuan = 0;
        System.out.printf("|%-10s|", "Loi Nhuan");
        for(int i=0;i<4;i++){
            System.out.printf("%-15s|",String.format("%,.0f",tongThu[i]-tongChi[i]));
            tongLoiNhuan+=tongThu[i]-tongChi[i];
        }
        System.out.printf("%-15s|\n",String.format("%,.0f", tongLoiNhuan) );
        System.out.println("---------------------------------------------------------------------------------------------");
    }
    public void ThongKeTheoKhoangNgay() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate ngayBD, ngayKT, date;
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap ngay bat dau (dd/MM/yyyy): ");
        ngayBD = LocalDate.parse(sc.nextLine(), df);

        System.out.print("Nhap ngay ket thuc (dd/MM/yyyy): ");
        ngayKT = LocalDate.parse(sc.nextLine(), df);

        if (ngayKT.isBefore(ngayBD)) {
            System.out.println("Khoang ngay khong hop le!");
            return;
        }

        double tongThu = 0;

        System.out.println("\n================== THONG KE HOA DON THEO KHOANG NGAY ==================");
        System.out.printf("|%-10s|%-10s|%-10s|%-15s|%-15s|%-15s|\n", "MaHD", "MaNV", "MaKH", "Ngay Tao", "HinhThucTT",
                "Tong Tien");
        System.out.println("------------------------------------------------------------------------------------");

        // Duyệt toàn bộ hóa đơn
        for (int i = 0; i < dsHD.getSoLuong(); i++) {
            HoaDon hoaDon = dsHD.getHoaDon(i);
            try {
                date = LocalDate.parse(hoaDon.getNgayTao(), df);
            } catch (Exception e) {
                System.out.println("Loi ngay thang khong hop le. Hoa don: " + hoaDon.getMaHD());
                continue;
            }

            // Nếu ngày nằm trong khoảng yêu cầu
            if ((date.isAfter(ngayBD) || date.isEqual(ngayBD)) &&
                    (date.isBefore(ngayKT) || date.isEqual(ngayKT))) {

                System.out.printf("|%-10s|%-10s|%-10s|%-15s|%-15s|%-15s|\n",
                        hoaDon.getMaHD(),
                        hoaDon.getMaNV(),
                        hoaDon.getMaKH(),
                        hoaDon.getNgayTao(),
                        hoaDon.getHinhThucTT(),
                        String.format("%,.0f", hoaDon.getTongTien()));

                tongThu += hoaDon.getTongTien();
            }
        }

        System.out.println("------------------------------------------------------------------------------------");
        System.out.printf("|%-64s|%-15s|\n", "Tong cong:", String.format("%,.0f", tongThu));
        System.out.println("------------------------------------------------------------------------------------");
    } 
    public void ThongKeTongTienKHTheoQuy() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date;
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap nam can thong ke (theo Quy): ");
        int nam = Integer.parseInt(sc.nextLine());


        String[] dsMaKH = new String[0];
        for (int i = 0; i < dsHD.getSoLuong(); i++) {
            HoaDon hd = dsHD.getHoaDon(i);
            String maKH = hd.getMaKH();
            if (maKH == null || maKH.isEmpty()) continue;

            boolean tonTai = false;
            for (String s : dsMaKH) {
                if (s.equalsIgnoreCase(maKH)) {
                    tonTai = true;
                    break;
                }
            }

            if (!tonTai) {
                String[] newArr = new String[dsMaKH.length + 1];
                for (int j = 0; j < dsMaKH.length; j++) newArr[j] = dsMaKH[j];
                newArr[dsMaKH.length] = maKH;
                dsMaKH = newArr;
            }
        }

        if (dsMaKH.length == 0) {
            System.out.println("Khong co du lieu hoa don de thong ke!");
            return;
        }
        System.out.println("=========================THONG KE TONG TIEN KHACH HANG THEO QUY===============================");        
        System.out.printf("|%-10s|%-15s|%-15s|%-15s|%-15s|%-15s|\n",
                "Ma KH", "Quy 1", "Quy 2", "Quy 3", "Quy 4", "Tong Cong");
        System.out.println("----------------------------------------------------------------------------------------------");

        for (String maKH : dsMaKH) {
            double[] tongTien = new double[4];

            for (int i = 0; i < dsHD.getSoLuong(); i++) {
                HoaDon hd = dsHD.getHoaDon(i);

                if (!hd.getMaKH().equalsIgnoreCase(maKH)) continue;

                try {
                    date = LocalDate.parse(hd.getNgayTao(), df);
                } catch (Exception e) {
                    System.out.println("Loi ngay thang nam khong hop le o hoa don " + hd.getMaHD());
                    continue;
                }

                if (date.getYear() != nam) continue;

                switch (date.getMonthValue()) {
                    case 1: case 2: case 3:
                        tongTien[0] += hd.getTongTien(); break;
                    case 4: case 5: case 6:
                        tongTien[1] += hd.getTongTien(); break;
                    case 7: case 8: case 9:
                        tongTien[2] += hd.getTongTien(); break;
                    case 10: case 11: case 12:
                        tongTien[3] += hd.getTongTien(); break;
                    default: break;
                }
            }

            double tongCong = 0;
            System.out.printf("|%-10s|", maKH);
            for (int q = 0; q < 4; q++) {
                System.out.printf("%-15s|", String.format("%,.0f", tongTien[q]));
                tongCong += tongTien[q];
            }
            System.out.printf("%-15s|\n", String.format("%,.0f", tongCong));
        }

        System.out.println("----------------------------------------------------------------------------------------------");
    }       
}
