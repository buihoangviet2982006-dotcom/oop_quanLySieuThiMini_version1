package quanlysieuthi.danhsach;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import quanlysieuthi.SanPham.DoGiaDung;
import quanlysieuthi.SanPham.SanPham;
import quanlysieuthi.SanPham.ThucPham;
import quanlysieuthi.interfaces.IDanhSach;
import quanlysieuthi.interfaces.INhapXuat;

public class DSSP implements IDanhSach<SanPham>,INhapXuat{
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

    public int getSoLuong(){
        return danhSachSP.length;
    }

    public SanPham getSanPham(int i){
        if(i>=0 && i<danhSachSP.length){
            return danhSachSP[i];
        }
        return null;
    }

    public SanPham[] getDanhSach(){
        return danhSachSP;
    }

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
            for(int i=0;i<n;){
                System.out.println("1.Do Gia Dung");
                System.out.println("2.Thuc Pham");
                System.out.println("chon loai san pham: ");
                chon = Integer.parseInt(sc.nextLine());             
                if(chon==1){
                    SanPham sp = new DoGiaDung();
                    sp.nhap();
                    while(timTheoMaSP(sp.getMaSP())!=null){
                        System.out.println("Ma sp da ton tai vui long nhap lai");
                        sp.setMaSP(sc.nextLine());
                    }
                    danhSachSP[i] = sp;
                    i++;
                }else if(chon == 2){
                    SanPham sp = new ThucPham();
                    sp.nhap();
                    while(timTheoMaSP(sp.getMaSP())!=null){
                        System.out.println("Ma sp da ton tai vui long nhap lai");
                        sp.setMaSP(sc.nextLine());
                    }
                    danhSachSP[i] = sp;
                    i++;
                }else{
                    System.out.println("Lua chon khong phu hop!!!");
                }
            }
        }else{
            them();
        }
    }

    public void xuat(){
        if(danhSachSP.length == 0){
            System.out.println("Danh sach trong !");
            return;
        }
        System.out.printf("| %-10s | %-15s | %-5s | %-15s | %-10s | %-7s | %-10s | %-21s | %-29s |\n","Ma San Pham","Ten San Pham","So Luong","Don Gia","Ma Hang","Ma Loai","Ngay San Xuat","Thong Tin Them 1","Thong Tin Them 2" );
        for(int i=0;i<danhSachSP.length;i++){
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------");
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
        int vt = -1;
        for(int i=0;i < danhSachSP.length;i++){
            if(maSanPham.equalsIgnoreCase(danhSachSP[i].getMaSP())){
                vt = i;
                break;
            }
        }
        if(vt==-1){
            System.out.println("Khong tim thay ma san pham");
            return;
        }
        for(int j = vt;j < danhSachSP.length-1 ; j++){
            danhSachSP[j] = danhSachSP[j+1];
        }
        danhSachSP = Arrays.copyOf(danhSachSP,danhSachSP.length-1);
        System.out.println("Xoa thanh cong");
    }

    public void xoaTheoTenSP(String tenSanPham){
        int vt = -1;
        for(int i=0;i < danhSachSP.length;i++){
            if(tenSanPham.equalsIgnoreCase(danhSachSP[i].getTenSP())){
                vt = i;
                break;
            }
        }
        if(vt==-1){
            System.out.println("Khong tim thay ten san pham");
            return;
        }
        for(int j = vt;j < danhSachSP.length-1 ; j++){
                    danhSachSP[j] = danhSachSP[j+1];
        }
        danhSachSP = Arrays.copyOf(danhSachSP,danhSachSP.length-1);
        System.out.println("Xoa thanh cong");
    }

    public void them(SanPham sanPham){
        if(timTheoMaSP(sanPham.getMaSP())!=null){
            System.out.println("Ma san pham da ton tai!");
            return;
        }
        danhSachSP = Arrays.copyOf(danhSachSP, danhSachSP.length + 1);
        danhSachSP[danhSachSP.length-1] = sanPham;
    }
    
    public void them(){
        Scanner sc = new Scanner(System.in);
        int n=0,chon=0;
        System.out.println("Nhap so luong san pham : ");
        n = Integer.parseInt(sc.nextLine());
        SanPham[] dssp ;
        dssp = Arrays.copyOf(danhSachSP,  danhSachSP.length + n);
        for(int i = danhSachSP.length;i < dssp.length ;){
            System.out.println("1.Do Gia Dung");
            System.out.println("2.Thuc Pham");
            System.out.println("chon loai san pham: ");
            chon = Integer.parseInt(sc.nextLine());
            if(chon==1){
                SanPham sp = new DoGiaDung();
                sp.nhap();
                while(timTheoMaSP(sp.getMaSP())!=null){
                    System.out.println("Ma sp da ton tai vui long nhap lai");
                    sp.setMaSP(sc.nextLine());
                }
                dssp[i] = sp;
                i++;
            }else if(chon == 2){
                SanPham sp = new ThucPham();
                sp.nhap();
                while(timTheoMaSP(sp.getMaSP())!=null){
                    System.out.println("Ma sp da ton tai vui long nhap lai");
                    sp.setMaSP(sc.nextLine());
                }
                dssp[i] = sp;
                i++;
            }else{
                System.out.println("Lua chon khong phu hop!!!");
            }            
        }
        danhSachSP = dssp;
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
        if(timTheoMaSP(maSP)==null){
            System.out.println("khong tim thay san pham");
            return;
        }
        while (true) {
            try{
                System.out.println("1.Do gia dung");
                System.out.println("2.Thuc pham");
                System.out.print("chon: ");
                chon = Integer.parseInt(sc.nextLine());
                if(chon==1){
                    DoGiaDung dgd = new DoGiaDung();
                    dgd.nhap();
                    while (timTheoMaSP(dgd.getMaSP())!=null&&maSP.equalsIgnoreCase(dgd.getMaSP())==false) {
                        System.out.println("Ma san pham da ton tai vui long nhap lai ");
                        dgd.setMaSP(sc.nextLine());
                    }
                    suaTheoMaSP(maSP, dgd);
                    return;
                }else if(chon==2){
                    ThucPham tp = new ThucPham();
                    tp.nhap();
                    while (timTheoMaSP(tp.getMaSP())!=null&&maSP.equalsIgnoreCase(tp.getMaSP())==false) {
                        System.out.println("Ma san pham da ton tai vui long nhap lai ");
                        tp.setMaSP(sc.nextLine());
                    }
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
        SanPham sp = timTheoTenSP(tenSP);
        if(sp==null){
            System.out.println("khong tim thay san pham");
            return;
        }
        while (true) {
            try{
                System.out.println("1.Do gia dung");
                System.out.println("2.Thuc pham");
                System.out.print("chon: ");
                chon = Integer.parseInt(sc.nextLine());
                if(chon==1){
                    DoGiaDung dgd = new DoGiaDung();
                    dgd.nhap();
                    while (timTheoMaSP(dgd.getMaSP())!=null&&sp.getMaSP().equalsIgnoreCase(dgd.getMaSP())==false) {
                        System.out.println("Ma san pham da ton tai vui long nhap lai ");
                        dgd.setMaSP(sc.nextLine());
                    }                  
                    suaTheoTenSP(tenSP, dgd);
                    return;
                }else if(chon==2){
                    ThucPham tp = new ThucPham();
                    tp.nhap();
                    while (timTheoMaSP(tp.getMaSP())!=null&&sp.getMaSP().equalsIgnoreCase(tp.getMaSP())==false) {
                        System.out.println("Ma san pham da ton tai vui long nhap lai ");
                        tp.setMaSP(sc.nextLine());
                    }
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
            if(danhSachSP[i]!=null&&maSP.equalsIgnoreCase(danhSachSP[i].getMaSP())){
                return danhSachSP[i];
            }
        }
        return null;
    }

    public SanPham timTheoTenSP(String tenSP){
        for(int i=0;i<danhSachSP.length;i++){
            if(danhSachSP[i]!=null&&tenSP.equalsIgnoreCase(danhSachSP[i].getTenSP())){
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
        // xoa du lieu tu file cu
        DataOutputStream xoaFile = new DataOutputStream(new FileOutputStream(tenFile, false)); 
        xoaFile.close();       

        for(int i=0;i<danhSachSP.length;i++){
            danhSachSP[i].ghiFile(tenFile);
        }
        System.out.println("Ghi file thanh cong");
    }

    public void docFile(String tenFile) throws IOException{
        if(danhSachSP.length!=0){
            System.out.println("Loi!! danh sach dang chua du lieu.");
            return;
        }
        DataInputStream inStream = new DataInputStream(new FileInputStream(tenFile));  
        String maLoai;
        try {
            while (true) {
                maLoai = inStream.readUTF();
                if(maLoai.equals("TP")){
                    them(new ThucPham(inStream.readUTF(),inStream.readUTF(),inStream.readInt(),
                                        inStream.readDouble(),inStream.readUTF(),
                                        inStream.readUTF(),inStream.readUTF(),inStream.readUTF()));
                }else if(maLoai.equals("DGD")){
                    them(new DoGiaDung(inStream.readUTF(),inStream.readUTF(),inStream.readInt(),
                                        inStream.readDouble(),inStream.readUTF(),
                                        inStream.readUTF(),inStream.readUTF(),inStream.readInt()));
                }
            }
        } catch (EOFException e) {}
        finally{
            inStream.close();
            System.out.println("Doc file thanh cong");
        }
        
    }
    
    public void updateSoLuong(String maSP,int soLuong){
        for(int i=0;i<danhSachSP.length;i++){
            if(maSP.equalsIgnoreCase(danhSachSP[i].getMaSP())){
                danhSachSP[i].setSoLuong(soLuong);
                return;
            }
        }
    }

    public int[] thongKeSoLuongLoaiSanPham(){
        int dem[] = new int[2];
        for(SanPham sp : danhSachSP){
            if(sp instanceof DoGiaDung){
                dem[0]++;
            }else {
                dem[1]++;
            }
        }
        System.out.println("Do gia dung co :"+ dem[0]);
        System.out.println("Thuc pham co :"+ dem[1]);
        return dem;
    }
}
