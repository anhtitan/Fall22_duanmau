/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Duanmau.Service.impl;

import Duanmau.DomainModels.KhachHang;
import Duanmau.Responsitories.KhachHangRepository;
import Duanmau.Service.KhachHangService;

/**
 *
 * @author AnhTiTan
 */
public class IKhachHangServiceImpl implements KhachHangService {

    private KhachHangRepository khachHangRepository = new KhachHangRepository();

    @Override
    public KhachHang getOne(String ma) {
        return khachHangRepository.getOne(ma);
    }

    @Override
    public Boolean addKH(KhachHang kh) {
        return khachHangRepository.addKH(kh);
    }

}
