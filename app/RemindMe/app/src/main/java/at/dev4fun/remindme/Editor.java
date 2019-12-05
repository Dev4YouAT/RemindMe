package at.dev4fun.remindme;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDateTime;
import java.util.UUID;

import at.dev4fun.remindme.models.Reminder;

public class Editor extends AppCompatActivity {

    private boolean alreadyExists = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);
    }

    public void onSaveReminder(View view) {
        String name = ((TextView)findViewById(R.id.editor_et_name)).getText().toString();
        char gender = ((RadioButton)findViewById(R.id.editor_rb_male)).isChecked() ? 'm' : 'f';
        LocalDateTime date = null;

        if(name.isEmpty()){
            //TODO: show error toast
            return;
        }

        if(!alreadyExists){
            //TODO: create new reminder
            Reminder r = new Reminder(UUID.randomUUID(), null, LocalDateTime.now(), name, null, date, gender);
        }else{
            //TODO: update existing one
        }
    }

    public void onCancelReminder(View view) {
        finish();
    }

    public void onChooseBirthdate(View view) {
        DatePickerDialog dpd = new DatePickerDialog(this, R.style.ThemeOverlay_AppCompat_Dialog, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                ((TextView)findViewById(R.id.editor_et_birthdate)).setText(String.format("%02d. %02d. %d", dayOfMonth, month, year));
            }
        }, 2000, 1, 1);

        dpd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        dpd.show();
    }
}
