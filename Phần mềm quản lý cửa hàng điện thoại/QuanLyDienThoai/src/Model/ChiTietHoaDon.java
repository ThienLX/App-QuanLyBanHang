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
public class ChiTietHoaDon {
    private int maCTHD;
    private int maHD;
    private Date ngaytaoHD;
    private int maSP;
    private String tenSP;
    private float thanhtien;
    private static int sMaCTHD = 1;

    public ChiTietHoaDon() {
    }
    
    public ChiTietHoaDon(int maCTHD, int maHD, int maSP, String tenSP, float thanhtien) {
        this.maCTHD = sMaCTHD++;
        this.maHD = maHD;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.thanhtien = thanhtien;
    }

    public int getMaCTHD() {
        return maCTHD;
    }

    public void setMaCTHD(int maCTHD) {
        this.maCTHD = maCTHD;
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
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

    public float getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(float thanhtien) {
        this.thanhtien = thanhtien;
    }
    
    
}
