/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Duanmau.Responsitories;

import Duanmau.Utilies.DBConnection;
import Duanmau.DomainModels.KhachHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author AnhTiTan
 */
public class KhachHangRepository {

    private DBConnection connection;

    public KhachHang getOne(String ma) {
        KhachHang kh = null;
        String sql = "select ma, matkhau from KhachHang where ma = ?";
        try ( Connection con = connection.getConnection();  PreparedStatement ps = con.prepareCall(sql)) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                kh = new KhachHang(rs.getString(1), rs.getString(2));
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return kh;
    }

    public Boolean addKH(KhachHang kh) {
        String query = "insert into KhachHang ( ma, ten , tendem, ho, NgaySinh, sdt ,diachi, thanhpho, quocgia , MatKhau) \n"
                + "values ( ?,?,?,?,?,?,?,?,?,?)";
        try ( Connection con = connection.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, kh.getMa());
            ps.setObject(2, kh.getTen());
            ps.setObject(3, kh.getTenDem());
            ps.setObject(4, kh.getHo());
            ps.setObject(5, kh.getNgaySinh());
            ps.setObject(6, kh.getSdt());
            ps.setObject(7, kh.getDiaChi());
            ps.setObject(8, kh.getThanhPho());
            ps.setObject(9, kh.getQuocGia());
            ps.setObject(10, kh.getMatKhau());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
        }
        return false;
    }
}
