package com.example.mygym.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.mygym.moudle.Guide;
import com.example.mygym.moudle.MyGuide;

import java.util.ArrayList;

public class MyDataBase extends SQLiteOpenHelper {
    final static String DB_NAME = "gym_db";
    final static int DB_VERSION = 2;
    // gym_table
    final static String TABLE_NAME = "Gym_TB";
    final static String TABLE_ID = "id";
    final static String TABLE_TITLE = "title";
    final static String TABLE_TIME = "time";
    final static String TABLE_DIFFICULTY = "difficulty";
    final static String TABLE_GUIDE_STATUS = "status";
    final static String TABLE_IMAGE_COVER = "cover";

    //guide_table
    final static String GUIDE_NAME = "Gudie_TB";
    final static String GUIDE_ID = "id";
    final static String GUIDE_ID_PARENT = "idParent";
    final static String GUIDE_TITLE = "title";
    final static String GUIDE_IMAGE = "image";
    final static String GUIDE_DAY = "day";

    public MyDataBase(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (" + TABLE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + TABLE_TITLE + " TEXT , " + TABLE_TIME + " INTEGER , " + TABLE_DIFFICULTY + " TEXT," + TABLE_GUIDE_STATUS + " TEXT," + TABLE_IMAGE_COVER + " INTEGER)");
        db.execSQL("CREATE TABLE " + GUIDE_NAME + " (" + GUIDE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," + GUIDE_ID_PARENT + " INTEGER , " + GUIDE_TITLE + " TEXT , " + GUIDE_IMAGE + " INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME + "");
        db.execSQL("DROP TABLE IF EXISTS " + GUIDE_NAME + "");
        this.onCreate(db);
    }

    /////////////////////////////////////////////////////////////////////
    public boolean INSERT_GUIDE(MyGuide guide) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TABLE_TITLE, guide.getName());
        values.put(TABLE_TIME, guide.getTime());
        values.put(TABLE_DIFFICULTY, guide.getDifficulty());
        values.put(TABLE_GUIDE_STATUS, guide.getStatus());
        values.put(TABLE_IMAGE_COVER, guide.getCover());
        long result = sqLiteDatabase.insert(TABLE_NAME, null, values);
        return result != -1;
    }

    public boolean UPDATE_GUIDE(MyGuide guide) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TABLE_TITLE, guide.getName());
        values.put(TABLE_TIME, guide.getTime());
        values.put(TABLE_DIFFICULTY, guide.getDifficulty());
        values.put(TABLE_GUIDE_STATUS, guide.getStatus());
        values.put(TABLE_IMAGE_COVER, guide.getCover());
        String args[] = {guide.getId() + ""};
        long res = sqLiteDatabase.update(TABLE_NAME, values, "" + TABLE_ID + "=?", args);
        return res > 0;
    }

    public boolean DELETE_GUIDE(int id) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String args[] = {id + ""};
        long res = sqLiteDatabase.delete(TABLE_NAME, "" + TABLE_ID + "=?", args);
        return res != -1;
    }

    public ArrayList<MyGuide> GETALLGUIDES() {
        ArrayList<MyGuide> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME + "", null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(TABLE_ID));
                String title = cursor.getString(cursor.getColumnIndexOrThrow(TABLE_TITLE));
                int time = cursor.getInt(cursor.getColumnIndexOrThrow(TABLE_TIME));
                String difficulty = cursor.getString(cursor.getColumnIndexOrThrow(TABLE_DIFFICULTY));
                String status = cursor.getString(cursor.getColumnIndexOrThrow(TABLE_GUIDE_STATUS));
                int cover_Img = cursor.getInt(cursor.getColumnIndexOrThrow(TABLE_IMAGE_COVER));
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
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + TABLE_ID + "=?", args);
        if (cursor.moveToFirst()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow(TABLE_ID));
            String title = cursor.getString(cursor.getColumnIndexOrThrow(TABLE_TITLE));
            int time = cursor.getInt(cursor.getColumnIndexOrThrow(TABLE_TIME));
            String difficulty = cursor.getString(cursor.getColumnIndexOrThrow(TABLE_DIFFICULTY));
            String status = cursor.getString(cursor.getColumnIndexOrThrow(TABLE_GUIDE_STATUS));
            int cover_Img = cursor.getInt(cursor.getColumnIndexOrThrow(TABLE_IMAGE_COVER));
            MyGuide myGuide = new MyGuide(id, title, time, difficulty, status, cover_Img);
            cursor.close();
            return myGuide;
        }
        return null;
    }


    public ArrayList<MyGuide> SEARCHONGUIDE(String text) {
        ArrayList<MyGuide> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String args[] = {text + "%"};
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + TABLE_NAME + " LIKE ?", args);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(TABLE_ID));
                String title = cursor.getString(cursor.getColumnIndexOrThrow(TABLE_TITLE));
                int time = cursor.getInt(cursor.getColumnIndexOrThrow(TABLE_TIME));
                String difficulty = cursor.getString(cursor.getColumnIndexOrThrow(TABLE_DIFFICULTY));
                String status = cursor.getString(cursor.getColumnIndexOrThrow(TABLE_GUIDE_STATUS));
                int cover_Img = cursor.getInt(cursor.getColumnIndexOrThrow(TABLE_IMAGE_COVER));
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
        values.put(GUIDE_ID_PARENT, guide.getIdParent());
        values.put(GUIDE_TITLE, guide.getTitle());
        values.put(GUIDE_IMAGE, guide.getImage());
        values.put(GUIDE_DAY, guide.getDay());
        long result = sqLiteDatabase.insert(GUIDE_NAME, null, values);
        return result != -1;
    }

    public boolean UPDATE_MY_GUIDE(Guide guide) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(GUIDE_ID_PARENT, guide.getIdParent());
        values.put(GUIDE_TITLE, guide.getTitle());
        values.put(GUIDE_IMAGE, guide.getImage());
        values.put(GUIDE_DAY, guide.getDay());
        String args[] = {guide.getId() + ""};
        long res = sqLiteDatabase.update(GUIDE_NAME, values, "" + GUIDE_ID + "=?", args);
        return res > 0;
    }

    public boolean DELETE_MY_GUIDE(int id) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String args[] = {id + ""};
        long res = sqLiteDatabase.delete(GUIDE_NAME, "" + GUIDE_ID + "=?", args);
        return res != -1;
    }

    public ArrayList<Guide> GET_ALL_MY_GUIDES(int idParent, int selectDay) {
        ArrayList<Guide> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String args[] = {idParent + "", selectDay + ""};
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + GUIDE_NAME + " WHERE " + GUIDE_ID_PARENT + " =? AND " + GUIDE_DAY + " =?", args);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(GUIDE_ID));
                int id_Parent = cursor.getInt(cursor.getColumnIndexOrThrow(GUIDE_ID_PARENT));
                String title = cursor.getString(cursor.getColumnIndexOrThrow(GUIDE_TITLE));
                int image = cursor.getInt(cursor.getColumnIndexOrThrow(GUIDE_IMAGE));
                int day = cursor.getInt(cursor.getColumnIndexOrThrow(GUIDE_DAY));
                Guide myGuide = new Guide(id, image, title, id_Parent, day);
                list.add(myGuide);
            } while (cursor.moveToNext());
            cursor.close();
        }
        return list;
    }

    public Guide GET_MY_GUIDE(int ids) {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String args[] = {ids + ""};
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + GUIDE_NAME + " WHERE " + GUIDE_ID + "=?", args);
        if (cursor.moveToFirst()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow(GUIDE_ID));
            int id_Parent = cursor.getInt(cursor.getColumnIndexOrThrow(GUIDE_ID_PARENT));
            String title = cursor.getString(cursor.getColumnIndexOrThrow(GUIDE_TITLE));
            int image = cursor.getInt(cursor.getColumnIndexOrThrow(GUIDE_IMAGE));
            int day = cursor.getInt(cursor.getColumnIndexOrThrow(GUIDE_DAY));
            Guide myGuide = new Guide(id, image, title, id_Parent, day);
            cursor.close();
            return myGuide;
        }
        return null;
    }
}
