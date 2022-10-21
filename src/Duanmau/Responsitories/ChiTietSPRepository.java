/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Duanmau.Responsitories;

import Duanmau.DomainModels.ChiTietSP;
import Duanmau.DomainModels.DongSP;
import Duanmau.DomainModels.MauSac;
import Duanmau.DomainModels.NSX;
import Duanmau.DomainModels.SanPham;
import Duanmau.Utilies.DBConnection;
import Duanmau.ViewModels.CTSanPhamResponse;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author AnhTiTan
 */
public class ChiTietSPRepository {

    private DBConnection connection;

    public ArrayList<ChiTietSP> getbySP_NV() {
        ArrayList<ChiTietSP> list_CTSP = new ArrayList<>();
        String sql = "select * From ChiTietSP A JOIN SANPHAM B ON A.IDSP = B.ID JOIN NSX C ON A.IDNSX = C.ID JOIN MAUSAC D ON A.IDMAUSAC = D.ID JOIN DONGSP E ON A.IDDONGSP = E.ID";
        try ( Connection con = connection.getConnection();  PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham(rs.getString(11), rs.getString(12), rs.getString(13));

                NSX nsx = new NSX(rs.getString(14), rs.getString(15), rs.getString(16));

                MauSac ms = new MauSac(rs.getString(17), rs.getString(18), rs.getString(19));

                DongSP dsp = new DongSP(rs.getString(20), rs.getString(21), rs.getString(22));

                list_CTSP.add(new ChiTietSP(rs.getString(1), sp, nsx, ms, dsp, rs.getInt(6), rs.getString(7), rs.getInt(8), rs.getBigDecimal(9), rs.getBigDecimal(10)));

            }

        } catch (Exception e) {
            e.getMessage();
        }
        return list_CTSP;
    }

    public ArrayList<ChiTietSP> getbySP_KH() {
        ArrayList<ChiTietSP> list_CTSP = new ArrayList<>();
        String sql = "select sanpham.ma, sanpham.ten, chitietsp.namBH, ChiTietSP.SoLuongTon,ChiTietSP.GiaBan,chitietsp.moTa\n"
                + "from ChiTietSP inner join  sanpham on sanpham.id = ChiTietSP.IDsp";
        try ( Connection con = connection.getConnection();  PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChiTietSP ctsp = new ChiTietSP();

                SanPham sp = new SanPham();

                sp.setMa(rs.getString(1));
                sp.setTen(rs.getString(2));
                ctsp.setSanPham(sp);

                ctsp.setNamBH(rs.getInt(3));
                ctsp.setSoLuongTon(rs.getInt(4));
                ctsp.setGiaBan(rs.getBigDecimal(5));
                ctsp.setMoTa(rs.getString(6));

                list_CTSP.add(ctsp);
            }

        } catch (Exception e) {
            e.getMessage();
        }
        return list_CTSP;
    }

    public Boolean addCTSP(ChiTietSP ctsp) {
        String sql = "INSERT INTO ChiTietSP ( IdSP, IdNsx, IdMauSac, IdDongSP, NamBH, MoTa, SoLuongTon, GiaNhap, GiaBan) VALUES (?,?,?,?,?,?,?,?,?)";
        try ( Connection con = connection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, ctsp.getSanPham().getID());
            ps.setObject(2, ctsp.getNsx().getId());
            ps.setObject(3, ctsp.getMauSac().getId());
            ps.setObject(4, ctsp.getDongSP().getId());
            ps.setObject(5, ctsp.getNamBH());
            ps.setObject(6, ctsp.getMoTa());
            ps.setObject(7, ctsp.getSoLuongTon());
            ps.setObject(8, ctsp.getGiaNhap());
            ps.setObject(9, ctsp.getGiaBan());

            ps.executeUpdate();

            return true;
        } catch (Exception e) {

            e.printStackTrace(System.out);
        }
        return false;
    }

    public Boolean updateCTSP(ChiTietSP ctsp, String id) {
        String sql = "UPDATE ChiTietSP SET IdSP = ?, IdNsx = ?, IdMauSac = ?,"
                + " IdDongSP = ?, NamBH = ?, MoTa = ?, SoLuongTon = ?,"
                + " GiaNhap = ?, GiaBan = ? WHERE ID = ?";
        try ( Connection con = connection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, ctsp.getSanPham().getID());
            ps.setObject(2, ctsp.getNsx().getId());
            ps.setObject(3, ctsp.getMauSac().getId());
            ps.setObject(4, ctsp.getDongSP().getId());
            ps.setObject(5, ctsp.getNamBH());
            ps.setObject(6, ctsp.getMoTa());
            ps.setObject(7, ctsp.getSoLuongTon());
            ps.setObject(8, ctsp.getGiaNhap());
            ps.setObject(9, ctsp.getGiaBan());
            ps.setObject(10, id);

            ps.executeUpdate();

            return true;
        } catch (Exception e) {

            e.printStackTrace(System.out);
        }
        return false;
    }

    public Boolean deleteCTSP(String id) {
        String sql = "DELETE FROM CHITIETSP WHERE ID = ?";
        try ( Connection con = connection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, id);
            ps.executeUpdate();

            return true;
        } catch (Exception e) {

            e.printStackTrace(System.out);
        }
        return false;
    }

    public static void main(String[] args) {

        ArrayList<ChiTietSP> list = new ChiTietSPRepository().getbySP_NV();
        for (ChiTietSP x : list) {
            System.out.println(x);
        }
    }
}
