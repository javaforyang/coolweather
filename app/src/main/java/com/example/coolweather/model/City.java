package com.example.coolweather.model;

/**
 * Created by 杨胜 on 2016/3/27.
 */
public class City {
    public static final String TABLE_NAME = "City";
    public static final String TABLE_COLUMN_ID = "id";
    public static final String TABLE_COLUMN_CITY_NAME = "city_name";
    public static final String TABLE_COLUMN_CITY_CODE = "city_code";
    public static final String TABLE_COLUMN_PROVINCE_ID = "province_id";
    private int id;
    private String cityName;
    private String cityCode;
    private int provinceId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }
}
