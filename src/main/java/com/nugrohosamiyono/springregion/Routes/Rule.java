package com.nugrohosamiyono.springregion.Routes;

public class Rule {

    public String auth[];
    public String roles[];
    public String permissions[];

    public Rule(String auth[]) {
        this.auth = auth;
    }

    public Rule(String auth[], String roles[], String permissions[]) {
        this.auth = auth;
        this.roles = roles;
        this.permissions = permissions;
    }

    public Rule(String auth[], String roles[]) {
        this.auth = auth;
        this.roles = roles;
    }
}
