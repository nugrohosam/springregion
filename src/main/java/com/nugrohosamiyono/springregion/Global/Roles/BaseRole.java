package com.nugrohosamiyono.springregion.Global.Roles;

import org.springframework.stereotype.Component;

@Component
public class BaseRole {
    public static final AdminRole ADMIN = new AdminRole();
    public static final StaffRole STAFF = new StaffRole();
}
