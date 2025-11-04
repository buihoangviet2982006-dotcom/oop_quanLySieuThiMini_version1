package quanlysieuthi.danhsach;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import quanlysieuthi.Nguoi.NhaCungCap;
import quanlysieuthi.interfaces.IDanhSach;
import quanlysieuthi.interfaces.INhapXuat;

public class DSNhaCungCap implements IDanhSach<NhaCungCap>,INhapXuat{
    private NhaCungCap[] danhSachNCC;
    public DSNhaCungCap(){
        danhSachNCC = new NhaCungCap[0];
    }
    public DSNhaCungCap(NhaCungCap[] danhSachNCC){
        this.danhSachNCC = danhSachNCC;
    }
    public DSNhaCungCap(DSNhaCungCap danhSachNCC){
        this.danhSachNCC = new NhaCungCap[danhSachNCC.getSoLuong()];
        for(int i=0;i < danhSachNCC.getSoLuong();i++){
            this.danhSachNCC[i] = new NhaCungCap(danhSachNCC.getNhaCungCap(i));
        }
    }
    public int getSoLuong(){return danhSachNCC.length;}
    public NhaCungCap getNhaCungCap(int i){
        if(i<0 || i>=danhSachNCC.length) return null;
        return danhSachNCC[i];
    }
    public NhaCungCap[] getDanhSachNhaCungCap(){
        return danhSachNCC;
    }
    public void setDanhSachNhaCungCap(NhaCungCap[] danhSachNCC){
        this.danhSachNCC = danhSachNCC;
    }

    public void nhap(){
        if(danhSachNCC.length==0){
            Scanner sc = new Scanner(System.in);
            int n=0;
            System.out.println("Nhap so luong nha cung cap muon them vao :");
            n = Integer.parseInt(sc.nextLine());
            danhSachNCC = new NhaCungCap[n];
            for(int i=0;i<n;i++){
                NhaCungCap ncc = new NhaCungCap();
                ncc.nhap();
                while(tim(ncc.getMaNCC())!=null){
                    System.out.println("Ma nha cung cap da ton tai!Vui long nhap lai");
                    ncc.setMaNCC(sc.nextLine());
                }
                danhSachNCC[i]=ncc;
            }
        }else{
            them();
        }
    }
    public void xuat(){
        if(danhSachNCC.length==0){
            System.out.println("Danh sach trong!");
            return;
        }
        System.out.printf("| %-10s | %-20s | %-18s | %-60s |\n" , "Ma NCC","Ten NCC","So dien thoai","Dia chi");
        for(int i=0;i<danhSachNCC.length;i++){
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            danhSachNCC[i].xuat();
        }
    }
    public void them(){
        Scanner sc = new Scanner(System.in);
        int n=0;
        System.out.println("Nhap so luong nha cung cap muon them");
        n = Integer.parseInt(sc.nextLine());
        danhSachNCC = Arrays.copyOf(danhSachNCC, danhSachNCC.length + n);
        for(int i=danhSachNCC.length - n;i < danhSachNCC.length;i++){
            NhaCungCap ncc = new NhaCungCap();
            ncc.nhap();
            while(tim(ncc.getMaNCC())!=null){
                System.out.println("Ma nha cung cap da ton tai!Vui long nhap lai");
                ncc.setMaNCC(sc.nextLine());
            }
            danhSachNCC[i]=ncc;
        }
        
    }
    public void them(NhaCungCap nhaCungCap){
        if(tim(nhaCungCap.getMaNCC())!=null){
            System.out.println("Ma nha cung cap da ton tai");
            return;
        }
        danhSachNCC = Arrays.copyOf(danhSachNCC,danhSachNCC.length+1);
        danhSachNCC[danhSachNCC.length - 1] = nhaCungCap;
    }

    public void xoa(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma nha cung cap muon xoa");
        xoa(sc.nextLine());
    }
    
    public void xoa(String maNCC){
        int vt = -1;
        for(int i=0;i<danhSachNCC.length;i++){
            if(maNCC.equalsIgnoreCase(danhSachNCC[i].getMaNCC())){
                vt=i;
            }
        }  
        
        if(vt==-1){
            System.out.println("Khong tim thay ma nha cung cap!");
            return;
        }

        for(int j=vt;j < danhSachNCC.length -1; j++){
                    danhSachNCC[j] = danhSachNCC[j+1];
        }
        danhSachNCC = Arrays.copyOf(danhSachNCC, danhSachNCC.length - 1);    
        System.out.println("Xoa thanh cong!");            
    }

    public void sua(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma nha cung cap muon sua");
        String maNCC = sc.nextLine();     
        if(tim(maNCC)==null){
            System.out.println("khong tim thay nha cung cap");
            return;
        }
        for(int i = 0;i < danhSachNCC.length;i++){
            if(maNCC.equalsIgnoreCase(danhSachNCC[i].getMaNCC())){
                NhaCungCap ncc = new NhaCungCap() ;
                ncc.nhap();
                while(tim(ncc.getMaNCC())!=null&&maNCC.equalsIgnoreCase(ncc.getMaNCC())==false){
                    System.out.println("Ma nha cung cap da ton tai!Vui long nhap lai");
                    ncc.setMaNCC(sc.nextLine());
                }
                sua(maNCC, ncc);
            }
        }   
    }
    public void sua(String maNCC,NhaCungCap nhaCungCap){
        for(int i = 0;i < danhSachNCC.length;i++){
            if(maNCC.equalsIgnoreCase(danhSachNCC[i].getMaNCC())){
                danhSachNCC[i] = nhaCungCap;
                return;
            }
        }
        System.out.println("khong tim thay nha cung cap");
    }

    public NhaCungCap tim(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma nha cung cap muon tim");
        String maNCC = sc.nextLine();  
        for(int i = 0;i < danhSachNCC.length;i++){
            if(maNCC.equalsIgnoreCase(danhSachNCC[i].getMaNCC())){
                return danhSachNCC[i];
            }
        }  
        return null;          
    }
    public NhaCungCap tim(String maNCC){
        for(int i = 0;i < danhSachNCC.length;i++){
            if(danhSachNCC[i]!=null&&maNCC.equalsIgnoreCase(danhSachNCC[i].getMaNCC())){
                return danhSachNCC[i];
            }
        }  
        return null;          
    }

    public DSNhaCungCap thongKeTheoDiaChi(String diachi){
        DSNhaCungCap dsncc = new DSNhaCungCap();
        for(int i=0;i<danhSachNCC.length;i++){     

            String diaChiNCC = danhSachNCC[i].getDiaChi();        

            if(diaChiNCC != null && diaChiNCC.toLowerCase().contains(diachi.toLowerCase())){
                dsncc.them(new NhaCungCap(danhSachNCC[i]));
            }
        }
        if(dsncc.getSoLuong()==0)return null;
        return dsncc;
    }

    public int thongKeSoLuongNhaCungCap(){
        System.out.println("So nha cung cap hien co la : " + danhSachNCC.length);
        return danhSachNCC.length;
    }

    // --- THEM MOI ---
    public void ghiFile(String tenFile) throws IOException {
        DataOutputStream xoaFile = new DataOutputStream(new FileOutputStream(tenFile, false)); 
        xoaFile.close();  
        for(int i = 0; i < danhSachNCC.length; i++){
            danhSachNCC[i].ghiFile(tenFile);
        }
        System.out.println("Ghi file thanh cong");
    }

    // --- THEM MOI ---
    public void docFile(String tenFile) throws IOException {
        if(danhSachNCC.length != 0){
            System.out.println("Loi!! danh sach dang chua du lieu.");
            return;
        }
        DataInputStream inpStream = new DataInputStream(new FileInputStream(tenFile));
        try {
            while (true) {
                them(new NhaCungCap(inpStream.readUTF(), inpStream.readUTF(), inpStream.readUTF(),
                                    inpStream.readUTF()));
            }
        } catch (Exception e) {}
        finally{
            inpStream.close();
            System.out.println("Doc file thanh cong");
        }
    }
}