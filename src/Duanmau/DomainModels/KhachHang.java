
package Duanmau.DomainModels;

import java.util.Date;

/**
 *
 * @author AnhTiTan
 */
public class KhachHang {

    private String ID;
    private String ma;
    private String ten;
    private String tenDem;
    private String ho;
    private Date ngaySinh;
    private String sdt;
    private String diaChi;
    private String thanhPho;
    private String quocGia;
    private String matKhau;

    public KhachHang() {
    }

    public KhachHang(String ID, String ma, String ten, String tenDem, String ho, Date ngaySinh, String sdt, String diaChi, String thanhPho, String quocGia, String matKhau) {
        this.ID = ID;
        this.ma = ma;
        this.ten = ten;
        this.tenDem = tenDem;
        this.ho = ho;
        this.ngaySinh = ngaySinh;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.thanhPho = thanhPho;
        this.quocGia = quocGia;
        this.matKhau = matKhau;
    }

    public KhachHang(String ma, String matKhau) {
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

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getThanhPho() {
        return thanhPho;
    }

    public void setThanhPho(String thanhPho) {
        this.thanhPho = thanhPho;
    }

    public String getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(String quocGia) {
        this.quocGia = quocGia;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

}
