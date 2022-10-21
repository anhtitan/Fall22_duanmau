/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Duanmau.Responsitories;

import Duanmau.Utilies.DBConnection;
import Duanmau.DomainModels.ChiTietSP;
import Duanmau.DomainModels.SanPham;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AnhTiTan
 */
public class SanPhamRepository {

    private DBConnection connection;

    public ArrayList<SanPham> getAll() {
        ArrayList<SanPham> listAll = new ArrayList<>();
        String sql = "select id, ma, ten from sanpham";
        try ( Connection con = connection.getConnection();  PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setID(rs.getString(1));
                sp.setMa(rs.getString(2));
                sp.setTen(rs.getString(3));
                listAll.add(sp);
            }

        } catch (Exception e) {
            e.getMessage();
        }
        return listAll;
    }

    public Boolean Edit(String ma, SanPham sp) {

        String sql = "update sanpham set Ten = ? where Ma = ?";
        try ( Connection con = connection.getConnection();  PreparedStatement ps = con.prepareCall(sql)) {
            ps.setObject(1, sp.getTen());
            ps.setObject(2, ma);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.getMessage();
        }

        return false;
    }

    public Boolean Delete(String ma) {

        String sql = "DELETE FROM CHITIETSP WHERE IDSP = ? DELETE FROM SanPham WHERE ID = ? ";
        try ( Connection con = connection.getConnection();  PreparedStatement ps = con.prepareCall(sql)) {
            ps.setObject(1, ma);
            ps.setObject(2, ma);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            //e.printStackTrace();
            //return false;
        }

        return false;
    }

    public Boolean AddNew(SanPham sp) {
        String sql = "insert into SanPham(Ma,ten) values (?,?)";
        try ( Connection con = connection.getConnection();  PreparedStatement ps = con.prepareCall(sql)) {
            ps.setObject(1, sp.getMa());
            ps.setObject(2, sp.getTen());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.getMessage();
        }
        return false;
    }

    public static void main(String[] args) {
        SanPhamRepository spR = new SanPhamRepository();
        for (SanPham arg : spR.getAll()) {
            System.out.println(arg.getID());
        }
    }

    public SanPham getSPbyMa(String ma) {
        SanPham sp = null;
        String sql = "select id, ma , ten from SanPham where ma =?";
        try ( Connection con = connection.getConnection();  PreparedStatement ps = con.prepareCall(sql)) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                sp = new SanPham(rs.getString(1), rs.getString(2), rs.getString(3));
                //sp = new SanPham(rs.getString("ma"), rs.getString("id"), rs.getString("ten"));
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return sp;
    }
        public Boolean Update(String ma, SanPham sp) {

        String sql = "update SanPham set ten = ? where ma = ?";
        try ( Connection con = connection.getConnection();  PreparedStatement ps = con.prepareCall(sql)) {
            ps.setObject(1, sp.getTen());
            ps.setObject(2, ma);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
