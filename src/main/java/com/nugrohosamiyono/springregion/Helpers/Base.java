package com.nugrohosamiyono.springregion.Helpers;

import org.springframework.stereotype.Component;

@Component
public class Base {

    public static String snakeCaseToCamelCase(String str) {
        while (str.contains("_")) {
            str = str.replaceFirst("_[a-z]", String.valueOf(Character.toUpperCase(str.charAt(str.indexOf("_") + 1))));
        }

        return str;
    }
}
