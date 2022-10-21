/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Duanmau.Service.impl;

import Duanmau.DomainModels.NhanVien;
import Duanmau.Responsitories.NhanVienRepository;
import Duanmau.Service.NhanVienService;
import java.util.ArrayList;

/**
 *
 * @author AnhTiTan
 */
public class INhanVienServiceImpl implements NhanVienService {

    NhanVienRepository nhanvienrep = new NhanVienRepository();

    @Override
    public NhanVien getOne(String ma) {
        return nhanvienrep.getOne(ma);
    }

    @Override
    public Boolean AddNV(NhanVien nv) {
        return nhanvienrep.AddNV(nv);
    }

}
