package com.example.coolweather.util;

import android.text.TextUtils;

import com.example.coolweather.db.CoolWeatherDB;
import com.example.coolweather.model.City;
import com.example.coolweather.model.County;
import com.example.coolweather.model.Province;

/**
 * Created by 杨胜 on 2016/3/29.
 */
public class Utility {
    /**
     * 解析和处理服务器返回的省级数据
     * @param coolWeatherDB
     * @param response
     * @return
     */
    public synchronized static boolean handleProvincesResponse(CoolWeatherDB coolWeatherDB,String response){
        if (!TextUtils.isEmpty(response) && coolWeatherDB != null){
            String[] allProvinces = response.split(",");
            if (allProvinces != null && allProvinces.length>0){
                for (String singleProvince : allProvinces){
                    String[] details = singleProvince.split("\\|");
                    Province province = new Province();
                    province.setProvinceCode(details[0]);
                    province.setProvinceName(details[1]);
                    coolWeatherDB.saveProvince(province);
                }
                return true;
            }
        }
        return false;
    }
    public static boolean handleCitiesResponse(CoolWeatherDB coolWeatherDB,String response,int provinceId){
        if (!TextUtils.isEmpty(response) && coolWeatherDB != null){
            String[] allCities = response.split(",");
            if (allCities != null && allCities.length > 0){
                for (String singleCity : allCities){
                    String[] array = singleCity.split("\\|");
                    City city = new City();
                    city.setCityCode(array[0]);
                    city.setCityName(array[1]);
                    city.setProvinceId(provinceId);
                    coolWeatherDB.saveCity(city);
                }
                return true;
            }
        }
        return false;
    }
    public static boolean handleCountyResponse(CoolWeatherDB coolWeatherDB,String response,int cityId){
        if (!TextUtils.isEmpty(response) && coolWeatherDB != null){
            String[] allCounty = response.split(",");
            for (String singleCounty : allCounty){
                County county = new County();
                String[] array = singleCounty.split("\\|");
                county.setCountyCode(array[0]);
                county.setCountyName(array[1]);
                county.setCityId(cityId);
                coolWeatherDB.saveCounty(county);
            }
            return true;
        }
        return false;
    }

}
