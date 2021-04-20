package com.nugrohosamiyono.springregion.Applications;

import com.nugrohosamiyono.springregion.ThirdParty.Rajaongkir.Models.Province.RajaOngkirListProvince;
import com.nugrohosamiyono.springregion.ThirdParty.Rajaongkir.Serivces.ProvinceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RajaOngkirApplication {

    @Autowired
    ProvinceService provinceServie;

    public RajaOngkirListProvince getProvince() throws Exception {
        return (RajaOngkirListProvince)provinceServie.getProvince();
    }

    public void detailProvince(int id) throws Exception {
        provinceServie.detailProvince(id);
    }

}
