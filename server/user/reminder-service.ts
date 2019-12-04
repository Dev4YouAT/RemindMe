import { Session } from "../session";
import { Reminder } from "../model/reminder";

export class ReminderService extends Session{

    public create(reminder :Reminder) :void{

    }

    public get(userID :string) :Reminder[]{
        let result :Reminder[] = [];

        Session.reminders.forEach(r => {
            if(r.createdBy === userID){
                result.push(r);
            }
        });

        return result;
    }

    public update(reminder :Reminder) :void{

    }

    public delete(id :string) :void{

    }

}