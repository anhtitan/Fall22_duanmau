/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Duanmau.Service;

import Duanmau.DomainModels.NhanVien;
import java.util.ArrayList;

/**
 *
 * @author AnhTiTan
 */
public interface NhanVienService {

    public NhanVien getOne(String ma);

    public Boolean AddNV(NhanVien nv);
}
