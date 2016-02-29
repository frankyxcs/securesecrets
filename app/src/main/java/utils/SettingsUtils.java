package utils;

import java.util.ArrayList;
import java.util.List;

import model.BaseEntity;
import model.SettingsEntity;

/**
 * Created on 29/02/2016.
 */
public class SettingsUtils {
    public static List<BaseEntity> getSettings() {
        List<BaseEntity> settings = new ArrayList();

        SettingsEnum[] settingEnum = SettingsEnum.values();
        for (SettingsEnum tempSettingEnum : settingEnum) {
            SettingsEntity.Setting newSetting = new SettingsEntity.Setting();
            newSetting.setId(tempSettingEnum.getId());
            newSetting.setTitle(tempSettingEnum.getTitle());
            settings.add(newSetting);
        }
        return settings;
    }
}
