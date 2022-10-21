/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Duanmau.Responsitories;

import Duanmau.DomainModels.HoaDon;
import Duanmau.Utilies.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AnhTiTan
 */
public class HoaDonRepository {

    private DBConnection connection;

    public List<HoaDon> getAll() {
        List<HoaDon> list = new ArrayList<>();
        String sql = "select id, ma, ngaytao, tinhtrang from hoadon \n" +
"		order by cast(SUBSTRING(ma,3,len(ma)-2) as int) desc";
        try ( Connection con = connection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setId(rs.getString(1));
                hd.setMa(rs.getString(2));
                hd.setNgayTao(rs.getDate(3));
                hd.setTinhTrang(rs.getInt(4));

                list.add(hd);
            }
        } catch (Exception e) {

        }
        return list;
    }

    public Boolean addHD(HoaDon hd) {
        String query = "insert into hoadon(ma,ngaytao) values (?,?)";
        try ( Connection con = connection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, hd.getMa());
            ps.setObject(2, hd.getNgayTao());
            ps.executeUpdate();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public HoaDon getHDbyMa(String ma) {
        HoaDon hd = null;
        String query = "select id, ma, ngaytao, tinhtrang from HoaDon where ma = ?";
        try ( Connection con = connection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ma);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                hd = new HoaDon(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getInt(4));
            }
        } catch (Exception e) {
        }
        return hd;
    }

    public List<HoaDon> getHDbyTT(int TT) {
        List<HoaDon> list = new ArrayList<>();
        String query = "select id, ma, ngaytao, tinhtrang from HoaDon where tinhtrang = " + TT + "";
        try ( Connection con = connection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setId(rs.getString(1));
                hd.setMa(rs.getString(2));
                hd.setNgayTao(rs.getDate(3));
                hd.setTinhTrang(rs.getInt(4));

                list.add(hd);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public static void main(String[] args) {
        HoaDonRepository hd = new HoaDonRepository();
        for (HoaDon x : hd.getAll()) {
            System.out.println(x);
        }
    }
}
