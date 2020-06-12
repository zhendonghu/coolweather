package com.coolweather.android.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class HttpUtil {
    private static final String TAG = "HttpUtil";

    // Android P全面禁止了非https链接，并严格审查网站的CA证书
    // 所以简单方法 targetSdkVersion 不能大于 27
    // 正确方法：配置 cleartextTrafficPermitted 为 true
    public static void sendOkHttpRequest(String address, okhttp3.Callback callback) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);
    }
}
