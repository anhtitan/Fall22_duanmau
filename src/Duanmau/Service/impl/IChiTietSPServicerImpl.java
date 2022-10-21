package Duanmau.Service.impl;

import Duanmau.DomainModels.ChiTietSP;
import Duanmau.Responsitories.ChiTietSPRepository;
import Duanmau.Service.ChiTietSPService;
import java.util.ArrayList;

/**
 *
 * @author AnhTiTan
 */
public class IChiTietSPServicerImpl implements ChiTietSPService {

    private ChiTietSPRepository ctsp = new ChiTietSPRepository();

    @Override
    public ArrayList<ChiTietSP> getbySP_NV() {
        return ctsp.getbySP_NV();
    }

    @Override
    public ArrayList<ChiTietSP> getbySP_KH() {
        return ctsp.getbySP_KH();
    }

    @Override
    public Boolean addCTSP(ChiTietSP ctspp) {
        return ctsp.addCTSP(ctspp);
    }

    @Override
    public Boolean updateCTSP(ChiTietSP ctspp, String id) {
        return ctsp.updateCTSP(ctspp, id);
    }

    @Override
    public Boolean delete(String id) {
        return ctsp.deleteCTSP(id);
    }

}
