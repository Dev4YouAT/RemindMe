import { Passwords } from "../password_hash/password";

export class User{
    public readonly id :string;
    public readonly username :string;
    public readonly password :string;

    constructor(id :string, username :string, password :string, isEncrypted :boolean = false){
        this.id = id;
        this.username = username;
        this.password = !isEncrypted ? Passwords.get(password) : password;
    }
}