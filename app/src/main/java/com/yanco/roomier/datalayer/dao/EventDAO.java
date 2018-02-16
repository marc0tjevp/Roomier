package com.yanco.roomier.datalayer.dao;

import com.yanco.roomier.model.Event;
import com.yanco.roomier.model.User;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by ywillems on 7-2-2018.
 */

public interface EventDAO {
    List<Event> getAllEvents();
    Event getEventById(UUID eventId);
    void insert(Event event);
    void update(Event event);
    void delete(UUID eventId);
    void setConfirmation(String eventId, String userId, boolean status);

    //Event_User
    Map getAllResponses(UUID eventId);
    int getResponsesCount(UUID eventId);
    void insertRsvpEvent(UUID eventId, User user, boolean status);

}
