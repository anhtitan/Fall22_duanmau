
package Duanmau.DomainModels;

import java.util.Date;

/**
 *
 * @author AnhTiTan
 */
public class NhanVien {

    private String ID;
    private String ma;
    private String ten;
    private String tenDem;
    private String ho;
    private String gioiTinh;
    private Date ngaySinh;
    private String diaChi;
    private String sdt;
    private String matKhau;
    private String idCH;
    private String idCV;
    private String idGuiBC;
    private int trangThai;

    public NhanVien() {
    }

    public NhanVien(String ID, String ma, String ten, String tenDem, String ho, String gioiTinh, String sdt, Date ngaySinh, String diaChi, String matKhau, String idCH, String idCV, String idGuiBC, int trangThai) {
        this.ID = ID;
        this.ma = ma;
        this.ten = ten;
        this.tenDem = tenDem;
        this.ho = ho;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.matKhau = matKhau;
        this.idCH = idCH;
        this.idCV = idCV;
        this.idGuiBC = idGuiBC;
        this.trangThai = trangThai;
    }

    public NhanVien(String ma, String matKhau) {
        this.ma = ma;
        this.matKhau = matKhau;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTenDem() {
        return tenDem;
    }

    public void setTenDem(String tenDem) {
        this.tenDem = tenDem;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getIdCH() {
        return idCH;
    }

    public void setIdCH(String idCH) {
        this.idCH = idCH;
    }

    public String getIdCV() {
        return idCV;
    }

    public void setIdCV(String idCV) {
        this.idCV = idCV;
    }

    public String getIdGuiBC() {
        return idGuiBC;
    }

    public void setIdGuiBC(String idGuiBC) {
        this.idGuiBC = idGuiBC;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }


}
