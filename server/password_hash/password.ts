
export class Passwords{
    public static get(password :string) :string{
        let encrypted :string = new Buffer(password).toString('Base64');
        return encrypted;
    }

    public static equal(password_1 :string, password_2 :string, isEncrpyted :boolean = true) :boolean{
        return isEncrpyted ? password_1 === password_2 : password_1 === this.get(password_2);
    }
}