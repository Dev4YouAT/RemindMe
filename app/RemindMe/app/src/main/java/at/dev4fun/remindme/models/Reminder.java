package at.dev4fun.remindme.models;

import java.time.LocalDateTime;

public class Reminder {
    private final String id;
    private final String createdBy;
    private final LocalDateTime createdOn;
    private String name;
    private String imageName;
    private LocalDateTime birthdate;
    private char gender;

    public Reminder(String id, String createdBy, LocalDateTime createdOn, String name, String imageName, LocalDateTime birthdate, char gender) {
        this.id = id;
        this.createdBy = createdBy;
        this.createdOn = createdOn;
        this.name = name;
        this.imageName = imageName;
        this.birthdate = birthdate;
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public LocalDateTime getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDateTime birthdate) {
        this.birthdate = birthdate;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
}
