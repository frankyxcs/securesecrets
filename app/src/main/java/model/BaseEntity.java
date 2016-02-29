package model;

/**
 * Created on 11/02/2016.
 */
public interface BaseEntity {
    int getId();

    void setId(int id);

    String getTitle();

    void setTitle(String title);

    void setSelected(boolean isSelected);

    boolean isSelected();
}
