/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Duanmau.Service;

import Duanmau.DomainModels.ChucVu;
import java.util.ArrayList;

/**
 *
 * @author AnhTiTan
 */
public interface ChucVuService {

    public Boolean Delete(String ma);

    public ArrayList<ChucVu> getALL();

    public Boolean Add(ChucVu cv);

    public Boolean update(ChucVu cv, String ma);
}
