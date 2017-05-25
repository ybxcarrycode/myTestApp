package com.ybxcc.testinysx.mytestapp.sqliteHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import org.greenrobot.greendao.annotation.Id;

/**
 * Created by Ybx on 2017/5/25.
 */

public class CommonOpenHelper extends SQLiteOpenHelper {

    private static CommonOpenHelper helper;

    public static CommonOpenHelper getInstance(Context context) {
        if (helper == null) {
            helper = new CommonOpenHelper(context, "common.db", null, 1);
        }
        return helper;
    }


    private CommonOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table love(" +
                "id integer primary key autoincrement, " +
                "name varchar, " +
                "price varchar, " +
                "sell_num integer, " +
                "image_url varchar, " +
                "address varchar" +
                ")");
        
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
