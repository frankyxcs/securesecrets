package model;

import java.util.ArrayList;

/**
 * Created on 29/02/2016.
 */
public class SettingsEntity {

    ArrayList<Setting> settings = new ArrayList<>();


    public ArrayList<Setting> getSettings() {
        return settings;
    }

    public void setSettings(ArrayList<Setting> settings) {
        this.settings = settings;
    }

    public static class Setting implements BaseEntity {
        private int mId;
        private String mTitle;
        private boolean mSelected;

        @Override
        public int getId() {
            return mId;
        }

        @Override
        public String getTitle() {
            return mTitle;
        }

        @Override
        public void setSelected(boolean isSelected) {
            mSelected = isSelected;
        }

        @Override
        public boolean isSelected() {
            return mSelected;
        }

        @Override
        public void setId(int mId) {
            this.mId = mId;
        }

        @Override
        public void setTitle(String mTitle) {
            this.mTitle = mTitle;
        }
    }

}
