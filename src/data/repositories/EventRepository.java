package data.repositories;

import data.models.Event;

import java.util.List;

public interface EventRepository {
    //    THIS REPO IS RESPONSIBLE FOR STORING AND RETRIEVING AN EVENT
    Event save(Event event);
    long count();
    void delete(Event event);
    void delete(int id);
    List<Event> findAll();
    Event findById(int id);
}
