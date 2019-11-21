const hash = require('password-hash');

export class Passwords{
    public static get(password :string) :string{
        return hash.generate(password);
    }

    public static equal(password_1 :string, password_2 :string) :boolean{
        return password_1 === password_2;
    }
}