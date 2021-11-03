package ru.otus.gpbu.mygena.service.runtime;

import java.net.URISyntaxException;

public interface RuntimeEnvironment {
    void prepare() throws Exception;
    void compile();
    void run();
}
