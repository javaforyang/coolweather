package com.example.coolweather.model;

/**
 * Created by 杨胜 on 2016/3/27.
 */
public class County {
    public static final String TABLE_NAME = "County";
    public static final String TABLE_COLUMN_ID = "id";
    public static final String TABLE_COLUMN_COUNTY_NAME = "county_name";
    public static final String TABLE_COLUMN_COUNTY_CODE = "county_code";
    public static final String TABLE_COLUMN_CITY_ID = "city_id";
    private int id;
    private String countyName;
    private String countyCode;
    private int cityId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public String getCountyCode() {
        return countyCode;
    }

    public void setCountyCode(String countyCode) {
        this.countyCode = countyCode;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }
}
