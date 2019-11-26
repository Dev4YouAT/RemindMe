package at.dev4fun.remindme.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferences {
    private static Context context;
    private static SharedPreferences sharedPreferences;

    public static void init(Context ctx){
        context = ctx;
        sharedPreferences = context.getSharedPreferences("config", Context.MODE_PRIVATE);
    }

    public static void set(String key, String value){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static void remove(String key){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(key);
        editor.apply();
    }

    public static String get(String key){
        return sharedPreferences.getString(key, "");
    }

    public static boolean exists(String key){
        return sharedPreferences.contains(key);
    }

    public class PreferenceKeys{
        private static final String BASE = "REMIND_ME_";
        public static final String USER_ID = BASE + "USER_ID";
    }
}
