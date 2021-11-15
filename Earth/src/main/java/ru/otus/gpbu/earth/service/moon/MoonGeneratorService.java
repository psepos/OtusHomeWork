package ru.otus.gpbu.earth.service.moon;

import com.squareup.javapoet.JavaFile;
import ru.otus.gpbu.earth.models.myentity.MyEntity;

public interface MoonGeneratorService {
    JavaFile doEntityGenerate(MyEntity entityModel);
    JavaFile doEntityRepositoriesGenerate(MyEntity entityModel);
    JavaFile doEntityServicesGenerate(MyEntity entityModel);
    JavaFile doEntityShellCommandsGenerate(MyEntity entityModel);
    JavaFile myEntityRestControllersItemProcessor(MyEntity entityModel);
}
