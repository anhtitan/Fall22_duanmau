/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Duanmau.Service;

import Duanmau.DomainModels.DongSP;
import java.util.ArrayList;

/**
 *
 * @author AnhTiTan
 */
public interface DongSPService {

    public Boolean Delete(String ma);

    public ArrayList<DongSP> getALL();

    public Boolean Add(DongSP ch);

    public Boolean update(DongSP dsp, String ma);

    public DongSP getDSPbyMa(String ma);
}
