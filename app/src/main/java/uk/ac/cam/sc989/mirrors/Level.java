package uk.ac.cam.sc989.mirrors;

/**
 * Created by Simon on 02/01/2018.
 */

public class Level {
    private int number;
    private String name;
    private int[][] piece_identifiers;
    private boolean completed;

    public Level(){
        number = 0;
        name = "Boring Level";
        completed = false;
    }

    public int getNumber(){
        return number;
    }

    public String getName(){
        return name;
    }

    public boolean isCompleted(){
        return completed;
    }

}
