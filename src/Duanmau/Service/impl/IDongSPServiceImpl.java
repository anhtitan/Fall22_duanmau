/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Duanmau.Service.impl;

import Duanmau.DomainModels.DongSP;
import Duanmau.Responsitories.DongSPRepository;
import Duanmau.Service.DongSPService;
import java.util.ArrayList;

/**
 *
 * @author AnhTiTan
 */
public class IDongSPServiceImpl implements DongSPService {

    private DongSPRepository dongSPSer = new DongSPRepository();

    @Override
    public Boolean Delete(String ma) {
        return dongSPSer.Delete(ma);
    }

    @Override
    public ArrayList<DongSP> getALL() {
        return dongSPSer.getAll();
    }

    @Override
    public Boolean Add(DongSP ch) {
        return dongSPSer.AddNew(ch);
    }

    @Override
    public Boolean update(DongSP dsp, String ma) {
        return dongSPSer.Update(ma, dsp);
    }

    @Override
    public DongSP getDSPbyMa(String ma) {
        return dongSPSer.getDSPbyMa(ma);
    }

}
