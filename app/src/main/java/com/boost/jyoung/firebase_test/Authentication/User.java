package com.boost.jyoung.firebase_test.Authentication;

/**
 * Created by jyoung on 2017. 7. 10..
 */

public class User {

    String email;
    String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }





}
