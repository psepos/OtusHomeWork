package ru.otus.gpbu.pse.homework08.mybooks.service;

import org.springframework.stereotype.Service;
import ru.otus.gpbu.pse.homework08.mybooks.common.LastUpdated;

import java.time.LocalDateTime;

@Service
public class TriggerServiceImpl implements TriggerService {

    @Override
    public void setLastUpdate(LastUpdated object) {
        setLastUpd(object);
    }

    public static void setLastUpd(LastUpdated object) {
        object.setLastUpdate(LocalDateTime.now());
    }
}
