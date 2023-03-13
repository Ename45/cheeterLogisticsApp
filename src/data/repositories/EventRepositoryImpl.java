package data.repositories;

import data.models.Event;
import data.models.User;

import java.util.ArrayList;
import java.util.List;

public class EventRepositoryImpl implements EventRepository{

    private int count;
    private List<Event> allEvents = new ArrayList<>();

    public Event save(Event event) {
        boolean isSavedEvent = event.getId() != 0;
        if(isSavedEvent) update(event);

        else saveNewEvent(event);

        return event;
    }


    private void saveNewEvent(Event event){
        event.setId(generateUserId());
        allEvents.add(event);
        count++;
    }

//        private void update(Event event){
//        Event savedEvent = findById(event.getId());
//        int indexOfSavedEvent = allEvents.indexOf(savedEvent);
//        allEvents.set(indexOfSavedEvent, event);
////        allEvents[indexOfSavedEvent] = event; for an array
//    }

    //                             OR
    private void update(Event event){
//        Event savedEvent = findById(event.getId());
//        savedEvent.setWho(event.getWho());
//        savedEvent.setWhat(event.getWhat());
//        savedEvent.setEvents(a);

//                  OR
        Event savedEvent = findById(event.getId());
        allEvents.remove(savedEvent);
        allEvents.add(event);
    }

    private int generateUserId() {
        return count+1;
    }

    public long count() {
        return count;
    }

    public void delete(Event event) {

    }

    public void delete(int id) {

    }

    public List<Event> findAll() {
        return null;
    }

    public Event findById(int id) {
        for (Event event: allEvents) if (event.getId() == id) return event;
        return null;
    }
}
