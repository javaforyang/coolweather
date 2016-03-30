package com.example.coolweather.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.coolweather.model.City;
import com.example.coolweather.model.County;
import com.example.coolweather.model.Province;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * 获取CoolWeather实例并且防止多线程操作数据库
     * @param context
     * @return
     */
    public synchronized static CoolWeatherDB getInstance(Context context){
        if (coolWeatherDB != null){
            coolWeatherDB = new CoolWeatherDB(context);
        }
        return coolWeatherDB;
    }

    /**
     * 将Province实例存储到数据库
     * @param province
     */
    public void saveProvince(Province province){
        if (province != null){
            ContentValues values = new ContentValues();
            values.put(Province.TABLE_COLUMN_PROVINCE_NAME,province.getProvinceName());
            values.put(Province.TABLE_COLUMN_PROVINCE_CODE,province.getProvinceCode());
            db.insert(Province.TABLE_NAME,null,values);
        }
    }

    /**
     * 从数据库读取全国所有的省份信息
     * @return
     */
    public List<Province> loadProvince(){
        List<Province> list = new ArrayList<Province>();
        Cursor cursor = db.query(Province.TABLE_NAME,null,null,null,null,null,null);
        if (cursor.moveToFirst()){
            do{
                Province province = new Province();
                province.setId(cursor.getInt(cursor.getInt(cursor.getColumnIndex(Province.TABLE_COLUMN_ID))));
                province.setProvinceName(cursor.getString(cursor.getColumnIndex(Province.TABLE_NAME)));
                province.setProvinceCode(cursor.getString(cursor.getColumnIndex(Province.TABLE_COLUMN_PROVINCE_CODE)));
                list.add(province);
            }while (cursor.moveToNext());
        }
        if (cursor != null){
            cursor.close();
        }
        return list;
    }

    /**
     * 将City实例存储到数据库
     * @param city
     */
    public void saveCity(City city){
        if (city != null){
            ContentValues values = new ContentValues();
            values.put(City.TABLE_COLUMN_CITY_NAME,city.getCityName());
            values.put(City.TABLE_COLUMN_CITY_CODE,city.getCityCode());
            values.put(City.TABLE_COLUMN_PROVINCE_ID,city.getProvinceId());
            db.insert(City.TABLE_NAME,null,values);
        }
    }

    /**
     * 在数据库下根据某省Id读取该省下所有的城市信息
     * @param provinceId
     * @return
     */
    public List<City> loadCities (int provinceId){
        List<City> list = new ArrayList<City>();
        Cursor cursor = db.query(City.TABLE_NAME,null,"province_id = ?",new String[]{String.valueOf(provinceId)},null,null,null);
        if (cursor.moveToFirst()){
            do {
                City city = new City();
                city.setId(cursor.getInt(cursor.getColumnIndex(City.TABLE_COLUMN_ID)));
                city.setCityName(cursor.getString(cursor.getColumnIndex(City.TABLE_NAME)));
                city.setCityCode(cursor.getString(cursor.getColumnIndex(City.TABLE_COLUMN_CITY_CODE)));
                city.setProvinceId(provinceId);
                list.add(city);
            }while (cursor.moveToNext());
        }
        if (cursor != null){
            cursor.close();
        }
        return list;
    }

    /**
     * 将Country保存到数据库
     * @param county
     */
    public void saveCounty(County county){
        if (county != null){
            ContentValues values = new ContentValues();
            values.put(County.TABLE_COLUMN_COUNTY_CODE,county.getCountyCode());
            values.put(County.TABLE_COLUMN_COUNTY_NAME,county.getCountyName());
            values.put(County.TABLE_COLUMN_CITY_ID,county.getCityId());
            db.insert(County.TABLE_NAME,null,values);
        }
    }
    /**
     * 在数据库下根据某城市Id读取该城市下所有的县信息
     * @param cityId
     * @return
     */
    public List<County> loadCounty (int cityId){
        List<County> list = new ArrayList<County>();
        Cursor cursor = db.query(County.TABLE_NAME,null,"city_id = ?",new String[]{String.valueOf(cityId)},null,null,null);
        if (cursor.moveToFirst()){
            do {
                County county = new County();
                county.setId(cursor.getInt(cursor.getColumnIndex(County.TABLE_COLUMN_ID)));
                county.setCountyName(cursor.getString(cursor.getColumnIndex(County.TABLE_COLUMN_COUNTY_NAME)));
                county.setCountyCode(cursor.getString(cursor.getColumnIndex(County.TABLE_COLUMN_COUNTY_CODE)));
                county.setCityId(cityId);
                list.add(county);
            }while (cursor.moveToNext());
        }
        if (cursor != null){
            cursor.close();
        }
        return list;
    }




}
