package at.dev4fun.remindme.utils;

import at.dev4fun.remindme.api.RemindMeAPI;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    private static final String BASE_URL = "http://10.0.0.15/";

    public static RemindMeAPI API;

    public static Retrofit RETROFIT;

    public static void init(){
        RETROFIT = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        API = RETROFIT.create(RemindMeAPI.class);
    }
}
