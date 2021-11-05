package ru.otus.gpbu.mygena.job.runtimegeneration;

import com.squareup.javapoet.JavaFile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;
import ru.otus.gpbu.mygena.service.runtime.PathService;

import java.io.IOException;
import java.util.List;

@Component
@Slf4j
public class JavaFileWriter<T> implements ItemWriter<T> {

    private final PathService pathService;

    public JavaFileWriter(PathService pathService) {
        this.pathService = pathService;
    }

    @Override
    public void write(List<? extends T> list) {
        list.forEach(
                (e) -> {
                    try {
                        ((JavaFile) e).writeTo(pathService.runtimeEnvironmentSources());
                    } catch (IOException ex) {
                        log.error(ex.getMessage());
                    }
                }
        );
    }
}
