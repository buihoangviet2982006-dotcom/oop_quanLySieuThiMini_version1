package quanlysieuthi.danhsach;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import quanlysieuthi.hoadon.HoaDon;
import quanlysieuthi.interfaces.IDanhSach;
import quanlysieuthi.interfaces.INhapXuat;

public class DSHoaDon implements IDanhSach<HoaDon>,INhapXuat{
    private HoaDon[] danhSachHD;

    // Constructor
    public DSHoaDon() {
        danhSachHD = new HoaDon[0];
    }

    // Getter
    public int getSoLuong() {
        return danhSachHD.length;
    }
    public HoaDon[] getDanhSach(){
        return danhSachHD;
    }
    public void setDanhSach(HoaDon[] danhSachHD){
        this.danhSachHD = danhSachHD;
    }
    public HoaDon getHoaDon(int i) {
        if (i >= 0 && i < danhSachHD.length) {
            return danhSachHD[i];
        }
        return null;
    }

    public HoaDon timTheoMa(String maHD) {
        for (int i = 0; i < danhSachHD.length; i++) {
            if (danhSachHD[i].getMaHD().equalsIgnoreCase(maHD)) {
                return danhSachHD[i];
            }
        }
        return null;
    }
    public HoaDon tim() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma hoa don can tim");
        return timTheoMa(sc.nextLine());
    }
    public void them() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong hoa don can them: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            boolean hopLe = false;
            while (!hopLe) {
                System.out.println("\nNhap hoa don thu " + (danhSachHD.length + 1) + ":");
                HoaDon hd = new HoaDon();
                hd.nhap();

                if (timTheoMa(hd.getMaHD()) != null) {
                    System.out.println("MaHD da ton tai! Moi nhap lai.");
                } else {
                    HoaDon[] newArr = new HoaDon[danhSachHD.length + 1];
                    for (int j = 0; j < danhSachHD.length; j++) {
                        newArr[j] = danhSachHD[j];
                    }
                    newArr[danhSachHD.length] = hd;
                    danhSachHD = newArr;
                    hopLe = true;
                }
            }
        }
        System.out.println("Them thanh cong!");
    }

    public void them(HoaDon hd) {
        if (timTheoMa(hd.getMaHD()) != null) {
            System.out.println("MaHD da ton tai");
            return;
        }
        HoaDon[] newArr = new HoaDon[danhSachHD.length + 1];
        for (int i = 0; i < danhSachHD.length; i++) {
            newArr[i] = danhSachHD[i];
        }
        newArr[danhSachHD.length] = hd;
        danhSachHD = newArr;
    }
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong hoa don: ");
        int n = Integer.parseInt(sc.nextLine());
        danhSachHD = new HoaDon[n];
        for (int i = 0; i < n; i++) {
            System.out.println("\nNhap hoa don thu " + (i + 1) + ":");
            danhSachHD[i] = new HoaDon();
            danhSachHD[i].nhap();
        }
    }
    public void xuat() {
        if (danhSachHD.length == 0) {
            System.out.println("Danh sach trong");
            return;
        }
        System.out.println("\nDanh sach hoa don");
        for (int i = 0; i < danhSachHD.length; i++) {
            danhSachHD[i].xuat();
        }
    }

    public void sua() {
        Scanner sc = new Scanner(System.in);
        if (danhSachHD.length == 0) {
            System.out.println("Danh sach trong");
            return;
        }
        System.out.print("Nhap maHD can sua: ");
        String ma = sc.nextLine();
        HoaDon hd = timTheoMa(ma);
        if (hd == null) {
            System.out.println("Khong tim thay hoa don co maHD = " + ma);
            return;
        }
        System.out.println("Nhap lai thong tin cho hoa don " + ma + ":");
        hd.nhap();
        System.out.println("Da sua thong tin");
    }

    public void xoa() {
        Scanner sc = new Scanner(System.in);
        if (danhSachHD.length == 0) {
            System.out.println("Danh sach rong");
            return;
        }
        System.out.print("Nhap maHD can xoa: ");
        String ma = sc.nextLine();
        int vt = -1;
        for (int i = 0; i < danhSachHD.length; i++) {
            if (danhSachHD[i].getMaHD().equalsIgnoreCase(ma)) {
                vt = i;
                break;
            }
        }
        if (vt == -1) {
            System.out.println("Khong tim thay hoa don co maHD = " + ma);
            return;
        }

        HoaDon[] newArr = new HoaDon[danhSachHD.length - 1];
        for (int i = 0, j = 0; i < danhSachHD.length; i++) {
            if (i != vt) {
                newArr[j++] = danhSachHD[i];
            }
        }
        danhSachHD = newArr;
        System.out.println("Da xoa hoa don co maHD = " + ma);
    }

    public void timHoaDon() {
        Scanner sc = new Scanner(System.in);
        if (danhSachHD.length == 0) {
            System.out.println("Danh sach trong");
            return;
        }
        System.out.print("Nhap maHD can tim: ");
        String ma = sc.nextLine();
        HoaDon hd = timTheoMa(ma);
        if (hd == null) {
            System.out.println("Khong tim thay hoa don co maHD = " + ma);
        } else {
            System.out.println("Thong tin hoa don:");
            hd.xuat();
        }
    }

    public void ghiFile(String tenFile) throws IOException{
        // xoa du lieu tu file cu
        DataOutputStream xoaFile = new DataOutputStream(new FileOutputStream(tenFile, false)); 
        xoaFile.close();  
        for(int i=0;i<danhSachHD.length;i++){
            danhSachHD[i].ghiFile(tenFile);
        }
        System.out.println("Ghi file thanh cong");
    }
    public void docFile(String tenFile) throws IOException{
        if(danhSachHD.length!=0){
            System.out.println("Loi!! danh sach dang chua du lieu.");
            return;
        }
        DataInputStream inpStream = new DataInputStream(new FileInputStream(tenFile));
        try {
            while (true) {
                them(new HoaDon(inpStream.readUTF(),inpStream.readUTF(),inpStream.readUTF(),
                                        inpStream.readUTF(),inpStream.readUTF(),inpStream.readDouble()));
            }
        } catch (Exception e) {}
        finally{
            inpStream.close();
            System.out.println("Doc file thanh cong");
        }
    }
    // thong ke
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
        for (int i = 0; i < danhSachHD.length; i++) {
            HoaDon hoaDon = danhSachHD[i];
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
        for (int i = 0; i < danhSachHD.length; i++) {
            HoaDon hd = danhSachHD[i];
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

            for (int i = 0; i < danhSachHD.length; i++) {
                HoaDon hd = danhSachHD[i];

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
    
    public double[] ThongKeTongThuTheoQuy(int nam){
        double[] tongThu = new double[4];
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date;

        for(int i=0;i<danhSachHD.length;i++){
            HoaDon hoaDon = danhSachHD[i];
            try{
                date = LocalDate.parse(hoaDon.getNgayTao(), df);
            }catch(Exception e){
                System.out.println("Loi ngay thang nam khong hop le.Hoa don "+hoaDon.getMaHD());
                return null;
            }
            if(date.getYear()!=nam){
                continue;
            }
            switch (date.getMonthValue()) {
                case 1:case 2:case 3:
                    tongThu[0]+=hoaDon.getTongTien();
                    break;
                case 4:case 5:case 6:
                    tongThu[1]+=hoaDon.getTongTien();
                    break;
                case 7:case 8:case 9:
                    tongThu[2]+=hoaDon.getTongTien();
                    break;
                case 10:case 11:case 12:
                    tongThu[3]+=hoaDon.getTongTien();
                    break;                                                                            
                default:
                    break;
            }
        }
        return tongThu;
    }
    
    public int[] ThongKeHoaDonTheoQuy(int nam){
        int[] soLuongHD = new int[4];
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date;

        for(int i=0;i<danhSachHD.length;i++){
            HoaDon hoaDon = danhSachHD[i];
            try{
                date = LocalDate.parse(hoaDon.getNgayTao(), df);
            }catch(Exception e){
                System.out.println("Loi ngay thang nam khong hop le.Hoa don "+hoaDon.getMaHD());
                return null;
            }
            if(date.getYear()!=nam){
                continue;
            }
            switch (date.getMonthValue()) {
                case 1:case 2:case 3:
                    soLuongHD[0]++;
                    break;
                case 4:case 5:case 6:
                    soLuongHD[1]++;
                    break;
                case 7:case 8:case 9:
                    soLuongHD[2]++;
                    break;
                case 10:case 11:case 12:
                    soLuongHD[3]++;
                    break;                                                                            
                default:
                    break;
            }
        }
        return soLuongHD;  
    }
    public int thongKeSoLuong(){
        System.out.println("So luong hoa don la : "+danhSachHD.length);
        return danhSachHD.length;
    }
}
