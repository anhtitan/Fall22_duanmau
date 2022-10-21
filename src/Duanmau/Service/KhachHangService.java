/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Duanmau.Service;

import Duanmau.DomainModels.KhachHang;

/**
 *
 * @author AnhTiTan
 */
public interface KhachHangService {

    public KhachHang getOne(String ma);

    public Boolean addKH(KhachHang kh);
}
