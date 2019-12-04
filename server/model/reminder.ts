export class Reminder{
    public readonly id :string;
    public readonly createdBy :string;
    public readonly createdOn :Date;
    public name :string;
    public imageName :string;
    public birthdate :Date;
    public gender :string;

    constructor(id :string, createdBy :string, createdOn :Date, name :string, imageName :string, birthdate :Date, gender :string){
        this.id = id;
        this.createdBy = createdBy;
        this.createdOn = createdOn;
        this.name = name;
        this.imageName = imageName;
        this.birthdate = birthdate;
        this.gender = gender;
    }
}