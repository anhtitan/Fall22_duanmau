/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Duanmau.Service.impl;

import Duanmau.DomainModels.NSX;
import Duanmau.Responsitories.NSXRepository;
import Duanmau.Service.NSXService;
import java.util.ArrayList;

/**
 *
 * @author AnhTiTan
 */
public class INSXServicerImpl implements NSXService {
    
    private NSXRepository NSXRep = new NSXRepository();
    
    @Override
    public Boolean Delete(String ma) {
        return NSXRep.Delete(ma);
    }
    
    @Override
    public ArrayList<NSX> getALL() {
        return NSXRep.getAll();
    }
    
    @Override
    public Boolean Add(NSX nsx) {
        return NSXRep.AddNew(nsx);
    }
    
    @Override
    public Boolean update(NSX nsx, String ma) {
        return NSXRep.Update(ma, nsx);
    }
    
    @Override
    public NSX getNSXbyMS(String ma) {
        return NSXRep.getNSXbyMa(ma);
    }
    
}
