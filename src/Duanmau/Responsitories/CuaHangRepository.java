/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Duanmau.Responsitories;

import Duanmau.DomainModels.ChucVu;
import Duanmau.DomainModels.CuaHang;
import Duanmau.DomainModels.DongSP;
import Duanmau.Utilies.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author AnhTiTan
 */
public class CuaHangRepository {

    private DBConnection connection;

    public ArrayList<CuaHang> getAll() {
        ArrayList<CuaHang> list_all = new ArrayList<>();

        String sql = "select id, ma, ten from CuaHang";

        try ( Connection con = connection.getConnection();  PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CuaHang ch = new CuaHang();
                ch.setId(rs.getString(1));
                ch.setMa(rs.getString(2));
                ch.setTen(rs.getString(3));
                list_all.add(ch);
            }

        } catch (Exception e) {
            e.getMessage();
        }
        return list_all;
    }

    public Boolean Edit(String ma, CuaHang ch) {

        String sql = "update CuaHang set Ten = ? where Ma = ?";
        try ( Connection con = connection.getConnection();  PreparedStatement ps = con.prepareCall(sql)) {
            ps.setObject(1, ch.getTen());
            ps.setObject(2, ma);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.getMessage();
        }

        return false;
    }

    public Boolean Delete(String ma) {

        String sql = "Delete CuaHang where Ma = ?";
        try ( Connection con = connection.getConnection();  PreparedStatement ps = con.prepareCall(sql)) {
            ps.setObject(1, ma);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public Boolean AddNew(CuaHang ch) {
        String sql = "insert into CuaHang(Ma,ten) values (?,?)";
        try ( Connection con = connection.getConnection();  PreparedStatement ps = con.prepareCall(sql)) {
            ps.setObject(1, ch.getMa());
            ps.setObject(2, ch.getTen());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.getMessage();
        }
        return false;
    }

    public static void main(String[] args) {

        ArrayList<CuaHang> list = new CuaHangRepository().getAll();
        for (CuaHang x : list) {
            System.out.println(x);
        }
    }
}
