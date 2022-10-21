/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Duanmau.Service;

import Duanmau.DomainModels.CuaHang;
import java.util.ArrayList;

/**
 *
 * @author AnhTiTan
 */
public interface CuaHangService {

    public Boolean Delete(String ma);

    public ArrayList<CuaHang> getALL();

    public Boolean Add(CuaHang ch);
    
    public Boolean update(CuaHang ch, String ma);
}
