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

public class Route {

    private static String cityControllerName = (new CityController()).getClass().getCanonicalName();
    private static String districtControllerName = (new DistrictController()).getClass().getCanonicalName();
    private static String stateControllerName = (new StateController()).getClass().getCanonicalName();
    private static String countryControllerName = (new CountryController()).getClass().getCanonicalName();
    private static String villageControllerName = (new VillageController()).getClass().getCanonicalName();

    public static Map<String, DataRoute> routes = new HashMap<>() {
        {
            put(cityControllerName + ":show",
                    new DataRoute(new String[] { AuthorizationMiddleware.API }, new String[] { AdminRole.NAME }));
            put(cityControllerName + ":index",
                    new DataRoute(new String[] { AuthorizationMiddleware.API }, new String[] { AdminRole.NAME }));
            put(cityControllerName + ":store",
                    new DataRoute(new String[] { AuthorizationMiddleware.API }, new String[] { AdminRole.NAME }));
            put(cityControllerName + ":update",
                    new DataRoute(new String[] { AuthorizationMiddleware.API }, new String[] { AdminRole.NAME }));
            put(cityControllerName + ":delete",
                    new DataRoute(new String[] { AuthorizationMiddleware.API }, new String[] { AdminRole.NAME }));

            put(countryControllerName + ":show",
                    new DataRoute(new String[] { AuthorizationMiddleware.API }, new String[] { AdminRole.NAME }));
            put(countryControllerName + ":index",
                    new DataRoute(new String[] { AuthorizationMiddleware.API }, new String[] { AdminRole.NAME }));
            put(countryControllerName + ":store",
                    new DataRoute(new String[] { AuthorizationMiddleware.API }, new String[] { AdminRole.NAME }));
            put(countryControllerName + ":update",
                    new DataRoute(new String[] { AuthorizationMiddleware.API }, new String[] { AdminRole.NAME }));
            put(countryControllerName + ":delete",
                    new DataRoute(new String[] { AuthorizationMiddleware.API }, new String[] { AdminRole.NAME }));

            put(stateControllerName + ":show",
                    new DataRoute(new String[] { AuthorizationMiddleware.API }, new String[] { AdminRole.NAME }));
            put(stateControllerName + ":index",
                    new DataRoute(new String[] { AuthorizationMiddleware.API }, new String[] { AdminRole.NAME }));
            put(stateControllerName + ":store",
                    new DataRoute(new String[] { AuthorizationMiddleware.API }, new String[] { AdminRole.NAME }));
            put(stateControllerName + ":update",
                    new DataRoute(new String[] { AuthorizationMiddleware.API }, new String[] { AdminRole.NAME }));
            put(stateControllerName + ":delete",
                    new DataRoute(new String[] { AuthorizationMiddleware.API }, new String[] { AdminRole.NAME }));

            put(villageControllerName + ":show",
                    new DataRoute(new String[] { AuthorizationMiddleware.API }, new String[] { AdminRole.NAME }));
            put(villageControllerName + ":index",
                    new DataRoute(new String[] { AuthorizationMiddleware.API }, new String[] { AdminRole.NAME }));
            put(villageControllerName + ":store",
                    new DataRoute(new String[] { AuthorizationMiddleware.API }, new String[] { AdminRole.NAME }));
            put(villageControllerName + ":update",
                    new DataRoute(new String[] { AuthorizationMiddleware.API }, new String[] { AdminRole.NAME }));
            put(villageControllerName + ":delete",
                    new DataRoute(new String[] { AuthorizationMiddleware.API }, new String[] { AdminRole.NAME }));

            put(districtControllerName + ":show",
                    new DataRoute(new String[] { AuthorizationMiddleware.API }, new String[] { AdminRole.NAME }));
            put(districtControllerName + ":index",
                    new DataRoute(new String[] { AuthorizationMiddleware.API }, new String[] { AdminRole.NAME }));
            put(districtControllerName + ":store",
                    new DataRoute(new String[] { AuthorizationMiddleware.API }, new String[] { AdminRole.NAME }));
            put(districtControllerName + ":update",
                    new DataRoute(new String[] { AuthorizationMiddleware.API }, new String[] { AdminRole.NAME }));
            put(districtControllerName + ":delete",
                    new DataRoute(new String[] { AuthorizationMiddleware.API }, new String[] { AdminRole.NAME }));
        }
    };
}
