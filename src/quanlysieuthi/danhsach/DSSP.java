package quanlysieuthi.danhsach;

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
    public DSSP(int n){
        danhSachSP = new SanPham[n];
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
    public void setDanhSach(DSSP danhsach){
        danhSachSP = danhsach.getDanhSach();
    }
    public void nhap(){
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
    }
    public void xuat(){
        System.out.printf("| %-10s | %-15s | %-5s | %-15s | %-10s | %-15s | %-10s | %-10s | %-29s |\n","Ma San Pham","Ten San Pham","So Luong","Don Gia","Xuat Xu","Ma Loai San Pham","Ngay San Xuat","Thong Tin Them 1","Thong Tin Them 2" );
        for(int i=0;i<danhSachSP.length;i++){
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------");
            danhSachSP[i].xuat();
        }
    }

    public void xoa(){
        Scanner sc = new Scanner(System.in);
        String maSanPham;
        System.out.println("nhap ma san pham muon xoa");
        maSanPham = sc.nextLine();
        for(int i=0;i < danhSachSP.length;i++){
            if(maSanPham.equals(danhSachSP[i].getMaSP())){
                for(int j = i;j < danhSachSP.length-1 ; j++){
                    danhSachSP[j] = danhSachSP[j+1];
                }
                danhSachSP = Arrays.copyOf(danhSachSP,danhSachSP.length-1);
                break;
            }
        }
    }

    public void xoa(String maSanPham){
        for(int i=0;i < danhSachSP.length;i++){
            if(maSanPham.equals(danhSachSP[i].getMaSP())){
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

    public void sua(String maSanPham,SanPham sanPham){
        for(int i=0;i < danhSachSP.length;i++){
            if(maSanPham.equals(danhSachSP[i].getMaSP())){
                danhSachSP[i] = sanPham;
            }
        }
    }
    public void sua(String maSanPham){
        for(int i=0;i < danhSachSP.length;i++){
            if(maSanPham.equals(danhSachSP[i].getMaSP())){
                danhSachSP[i].nhap();
            }

        }
    }
    public SanPham tim(String maSP){
        for(int i=0;i<danhSachSP.length;i++){
            if(maSP.equals(danhSachSP[i].getMaSP())){
                return danhSachSP[i];
            }
        }
        return null;
    }


}
