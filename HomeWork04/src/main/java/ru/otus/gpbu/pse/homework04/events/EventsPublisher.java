package ru.otus.gpbu.pse.homework04.events;

import ru.otus.gpbu.pse.homework04.states.ApplicationStates;

public interface EventsPublisher {
    void publish(EventType type, String context);
}
