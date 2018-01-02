package uk.ac.cam.sc989.mirrors;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bPlay, bTutorial;
    private Intent moveScreens;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bPlay = (Button) findViewById(R.id.buttonLevelSelect);
        bTutorial = (Button) findViewById(R.id.buttonTutorial);

        bPlay.setOnClickListener(this);
        bTutorial.setOnClickListener(this);
    }

    public void onClick(View v){
        go (v);
    }

    private void go(View v){
        moveScreens = new Intent();
        switch (v.getId()){
            case R.id.buttonLevelSelect: moveScreens.setClass(this, ActivityLevelSelect.class);
                break;
            case R.id.buttonTutorial: moveScreens.setClass(this, ActivityTutorial.class);
                break;
        }
        startActivity(moveScreens);
    }
}
