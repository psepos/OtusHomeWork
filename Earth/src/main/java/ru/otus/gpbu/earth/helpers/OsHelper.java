package ru.otus.gpbu.earth.helpers;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

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

    public static void runJar(Path destinationPath, Path jarFile) throws IOException {

        String command = OsHelper.getCommand(" Start ", " ");

        command += " java -jar " + destinationPath + "\\" + jarFile;

        Runtime.getRuntime().exec(
                command,
                null,
                new File(destinationPath.toString()));
    }
}
