/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Duanmau.Service.impl;

import Duanmau.DomainModels.MauSac;
import Duanmau.Responsitories.MauSacRepository;
import Duanmau.Service.MauSacService;
import java.util.ArrayList;

/**
 *
 * @author AnhTiTan
 */
public class IMauSacServiceImpl implements MauSacService {
    
    private MauSacRepository MSR = new MauSacRepository();
    
    @Override
    public Boolean Delete(String ma) {
        return MSR.Delete(ma);
    }
    
    @Override
    public ArrayList<MauSac> getALL() {
        return MSR.getAll();
    }
    
    @Override
    public Boolean Add(MauSac ms) {
        return MSR.AddNew(ms);
    }
    
    @Override
    public Boolean update(MauSac ms, String ma) {
        return MSR.Update(ma, ms);        
    }
    
    @Override
    public MauSac getMSbyMa(String ma) {
        return MSR.getMSbyMa(ma);
    }
    
}
