package com.example.coolweather.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * 操作数据库
 * Created by 杨胜 on 2016/3/27.
 */
public class CoolWeatherDB {
    //数据库名
    public static final String DB_NAME = "cool_weather";
    //数据库版本
    public static final int VERSION = 1;
    private static CoolWeatherDB coolWeatherDB;
    private SQLiteDatabase db;
    private CoolWeatherDB(Context context){
        CoolWeatherOpenHelper dbHelper = new CoolWeatherOpenHelper(context,DB_NAME,null,VERSION);
        db = dbHelper.getWritableDatabase();
    }

}
