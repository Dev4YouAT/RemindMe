package at.dev4fun.remindme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class Loading extends AppCompatActivity {

    public static Loading loader = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        if(loader != null){
            finish();
        }

        loader = this;

        Glide.with(getApplicationContext()).load(R.drawable.loading).into(((ImageView)findViewById(R.id.loading_iv_loading)));
    }
}
