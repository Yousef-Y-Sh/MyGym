package com.example.mygym.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.mygym.moudle.Day;
import com.example.mygym.moudle.Guide;
import com.example.mygym.moudle.MyGuide;

import java.util.ArrayList;
import java.util.List;

public class MyDataBase extends SQLiteOpenHelper {
    final static String DB_NAME = "gym_db";
    final static int DB_VERSION = 1;
    // COLLECTION ITEM
    final static String COLLECTION_TABLE_NAME = "Gym_TB";
    final static String COLLECTION_ID = "id";
    final static String COLLECTION_TITLE = "title";
    final static String COLLECTION_TIME = "time";
    final static String COLLECTION_DIFFICULTY = "difficulty";
    final static String COLLECTION_STATUS = "status";
    final static String COLLECTION_IMG = "cover";

    //guide_table
    final static String EXECUTE_TABLE_NAME = "Gudie_TB";
    final static String EXECUTE_ID = "id";
    final static String EXECUTE_ID_PARENT = "idParent";
    final static String EXECUTE_TITLE = "title";
    final static String EXECUTE_IMG = "image";
    final static String EXECUTE_TYPE = "type";

    //Day_table
    final static String DAY_NAME = "Day_TB";
    final static String DAY_ID = "id";
    final static String DAY_ID_PARENT = "idParent";
    final static String DAY_TITLE = "title";

    public MyDataBase(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + COLLECTION_TABLE_NAME + " (" + COLLECTION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + COLLECTION_TITLE + " TEXT , " + COLLECTION_TIME + " INTEGER , " + COLLECTION_DIFFICULTY + " TEXT," + COLLECTION_STATUS + " TEXT," + COLLECTION_IMG + " INTEGER)");
        db.execSQL("CREATE TABLE " + EXECUTE_TABLE_NAME + " (" + EXECUTE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," + EXECUTE_ID_PARENT + " INTEGER , " + EXECUTE_TITLE + " TEXT , " + EXECUTE_IMG + " TEXT , " + EXECUTE_TYPE + " TEXT)");
        db.execSQL("CREATE TABLE " + DAY_NAME + " (" + DAY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," + DAY_ID_PARENT + " INTEGER ," + DAY_TITLE + " TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + COLLECTION_TABLE_NAME + "");
        db.execSQL("DROP TABLE IF EXISTS " + EXECUTE_TABLE_NAME + "");
        db.execSQL("DROP TABLE IF EXISTS " + DAY_NAME + "");
        this.onCreate(db);
    }

    /////////////////////////////////////////////////////////////////////
    public boolean INSERT_GUIDE(MyGuide guide) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLLECTION_TITLE, guide.getName());
        values.put(COLLECTION_TIME, guide.getTime());
        values.put(COLLECTION_DIFFICULTY, guide.getDifficulty());
        values.put(COLLECTION_STATUS, guide.getStatus());
        values.put(COLLECTION_IMG, guide.getCover());
        long result = sqLiteDatabase.insert(COLLECTION_TABLE_NAME, null, values);
        return result != -1;
    }

    public boolean UPDATE_GUIDE(MyGuide guide) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLLECTION_TITLE, guide.getName());
        values.put(COLLECTION_TIME, guide.getTime());
        values.put(COLLECTION_DIFFICULTY, guide.getDifficulty());
        values.put(COLLECTION_STATUS, guide.getStatus());
        values.put(COLLECTION_IMG, guide.getCover());
        String args[] = {guide.getId() + ""};
        long res = sqLiteDatabase.update(COLLECTION_TABLE_NAME, values, "" + COLLECTION_ID + "=?", args);
        return res > 0;
    }

    public boolean DELETE_GUIDE(int id) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String args[] = {id + ""};
        long res = sqLiteDatabase.delete(COLLECTION_TABLE_NAME, "" + COLLECTION_ID + "=?", args);
        return res != -1;
    }

    public List<MyGuide> GETALLGUIDES() {
        List<MyGuide> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + COLLECTION_TABLE_NAME + "", null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(COLLECTION_ID));
                String title = cursor.getString(cursor.getColumnIndexOrThrow(COLLECTION_TITLE));
                int time = cursor.getInt(cursor.getColumnIndexOrThrow(COLLECTION_TIME));
                String difficulty = cursor.getString(cursor.getColumnIndexOrThrow(COLLECTION_DIFFICULTY));
                String status = cursor.getString(cursor.getColumnIndexOrThrow(COLLECTION_STATUS));
                int cover_Img = cursor.getInt(cursor.getColumnIndexOrThrow(COLLECTION_IMG));
                MyGuide myGuide = new MyGuide(id, title, time, difficulty, status, cover_Img);
                list.add(myGuide);
            } while (cursor.moveToNext());
            cursor.close();
        }
        return list;
    }

    public MyGuide GETGUIDE(int car) {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String args[] = {car + ""};
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + COLLECTION_TABLE_NAME + " WHERE " + COLLECTION_ID + "=?", args);
        if (cursor.moveToFirst()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow(COLLECTION_ID));
            String title = cursor.getString(cursor.getColumnIndexOrThrow(COLLECTION_TITLE));
            int time = cursor.getInt(cursor.getColumnIndexOrThrow(COLLECTION_TIME));
            String difficulty = cursor.getString(cursor.getColumnIndexOrThrow(COLLECTION_DIFFICULTY));
            String status = cursor.getString(cursor.getColumnIndexOrThrow(COLLECTION_STATUS));
            int cover_Img = cursor.getInt(cursor.getColumnIndexOrThrow(COLLECTION_IMG));
            MyGuide myGuide = new MyGuide(id, title, time, difficulty, status, cover_Img);
            cursor.close();
            return myGuide;
        }
        return null;
    }


    public List<MyGuide> SEARCHONGUIDE(String text) {
        List<MyGuide> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String args[] = {text + "%"};
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + COLLECTION_TABLE_NAME + " WHERE " + COLLECTION_TABLE_NAME + " LIKE ?", args);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(COLLECTION_ID));
                String title = cursor.getString(cursor.getColumnIndexOrThrow(COLLECTION_TITLE));
                int time = cursor.getInt(cursor.getColumnIndexOrThrow(COLLECTION_TIME));
                String difficulty = cursor.getString(cursor.getColumnIndexOrThrow(COLLECTION_DIFFICULTY));
                String status = cursor.getString(cursor.getColumnIndexOrThrow(COLLECTION_STATUS));
                int cover_Img = cursor.getInt(cursor.getColumnIndexOrThrow(COLLECTION_IMG));
                MyGuide myGuide = new MyGuide(id, title, time, difficulty, status, cover_Img);
                list.add(myGuide);
            } while (cursor.moveToNext());
            cursor.close();
        }
        return list;
    }

    /////////////////////////////////////////////////////////////////////
    public boolean INSERT_MY_GUIDE(Guide guide) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(EXECUTE_ID_PARENT, guide.getIdDayParent());
        values.put(EXECUTE_TITLE, guide.getTitle());
        values.put(EXECUTE_IMG, guide.getImage());
        values.put(EXECUTE_TYPE, guide.getType());
        long result = sqLiteDatabase.insert(EXECUTE_TABLE_NAME, null, values);
        return result != -1;
    }

    public boolean UPDATE_MY_GUIDE(Guide guide) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(EXECUTE_ID_PARENT, guide.getIdDayParent());
        values.put(EXECUTE_TITLE, guide.getTitle());
        values.put(EXECUTE_IMG, guide.getImage());
        values.put(EXECUTE_TYPE, guide.getType());

        String args[] = {guide.getId() + ""};
        long res = sqLiteDatabase.update(EXECUTE_TABLE_NAME, values, "" + EXECUTE_ID + "=?", args);
        return res > 0;
    }

    public boolean DELETE_MY_GUIDE(int id) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String args[] = {id + ""};
        long res = sqLiteDatabase.delete(EXECUTE_TABLE_NAME, "" + EXECUTE_ID + "=?", args);
        return res != -1;
    }

    public List<Guide> GET_ALL_MY_GUIDES(int dayParent) {
        List<Guide> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String args[] = {dayParent + ""};
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + EXECUTE_TABLE_NAME + " WHERE " + EXECUTE_ID_PARENT + " =?", args);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(EXECUTE_ID));
                int id_Parent = cursor.getInt(cursor.getColumnIndexOrThrow(EXECUTE_ID_PARENT));
                String title = cursor.getString(cursor.getColumnIndexOrThrow(EXECUTE_TITLE));
                String image = cursor.getString(cursor.getColumnIndexOrThrow(EXECUTE_IMG));
                String type = cursor.getString(cursor.getColumnIndexOrThrow(EXECUTE_TYPE));
                Guide myGuide = new Guide(id, image, title, id_Parent, type);
                list.add(myGuide);
            } while (cursor.moveToNext());
            cursor.close();
        }
        return list;
    }

    public Guide GET_MY_GUIDE(int ids) {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String args[] = {ids + ""};
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + EXECUTE_TABLE_NAME + " WHERE " + EXECUTE_ID + "=?", args);
        if (cursor.moveToFirst()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow(EXECUTE_ID));
            int id_Parent = cursor.getInt(cursor.getColumnIndexOrThrow(EXECUTE_ID_PARENT));
            String title = cursor.getString(cursor.getColumnIndexOrThrow(EXECUTE_TITLE));
            String image = cursor.getString(cursor.getColumnIndexOrThrow(EXECUTE_IMG));
            String type = cursor.getString(cursor.getColumnIndexOrThrow(EXECUTE_TYPE));
            Guide myGuide = new Guide(id, image, title, id_Parent, type);
            cursor.close();
            return myGuide;
        }
        return null;
    }

    /////////////////////////////////////////////////////////////////////
    public int INSERT_DAY(Day day) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DAY_ID_PARENT, day.getCollectionID());
        values.put(DAY_TITLE, day.getTitle());
        long result = sqLiteDatabase.insert(DAY_NAME, null, values);
        return (int) result;
    }

    public boolean UPDATE_DAY(Day day) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DAY_ID_PARENT, day.getCollectionID());
        values.put(DAY_TITLE, day.getTitle());
        String args[] = {day.getId() + ""};
        long res = sqLiteDatabase.update(DAY_NAME, values, "" + DAY_ID + "=?", args);
        return res > 0;
    }

    public boolean DELETE_MY_DAY(int dayID, int idCollection) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String args[] = {dayID + "", idCollection + ""};
        long res = sqLiteDatabase.delete(DAY_NAME, "" + DAY_ID + "=? AND " + DAY_ID_PARENT + " =?", args);
        return res != -1;
    }

    public List<Day> GET_ALL_DAYS(int collectionID) {
        List<Day> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String args[] = {collectionID + ""};
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + DAY_NAME + " WHERE " + DAY_ID_PARENT + " =?", args);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(DAY_ID));
                int idParent = cursor.getInt(cursor.getColumnIndexOrThrow(DAY_ID_PARENT));
                String title = cursor.getString(cursor.getColumnIndexOrThrow(DAY_TITLE));
                Day day = new Day(id, idParent, title);
                list.add(day);
            } while (cursor.moveToNext());
            cursor.close();
        }
        return list;
    }

    public Day GET_Day(int ids) {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String args[] = {ids + ""};
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + DAY_NAME + " WHERE " + DAY_ID + "=?", args);
        if (cursor.moveToFirst()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow(DAY_ID));
            int idParent = cursor.getInt(cursor.getColumnIndexOrThrow(DAY_ID_PARENT));
            String title = cursor.getString(cursor.getColumnIndexOrThrow(DAY_TITLE));
            Day day = new Day(id, idParent, title);
            cursor.close();
            return day;
        }
        return null;
    }
}
