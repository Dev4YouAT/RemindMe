package at.dev4fun.remindme.utils;

public enum Codes {
    CREATE_NEW_REMINDER(100),
    EDIT_EXISTING_REMINDER(101);

    private final int value;

    Codes(final int newValue) {
        value = newValue;
    }

    public int getValue() { return value; }
}
