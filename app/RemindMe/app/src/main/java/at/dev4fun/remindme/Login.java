package at.dev4fun.remindme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Base64;

import at.dev4fun.remindme.api.RemindMeAPI;
import at.dev4fun.remindme.models.User;
import at.dev4fun.remindme.utils.Preferences;
import at.dev4fun.remindme.utils.RetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViewById(R.id.login_bt_login).setOnClickListener(this::onLogin);
        findViewById(R.id.login_tv_to_registration).setOnClickListener(this::onGoToRegistration);
    }

    public void onLogin(View view) {
        Call<User> call  = RetrofitService.API.makeLogin(((EditText)findViewById(R.id.login_et_username)).getText().toString(),
                            Base64.getEncoder().encodeToString(((EditText)findViewById(R.id.login_et_password)).getText().toString().getBytes()));

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();

                if(user == null){
                    Toast.makeText(getApplicationContext(), getString(R.string.invalid_login), Toast.LENGTH_LONG).show();
                    return;
                }

                Preferences.set(Preferences.PreferenceKeys.USER_ID, user.getId());
                finish();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void onGoToRegistration(View view) {
        MainActivity.main.startActivity(new Intent(MainActivity.main, Registration.class));
        finish();
    }
}
