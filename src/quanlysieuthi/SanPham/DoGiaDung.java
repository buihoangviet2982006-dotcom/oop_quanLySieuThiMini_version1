package quanlysieuthi.SanPham;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class DoGiaDung extends SanPham {
    private String chatLieu;
    private int baoHanh; // so thang

    // Constructor mac dinh
    public DoGiaDung() {
        super();
    }

    // Constructor co tham so
    public DoGiaDung(String maSP, String tenSP, int soLuong, double donGia,
                     String xuatXu, String maLoaiSP, String nsx,
                     String chatLieu, int baoHanh) {
        super(maSP, tenSP, soLuong, donGia, xuatXu, maLoaiSP, nsx);
        this.chatLieu = chatLieu;
        this.baoHanh = baoHanh;
    }

    // Copy constructor
    public DoGiaDung(DoGiaDung other) {
        super(other);
        this.chatLieu = other.chatLieu;
        this.baoHanh = other.baoHanh;
    }

    // Getter & Setter
    public String getChatLieu() { return chatLieu; }
    public void setChatLieu(String chatLieu) { this.chatLieu = chatLieu; }

    public int getBaoHanh() { return baoHanh; }
    public void setBaoHanh(int baoHanh) { this.baoHanh = baoHanh; }

    // Ham nhap
    @Override
    public void nhap() {
        super.nhap(); // goi ham nhap cua SanPham truoc
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap chat lieu: ");
        chatLieu = sc.nextLine();
        System.out.print("Nhap thoi gian bao hanh (thang): ");
        baoHanh = Integer.parseInt(sc.nextLine());
    }

    // Ham xuat
    @Override
    public void xuat() {
        super.xuat();
        System.out.printf(" chat lieu: %-10s | bao hanh: %-19s |\n",chatLieu,String.format("%d thang", baoHanh));
    }
    @Override
    public void ghiFile(String tenFile) throws IOException{
        DataOutputStream outStream = new DataOutputStream(new FileOutputStream(tenFile, Boolean.TRUE));
        super.ghiFile(tenFile);
        outStream.writeUTF(chatLieu);
        outStream.writeInt(baoHanh);
        outStream.close();              
    }
    @Override
    public void docFile(String tenFile) throws IOException{
        DataInputStream inStream = new DataInputStream(new FileInputStream(tenFile));
        super.docFile(tenFile);
        chatLieu=inStream.readUTF();
        baoHanh=inStream.readInt();
        inStream.close();
    }
}
