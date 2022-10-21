/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Duanmau.Service;

import Duanmau.DomainModels.ChiTietSP;
import java.util.ArrayList;

/**
 *
 * @author AnhTiTan
 */
public interface ChiTietSPService {

    public ArrayList<ChiTietSP> getbySP_NV();

    public ArrayList<ChiTietSP> getbySP_KH();

    public Boolean addCTSP(ChiTietSP ctsp);

    public Boolean delete(String id);

    public Boolean updateCTSP(ChiTietSP ctsp, String id);

}
