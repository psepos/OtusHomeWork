package ru.otus.gpbu.earth.helpers;

import java.lang.reflect.Type;

public class ReflectHelper {
    public static Type getType(String typeName) {
        Type result;
        switch (typeName) {
            case ("String"):
                result = String.class;
                break;
            case ("Long"):
                result = Long.class;
                break;
            default:
                result = null;
                break;
        }

        return result;
    }

    public static String getString(Type type, String string) {
        String result;

        if (String.class.equals(type)) {
            result = "\"" + string + "\"";
        } else if (Long.class.equals(type)) {
            result = string;
        } else {
            result = "";
        }
        return result;
    }
}
