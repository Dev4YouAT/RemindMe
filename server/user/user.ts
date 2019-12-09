import { Passwords } from "../password_hash/password";
import { Reminder } from "../model/reminder";

export class User{
    public readonly id :string;
    public readonly notificationID :string;
    public readonly username :string;
    public readonly password :string;

    constructor(id :string, notificationID :string, username :string, password :string, isEncrypted :boolean = false){
        this.id = id;
        this.notificationID = notificationID;
        this.username = username;
        this.password = !isEncrypted ? Passwords.get(password) : password;
    }

    public equals(user :User) :boolean{
        return this.id === user.id;
    }
}