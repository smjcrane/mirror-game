package uk.ac.cam.sc989.mirrors;

import android.util.Log;

/**
 * Created by Simon on 02/01/2018.
 */

public class Level {
    private static int[] imageResources = {R.drawable.blank, R.drawable.simple_diagonal};

    private int number;
    private String name;
    private int[][] piece_identifiers;
    private boolean completed;
    private int height;
    private int width;

    public Level(int number){
        this.number = number;
        name = "Boring Level";
        completed = false;
        piece_identifiers = easyLevels[number];
        this.height = piece_identifiers.length;
        this.width = piece_identifiers[0].length;
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
        int[][] imgs = new int[height][width] ;
        for (int i = 0; i<height; i++){
            int[] row = piece_identifiers[i];
            int[] rowImgs = new int[width];
            for (int j = 0; j<width; j++){
                int piece = row[j];
                rowImgs[j] = imageResources[piece];
            }
            imgs[i]=rowImgs;
        }
        Log.d("LEVEL", imgs.toString());
        return imgs;

    }

    private static int[][][] easyLevels = {
            {{0, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}},
            {{1, 0, 0, 1}, {0, 0, 0, 0}, {0, 0, 0, 0}, {1, 0, 0, 1}},
            {{1, 0, 1, 0, 1}, {0, 1, 0, 1, 0}, {1, 0, 1, 0, 0}, {0, 0, 0, 1, 0}, {1, 0, 0, 1, 0}}
    };

    public static int getNumberOfLevels(){
        return easyLevels.length;
    }
}
