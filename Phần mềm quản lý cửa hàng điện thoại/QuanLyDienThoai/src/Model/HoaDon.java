/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import java.sql.Date;

/**
 *
 * @author Nhom24
 */
public class HoaDon {
    private int maHD;
    private int idNv;
    private Date ngaytaoHD;
    private float tongtien;
    private static int sMaHD = 1000;

    public HoaDon() {
        this.maHD = sMaHD++;
    }

    public HoaDon(int idNv, Date ngaytaoHD, float tongtien) {
        this.maHD = sMaHD++;
        this.idNv = idNv;
        this.ngaytaoHD = ngaytaoHD;
        this.tongtien = tongtien;
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public int getidNv() {
        return idNv;
    }

    public void setidNv(int idNv) {
        this.idNv = idNv;
    }

    public Date getNgaytaoHD() {
        return ngaytaoHD;
    }

    public void setNgaytaoHD(Date ngaytaoHD) {
        this.ngaytaoHD = ngaytaoHD;
    }

    public float getTongtien() {
        return tongtien;
    }

    public void setTongtien(float tongtien) {
        this.tongtien = tongtien;
    }

    
    
    
}
