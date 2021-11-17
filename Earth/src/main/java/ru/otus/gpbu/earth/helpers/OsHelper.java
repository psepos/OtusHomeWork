package ru.otus.gpbu.earth.helpers;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OsHelper {

    public static boolean isWindows() {
        return System.getProperty("os.name").toLowerCase().startsWith("windows");
    }

    public static String getCommand() {

        String prefix;

        if (isWindows()) {
            // Windows
            prefix = "cmd /c";
        } else {
            // Linux
            prefix = "sh -c";
        }

        log.debug("prefix: {}", prefix);

        return prefix;
    }

    public static String getCommand(String suffixWindows, String suffixLinux) {
        String command = getCommand();

        if (isWindows()) {
            command += suffixWindows;
        }
        else {
            command += suffixLinux;
        }

        return command;
    }

}
