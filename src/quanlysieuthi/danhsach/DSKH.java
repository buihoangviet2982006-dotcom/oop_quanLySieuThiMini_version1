package quanlysieuthi.danhsach;

import java.util.Scanner;
import quanlysieuthi.Nguoi.KhachHang;
import quanlysieuthi.interfaces.IDanhSach;
import quanlysieuthi.interfaces.INhapXuat;

public class DSKH implements IDanhSach<KhachHang>,INhapXuat{
    private KhachHang[] danhSachKH;

    // Constructor
    public DSKH() {
        danhSachKH = new KhachHang[0];
    }

    // Getter
    public int getSoLuong() {
        return danhSachKH.length;
    }
    public KhachHang[] getDanhSach(){
        return danhSachKH;
    }
    public void setDanhSach(KhachHang[] danhSachKH){
        this.danhSachKH = danhSachKH;
    }
    public KhachHang getKhachHang(int i) {
        if (i >= 0 && i < danhSachKH.length) {
            return danhSachKH[i];
        }
        return null;
    }

    public KhachHang timTheoMa(String maKH) {
        for (KhachHang kh : danhSachKH) {
            if (kh.getMaKH().equalsIgnoreCase(maKH)) {
                return kh;
            }
        }
        return null;
    }
    public void nhap(){
        if (danhSachKH.length == 0) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhap so luong khach hang");
            int n = Integer.parseInt(sc.nextLine());
            danhSachKH = new KhachHang[n];
            for(int i=0;i<n;i++){
                danhSachKH[i] = new KhachHang();
                danhSachKH[i].nhap();
            }
        } else {
            them();
        }
    }
    // Nhập thêm khách hàng
    public void them() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong khach hang can them: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            boolean hopLe = false;
            while (!hopLe) {
                System.out.println("\nNhap khach hang thu " + (danhSachKH.length + 1) + ":");
                KhachHang kh = new KhachHang();
                kh.nhap();

                if (timTheoMa(kh.getMaKH()) != null) {
                    System.out.println("MaKH da ton tai! Moi nhap lai.");
                } else {
                    KhachHang[] newArr = new KhachHang[danhSachKH.length + 1];
                    for (int j = 0; j < danhSachKH.length; j++) {
                        newArr[j] = danhSachKH[j];
                    }
                    newArr[danhSachKH.length] = kh;
                    danhSachKH = newArr;
                    hopLe = true;
                }
            }
        }
        System.out.println("Them thanh cong!");
    }

    // Thêm 1 khách hàng (truyền đối tượng)
    public void them(KhachHang kh) {
        if (timTheoMa(kh.getMaKH()) != null) {
            System.out.println("MaKH da ton tai!");
            return;
        }
        KhachHang[] newArr = new KhachHang[danhSachKH.length + 1];
        for (int i = 0; i < danhSachKH.length; i++) {
            newArr[i] = danhSachKH[i];
        }
        newArr[danhSachKH.length] = kh;
        danhSachKH = newArr;
    }

    // Xuất danh sách
    public void xuat() {
        if (danhSachKH.length == 0) {
            System.out.println("Danh sach trong!");
            return;
        }
        System.out.println("\nDanh sach khach hang:");
        for (KhachHang kh : danhSachKH) {
            kh.xuat();
        }
    }

    // Sửa thông tin khách hàng
    public void sua() {
        Scanner sc = new Scanner(System.in);
        if (danhSachKH.length == 0) {
            System.out.println("Danh sach trong!");
            return;
        }
        System.out.print("Nhap maKH can sua: ");
        String ma = sc.nextLine();
        KhachHang kh = timTheoMa(ma);
        if (kh == null) {
            System.out.println("Khong tim thay khach hang co maKH = " + ma);
            return;
        }
        System.out.println("Nhap lai thong tin cho khach hang " + ma + ":");
        kh.nhap();
        System.out.println("Da sua thong tin!");
    }

    // Xóa khách hàng
    public void xoa() {
        Scanner sc = new Scanner(System.in);
        if (danhSachKH.length == 0) {
            System.out.println("Danh sach trong!");
            return;
        }
        System.out.print("Nhap maKH can xoa: ");
        String ma = sc.nextLine();
        int vt = -1;
        for (int i = 0; i < danhSachKH.length; i++) {
            if (danhSachKH[i].getMaKH().equalsIgnoreCase(ma)) {
                vt = i;
                break;
            }
        }
        if (vt == -1) {
            System.out.println("Khong tim thay khach hang co maKH = " + ma);
            return;
        }

        KhachHang[] newArr = new KhachHang[danhSachKH.length - 1];
        for (int i = 0, j = 0; i < danhSachKH.length; i++) {
            if (i != vt) {
                newArr[j++] = danhSachKH[i];
            }
        }
        danhSachKH = newArr;

        System.out.println("Da xoa khach hang co maKH = " + ma);
    }
    public KhachHang tim(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma khach hang can tim");
        return timTheoMa(sc.nextLine());
    }
}