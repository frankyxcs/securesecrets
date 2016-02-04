package utils;

import com.praxisgs.securesecrets.pages.CategoriesFragment;

/**
 * Created on 04/02/2016.
 */
public enum AppNavigationEnum {

    CATEGORIES(CategoriesFragment.TAG,"Categories");

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
