package dev.uublabs.zoo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 11/14/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper
{

    public DatabaseHelper(Context context)
    {
        super(context, DatabaseContract.Entry.TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String CREATE_TABLE = "CREATE TABLE " + DatabaseContract.Entry.TABLE_NAME + "(" + DatabaseContract.Entry.COLUMN_NAME
                + " TEXT PRIMARY KEY," +
                DatabaseContract.Entry.COLUMN_TYPE + " TEXT " +
                ")";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + DatabaseContract.Entry.TABLE_NAME);
        onCreate(db);
    }

    public long saveAnimal(Animal animal)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseContract.Entry.COLUMN_NAME, animal.getName());
        contentValues.put(DatabaseContract.Entry.COLUMN_TYPE, animal.getType());
        long row = db.insert(DatabaseContract.Entry.TABLE_NAME, null,contentValues);
        return row;
    }

    public List<Animal> getAnimals()
    {
        List<Animal> animalList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();

        String QUERY = "SELECT * FROM " + DatabaseContract.Entry.TABLE_NAME;
        Cursor cursor = db.rawQuery(QUERY, null);

        if(cursor.moveToFirst())
        {
            do
            {
                Animal animal = new Animal(
                        cursor.getString(0),
                        cursor.getString(1));
                animalList.add(animal);
            }
            while (cursor.moveToNext());
        }
        return animalList;
    }

    public List<Animal> getCategoryAnimals(String cat)
    {
        List<Animal> animalList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();

        String QUERY = "SELECT * FROM " + DatabaseContract.Entry.TABLE_NAME + " WHERE Type='"+cat+"'";
        Cursor cursor = db.rawQuery(QUERY, null);

        if(cursor.moveToFirst())
        {
            do
            {
                Animal animal = new Animal(
                        cursor.getString(0),
                        cursor.getString(1));
                animalList.add(animal);
            }
            while (cursor.moveToNext());
        }
        return animalList;
    }

    public Animal getAnimal(String animalName)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Animal animal = new Animal("","");

        String QUERY = "SELECT * FROM " + DatabaseContract.Entry.TABLE_NAME + " WHERE Name='"+animalName+"'";
        Cursor cursor = db.rawQuery(QUERY, null);

        if(cursor.moveToFirst())
        {
            do
            {
                animal = new Animal(
                        cursor.getString(0),
                        cursor.getString(1));
            }
            while (cursor.moveToNext());
        }
        return animal;
    }
}
