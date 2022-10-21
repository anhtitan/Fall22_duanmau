/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Duanmau.Responsitories;

import Duanmau.Utilies.DBConnection;
import Duanmau.DomainModels.NhanVien;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author AnhTiTan
 */
public class NhanVienRepository {

    private DBConnection connection;

    public NhanVien getOne(String ma) {
        NhanVien nv = null;
        String sql = "select ma, matkhau from NhanVien where ma = ?";
        try ( Connection con = connection.getConnection();  PreparedStatement ps = con.prepareCall(sql)) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                nv = new NhanVien(rs.getString(1), rs.getString(2));
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return nv;
    }
    public Boolean AddNV(NhanVien nv){
        String query = "insert into NhanVien ( ma, ten , tendem , ho, gioitinh, NgaySinh, diachi, sdt, MatKhau)\n" +
                        "values (?,?,?,?,?,?,?,?,?)";
        try(Connection con = connection.getConnection(); PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, nv.getMa());
            ps.setObject(2, nv.getTen());
            ps.setObject(3, nv.getTenDem());
            ps.setObject(4, nv.getHo());
            ps.setObject(5, nv.getGioiTinh());
            ps.setObject(6, nv.getNgaySinh());
            ps.setObject(7, nv.getDiaChi());
            ps.setObject(8, nv.getSdt());
            ps.setObject(9, nv.getMatKhau());
            ps.executeUpdate();
            return true;
            
        } catch (Exception e) {
        }
        return false;
    }
}
