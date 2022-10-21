package Duanmau.Responsitories;

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
public class DongSPRepository {

    private DBConnection connection;

    public ArrayList<DongSP> getAll() {
        ArrayList<DongSP> list_all = new ArrayList<>();

        String sql = "select id, ma, ten from DongSP";

        try ( Connection con = connection.getConnection();  PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DongSP dsp = new DongSP();
                dsp.setId(rs.getString(1));
                dsp.setMa(rs.getString(2));
                dsp.setTen(rs.getString(3));
                list_all.add(dsp);
            }

        } catch (Exception e) {
            e.getMessage();
        }
        return list_all;
    }

    public Boolean Edit(String ma, DongSP dsp) {

        String sql = "update DongSP set Ten = ? where Ma = ?";
        try ( Connection con = connection.getConnection();  PreparedStatement ps = con.prepareCall(sql)) {
            ps.setObject(1, dsp.getTen());
            ps.setObject(2, ma);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.getMessage();
        }

        return false;
    }

    public Boolean Delete(String ma) {

        String sql = "DELETE FROM CHITIETSP WHERE IdDongSP = ? DELETE FROM DongSP WHERE ID = ?";
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

    public Boolean AddNew(DongSP dsp) {
        String sql = "insert into DongSP(Ma,ten) values (?,?)";
        try ( Connection con = connection.getConnection();  PreparedStatement ps = con.prepareCall(sql)) {
            ps.setObject(1, dsp.getMa());
            ps.setObject(2, dsp.getTen());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.getMessage();
        }
        return false;
    }

    public static void main(String[] args) {

        ArrayList<DongSP> list = new DongSPRepository().getAll();
        for (DongSP x : list) {
            System.out.println(x);
        }
    }

    public DongSP getDSPbyMa(String ma) {
        DongSP dsp = null;
        String sql = "select id, ma , ten from DongSP where ma =?";
        try ( Connection con = connection.getConnection();  PreparedStatement ps = con.prepareCall(sql)) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                dsp = new DongSP(rs.getString(1), rs.getString(2), rs.getString(3));
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return dsp;
    }
        public Boolean Update(String ma, DongSP dsp) {

        String sql = "update DongSP set ten = ? where ma = ?";
        try ( Connection con = connection.getConnection();  PreparedStatement ps = con.prepareCall(sql)) {
            ps.setObject(1, dsp.getTen());
            ps.setObject(2, ma);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
