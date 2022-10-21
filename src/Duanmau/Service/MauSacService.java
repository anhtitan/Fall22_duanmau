/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Duanmau.Service;

import Duanmau.DomainModels.MauSac;
import java.util.ArrayList;

/**
 *
 * @author AnhTiTan
 */
public interface MauSacService {

    public Boolean Delete(String ma);

    public ArrayList<MauSac> getALL();

    public Boolean Add(MauSac ms);

    public Boolean update(MauSac ms, String ma);
    
    public MauSac getMSbyMa(String ma);
}
