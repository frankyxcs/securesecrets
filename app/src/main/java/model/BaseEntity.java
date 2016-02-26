package model;

/**
 * Created on 11/02/2016.
 */
public interface BaseEntity {
    int getId();
    String getTitle();
    void setSelelected(boolean isSelected);
    boolean isSelected();
}
