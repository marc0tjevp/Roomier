package com.yanco.roomier.datalayer.dao;

import android.database.Cursor;

import com.yanco.roomier.datalayer.SQLiteConnection;
import com.yanco.roomier.model.Event;
import com.yanco.roomier.model.User;

import java.sql.Time;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by ywillems on 15-2-2018.
 */

public class SqlLiteEventDAO implements EventDAO {

    private SQLiteConnection connection;

    public SqlLiteEventDAO(SQLiteConnection connection){
        this.connection = connection;
    }

    @Override
    public List getAllEvents() {

        Cursor cursor = connection.getWritableDatabase().rawQuery("SELECT * FROM event", null);

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {

                UUID eventID = UUID.fromString(cursor.getString(cursor.getColumnIndex("eventID")));
                String eventName = cursor.getString(cursor.getColumnIndex("eventName"));
                Time startTime = Time.valueOf(cursor.getString(cursor.getColumnIndex("startTime")));
                Time endTime = Time.valueOf(cursor.getString(cursor.getColumnIndex("endTime")));
                Date date = Date.valueOf(cursor.getString(cursor.getColumnIndex("date")));
                Boolean status = cursor.getInt(cursor.getColumnIndex("status")) > 0;

                // TODO: Add user lists and create Event objects, add to list.

            }
        }

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
