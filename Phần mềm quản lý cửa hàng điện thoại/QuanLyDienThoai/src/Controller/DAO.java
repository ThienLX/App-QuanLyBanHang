/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ChiTietHoaDon;
import Model.HoaDon;
import Model.NhanVien;
import Model.SanPham;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nhom24
 */
public class DAO {

    private Connection conn;

    public DAO() {
        final String url = "jdbc:mysql://localhost:3308/cuahangdienthoai?useSSL=false";
        final String user = "root";
        final String password = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean dangnhap(String tk, String mk) {
        String sql = "SELECT * FROM tblnhanvien WHERE taikhoan=? AND matkhau=?";
        try {
            PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setString(1, tk);
            ps.setString(2, mk);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean dangnhapvitri(String tk, String mk) {
        String vt = "";
        String sql = "SELECT vitri FROM tblnhanvien WHERE taikhoan=? AND matkhau=?";
        try {
            PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setString(1, tk);
            ps.setString(2, mk);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                vt = rs.getString("vitri");
                if ("Thu ngân".equals(vt)) {
                    return true;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean addSanPham(SanPham sp) {
        String sqlInsertSP = "INSERT INTO tblsanpham(maSP, tenSP, nhomSP, giaNhap, giaBan, ngaySX, hanSD) VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sqlInsertSP);
            ps.setInt(1, sp.getMaSP());
            ps.setString(2, sp.getTenSP());
            ps.setString(3, sp.getNhomSP());
            ps.setFloat(4, sp.getGiaNhap());
            ps.setFloat(5, sp.getGiaBan());
            ps.setDate(6, new Date(sp.getNgaySX().getTime()));
            ps.setDate(7, new Date(sp.getHanSD().getTime()));

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addNhanVien(NhanVien nv) {
        String sqlInsertNV = "INSERT INTO tblnhanvien(idNV, hovaten, diachi, ngaysinh, sdt, taikhoan, matkhau, vitri) VALUES(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sqlInsertNV);
            ps.setInt(1, nv.getIdNv());
            ps.setString(2, nv.getHoten());
            ps.setString(3, nv.getDiachi());
            ps.setDate(4, new Date(nv.getNgaysinh().getTime()));
            ps.setInt(5, nv.getSdt());
            ps.setString(6, nv.getTaikhoan());
            ps.setString(7, nv.getMatkhau());
            ps.setString(8, nv.getVitri());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<SanPham> getListSanPham(String sql) {
        ArrayList<SanPham> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSP(rs.getInt(1));
                sp.setTenSP(rs.getString(2));
                sp.setNhomSP(rs.getString(3));
                sp.setGiaNhap(rs.getFloat(4));
                sp.setGiaBan(rs.getFloat(5));
                sp.setNgaySX(rs.getDate(6));
                sp.setHanSD(rs.getDate(7));
                list.add(sp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<NhanVien> getListNhanVien(String sql) {
        ArrayList<NhanVien> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setIdNv(rs.getInt("idNV"));
                nv.setHoten(rs.getString("hovaten"));
                nv.setDiachi(rs.getString("diachi"));
                nv.setNgaysinh(rs.getDate("ngaysinh"));
                nv.setSdt(rs.getInt("sdt"));
                nv.setTaikhoan(rs.getString("taikhoan"));
                nv.setMatkhau(rs.getString("matkhau"));
                nv.setVitri(rs.getString("vitri"));

                list.add(nv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<HoaDon> getListHoaDon(String sql) {
        ArrayList<HoaDon> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHD(rs.getInt(1));
                hd.setNgaytaoHD(rs.getDate(2));
                hd.setTongtien(rs.getFloat(3));
                list.add(hd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<ChiTietHoaDon> getListChiTietHoaDon(String sql) {
        ArrayList<ChiTietHoaDon> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChiTietHoaDon cthd = new ChiTietHoaDon();
                cthd.setMaCTHD(rs.getInt(1));
                cthd.setMaHD(rs.getInt(2));
                cthd.setMaSP(rs.getInt(3));
                cthd.setTenSP(rs.getString(4));
                cthd.setThanhtien(rs.getFloat(5));
                list.add(cthd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Object getObject(String sql) {
        Object ob = new Object();
        try {
            PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getObject(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean suaSanPham(SanPham sp) {
        String sql = "UPDATE tblsanpham"
                + " SET tenSP = ?,nhomSP = ?, gianhap = ?, giaban = ?, ngaySX = ?, hanSD = ?"
                + " WHERE maSP = ? ";
        try {
            PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setString(1, sp.getTenSP());
            ps.setString(2, sp.getNhomSP());
            ps.setFloat(3, sp.getGiaNhap());
            ps.setFloat(4, sp.getGiaBan());
            ps.setDate(5, new Date(sp.getNgaySX().getTime()));
            ps.setDate(6, new Date(sp.getHanSD().getTime()));

            ps.setInt(7, sp.getMaSP());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean suaNhanVien(NhanVien nv) {
        String sql = "UPDATE tblnhanvien"
                + " SET hovaten = ?, diachi = ?, ngaysinh = ?, sdt = ?, taikhoan = ?,  matkhau = ?, vitri = ?"
                + " WHERE idNV = ?";
        try {
            PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setString(1, nv.getHoten());
            ps.setString(2, nv.getDiachi());
            ps.setDate(3, new Date(nv.getNgaysinh().getTime()));
            ps.setInt(4, nv.getSdt());
            ps.setString(5, nv.getTaikhoan());
            ps.setString(6, nv.getMatkhau());
            ps.setString(7, nv.getVitri());
            ps.setInt(8, nv.getIdNv());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean xoaSanPham(int msp) {
        String sql = "DELETE FROM tblsanpham WHERE maSP = ?";
        try {
            PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setInt(1, msp);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean xoaNhanVien(int idnv) {
        String sql = "DELETE FROM tblnhanvien WHERE idNv = ?";
        try {
            PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setInt(1, idnv);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean themhoaDon(HoaDon hd, String sql) {
        try {
            PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setInt(1, hd.getMaHD());
            ps.setDate(2, new Date(hd.getNgaytaoHD().getTime()));
            ps.setFloat(3, hd.getTongtien());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean themchitiethoaDon(ChiTietHoaDon cthd, String sql) {
        try {
            PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setInt(1, cthd.getMaCTHD());
            ps.setInt(2, cthd.getMaHD());
            ps.setInt(4, cthd.getMaSP());
            ps.setString(5, cthd.getTenSP());
            ps.setFloat(6, cthd.getThanhtien());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        new DAO();
    }

}
