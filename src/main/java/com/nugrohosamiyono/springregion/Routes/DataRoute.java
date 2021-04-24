package com.nugrohosamiyono.springregion.Routes;

public class DataRoute {

    public String auth[];
    public String roles[];
    public String permission[];

    public DataRoute(String auth[]) {
        this.auth = auth;
    }

    public DataRoute(String auth[], String roles[], String permission[]) {
        this.auth = auth;
        this.roles = roles;
        this.permission = permission;
    }

    public DataRoute(String auth[], String roles[]) {
        this.auth = auth;
        this.roles = roles;
    }
}
