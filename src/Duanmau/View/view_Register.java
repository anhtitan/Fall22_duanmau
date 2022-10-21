/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Duanmau.View;

import Duanmau.DomainModels.KhachHang;
import Duanmau.DomainModels.NhanVien;
import Duanmau.Service.KhachHangService;
import Duanmau.Service.NhanVienService;
import Duanmau.Service.impl.IKhachHangServiceImpl;
import Duanmau.Service.impl.INhanVienServiceImpl;
import java.awt.CardLayout;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

/**
 *
 * @author AnhTiTan
 */
public class view_Register extends javax.swing.JFrame {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private NhanVienService nhanVienService = new INhanVienServiceImpl();
    private KhachHangService khachHangService = new IKhachHangServiceImpl();
    CardLayout cardLayout;

    public view_Register() {
        initComponents();
        setLocationRelativeTo(null);
        cardLayout = (CardLayout) main.getLayout();
        cardLayout.show(main, "cardNV");
        menu.setBackground(Color.GRAY);
        jPKH.setBackground(Color.GRAY);

        GroupGTNV();

    }
    ButtonGroup buttonGroupKH = new ButtonGroup();
    ButtonGroup buttonGroupNV = new ButtonGroup();

    private void GroupGTNV() {
        buttonGroupNV.add(rdNamNV);
        buttonGroupNV.add(rdNuNV);
    }

    private Boolean ValidateNV() {
        try {
            sdf.parse(txtNgSinhNV.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ngày sinh không hợp lệ");
            return false;
        }
        if (nhanVienService.getOne(txtMaNV.getText()) != null) {
            JOptionPane.showMessageDialog(this, "Tên đăng nhập: " + txtMaNV.getText() + " đã tồn tại. Vui lòng đăng ký bằng tên đăng nhập khác!");
            return false;
        }
        return true;
    }

    private Boolean ValidateKH() {
        try {
            sdf.parse(txtNgSinhKH.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ngày sinh không hợp lệ");
            return false;
        }
        if (khachHangService.getOne(txtMaKH.getText()) != null) {
            JOptionPane.showMessageDialog(this, "Tên đăng nhập: " + txtMaKH.getText() + " đã tồn tại. Vui lòng đăng ký bằng tên đăng nhập khác!");
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        main = new javax.swing.JPanel();
        PN_NV = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTenNV = new javax.swing.JTextField();
        txtTenDemNV = new javax.swing.JTextField();
        txtHoNV = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDCNV = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtSDTNV = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtNgSinhNV = new javax.swing.JTextField();
        rdNamNV = new javax.swing.JRadioButton();
        rdNuNV = new javax.swing.JRadioButton();
        txtMK_NV = new javax.swing.JPasswordField();
        btnDKNV = new javax.swing.JButton();
        Cancel = new javax.swing.JButton();
        PN_KH = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtTenKH = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtTenDemKH = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtHoKH = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtNgSinhKH = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtDCKH = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtMK_KH = new javax.swing.JPasswordField();
        btnDK_KH = new javax.swing.JButton();
        btnCancelKH = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        cbThanhPho_KH = new javax.swing.JComboBox<>();
        cbQuocGia_KH = new javax.swing.JComboBox<>();
        txtSDT_KH = new javax.swing.JTextField();
        menu = new javax.swing.JPanel();
        jPNV = new javax.swing.JPanel();
        lblNV = new javax.swing.JLabel();
        jPKH = new javax.swing.JPanel();
        lblKH = new javax.swing.JLabel();
        lblBack = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        main.setLayout(new java.awt.CardLayout());

        PN_NV.setBackground(new java.awt.Color(255, 255, 255));
        PN_NV.setForeground(new java.awt.Color(204, 204, 204));

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Đăng Ký Tài Khoản Nhân viên");

        jLabel3.setText("Mã:");

        txtMaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaNVActionPerformed(evt);
            }
        });

        jLabel4.setText("Tên:");

        jLabel5.setText("Tên Đệm:");

        jLabel6.setText("Họ:");

        jLabel7.setText("Giới Tính");

        txtDCNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDCNVActionPerformed(evt);
            }
        });

        jLabel8.setText("Địa Chỉ");

        jLabel9.setText("SDT");

        txtSDTNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSDTNVActionPerformed(evt);
            }
        });

        jLabel10.setText("Mật Khẩu");

        jLabel14.setText("Ngày Sinh");

        txtNgSinhNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgSinhNVActionPerformed(evt);
            }
        });

        rdNamNV.setBackground(new java.awt.Color(255, 255, 255));
        rdNamNV.setText("Nam");
        rdNamNV.setFocusPainted(false);

        rdNuNV.setBackground(new java.awt.Color(255, 255, 255));
        rdNuNV.setText("Nữ");
        rdNuNV.setFocusPainted(false);

        btnDKNV.setText("Đăng Ký");
        btnDKNV.setFocusable(false);
        btnDKNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDKNVActionPerformed(evt);
            }
        });

        Cancel.setText("Cancel");
        Cancel.setFocusable(false);

        javax.swing.GroupLayout PN_NVLayout = new javax.swing.GroupLayout(PN_NV);
        PN_NV.setLayout(PN_NVLayout);
        PN_NVLayout.setHorizontalGroup(
            PN_NVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
            .addGroup(PN_NVLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(PN_NVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PN_NVLayout.createSequentialGroup()
                        .addComponent(btnDKNV)
                        .addGap(69, 69, 69)
                        .addComponent(Cancel))
                    .addGroup(PN_NVLayout.createSequentialGroup()
                        .addGroup(PN_NVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PN_NVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMaNV)
                            .addComponent(txtDCNV, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                            .addComponent(txtSDTNV, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                            .addComponent(txtNgSinhNV, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                            .addGroup(PN_NVLayout.createSequentialGroup()
                                .addGroup(PN_NVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(PN_NVLayout.createSequentialGroup()
                                        .addComponent(rdNamNV, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(rdNuNV, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(PN_NVLayout.createSequentialGroup()
                                        .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTenDemNV, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtHoNV, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtMK_NV))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PN_NVLayout.setVerticalGroup(
            PN_NVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PN_NVLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(PN_NVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(PN_NVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenDemNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHoNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(PN_NVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(rdNamNV)
                    .addComponent(rdNuNV))
                .addGap(22, 22, 22)
                .addGroup(PN_NVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtNgSinhNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(PN_NVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtDCNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(PN_NVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtSDTNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(PN_NVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtMK_NV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(PN_NVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDKNV)
                    .addComponent(Cancel))
                .addGap(0, 53, Short.MAX_VALUE))
        );

        main.add(PN_NV, "cardNV");

        PN_KH.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(51, 51, 51));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Đăng Ký Tài Khoản Khách Hàng");

        jLabel11.setText("Mã:");

        txtMaKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaKHActionPerformed(evt);
            }
        });

        jLabel12.setText("Tên:");

        jLabel13.setText("Tên Đệm:");

        jLabel15.setText("Họ:");

        jLabel16.setText("SDT");

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("Ngày Sinh");

        txtNgSinhKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgSinhKHActionPerformed(evt);
            }
        });

        jLabel18.setText("Địa Chỉ");

        txtDCKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDCKHActionPerformed(evt);
            }
        });

        jLabel19.setText("Thành Phố");

        jLabel20.setText("Mật Khẩu");

        btnDK_KH.setText("Đăng Ký");
        btnDK_KH.setFocusable(false);
        btnDK_KH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDK_KHActionPerformed(evt);
            }
        });

        btnCancelKH.setText("Cancel");
        btnCancelKH.setFocusable(false);

        jLabel21.setText("Quốc Gia");

        cbThanhPho_KH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "An Giang", "Bà Rịa – Vũng Tàu", "Bắc Giang", "Bắc Kạn", "Bạc Liêu", "Bắc Ninh", "Bến Tre", "Bình Định", "Bình Dương", "Bình Phước", "Bình Thuận", "Cà Mau", "Cần Thơ", "Cao Bằng", "Đà Nẵng", "Đắk Lắk", "Đắk Nông", "Điện Biên", "Đồng Nai", "Đồng Tháp", "Gia Lai", "Hà Giang", "Hà Nam", "Hà Nội", "Hà Tĩnh", "Hải Dương", "Hải Phòng", "Hậu Giang", "Hòa Bình", "Hưng Yên", "Khánh Hòa", "Kiên Giang", "Kon Tum", "Lai Châu", "Lâm Đồng", "Lạng Sơn", "Lào Cai", "Long An", "Nam Định", "Nghệ An", "Ninh Bình", "Ninh Thuận", "Phú Thọ", "Phú Yên", "Quảng Bình", "Quảng Nam", "Quảng Ngãi", "Quảng Ninh", "Quảng Trị", "Sóc Trăng", "Sơn La", "Tây Ninh", "Thái Bình", "Thái Nguyên", "Thanh Hóa", "Thừa Thiên Huế", "Tiền Giang", "TP Hồ Chí Minh", "Trà Vinh", "Tuyên Quang", "Vĩnh Long", "Vĩnh Phúc", "Yên Bái" }));

        cbQuocGia_KH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Việt Nam" }));
        cbQuocGia_KH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbQuocGia_KHActionPerformed(evt);
            }
        });

        txtSDT_KH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSDT_KHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PN_KHLayout = new javax.swing.GroupLayout(PN_KH);
        PN_KH.setLayout(PN_KHLayout);
        PN_KHLayout.setHorizontalGroup(
            PN_KHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
            .addGroup(PN_KHLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PN_KHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PN_KHLayout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PN_KHLayout.createSequentialGroup()
                        .addGroup(PN_KHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PN_KHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(PN_KHLayout.createSequentialGroup()
                                    .addGroup(PN_KHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel19))
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(PN_KHLayout.createSequentialGroup()
                                    .addGroup(PN_KHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel20))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(PN_KHLayout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(28, 28, 28)))
                        .addGroup(PN_KHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PN_KHLayout.createSequentialGroup()
                                .addComponent(txtNgSinhKH, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(PN_KHLayout.createSequentialGroup()
                                .addGroup(PN_KHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(PN_KHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(PN_KHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cbQuocGia_KH, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cbThanhPho_KH, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PN_KHLayout.createSequentialGroup()
                                            .addComponent(btnDK_KH)
                                            .addGap(52, 52, 52)
                                            .addComponent(btnCancelKH))
                                        .addComponent(txtMK_KH, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                                        .addComponent(txtSDT_KH)
                                        .addGroup(PN_KHLayout.createSequentialGroup()
                                            .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(23, 23, 23)
                                            .addComponent(txtTenDemKH, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(11, 11, 11)
                                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtHoKH))
                                        .addComponent(txtDCKH)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        PN_KHLayout.setVerticalGroup(
            PN_KHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PN_KHLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(PN_KHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(PN_KHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12)
                    .addComponent(jLabel15)
                    .addComponent(txtHoKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenDemKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(PN_KHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSDT_KH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(18, 18, 18)
                .addGroup(PN_KHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtNgSinhKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PN_KHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtDCKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(PN_KHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbThanhPho_KH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(18, 18, 18)
                .addGroup(PN_KHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbQuocGia_KH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addGap(18, 18, 18)
                .addGroup(PN_KHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMK_KH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addGap(47, 47, 47)
                .addGroup(PN_KHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDK_KH)
                    .addComponent(btnCancelKH))
                .addGap(29, 29, 29))
        );

        main.add(PN_KH, "cardKH");

        menu.setBackground(new java.awt.Color(204, 204, 204));

        lblNV.setBackground(new java.awt.Color(255, 255, 255));
        lblNV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNV.setText("Nhân Viên");
        lblNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNVMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPNVLayout = new javax.swing.GroupLayout(jPNV);
        jPNV.setLayout(jPNVLayout);
        jPNVLayout.setHorizontalGroup(
            jPNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPNVLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNV, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPNVLayout.setVerticalGroup(
            jPNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPNVLayout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(lblNV, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        lblKH.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblKH.setText("Khách Hàng");
        lblKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblKHMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPKHLayout = new javax.swing.GroupLayout(jPKH);
        jPKH.setLayout(jPKHLayout);
        jPKHLayout.setHorizontalGroup(
            jPKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPKHLayout.setVerticalGroup(
            jPKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblKH, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        lblBack.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lblBack.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblBack.setText("Quay Lại");
        lblBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBackMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(menuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBack, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBack)
                .addGap(35, 35, 35)
                .addComponent(jPNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(main, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(main, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNVMouseClicked
        cardLayout.show(main, "cardNV");
        jPNV.setBackground(Color.lightGray);
        jPKH.setBackground(Color.gray);
    }//GEN-LAST:event_lblNVMouseClicked

    private void lblKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKHMouseClicked
        cardLayout.show(main, "cardKH");
        jPKH.setBackground(Color.lightGray);
        jPNV.setBackground(Color.gray);
    }//GEN-LAST:event_lblKHMouseClicked

    private void txtSDTNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSDTNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSDTNVActionPerformed

    private void txtDCNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDCNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDCNVActionPerformed

    private void txtMaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaNVActionPerformed

    private void txtNgSinhNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgSinhNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgSinhNVActionPerformed

    private void txtMaKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaKHActionPerformed

    private void txtNgSinhKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgSinhKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgSinhKHActionPerformed

    private void txtDCKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDCKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDCKHActionPerformed

    private void cbQuocGia_KHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbQuocGia_KHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbQuocGia_KHActionPerformed

    private void btnDKNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDKNVActionPerformed
        if (ValidateNV()) {
            try {
                NhanVien nv = new NhanVien();
                nv.setMa(txtMaNV.getText());
                nv.setTen(txtTenNV.getText());
                nv.setTenDem(txtTenDemNV.getText());
                nv.setHo(txtHoNV.getText());
                String gt = "Nam";
                if (rdNuNV.isSelected()) {
                    gt = "Nữ";
                }
                nv.setGioiTinh(gt);
                nv.setDiaChi(txtDCNV.getText());
                nv.setNgaySinh(sdf.parse(txtNgSinhNV.getText()));
                String mk = new String(txtMK_NV.getPassword());
                nv.setMatKhau(mk);
                if (nhanVienService.AddNV(nv)) {
                    JOptionPane.showMessageDialog(this, "Đăng ký thành công!");
                } else {
                    JOptionPane.showMessageDialog(this, "Đăng ký thất bại");
                }
            } catch (Exception e) {
                e.getMessage();
            }
        }

    }//GEN-LAST:event_btnDKNVActionPerformed

    private void btnDK_KHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDK_KHActionPerformed
        if (ValidateKH()) {
            try {
                KhachHang kh = new KhachHang();
                kh.setMa(txtMaKH.getText());
                kh.setThanhPho((String) cbThanhPho_KH.getSelectedItem());
                kh.setQuocGia((String) cbQuocGia_KH.getSelectedItem());
                String mk = new String(txtMK_KH.getPassword());
                kh.setMatKhau(mk);
                kh.setMa(txtMaKH.getText());
                kh.setTen(txtTenKH.getText());
                kh.setTenDem(txtTenDemKH.getText());
                kh.setHo(txtHoKH.getText());
                kh.setSdt(txtSDT_KH.getText());
                kh.setDiaChi(txtDCKH.getText());
                kh.setNgaySinh(sdf.parse(txtNgSinhKH.getText()));
                if (khachHangService.addKH(kh)) {
                    JOptionPane.showMessageDialog(this, "Đăng ký thành công!");
                } else {
                    JOptionPane.showMessageDialog(this, "Đăng ký thất bại. Vui lòng thử lại!");
                }
            } catch (Exception e) {
                e.getMessage();
            }
        }
    }//GEN-LAST:event_btnDK_KHActionPerformed

    private void lblBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackMouseClicked
        new view_DangNhap().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblBackMouseClicked

    private void txtSDT_KHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSDT_KHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSDT_KHActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancel;
    private javax.swing.JPanel PN_KH;
    private javax.swing.JPanel PN_NV;
    private javax.swing.JButton btnCancelKH;
    private javax.swing.JButton btnDKNV;
    private javax.swing.JButton btnDK_KH;
    private javax.swing.JComboBox<String> cbQuocGia_KH;
    private javax.swing.JComboBox<String> cbThanhPho_KH;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPKH;
    private javax.swing.JPanel jPNV;
    private javax.swing.JLabel lblBack;
    private javax.swing.JLabel lblKH;
    private javax.swing.JLabel lblNV;
    private javax.swing.JPanel main;
    private javax.swing.JPanel menu;
    private javax.swing.JRadioButton rdNamNV;
    private javax.swing.JRadioButton rdNuNV;
    private javax.swing.JTextField txtDCKH;
    private javax.swing.JTextField txtDCNV;
    private javax.swing.JTextField txtHoKH;
    private javax.swing.JTextField txtHoNV;
    private javax.swing.JPasswordField txtMK_KH;
    private javax.swing.JPasswordField txtMK_NV;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtNgSinhKH;
    private javax.swing.JTextField txtNgSinhNV;
    private javax.swing.JTextField txtSDTNV;
    private javax.swing.JTextField txtSDT_KH;
    private javax.swing.JTextField txtTenDemKH;
    private javax.swing.JTextField txtTenDemNV;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtTenNV;
    // End of variables declaration//GEN-END:variables
}
