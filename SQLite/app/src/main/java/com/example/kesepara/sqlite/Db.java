package com.example.kesepara.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;

import java.util.ArrayList;
import java.util.List;

public class Db extends SQLiteOpenHelper {
    /* table Name */
    private static final String DATABASE_NAME = "customers";

    /* table version */
    private static final int DB_VERSION = 1;

    /* table rows */
    private static final String ROW_ID = "id";
    private static final String ROW_NAME = "name";
    private static final String ROW_SURNAME = "surname";
    private static final String ROW_PHONE = "phone";

    /* Create table query */
    private static final String CREATE_TABLE = "CREATE TABLE " + DATABASE_NAME + "("
            + ROW_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + ROW_NAME + " TEXT, "
            + ROW_SURNAME + " TEXT, "
            + ROW_PHONE + " TEXT) ";

    public Db(Context context) {
        super(context, DATABASE_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /**
     * Add row on DATABASE_NAME
     * @param name
     * @param surname
     * @param phone
     */
    public void addRow(String name, String surname, String phone) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues cv = new ContentValues();
            cv.put(ROW_NAME, name);
            cv.put(ROW_SURNAME, surname);
            cv.put(ROW_PHONE, phone);
            db.insert(DATABASE_NAME, null, cv);
        } catch (Exception e) {
            System.out.println("SQL Warning: " + e);
        }

        db.close();
    }

    /**
     * This method return the all db data
     * @return data
     */
    public List<String> getList() {
        List<String> data = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        try {
            String[] columns = {ROW_ID, ROW_NAME, ROW_SURNAME, ROW_PHONE};
            Cursor cursor = db.query(DATABASE_NAME, columns, null, null, null, null, null);
            while (cursor.moveToNext()) {
                data.add(cursor.getString(0)
                        + " - " + cursor.getString(1)
                        + " - " + cursor.getString(2)
                        + " - " + cursor.getString(3));
            }
        } catch (Exception e) {
            System.out.println("SQL Warning: " + e);
        }

        db.close();
        return data;
    }
}
