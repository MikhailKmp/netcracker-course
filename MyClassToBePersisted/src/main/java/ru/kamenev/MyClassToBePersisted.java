package ru.kamenev;

import java.io.Serializable;

public class MyClassToBePersisted implements Serializable {

    private String profile;
    private String group;

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}