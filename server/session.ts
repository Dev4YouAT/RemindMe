import { User } from "./user/user";

export class Session{
    protected static users :User[] = [];

    public static init(users :User[]) :void{
        this.users = [...users];
    }

    public static add(user :User) :boolean{
        if(this.exists(user)){
            return false;
        }

        this.users.push(user);
        return true;
    }

    public static remove(user :User) :boolean{
        if(!this.exists(user)){
            return false;
        }

        let index :number = this.getIndex(user);

        if(index == -1){
            return false;
        }

        this.users.splice(index, 1);

        return true;
    }

    public static exists(user :User) :boolean{
        return this.getIndex(user) != -1;
    }

    public static getAll() :User[]{
        return [...this.users];
    }

    protected existsByUsername(username :string) :boolean{
        for(let i = 0; i < Session.users.length; i++){
            if(Session.users[i].username === username){
                return true;
            }
        }

        return false;
    }

    private static getIndex(user :User) :number{
        for(let i = 0; i < this.users.length; i++){
            if(this.users[i].equals(user)){
                return i;
            }
        }

        return -1;
    }
}