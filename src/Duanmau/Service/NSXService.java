/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Duanmau.Service;

import Duanmau.DomainModels.NSX;
import java.util.ArrayList;

/**
 *
 * @author AnhTiTan
 */
public interface NSXService {

    public Boolean Delete(String ma);

    public ArrayList<NSX> getALL();

    public Boolean Add(NSX ms);

    public Boolean update(NSX nsx, String ma);
    
    public NSX getNSXbyMS(String ma);
}
