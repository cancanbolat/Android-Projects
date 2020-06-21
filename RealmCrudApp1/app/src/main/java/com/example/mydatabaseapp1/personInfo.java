package com.example.mydatabaseapp1;

import io.realm.RealmObject;
import io.realm.annotations.RealmClass;

@RealmClass
public class personInfo extends RealmObject {

    private String username;
    private String name;
    private String password;
    private String malefemale;



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMalefemale() {
        return malefemale;
    }

    public void setMalefemale(String malefemale) {
        this.malefemale = malefemale;
    }

    @Override
    public String toString() {
        return "personInfo{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", malefemale='" + malefemale + '\'' +
                '}';
    }
}
