package uk.ac.cam.sc989.mirrors;

import android.content.Context;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Simon on 02/01/2018.
 */

public class LevelSelectListAdapter extends ArrayAdapter {
    private ArrayList<Level> levels;
    private Context mContext;

    public LevelSelectListAdapter(Context context, int resource, ArrayList<Level> items) {
        super(context, resource, items);
        this.mContext = context;
        this.levels = items;
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {

        Log.d("LISTADAPT", "getting View");
        if (v == null) {
            Level myLevel = levels.get(position);

            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.list_item_level_select, null);

            TextView textNumber = (TextView) v.findViewById(R.id.textLevelNumber);
            textNumber.setText(Integer.toString(myLevel.getNumber()));

            TextView textName = (TextView) v.findViewById(R.id.textLevelName);
            textName.setText(myLevel.getName());

            ImageView imageDone = (ImageView) v.findViewById(R.id.imageLevelCompleted);
            imageDone.setImageResource(myLevel.isCompleted() ? R.drawable.full_star : R.drawable.empty_star);
        }
        return v;
    }
}
