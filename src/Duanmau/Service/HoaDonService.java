/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Duanmau.Service;

import Duanmau.DomainModels.HoaDon;
import java.util.List;

/**
 *
 * @author AnhTiTan
 */
public interface HoaDonService {

    public List<HoaDon> getAll();

    public Boolean addHD(HoaDon hd);

    public List<HoaDon> getHDbyTT(int TT) ;

    public HoaDon getHDbyMa(String ma);
}
