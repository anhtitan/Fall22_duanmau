/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Duanmau.Service;

import Duanmau.DomainModels.SanPham;
import java.util.ArrayList;

/**
 *
 * @author AnhTiTan
 */
public interface SanPhamService {

    public ArrayList<SanPham> getAll();

    public Boolean AddNew(SanPham sp);

    public Boolean Delete(String ma);

    public Boolean Edit(String ma, SanPham sp);

    public SanPham getSPbyMa(String ma);
    
    public Boolean Update(String ma, SanPham sp);
}
