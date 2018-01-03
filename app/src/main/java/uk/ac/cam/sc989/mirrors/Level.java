package uk.ac.cam.sc989.mirrors;

import android.util.Log;

/**
 * Created by Simon on 02/01/2018.
 */

public class Level {
    private static int[] imageResources = {R.drawable.empty_star, R.drawable.full_star};

    private int number;
    private String name;
    private int[][] piece_identifiers;
    private boolean completed;

    public Level(){
        number = 0;
        name = "Boring Level";
        completed = false;
        piece_identifiers = new int[][] {{0, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}};
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

    public int[][] getImages(){
        int[][] imgs = new int[4][4];
        for (int i = 0; i<4; i++){
            int[] row = piece_identifiers[i];
            int[] rowImgs = new int[4];
            for (int j = 0; j<4; j++){
                int piece = row[j];
                rowImgs[j] = imageResources[piece];
            }
            imgs[i]=rowImgs;
        }
        Log.d("LEVEL", imgs.toString());
        return imgs;

    }

}
