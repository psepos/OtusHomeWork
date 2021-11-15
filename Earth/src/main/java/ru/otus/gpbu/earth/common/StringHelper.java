package ru.otus.gpbu.earth.common;

public class StringHelper {
    public static String getStringFirstLower(String string) {
        return string.substring(0,1).toLowerCase() + string.substring(1);
    }

    public static String getStringFirstUpper(String string) {
        return string.substring(0,1).toUpperCase() + string.substring(1);
    }
}
