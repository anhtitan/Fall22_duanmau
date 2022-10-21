
package Duanmau.DomainModels;

/**
 *
 * @author AnhTiTan
 */
public class SanPham {

    private String ID;

    private String ma;

    private String ten;

    public SanPham() {
    }

    public SanPham(String ID, String ma, String ten) {
        this.ID = ID;
        this.ma = ma;
        this.ten = ten;
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

    @Override
    public String toString() {
        return ma;
    }

    
}
