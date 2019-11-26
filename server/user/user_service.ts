import { Passwords } from "../password_hash/password";
import * as UUID from 'uuid';
import * as FileSystem from 'fs';
import * as Path from 'path';
import { Session } from "../session";
import { User } from "./user";

export class UserService extends Session{

    constructor(){
        super();
        this.load();
    }

    public create(username :string, password :string) :User{
        if(this.existsByUsername(username)){
            let nullResult :any = null;
            return nullResult;
        }

        let user :User = new User(
            UUID.v4.toString(),
            '',
            username,
            password
        );

        Session.users.push(user);

        this.save();

        return user;
    }

    public checkLogin(user :User) :User{
        for(let usr of Session.users){
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
        Session.users = JSON.parse(FileSystem.readFileSync(Path.join(__dirname, '..', 'configs', 'user.json')).toString());
    }

    private save() :void{
        FileSystem.writeFileSync(Path.join(__dirname, '..', 'configs', 'user.json'), JSON.stringify(Session.users));
    }
}