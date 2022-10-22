/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Duanmau.Service.impl;

import Duanmau.DomainModels.HoaDonChiTiet;
import Duanmau.Responsitories.HoaDonCTRepository;
import Duanmau.Service.HoaDonCTService;
import java.util.List;

/**
 *
 * @author AnhTiTan
 */
public class IHoaDonChiTietImpl implements HoaDonCTService {
    
    private HoaDonCTRepository hoaDonCTRep = new HoaDonCTRepository();
    
    @Override
    public List<HoaDonChiTiet> getAll() {
        return hoaDonCTRep.getAll();
    }
    
    @Override
    public Boolean addHDCT(HoaDonChiTiet hdct) {
        return hoaDonCTRep.Add(hdct);
    }
    
}
