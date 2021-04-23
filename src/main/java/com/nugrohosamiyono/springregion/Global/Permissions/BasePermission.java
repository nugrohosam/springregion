package com.nugrohosamiyono.springregion.Global.Permissions;

import org.springframework.stereotype.Component;

@Component
public class BasePermission {
    public static final CountryPermission COUNTRY_PERMISSION = new CountryPermission();
    public static final StatePermission STATE_PERMISSION = new StatePermission();
    public static final CityPermission CITY_PERMISSION = new CityPermission();
    public static final DistrictPermission DISTRICT_PERMISSION = new DistrictPermission();
    public static final VillagePermission VILLAGE_PERMISSION = new VillagePermission();
}
