package com.app.fourproject;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "seller.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE \"Person\" (\n" +
                "\t\"ID\"\tINTEGER,\n" +
                "\t\"Name\"\tTEXT,\n" +
                "\t\"Phone\"\tTEXT,\n" +
                "\t\"Address\"\tTEXT,\n" +
                "\tPRIMARY KEY(\"ID\")\n" +
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public void InsertPerson(Person p) {

        SQLiteDatabase db = this.getWritableDatabase();

        //  String q = "INSERT into Customer (Name,Phone,Address) VALUES ('"+p.name+"','"+p.phone+"','assuit');";
        String q = String.format("INSERT into Person (Name,Phone,Address) VALUES" +
                " ('%s','%s','%s');", p.name, p.phone, p.address);
        db.execSQL(q);
    }

    public ArrayList<Person> getAllPerson() {
        ArrayList<Person> people = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("Select * from Person", null);

        c.moveToFirst();

        while (!c.isAfterLast()) {

            Person p = new Person();

            p.name = c.getString(1);
            p.phone = c.getString(2);
            p.address = c.getString(3);
            people.add(p);

            c.moveToNext();
        }

        return people;

    }

}
