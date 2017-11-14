package dev.uublabs.zoo;

import android.content.Intent;
import android.provider.BaseColumns;

/**
 * Created by Admin on 11/14/2017.
 */

public class DatabaseContract
{
    public static class Entry implements BaseColumns
    {
        public static final String TABLE_NAME = "ZooAnimals";
        public static final String COLUMN_NAME = "Name";
        public static final String COLUMN_TYPE = "Type";
    }
}
