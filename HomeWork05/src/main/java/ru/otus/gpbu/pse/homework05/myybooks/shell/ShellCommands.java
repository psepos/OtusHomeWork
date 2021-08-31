package ru.otus.gpbu.pse.homework05.myybooks.shell;

import org.h2.tools.Console;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.sql.SQLException;


@ShellComponent
public class ShellCommands {

    @ShellMethod(value = "dbcon - Run H2 console")
    public void dbcon() throws SQLException {
        Console.main();
    }

}
