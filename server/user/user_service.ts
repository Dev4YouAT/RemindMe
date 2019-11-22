import { User } from "./User";
import { Passwords } from "../password_hash/password";
import * as UUID from 'uuid';
import * as FileSystem from 'fs';
import * as Path from 'path';

export class UserService{
    public static USERS :User[] = [];

    constructor(){
        this.load();
    }

    public create(username :string, password :string) :void{
        UserService.USERS.push(new User(
            UUID.v4.toString(),
            '',
            username,
            password
        ));

        this.save();
    }

    public checkLogin(user :User) :User{
        for(let usr of UserService.USERS){
            if(usr.username === user.username){
                if(Passwords.equal(usr.password, user.password)){
                    return usr;
                }
            }
        }

        let nullUser :User | any = null;

        return nullUser;
    }

    private load() :void{
        UserService.USERS = JSON.parse(FileSystem.readFileSync(Path.join(__dirname, '..', 'configs', 'user.json')).toString());
    }

    private save() :void{
        FileSystem.writeFileSync(Path.join(__dirname, '..', 'configs', 'user.json'), JSON.stringify(UserService.USERS));
    }
}