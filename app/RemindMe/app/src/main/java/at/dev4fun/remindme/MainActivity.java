package at.dev4fun.remindme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import at.dev4fun.remindme.models.User;
import at.dev4fun.remindme.utils.Loader;
import at.dev4fun.remindme.utils.Preferences;
import at.dev4fun.remindme.utils.RetrofitService;
import retrofit2.Call;

public class MainActivity extends AppCompatActivity {

    public static MainActivity main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main = this;

        init();

        if(!Preferences.exists(Preferences.PreferenceKeys.USER_ID)){
            Intent intent = new Intent(this, Login.class);
            startActivity(intent);
        }
    }

    public void initComponents(){

    }

    private void init(){
        Preferences.init(getApplication());
        RetrofitService.init();
    }
}
