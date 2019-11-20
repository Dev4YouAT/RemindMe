package at.dev4fun.remindme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import at.dev4fun.remindme.models.User;
import at.dev4fun.remindme.utils.RetrofitService;
import retrofit2.Call;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RetrofitService.init();

        //Toast.makeText(getApplicationContext(), RetrofitService.RETROFIT + "", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}
