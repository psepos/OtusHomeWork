package ru.otus.gpbu.mygena.service.runtime;

import java.io.IOException;
import java.net.URISyntaxException;

public interface RuntimeEnvironment {
    void prepare() throws Exception;
    void compile() throws InterruptedException, IOException;
    void run() throws InterruptedException, IOException;
}
