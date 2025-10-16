package quanlysieuthi.SanPham;

import java.util.Scanner;

public class ThucPham extends SanPham {
    private String hsd;          
    private String loaiBaoQuan; 

    // Constructor mac dinh
    public ThucPham() {
        super();
    }

    // Constructor co tham so
    public ThucPham(String maSP, String tenSP, int soLuong, double donGia,
                    String xuatXu, String maLoaiSP, String nsx,
                    String hsd, String loaiBaoQuan) {
        super(maSP, tenSP, soLuong, donGia, xuatXu, maLoaiSP, nsx);
        this.hsd = hsd;
        this.loaiBaoQuan = loaiBaoQuan;
    }

    // Copy constructor
    public ThucPham(ThucPham other) {
        super(other);
        this.hsd = other.hsd;
        this.loaiBaoQuan = other.loaiBaoQuan;
    }

    // Getter & Setter
    public String getHsd() {
        return hsd;
    }

    public void setHsd(String hsd) {
        this.hsd = hsd;
    }

    public String getLoaiBaoQuan() {
        return loaiBaoQuan;
    }

    public void setLoaiBaoQuan(String loaiBaoQuan) {
        this.loaiBaoQuan = loaiBaoQuan;
    }

    // Ham nhap
    @Override
    public void nhap() {
        super.nhap(); // goi nhap cua SanPham truoc
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap han su dung: ");
        hsd = sc.nextLine();

        System.out.print("Nhap loai bao quan: ");
        loaiBaoQuan = sc.nextLine();
    }

    // Ham xuat
    @Override
    public void xuat() {
        super.xuat();
        System.out.printf(" hsd: %-11s | loai bao quan %-15s |\n",hsd,loaiBaoQuan);

    }

}
