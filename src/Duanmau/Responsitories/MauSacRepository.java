/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Duanmau.Responsitories;

import Duanmau.DomainModels.MauSac;
import Duanmau.DomainModels.NSX;
import Duanmau.Utilies.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author AnhTiTan
 */
public class MauSacRepository {

    private DBConnection connection;

    public ArrayList<MauSac> getAll() {
        ArrayList<MauSac> list_all = new ArrayList<>();

        String sql = "select id, ma, ten from mauSac";

        try ( Connection con = connection.getConnection();  PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MauSac ms = new MauSac();
                ms.setId(rs.getString(1));
                ms.setMa(rs.getString(2));
                ms.setTen(rs.getString(3));
                list_all.add(ms);
            }

        } catch (Exception e) {
            e.getMessage();
        }
        return list_all;
    }

    public Boolean Edit(String ma, MauSac ms) {

        String sql = "update MauSac set Ten = ? where Ma = ?";
        try ( Connection con = connection.getConnection();  PreparedStatement ps = con.prepareCall(sql)) {
            ps.setObject(1, ms.getTen());
            ps.setObject(2, ma);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.getMessage();
        }

        return false;
    }

    public Boolean Delete(String ma) {

        String sql = "DELETE FROM CHITIETSP WHERE IDMauSac = ? DELETE FROM MauSac WHERE ID = ?";
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

    public Boolean AddNew(MauSac ms) {
        String sql = "insert into MauSac(Ma,ten) values (?,?)";
        try ( Connection con = connection.getConnection();  PreparedStatement ps = con.prepareCall(sql)) {
            ps.setObject(1, ms.getMa());
            ps.setObject(2, ms.getTen());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.getMessage();
        }
        return false;
    }

    public static void main(String[] args) {

        ArrayList<MauSac> list = new MauSacRepository().getAll();
        for (MauSac x : list) {
            System.out.println(x);
        }
    }

    public MauSac getMSbyMa(String ma) {
        MauSac ms = null;
        String sql = "select id, ma , ten from MauSac where ma =?";
        try ( Connection con = connection.getConnection();  PreparedStatement ps = con.prepareCall(sql)) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ms = new MauSac(rs.getString(1), rs.getString(2), rs.getString(3));
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return ms;
    }

    public Boolean Update(String ma, MauSac ms) {

        String sql = "update mausac set ten = ? where ma = ?";
        try ( Connection con = connection.getConnection();  PreparedStatement ps = con.prepareCall(sql)) {
            ps.setObject(1, ms.getTen());
            ps.setObject(2, ma);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
