/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Duanmau.Responsitories;

/**
 *
 * @author AnhTiTan
 */
import Duanmau.DomainModels.NSX;
import Duanmau.Utilies.DBConnection;

import java.sql.*;
import java.util.ArrayList;

public class NSXRepository {

    private DBConnection connection;

    public ArrayList<NSX> getAll() {
        ArrayList<NSX> list_all = new ArrayList<>();

        String sql = "select id, ma, ten from NSX";

        try ( Connection con = connection.getConnection();  PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NSX nsx = new NSX();
                nsx.setId(rs.getString(1));
                nsx.setMa(rs.getString(2));
                nsx.setTen(rs.getString(3));
                list_all.add(nsx);
            }

        } catch (Exception e) {
            e.getMessage();
        }
        return list_all;
    }

    public Boolean Edit(String ma, NSX nsx) {

        String sql = "update NSX set Ten = ? where Ma = ?";
        try ( Connection con = connection.getConnection();  PreparedStatement ps = con.prepareCall(sql)) {
            ps.setObject(1, nsx.getTen());
            ps.setObject(2, ma);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.getMessage();
        }

        return false;
    }

    public Boolean Delete(String ma) {

        String sql = "DELETE FROM CHITIETSP WHERE IDNSX = ? DELETE FROM NSX WHERE ID = ?";
        try ( Connection con = connection.getConnection();  PreparedStatement ps = con.prepareCall(sql)) {
            ps.setObject(1, ma);
            ps.setObject(2, ma);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public Boolean AddNew(NSX nsx) {
        String sql = "insert into NSX(Ma,ten) values (?,?)";
        try ( Connection con = connection.getConnection();  PreparedStatement ps = con.prepareCall(sql)) {
            ps.setObject(1, nsx.getMa());
            ps.setObject(2, nsx.getTen());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.getMessage();
        }
        return false;
    }

    public static void main(String[] args) {

        ArrayList<NSX> list = new NSXRepository().getAll();
        for (NSX x : list) {
            System.out.println(x);
        }
    }

    public NSX getNSXbyMa(String ma) {
        NSX nsx = null;
        String sql = "select id, ma , ten from NSX where ma =?";
        try ( Connection con = connection.getConnection();  PreparedStatement ps = con.prepareCall(sql)) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                nsx = new NSX(rs.getString(1), rs.getString(2), rs.getString(3));
                //sp = new SanPham(rs.getString("ma"), rs.getString("id"), rs.getString("ten"));
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return nsx;
    }

    public Boolean Update(String ma, NSX nsx) {

        String sql = "update NSX set ten = ? where ma = ?";
        try ( Connection con = connection.getConnection();  PreparedStatement ps = con.prepareCall(sql)) {
            ps.setObject(1, nsx.getTen());
            ps.setObject(2, ma);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
