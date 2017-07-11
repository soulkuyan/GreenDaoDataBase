package com.android.greendaodatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.visunex.greendao.gen.DaoMaster;

import org.greenrobot.greendao.database.Database;

/**
 * Function
 * Created by lei.zhang on 2017/7/3.
 */

public class MyOpenHelper extends DaoMaster.OpenHelper {
    public MyOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
    }
}
