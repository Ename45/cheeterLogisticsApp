package data.repositories;

import data.models.Event;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EventRepositoryImplTest {

    private EventRepository eventRepository;

    @BeforeEach
    public void setUp(){
        eventRepository = new EventRepositoryImpl();
    }

    @Test
    @DisplayName("Create new event test")
    public void saveOneEvent_countIsOneTest(){
        assertEquals(0, eventRepository.count());

        Event event = new Event();
        eventRepository.save(event);

        assertEquals(1, eventRepository.count());
    }

    @Test
    @DisplayName("Generate Id test")
    public void saveOneEvent_idIsOneTest(){
        Event event = new Event();
        assertEquals(0, event.getId());
        Event savedEvent = eventRepository.save(event);
        assertEquals(1, savedEvent.getId());
    }

    @Test
    @DisplayName("Find by Id test")
    public void saveOneEvent_findEventById_returnsSavedEventTest(){
        Event event = new Event();
        event.setWhat("shoe");
        eventRepository.save(event);

        Event foundEvent = eventRepository.findById(1);
        assertEquals(1, foundEvent.getId());
        assertEquals("shoe", foundEvent.getWhat());
        assertEquals(event, foundEvent);
    }

    @Test
    @DisplayName("Update test")
    public void saveTwoItemsWithSameId_countIsOneTest(){
        Event event = new Event();
        event.setWhat("shoe");
//        var savedAnEvent = eventRepository.save(event);
        eventRepository.save(event);
        Event savedAnEvent = eventRepository.findById(1);
        assertEquals(event, savedAnEvent);


        Event secondEvent = new Event();
        secondEvent.setId(1);
        event.setWhat("bag");

        eventRepository.save(secondEvent);

        Event foundEvent = eventRepository.findById(1);

        assertEquals(foundEvent, secondEvent);
        assertNotEquals(foundEvent, event);
    }

}