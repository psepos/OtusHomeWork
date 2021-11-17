package ru.otus.gpbu.earth.service.adminserver;

import java.io.IOException;
import java.net.URISyntaxException;

public interface AdminServerService {
    void run() throws IOException, InterruptedException;
    void shutdown();
    void install() throws IOException, URISyntaxException;
}
