package com.example.coolweather.util;

/**
 * Created by 杨胜 on 2016/3/29.
 */
public interface HttpCallbackListener {
    void onFinishi(String response);
    void onError(Exception e);
}
