package at.dev4fun.remindme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class Loading extends AppCompatActivity {

    public static Loading loader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        loader = this;

        Glide.with(getApplicationContext()).load(R.drawable.loading).into(((ImageView)findViewById(R.id.loading_iv_loading)));
    }
}
