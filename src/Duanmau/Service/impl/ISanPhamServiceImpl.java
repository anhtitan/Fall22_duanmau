/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Duanmau.Service.impl;

import Duanmau.DomainModels.SanPham;
import Duanmau.Responsitories.SanPhamRepository;
import Duanmau.Service.SanPhamService;
import java.util.ArrayList;

/**
 *
 * @author AnhTiTan
 */
public class ISanPhamServiceImpl implements SanPhamService {

    SanPhamRepository sanphamrep = new SanPhamRepository();

    @Override
    public ArrayList<SanPham> getAll() {
        return sanphamrep.getAll();
    }

    @Override
    public Boolean AddNew(SanPham sp) {
        return sanphamrep.AddNew(sp);
    }

    @Override
    public Boolean Delete(String ma) {
        return sanphamrep.Delete(ma);
    }

    @Override
    public Boolean Edit(String ma, SanPham sp) {
        return sanphamrep.Edit(ma, sp);
    }

    @Override
    public SanPham getSPbyMa(String ma) {
        return sanphamrep.getSPbyMa(ma);
    }

    @Override
    public Boolean Update(String ma, SanPham sp) {
        return sanphamrep.Update(ma, sp);
    }

}
