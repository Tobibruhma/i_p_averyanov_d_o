package com.example.i_p_averyanov_d_o;

import java.util.HashMap;
import java.util.Map;

public class User
{
    public static final String EMAIL ="email";

    public static final String PASSWORD ="password";
    public static final String ID ="_id";


   // public static final String USER = "user:{" + EMAIL + "," + PASSWORD + "}";
    // public static final String FIRST_NAME ="firstName";
    //public static final String LAST_NAME ="lastName";


    private static  User CurrentUser;

    public static User getCurrentUser() {
        if(CurrentUser==null)
            CurrentUser = new User();
        return CurrentUser;
    }
    private String token;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

