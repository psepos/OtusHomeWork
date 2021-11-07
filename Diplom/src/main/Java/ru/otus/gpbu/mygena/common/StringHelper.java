package ru.otus.gpbu.mygena.common;

public class StringHelper {
    public static String getStringFirstLower(String string) {
        String first = string.substring(0,1).toLowerCase();
        return first + string.substring(1);
    }
}
