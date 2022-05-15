package com.example.prac2;

public class User {
    String name;
    String description;
    Integer id;
    Boolean followed;

    // Constructor Declaration of Class
    public User(String name, String description,
               int id, Boolean followed)
    {
        this.name = name;
        this.description = description;
        this.id = id;
        this.followed = followed;
    }

    // method 1
    public String getName()
    {
        return name;
    }

    // method 2
    public String getdescription()
    {
        return description;
    }

    // method 3
    public int getid()
    {
        return id;
    }

    // method 4
    public Boolean getfollowed()
    {
        return followed;
    }
}
