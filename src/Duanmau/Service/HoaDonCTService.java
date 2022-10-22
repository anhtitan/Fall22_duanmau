/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Duanmau.Service;

import Duanmau.DomainModels.HoaDonChiTiet;
import java.util.List;

/**
 *
 * @author AnhTiTan
 */
public interface HoaDonCTService {

    public List<HoaDonChiTiet> getAll();

    public Boolean addHDCT(HoaDonChiTiet hdct);
}
