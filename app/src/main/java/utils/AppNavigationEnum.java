package utils;

import com.praxisgs.securesecrets.pages.CategoriesFragment;
import com.praxisgs.securesecrets.pages.CreateRecordFragment;
import com.praxisgs.securesecrets.pages.DisplayAndEditRecordFragment;
import com.praxisgs.securesecrets.pages.PasscodeFragment;
import com.praxisgs.securesecrets.pages.RecordsFragment;
import com.praxisgs.securesecrets.pages.SettingsFragment;

/**
 * Created on 04/02/2016.
 */
public enum AppNavigationEnum {

    SETTINGS(SettingsFragment.TAG,"Settings"),
    CREATE_RECORD(CreateRecordFragment.TAG,"Create Record"),
    RECORD_DETAILS(DisplayAndEditRecordFragment.TAG,"Record"),
    RECORDS(RecordsFragment.TAG,"Records"),
    CATEGORIES(CategoriesFragment.TAG,"Categories"),
    PASSCODE(PasscodeFragment.TAG,"Passcode");

    private String fragmentTag;
    private String title;

    AppNavigationEnum(String fragmentTag,String title){
        this.fragmentTag = fragmentTag;
        this.title = title;
    }


    public String getFragmentTag() {
        return fragmentTag;
    }

    public String getTitle() {
        return title;
    }


}
