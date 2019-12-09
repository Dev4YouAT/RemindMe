import { Session } from "../session";
import { Reminder } from "../model/reminder";
import * as UUID from 'uuid';
import * as FileSystem from 'fs';
import * as Path from 'path';

export class ReminderService extends Session{

    constructor(){
        super();
        this.load();
    }

    public create(reminder :Reminder) :void{
        Session.reminders.push(reminder);
        this.save();
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
        for(let i = 0; i < Session.reminders.length; i++){
            if(Session.reminders[i].id === reminder.id){
                Session.reminders[i] = reminder;
                this.save();
                return;
            }
        }
    }

    public delete(id :string) :void{
        for(let i = 0; i < Session.reminders.length; i++){
            if(Session.reminders[i].id === id){
                Session.reminders.splice(i, 1);
                this.save();
                return;
            }
        }
    }

    private load() :void{
        Session.reminders = JSON.parse(FileSystem.readFileSync(Path.join(__dirname, '..', 'configs', 'reminders.json')).toString());
    }

    private save() :void{
        FileSystem.writeFileSync(Path.join(__dirname, '..', 'configs', 'reminders.json'), JSON.stringify(Session.reminders));
    }
}