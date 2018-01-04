package uk.ac.cam.sc989.mirrors;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;
import android.widget.GridView;

public class ActivityPlayLevel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_level);

        GridLayout grid = findViewById(R.id.grid);
        grid.setColumnCount(4);
        BoardManager board = new BoardManager(this, grid, new Level());
        board.draw();
    }

}
