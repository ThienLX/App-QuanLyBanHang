/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Nhom24
 */
public class SanPham implements Serializable{
    private int maSP;
    private String tenSP;
    private String nhomSP;
    private float giaBan;
    private float giaNhap;
    private Date ngaySX;
    private Date hanSD;
    
    public SanPham() {
    }

    public SanPham(int maSP, String tenSP, String nhomSP, float giaNhap, float giaBan, Date ngaySX, Date hanSD) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.nhomSP = nhomSP;
        this.giaBan = giaBan;
        this.giaNhap = giaNhap;
        this.ngaySX = ngaySX;
        this.hanSD = hanSD;
    }
    
    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getNhomSP() {
        return nhomSP;
    }

    public void setNhomSP(String nhomSP) {
        this.nhomSP = nhomSP;
    }

    public float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(float giaBan) {
        this.giaBan = giaBan;
    }

    public float getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(float giaNhap) {
        this.giaNhap = giaNhap;
    }

    public Date getNgaySX() {
        return ngaySX;
    }

    public void setNgaySX(Date ngaySX) {
        this.ngaySX = ngaySX;
    }

    public Date getHanSD() {
        return hanSD;
    }

    public void setHanSD(Date hanSD) {
        this.hanSD = hanSD;
    }
    
}
