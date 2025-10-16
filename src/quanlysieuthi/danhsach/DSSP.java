package quanlysieuthi.danhsach;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import quanlysieuthi.SanPham.DoGiaDung;
import quanlysieuthi.SanPham.SanPham;
import quanlysieuthi.SanPham.ThucPham;

public class DSSP {
    private SanPham[] danhSachSP;

    public DSSP(){
        danhSachSP = new SanPham[0];
    }
    public DSSP(SanPham[] danhSachSP){
        this.danhSachSP = danhSachSP;
    }
    public DSSP(DSSP danhsach){
        danhSachSP = new SanPham[danhsach.getSoLuong()];
        for(int i=0;i<danhsach.getSoLuong();i++){
            if(danhsach.getSanPham(i) instanceof DoGiaDung){
                DoGiaDung dgd = new DoGiaDung((DoGiaDung)danhsach.getSanPham(i));
                danhSachSP[i] = dgd;
            }else if(danhsach.getSanPham(i) instanceof ThucPham){
                ThucPham tp = new ThucPham((ThucPham)danhsach.getSanPham(i));
                danhSachSP[i] = tp;                
            }
        }
    }

    public int getSoLuong(){return danhSachSP.length;}
    public SanPham getSanPham(int i){
        if(i>=0 && i<danhSachSP.length){
            return danhSachSP[i];
        }
        return null;
    }
    public SanPham[] getDanhSach(){return danhSachSP;}
    public void setDanhSach(SanPham[] danhSachSP){
        this.danhSachSP = danhSachSP; 
    }
    public void nhap(){
        if(danhSachSP.length==0){
            Scanner sc = new Scanner(System.in);
            int n=0,chon=0;
            System.out.println("nhap so luong san pham ");
            n = Integer.parseInt(sc.nextLine());
            danhSachSP = new SanPham[n];
            for(int i=0;i<n;i++){
                System.out.println("1.Do Gia Dung");
                System.out.println("2.Thuc Pham");
                System.out.println("chon loai san pham: ");
                chon = Integer.parseInt(sc.nextLine());
                if(chon==1){
                    danhSachSP[i] = new DoGiaDung();
                    danhSachSP[i].nhap();
                }else if(chon == 2){
                    danhSachSP[i] = new ThucPham();
                    danhSachSP[i].nhap();
                }
            }
        }else{
            them();
        }
    }
    public void xuat(){
        System.out.printf("| %-10s | %-15s | %-5s | %-15s | %-10s | %-15s | %-10s | %-21s | %-29s |\n","Ma San Pham","Ten San Pham","So Luong","Don Gia","Xuat Xu","Ma Loai San Pham","Ngay San Xuat","Thong Tin Them 1","Thong Tin Them 2" );
        for(int i=0;i<danhSachSP.length;i++){
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            danhSachSP[i].xuat();
        }
    }

    public void xoa(){
        Scanner sc = new Scanner(System.in);
        int chon=0;
        String t;
        while (true) {
            try{
                System.out.println("1.Xoa theo ma san pham");
                System.out.println("2.Xoa theo ten san pham");
                System.out.print("chon:");
                chon = Integer.parseInt(sc.nextLine());
                if(chon==1){
                    System.out.println("Nhap ma san pham muon xoa");
                    t = sc.nextLine();
                    xoaTheoMaSP(t);
                    return;
                }else if(chon==2){
                    System.out.println("Nhap ten san pham muon xoa");
                    t = sc.nextLine();
                    xoaTheoTenSP(t);
                    return;
                }else{
                    System.out.println("Lua chon khong phu hop.Xin vui long nhap lai!");
                }
            }catch(Exception e){
                System.out.println("Lua chon khong phu hop.Xin vui long nhap lai!");
            }
        }
    }

    public void xoaTheoMaSP(String maSanPham){
        for(int i=0;i < danhSachSP.length;i++){
            if(maSanPham.equalsIgnoreCase(danhSachSP[i].getMaSP())){
                for(int j = i;j < danhSachSP.length-1 ; j++){
                    danhSachSP[j] = danhSachSP[j+1];
                }
                danhSachSP = Arrays.copyOf(danhSachSP,danhSachSP.length-1);
                break;
            }
        }
    }
    public void xoaTheoTenSP(String tenSanPham){
        for(int i=0;i < danhSachSP.length;i++){
            if(tenSanPham.equalsIgnoreCase(danhSachSP[i].getTenSP())){
                for(int j = i;j < danhSachSP.length-1 ; j++){
                    danhSachSP[j] = danhSachSP[j+1];
                }
                danhSachSP = Arrays.copyOf(danhSachSP,danhSachSP.length-1);
                break;
            }
        }
    }


    public void them(SanPham sanPham){
        danhSachSP = Arrays.copyOf(danhSachSP, danhSachSP.length + 1);
        danhSachSP[danhSachSP.length-1] = sanPham;
    }
    
    public void them(){
        Scanner sc = new Scanner(System.in);
        int n=0,chon=0;
        System.out.println("nhap so luong san pham muon them: ");
        n = Integer.parseInt(sc.nextLine());
        danhSachSP = Arrays.copyOf(danhSachSP,  danhSachSP.length + n);
        for(int i = danhSachSP.length - n;i < danhSachSP.length ;i++){
            System.out.println("1.Do Gia Dung");
            System.out.println("2.Thuc Pham");
            System.out.println("chon loai san pham: ");
            chon = Integer.parseInt(sc.nextLine());
            if(chon==1){
                danhSachSP[i] = new DoGiaDung();
                danhSachSP[i].nhap();
            }else if(chon == 2){
                danhSachSP[i] = new ThucPham();
                danhSachSP[i].nhap();
            }            
        }
    }

    public void suaTheoMaSP(String maSanPham,SanPham sanPham){
        for(int i=0;i < danhSachSP.length;i++){
            if(maSanPham.equalsIgnoreCase(danhSachSP[i].getMaSP())){
                danhSachSP[i] = sanPham;
            }
        }
    }
    public void suaTheoMaSP(){
        Scanner sc = new Scanner(System.in);
        int chon=0;
        String maSP;
        System.out.println("Nhap ma san pham muon sua");
        maSP=sc.nextLine();
        while (true) {
            try{
                System.out.println("1.Do gia dung");
                System.out.println("2.Thuc pham");
                System.out.print("chon: ");
                chon = Integer.parseInt(sc.nextLine());
                if(chon==1){
                    DoGiaDung dgd = new DoGiaDung();
                    dgd.nhap();
                    suaTheoMaSP(maSP, dgd);
                    return;
                }else if(chon==2){
                    ThucPham tp = new ThucPham();
                    tp.nhap();
                    suaTheoMaSP(maSP,tp);
                    return;
                }
            }catch(Exception e){
                System.out.println("Lua chon khong phu hop.Xin vui long nhap lai!");
            }
        }

    }

    public void suaTheoTenSP(String tenSanPham,SanPham sanPham){
        for(int i=0;i < danhSachSP.length;i++){
            if(tenSanPham.equalsIgnoreCase(danhSachSP[i].getTenSP())){
                danhSachSP[i] = sanPham;
            }
        }
    }
    public void suaTheoTenSP(){
        Scanner sc = new Scanner(System.in);
        int chon=0;
        String tenSP;
        System.out.println("Nhap ten san pham muon sua");
        tenSP=sc.nextLine();
        while (true) {
            try{
                System.out.println("1.Do gia dung");
                System.out.println("2.Thuc pham");
                System.out.print("chon: ");
                chon = Integer.parseInt(sc.nextLine());
                if(chon==1){
                    DoGiaDung dgd = new DoGiaDung();
                    dgd.nhap();
                    suaTheoTenSP(tenSP, dgd);
                    return;
                }else if(chon==2){
                    ThucPham tp = new ThucPham();
                    tp.nhap();
                    suaTheoTenSP(tenSP,tp);
                    return;
                }else{
                    System.out.println("Lua chon khong phu hop.Xin vui long nhap lai!");
                }
            }catch(Exception e){
                System.out.println("Lua chon khong phu hop.Xin vui long nhap lai!");
            }
        }

    }
    
    public void sua(){
        Scanner sc = new Scanner(System.in);
        int chon=0;
        while (true) {
            try{
                System.out.println("1.Sua theo ma san pham");
                System.out.println("2.Sua theo ten san pham");
                System.out.print("chon:");
                chon = Integer.parseInt(sc.nextLine());
                if(chon==1){
                    suaTheoMaSP();
                    return;
                }else if(chon==2){
                    suaTheoTenSP();
                    return;
                }else{
                    System.out.println("Lua chon khong phu hop.Xin vui long nhap lai!");
                }
            }catch(Exception e){
                System.out.println("Lua chon khong phu hop.Xin vui long nhap lai!");
            }
        }
    }


    public SanPham timTheoMaSP(String maSP){
        for(int i=0;i<danhSachSP.length;i++){
            if(maSP.equalsIgnoreCase(danhSachSP[i].getMaSP())){
                return danhSachSP[i];
            }
        }
        return null;
    }
    public SanPham timTheoTenSP(String tenSP){
        for(int i=0;i<danhSachSP.length;i++){
            if(tenSP.equalsIgnoreCase(danhSachSP[i].getTenSP())){
                return danhSachSP[i];
            }
        }
        return null;
    }
    public SanPham tim(){
        Scanner sc = new Scanner(System.in);
        int chon=0;
        String t;
        while (true) {
            try{
                System.out.println("1.Tim theo ma san pham");
                System.out.println("2.Tim theo ten san pham");
                System.out.print("chon:");
                chon = Integer.parseInt(sc.nextLine());
                if(chon==1){
                    System.out.println("Nhap ma san pham can tim");
                    t = sc.nextLine();
                    return timTheoMaSP(t);
                }else if(chon==2){
                    System.out.println("Nhap ten san pham can tim");
                    t = sc.nextLine();                    
                    return timTheoTenSP(t);
                }else{
                    System.out.println("Lua chon khong phu hop.Xin vui long nhap lai!");
                }
            }catch(Exception e){
                System.out.println("Lua chon khong phu hop.Xin vui long nhap lai!");
            }
        }      
    }

    public void ghiFile(String tenFile) throws IOException{
        for(int i=0;i<danhSachSP.length;i++){
            danhSachSP[i].ghiFile(tenFile);
        }
    }

    public void docFile(String tenFile) throws IOException{
        DataInputStream inStream = new DataInputStream(new FileInputStream(tenFile));  
        String maLoai;
        try {
            while (true) {
                maLoai = inStream.readUTF();
                if(maLoai.equals("TP")){
                    them(new ThucPham(inStream.readUTF(),inStream.readUTF(),inStream.readInt(),
                                        inStream.readDouble(),inStream.readUTF(),maLoai,
                                        inStream.readUTF(),inStream.readUTF(),inStream.readUTF()));
                }else if(maLoai.equals("DGD")){
                    them(new DoGiaDung(inStream.readUTF(),inStream.readUTF(),inStream.readInt(),
                                        inStream.readDouble(),inStream.readUTF(),maLoai,
                                        inStream.readUTF(),inStream.readUTF(),inStream.readInt()));
                }
            }
        } catch (EOFException e) {}
    }
    public void updateSoLuong(String maSP,int soLuong){
        for(int i=0;i<danhSachSP.length;i++){
            if(maSP.equalsIgnoreCase(danhSachSP[i].getMaSP())){
                danhSachSP[i].setSoLuong(soLuong);
                return;
            }
        }
    }
}
