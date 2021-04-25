package com.nugrohosamiyono.springregion.Routes;

public class Rule {

    public String auth[];
    public String roles[];
    public String permission[];

    public Rule(String auth[]) {
        this.auth = auth;
    }

    public Rule(String auth[], String roles[], String permission[]) {
        this.auth = auth;
        this.roles = roles;
        this.permission = permission;
    }

    public Rule(String auth[], String roles[]) {
        this.auth = auth;
        this.roles = roles;
    }
}
