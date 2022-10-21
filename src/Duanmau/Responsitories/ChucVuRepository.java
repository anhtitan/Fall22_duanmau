/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Duanmau.Responsitories;

import Duanmau.DomainModels.ChiTietSP;
import Duanmau.DomainModels.ChucVu;
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
public class ChucVuRepository {

    private DBConnection connection;

    public ArrayList<ChucVu> getAll() {
        ArrayList<ChucVu> list_all = new ArrayList<>();

        String sql = "select id, ma, ten from ChucVu";

        try ( Connection con = connection.getConnection();  PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChucVu cv = new ChucVu();
                cv.setId(rs.getString(1));
                cv.setMa(rs.getString(2));
                cv.setTen(rs.getString(3));
                list_all.add(cv);
            }

        } catch (Exception e) {
            e.getMessage();
        }
        return list_all;
    }

    public Boolean Edit(String ma, ChucVu cv) {

        String sql = "update ChucVu set Ten = ? where Ma = ?";
        try ( Connection con = connection.getConnection();  PreparedStatement ps = con.prepareCall(sql)) {
            ps.setObject(1, cv.getTen());
            ps.setObject(2, ma);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.getMessage();
        }

        return false;
    }

    public Boolean Delete(String ma) {

        String sql = "Delete ChucVu where Ma = ?";
        try ( Connection con = connection.getConnection();  PreparedStatement ps = con.prepareCall(sql)) {
            ps.setObject(1, ma);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
    public Boolean Update(String ma, ChucVu cv) {

        String sql = "update chucvu set ten = ? where ma = ?";
        try ( Connection con = connection.getConnection();  PreparedStatement ps = con.prepareCall(sql)) {
            ps.setObject(1, cv.getTen());
            ps.setObject(2, ma);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public Boolean AddNew(ChucVu cv) {
        String sql = "insert into ChucVu(Ma,ten) values (?,?)";
        try ( Connection con = connection.getConnection();  PreparedStatement ps = con.prepareCall(sql)) {
            ps.setObject(1, cv.getMa());
            ps.setObject(2, cv.getTen());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.getMessage();
        }
        return false;
    }
        public static void main(String[] args) {

        ArrayList<ChucVu> list = new ChucVuRepository().getAll();
        for (ChucVu x : list) {
            System.out.println(x);
        }
    }
}
