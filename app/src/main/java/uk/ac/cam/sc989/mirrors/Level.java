package uk.ac.cam.sc989.mirrors;

/**
 * Created by Simon on 02/01/2018.
 */

public class Level {
    public static final int BLANK = 0;
    public static final int DIAGONAL = 1;
    public static final int ROUND = 2;
    private static int[] imageResources = {R.drawable.blank, R.drawable.simple_diagonal, R.drawable.round};

    private int number;
    private String name;
    private int[][] piece_identifiers;
    private int[][] piece_rotations;
    private boolean completed;
    private int height;
    private int width;

    public Level(int number){
        this.number = number;
        name = "Level " + Integer.toString(number);
        completed = false;
        piece_identifiers = easyLevelsIdentifiers[number];
        piece_rotations = easyLevelsRotations[number];
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

    public void rotate(int x, int y){
        piece_rotations[y][x] += 1;
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
        return imgs;
    }

    public int[][] getRotations(){
        return piece_rotations;
    }

    private static int[][][] easyLevelsIdentifiers = {
            {{0, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}},
            {{1, 0, 0, 1}, {0, 0, 0, 0}, {0, 0, 0, 0}, {1, 0, 0, 1}},
            {{1, 0, 1, 0, 1}, {0, 1, 0, 1, 0}, {1, 0, 2, 0, 0}, {0, 0, 0, 0, 0}, {1, 0, 0, 1, 0}}
    };

    private static int[][][] easyLevelsRotations = {
            {{0, 0, 0, 0}, {0, 2, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}},
            {{1, 0, 0, 2}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 3}},
            {{2, 0, 3, 0, 1}, {0, 1, 0, 3, 0}, {2, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {2, 0, 0, 3, 0}}
    };



    public static int getNumberOfLevels(){
        return easyLevelsIdentifiers.length;
    }
}
