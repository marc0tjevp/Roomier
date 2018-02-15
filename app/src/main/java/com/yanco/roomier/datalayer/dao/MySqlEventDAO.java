package com.yanco.roomier.datalayer.dao;

import com.yanco.roomier.model.Event;
import com.yanco.roomier.model.User;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by ywillems on 7-2-2018.
 */

public class MySqlEventDAO implements EventDAO {

    @Override
    public List getAllEvents() {
        return null;
    }

    @Override
    public Event getEventById(UUID eventId) {
        return null;
    }

    @Override
    public void insert(Event event) {

    }

    @Override
    public void update(Event event) {

    }

    @Override
    public void delete(UUID eventId) {

    }

    @Override
    public void setConfirmation(String eventId, String userId, boolean status) {

    }

    @Override
    public Map getAllResponses(UUID eventId) {
        return null;
    }

    @Override
    public int getResponsesCount(UUID eventId) {
        return 0;
    }

    @Override
    public void insertRsvpEvent(UUID eventId, User user, boolean status) {

    }
}
