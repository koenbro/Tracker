package com.koenbro.android.tracker;


import android.provider.BaseColumns;

/**
 * @author laszlo
 * @date 1/10/16.
 */

public final class DBContract {
    public static final String DB_NAME = "trackmysteps.sqlite";
    public static final int DB_VERSION = 1;
    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ", ";

    // Empty constructor prevents accidental instantiation of the contract class.
    private DBContract() {
    }

    public static abstract class TableLocations implements BaseColumns {
        public static final String TABLE_NAME = "locations";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_1 = "date";
        public static final String COLUMN_2 = "time";
        public static final String COLUMN_3 = "lat";
        public static final String COLUMN_4 = "lon"; //bellows extension minimal


        public static final String[] COLUMNS = {COLUMN_ID, COLUMN_1, COLUMN_2, COLUMN_3,
                COLUMN_4};
        public static final String CREATE_TABLE =
                "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
                        COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT" +
                        COMMA_SEP + COLUMN_1 + TEXT_TYPE +
                        COMMA_SEP + COLUMN_2 + TEXT_TYPE +
                        COMMA_SEP + COLUMN_3 + TEXT_TYPE +
                        COMMA_SEP + COLUMN_4 + TEXT_TYPE +
                        " )";
        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
        public static final String TAG = "CameraDB.tag";
    }


}
