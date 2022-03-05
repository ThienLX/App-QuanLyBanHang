/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.DAO;
import Model.ChiTietHoaDon;
import Model.HoaDon;
import Model.NhanVien;
import Model.SanPham;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nhom24
 */
public class QuanLy extends javax.swing.JDialog implements View {

    /**
     * Creates new form QuanLy
     */
    private List<SanPham> listSP;
    private DefaultTableModel modelSP;
    private List<NhanVien> listNV;
    private DefaultTableModel modelNV;
    private List<SanPham> listSP1;
    private DefaultTableModel modelSP1;
    private List<ChiTietHoaDon> listNhapXuat; //danh sách các sản phẩm ở bảng tạm
    private DefaultTableModel modelNhapXuat;
    private List<SanPham> listSP2;
    private DefaultTableModel modelSP2;
    private List<ChiTietHoaDon> listBanHang; //danh sách các sản phẩm ở bảng tạm
    private DefaultTableModel modelBanHang;
    private List<HoaDon> listHD;
    private DefaultTableModel modelThongKeHD;
    private List<ChiTietHoaDon> listThongKeChiTiet;
    private DefaultTableModel modelThongKeChiTiet;

    public QuanLy(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        listSP = new DAO().getListSanPham("SELECT * FROM tblsanpham");
        modelSP = (DefaultTableModel) tblSanPham.getModel();
        listNV = new DAO().getListNhanVien("SELECT * FROM tblnhanvien");
        modelNV = (DefaultTableModel) tblNhanVien.getModel();
        listSP1 = new DAO().getListSanPham("SELECT * FROM tblsanpham");
        modelSP1 = (DefaultTableModel) tblSanPham1.getModel();
        listNhapXuat = new ArrayList<>();
        modelNhapXuat = (DefaultTableModel) tblNhapXuat.getModel();
        listSP2 = new DAO().getListSanPham("SELECT * FROM tblsanpham");
        modelSP2 = (DefaultTableModel) tblSanPham2.getModel();
        listBanHang = new ArrayList<>();
        modelBanHang = (DefaultTableModel) tblBanHang.getModel();
        listHD = new ArrayList<>();
        modelThongKeHD = (DefaultTableModel) tblThongKeHoaDon.getModel();

        showData(listSP, modelSP);
        showData(listNV, modelNV);
        showData(listSP1, modelSP1);
        showData(listSP2, modelSP2);

    }

    public List<SanPham> getListSP() {
        return listSP;
    }

    public List<NhanVien> getListNV() {
        return listNV;
    }

    public void addSanPham(SanPham sp) {
        listSP.add(sp);
        showData(listSP, modelSP);
    }

    public void addNhanVien(NhanVien nv) {
        listNV.add(nv);
        showData(listNV, modelNV);
    }

    public String xulyngay(String date) {
        String[] arrdate = date.split("-");
        String ngay = arrdate[2] + "/" + arrdate[1] + "/" + arrdate[0];
        return ngay;
    }

    private void hienthiSP(int selectRow, String kt) {
        SanPham sp = new SanPham();
        ChiTietHoaDon cthd = new ChiTietHoaDon();
        if ("tabqlsp".equals(kt)) {
            sp = listSP.get(selectRow);

            String str1 = String.valueOf(sp.getNgaySX());
            String nsx = xulyngay(str1);
            String str2 = String.valueOf(sp.getHanSD());
            String hsd = xulyngay(str2);
            String str3 = String.valueOf(sp.getGiaNhap()).replace(".0", "");
            String str4 = String.valueOf(sp.getGiaBan()).replace(".0", "");

            tfMaSP.setText(String.valueOf(sp.getMaSP()));
            tfTenSP.setText(sp.getTenSP());
            cbNhomSP.setSelectedItem(String.valueOf(sp.getNhomSP()));
            tfGiaNhap.setText(str3);
            tfGiaBan.setText(str4);
            tfNSX.setText(nsx);
            tfHSD.setText(hsd);
            
        } else if ("tabqlkho1".equals(kt)) {
            sp = listSP1.get(selectRow);

            String str1 = String.valueOf(sp.getNgaySX());
            String nsx = xulyngay(str1);
            String str2 = String.valueOf(sp.getHanSD());
            String hsd = xulyngay(str2);
            String str3 = String.valueOf(sp.getGiaNhap()).replace(".0", "");
            String str4 = String.valueOf(sp.getGiaBan()).replace(".0", "");

            tfMaSP1.setText(String.valueOf(sp.getMaSP()));
            tfTenSP1.setText(sp.getTenSP());
            cbNhomSP1.setSelectedItem(String.valueOf(sp.getNhomSP()));
            tfGiaNhap1.setText(str3);
            tfGiaBan1.setText(str4);
            tfNSX1.setText(nsx);
            tfNHH1.setText(hsd);

        } else if ("tabqlkho2".equals(kt)) {
            cthd = listNhapXuat.get(selectRow);
            String sql = "SELECT * FROM tblsanpham WHERE maSP = " + cthd.getMaSP();
            listSP = new DAO().getListSanPham(sql);
            sp = listSP.get(0);

            String str1 = String.valueOf(sp.getNgaySX());
            String nsx = xulyngay(str1);
            String str2 = String.valueOf(sp.getHanSD());
            String hsd = xulyngay(str2);
            String str3 = String.valueOf(sp.getGiaNhap()).replace(".0", "");
            String str4 = String.valueOf(sp.getGiaBan()).replace(".0", "");

            tfMaSP1.setText(String.valueOf(sp.getMaSP()));
            tfTenSP1.setText(sp.getTenSP());
            cbNhomSP1.setSelectedItem(String.valueOf(sp.getNhomSP()));
            tfGiaNhap1.setText(str3);
            tfGiaBan1.setText(str4);
            tfNSX1.setText(nsx);
            tfNHH1.setText(hsd);

        } else if ("tabbanhang1".equals(kt)) {
            sp = listSP2.get(selectRow);

            String str1 = String.valueOf(sp.getNgaySX());
            String nsx = xulyngay(str1);
            String str2 = String.valueOf(sp.getHanSD());
            String hsd = xulyngay(str2);
            String str3 = String.valueOf(sp.getGiaNhap()).replace(".0", "");
            String str4 = String.valueOf(sp.getGiaBan()).replace(".0", "");

            tfMaSP2.setText(String.valueOf(sp.getMaSP()));
            tfTenSP2.setText(sp.getTenSP());
            cbNhomSP2.setSelectedItem(String.valueOf(sp.getNhomSP()));
            tfGiaNhap2.setText(str3);
            tfGiaBan2.setText(str4);
            tfNSX2.setText(nsx);
            tfNHH2.setText(hsd);

        } else if ("tabbanhang2".equals(kt)) {
            cthd = listBanHang.get(selectRow);
            String sql = "SELECT * FROM tblsanpham WHERE maSP = " + cthd.getMaSP();
            listSP = new DAO().getListSanPham(sql);
            sp = listSP.get(0);

            String str1 = String.valueOf(sp.getNgaySX());
            String nsx = xulyngay(str1);
            String str2 = String.valueOf(sp.getHanSD());
            String hsd = xulyngay(str2);
            String str3 = String.valueOf(sp.getGiaNhap()).replace(".0", "");
            String str4 = String.valueOf(sp.getGiaBan()).replace(".0", "");

            tfMaSP2.setText(String.valueOf(sp.getMaSP()));
            tfTenSP2.setText(sp.getTenSP());
            cbNhomSP2.setSelectedItem(String.valueOf(sp.getNhomSP()));
            tfGiaNhap2.setText(str3);
            tfGiaBan2.setText(str4);
            tfNSX2.setText(nsx);
            tfNHH2.setText(hsd);
        }
    }

    private void hienthiNhanVien(int selectRow) {
        NhanVien nv = listNV.get(selectRow);
        String str1 = String.valueOf(nv.getNgaysinh());
        String ns = xulyngay(str1);
        String sdt = "0" + String.valueOf(nv.getSdt());

        tfIdNv.setText(String.valueOf(nv.getIdNv()));
        tfHovaTen.setText(nv.getHoten());
        tfDiachi.setText(nv.getDiachi());
        tfNgaySinh.setText(ns);
        tfSDT.setText(sdt);
        tfTaiKhoan.setText(nv.getTaikhoan());
        tfMatKhau.setText(nv.getMatkhau());
        cbVitri.setSelectedItem(String.valueOf(nv.getVitri()));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem2 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem3 = new javax.swing.JRadioButtonMenuItem();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        buttonGroup7 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        tfMaSP1 = new javax.swing.JTextField();
        tfTenSP1 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        tfGiaNhap1 = new javax.swing.JTextField();
        tfGiaBan1 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblSanPham1 = new javax.swing.JTable();
        tfNHH1 = new javax.swing.JTextField();
        timKiemSP1 = new javax.swing.JButton();
        LamMoiSP1 = new javax.swing.JButton();
        capnhatSP1 = new javax.swing.JButton();
        cbNhomSP1 = new javax.swing.JComboBox<>();
        tfNSX1 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblNhapXuat = new javax.swing.JTable();
        tfMaSPKho = new javax.swing.JTextField();
        nhapMaSP1 = new javax.swing.JButton();
        rdNhapHang = new javax.swing.JRadioButton();
        rdXuatHang = new javax.swing.JRadioButton();
        luuPhieu1 = new javax.swing.JButton();
        xoaPhieu1 = new javax.swing.JButton();
        taoMoiHD1 = new javax.swing.JButton();
        jLabel43 = new javax.swing.JLabel();
        lbTongTien1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        tfMaSP2 = new javax.swing.JTextField();
        tfTenSP2 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        tfGiaNhap2 = new javax.swing.JTextField();
        tfGiaBan2 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        tfNHH2 = new javax.swing.JTextField();
        timKiemSP2 = new javax.swing.JButton();
        LamMoiSP2 = new javax.swing.JButton();
        capnhatSP2 = new javax.swing.JButton();
        cbNhomSP2 = new javax.swing.JComboBox<>();
        tfNSX2 = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblSanPham2 = new javax.swing.JTable();
        jLabel36 = new javax.swing.JLabel();
        nhapMaSP2 = new javax.swing.JButton();
        tfNhapSoLuong2 = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblBanHang = new javax.swing.JTable();
        xoaPhieu2 = new javax.swing.JButton();
        taoMoiHD2 = new javax.swing.JButton();
        luuPhieu2 = new javax.swing.JButton();
        jLabel44 = new javax.swing.JLabel();
        lbTongTien2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tfHovaTen = new javax.swing.JTextField();
        tfNgaySinh = new javax.swing.JTextField();
        tfDiachi = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        tfSDT = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        tfTaiKhoan = new javax.swing.JTextField();
        tfMatKhau = new javax.swing.JTextField();
        cbVitri = new javax.swing.JComboBox<>();
        timkiemNV = new javax.swing.JButton();
        themNhanvien = new javax.swing.JButton();
        suaNV = new javax.swing.JButton();
        xoaNV = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblNhanVien = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        tfIdNv = new javax.swing.JTextField();
        lammoiNV = new javax.swing.JButton();
        capnhatNV = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfMaSP = new javax.swing.JTextField();
        tfTenSP = new javax.swing.JTextField();
        cbNhomSP = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tfGiaNhap = new javax.swing.JTextField();
        tfGiaBan = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        tfNSX = new javax.swing.JTextField();
        tfHSD = new javax.swing.JTextField();
        themSanPham = new javax.swing.JButton();
        suaSanPham = new javax.swing.JButton();
        xoaSanPham = new javax.swing.JButton();
        timKiemSP = new javax.swing.JButton();
        LamMoiSP = new javax.swing.JButton();
        capnhatSP = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        rdHoaDonNhap = new javax.swing.JRadioButton();
        rdHoaDonXuat = new javax.swing.JRadioButton();
        rdHoaDonBanHang = new javax.swing.JRadioButton();
        rdNgay = new javax.swing.JRadioButton();
        rdThang = new javax.swing.JRadioButton();
        rdKhoangThoiGian = new javax.swing.JRadioButton();
        tfTuNgay = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfDenNgay = new javax.swing.JTextField();
        tfNgay = new javax.swing.JTextField();
        tfThang = new javax.swing.JTextField();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblThongKeHoaDon = new javax.swing.JTable();
        jLabel37 = new javax.swing.JLabel();
        thongKeHoaDon = new javax.swing.JButton();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        lbTongTien3 = new javax.swing.JLabel();
        canvas1 = new java.awt.Canvas();
        dangxuat = new javax.swing.JButton();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        jRadioButtonMenuItem2.setSelected(true);
        jRadioButtonMenuItem2.setText("jRadioButtonMenuItem2");

        jRadioButtonMenuItem3.setSelected(true);
        jRadioButtonMenuItem3.setText("jRadioButtonMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/icon home.png"))); // NOI18N
        jLabel1.setText("  Quản Lý Cửa Hàng");
        jLabel1.setVerifyInputWhenFocusTarget(false);

        jTabbedPane1.setBackground(new java.awt.Color(153, 204, 255));
        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel3.setBackground(new java.awt.Color(103, 204, 255));

        jPanel5.setBackground(new java.awt.Color(153, 204, 255));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("Mã SP");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setText("Tên SP");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setText("Hãng SX");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setText("Giá Nhập");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setText("Giá Bán");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setText("Ngày Sãn Xuất");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setText("Ngày Nhập Hàng");

        tblSanPham1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã Sản Phẩm", "Tên Sản Phẩm", "Nhóm Sản Phẩm"
            }
        ));
        tblSanPham1.setAutoscrolls(false);
        tblSanPham1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblSanPham1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPham1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblSanPham1);

        timKiemSP1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        timKiemSP1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/icon tìm kiếm.png"))); // NOI18N
        timKiemSP1.setText("Tìm Kiếm");
        timKiemSP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timKiemSP1ActionPerformed(evt);
            }
        });

        LamMoiSP1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        LamMoiSP1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/icon refresh.png"))); // NOI18N
        LamMoiSP1.setText("Làm Mới");
        LamMoiSP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LamMoiSP1ActionPerformed(evt);
            }
        });

        capnhatSP1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        capnhatSP1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/icon cập nhật.png"))); // NOI18N
        capnhatSP1.setText("Cập Nhật");
        capnhatSP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                capnhatSP1ActionPerformed(evt);
            }
        });

        cbNhomSP1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbNhomSP1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "IPhone", "SamSung" }));

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel26.setText("Nhập Hàng - Xuất Hàng");

        tblNhapXuat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã Sản Phẩm", "Tên Sản Phẩm", "Thành Tiền"
            }
        ));
        tblNhapXuat.setAutoscrolls(false);
        tblNhapXuat.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblNhapXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhapXuatMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblNhapXuat);

        nhapMaSP1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nhapMaSP1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/icon cộng.png"))); // NOI18N
        nhapMaSP1.setText("Nhập Mã Sản Phẩm");
        nhapMaSP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nhapMaSP1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdNhapHang);
        rdNhapHang.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rdNhapHang.setText("Nhập Hàng");

        buttonGroup1.add(rdXuatHang);
        rdXuatHang.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rdXuatHang.setText("Xuất Hàng");

        luuPhieu1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        luuPhieu1.setText("Lưu Phiếu");
        luuPhieu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                luuPhieu1ActionPerformed(evt);
            }
        });

        xoaPhieu1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        xoaPhieu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/icon xóa.png"))); // NOI18N
        xoaPhieu1.setText("  Xóa");
        xoaPhieu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoaPhieu1ActionPerformed(evt);
            }
        });

        taoMoiHD1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        taoMoiHD1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/icon refresh.png"))); // NOI18N
        taoMoiHD1.setText("  Hóa Đơn Mới");
        taoMoiHD1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taoMoiHD1ActionPerformed(evt);
            }
        });

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/icon xiền.png"))); // NOI18N
        jLabel43.setText("  Tổng Tiền");

        lbTongTien1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbTongTien1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTongTien1.setText("0.0");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(timKiemSP1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(LamMoiSP1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(capnhatSP1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfTenSP1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbNhomSP1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfMaSP1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(149, 149, 149)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(tfGiaBan1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tfGiaNhap1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel25)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNHH1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNSX1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(322, 322, 322)
                        .addComponent(jLabel43)
                        .addGap(18, 18, 18)
                        .addComponent(lbTongTien1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(xoaPhieu1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(63, 63, 63))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(rdNhapHang)
                                        .addGap(24, 24, 24)
                                        .addComponent(rdXuatHang)
                                        .addGap(21, 21, 21)))
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(tfMaSPKho, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(36, 36, 36)
                                        .addComponent(nhapMaSP1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(taoMoiHD1)
                                        .addGap(54, 54, 54)
                                        .addComponent(luuPhieu1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(50, 50, 50))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34))))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tfMaSP1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfGiaNhap1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfNSX1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(27, 27, 27)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfGiaBan1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfTenSP1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel25)
                    .addComponent(tfNHH1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbNhomSP1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 1, Short.MAX_VALUE)
                        .addComponent(jLabel26)
                        .addGap(41, 41, 41)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdXuatHang, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfMaSPKho, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nhapMaSP1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdNhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(luuPhieu1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(taoMoiHD1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(xoaPhieu1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(timKiemSP1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LamMoiSP1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(capnhatSP1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(74, 74, 74)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbTongTien1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(22, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Quản Lý Kho Hàng", jPanel3);

        jPanel6.setBackground(new java.awt.Color(153, 204, 255));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel28.setText("Mã SP");

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel29.setText("Tên SP");

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel30.setText("Hãng SX");

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel31.setText("Giá Nhập");

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel32.setText("Giá Bán");

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel33.setText("Ngày Sản Xuất");

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel34.setText("Ngày Nhập Hàng");

        timKiemSP2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        timKiemSP2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/icon tìm kiếm.png"))); // NOI18N
        timKiemSP2.setText("Tìm Kiếm");
        timKiemSP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timKiemSP2ActionPerformed(evt);
            }
        });

        LamMoiSP2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        LamMoiSP2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/icon refresh.png"))); // NOI18N
        LamMoiSP2.setText("Làm Mới");
        LamMoiSP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LamMoiSP2ActionPerformed(evt);
            }
        });

        capnhatSP2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        capnhatSP2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/icon cập nhật.png"))); // NOI18N
        capnhatSP2.setText("Cập Nhật");
        capnhatSP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                capnhatSP2ActionPerformed(evt);
            }
        });

        cbNhomSP2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbNhomSP2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "IPhone", "SamSung" }));

        tblSanPham2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã Sản Phẩm", "Tên Sản Phẩm", "Nhóm Sản Phẩm"
            }
        ));
        tblSanPham2.setAutoscrolls(false);
        tblSanPham2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblSanPham2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPham2MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblSanPham2);

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel36.setText("Tạo Hóa Đơn");

        nhapMaSP2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nhapMaSP2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/icon cộng.png"))); // NOI18N
        nhapMaSP2.setText("Nhập Mã Sản Phẩm");
        nhapMaSP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nhapMaSP2ActionPerformed(evt);
            }
        });

        tblBanHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã Sản Phẩm", "Tên Sản Phẩm", "Thành Tiền"
            }
        ));
        tblBanHang.setAutoscrolls(false);
        tblBanHang.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblBanHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBanHangMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblBanHang);

        xoaPhieu2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        xoaPhieu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/icon xóa.png"))); // NOI18N
        xoaPhieu2.setText("  Xoá");
        xoaPhieu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoaPhieu2ActionPerformed(evt);
            }
        });

        taoMoiHD2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        taoMoiHD2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/icon refresh.png"))); // NOI18N
        taoMoiHD2.setText("  Hóa Đơn Mới");
        taoMoiHD2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taoMoiHD2ActionPerformed(evt);
            }
        });

        luuPhieu2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        luuPhieu2.setText("Lưu Phiếu");
        luuPhieu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                luuPhieu2ActionPerformed(evt);
            }
        });

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/icon xiền.png"))); // NOI18N
        jLabel44.setText("Tổng Tiền");

        lbTongTien2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbTongTien2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTongTien2.setText("0.0");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(timKiemSP2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(51, 51, 51)
                                    .addComponent(LamMoiSP2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(51, 51, 51)
                                    .addComponent(capnhatSP2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                            .addGap(277, 277, 277)
                                            .addComponent(tfNhapSoLuong2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(104, 104, 104)
                                            .addComponent(nhapMaSP2))
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addGap(103, 103, 103)
                                                .addComponent(xoaPhieu2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(62, 62, 62)
                                                .addComponent(taoMoiHD2)
                                                .addGap(59, 59, 59)
                                                .addComponent(luuPhieu2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                                .addGap(355, 355, 355)
                                                .addComponent(jLabel36)
                                                .addGap(180, 180, 180)))))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                    .addGap(432, 432, 432)
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(tfGiaNhap2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(tfGiaBan2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(214, 214, 214)))
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel33)
                                        .addComponent(jLabel34))
                                    .addGap(26, 26, 26)
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tfNSX2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tfNHH2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(70, 70, 70)))
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(18, 18, 18)
                                    .addComponent(cbNhomSP2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfTenSP2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(34, 34, 34)
                                    .addComponent(tfMaSP2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(230, 230, 230)
                                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbTongTien2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfGiaNhap2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel31)
                        .addComponent(tfNSX2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel33))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(tfMaSP2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfTenSP2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29))
                        .addGap(9, 9, 9))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tfNHH2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel34))
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tfGiaBan2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel32)))
                        .addGap(2, 2, 2)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nhapMaSP2)
                            .addComponent(tfNhapSoLuong2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(xoaPhieu2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(taoMoiHD2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(luuPhieu2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbNhomSP2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(timKiemSP2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LamMoiSP2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(capnhatSP2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(72, 72, 72)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel44)
                            .addComponent(lbTongTien2))
                        .addGap(43, 43, 43))))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Quản Lý Bán Hàng", jPanel1);

        jPanel4.setBackground(new java.awt.Color(153, 204, 255));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Họ và Tên:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Ngày sinh:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Địa chỉ:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("SĐT:");

        tfSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSDTActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Tài Khoản:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Mật Khẩu:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Vị trí:");

        cbVitri.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thu ngân", "Kho" }));
        cbVitri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbVitriActionPerformed(evt);
            }
        });

        timkiemNV.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        timkiemNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/icon tìm kiếm.png"))); // NOI18N
        timkiemNV.setText("Tìm Kiếm ");
        timkiemNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timkiemNVActionPerformed(evt);
            }
        });

        themNhanvien.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        themNhanvien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/thêm nv.png"))); // NOI18N
        themNhanvien.setText("Thêm Nhân Viên");
        themNhanvien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themNhanvienActionPerformed(evt);
            }
        });

        suaNV.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        suaNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/form-edit_1.png"))); // NOI18N
        suaNV.setText("Sửa thông tin");
        suaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suaNVActionPerformed(evt);
            }
        });

        xoaNV.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        xoaNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/xóa nv.png"))); // NOI18N
        xoaNV.setText("Xóa Nhân viên");
        xoaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoaNVActionPerformed(evt);
            }
        });

        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "ID Nv", "Họ và Tên", "Địa Chỉ", "Ngày Sinh", "SDT", "Tài Khoản", "Mật Khẩu", "Vị Trí"
            }
        ));
        tblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanVienMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblNhanVien);
        if (tblNhanVien.getColumnModel().getColumnCount() > 0) {
            tblNhanVien.getColumnModel().getColumn(1).setHeaderValue("ID Nv");
        }

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("ID:");

        lammoiNV.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lammoiNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/icon refresh.png"))); // NOI18N
        lammoiNV.setText("Làm Mới");
        lammoiNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lammoiNVActionPerformed(evt);
            }
        });

        capnhatNV.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        capnhatNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/icon cập nhật.png"))); // NOI18N
        capnhatNV.setText("Cập Nhật");
        capnhatNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                capnhatNVActionPerformed(evt);
            }
        });

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/ql nvien.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGap(35, 35, 35)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel10)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(22, 22, 22))))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfIdNv, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfHovaTen, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(209, 209, 209)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(themNhanvien)
                                    .addComponent(xoaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(92, 92, 92)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(capnhatNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lammoiNV, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(94, 94, 94)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(timkiemNV, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(suaNV))
                                .addGap(78, 78, 78))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(tfTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbVitri, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(276, 276, 276)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 875, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(65, 65, 65))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(themNhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lammoiNV, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(timkiemNV, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(tfHovaTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(capnhatNV, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(suaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(xoaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(39, 39, 39)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(tfIdNv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
                        .addGap(56, 56, 56))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(tfDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(tfSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(tfMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbVitri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel17)
                        .addGap(174, 174, 174))))
        );

        jTabbedPane1.addTab("Quản Lý nhân viên", jPanel4);

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Mã SP");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Tên SP");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Hãng SX");

        cbNhomSP.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbNhomSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "IPhone", "SamSung" }));
        cbNhomSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNhomSPActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Giá Nhập");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Giá Bán");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Ngày Sản Xuất");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Ngày Nhập Hàng");

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã Sản Phẩm", "Tên Sản Phẩm", "Nhóm Sản Phẩm", "Giá Nhập", "Giá Bán", "NSX", "NNH"
            }
        ));
        tblSanPham.setAutoscrolls(false);
        tblSanPham.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSanPham);

        tfNSX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNSXActionPerformed(evt);
            }
        });

        themSanPham.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        themSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/icon cộng.png"))); // NOI18N
        themSanPham.setText("Thêm Sản Phẩm");
        themSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themSanPhamActionPerformed(evt);
            }
        });

        suaSanPham.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        suaSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/form-edit_1.png"))); // NOI18N
        suaSanPham.setText("Sửa Sản Phẩm");
        suaSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suaSanPhamActionPerformed(evt);
            }
        });

        xoaSanPham.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        xoaSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/icon xóa.png"))); // NOI18N
        xoaSanPham.setText("Xóa Sản Phẩm");
        xoaSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoaSanPhamActionPerformed(evt);
            }
        });

        timKiemSP.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        timKiemSP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/icon tìm kiếm.png"))); // NOI18N
        timKiemSP.setText("Tìm Kiếm");
        timKiemSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timKiemSPActionPerformed(evt);
            }
        });

        LamMoiSP.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        LamMoiSP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/icon refresh.png"))); // NOI18N
        LamMoiSP.setText("Làm Mới");
        LamMoiSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LamMoiSPActionPerformed(evt);
            }
        });

        capnhatSP.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        capnhatSP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/icon cập nhật.png"))); // NOI18N
        capnhatSP.setText("Cập Nhật");
        capnhatSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                capnhatSPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(233, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(themSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(timKiemSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(484, 484, 484)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfNSX, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfHSD, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(138, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 152, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(suaSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LamMoiSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(146, 146, 146)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(xoaSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(capnhatSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(299, 299, 299))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbNhomSP, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(tfTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5))
                        .addGap(108, 108, 108)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tfGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(55, 55, 55)
                                .addComponent(tfGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(tfGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(tfNSX, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(tfHSD, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbNhomSP, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(themSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(suaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xoaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(capnhatSP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LamMoiSP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timKiemSP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        jTabbedPane1.addTab("Quản Lý sản phẩm", jPanel2);

        jPanel7.setBackground(new java.awt.Color(153, 204, 255));
        jPanel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        buttonGroup7.add(rdHoaDonNhap);
        rdHoaDonNhap.setText("Hóa Đơn Nhập");
        rdHoaDonNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdHoaDonNhapActionPerformed(evt);
            }
        });

        buttonGroup7.add(rdHoaDonXuat);
        rdHoaDonXuat.setText("Hóa Đơn Xuất");

        buttonGroup7.add(rdHoaDonBanHang);
        rdHoaDonBanHang.setText("Hóa Đơn Bán Hàng");

        buttonGroup6.add(rdNgay);
        rdNgay.setText("Theo Ngày:");
        rdNgay.setPreferredSize(new java.awt.Dimension(87, 23));

        buttonGroup6.add(rdThang);
        rdThang.setText("Theo Tháng:");

        buttonGroup6.add(rdKhoangThoiGian);
        rdKhoangThoiGian.setText("Từ ngày :");
        rdKhoangThoiGian.setPreferredSize(new java.awt.Dimension(87, 23));

        tfTuNgay.setText(" ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("đến ngày:");

        tblThongKeHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã Hóa Đơn", "Ngày Tạo", "Tổng Tiền"
            }
        ));
        tblThongKeHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblThongKeHoaDonMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tblThongKeHoaDon);
        if (tblThongKeHoaDon.getColumnModel().getColumnCount() > 0) {
            tblThongKeHoaDon.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/icon thống kê.png"))); // NOI18N
        jLabel37.setText("  Thống Kê Hóa Đơn");

        thongKeHoaDon.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        thongKeHoaDon.setText("Thống Kê");
        thongKeHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thongKeHoaDonActionPerformed(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("Chọn Loại Hóa Đơn");

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("Hình Thức Thống Kê");

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/icon xiền.png"))); // NOI18N
        jLabel45.setText("  Tổng Tiền");

        lbTongTien3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbTongTien3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTongTien3.setText("0.0");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(thongKeHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(154, 154, 154)
                        .addComponent(jLabel45)
                        .addGap(18, 18, 18)
                        .addComponent(lbTongTien3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(137, 137, 137))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(rdHoaDonNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(209, 209, 209))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(rdThang, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(tfThang, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(rdKhoangThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(tfTuNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tfDenNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                                                .addComponent(rdNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(tfNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGap(122, 122, 122)
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(rdHoaDonBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(rdHoaDonXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(275, 275, 275)
                                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(300, 300, 300))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34))))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(jLabel37))
                .addGap(19, 19, 19)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, Short.MAX_VALUE)
                        .addComponent(rdHoaDonBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(rdHoaDonXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(rdHoaDonNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)
                        .addComponent(jLabel40)
                        .addGap(60, 60, 60)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdThang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfThang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdKhoangThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfTuNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfDenNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(174, 174, 174))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(thongKeHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel45)
                            .addComponent(lbTongTien3))
                        .addGap(61, 61, 61))))
        );

        jTabbedPane1.addTab("Thống Kê", jPanel7);

        dangxuat.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        dangxuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/icon đăng xuất.png"))); // NOI18N
        dangxuat.setText("Đăng Xuất");
        dangxuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dangxuatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dangxuat)
                        .addGap(130, 130, 130))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(dangxuat))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbNhomSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNhomSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbNhomSPActionPerformed

    private void tfNSXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNSXActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNSXActionPerformed

    private void themSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themSanPhamActionPerformed
        String maSP1 = tfMaSP.getText();
        String tenSP = tfTenSP.getText();
        String nhomSP = cbNhomSP.getSelectedItem().toString();
        String giaNhap1 = tfGiaNhap.getText();
        String giaBan1 = tfGiaBan.getText();
        String ngaySX1 = tfNSX.getText();
        String hanSD1 = tfHSD.getText();
        
        boolean ok = true;
        if (maSP1.length() == 0 || tenSP.length() == 0
                || giaNhap1.length() == 0 || giaBan1.length() == 0
                || ngaySX1.length() == 0 || hanSD1.length() == 0) {
            JOptionPane.showInternalMessageDialog(null, "Các trường không được để trống");
            ok = false;
        } else if (!maSP1.matches("\\d+")) {
            JOptionPane.showInternalMessageDialog(null, "Mã sản phẩm phải là số");
            ok = false;
        } else if (!giaNhap1.matches("\\d+")) {
            JOptionPane.showInternalMessageDialog(null, "Giá nhập phải là số");
            ok = false;
        } else if (!giaBan1.matches("\\d+")) {
            JOptionPane.showInternalMessageDialog(null, "Giá bán phải là số");
            ok = false;
        }

        String pattern = "dd/MM/yyyy";
        Date ngaySX = null;
        Date hanSD = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
            ngaySX = dateFormat.parse(ngaySX1);
            hanSD = dateFormat.parse(hanSD1);
        } catch (ParseException ex) {
            JOptionPane.showInternalMessageDialog(null, "Ngày phải có định dang dd/mm/yyyy");
            ok = false;
        }

        if (ok == true) {
            int maSP = Integer.parseInt(maSP1);
            float giaNhap = Float.parseFloat(giaNhap1);
            float giaBan = Float.parseFloat(giaBan1);
            SanPham sp = new SanPham(maSP, tenSP, nhomSP, giaNhap, giaBan, ngaySX, hanSD);
            if (new DAO().addSanPham(sp)) {
                JOptionPane.showMessageDialog(rootPane, "Sản phẩm đã được thêm mới");
                String sql = "SELECT * FROM tblsanpham";
                listSP = new DAO().getListSanPham(sql);
                showData(listSP, modelSP);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Sản phẩm đã tồn tại hoặc xảy ra lỗi");
            }
        }
    }//GEN-LAST:event_themSanPhamActionPerformed

    private void tfSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSDTActionPerformed

    private void cbVitriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbVitriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbVitriActionPerformed

    private void themNhanvienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themNhanvienActionPerformed
        String idNv1 = tfIdNv.getText();
        String hoten = tfHovaTen.getText();
        String diachi = tfDiachi.getText();
        String ngaysinh1 = tfNgaySinh.getText();
        String taikhoan = tfTaiKhoan.getText();
        String matkhau = tfMatKhau.getText();
        String sdt1 = tfSDT.getText();
        String vitri = cbVitri.getSelectedItem().toString();

        boolean ok = true;
        if (idNv1.length() == 0 || hoten.length() == 0 || diachi.length() == 0
                || ngaysinh1.length() == 0 || taikhoan.length() == 0
                || matkhau.length() == 0 || sdt1.length() == 0) {
            JOptionPane.showInternalMessageDialog(null, "Các trường không được để trống");
            ok = false;
        } else if (!idNv1.matches("\\d+")) {
            JOptionPane.showInternalMessageDialog(null, "CMT phải là số");
            ok = false;
        } else if (!sdt1.matches("\\d+")) {
            JOptionPane.showInternalMessageDialog(null, "Số điện thoại phải là số");
            ok = false;
        }

        String pattern = "dd/MM/yyyy";
        Date ngaysinh = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
            ngaysinh = dateFormat.parse(ngaysinh1);
        } catch (ParseException ex) {
            JOptionPane.showInternalMessageDialog(null, "Ngày sinh phải có định dang dd/mm/yyyy");
            ok = false;
        }

        if (ok == true) {
            int sdt = Integer.parseInt(sdt1);
            int idNv = Integer.parseInt(idNv1);
            NhanVien nv = new NhanVien(idNv, hoten, diachi, ngaysinh, taikhoan, matkhau, sdt, vitri);
            if (new DAO().addNhanVien(nv)) {
                JOptionPane.showMessageDialog(rootPane, "Đã thêm mới nhân viên");
                String sql = "SELECT * FROM tblnhanvien";
                listNV = new DAO().getListNhanVien(sql);
                showData(listNV, modelNV);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Nhân viên hoặc tài khoản đã tồn tại");
            }
        }
    }//GEN-LAST:event_themNhanvienActionPerformed

    private void LamMoiSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LamMoiSPActionPerformed
        tfMaSP.setText("");
        tfTenSP.setText("");
        tfGiaNhap.setText("");
        tfGiaBan.setText("");
        tfNSX.setText("");
        tfHSD.setText("");

    }//GEN-LAST:event_LamMoiSPActionPerformed

    private void suaSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suaSanPhamActionPerformed
        String maSP1 = tfMaSP.getText();
        String tenSP = tfTenSP.getText();
        String nhomSP = cbNhomSP.getSelectedItem().toString();
        String giaNhap1 = tfGiaNhap.getText();
        String giaBan1 = tfGiaBan.getText();
        String ngaySX1 = tfNSX.getText();
        String hanSD1 = tfHSD.getText();

        boolean ok = true;
        if (maSP1.length() == 0 || tenSP.length() == 0
                || giaNhap1.length() == 0 || giaBan1.length() == 0
                || ngaySX1.length() == 0 || hanSD1.length() == 0) {
            JOptionPane.showInternalMessageDialog(null, "Các trường không được để trống");
            ok = false;
        } else if (!maSP1.matches("\\d+")) {
            JOptionPane.showInternalMessageDialog(null, "Mã sản phẩm phải là số");
            ok = false;
        } else if (!giaNhap1.matches("\\d+")) {
            JOptionPane.showInternalMessageDialog(null, "Giá nhập phải là số");
            ok = false;
        } else if (!giaBan1.matches("\\d+")) {
            JOptionPane.showInternalMessageDialog(null, "Giá bán phải là số");
            ok = false;
        }

        String pattern = "dd/MM/yyyy";
        Date ngaySX = null;
        Date hanSD = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
            ngaySX = dateFormat.parse(ngaySX1);
            hanSD = dateFormat.parse(hanSD1);
        } catch (ParseException ex) {
            JOptionPane.showInternalMessageDialog(null, "Ngày phải có định dang dd/mm/yyyy");
            ok = false;
        }

        if (ok == true) {
            int maSP = Integer.parseInt(maSP1);
            float giaNhap = Float.parseFloat(giaNhap1);
            float giaBan = Float.parseFloat(giaBan1);
            SanPham sp = new SanPham(maSP, tenSP, nhomSP, giaNhap, giaBan, ngaySX, hanSD);
            if (new DAO().suaSanPham(sp)) {
                JOptionPane.showMessageDialog(rootPane, "Sản phẩm đã được cập nhật");
                listSP = new DAO().getListSanPham("SELECT * FROM tblsanpham");
                showData(listSP, modelSP);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Sản phẩm chưa được cập nhật");
            }
        }
    }//GEN-LAST:event_suaSanPhamActionPerformed

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        int selectRow = tblSanPham.getSelectedRow();
        hienthiSP(selectRow, "tabqlsp");

    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void lammoiNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lammoiNVActionPerformed
        tfIdNv.setText("");
        tfHovaTen.setText("");
        tfDiachi.setText("");
        tfNgaySinh.setText("");
        tfSDT.setText("");
        tfTaiKhoan.setText("");
        tfMatKhau.setText("");

    }//GEN-LAST:event_lammoiNVActionPerformed

    private void suaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suaNVActionPerformed
        String idNv1 = tfIdNv.getText();
        String hoten = tfHovaTen.getText();
        String diachi = tfDiachi.getText();
        String ngaysinh1 = tfNgaySinh.getText();
        String taikhoan = tfTaiKhoan.getText();
        String matkhau = tfMatKhau.getText();
        String sdt1 = tfSDT.getText();
        String vitri = cbVitri.getSelectedItem().toString();

        boolean ok = true;
        if (idNv1.length() == 0 || hoten.length() == 0 || diachi.length() == 0
                || ngaysinh1.length() == 0 || taikhoan.length() == 0
                || matkhau.length() == 0 || sdt1.length() == 0) {
            JOptionPane.showInternalMessageDialog(null, "Các trường không được để trống");
            ok = false;
        } else if (!idNv1.matches("\\d+")) {
            JOptionPane.showInternalMessageDialog(null, "CMT phải là số");
            ok = false;
        } else if (!sdt1.matches("\\d+")) {
            JOptionPane.showInternalMessageDialog(null, "Số điện thoại phải là số");
            ok = false;
        }

        String pattern = "dd/MM/yyyy";
        Date ngaysinh = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
            ngaysinh = dateFormat.parse(ngaysinh1);
        } catch (ParseException ex) {
            JOptionPane.showInternalMessageDialog(null, "Ngày sinh phải có định dang dd/mm/yyyy");
            ok = false;
        }

        if (ok == true) {
            int sdt = Integer.parseInt(sdt1);
            int idNv = Integer.parseInt(idNv1);
            NhanVien nv = new NhanVien(idNv, hoten, diachi, ngaysinh, taikhoan, matkhau, sdt, vitri);
            if (new DAO().suaNhanVien(nv)) {
                JOptionPane.showMessageDialog(rootPane, "Nhân viên đã được sửa thông tin");
                listNV = new DAO().getListNhanVien("SELECT * FROM tblnhanvien");
                showData(listNV, modelNV);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Nhân viên chưa được sửa thông tin");
            }
        }
    }//GEN-LAST:event_suaNVActionPerformed

    private void tblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMouseClicked
        int selectRow = tblNhanVien.getSelectedRow();
        hienthiNhanVien(selectRow);
    }//GEN-LAST:event_tblNhanVienMouseClicked

    private void xoaSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xoaSanPhamActionPerformed
        int msp = Integer.parseInt(tfMaSP.getText());
        if (new DAO().xoaSanPham(msp)) {
            JOptionPane.showMessageDialog(rootPane, "Sản phẩm đã được xóa thành công");
            LamMoiSPActionPerformed(evt);
            listSP.remove(tblSanPham.getSelectedRow());
            showData(listSP, modelSP);

        } else {
            JOptionPane.showMessageDialog(rootPane, "Sản phẩm chưa được xóa");
        }
    }//GEN-LAST:event_xoaSanPhamActionPerformed

    private void capnhatSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_capnhatSPActionPerformed
        String sql = "SELECT * FROM tblsanpham";
        listSP = new DAO().getListSanPham(sql);
        showData(listSP, modelSP);
    }//GEN-LAST:event_capnhatSPActionPerformed

    private void xoaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xoaNVActionPerformed
        int idnv = Integer.parseInt(tfIdNv.getText());
        if (new DAO().xoaNhanVien(idnv)) {
            JOptionPane.showMessageDialog(rootPane, "Nhân Viên đã được xóa thành công");
            lammoiNVActionPerformed(evt);
            listNV.remove(tblNhanVien.getSelectedRow());
            showData(listNV, modelNV);

        } else {
            JOptionPane.showMessageDialog(rootPane, "Nhân Viên chưa được xóa");
        }
    }//GEN-LAST:event_xoaNVActionPerformed

    private void capnhatNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_capnhatNVActionPerformed
        String sql = "SELECT * FROM tblnhanvien";
        listNV = new DAO().getListNhanVien(sql);
        showData(listNV, modelNV);

    }//GEN-LAST:event_capnhatNVActionPerformed

    private void timKiemSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timKiemSPActionPerformed
        if (tfMaSP.getText().length() != 0) {
            String sql = "SELECT * FROM tblsanpham WHERE maSP LIKE '%" + tfMaSP.getText() + "%'";
            listSP = new DAO().getListSanPham(sql);
            showData(listSP, modelSP);
        } else if (tfTenSP.getText().length() != 0) {
            String sql = "SELECT * FROM tblsanpham WHERE tenSP LIKE '%" + tfTenSP.getText() + "%'";
            listSP = new DAO().getListSanPham(sql);
            showData(listSP, modelSP);
        } else if (tfGiaNhap.getText().length() != 0) {
            String sql = "SELECT * FROM tblsanpham WHERE gianhap LIKE '%" + tfGiaNhap.getText() + "%'";
            listSP = new DAO().getListSanPham(sql);
            showData(listSP, modelSP);
        } else if (tfGiaBan.getText().length() != 0) {
            String sql = "SELECT * FROM tblsanpham WHERE giaban LIKE '%" + tfGiaBan.getText() + "%'";
            listSP = new DAO().getListSanPham(sql);
            showData(listSP, modelSP);
        } else if (tfNSX.getText().length() != 0) {
            String sql = "SELECT * FROM tblsanpham WHERE ngaySX LIKE '%" + tfNSX.getText() + "%'";
            listSP = new DAO().getListSanPham(sql);
            showData(listSP, modelSP);
        } else if (tfHSD.getText().length() != 0) {
            String sql = "SELECT * FROM tblsanpham WHERE hanSD LIKE '%" + tfHSD.getText() + "%'";
            listSP = new DAO().getListSanPham(sql);
            showData(listSP, modelSP);
        } else {
            String sql = "SELECT * FROM tblsanpham WHERE nhomSP LIKE '%" + cbNhomSP.getSelectedItem().toString() + "%'";
            listSP = new DAO().getListSanPham(sql);
            showData(listSP, modelSP);
        }
    }//GEN-LAST:event_timKiemSPActionPerformed

    private void timkiemNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timkiemNVActionPerformed
        if (tfIdNv.getText().length() != 0) {
            String sql = "SELECT * FROM tblnhanvien WHERE idNv LIKE '%" + tfIdNv.getText() + "%'";
            listNV = new DAO().getListNhanVien(sql);
            showData(listNV, modelNV);
        } else if (tfHovaTen.getText().length() != 0) {
            String sql = "SELECT * FROM tblnhanvien WHERE hovaten LIKE '%" + tfHovaTen.getText() + "%'";
            listNV = new DAO().getListNhanVien(sql);
            showData(listNV, modelNV);
        } else if (tfDiachi.getText().length() != 0) {
            String sql = "SELECT * FROM tblnhanvien WHERE diachi LIKE '%" + tfDiachi.getText() + "%'";
            listNV = new DAO().getListNhanVien(sql);
            showData(listNV, modelNV);
        } else if (tfNgaySinh.getText().length() != 0) {
            String sql = "SELECT * FROM tblnhanvien WHERE ngaysinh LIKE '%" + tfNgaySinh.getText() + "%'";
            listNV = new DAO().getListNhanVien(sql);
            showData(listNV, modelNV);
        } else if (tfSDT.getText().length() != 0) {
            String sdt = "";
            if ("0".equals(tfSDT.getText().substring(0, 1))) { 
                sdt = tfSDT.getText().substring(1); 
            } else {
                sdt = tfSDT.getText();
            }
            String sql = "SELECT * FROM tblnhanvien WHERE sdt LIKE '%" + sdt + "%'";
            listNV = new DAO().getListNhanVien(sql);
            showData(listNV, modelNV);
        } else if (tfTaiKhoan.getText().length() != 0) {
            String sql = "SELECT * FROM tblnhanvien WHERE taikhoan LIKE '%" + tfTaiKhoan.getText() + "%'";
            listNV = new DAO().getListNhanVien(sql);
            showData(listNV, modelNV);
        } else if (tfMatKhau.getText().length() != 0) {
            String sql = "SELECT * FROM tblnhanvien WHERE matkhau LIKE '%" + tfMatKhau.getText() + "%'";
            listNV = new DAO().getListNhanVien(sql);
            showData(listNV, modelNV);
        } else {
            String sql = "SELECT * FROM tblnhanvien WHERE vitri LIKE '%" + cbVitri.getSelectedItem().toString() + "%'";
            listNV = new DAO().getListNhanVien(sql);
            showData(listNV, modelNV);
        }
    }//GEN-LAST:event_timkiemNVActionPerformed

    private void timKiemSP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timKiemSP2ActionPerformed
        if (tfMaSP2.getText().length() != 0) {
            String sql = "SELECT * FROM tblsanpham WHERE maSP LIKE '%" + tfMaSP2.getText() + "%'";
            listSP2 = new DAO().getListSanPham(sql);
            showData(listSP2, modelSP2);
        } else if (tfTenSP2.getText().length() != 0) {
            String sql = "SELECT * FROM tblsanpham WHERE tenSP LIKE '%" + tfTenSP2.getText() + "%'";
            listSP2 = new DAO().getListSanPham(sql);
            showData(listSP2, modelSP2);
        } else if (tfGiaNhap2.getText().length() != 0) {
            String sql = "SELECT * FROM tblsanpham WHERE gianhap LIKE '%" + tfGiaNhap2.getText() + "%'";
            listSP2 = new DAO().getListSanPham(sql);
            showData(listSP1, modelSP2);
        } else if (tfGiaBan2.getText().length() != 0) {
            String sql = "SELECT * FROM tblsanpham WHERE giaban LIKE '%" + tfGiaBan2.getText() + "%'";
            listSP2 = new DAO().getListSanPham(sql);
            showData(listSP2, modelSP2);
        } else if (tfNSX2.getText().length() != 0) {
            String sql = "SELECT * FROM tblsanpham WHERE ngaySX LIKE '%" + tfNSX2.getText() + "%'";
            listSP2 = new DAO().getListSanPham(sql);
            showData(listSP2, modelSP2);
        } else if (tfNHH2.getText().length() != 0) {
            String sql = "SELECT * FROM tblsanpham WHERE hanSD LIKE '%" + tfNHH2.getText() + "%'";
            listSP2 = new DAO().getListSanPham(sql);
            showData(listSP2, modelSP2);
        } else {
            String sql = "SELECT * FROM tblsanpham WHERE nhomSP LIKE '%" + cbNhomSP2.getSelectedItem().toString() + "%'";
            listSP2 = new DAO().getListSanPham(sql);
            showData(listSP2, modelSP2);
        }
    }//GEN-LAST:event_timKiemSP2ActionPerformed

    private void LamMoiSP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LamMoiSP2ActionPerformed
        tfMaSP2.setText("");
        tfTenSP2.setText("");
        tfGiaNhap2.setText("");
        tfGiaBan2.setText("");
        tfNSX2.setText("");
        tfNHH2.setText("");
    }//GEN-LAST:event_LamMoiSP2ActionPerformed

    private void capnhatSP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_capnhatSP2ActionPerformed
        String sql = "SELECT * FROM tblsanpham";
        listSP2 = new DAO().getListSanPham(sql);
        showData(listSP2, modelSP2);
    }//GEN-LAST:event_capnhatSP2ActionPerformed

    private void tblSanPham2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPham2MouseClicked
        int selectRow = tblSanPham2.getSelectedRow();
        hienthiSP(selectRow, "tabbanhang1");
    }//GEN-LAST:event_tblSanPham2MouseClicked

    private void capnhatSP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_capnhatSP1ActionPerformed
        String sql = "SELECT * FROM tblsanpham";
        listSP1 = new DAO().getListSanPham(sql);
        showData(listSP1, modelSP1);
    }//GEN-LAST:event_capnhatSP1ActionPerformed

    private void LamMoiSP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LamMoiSP1ActionPerformed
        tfMaSP1.setText("");
        tfTenSP1.setText("");
        tfGiaNhap1.setText("");
        tfGiaBan1.setText("");
        tfNSX1.setText("");
        tfNHH1.setText("");
    }//GEN-LAST:event_LamMoiSP1ActionPerformed

    private void timKiemSP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timKiemSP1ActionPerformed
        if (tfMaSP1.getText().length() != 0) {
            String sql = "SELECT * FROM tblsanpham WHERE maSP LIKE '%" + tfMaSP1.getText() + "%'";
            listSP1 = new DAO().getListSanPham(sql);
            showData(listSP1, modelSP1);
        } else if (tfTenSP1.getText().length() != 0) {
            String sql = "SELECT * FROM tblsanpham WHERE tenSP LIKE '%" + tfTenSP1.getText() + "%'";
            listSP1 = new DAO().getListSanPham(sql);
            showData(listSP1, modelSP1);
        } else if (tfGiaNhap1.getText().length() != 0) {
            String sql = "SELECT * FROM tblsanpham WHERE gianhap LIKE '%" + tfGiaNhap1.getText() + "%'";
            listSP1 = new DAO().getListSanPham(sql);
            showData(listSP1, modelSP1);
        } else if (tfGiaBan1.getText().length() != 0) {
            String sql = "SELECT * FROM tblsanpham WHERE giaban LIKE '%" + tfGiaBan1.getText() + "%'";
            listSP1 = new DAO().getListSanPham(sql);
            showData(listSP1, modelSP1);
        } else if (tfNSX1.getText().length() != 0) {
            String sql = "SELECT * FROM tblsanpham WHERE ngaySX LIKE '%" + tfNSX1.getText() + "%'";
            listSP1 = new DAO().getListSanPham(sql);
            showData(listSP1, modelSP1);
        } else if (tfNHH1.getText().length() != 0) {
            String sql = "SELECT * FROM tblsanpham WHERE hanSD LIKE '%" + tfNHH1.getText() + "%'";
            listSP1 = new DAO().getListSanPham(sql);
            showData(listSP1, modelSP1);
        } else {
            String sql = "SELECT * FROM tblsanpham WHERE nhomSP LIKE '%" + cbNhomSP1.getSelectedItem().toString() + "%'";
            listSP1 = new DAO().getListSanPham(sql);
            showData(listSP1, modelSP1);
        }
    }//GEN-LAST:event_timKiemSP1ActionPerformed

    private void tblSanPham1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPham1MouseClicked
        int selectRow = tblSanPham1.getSelectedRow();
        hienthiSP(selectRow, "tabqlkho1");
    }//GEN-LAST:event_tblSanPham1MouseClicked

    private void nhapMaSP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nhapMaSP1ActionPerformed
        if (rdXuatHang.isSelected()) {
            float tongtien = Float.parseFloat(lbTongTien1.getText());
            String masp = tfMaSPKho.getText();
            int slsql = 0;
            String sql = "SELECT * FROM tblsanpham WHERE maSP = " + tfMaSP1.getText();
            listSP = new DAO().getListSanPham(sql);
            for (SanPham sp : listSP) {
                slsql = sp.getMaSP();
            }
            if (masp.length() == 0) {
                JOptionPane.showMessageDialog(rootPane, "Số lượng không được để trống");
            } else if (!tfMaSPKho.getText().matches("\\d+")) {
                JOptionPane.showMessageDialog(rootPane, "Số lượng phải là số");
            } else if (slsql < Integer.parseInt(masp)) {
                JOptionPane.showMessageDialog(rootPane, "Số lượng trong kho không đủ để xuất");
            } else if (slsql >= Integer.parseInt(masp)) {
                for (SanPham sp : listSP) {
                    ChiTietHoaDon cthd = new ChiTietHoaDon();
                    cthd.setMaSP(sp.getMaSP());
                    cthd.setTenSP(sp.getTenSP());
                    cthd.setThanhtien(sp.getGiaBan());

                    tongtien += cthd.getThanhtien();
                    lbTongTien1.setText(String.valueOf(tongtien));
                    listNhapXuat.add(cthd);
                    showData(listNhapXuat, modelNhapXuat);
                }
            }
            tfMaSPKho.setText("");
        } 
        else if (rdNhapHang.isSelected()) {
            float tongtien = Float.parseFloat(lbTongTien1.getText());
            String soluong = tfMaSPKho.getText();
            String sql = "SELECT * FROM tblsanpham WHERE maSP = " + tfMaSP1.getText();
            listSP = new DAO().getListSanPham(sql);
            if (soluong.length() == 0) {
                JOptionPane.showMessageDialog(rootPane, "Số lượng không được để trống");
            } else if (!tfMaSPKho.getText().matches("\\d+")) {
                JOptionPane.showMessageDialog(rootPane, "Số lượng phải là số");
            } else {
                for (SanPham sp : listSP) {
                    ChiTietHoaDon cthd = new ChiTietHoaDon();
                    cthd.setMaSP(sp.getMaSP());
                    cthd.setTenSP(sp.getTenSP());
                    cthd.setThanhtien(sp.getGiaBan());

                    tongtien += cthd.getThanhtien();
                    lbTongTien1.setText(String.valueOf(tongtien));
                    listNhapXuat.add(cthd);
                    showData(listNhapXuat, modelNhapXuat);
                }
            }
            tfMaSPKho.setText("");
        } else {
            JOptionPane.showMessageDialog(rootPane, "Bạn phải chọn loại hóa đơn trước khi nhập số lượng");
        }

    }//GEN-LAST:event_nhapMaSP1ActionPerformed

    private void luuPhieu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_luuPhieu1ActionPerformed
        if (rdNhapHang.isSelected()) {
            if (listNhapXuat.isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Hóa đơn đang trống bạn cần thêm sản phẩm !!!");
            } else {
                HoaDon hd = new HoaDon();
                String mahdcuoi = new DAO().getObject("SELECT MAX(maHD) FROM tblnhaphang").toString();
                hd.setMaHD(Integer.parseInt(mahdcuoi) + 1);
                hd.setNgaytaoHD(new java.sql.Date(System.currentTimeMillis()));

                float tongtien = 0;
                int maCTHD = 1;
                for (ChiTietHoaDon cthd : listNhapXuat) {
                    int slsql = 0;
                    float gianhap = 0;

                    int msp = cthd.getMaSP();
                    String sql = "SELECT * FROM tblsanpham WHERE maSP = " + msp;
                    listSP = new DAO().getListSanPham(sql);
                    for (SanPham sp : listSP) {
                        slsql = sp.getMaSP();
                        gianhap = sp.getGiaNhap();
                    }
                    cthd.setMaCTHD(maCTHD);
                    cthd.setMaHD(hd.getMaHD());
                    new DAO().themchitiethoaDon(cthd, "INSERT INTO tblchitietnhaphang(machitietHD, maHD, maSP, tenSP, thanhtien) VALUES(?,?,?,?,?)");

                    tongtien += gianhap;
                    maCTHD++;
                }

                hd.setTongtien(tongtien);

                if (new DAO().themhoaDon(hd, "INSERT INTO tblnhaphang(maHD, ngaytao, tongtien) VALUES(?,?,?)")) {
                    JOptionPane.showMessageDialog(rootPane, "Lưu thành công hóa đơn nhập hàng");
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Thất bại");
                }
            }
        } 
        else if (rdXuatHang.isSelected()) {
            if (listBanHang.isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Hóa đơn đang trống bạn cần thêm sản phẩm !!!");
            } else {
                HoaDon hd = new HoaDon();
                String mahdcuoi = new DAO().getObject("SELECT MAX(maHD) FROM tblxuatkho").toString();
                hd.setMaHD(Integer.parseInt(mahdcuoi) + 1);
                hd.setNgaytaoHD(new java.sql.Date(System.currentTimeMillis()));

                float tongtien = 0;
                int maCTHD = 1;
                for (ChiTietHoaDon cthd : listNhapXuat) {
                    int slsql = 0;
                    float gianhap = 0;

                    int msp = cthd.getMaSP();
                    String sql = "SELECT * FROM tblsanpham WHERE maSP = " + msp;
                    listSP = new DAO().getListSanPham(sql);
                    for (SanPham sp : listSP) {
                        slsql = sp.getMaSP();
                        gianhap = sp.getGiaNhap();
                    }
                    cthd.setMaCTHD(maCTHD);
                    cthd.setMaHD(hd.getMaHD());
                    new DAO().themchitiethoaDon(cthd, "INSERT INTO tblchitietxuatkho(machitietHD, maHD, maSP, tenSP, thanhtien) VALUES(?,?,?,?,?)");

                    tongtien += gianhap;
                    maCTHD++;
                }

                hd.setTongtien(tongtien);

                if (new DAO().themhoaDon(hd, "INSERT INTO tblxuatkho(maHD, ngaytao, tongtien) VALUES(?,?,?)")) {
                    JOptionPane.showMessageDialog(rootPane, "Lưu thành công hóa đơn xuất kho");
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Thất bại");
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Bạn phải chọn loại hóa đơn trước !!!");
        }
    }//GEN-LAST:event_luuPhieu1ActionPerformed

    private void tblNhapXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhapXuatMouseClicked
        int selectRow = tblNhapXuat.getSelectedRow();

        hienthiSP(selectRow, "tabqlkho2");
    }//GEN-LAST:event_tblNhapXuatMouseClicked

    private void xoaPhieu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xoaPhieu1ActionPerformed
        listNhapXuat.remove(tblNhapXuat.getSelectedRow());
        showData(listNhapXuat, modelNhapXuat);
    }//GEN-LAST:event_xoaPhieu1ActionPerformed

    private void tblBanHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBanHangMouseClicked
        int selectRow = tblBanHang.getSelectedRow();

        hienthiSP(selectRow, "tabbanhang2");
    }//GEN-LAST:event_tblBanHangMouseClicked

    private void taoMoiHD1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taoMoiHD1ActionPerformed
        listNhapXuat = new ArrayList<>();
        showData(listNhapXuat, modelNhapXuat);
        lbTongTien1.setText("0.0");
    }//GEN-LAST:event_taoMoiHD1ActionPerformed

    private void taoMoiHD2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taoMoiHD2ActionPerformed
        listBanHang = new ArrayList<>();
        showData(listBanHang, modelBanHang);
        lbTongTien2.setText("0.0");
    }//GEN-LAST:event_taoMoiHD2ActionPerformed

    private void nhapMaSP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nhapMaSP2ActionPerformed
        float tongtien = Float.parseFloat(lbTongTien2.getText());
        String masp = tfNhapSoLuong2.getText();
        int slsql = 0;
        String sql = "SELECT * FROM tblsanpham WHERE maSP = " + tfMaSP2.getText();
        listSP = new DAO().getListSanPham(sql);
        for (SanPham sp : listSP) {
            slsql = sp.getMaSP();
        }
        if (masp.length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Mã sản phẩm không được để trống");
        } else if (!tfNhapSoLuong2.getText().matches("\\d+")) {
            JOptionPane.showMessageDialog(rootPane, "Mã sản phẩm phải là số");
        } else if (slsql < Integer.parseInt(masp)) {
            JOptionPane.showMessageDialog(rootPane, "Mã sản phẩm không có để bán");
        } else if (slsql >= Integer.parseInt(masp)) {
            for (SanPham sp : listSP) {
                ChiTietHoaDon cthd = new ChiTietHoaDon();
                cthd.setMaSP(sp.getMaSP());
                cthd.setTenSP(sp.getTenSP());
                cthd.setThanhtien(sp.getGiaBan());

                tongtien += cthd.getThanhtien();
                lbTongTien2.setText(String.valueOf(tongtien));
                listBanHang.add(cthd);
                showData(listBanHang, modelBanHang);
            }
        }
        tfNhapSoLuong2.setText("");
    }//GEN-LAST:event_nhapMaSP2ActionPerformed

    private void xoaPhieu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xoaPhieu2ActionPerformed
        listBanHang.remove(tblBanHang.getSelectedRow());
        showData(listBanHang, modelBanHang);
    }//GEN-LAST:event_xoaPhieu2ActionPerformed

    private void luuPhieu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_luuPhieu2ActionPerformed
        if (listBanHang.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Hóa đơn đang trống bạn cần thêm sản phẩm !!!");
        } else {
            HoaDon hd = new HoaDon();
            String mahdcuoi = new DAO().getObject("SELECT MAX(maHD) FROM tblhoadon").toString();
            hd.setMaHD(Integer.parseInt(mahdcuoi) + 1);
            hd.setNgaytaoHD(new java.sql.Date(System.currentTimeMillis()));

            float tongtien = 0;
            int maCTHD = 1;
            for (ChiTietHoaDon cthd : listBanHang) {
                int slsql = 0;
                float giaban = 0;

                int msp = cthd.getMaSP();
                String sql = "SELECT * FROM tblsanpham WHERE maSP = " + msp;
                listSP = new DAO().getListSanPham(sql);
                for (SanPham sp : listSP) {
                    slsql = sp.getMaSP();
                    giaban = sp.getGiaBan();
                }
                cthd.setMaCTHD(maCTHD);
                cthd.setMaHD(hd.getMaHD());
                new DAO().themchitiethoaDon(cthd, "INSERT INTO tblchitiethoadon(machitietHD, maHD, maSP, tenSP, thanhtien) VALUES(?,?,?,?,?)");

                tongtien += giaban;
                maCTHD++;
            }

            hd.setTongtien(tongtien);

            if (new DAO().themhoaDon(hd, "INSERT INTO tblhoadon(maHD, ngaytao, tongtien) VALUES(?,?,?)")) {
                JOptionPane.showMessageDialog(rootPane, "Lưu hóa đơn bán hàng thành công");
            } else {
                JOptionPane.showMessageDialog(rootPane, "Thất bại");
            }
        }
    }//GEN-LAST:event_luuPhieu2ActionPerformed

    private void thongKeHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thongKeHoaDonActionPerformed
        if (rdHoaDonNhap.isSelected()) {
            if (rdNgay.isSelected()) {
                String ngay = tfNgay.getText();
                boolean ok = true;
                if (ngay.length() == 0) {
                    JOptionPane.showMessageDialog(rootPane, "Bạn phải nhập ngày muốn tìm kiếm");
                    ok = false;
                }
                String pattern = "dd/MM/yyyy";
                Date ngay1 = null;
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
                    ngay1 = dateFormat.parse(ngay);
                } catch (ParseException ex) {
                    JOptionPane.showInternalMessageDialog(null, "Ngày phải có định dang dd/MM/yyyy");
                    ok = false;
                }
                if (ok == true) {
                    String arrngay[] = ngay.split("/");
                    ngay = arrngay[2] + "-" + arrngay[1] + "-" + arrngay[0];
                    String sql = "SELECT * FROM tblnhaphang WHERE ngaytao LIKE '%" + ngay + "%'";
                    listHD = new DAO().getListHoaDon(sql);
                    showData(listHD, modelThongKeHD);
                    float tongtien = 0;
                    for (HoaDon hd : listHD) {
                        tongtien = tongtien + hd.getTongtien();
                    }
                    lbTongTien3.setText(String.valueOf(tongtien));
                }
            } else if (rdThang.isSelected()) {
                String thang = tfThang.getText();
                boolean ok = true;
                if (thang.length() == 0) {
                    JOptionPane.showMessageDialog(rootPane, "Bạn phải nhập tháng muốn tìm kiếm");
                    ok = false;
                }
                String pattern = "MM/yyyy";
                Date thang1 = null;
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
                    thang1 = dateFormat.parse(thang);
                } catch (ParseException ex) {
                    JOptionPane.showInternalMessageDialog(null, "Tháng phải có định dang MM/yyyy");
                    ok = false;
                }
                if (ok == true) {
                    String arrngay[] = thang.split("/");
                    thang = arrngay[1] + "-" + arrngay[0];
                    String sql = "SELECT * FROM tblnhaphang WHERE ngaytao LIKE '%" + thang + "%'";
                    listHD = new DAO().getListHoaDon(sql);
                    showData(listHD, modelThongKeHD);
                    float tongtien = 0;
                    for (HoaDon hd : listHD) {
                        tongtien = tongtien + hd.getTongtien();
                    }
                    lbTongTien3.setText(String.valueOf(tongtien));
                }
            } else if (rdKhoangThoiGian.isSelected()) {
                String tungay = tfTuNgay.getText();
                String denngay = tfDenNgay.getText();
                boolean ok = true;
                if (tungay.length() == 0 || denngay.length() == 0) {
                    JOptionPane.showMessageDialog(rootPane, "Bạn phải nhập ngày muốn tìm kiếm");
                    ok = false;
                }
                String pattern = "dd/MM/yyyy";
                Date tungay1 = null;
                Date denngay1 = null;
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
                    tungay1 = dateFormat.parse(tungay);
                    denngay1 = dateFormat.parse(denngay);
                } catch (ParseException ex) {
                    JOptionPane.showInternalMessageDialog(null, "Ngày phải có định dang MM/yyyy");
                    ok = false;
                }
                if (ok == true) {
                    String arrngay1[] = tungay.split("/");
                    tungay = arrngay1[2] + "-" + arrngay1[1] + "-" + arrngay1[0];
                    String arrngay2[] = denngay.split("/");
                    denngay = arrngay2[2] + "-" + arrngay2[1] + "-" + arrngay2[0];
                    String sql = "SELECT *FROM tblnhaphang Where ngaytao between '" + tungay + "' AND '" + denngay + "'";
                    listHD = new DAO().getListHoaDon(sql);
                    showData(listHD, modelThongKeHD);
                    float tongtien = 0;
                    for (HoaDon hd : listHD) {
                        tongtien = tongtien + hd.getTongtien();
                    }
                    lbTongTien3.setText(String.valueOf(tongtien));
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Bạn phải chọn loại thống kê !!!");
            }
        } 
        else if (rdHoaDonXuat.isSelected()) {
            if (rdNgay.isSelected()) {
                String ngay = tfNgay.getText();
                boolean ok = true;
                if (ngay.length() == 0) {
                    JOptionPane.showMessageDialog(rootPane, "Bạn phải nhập ngày muốn tìm kiếm");
                    ok = false;
                }
                String pattern = "dd/MM/yyyy";
                Date ngay1 = null;
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
                    ngay1 = dateFormat.parse(ngay);
                } catch (ParseException ex) {
                    JOptionPane.showInternalMessageDialog(null, "Ngày phải có định dang dd/MM/yyyy");
                    ok = false;
                }
                if (ok == true) {
                    String arrngay[] = ngay.split("/");
                    ngay = arrngay[2] + "-" + arrngay[1] + "-" + arrngay[0];
                    String sql = "SELECT * FROM tblxuatkho WHERE ngaytao LIKE '%" + ngay + "%'";
                    listHD = new DAO().getListHoaDon(sql);
                    showData(listHD, modelThongKeHD);
                    float tongtien = 0;
                    for (HoaDon hd : listHD) {
                        tongtien = tongtien + hd.getTongtien();
                    }
                    lbTongTien3.setText(String.valueOf(tongtien));
                }
            } else if (rdThang.isSelected()) {
                String thang = tfThang.getText();
                boolean ok = true;
                if (thang.length() == 0) {
                    JOptionPane.showMessageDialog(rootPane, "Bạn phải nhập tháng muốn tìm kiếm");
                    ok = false;
                }
                String pattern = "MM/yyyy";
                Date thang1 = null;
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
                    thang1 = dateFormat.parse(thang);
                } catch (ParseException ex) {
                    JOptionPane.showInternalMessageDialog(null, "Tháng phải có định dang MM/yyyy");
                    ok = false;
                }
                if (ok == true) {
                    String arrngay[] = thang.split("/");
                    thang = arrngay[1] + "-" + arrngay[0];
                    String sql = "SELECT * FROM tblxuatkho WHERE ngaytao LIKE '%" + thang + "%'";
                    listHD = new DAO().getListHoaDon(sql);
                    showData(listHD, modelThongKeHD);
                    float tongtien = 0;
                    for (HoaDon hd : listHD) {
                        tongtien = tongtien + hd.getTongtien();
                    }
                    lbTongTien3.setText(String.valueOf(tongtien));
                }
            } else if (rdKhoangThoiGian.isSelected()) {
                String tungay = tfTuNgay.getText();
                String denngay = tfDenNgay.getText();
                boolean ok = true;
                if (tungay.length() == 0 || denngay.length() == 0) {
                    JOptionPane.showMessageDialog(rootPane, "Bạn phải nhập ngày muốn tìm kiếm");
                    ok = false;
                }
                String pattern = "dd/MM/yyyy";
                Date tungay1 = null;
                Date denngay1 = null;
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
                    tungay1 = dateFormat.parse(tungay);
                    denngay1 = dateFormat.parse(denngay);
                } catch (ParseException ex) {
                    JOptionPane.showInternalMessageDialog(null, "Ngày phải có định dang MM/yyyy");
                    ok = false;
                }
                if (ok == true) {
                    String arrngay1[] = tungay.split("/");
                    tungay = arrngay1[2] + "-" + arrngay1[1] + "-" + arrngay1[0];
                    String arrngay2[] = denngay.split("/");
                    denngay = arrngay2[2] + "-" + arrngay2[1] + "-" + arrngay2[0];
                    String sql = "SELECT *FROM tblxuatkho Where ngaytao between '" + tungay + "' AND '" + denngay + "'";
                    listHD = new DAO().getListHoaDon(sql);
                    showData(listHD, modelThongKeHD);
                    float tongtien = 0;
                    for (HoaDon hd : listHD) {
                        tongtien = tongtien + hd.getTongtien();
                    }
                    lbTongTien3.setText(String.valueOf(tongtien));
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Bạn phải chọn loại thống kê !!!");
            }

        } 
        else if (rdHoaDonBanHang.isSelected()) {
            if (rdNgay.isSelected()) {
                String ngay = tfNgay.getText();
                boolean ok = true;
                if (ngay.length() == 0) {
                    JOptionPane.showMessageDialog(rootPane, "Bạn phải nhập ngày muốn tìm kiếm");
                    ok = false;
                }
                String pattern = "dd/MM/yyyy";
                Date ngay1 = null;
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
                    ngay1 = dateFormat.parse(ngay);
                } catch (ParseException ex) {
                    JOptionPane.showInternalMessageDialog(null, "Ngày phải có định dang dd/MM/yyyy");
                    ok = false;
                }
                if (ok == true) {
                    String arrngay[] = ngay.split("/");
                    ngay = arrngay[2] + "-" + arrngay[1] + "-" + arrngay[0];
                    String sql = "SELECT * FROM tblhoadon WHERE ngaytao LIKE '%" + ngay + "%'";
                    listHD = new DAO().getListHoaDon(sql);
                    showData(listHD, modelThongKeHD);
                    float tongtien = 0;
                    for (HoaDon hd : listHD) {
                        tongtien = tongtien + hd.getTongtien();
                    }
                    lbTongTien3.setText(String.valueOf(tongtien));
                }
            } else if (rdThang.isSelected()) {
                String thang = tfThang.getText();
                boolean ok = true;
                if (thang.length() == 0) {
                    JOptionPane.showMessageDialog(rootPane, "Bạn phải nhập tháng muốn tìm kiếm");
                    ok = false;
                }
                String pattern = "MM/yyyy";
                Date thang1 = null;
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
                    thang1 = dateFormat.parse(thang);
                } catch (ParseException ex) {
                    JOptionPane.showInternalMessageDialog(null, "Tháng phải có định dang MM/yyyy");
                    ok = false;
                }
                if (ok == true) {
                    String arrngay[] = thang.split("/");
                    thang = arrngay[1] + "-" + arrngay[0];
                    String sql = "SELECT * FROM tblhoadon WHERE ngaytao LIKE '%" + thang + "%'";
                    listHD = new DAO().getListHoaDon(sql);
                    showData(listHD, modelThongKeHD);
                    float tongtien = 0;
                    for (HoaDon hd : listHD) {
                        tongtien = tongtien + hd.getTongtien();
                    }
                    lbTongTien3.setText(String.valueOf(tongtien));
                }
            } else if (rdKhoangThoiGian.isSelected()) {
                String tungay = tfTuNgay.getText();
                String denngay = tfDenNgay.getText();
                boolean ok = true;
                if (tungay.length() == 0 || denngay.length() == 0) {
                    JOptionPane.showMessageDialog(rootPane, "Bạn phải nhập ngày muốn tìm kiếm");
                    ok = false;
                }
                String pattern = "dd/MM/yyyy";
                Date tungay1 = null;
                Date denngay1 = null;
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
                    tungay1 = dateFormat.parse(tungay);
                    denngay1 = dateFormat.parse(denngay);
                } catch (ParseException ex) {
                    JOptionPane.showInternalMessageDialog(null, "Ngày phải có định dang MM/yyyy");
                    ok = false;
                }
                if (ok == true) {
                    String arrngay1[] = tungay.split("/");
                    tungay = arrngay1[2] + "-" + arrngay1[1] + "-" + arrngay1[0];
                    String arrngay2[] = denngay.split("/");
                    denngay = arrngay2[2] + "-" + arrngay2[1] + "-" + arrngay2[0];
                    String sql = "SELECT *FROM tblhoadon Where ngaytao between '" + tungay + "' AND '" + denngay + "'";
                    listHD = new DAO().getListHoaDon(sql);
                    showData(listHD, modelThongKeHD);
                    float tongtien = 0;
                    for (HoaDon hd : listHD) {
                        tongtien = tongtien + hd.getTongtien();
                    }
                    lbTongTien3.setText(String.valueOf(tongtien));
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Bạn phải chọn loại thống kê !!!");
            }

        } else {
            JOptionPane.showMessageDialog(rootPane, "Bạn phải chọn loại hóa đơn trước !!!");
        }
    }//GEN-LAST:event_thongKeHoaDonActionPerformed

    private void tblThongKeHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThongKeHoaDonMouseClicked
        if (rdHoaDonNhap.isSelected()) {
            int selectRow = tblThongKeHoaDon.getSelectedRow();
            HoaDon hd = new HoaDon();
            hd = listHD.get(selectRow);
            String sql = "SELECT * FROM tblchitietnhaphang WHERE maHD = " + hd.getMaHD();
            listThongKeChiTiet = new DAO().getListChiTietHoaDon(sql);
            showData(listThongKeChiTiet, modelThongKeChiTiet);
        } else if (rdHoaDonXuat.isSelected()) {
            int selectRow = tblThongKeHoaDon.getSelectedRow();
            HoaDon hd = new HoaDon();
            hd = listHD.get(selectRow);
            String sql = "SELECT * FROM tblchitietxuatkho WHERE maHD = " + hd.getMaHD();
            listThongKeChiTiet = new DAO().getListChiTietHoaDon(sql);
            showData(listThongKeChiTiet, modelThongKeChiTiet);
        } else if (rdHoaDonBanHang.isSelected()) {
            int selectRow = tblThongKeHoaDon.getSelectedRow();
            HoaDon hd = new HoaDon();
            hd = listHD.get(selectRow);
            String sql = "SELECT * FROM tblchitiethoadon WHERE maHD = " + hd.getMaHD();
            listThongKeChiTiet = new DAO().getListChiTietHoaDon(sql);
            showData(listThongKeChiTiet, modelThongKeChiTiet);
        }
    }//GEN-LAST:event_tblThongKeHoaDonMouseClicked

    private void dangxuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dangxuatActionPerformed
        this.dispose();
    }//GEN-LAST:event_dangxuatActionPerformed

    private void rdHoaDonNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdHoaDonNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdHoaDonNhapActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                QuanLy dialog = new QuanLy(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LamMoiSP;
    private javax.swing.JButton LamMoiSP1;
    private javax.swing.JButton LamMoiSP2;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.ButtonGroup buttonGroup7;
    private java.awt.Canvas canvas1;
    private javax.swing.JButton capnhatNV;
    private javax.swing.JButton capnhatSP;
    private javax.swing.JButton capnhatSP1;
    private javax.swing.JButton capnhatSP2;
    private javax.swing.JComboBox<String> cbNhomSP;
    private javax.swing.JComboBox<String> cbNhomSP1;
    private javax.swing.JComboBox<String> cbNhomSP2;
    private javax.swing.JComboBox<String> cbVitri;
    private javax.swing.JButton dangxuat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem2;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton lammoiNV;
    private javax.swing.JLabel lbTongTien1;
    private javax.swing.JLabel lbTongTien2;
    private javax.swing.JLabel lbTongTien3;
    private javax.swing.JButton luuPhieu1;
    private javax.swing.JButton luuPhieu2;
    private javax.swing.JButton nhapMaSP1;
    private javax.swing.JButton nhapMaSP2;
    private javax.swing.JRadioButton rdHoaDonBanHang;
    private javax.swing.JRadioButton rdHoaDonNhap;
    private javax.swing.JRadioButton rdHoaDonXuat;
    private javax.swing.JRadioButton rdKhoangThoiGian;
    private javax.swing.JRadioButton rdNgay;
    private javax.swing.JRadioButton rdNhapHang;
    private javax.swing.JRadioButton rdThang;
    private javax.swing.JRadioButton rdXuatHang;
    private javax.swing.JButton suaNV;
    private javax.swing.JButton suaSanPham;
    private javax.swing.JButton taoMoiHD1;
    private javax.swing.JButton taoMoiHD2;
    private javax.swing.JTable tblBanHang;
    private javax.swing.JTable tblNhanVien;
    private javax.swing.JTable tblNhapXuat;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTable tblSanPham1;
    private javax.swing.JTable tblSanPham2;
    private javax.swing.JTable tblThongKeHoaDon;
    private javax.swing.JTextField tfDenNgay;
    private javax.swing.JTextField tfDiachi;
    private javax.swing.JTextField tfGiaBan;
    private javax.swing.JTextField tfGiaBan1;
    private javax.swing.JTextField tfGiaBan2;
    private javax.swing.JTextField tfGiaNhap;
    private javax.swing.JTextField tfGiaNhap1;
    private javax.swing.JTextField tfGiaNhap2;
    private javax.swing.JTextField tfHSD;
    private javax.swing.JTextField tfHovaTen;
    private javax.swing.JTextField tfIdNv;
    private javax.swing.JTextField tfMaSP;
    private javax.swing.JTextField tfMaSP1;
    private javax.swing.JTextField tfMaSP2;
    private javax.swing.JTextField tfMaSPKho;
    private javax.swing.JTextField tfMatKhau;
    private javax.swing.JTextField tfNHH1;
    private javax.swing.JTextField tfNHH2;
    private javax.swing.JTextField tfNSX;
    private javax.swing.JTextField tfNSX1;
    private javax.swing.JTextField tfNSX2;
    private javax.swing.JTextField tfNgay;
    private javax.swing.JTextField tfNgaySinh;
    private javax.swing.JTextField tfNhapSoLuong2;
    private javax.swing.JTextField tfSDT;
    private javax.swing.JTextField tfTaiKhoan;
    private javax.swing.JTextField tfTenSP;
    private javax.swing.JTextField tfTenSP1;
    private javax.swing.JTextField tfTenSP2;
    private javax.swing.JTextField tfThang;
    private javax.swing.JTextField tfTuNgay;
    private javax.swing.JButton themNhanvien;
    private javax.swing.JButton themSanPham;
    private javax.swing.JButton thongKeHoaDon;
    private javax.swing.JButton timKiemSP;
    private javax.swing.JButton timKiemSP1;
    private javax.swing.JButton timKiemSP2;
    private javax.swing.JButton timkiemNV;
    private javax.swing.JButton xoaNV;
    private javax.swing.JButton xoaPhieu1;
    private javax.swing.JButton xoaPhieu2;
    private javax.swing.JButton xoaSanPham;
    // End of variables declaration//GEN-END:variables

    @Override
    public <T> void showData(List<T> list, DefaultTableModel model) {
        model.setRowCount(0);
        int stt = 1;
        if (modelSP == model) {
            for (T t : list) {
                SanPham sp = (SanPham) t;
                model.addRow(new Object[]{
                    stt, sp.getMaSP(), sp.getTenSP(), sp.getNhomSP(), sp.getGiaNhap(), sp.getGiaBan(),
                    sp.getNgaySX(), sp.getHanSD()
                });
                stt++;
            }
        }
        if (modelSP1 == model) {
            for (T t : list) {
                SanPham sp = (SanPham) t;
                model.addRow(new Object[]{
                    stt, sp.getMaSP(), sp.getTenSP(), sp.getNhomSP()
                });
                stt++;
            }
        }
        if (modelNV == model) {
            for (T t : list) {
                NhanVien nv = (NhanVien) t;
                model.addRow(new Object[]{
                    stt, nv.getIdNv(), nv.getHoten(), nv.getDiachi(), nv.getNgaysinh(), nv.getSdt(),
                    nv.getTaikhoan(), nv.getMatkhau(), nv.getVitri()
                });
                stt++;
            }
        }
        if (modelSP2 == model) {
            for (T t : list) {
                SanPham sp = (SanPham) t;
                model.addRow(new Object[]{
                    stt, sp.getMaSP(), sp.getTenSP(), sp.getNhomSP()
                });
                stt++;
            }
        }
        if (modelNhapXuat == model) {
            for (T t : list) {
                ChiTietHoaDon cthd = (ChiTietHoaDon) t;
                //SanPham sp
                model.addRow(new Object[]{
                    stt, cthd.getMaSP(), cthd.getTenSP(), cthd.getThanhtien()
                });
                stt++;
            }
        }
        if (modelBanHang == model) {
            for (T t : list) {
                ChiTietHoaDon cthd = (ChiTietHoaDon) t;
                //SanPham sp
                model.addRow(new Object[]{
                    stt, cthd.getMaSP(), cthd.getTenSP(), cthd.getThanhtien()
                });
                stt++;
            }
        }
        if (modelThongKeHD == model) {
            for (T t : list) {
                HoaDon hd = (HoaDon) t;
                model.addRow(new Object[]{
                    stt, hd.getMaHD(), hd.getNgaytaoHD(), hd.getTongtien()});
                stt++;
            }
        }
    }

}
