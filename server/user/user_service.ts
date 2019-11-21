import { User } from "./User";
import { Passwords } from "../password_hash/password";
import * as UUID from 'uuid';

export class UserService{
    public static readonly USERS :User[] = [];

    public static create(username :string, password :string) :void{
        this.USERS.push(new User(
            UUID.v4.toString(),
            username,
            password
        ));
    }

    public static checkLogin(user :User) :boolean{
        for(let usr of this.USERS){
            if(usr.username === user.username){
                if(Passwords.equal(usr.password, user.password)){
                    return true;
                }
            }
        }

        return false;
    }
}