package com.icook.dev.i_cook;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by JohnReinel on 8/31/2017.
 */

public class SQLiteDataBaseAdapter {

    static MyHelper helper;

    public SQLiteDataBaseAdapter(Context context) {
        helper = new MyHelper(context);
    }

    static class MyHelper extends SQLiteOpenHelper {
        private static final String DATABASE_NAME = "ICookDB";
        private static final String TABLE_NAME = "tblUsers";
        private static final int DATABASE_VERSION = 1;
        public static final String UID = "_id";
        public static final String USER_NAME = "UserName";
        public static final String USER_PASSW = "UserPassw";
        public static final String USER_EMAIL = "UserEmail";
		public static final String USER_CONTACT = "UserContact";
        private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME
                + " (" + UID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + USER_NAME + " VARCHAR(30), " + USER_PASSW + " VARCHAR(20), "
                + USER_EMAIL + " VARCHAR(20), " + USER_CONTACT + " VARCHAR(15))";

        private Context context1;

        public MyHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.context1 = context;
        }

        public String[] searchData(String id){
            String[] data = new String[5];
            SQLiteDatabase db = helper.getReadableDatabase();
            String[] whereArgs = { id };
            String[] columns = { MyHelper.UID, MyHelper.USER_NAME,
                    MyHelper.USER_PASSW, MyHelper.USER_EMAIL, MyHelper.USER_CONTACT};
            Cursor c = db.query(TABLE_NAME, columns, UID + " = ? ", whereArgs ,null,null,null);

            if(c.moveToNext()) {
                String userlname = c.getString(1);
                String usermi = c.getString(3);
                String useremail = c.getString(4);

                data[1] = userlname;
                data[3] = usermi;
                data[4] = useremail;
            }
            return data;
        }

        public long registerUser(String user_name, String user_passw, String user_email, String user_contact) {
            SQLiteDatabase db = helper.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put(MyHelper.USER_NAME, user_name);
            cv.put(MyHelper.USER_PASSW, user_passw);
            cv.put(MyHelper.USER_EMAIL, user_email);
			cv.put(MyHelper.USER_CONTACT, user_contact);
            long id = db.insert(MyHelper.TABLE_NAME, null, cv);
            db.close();
            return id;
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            try {
                sqLiteDatabase.execSQL(CREATE_TABLE);
            } catch (SQLException e) {
                Toast.makeText(context1,""+e,Toast.LENGTH_LONG).show();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }
    }
}
