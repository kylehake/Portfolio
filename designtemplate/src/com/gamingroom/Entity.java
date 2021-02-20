package com.gamingroom;

/**
 * A class used to hold common attributes behaviors of the
 * child classes Game, Team, and Player.
 *
 */

public class Entity {

    //Variables
    long id;
    String name;

    //Default Constructors
    private Entity () {
        this.id = 0;
        this.name = "";

    }

    //Overloaded Constructors

    //Constructor with id and name
    public Entity (long id, String name) {
        this();
        this.id = id;
        this.name = name;
    }

    //Methods

    //returns id
    public long getId () {
        return id;
    }

    //returns name
    public String getName () {
        return name;
    }

    //returns string of variables
    public String toString() {

        return "Entity [id=" + id + ", name=" + name + "]";
    }
}
