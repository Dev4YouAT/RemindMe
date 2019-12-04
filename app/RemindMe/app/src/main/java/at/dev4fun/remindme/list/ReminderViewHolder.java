package at.dev4fun.remindme.list;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import at.dev4fun.remindme.models.Reminder;

public class ReminderViewHolder extends RecyclerView.ViewHolder {

    private LinearLayout container;
    private ImageView image;
    private TextView name;
    private TextView birthdate;

    private Reminder reminder;

    public ReminderViewHolder(@NonNull View itemView, LinearLayout container, ImageView image, TextView name, TextView birthdate) {
        super(itemView);
        this.container = container;
        this.image = image;
        this.name = name;
        this.birthdate = birthdate;

        container.setOnClickListener(this::onClick);
    }

    private void onClick(View view){
        //TODO: implement edit mode
    }

    public void setReminder(Reminder reminder) {
        this.reminder = reminder;
    }

    public LinearLayout getContainer() {
        return container;
    }

    public void setContainer(LinearLayout container) {
        this.container = container;
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }

    public TextView getName() {
        return name;
    }

    public void setName(TextView name) {
        this.name = name;
    }

    public TextView getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(TextView birthdate) {
        this.birthdate = birthdate;
    }
}
