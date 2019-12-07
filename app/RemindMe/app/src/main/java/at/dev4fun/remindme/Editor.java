package at.dev4fun.remindme;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import at.dev4fun.remindme.models.Reminder;
import at.dev4fun.remindme.utils.Codes;

public class Editor extends AppCompatActivity {

    private boolean alreadyExists = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        alreadyExists = getIntent().getBooleanExtra("alreadyExists", false);

        if(alreadyExists){
            ((TextView)findViewById(R.id.editor_et_name)).setText(getIntent().getStringExtra("name"));

            if(getIntent().getCharExtra("gender", 'm') == 'm'){
                ((RadioButton)findViewById(R.id.editor_rb_male)).setChecked(true);
            }else{
                ((RadioButton)findViewById(R.id.editor_rb_female)).setChecked(true);
            }

            ((TextView)findViewById(R.id.editor_et_birthdate)).setText(getIntent().getStringExtra("birthdate"));
        }
    }

    public void onSaveReminder(View view) {
        String name = ((TextView)findViewById(R.id.editor_et_name)).getText().toString();
        char gender = ((RadioButton)findViewById(R.id.editor_rb_male)).isChecked() ? 'm' : 'f';
        LocalDateTime birthdate = LocalDateTime.of(LocalDate.parse(((TextView)findViewById(R.id.editor_et_birthdate)).getText(), DateTimeFormatter.ofPattern("dd.MM.yyyy")), LocalTime.of(0, 0));

        if(name.isEmpty()){
            Toast.makeText(getApplicationContext(), getString(R.string.name_has_to_be_given), Toast.LENGTH_LONG).show();
            return;
        }

        setResult(alreadyExists ? Codes.EDIT_EXISTING_REMINDER.getValue() : Codes.CREATE_NEW_REMINDER.getValue());
        Intent intent = getIntent();
        intent.putExtra("name", name);
        intent.putExtra("gender", gender);
        intent.putExtra("birthdate", birthdate);
        finish();
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
