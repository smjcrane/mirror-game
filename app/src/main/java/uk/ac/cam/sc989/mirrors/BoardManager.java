package uk.ac.cam.sc989.mirrors;

import android.content.Context;
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

    public BoardManager(Context c, GridLayout grid, Level level) {
        mContext = c;
        this.level = level;
        this.grid = grid;
        this.width = level.getImages().length;
        this.height = level.getImages()[0].length;
    }

    public void draw(){
        clear();
        for (int i =0; i < width * height; i ++){
            grid.addView(getView(i));
        }
    }

    public void clear(){
        for (int i = 0; i < grid.getChildCount(); i++){
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
    public View getView(int position) {
        ImageView imageView;
        imageView = new ImageView(mContext);
        imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setPadding(8, 8, 8, 8);
        GridView.LayoutParams params = new GridView.LayoutParams(200, 200);
        imageView.setImageResource(level.getImages()[position / 4][position % 4]);
        imageView.setLayoutParams(params);
        return imageView;
    }

}