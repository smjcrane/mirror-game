package uk.ac.cam.sc989.mirrors;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by Simon on 03/01/2018.
 */

public class BoardGridAdapter extends BaseAdapter{
    private Context mContext;
    private Level level;

    public BoardGridAdapter(Context c, Level level) {
        mContext = c;
        this.level = level;
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

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }
        GridView.LayoutParams params = new GridView.LayoutParams(200, 200);
        imageView.setImageResource(level.getImages()[position / 4][position % 4]);
        imageView.setLayoutParams(params);
        return imageView;
    }

}