package at.dev4fun.remindme.models;

import androidx.annotation.NonNull;

public class User {
    private final String id;
    private final String notifactionID;
    private final String username;

    public User(String id, String notifactionID, String username) {
        this.id = id;
        this.notifactionID = notifactionID;
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public String getNotifactionID() {
        return notifactionID;
    }

    public String getUsername() {
        return username;
    }

    @NonNull
    @Override
    public String toString() {
        return username;
    }
}
