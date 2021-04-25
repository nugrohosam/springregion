package com.nugrohosamiyono.springregion.Routes;

import com.nugrohosamiyono.springregion.Controllers.CityController;
import com.nugrohosamiyono.springregion.Controllers.CountryController;
import com.nugrohosamiyono.springregion.Controllers.DistrictController;
import com.nugrohosamiyono.springregion.Controllers.StateController;
import com.nugrohosamiyono.springregion.Controllers.VillageController;
import com.nugrohosamiyono.springregion.Global.Roles.AdminRole;

import com.nugrohosamiyono.springregion.Middlewares.AuthorizationMiddleware;

import java.util.HashMap;
import java.util.Map;

public class RouteRule {

    private static String cityControllerName = (new CityController()).getClass().getCanonicalName();
    private static String districtControllerName = (new DistrictController()).getClass().getCanonicalName();
    private static String stateControllerName = (new StateController()).getClass().getCanonicalName();
    private static String countryControllerName = (new CountryController()).getClass().getCanonicalName();
    private static String villageControllerName = (new VillageController()).getClass().getCanonicalName();

    private static Rule adminRouteRule = new Rule(new String[] { AuthorizationMiddleware.API },
            new String[] { AdminRole.NAME });

    public static Map<String, Rule> routes = new HashMap<>() {
        {
            put(cityControllerName + ":show", adminRouteRule);
            put(cityControllerName + ":index", adminRouteRule);
            put(cityControllerName + ":store", adminRouteRule);
            put(cityControllerName + ":update", adminRouteRule);
            put(cityControllerName + ":delete", adminRouteRule);

            put(countryControllerName + ":show", adminRouteRule);
            put(countryControllerName + ":index", adminRouteRule);
            put(countryControllerName + ":store", adminRouteRule);
            put(countryControllerName + ":update", adminRouteRule);
            put(countryControllerName + ":delete", adminRouteRule);

            put(stateControllerName + ":show", adminRouteRule);
            put(stateControllerName + ":index", adminRouteRule);
            put(stateControllerName + ":store", adminRouteRule);
            put(stateControllerName + ":update", adminRouteRule);
            put(stateControllerName + ":delete", adminRouteRule);

            put(villageControllerName + ":show", adminRouteRule);
            put(villageControllerName + ":index", adminRouteRule);
            put(villageControllerName + ":store", adminRouteRule);
            put(villageControllerName + ":update", adminRouteRule);
            put(villageControllerName + ":delete", adminRouteRule);

            put(districtControllerName + ":show", adminRouteRule);
            put(districtControllerName + ":index", adminRouteRule);
            put(districtControllerName + ":store", adminRouteRule);
            put(districtControllerName + ":update", adminRouteRule);
            put(districtControllerName + ":delete", adminRouteRule);
        }
    };
}
