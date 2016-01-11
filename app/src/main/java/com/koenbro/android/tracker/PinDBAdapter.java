package com.koenbro.android.tracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * @author laszlo
 * @date 1/10/16.
 */
public class PinDBAdapter {
    private DatabaseHelper mDBHelper;
    private SQLiteDatabase mDb;
    private final Context mCtx;

    private static class DatabaseHelper extends SQLiteOpenHelper{
        DatabaseHelper (Context context) {
            super(context, DBContract.DB_NAME, null, DBContract.DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db){}
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){}
    }

    public PinDBAdapter (Context ctx){this.mCtx = ctx;}

    public PinDBAdapter open() throws SQLException {
        this.mDBHelper = new DatabaseHelper(this.mCtx);
        this.mDb = this.mDBHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        this.mDBHelper.close();
    }

    private Pin cursorToPin(Cursor cursor) { return null;}
    private ContentValues pinToCV (Pin pin){
        ContentValues cv = new ContentValues();
        cv.put(DBContract.TableLocations.COLUMN_1, pin.getDate());
        cv.put(DBContract.TableLocations.COLUMN_2, pin.getTime());
        cv.put(DBContract.TableLocations.COLUMN_3, pin.getLat());
        cv.put(DBContract.TableLocations.COLUMN_4, pin.getLon());
        return cv;
    }

    //CRUD
    public void addPin (Pin pin){
        ContentValues cv = pinToCV(pin);
        this.mDb.insert(DBContract.TableLocations.TABLE_NAME, null, cv);
        Log.d(DBContract.TableLocations.TAG, "pin added: " + pin.toString());
    }


}
