package ru.otus.gpbu.mygena.service.runtime;

import java.io.IOException;

public interface RuntimeEnvironment {
    void generate() throws Exception;
    void run() throws InterruptedException, IOException;
}
