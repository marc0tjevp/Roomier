package com.yanco.roomier.datalayer;

/**
 * Created by ywillems on 15-2-2018.
 */

import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.UUID;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

public class SQLiteConnection extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Roomier.db";
    public static final String TASKS_TABLE_NAME = "tasks";
    public static final String TASKS_COLUMN_ID = "taskID";
    public static final String TASKS_COLUMN_NAME = "taskName";
    public static final String TASKS_COLUMN_CLAIMED = "claimedBy";
    public static final String TASKS_COLUMN_COMPLETED = "taskCompleted";
    public static final String TASKS_COLUMN_CREATED_DATE = "createdDate";
    public static final String TASKS_COLUMN_COMPLETED_DATE = "completedDate";

    public static final String PRODUCTS_TABLE_NAME = "products";
    public static final String PRODUCTS_COLUMN_ID = "productID";
    public static final String PRODUCTS_COLUMN_NAME = "productName";
    public static final String PRODUCTS_COLUMN_AMOUNT = "amount";
    public static final String PRODUCTS_COLUMN_MIN_AMOUNT = "minAmount";
    public static final String PRODUCTS_COLUMN_CREATE_TASK = "createTask";

    public static final String USERS_TABLE_NAME = "users";
    public static final String USERS_COLUMN_NAME = "userName";
    public static final String USERS_COLUMN_PASSWORD_HASH = "passwordHash";
    public static final String USERS_COLUMN_PASSWORD = "password";
    public static final String USERS_COLUMN_EMAIL = "email";

    public static final String EVENT_TABLE_NAME = "events";
    public static final String EVENT_COLUMN_ID = "eventID";
    public static final String EVENT_COLUMN_NAME = "eventName";
    public static final String EVENT_COLUMN_START_TIME = "startTime";
    public static final String EVENT_COLUMN_END_TIME = "endTime";
    public static final String EVENT_COLUMN_DATE = "date";
    public static final String EVENT_COLUMN_CONFIRMATION_STATUS = "confirmationStatus";
    public static final String EVENT_COLUMN_CREATED_BY = "createdBy";

    public static final String EVENT_USER_TABLE_NAME = "event_user";
    public static final String EVENT_USER_COLUMN_EVENT_ID = "eventID";
    public static final String EVENT_USER_COLUMN_USER_NAME = "userName";
    public static final String EVENT_USER_COLUMN_ACCEPTED = "accepted";

    private final String CREATE_USER = "CREATE TABLE user(userName text PRIMARY KEY NOT NULL, passwordHash text NOT NULL, password text NOT NULL, email text NOT NULL);";
    private final String CREATE_TASK = "CREATE TABLE task(taskID text PRIMARY KEY NOT NULL, taskName text NOT NULL, claimedBy text, taskCompleted bit DEFAULT 0 NOT NULL, createDate date NOT NULL, completedDate date, FOREIGN KEY(claimedBy) REFERENCES users(userName));";
    private final String CREATE_PRODUCT = "CREATE TABLE product(productID text PRIMARY KEY NOT NULL, productName text NOT NULL, amount integer DEFAULT 0 NOT NULL, minAmount integer DEFAULT 0 NOT NULL, createTask bit DEFAULT 0 NOT NULL);";
    private final String CREATE_EVENT = "CREATE TABLE event(eventID text PRIMARY KEY NOT NULL, eventName text NOT NULL, startTime time NOT NULL, endTime time NOT NULL, eventDate date NOT NULL, confirmationStatus bit DEFAULT 0 NOT NULL, createdBy text NOT NULL, FOREIGN KEY(createdBy) REFERENCES users(userName));";
    private final String CREATE_EVENT_USER =  "CREATE TABLE event_user(eventID text NOT NULL, userName text NOT NULL, accepted bit NOT NULL, FOREIGN KEY(eventID) REFERENCES events(eventID), FOREIGN KEY(userName) REFERENCES users(userName), PRIMARY KEY(eventID, userName));";

    public SQLiteConnection(Context context){
        super(context, DATABASE_NAME, null, 10);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println("--- ONCREATE STARTED ---");
        db.execSQL(CREATE_USER);
        db.execSQL(CREATE_TASK);
        db.execSQL(CREATE_PRODUCT);
        db.execSQL(CREATE_EVENT);
        db.execSQL(CREATE_EVENT_USER);

        System.out.println("--- INSERT MOCK DATA STARTED ---");
        db.execSQL("INSERT INTO product" +
                "(productID, productName)" +
                "VALUES('" + UUID.randomUUID() + "', 'Toiletpaper');");

        db.execSQL("INSERT INTO product" +
                    "(productID, productName)" +
                    "VALUES('" + UUID.randomUUID() + "', 'Vaccuum bags');");

        db.execSQL("INSERT INTO product" +
                    "(productID, productName)" +
                    "VALUES('" + UUID.randomUUID() + "', 'HG');");
        System.out.println("--- INSERT MOCK DATA ENDED ---");
        System.out.println("--- ONCREATE ENDED ---");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS event_user");
        db.execSQL("DROP TABLE IF EXISTS event");
        db.execSQL("DROP TABLE IF EXISTS product");
        db.execSQL("DROP TABLE IF EXISTS task");
        db.execSQL("DROP TABLE IF EXISTS user");

        System.out.println("ON UPGRADE DATABASE");

        onCreate(db);
    }

}
