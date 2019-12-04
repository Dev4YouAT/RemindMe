package at.dev4fun.remindme.list;

import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;

import at.dev4fun.remindme.MainActivity;
import at.dev4fun.remindme.R;
import at.dev4fun.remindme.models.Reminder;

public class ReminderAdapater extends RecyclerView.Adapter<ReminderViewHolder> {

    private List<Reminder> reminders;

    public ReminderAdapater(List<Reminder> reminders) {
        this.reminders = reminders;

        this.reminders.sort((r1, r2) -> {
            if(r1.getBirthdate().getMonthValue() == r2.getBirthdate().getMonthValue()){
                return Integer.compare(r1.getBirthdate().getDayOfMonth(), r2.getBirthdate().getDayOfMonth());
            }

            return Integer.compare(r1.getBirthdate().getMonthValue(), r2.getBirthdate().getMonthValue());
        });
    }

    @NonNull
    @Override
    public ReminderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.reminder_item, parent, false);
        return new ReminderViewHolder(view, view.findViewById(R.id.list_container), view.findViewById(R.id.list_iv_image), view.findViewById(R.id.list_tv_name), view.findViewById(R.id.list_tv_birthdate));
    }

    @Override
    public void onBindViewHolder(@NonNull ReminderViewHolder holder, int position) {
        Reminder reminder = reminders.get(position);

        holder.setReminder(reminder);
        holder.getName().setText(reminder.getName() + " (" + Period.between(reminder.getBirthdate().toLocalDate(), LocalDate.now()).getYears() + ")");
        holder.getBirthdate().setText(reminder.getBirthdate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        holder.getImage().setImageResource(reminder.getGender() == 'm' ? R.drawable.ic_boy : R.drawable.ic_girl);

        if(reminder.getBirthdate().getDayOfMonth() == LocalDate.now().getDayOfMonth() && reminder.getBirthdate().getMonthValue() == LocalDate.now().getMonthValue()){
            holder.getContainer().setBackgroundTintList(ColorStateList.valueOf(MainActivity.main.getColor(R.color.today)));
        }
    }

    @Override
    public int getItemCount() {
        return reminders.size();
    }

    public void addMany(List<Reminder> param){
        reminders.addAll(param);
        this.notifyDataSetChanged();
    }
}
