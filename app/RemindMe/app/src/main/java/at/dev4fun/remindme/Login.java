package at.dev4fun.remindme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import at.dev4fun.remindme.api.RemindMeAPI;
import at.dev4fun.remindme.models.User;
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
        Call<User> call  = RetrofitService.API.makeLogin("", "");
        //Call<String> call  = RetrofitService.API.test();

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Toast.makeText(getApplicationContext(), response.message(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void onGoToRegistration(View view) {
    }
}
