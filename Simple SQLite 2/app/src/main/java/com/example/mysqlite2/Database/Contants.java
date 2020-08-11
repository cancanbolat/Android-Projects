package com.example.mysqlite2.Database;

public class Contants {

    public static final String DB_NAME = "ADMİN_CC";
    public static final int DB_VERSION = 1;

    // POST TABLE ->
    public static final String TABLE_NAME = "POSTS";
    public static final String POST_ID = "POST_ID";
    public static final String POST_TITLE = "POST_TITLE";
    public static final String POST_IMAGE = "POST_IMAGE";
    public static final String POST_DETAIL = "POST_DETAIL";
    public static final String POST_CATEGORY = "POST_CATEGORY";
    public static final String POST_ADD_TIME = "POST_ADD_TIME";
    public static final String POST_UPDATE_TIME = "POST_UPDATE_TIME";

    public static final String CREATE_TABLE_P = "CREATE TABLE " + TABLE_NAME + "(" +
            POST_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            POST_TITLE + " TEXT," +
            POST_IMAGE + " TEXT," +
            POST_DETAIL + " TEXT," +
            POST_CATEGORY + " TEXT," +
            POST_ADD_TIME + " TEXT," +
            POST_UPDATE_TIME + " TEXT" + ")";
    // POST TABLE <-

    // CATEGORY TABLE ->
    public static final String TABLE_NAME1 = "CATEGORIES";
    public static final String CAT_ID = "CAT_ID";
    public static final String CAT_TITLE = "CAT_TITLE";

    public static final String CREATE_TABLE_C = "CREATE TABLE " + TABLE_NAME1 + "(" +
            CAT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            CAT_TITLE + " TEXT" + ")";
    // CATEGORY TABLE <-

}
