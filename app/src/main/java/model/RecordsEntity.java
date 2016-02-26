package model;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 02/02/2016.
 */
public class RecordsEntity {

    @Expose
    private List<Record> records = new ArrayList<>();

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

    public static class Record implements BaseEntity {


        @Expose
        private int id;
        @Expose
        private String title;
        @Expose
        private String userName;
        @Expose
        private String password;
        @Expose
        private Category category;
        @Expose
        private String website;
        @Expose
        private String notes;

        @Expose
        private boolean selected;

        @Expose
        private List<AdditionalRecord> additionalRecordList = new ArrayList<>();


        @Override
        public String getTitle() {
            return title;
        }

        @Override
        public void setSelelected(boolean isSelected) {
            this.selected = isSelected;
        }

        @Override
        public boolean isSelected() {
            return selected;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Category getCategory() {
            return category;
        }

        public void setCategory(Category category) {
            this.category = category;
        }

        public String getWebsite() {
            return website;
        }

        public void setWebsite(String website) {
            this.website = website;
        }

        public String getNotes() {
            return notes;
        }

        public void setNotes(String notes) {
            this.notes = notes;
        }

        public List<AdditionalRecord> getAdditionalRecordList() {
            return additionalRecordList;
        }

        public void setAdditionalRecordList(List<AdditionalRecord> additionalRecordList) {
            this.additionalRecordList = additionalRecordList;
        }

        @Override
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @Override
        public boolean equals(Object object) {
            if (object != null && object instanceof Record) {
                return this.id == ((Record) object).getId();
            }
            return false;

        }

        @Override
        public int hashCode() {
            return this.id;
        }
    }

    public static class AdditionalRecord implements BaseEntity {

        @Expose
        int id;

        @Expose
        private String title;
        @Expose
        private String additionalRecordPassword;

        @Expose
        private boolean selected;

        @Override
        public String getTitle() {
            return title;
        }

        @Override
        public void setSelelected(boolean isSelected) {
            this.selected = isSelected;
        }

        @Override
        public boolean isSelected() {
            return selected;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAdditionalRecordPassword() {
            return additionalRecordPassword;
        }

        public void setAdditionalRecordPassword(String additionalRecordPassword) {
            this.additionalRecordPassword = additionalRecordPassword;
        }

        @Override
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

    public static class Category implements BaseEntity {
        @Expose
        private int id;

        @Expose
        private String title;

        @Expose
        private boolean selected;

        @Override
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @Override
        public String getTitle() {
            return title;
        }

        @Override
        public void setSelelected(boolean isSelected) {
            this.selected = isSelected;
        }

        @Override
        public boolean isSelected() {
            return selected;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        @Override
        public boolean equals(Object object) {
            if ((object != null) && (object instanceof Category)) {
                return (this.id == ((Category) object).getId());
            }
            return false;
        }

        @Override
        public int hashCode() {
            return this.id;
        }
    }
}
