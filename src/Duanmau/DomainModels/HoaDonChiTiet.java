
package Duanmau.DomainModels;

/**
 *
 * @author AnhTiTan
 */
public class HoaDonChiTiet {
    private String idHoaDon;
    private String idChiTietSP;
    private int soLuong;
    private double donGia;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(String idHoaDon, String idChiTietSP, int soLuong, double donGia) {
        this.idHoaDon = idHoaDon;
        this.idChiTietSP = idChiTietSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public String getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(String idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public String getIdChiTietSP() {
        return idChiTietSP;
    }

    public void setIdChiTietSP(String idChiTietSP) {
        this.idChiTietSP = idChiTietSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }
    
}
/*
IdHoaDon UNIQUEIDENTIFIER,
IdChiTietSP UNIQUEIDENTIFIER,	
SoLuong INT,
DonGia DECIMAL(20,0) DEFAULT 0,
*/