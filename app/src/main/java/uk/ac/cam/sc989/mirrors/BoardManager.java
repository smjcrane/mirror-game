package uk.ac.cam.sc989.mirrors;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by Simon on 03/01/2018.
 */

public class BoardManager{
    private Context mContext;
    private Level level;
    private GridLayout grid;
    private int width;
    private int height;
    private int screenWidth;

    public BoardManager(Context c, GridLayout grid, Level level) {
        mContext = c;
        this.level = level;
        this.grid = grid;
        this.height = level.getImages().length;
        this.width = level.getImages()[0].length;
        grid.setColumnCount(width);
    }

    public void draw(){
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) mContext).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        screenWidth = displayMetrics.widthPixels;

        clear();
        for (int i =0; i < width * height; i ++){
            grid.addView(getView(i));
        }
    }

    public void clear(){
        for (int i = 0; i < grid.getChildCount();){
            grid.removeView(grid.getChildAt(0));
        }

    }

    public int getCount() {
        return 16;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView
    public View getView(final int position) {
        ImageView imageView;
        imageView = new ImageView(mContext);
        imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setPadding(8, 8, 8, 8);
        GridView.LayoutParams params = new GridView.LayoutParams(screenWidth / (width+1), screenWidth / (width+1));
        imageView.setImageResource(level.getImages()[position / width][position % width]);
        imageView.setLayoutParams(params);
        imageView.setRotation(level.getRotations()[position / width][position % width] * 90);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                level.rotate(position % width, position / width);
                draw();
            }
        });
        return imageView;
    }

}