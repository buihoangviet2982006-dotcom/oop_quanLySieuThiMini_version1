package quanlysieuthi.danhsach;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import quanlysieuthi.Phieu.PhieuNhapHang;
import quanlysieuthi.interfaces.IDanhSach;
import quanlysieuthi.interfaces.INhapXuat;

public class DSPhieuNhapHang implements IDanhSach<PhieuNhapHang>,INhapXuat{
    private PhieuNhapHang[] danhSachPNH;

    // constructor
    public DSPhieuNhapHang() {
        danhSachPNH = new PhieuNhapHang[0];
    }

    // get
    public int getSoLuong() {
        return danhSachPNH.length;
    }
    public PhieuNhapHang[] getDanhSach(){
        return danhSachPNH;
    }
    public void setDanhSach(PhieuNhapHang[] danhSachPNH){
        this.danhSachPNH = danhSachPNH;
    }
    public PhieuNhapHang getPhieuNhapHang(int i) {
        if (i >= 0 && i < danhSachPNH.length) {
            return danhSachPNH[i];
        }
        return null;
    }

    public PhieuNhapHang timTheoMa(String maPNH) {
        for (int i = 0; i < danhSachPNH.length; i++) {
            if (danhSachPNH[i].getMaPNH().equalsIgnoreCase(maPNH)) {
                return danhSachPNH[i];
            }
        }
        return null;
    }
    public PhieuNhapHang tim() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma phieu nhap hang can tim");
        return timTheoMa(sc.nextLine());
    }
    public void them() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong phieu nhap hang can them: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            boolean hopLe = false;
            while (!hopLe) {
                System.out.println("\nNhap phieu nhap hang thu " + (danhSachPNH.length + 1) + ":");
                PhieuNhapHang p = new PhieuNhapHang();
                p.nhap();

                if (timTheoMa(p.getMaPNH()) != null) {
                    System.out.println("MaPNH da ton tai! Moi nhap lai.");
                } else {
                    PhieuNhapHang[] newArr = new PhieuNhapHang[danhSachPNH.length + 1];
                    for (int j = 0; j < danhSachPNH.length; j++) {
                        newArr[j] = danhSachPNH[j];
                    }
                    newArr[danhSachPNH.length] = p;
                    danhSachPNH = newArr;
                    hopLe = true;
                }
            }
        }
        System.out.println("Them thanh cong!");
    }

    // Thêm 1 phiếu
    public void them(PhieuNhapHang p) {
        if (timTheoMa(p.getMaPNH()) != null) {
            System.out.println("MaPNH da ton tai!");
            return;
        }
        PhieuNhapHang[] newArr = new PhieuNhapHang[danhSachPNH.length + 1];
        for (int i = 0; i < danhSachPNH.length; i++) {
            newArr[i] = danhSachPNH[i];
        }
        newArr[danhSachPNH.length] = p;
        danhSachPNH = newArr;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong phieu nhap hang can nhap: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            boolean hopLe = false;
            while (!hopLe) {
                System.out.println("\nNhap phieu nhap hang thu " + (danhSachPNH.length + 1) + ":");
                PhieuNhapHang p = new PhieuNhapHang();
                p.nhap();

                if (timTheoMa(p.getMaPNH()) != null) {
                    System.out.println("MaPNH da ton tai! Moi nhap lai.");
                } else {
                    PhieuNhapHang[] newArr = new PhieuNhapHang[danhSachPNH.length + 1];
                    for (int j = 0; j < danhSachPNH.length; j++) {
                        newArr[j] = danhSachPNH[j];
                    }
                    newArr[danhSachPNH.length] = p;
                    danhSachPNH = newArr;
                    hopLe = true;
                }
            }
        }
        System.out.println("Nhap danh sach thanh cong!");
    }

    public void xuat() {
        if (danhSachPNH.length == 0) {
            System.out.println("Danh sach trong!");
            return;
        }
        System.out.println("\nDanh sach phieu nhap hang:");
        for (int i = 0; i < danhSachPNH.length; i++) {
            danhSachPNH[i].xuat();
        }
    }

    public void sua() {
        Scanner sc = new Scanner(System.in);
        if (danhSachPNH.length == 0) {
            System.out.println("Danh sach trong!");
            return;
        }
        System.out.print("Nhap maPNH can sua: ");
        String ma = sc.nextLine();
        PhieuNhapHang p = timTheoMa(ma);
        if (p == null) {
            System.out.println("Khong tim thay phieu co maPNH = " + ma);
            return;
        }
        System.out.println("Nhap lai thong tin cho phieu " + ma + ":");
        p.nhap();
        System.out.println("Da sua thong tin!");
    }

    public void xoa() {
        Scanner sc = new Scanner(System.in);
        if (danhSachPNH.length == 0) {
            System.out.println("Danh sach trong!");
            return;
        }
        System.out.print("Nhap maPNH can xoa: ");
        String ma = sc.nextLine();
        int vt = -1;
        for (int i = 0; i < danhSachPNH.length; i++) {
            if (danhSachPNH[i].getMaPNH().equalsIgnoreCase(ma)) {
                vt = i;
                break;
            }
        }
        if (vt == -1) {
            System.out.println("Khong tim thay phieu co maPNH = " + ma);
            return;
        }

        PhieuNhapHang[] newArr = new PhieuNhapHang[danhSachPNH.length - 1];
        for (int i = 0, j = 0; i < danhSachPNH.length; i++) {
            if (i != vt) {
                newArr[j++] = danhSachPNH[i];
            }
        }
        danhSachPNH = newArr;

        System.out.println("Da xoa phieu co maPNH = " + ma);
    }

    public void ghiFile(String tenFile) throws IOException{
        for(int i=0;i<danhSachPNH.length;i++){
            danhSachPNH[i].ghiFile(tenFile);
        }
    }
    public void docFile(String tenFile) throws IOException{
        DataInputStream inpStream = new DataInputStream(new FileInputStream(tenFile));
        try {
            while (true) {
                them(new PhieuNhapHang(inpStream.readUTF(),inpStream.readUTF(),inpStream.readUTF(),
                                        inpStream.readUTF(),inpStream.readDouble()));
            }
        } catch (Exception e) {}
    }

    public double[] ThongKeTongChiTheoQuy(int nam){
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date;
        double[] tongChi = new double[4];
        for(int i=0;i<danhSachPNH.length;i++){
            PhieuNhapHang pnh = danhSachPNH[i];
            try{
                date = LocalDate.parse(pnh.getNgayNhap(), df);
            }catch(Exception e){
                System.out.println("Loi ngay thang nam khong hop le.Phieu nhap hang "+pnh.getMaPNH());
                return null;
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
        return tongChi;
    }
}