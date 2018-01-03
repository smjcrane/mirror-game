package uk.ac.cam.sc989.mirrors;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ActivityLevelSelect extends AppCompatActivity {
    private ListView listOfLevels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_select);

        ArrayList<Level> levels = new ArrayList<>();
        levels.add(new Level());

        listOfLevels = findViewById(R.id.listOfLevels);
        LevelSelectListAdapter adapter = new LevelSelectListAdapter(this, R.layout.list_item_level_select, levels);
        listOfLevels.setAdapter(adapter);
        listOfLevels.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ActivityLevelSelect.this, ActivityPlayLevel.class);
                startActivity(intent);
            }
        });
    }

}
