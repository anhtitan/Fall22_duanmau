package Duanmau.View;

import Duanmau.DomainModels.ChiTietSP;
import Duanmau.DomainModels.DongSP;
import Duanmau.DomainModels.MauSac;
import Duanmau.DomainModels.NSX;
import Duanmau.DomainModels.SanPham;
import Duanmau.Responsitories.SanPhamRepository;
import Duanmau.Service.ChiTietSPService;
import Duanmau.Service.MauSacService;
import Duanmau.Service.SanPhamService;
import Duanmau.Service.DongSPService;
import Duanmau.Service.NSXService;
import Duanmau.Service.impl.IChiTietSPServicerImpl;
import Duanmau.Service.impl.IDongSPServiceImpl;
import Duanmau.Service.impl.ISanPhamServiceImpl;
import Duanmau.Service.impl.IMauSacServiceImpl;
import Duanmau.Service.impl.INSXServicerImpl;
import Duanmau.Utilies.Helper;
import java.awt.CardLayout;
import java.awt.Color;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AnhTiTan
 */
public class view_deltais extends javax.swing.JFrame {

    private Helper helper = new Helper();
    private CardLayout cardLayout;

    private DefaultTableModel tblModelSP;
    private DefaultTableModel tblModelCTSP;

    private SanPhamService SPSer = new ISanPhamServiceImpl();
    private MauSacService MSSer = new IMauSacServiceImpl();
    private DongSPService dongSPSer = new IDongSPServiceImpl();
    private NSXService nsxSer = new INSXServicerImpl();
    private ChiTietSPService ctspService = new IChiTietSPServicerImpl();

    private DefaultComboBoxModel<SanPham> dcbmSP;
    private DefaultComboBoxModel<MauSac> dcbmMS;
    private DefaultComboBoxModel<DongSP> dcbmDSP;
    private DefaultComboBoxModel<NSX> dcbmNSX;

    private DefaultComboBoxModel defaultComboBoxModel;

    public view_deltais() {
        initComponents();

        dcbmSP = new DefaultComboBoxModel<>();
        dcbmMS = new DefaultComboBoxModel<>();
        dcbmNSX = new DefaultComboBoxModel<>();
        dcbmDSP = new DefaultComboBoxModel<>();

        setExtendedState(MAXIMIZED_BOTH);
        cardLayout = (CardLayout) main.getLayout();
        cardLayout.show(main, "card3");
        Menu.setBackground(Color.GRAY);
        PN_menu1.setBackground(Color.LIGHT_GRAY);
        PN_menu2.setBackground(Color.GRAY);
        PN_menu3.setBackground(Color.GRAY);
        PN_menu4.setBackground(Color.GRAY);

        loadDataSP(SPSer.getAll());

        loadCbMaSP();
        loadCbMaNSX();
        loadCbMaMS();
        loadCbMaDSP();
        load_QLSP_CTSP(ctspService.getbySP_NV());
        tbTTSP.getTableHeader().setReorderingAllowed(false);
        tbCTSP.getTableHeader().setReorderingAllowed(false);
        lbl_viewAllctsp.setVisible(false);

    }

    private void loadDataSP(ArrayList<SanPham> list) {
        int stt = 1;
        tblModelSP = (DefaultTableModel) tbTTSP.getModel();
        tblModelSP.setColumnIdentifiers(new String[]{"STT", "Mã SP", "Tên SP"});

        tblModelSP.setRowCount(0);
        for (SanPham x : list) {
            tblModelSP.addRow(new Object[]{stt++, x.getMa(), x.getTen()});
        }

    }

    private void loadDataMS(ArrayList<MauSac> list) {
        int stt = 1;
        tblModelSP = (DefaultTableModel) tbTTSP.getModel();
        tblModelSP.setColumnIdentifiers(new String[]{"STT", "Mã MS", "Tên MS"});

        tblModelSP.setRowCount(0);
        for (MauSac x : list) {
            tblModelSP.addRow(new Object[]{stt++, x.getMa(), x.getTen()});
        }

    }

    private void loadDataDongSP(ArrayList<DongSP> list) {
        int stt = 1;
        tblModelSP = (DefaultTableModel) tbTTSP.getModel();
        tblModelSP.setColumnIdentifiers(new String[]{"STT", "Mã DSP", "Tên DSP"});

        tblModelSP.setRowCount(0);
        for (DongSP x : list) {
            tblModelSP.addRow(new Object[]{stt++, x.getMa(), x.getTen()});
        }

    }

    private void loadDataNSX(ArrayList<NSX> list) {
        int stt = 1;
        tblModelSP = (DefaultTableModel) tbTTSP.getModel();
        tblModelSP.setColumnIdentifiers(new String[]{"STT", "Mã NSX", "Tên NSX"});

        tblModelSP.setRowCount(0);
        for (NSX x : list) {
            tblModelSP.addRow(new Object[]{stt++, x.getMa(), x.getTen()});
        }

    }

//    private void loadDataCTSP(ArrayList<ChiTietSP> list) {
//        int stt = 1;
//        tblModelCTSP = (DefaultTableModel) tbl_SPCT.getModel();
//        tblModelCTSP.setColumnIdentifiers(new String[]{"STT", "Mã SP", "Tên SP", "Nam Bao Hanh", "mo ta", "So luong ton", "gia nhap", "gia ban"});
//
//        tblModelCTSP.setRowCount(0);
//        for (ChiTietSP x : list) {
//            tblModelCTSP.addRow(new Object[]{stt++, x.getSanPham().getMa(), x.getSanPham().getTen(), x.getNamBH(), x.getMoTa(), x.getNamBH(), x.getSoLuongTon(), x.getGiaNhap(), x.getGiaBan()});
//        }
//
//    }
    private void loadTextSP() {
        try {
            int choice = tbTTSP.getSelectedRow();
            txtMa_ttsp.setText(tbTTSP.getValueAt(choice, 1).toString());
            txtTen_ttsp.setText(tbTTSP.getValueAt(choice, 2).toString());
        } catch (Exception e) {
        }
    }

    private void loadTextCTSP() {
        try {
            int row = tbCTSP.getSelectedRow();
            ChiTietSP ctsp = ctspService.getbySP_NV().get(row);
            dcbmSP.setSelectedItem(ctsp.getSanPham());
            dcbmMS.setSelectedItem(ctsp.getMauSac());
            dcbmNSX.setSelectedItem(ctsp.getNsx());
            dcbmDSP.setSelectedItem(ctsp.getDongSP());
            spSlton_ctsp.setValue(ctsp.getSoLuongTon());
            txtGiaNhap_ctsp.setText(ctsp.getGiaNhap().toString());
            txtGiaBan_ctsp.setText(ctsp.getGiaNhap() + "");
            txtMoTa_ctsp.setText(ctsp.getMoTa());
            txtNamBH_ctsp.setText(ctsp.getNamBH() + "");
        } catch (Exception e) {

        }

    }

    private void Clear() {
        txtMa_ttsp.setText("");
        txtTen_ttsp.setText("");
    }

    private void loadCbMaSP() {
        dcbmSP = (DefaultComboBoxModel) cbSP_ctsp.getModel();
        dcbmSP.removeAllElements();
        for (SanPham x : SPSer.getAll()) {
            dcbmSP.addElement(x);
        }
    }

    private void loadCbMaNSX() {
        dcbmNSX = (DefaultComboBoxModel) cbNSX_ctsp.getModel();
        dcbmNSX.removeAllElements();
        for (NSX x : nsxSer.getALL()) {
            dcbmNSX.addElement(x);
        }
    }

    private void loadCbMaMS() {
        dcbmMS = (DefaultComboBoxModel) cbMS_ctsp.getModel();
        dcbmMS.removeAllElements();
        for (MauSac x : MSSer.getALL()) {
            dcbmMS.addElement(x);
        }
    }

    private void loadCbMaDSP() {
        dcbmDSP = (DefaultComboBoxModel) cbDSP_ctsp.getModel();
        dcbmDSP.removeAllElements();
        for (DongSP x : dongSPSer.getALL()) {
            dcbmDSP.addElement(x);
        }
    }

    //
    private void load_QLSP_CTSP(List<ChiTietSP> list) {
        tblModelCTSP = (DefaultTableModel) tbCTSP.getModel();
        tblModelCTSP.setRowCount(0);
        for (ChiTietSP x : list) {
            tblModelCTSP.addRow(new Object[]{
                x.getSanPham().getMa(), x.getSanPham().getTen(), x.getNamBH(), x.getMoTa(), x.getNsx().getTen(), x.getMauSac().getTen(), x.getDongSP().getTen(), x.getSoLuongTon(), x.getGiaNhap(), x.getGiaBan()
            });
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Menu = new javax.swing.JPanel();
        PN_menu1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        PN_menu2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        PN_menu3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        PN_menu4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblDangXuat = new javax.swing.JLabel();
        main = new javax.swing.JPanel();
        pn_qlsp = new javax.swing.JPanel();
        qlsp_ctsp = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbCTSP = new javax.swing.JTable();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        cbSP_ctsp = new javax.swing.JComboBox<>();
        cbNSX_ctsp = new javax.swing.JComboBox<>();
        cbMS_ctsp = new javax.swing.JComboBox<>();
        cbDSP_ctsp = new javax.swing.JComboBox<>();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        txtNamBH_ctsp = new javax.swing.JTextField();
        txtGiaNhap_ctsp = new javax.swing.JTextField();
        txtGiaBan_ctsp = new javax.swing.JTextField();
        btn_ctsp_them = new javax.swing.JButton();
        btn_ctsp_timkiem = new javax.swing.JButton();
        btn_ctsp_capnhat = new javax.swing.JButton();
        btn_ctsp_xoa = new javax.swing.JButton();
        spSlton_ctsp = new javax.swing.JSpinner();
        jLabel51 = new javax.swing.JLabel();
        txtMoTa_ctsp = new javax.swing.JTextField();
        lbl_viewAllctsp = new javax.swing.JLabel();
        qlsp_sp = new javax.swing.JPanel();
        lbl_title_gener = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tbTTSP = new javax.swing.JTable();
        cbGener = new javax.swing.JComboBox<>();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        txtMa_ttsp = new javax.swing.JTextField();
        txtTen_ttsp = new javax.swing.JTextField();
        btn_ttsp_xoa = new javax.swing.JButton();
        btn_ttsp_timkiem = new javax.swing.JButton();
        btn_ttsp_capnhat = new javax.swing.JButton();
        btnThem_ttsp = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Menu.setBackground(new java.awt.Color(204, 204, 204));

        PN_menu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PN_menu1MouseClicked(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Danh sách sản phẩm");

        javax.swing.GroupLayout PN_menu1Layout = new javax.swing.GroupLayout(PN_menu1);
        PN_menu1.setLayout(PN_menu1Layout);
        PN_menu1Layout.setHorizontalGroup(
            PN_menu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PN_menu1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                .addContainerGap())
        );
        PN_menu1Layout.setVerticalGroup(
            PN_menu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PN_menu1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addContainerGap())
        );

        PN_menu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PN_menu2MouseClicked(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Danh sách hoá đơn");

        javax.swing.GroupLayout PN_menu2Layout = new javax.swing.GroupLayout(PN_menu2);
        PN_menu2.setLayout(PN_menu2Layout);
        PN_menu2Layout.setHorizontalGroup(
            PN_menu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
        );
        PN_menu2Layout.setVerticalGroup(
            PN_menu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PN_menu2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addContainerGap())
        );

        PN_menu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PN_menu3MouseClicked(evt);
            }
        });

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Quản lý sản phẩm");

        javax.swing.GroupLayout PN_menu3Layout = new javax.swing.GroupLayout(PN_menu3);
        PN_menu3.setLayout(PN_menu3Layout);
        PN_menu3Layout.setHorizontalGroup(
            PN_menu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
        );
        PN_menu3Layout.setVerticalGroup(
            PN_menu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PN_menu3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel14)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PN_menu4Layout = new javax.swing.GroupLayout(PN_menu4);
        PN_menu4.setLayout(PN_menu4Layout);
        PN_menu4Layout.setHorizontalGroup(
            PN_menu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 215, Short.MAX_VALUE)
        );
        PN_menu4Layout.setVerticalGroup(
            PN_menu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 53, Short.MAX_VALUE)
        );

        jLabel1.setText("Hello: user + rose");

        lblDangXuat.setText("Đăng Xuất");
        lblDangXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDangXuatMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout MenuLayout = new javax.swing.GroupLayout(Menu);
        Menu.setLayout(MenuLayout);
        MenuLayout.setHorizontalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PN_menu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(PN_menu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(PN_menu3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(PN_menu4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(MenuLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(MenuLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        MenuLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {PN_menu1, PN_menu2, PN_menu3, PN_menu4});

        MenuLayout.setVerticalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PN_menu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(PN_menu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(PN_menu3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(PN_menu4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblDangXuat)
                .addGap(14, 14, 14))
        );

        MenuLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {PN_menu1, PN_menu2, PN_menu3, PN_menu4});

        main.setLayout(new java.awt.CardLayout());

        pn_qlsp.setVerifyInputWhenFocusTarget(false);
        pn_qlsp.setLayout(new java.awt.GridLayout(1, 0));

        qlsp_ctsp.setBorder(javax.swing.BorderFactory.createTitledBorder("Chi tiết sản phẩm"));

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("CHI TIẾT SẢN PHẨM");

        tbCTSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã", "Tên", "Năm BH", "Mô tả", "Nhà SX", "Màu Sắc", "Dòng SP", "Số Lượng", "Giá Nhập", "Giá Bán"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbCTSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCTSPMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tbCTSP);
        if (tbCTSP.getColumnModel().getColumnCount() > 0) {
            tbCTSP.getColumnModel().getColumn(0).setHeaderValue("Mã");
            tbCTSP.getColumnModel().getColumn(1).setHeaderValue("Tên");
            tbCTSP.getColumnModel().getColumn(2).setHeaderValue("Năm BH");
            tbCTSP.getColumnModel().getColumn(3).setHeaderValue("Mô tả");
            tbCTSP.getColumnModel().getColumn(4).setHeaderValue("Nhà SX");
            tbCTSP.getColumnModel().getColumn(5).setHeaderValue("Màu Sắc");
            tbCTSP.getColumnModel().getColumn(6).setHeaderValue("Dòng SP");
            tbCTSP.getColumnModel().getColumn(7).setHeaderValue("Số Lượng");
            tbCTSP.getColumnModel().getColumn(8).setHeaderValue("Giá Nhập");
            tbCTSP.getColumnModel().getColumn(9).setHeaderValue("Giá Bán");
        }

        jLabel38.setText("Sản phẩm");

        jLabel39.setText("Nhà sản xuất");

        jLabel40.setText("Màu sắc");

        jLabel41.setText("Dòng SP");

        cbSP_ctsp.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel42.setText("Năm BH");

        jLabel43.setText("Số lượng tồn");

        jLabel44.setText("Giá nhập");

        jLabel45.setText("Giá bán");

        txtNamBH_ctsp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        txtGiaNhap_ctsp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        txtGiaBan_ctsp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        btn_ctsp_them.setBackground(new java.awt.Color(204, 204, 204));
        btn_ctsp_them.setText("Thêm");
        btn_ctsp_them.setBorderPainted(false);
        btn_ctsp_them.setFocusPainted(false);
        btn_ctsp_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ctsp_themActionPerformed(evt);
            }
        });

        btn_ctsp_timkiem.setBackground(new java.awt.Color(204, 204, 204));
        btn_ctsp_timkiem.setText("Tìm kiếm");
        btn_ctsp_timkiem.setBorderPainted(false);
        btn_ctsp_timkiem.setFocusPainted(false);

        btn_ctsp_capnhat.setBackground(new java.awt.Color(204, 204, 204));
        btn_ctsp_capnhat.setText("Cập nhật");
        btn_ctsp_capnhat.setBorderPainted(false);
        btn_ctsp_capnhat.setFocusPainted(false);
        btn_ctsp_capnhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ctsp_capnhatActionPerformed(evt);
            }
        });

        btn_ctsp_xoa.setBackground(new java.awt.Color(204, 204, 204));
        btn_ctsp_xoa.setText("Xóa");
        btn_ctsp_xoa.setBorderPainted(false);
        btn_ctsp_xoa.setFocusPainted(false);
        btn_ctsp_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ctsp_xoaActionPerformed(evt);
            }
        });

        jLabel51.setText("Mô tả");

        txtMoTa_ctsp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        lbl_viewAllctsp.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_viewAllctsp.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_viewAllctsp.setText("Xem tất cả");
        lbl_viewAllctsp.setToolTipText("");
        lbl_viewAllctsp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_viewAllctspMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_viewAllctspMouseReleased(evt);
            }
        });

        qlsp_sp.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin"));

        lbl_title_gener.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_title_gener.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_title_gener.setText("SẢN PHẨM");

        tbTTSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Tên"
            }
        ));
        tbTTSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbTTSPMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tbTTSP);

        cbGener.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sản phẩm", "Nhà sản xuất", "Màu sắc", "Dòng sản phẩm" }));
        cbGener.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbGenerItemStateChanged(evt);
            }
        });

        jLabel46.setText("Mã");

        jLabel47.setText("Tên");

        txtMa_ttsp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        txtTen_ttsp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        btn_ttsp_xoa.setBackground(new java.awt.Color(204, 204, 204));
        btn_ttsp_xoa.setText("Xóa");
        btn_ttsp_xoa.setBorderPainted(false);
        btn_ttsp_xoa.setFocusPainted(false);
        btn_ttsp_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ttsp_xoaActionPerformed(evt);
            }
        });

        btn_ttsp_timkiem.setBackground(new java.awt.Color(204, 204, 204));
        btn_ttsp_timkiem.setText("Tìm kiếm");
        btn_ttsp_timkiem.setBorderPainted(false);
        btn_ttsp_timkiem.setFocusPainted(false);
        btn_ttsp_timkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ttsp_timkiemActionPerformed(evt);
            }
        });

        btn_ttsp_capnhat.setBackground(new java.awt.Color(204, 204, 204));
        btn_ttsp_capnhat.setText("Cập nhật");
        btn_ttsp_capnhat.setBorderPainted(false);
        btn_ttsp_capnhat.setFocusPainted(false);
        btn_ttsp_capnhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ttsp_capnhatActionPerformed(evt);
            }
        });

        btnThem_ttsp.setBackground(new java.awt.Color(204, 204, 204));
        btnThem_ttsp.setText("Thêm");
        btnThem_ttsp.setBorderPainted(false);
        btnThem_ttsp.setFocusPainted(false);
        btnThem_ttsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem_ttspActionPerformed(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel36.setForeground(java.awt.Color.red);
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel36.setText("Bạn đang cập nhật thông tin cho ");

        javax.swing.GroupLayout qlsp_spLayout = new javax.swing.GroupLayout(qlsp_sp);
        qlsp_sp.setLayout(qlsp_spLayout);
        qlsp_spLayout.setHorizontalGroup(
            qlsp_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_title_gener, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(qlsp_spLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(qlsp_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(qlsp_spLayout.createSequentialGroup()
                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbGener, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(qlsp_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(qlsp_spLayout.createSequentialGroup()
                            .addGroup(qlsp_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel47))
                            .addGap(18, 18, 18)
                            .addGroup(qlsp_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtTen_ttsp, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtMa_ttsp, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(66, 66, 66)
                            .addGroup(qlsp_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, qlsp_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btn_ttsp_xoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_ttsp_timkiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnThem_ttsp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(btn_ttsp_capnhat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        qlsp_spLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnThem_ttsp, btn_ttsp_capnhat, btn_ttsp_timkiem, btn_ttsp_xoa});

        qlsp_spLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtMa_ttsp, txtTen_ttsp});

        qlsp_spLayout.setVerticalGroup(
            qlsp_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(qlsp_spLayout.createSequentialGroup()
                .addComponent(lbl_title_gener)
                .addGap(37, 37, 37)
                .addGroup(qlsp_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(qlsp_spLayout.createSequentialGroup()
                        .addGroup(qlsp_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel46)
                            .addComponent(txtMa_ttsp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(qlsp_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel47)
                            .addComponent(txtTen_ttsp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(qlsp_spLayout.createSequentialGroup()
                        .addComponent(btnThem_ttsp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_ttsp_timkiem)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_ttsp_capnhat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_ttsp_xoa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(qlsp_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbGener, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36))
                .addContainerGap())
        );

        qlsp_spLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnThem_ttsp, btn_ttsp_capnhat, btn_ttsp_timkiem, btn_ttsp_xoa});

        qlsp_spLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtMa_ttsp, txtTen_ttsp});

        javax.swing.GroupLayout qlsp_ctspLayout = new javax.swing.GroupLayout(qlsp_ctsp);
        qlsp_ctsp.setLayout(qlsp_ctspLayout);
        qlsp_ctspLayout.setHorizontalGroup(
            qlsp_ctspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(qlsp_ctspLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(qlsp_sp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(qlsp_ctspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 1036, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, qlsp_ctspLayout.createSequentialGroup()
                        .addGroup(qlsp_ctspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(qlsp_ctspLayout.createSequentialGroup()
                                .addComponent(jLabel43)
                                .addGap(18, 18, 18)
                                .addComponent(spSlton_ctsp, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(qlsp_ctspLayout.createSequentialGroup()
                                .addComponent(jLabel44)
                                .addGap(40, 40, 40)
                                .addComponent(txtGiaNhap_ctsp))
                            .addGroup(qlsp_ctspLayout.createSequentialGroup()
                                .addGroup(qlsp_ctspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel45)
                                    .addComponent(jLabel51))
                                .addGap(46, 46, 46)
                                .addGroup(qlsp_ctspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtGiaBan_ctsp)
                                    .addComponent(txtMoTa_ctsp)))
                            .addGroup(qlsp_ctspLayout.createSequentialGroup()
                                .addGroup(qlsp_ctspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel39)
                                    .addComponent(jLabel41)
                                    .addComponent(jLabel42)
                                    .addComponent(jLabel40)
                                    .addComponent(jLabel38))
                                .addGap(18, 18, 18)
                                .addGroup(qlsp_ctspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbSP_ctsp, 0, 249, Short.MAX_VALUE)
                                    .addComponent(cbNSX_ctsp, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbMS_ctsp, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbDSP_ctsp, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtNamBH_ctsp))))
                        .addGroup(qlsp_ctspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(qlsp_ctspLayout.createSequentialGroup()
                                .addGap(0, 606, Short.MAX_VALUE)
                                .addComponent(lbl_viewAllctsp, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, qlsp_ctspLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(qlsp_ctspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btn_ctsp_them, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_ctsp_timkiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_ctsp_capnhat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_ctsp_xoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(208, 208, 208)))))
                .addContainerGap())
        );

        qlsp_ctspLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_ctsp_capnhat, btn_ctsp_them, btn_ctsp_timkiem, btn_ctsp_xoa});

        qlsp_ctspLayout.setVerticalGroup(
            qlsp_ctspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(qlsp_ctspLayout.createSequentialGroup()
                .addGroup(qlsp_ctspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, qlsp_ctspLayout.createSequentialGroup()
                        .addComponent(jLabel37)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(qlsp_ctspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel38)
                            .addComponent(cbSP_ctsp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(qlsp_ctspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(qlsp_ctspLayout.createSequentialGroup()
                                .addGroup(qlsp_ctspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel39)
                                    .addComponent(cbNSX_ctsp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(qlsp_ctspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel40)
                                    .addComponent(cbMS_ctsp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(qlsp_ctspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel41)
                                    .addComponent(cbDSP_ctsp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(qlsp_ctspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel42)
                                    .addComponent(txtNamBH_ctsp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(qlsp_ctspLayout.createSequentialGroup()
                                .addComponent(btn_ctsp_them)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_ctsp_timkiem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_ctsp_capnhat)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_ctsp_xoa)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(qlsp_ctspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel43)
                            .addComponent(spSlton_ctsp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(qlsp_ctspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel44)
                            .addComponent(txtGiaNhap_ctsp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(qlsp_ctspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel45)
                            .addComponent(txtGiaBan_ctsp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(qlsp_ctspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel51)
                            .addComponent(txtMoTa_ctsp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_viewAllctsp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE))
                    .addGroup(qlsp_ctspLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(qlsp_sp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        qlsp_ctspLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_ctsp_capnhat, btn_ctsp_them, btn_ctsp_timkiem, btn_ctsp_xoa});

        qlsp_ctspLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cbDSP_ctsp, cbMS_ctsp, cbNSX_ctsp, cbSP_ctsp, txtGiaBan_ctsp, txtGiaNhap_ctsp, txtMoTa_ctsp, txtNamBH_ctsp});

        pn_qlsp.add(qlsp_ctsp);

        main.add(pn_qlsp, "card3");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1486, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 708, Short.MAX_VALUE)
        );

        main.add(jPanel2, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PN_menu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PN_menu1MouseClicked
        cardLayout.show(main, "card3");
        PN_menu2.setBackground(Color.GRAY);
        PN_menu1.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_PN_menu1MouseClicked

    private void PN_menu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PN_menu2MouseClicked

        PN_menu2.setBackground(Color.LIGHT_GRAY);
        PN_menu1.setBackground(Color.GRAY);
        cardLayout.show(main, "card2");
    }//GEN-LAST:event_PN_menu2MouseClicked

    private void lblDangXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDangXuatMouseClicked
        int choice = JOptionPane.showConfirmDialog(this, "Ban co muom dang xuat khong", "thong bao", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            this.dispose();
            new view_DangNhap().setVisible(true);
        }

    }//GEN-LAST:event_lblDangXuatMouseClicked

    private void tbTTSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbTTSPMouseClicked
        loadTextSP();
    }//GEN-LAST:event_tbTTSPMouseClicked

    private void cbGenerItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbGenerItemStateChanged
        if (cbGener.getSelectedIndex() == 0) {
            //loadSP
            lbl_title_gener.setText("Sản Phẩm");
            Clear();
            loadDataSP(SPSer.getAll());
        } else if (cbGener.getSelectedIndex() == 1) {
            //loadNSX
            lbl_title_gener.setText("Nhà Sản Xuất");
            Clear();
            loadDataNSX(nsxSer.getALL());
        } else if (cbGener.getSelectedIndex() == 2) {
            //load MS
            lbl_title_gener.setText("Màu Sắc");
            Clear();
            loadDataMS(MSSer.getALL());
        } else if (cbGener.getSelectedIndex() == 3) {
            //load DSP
            lbl_title_gener.setText("Dòng Sản Phẩm");
            Clear();
            loadDataDongSP(dongSPSer.getALL());
        }
    }//GEN-LAST:event_cbGenerItemStateChanged

    private void btn_ttsp_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ttsp_xoaActionPerformed
        String ma = txtMa_ttsp.getText();
        if (cbGener.getSelectedIndex() == 0) {
            SanPham sp = SPSer.getSPbyMa(ma);
            if (SPSer.Delete(sp.getID())) {
                Clear();
                helper.alert(this, "Xoá thành công!");
            } else {
                helper.error(this, "xoá sản phẩm thất bại vui lòng kiểm tra lại");
            }
            loadDataSP(SPSer.getAll());
        } else if (cbGener.getSelectedIndex() == 1) {
            NSX nsx = nsxSer.getNSXbyMS(ma);
            if (nsxSer.Delete(nsx.getId())) {
                Clear();
                helper.alert(this, "Xoá thành công!");
            } else {
                helper.alert(this, "xoá nsx thất bại vui lòng kiểm tra lại");
            }
            loadDataNSX(nsxSer.getALL());
        } else if (cbGener.getSelectedIndex() == 2) {
            MauSac ms = MSSer.getMSbyMa(ma);
            if (MSSer.Delete(ms.getId())) {
                Clear();
                helper.alert(this, "Xoá thành công!");
            } else {
                helper.error(this, "xoa màu sắc thất bại vui lòng kiểm tra lại");
            }
            loadDataMS(MSSer.getALL());
        } else if (cbGener.getSelectedIndex() == 3) {
            DongSP dsp = dongSPSer.getDSPbyMa(ma);
            if (dongSPSer.Delete(dsp.getId())) {
                Clear();
                helper.alert(this, "Xoá thành công!");
            } else {
                helper.error(this, "xoá dsp bại vui lòng kiểm tra lại");
            }
            loadDataDongSP(dongSPSer.getALL());
        }
        loadCbMaSP();
        loadCbMaDSP();
        loadCbMaNSX();
        loadCbMaMS();
        load_QLSP_CTSP(ctspService.getbySP_NV());
    }//GEN-LAST:event_btn_ttsp_xoaActionPerformed

    private void btn_ttsp_capnhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ttsp_capnhatActionPerformed
        String ma = txtMa_ttsp.getText();
        if (cbGener.getSelectedIndex() == 0) {
            SanPham sp = new SanPham();
            sp.setTen(txtTen_ttsp.getText());
            if (SPSer.Edit(ma, sp)) {
                helper.alert(this, "Update thành công");
                Clear();
            } else {
                helper.error(this, "update thất bại vui lòng kiểm tra lại");
            }
            loadDataSP(SPSer.getAll());
        } else if (cbGener.getSelectedIndex() == 1) {
            NSX nsx = new NSX();
            nsx.setTen(txtTen_ttsp.getText());
            if (nsxSer.update(nsx, ma)) {
                helper.alert(this, "Update thành công");
                Clear();
            } else {
                helper.error(this, "update thất bại vui lòng kiểm tra lại");
            }
            loadDataNSX(nsxSer.getALL());
        } else if (cbGener.getSelectedIndex() == 2) {
            MauSac ms = new MauSac();
            ms.setTen(txtTen_ttsp.getText());
            if (MSSer.update(ms, ma)) {
                helper.alert(this, "Update thành công");
                Clear();
            } else {
                helper.error(this, "update thất bại vui lòng kiểm tra lại");
            }
            loadDataMS(MSSer.getALL());
        } else if (cbGener.getSelectedIndex() == 3) {
            DongSP dsp = new DongSP();
            dsp.setTen(txtTen_ttsp.getText());
            if (dongSPSer.update(dsp, ma)) {
                helper.alert(this, "Update thành công");
                Clear();
            } else {
                helper.error(this, "update thất bại vui lòng kiểm tra lại");
            }
            loadDataDongSP(dongSPSer.getALL());
        }
        load_QLSP_CTSP(ctspService.getbySP_NV());
    }//GEN-LAST:event_btn_ttsp_capnhatActionPerformed

    private void btnThem_ttspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem_ttspActionPerformed
        if (cbGener.getSelectedIndex() == 0) {
            SanPham sp = new SanPham();
            sp.setMa(txtMa_ttsp.getText());
            sp.setTen(txtTen_ttsp.getText());
            if (SPSer.AddNew(sp)) {

                helper.alert(this, "Thêm sản phẩm thành công!");

            } else {
                helper.error(this, "Thêm sản phẩm thất bại vui lòng kiểm tra lại");
            }
            loadDataSP(SPSer.getAll());
            // load_QLSP_CTSP(ctspService.getbySP_NV());

            //loadCbMaSP();
        } else if (cbGener.getSelectedIndex() == 1) {
            NSX nsx = new NSX();
            nsx.setMa(txtMa_ttsp.getText());
            nsx.setTen(txtTen_ttsp.getText());
            if (nsxSer.Add(nsx)) {
                helper.alert(this, "Thêm NSX thành công!");
            } else {
                helper.error(this, "Thêm NSX thất bại vui lòng kiểm tra lại");
            }
            loadDataNSX(nsxSer.getALL());
        } else if (cbGener.getSelectedIndex() == 2) {//ms
            MauSac ms = new MauSac();
            ms.setMa(txtMa_ttsp.getText());
            ms.setTen(txtTen_ttsp.getText());
            if (MSSer.Add(ms)) {
                helper.alert(this, "Thêm MS thành công!");
            } else {
                helper.alert(this, "Thêm MS thất bại vui lòng kiểm tra lại");
            }
            loadDataMS(MSSer.getALL());
        } else if (cbGener.getSelectedIndex() == 3) {//dsp
            DongSP dsp = new DongSP();
            dsp.setMa(txtMa_ttsp.getText());
            dsp.setTen(txtTen_ttsp.getText());
            if (dongSPSer.Add(dsp)) {
                helper.alert(this, "Thêm DSP thành công!");
            } else {
                helper.error(this, "Thêm DSP thất bại vui lòng kiểm tra lại");
            }
            loadDataDongSP(dongSPSer.getALL());
        }
        loadCbMaSP();
        loadCbMaDSP();
        loadCbMaNSX();
        loadCbMaMS();
        load_QLSP_CTSP(ctspService.getbySP_NV());
    }//GEN-LAST:event_btnThem_ttspActionPerformed

    private void tbCTSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCTSPMouseClicked
        loadTextCTSP();
    }//GEN-LAST:event_tbCTSPMouseClicked

    private void lbl_viewAllctspMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_viewAllctspMousePressed
        lbl_viewAllctsp.setForeground(Color.red);
    }//GEN-LAST:event_lbl_viewAllctspMousePressed

    private void lbl_viewAllctspMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_viewAllctspMouseReleased
        lbl_viewAllctsp.setForeground(Color.black);
    }//GEN-LAST:event_lbl_viewAllctspMouseReleased

    private void PN_menu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PN_menu3MouseClicked
        cardLayout.show(main, "card3");
    }//GEN-LAST:event_PN_menu3MouseClicked

    private void btn_ctsp_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ctsp_themActionPerformed
        ///        DanhMuc danhMuc = (DanhMuc) cbDanhMuc.getSelectedItem();

        //System.out.println("id : " + danhMuc.getId());
        // System.out.println("Ten Danh Muc : " + danhMuc.getTenDanhMuc());
        ChiTietSP ctsp = new ChiTietSP();
        DongSP dsp = (DongSP) cbDSP_ctsp.getSelectedItem();
        NSX nsx = (NSX) cbNSX_ctsp.getSelectedItem();
        MauSac ms = (MauSac) cbMS_ctsp.getSelectedItem();
        SanPham sp = (SanPham) cbSP_ctsp.getSelectedItem();
        ctsp.setSanPham(sp);
        ctsp.setDongSP(dsp);
        ctsp.setMauSac(ms);
        ctsp.setNsx(nsx);
        ctsp.setNamBH(Integer.valueOf(txtNamBH_ctsp.getText()));
        ctsp.setSoLuongTon((int) spSlton_ctsp.getValue());
        ctsp.setMoTa(txtMoTa_ctsp.getText());
        ctsp.setGiaBan(BigDecimal.valueOf(Double.parseDouble(txtGiaBan_ctsp.getText())));
        ctsp.setGiaNhap(BigDecimal.valueOf(Double.parseDouble(txtGiaNhap_ctsp.getText())));
        ctsp.setMoTa(txtMoTa_ctsp.getText());
        if (ctspService.addCTSP(ctsp)) {
            helper.alert(this, "Thêm thành công");
        } else {
            helper.error(this, "Thêm thất bại");
        }
        load_QLSP_CTSP(ctspService.getbySP_NV());
    }//GEN-LAST:event_btn_ctsp_themActionPerformed

    private void btn_ttsp_timkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ttsp_timkiemActionPerformed

    }//GEN-LAST:event_btn_ttsp_timkiemActionPerformed

    private void btn_ctsp_capnhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ctsp_capnhatActionPerformed
        int row = tbCTSP.getSelectedRow();

        ChiTietSP ctsp = ctspService.getbySP_NV().get(row);
        DongSP dsp = (DongSP) cbDSP_ctsp.getSelectedItem();
        NSX nsx = (NSX) cbNSX_ctsp.getSelectedItem();
        MauSac ms = (MauSac) cbMS_ctsp.getSelectedItem();
        SanPham sp = (SanPham) cbSP_ctsp.getSelectedItem();

        ctsp.setSanPham(sp);
        ctsp.setDongSP(dsp);
        ctsp.setMauSac(ms);
        ctsp.setNsx(nsx);
        ctsp.setNamBH(Integer.valueOf(txtNamBH_ctsp.getText()));
        ctsp.setSoLuongTon((int) spSlton_ctsp.getValue());
        ctsp.setMoTa(txtMoTa_ctsp.getText());
        ctsp.setGiaBan(BigDecimal.valueOf(Double.parseDouble(txtGiaBan_ctsp.getText())));
        ctsp.setGiaNhap(BigDecimal.valueOf(Double.parseDouble(txtGiaNhap_ctsp.getText())));
        ctsp.setMoTa(txtMoTa_ctsp.getText());
        if (ctspService.updateCTSP(ctsp, ctsp.getId())) {
            helper.alert(this, "update thành công");
        } else {
            helper.error(this, "Update thất bại");
        }
        load_QLSP_CTSP(ctspService.getbySP_NV());
    }//GEN-LAST:event_btn_ctsp_capnhatActionPerformed

    private void btn_ctsp_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ctsp_xoaActionPerformed
        int row = tbCTSP.getSelectedRow();
        ChiTietSP ctsp = ctspService.getbySP_NV().get(row);

        if (ctspService.delete(ctsp.getId())) {
            helper.alert(this, "delete thành công");
        } else {
            helper.error(this, "delete thất bại");
        }
        load_QLSP_CTSP(ctspService.getbySP_NV());
    }//GEN-LAST:event_btn_ctsp_xoaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(view_deltais.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(view_deltais.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(view_deltais.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(view_deltais.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new view_deltais().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Menu;
    private javax.swing.JPanel PN_menu1;
    private javax.swing.JPanel PN_menu2;
    private javax.swing.JPanel PN_menu3;
    private javax.swing.JPanel PN_menu4;
    private javax.swing.JButton btnThem_ttsp;
    private javax.swing.JButton btn_ctsp_capnhat;
    private javax.swing.JButton btn_ctsp_them;
    private javax.swing.JButton btn_ctsp_timkiem;
    private javax.swing.JButton btn_ctsp_xoa;
    private javax.swing.JButton btn_ttsp_capnhat;
    private javax.swing.JButton btn_ttsp_timkiem;
    private javax.swing.JButton btn_ttsp_xoa;
    private javax.swing.JComboBox<String> cbDSP_ctsp;
    private javax.swing.JComboBox<String> cbGener;
    private javax.swing.JComboBox<String> cbMS_ctsp;
    private javax.swing.JComboBox<String> cbNSX_ctsp;
    private javax.swing.JComboBox<String> cbSP_ctsp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JLabel lblDangXuat;
    private javax.swing.JLabel lbl_title_gener;
    private javax.swing.JLabel lbl_viewAllctsp;
    private javax.swing.JPanel main;
    private javax.swing.JPanel pn_qlsp;
    private javax.swing.JPanel qlsp_ctsp;
    private javax.swing.JPanel qlsp_sp;
    private javax.swing.JSpinner spSlton_ctsp;
    private javax.swing.JTable tbCTSP;
    private javax.swing.JTable tbTTSP;
    private javax.swing.JTextField txtGiaBan_ctsp;
    private javax.swing.JTextField txtGiaNhap_ctsp;
    private javax.swing.JTextField txtMa_ttsp;
    private javax.swing.JTextField txtMoTa_ctsp;
    private javax.swing.JTextField txtNamBH_ctsp;
    private javax.swing.JTextField txtTen_ttsp;
    // End of variables declaration//GEN-END:variables
}
