package Duanmau.Service.impl;

import Duanmau.DomainModels.HoaDon;
import Duanmau.Responsitories.HoaDonRepository;
import Duanmau.Service.HoaDonService;
import java.util.List;

/**
 *
 * @author AnhTiTan
 */
public class IHoaDonServiceImpl implements HoaDonService {

    private HoaDonRepository hd = new HoaDonRepository();

    @Override
    public List<HoaDon> getAll() {
        return hd.getAll();
    }

    @Override
    public Boolean addHD(HoaDon hdv) {
        return hd.addHD(hdv);
    }

    @Override
    public List<HoaDon> getHDbyTT(int TT) {
        return hd.getHDbyTT(TT);
    }

    @Override
    public HoaDon getHDbyMa(String ma) {
        return hd.getHDbyMa(ma);
    }
}
