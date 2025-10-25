package quanlysieuthi.danhsach;

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
                danhSachNCC[i] = new NhaCungCap();
                danhSachNCC[i].nhap();
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
        System.out.printf("| %-10s | %-20s | %-18s | %-30s |\n" , "Ma NCC","Ten NCC","So dien thoai","Dia chi");
        for(int i=0;i<danhSachNCC.length;i++){
            System.out.println("-------------------------------------------------------------------------------------------");
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
            danhSachNCC[i] = new NhaCungCap();
            danhSachNCC[i].nhap();
        }
        
    }
    public void them(NhaCungCap nhaCungCap){
        danhSachNCC = Arrays.copyOf(danhSachNCC,danhSachNCC.length+1);
        danhSachNCC[danhSachNCC.length - 1] = nhaCungCap;
    }

    public void xoa(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma nha cung cap muon xoa");
        String maNCC = sc.nextLine();
        for(int i=0;i<danhSachNCC.length;i++){
            if(maNCC.equalsIgnoreCase(danhSachNCC[i].getMaNCC())){
                for(int j=i;j < danhSachNCC.length -1; j++){
                    danhSachNCC[j] = danhSachNCC[j+1];
                }
                danhSachNCC = Arrays.copyOf(danhSachNCC, danhSachNCC.length - 1);
                break;
            }
        }
    }
    public void xoa(String maNCC){
        for(int i=0;i<danhSachNCC.length;i++){
            if(maNCC.equalsIgnoreCase(danhSachNCC[i].getMaNCC())){
                for(int j=i;j < danhSachNCC.length -1; j++){
                    danhSachNCC[j] = danhSachNCC[j+1];
                }
                danhSachNCC = Arrays.copyOf(danhSachNCC, danhSachNCC.length - 1);
                break;
            }
        }        
    }

    public void sua(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma nha cung cap muon sua");
        String maNCC = sc.nextLine();     
        for(int i = 0;i < danhSachNCC.length;i++){
            if(maNCC.equalsIgnoreCase(danhSachNCC[i].getMaNCC())){
                danhSachNCC[i].nhap();
                break;
            }
        }   
    }
    public void sua(String maNCC,NhaCungCap nhaCungCap){
        for(int i = 0;i < danhSachNCC.length;i++){
            if(maNCC.equalsIgnoreCase(danhSachNCC[i].getMaNCC())){
                danhSachNCC[i] = nhaCungCap;
                break;
            }
        }   
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
            if(maNCC.equalsIgnoreCase(danhSachNCC[i].getMaNCC())){
                return danhSachNCC[i];
            }
        }  
        return null;          
    }
}
