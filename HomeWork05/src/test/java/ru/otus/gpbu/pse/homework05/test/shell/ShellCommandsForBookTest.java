package ru.otus.gpbu.pse.homework05.test.shell;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.shell.Shell;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.shell.jline.ScriptShellApplicationRunner;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(properties = {
        InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false",
        ScriptShellApplicationRunner.SPRING_SHELL_SCRIPT + ".enabled=false"
})
@ComponentScan("ru.otus.gpbu.pse.homework05.myybooks.shell")
class ShellCommandsForBookTest {

    @Autowired
    private Shell shell;

    @Test
    void contextLoads() {
        assertNotNull(shell);
    }

    @Test
    void authorCount() {
        //assertThat(shell.evaluate(() -> "author-count")).isEqualTo("Your bowling game score is 7! Well done!");
    }
}