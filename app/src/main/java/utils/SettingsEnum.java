package utils;

/**
 * Created on 29/02/2016.
 */
public enum SettingsEnum {
    HELP(1, "Help"),
    ABOUT(2,"About"),
    CHANGE_PASSCODE(3,"Change Passcode"),
    RESET_PASSCODE(4,"Reset Passcode"),
    BACKUP_SETTINGS(5,"Backup Settings");


    private final int mId;
    private final String mTitle;

    SettingsEnum(int id, String title) {
        this.mId = id;
        this.mTitle = title;
    }

    public int getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }
}
