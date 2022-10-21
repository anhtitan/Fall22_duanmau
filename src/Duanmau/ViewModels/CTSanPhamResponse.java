package Duanmau.ViewModels;

import java.math.BigDecimal;

/**
 *
 * @author AnhTiTan
 */
public class CTSanPhamResponse {

    private String id;

    private String tenSP;

    private String tenDongSP;

    private String tenmMauSac;

    private String tenNSX;

    private int namBH;

    private String moTa;

    private int soLuongTon;

    private BigDecimal giaNhap;

    private BigDecimal giaBan;

    public CTSanPhamResponse() {
    }

    public CTSanPhamResponse(String id, String tenSP, String tenDongSP, String tenmMauSac, String tenNSX, int namBH, String moTa, int soLuongTon, BigDecimal giaNhap, BigDecimal giaBan) {
        this.id = id;
        this.tenSP = tenSP;
        this.tenDongSP = tenDongSP;
        this.tenmMauSac = tenmMauSac;
        this.tenNSX = tenNSX;
        this.namBH = namBH;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getTenDongSP() {
        return tenDongSP;
    }

    public void setTenDongSP(String tenDongSP) {
        this.tenDongSP = tenDongSP;
    }

    public String getTenmMauSac() {
        return tenmMauSac;
    }

    public void setTenmMauSac(String tenmMauSac) {
        this.tenmMauSac = tenmMauSac;
    }

    public String getTenNSX() {
        return tenNSX;
    }

    public void setTenNSX(String tenNSX) {
        this.tenNSX = tenNSX;
    }

    public int getNamBH() {
        return namBH;
    }

    public void setNamBH(int namBH) {
        this.namBH = namBH;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public BigDecimal getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(BigDecimal giaNhap) {
        this.giaNhap = giaNhap;
    }

    public BigDecimal getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(BigDecimal giaBan) {
        this.giaBan = giaBan;
    }

}
