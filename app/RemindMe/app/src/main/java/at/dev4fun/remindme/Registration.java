package at.dev4fun.remindme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class Registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        findViewById(R.id.registration_bt_register).setOnClickListener(this::onRegister);
        findViewById(R.id.registration_tv_to_login).setOnClickListener(this::onGoToLogin);
    }

    public void onGoToLogin(View view) {
    }

    public void onRegister(View view) {
    }
}
