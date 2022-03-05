/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author Nhom24
 */
public class NhanVien {
    private int idNv;
    private String taikhoan;
    private String matkhau;
    private String hoten;
    private String diachi;
    private Date ngaysinh;
    private int sdt;
    private String vitri;
    private static int sid = 1;

    public NhanVien() {
    }

    public NhanVien(int idNv, String hoten, String diachi, Date ngaysinh, String taikhoan, String matkhau, int sdt,String vitri) {
        this.taikhoan = taikhoan;
        this.matkhau = matkhau;
        this.hoten = hoten;
        this.diachi = diachi;
        this.ngaysinh = ngaysinh;
        this.sdt = sdt;
        this.vitri = vitri;
        this.idNv = idNv;
    }

    public static void setSid(int sid) {
        NhanVien.sid = sid;
    }
    
    
    public int getIdNv() {
        return idNv;
    }

    public void setIdNv(int idNv) {
        this.idNv = idNv;
    }


    public String getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    public String getVitri() {
        return vitri;
    }

    public void setVitri(String vitri) {
        this.vitri = vitri;
    }
    
    
}   
