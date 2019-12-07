package at.dev4fun.remindme.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import at.dev4fun.remindme.api.RemindMeAPI;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    private static final String BASE_URL = "http://10.0.0.15:80/";

    public static RemindMeAPI API;

    public static Retrofit RETROFIT;

    public static void init(){
        Gson gson = new GsonBuilder()
                //.setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
                .create();

        RETROFIT = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        API = RETROFIT.create(RemindMeAPI.class);
    }
}

class LocalDateTimeTypeAdapter extends TypeAdapter<LocalDateTime> {

    private final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    @Override
    public void write(JsonWriter out, LocalDateTime date) throws IOException {
        if (date == null) {
            out.nullValue();
        } else {
            out.value(formatter.format(date));
        }
    }

    @Override
    public LocalDateTime read(JsonReader in) throws IOException {
        switch (in.peek()) {
            case NULL:
                in.nextNull();
                return null;
            default:
                String date = in.nextString();
                return LocalDateTime.parse(date, formatter);
        }
    }
}

