package at.dev4fun.remindme.utils;

import android.content.Intent;
import android.widget.Toast;

import at.dev4fun.remindme.Loading;
import at.dev4fun.remindme.MainActivity;

public class Loader {

    public static void show(){
        Intent loader = new Intent(MainActivity.main, Loading.class);
        MainActivity.main.startActivity(loader);
    }

    public static void hide(){
        while(Loading.loader == null){}
        Loading.loader.finish();
    }
}
