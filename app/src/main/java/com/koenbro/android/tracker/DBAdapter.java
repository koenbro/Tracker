package com.koenbro.android.tracker;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * @author laszlo
 * @date 1/10/16.
 */
public class DBAdapter {
    private final Context context;
    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;


    public DBAdapter(Context ctx) {
        this.context = ctx;
        this.DBHelper = new DatabaseHelper(this.context);
    }
    private static class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context c) {
            super(c, DBContract.DB_NAME, null, DBContract.DB_VERSION);
        }
        @Override
        public void onCreate (SQLiteDatabase db) {
            db.execSQL(DBContract.TableLocations.CREATE_TABLE);
        }

        public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion){
            Log.w(DatabaseHelper.class.getName(),
                    "Upgrading database from version " + oldVersion + " to "
                            + newVersion + ", which will destroy all old data");
            db.execSQL(DBContract.TableLocations.DELETE_TABLE);
        }
    }

    public DBAdapter open() throws SQLException {
        this.db = this.DBHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        this.DBHelper.close();
    }
}
