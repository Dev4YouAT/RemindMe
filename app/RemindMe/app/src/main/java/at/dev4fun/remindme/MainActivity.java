package at.dev4fun.remindme;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import at.dev4fun.remindme.list.ReminderAdapater;
import at.dev4fun.remindme.models.Reminder;
import at.dev4fun.remindme.models.User;
import at.dev4fun.remindme.utils.Codes;
import at.dev4fun.remindme.utils.Loader;
import at.dev4fun.remindme.utils.Preferences;
import at.dev4fun.remindme.utils.RetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public static MainActivity main;

    private ReminderAdapater reminderAdapater;

    private FloatingActionButton btCreateReminder;
    private RecyclerView rvReminders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        Preferences.remove(Preferences.PreferenceKeys.USER_ID);
        if(!Preferences.exists(Preferences.PreferenceKeys.USER_ID)){
            Intent intent = new Intent(this, Login.class);
            startActivity(intent);
            return;
        }

        loadReminders();
    }

    private void init(){
        Preferences.init(getApplication());
        RetrofitService.init();
        main = this;

        btCreateReminder = findViewById(R.id.main_create_reminder);
        rvReminders = findViewById(R.id.main_rv_reminders);

        btCreateReminder.setOnClickListener(this::onCreateReminder);

        reminderAdapater = new ReminderAdapater(new ArrayList<Reminder>()/*{{
            add(new Reminder(null, null, null, "Max Mustermann", "", LocalDate.of(1993, 8, 19), 'm'));
            add(new Reminder(null, null, null, "Max Musterfrau", "", LocalDate.of(1987, 11, 29), 'f'));
        }}*/);
        rvReminders.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvReminders.setAdapter(reminderAdapater);
    }

    private void onCreateReminder(View view){
        startActivityForResult(new Intent(this, Editor.class), Codes.CREATE_NEW_REMINDER.getValue());
    }

    public static void loadReminders(){
        Loader.show();

        Call<Reminder[]> call  = RetrofitService.API.getReminders(Preferences.get(Preferences.PreferenceKeys.USER_ID));

        call.enqueue(new Callback<Reminder[]>() {
            @Override
            public void onResponse(Call<Reminder[]> call, Response<Reminder[]> response) {
                Reminder[] reminders = response.body();
                main.reminderAdapater.addMany(Arrays.asList(reminders));
                Loader.hide();
            }

            @Override
            public void onFailure(Call<Reminder[]> call, Throwable t) {
                Loader.hide();
                Toast.makeText(main.getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == Codes.CREATE_NEW_REMINDER.getValue() && resultCode == Codes.CREATE_NEW_REMINDER.getValue()){
            //TODO: make api request
        }else if(requestCode == Codes.EDIT_EXISTING_REMINDER.getValue() && resultCode == Codes.EDIT_EXISTING_REMINDER.getValue()){

        }
    }
}
