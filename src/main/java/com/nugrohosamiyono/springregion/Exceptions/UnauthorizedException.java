package com.nugrohosamiyono.springregion.Exceptions;

import javax.servlet.ServletException;

public class UnauthorizedException extends ServletException {
    public UnauthorizedException() {
        super("Uauthorized");
    }
}
