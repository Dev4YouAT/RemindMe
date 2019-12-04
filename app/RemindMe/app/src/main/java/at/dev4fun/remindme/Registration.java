package at.dev4fun.remindme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Base64;

import at.dev4fun.remindme.models.User;
import at.dev4fun.remindme.reponses.BaseReponse;
import at.dev4fun.remindme.utils.Loader;
import at.dev4fun.remindme.utils.Preferences;
import at.dev4fun.remindme.utils.RetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        findViewById(R.id.registration_bt_register).setOnClickListener(this::onRegister);
        findViewById(R.id.registration_tv_to_login).setOnClickListener(this::onGoToLogin);
    }

    public void onRegister(View view) {
        if(!((EditText)findViewById(R.id.registration_et_password)).getText().toString().equals(
                ((EditText)findViewById(R.id.registration_et_password_repeat)).getText().toString())){
            Toast.makeText(getApplicationContext(), getString(R.string.passwords_do_not_match), Toast.LENGTH_LONG).show();
            return;
        }
        Call<BaseReponse> call  = RetrofitService.API.makeRegistration(((EditText)findViewById(R.id.registration_et_username)).getText().toString(),
                Base64.getEncoder().encodeToString(((EditText)findViewById(R.id.registration_et_password)).getText().toString().getBytes()));

        Loader.show();

        call.enqueue(new Callback<BaseReponse>() {
            @Override
            public void onResponse(Call<BaseReponse> call, Response<BaseReponse> response) {
                BaseReponse data = response.body();

                Loader.hide();

                if(data == null || data.getData() == null || data.getData().equals("")){
                    Toast.makeText(getApplicationContext(), getString(R.string.username_already_taken), Toast.LENGTH_LONG).show();
                    return;
                }

                Preferences.set(Preferences.PreferenceKeys.USER_ID, data.getData());
                finish();
            }

            @Override
            public void onFailure(Call<BaseReponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                Loader.hide();
            }
        });
    }

    public void onGoToLogin(View view) {
        MainActivity.main.startActivity(new Intent(MainActivity.main, Login.class));
        finish();
    }
}
