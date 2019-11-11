/**
 * The app demonstrates screen rotation event in Android.
 *
 * @author Rustam Galimov
 * @version 1.0
 * @since 14.11.2019
 */
package ru.job4j.a321.model;

import java.util.Date;

public class Employee {
    private String name;
    private String sureName;
    private Date birthday;
    private String photoURL;
    private Position position;

    public Employee(String name,
                    String sureName,
                    Date birthday,
                    String photoURL,
                    Position position) {

        this.name = name;
        this.sureName = sureName;
        this.birthday = birthday;
        this.photoURL = photoURL;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSureName() {
        return sureName;
    }

    public void setSureName(String sureName) {
        this.sureName = sureName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
