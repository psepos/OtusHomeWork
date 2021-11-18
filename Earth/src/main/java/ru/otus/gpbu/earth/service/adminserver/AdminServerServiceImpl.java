package ru.otus.gpbu.earth.service.adminserver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.client.RestTemplate;
import ru.otus.gpbu.earth.helpers.OsHelper;
import ru.otus.gpbu.earth.models.mysetting.service.MySettingService;
import ru.otus.gpbu.earth.service.patch.PathService;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@Service
@Slf4j
public class AdminServerServiceImpl implements AdminServerService {

    private final PathService pathService;
    private final MySettingService settings;

    public AdminServerServiceImpl(PathService pathService, MySettingService settings) {
        this.pathService = pathService;
        this.settings = settings;
    }

    @Override
    public void run() throws IOException, InterruptedException {
        String command = OsHelper.getCommand(" start java -jar ", " java -jar ");
        command += pathService.adminServerJarFile();

        log.debug("command: {}", command);

        Process process = Runtime.getRuntime().exec(
                command,
                null,
                new File(pathService.adminServerPath().toString()));
        Files.writeString(Path.of(pathService.adminServerPath().toString(), "pid"), Long.toString(process.pid()));

    }

    @Override
    public void shutdown() throws ShutdownErrorException {

        String url = settings.getSetting("ADMIN_SERVER.URL") + settings.getSetting("ADMIN_SERVER.SHUTDOWN_SUFFIX");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>("", headers);

        RestTemplate rest = new RestTemplate();
        try {
            ShutdownDto response = rest.postForObject(url, request, ShutdownDto.class);
            assert response != null;
            log.debug(response.getMessage());
        } catch (Exception e) {
            log.error("shutdown fault", e);
            throw new ShutdownErrorException("shutdown fault", e);
        }
    }

    @Override
    public void install() throws IOException, URISyntaxException {
        this.makeDir();
        this.installAdminServer();
    }

    private void makeDir() throws IOException {
        Path destination = pathService.adminServerPath();
        log.debug("destination = {}", destination);

        if (Files.exists(destination)) {
            log.debug("destination exists");

            boolean result = FileSystemUtils.deleteRecursively(pathService.adminServerPath());
            log.debug("delete result = {}", result);
        }

        boolean result = destination.toFile().mkdir();
        log.debug("mkdir result = {}", result);
    }

    private void installAdminServer() throws URISyntaxException, IOException {
        Path sourceFile = pathService.adminServerTemplateJarFile();
        log.debug("installAdminServer():sourceFile: {}", sourceFile);


        Path destinationFile = pathService.adminServerJarFileWithPath();
        log.debug("installAdminServer():destinationFile: {}", destinationFile);

        Files.copy(sourceFile, destinationFile, StandardCopyOption.REPLACE_EXISTING);
    }

}
