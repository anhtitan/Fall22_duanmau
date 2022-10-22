/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Duanmau.Responsitories;

import Duanmau.DomainModels.ChiTietSP;
import Duanmau.DomainModels.HoaDon;
import Duanmau.DomainModels.HoaDonChiTiet;
import Duanmau.Utilies.DBConnection;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

/**
 *
 * @author AnhTiTan
 */
public class HoaDonCTRepository {

    private DBConnection connection;

    public List<HoaDonChiTiet> getAll() {
        List<HoaDonChiTiet> list = new ArrayList<>();
        String query = "select * from HoaDonChiTiet a join HoaDon b on a.IdHoaDon= b.id join ChiTietSP c on a.IdChiTietSP = c.Id";
        try ( Connection con = connection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                //String id, String idKH, String idNV, String ma, Date ngayTao, Date ngayThanhToan, Date ngayShip, Date ngayNhan, int tinhTrang, String tenNguoiNhan, String diaChi, String sdt
                HoaDon hd = new HoaDon(rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getDate(9), rs.getDate(10), rs.getDate(11),rs.getDate(12),rs.getInt(13),rs.getString(14),rs.getString(15),rs.getString(16));
//                hd.setId(rs.getString(1));
//                hd.setMa(rs.getString(8));
//                hd.setNgayTao(rs.getDate(9));
//String id, SanPham sanPham, NSX nsx, MauSac mauSac, DongSP dongSP, 22 int namBH, String moTa, int soLuongTon, BigDecimal giaNhap, BigDecimal giaBan
                ChiTietSP ctsp = new ChiTietSP();
               // ChiTietSP ctsp = new ChiTietSP(rs.getString(17),rs.getString(18),rs.getString(19),rs.getString(20),rs.getString(21),rs.getInt(22),rs.getString(23),rs.getInt(24),rs.getBigDecimal(25),rs.getBigDecimal(26));
//                ctsp.setId(rs.getString(2));
                HoaDonChiTiet hdct = new HoaDonChiTiet(hd,ctsp,rs.getInt(3),rs.getDouble(4));
//                hdct.setSoLuong(rs.getInt("soLuong"));
//                hdct.setDonGia(rs.getDouble("donGia"));
                list.add(hdct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Boolean Add(HoaDonChiTiet hdct) {
        String query = "insert into HoaDonChiTiet (idHoaDon, IdChiTietSP, soluong, dongia) values (?,?,?,?)";
        try ( Connection con = connection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, hdct.getHoaDon().getId());
            ps.setObject(2, hdct.getChiTietSP().getId());
            ps.setObject(3, hdct.getSoLuong());
            ps.setObject(4, hdct.getDonGia());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public Boolean Update(HoaDonChiTiet hdct, String idHD,String idCTSP) {
        String query = "update HoaDonChitiet set soluong = ? where idHoaDon = ? and IdChiTietSP = ?";
        try ( Connection con = connection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, hdct.getHoaDon().getId());
            ps.setObject(2, hdct.getChiTietSP().getId());
            ps.setObject(3, hdct.getSoLuong());
            ps.setObject(4, hdct.getDonGia());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
