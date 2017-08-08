package com.wip.rayyacub.hockeyplayers.Network;


import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final String URL = "https://jc-xerxes.gpshopper.com/";
    private static Retrofit retrofit = null;

    //retrofit client
    public static Retrofit getClient() {
        if (null == retrofit) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(URL)
                    .client(getRetrofitOkHttpClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    private static OkHttpClient getRetrofitOkHttpClient() {
        HttpLoggingInterceptor localHttpLoggingInterceptor = new HttpLoggingInterceptor();
        localHttpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder().addInterceptor(localHttpLoggingInterceptor).build();
    }
}
