package com.example.pajama.trackfoodtruck.userData;

import java.util.Set;

public class User {

    private String id;
    private String username;
    private String password;
    private String lastlogin;
    private String name;
    private String surname;
    private int age;
    //private Set<String> favouriteFoodTrucks;

    public User(String id, String username, String password, String lastlogin, String name, String surname, int age) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.lastlogin = lastlogin;
        this.name = name;
        this.surname = surname;
        this.age = age;
        //this.favouriteFoodTrucks = favouriteFoodTrucks;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getLastlogin() {
        return lastlogin;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

//    public Set<String> getFavouriteFoodTrucks() {
//        return favouriteFoodTrucks;
//    }


}
