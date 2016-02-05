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

    public static class Record {
        @Expose
        private String title;
        @Expose
        private String userName;
        @Expose
        private String password;
        @Expose
        private String category;
        @Expose
        private String website;
        @Expose
        private String notes;

        @Expose
        private List<AdditionalRecord> additionalRecordList = new ArrayList<>();

        public String getTitle() {
            return title;
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

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
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
    }

    public static class AdditionalRecord {
        @Expose
        private String addtionalRecordTitle;
        @Expose
        private String adddtionalRecordPassword;

        public String getAddtionalRecordTitle() {
            return addtionalRecordTitle;
        }

        public void setAddtionalRecordTitle(String addtionalRecordTitle) {
            this.addtionalRecordTitle = addtionalRecordTitle;
        }

        public String getAdddtionalRecordPassword() {
            return adddtionalRecordPassword;
        }

        public void setAdddtionalRecordPassword(String adddtionalRecordPassword) {
            this.adddtionalRecordPassword = adddtionalRecordPassword;
        }
    }
}