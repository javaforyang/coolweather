package com.example.coolweather.model;

/**
 * Created by 杨胜 on 2016/3/27.
 */
public class Province {
    public static final String TABLE_NAME = "Province";
    public static final String TABLE_COLUMN_ID = "id";
    public static final String TABLE_COLUMN_PROVINCE_NAME = "province_name";
    public static final String TABLE_COLUMN_PROVINCE_CODE= "province_code";
    private int id;
    private String provinceName;
    private String provinceCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }
}
