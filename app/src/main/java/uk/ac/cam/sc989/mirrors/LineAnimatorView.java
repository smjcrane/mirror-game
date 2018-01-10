package uk.ac.cam.sc989.mirrors;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by Simon on 08/01/2018.
 */

public class LineAnimatorView extends View {
    private boolean fired = false;

    private ArrayList<Point> pointsToDraw;
    private int index;

    private Point previousPoint;
    private float currentPosition;
    private Point nextPoint;

    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG) {
        {
            setDither(true);
            setColor(Color.RED);
        }
    };

    public void fire(){
        fired = true;
    }

    public LineAnimatorView(Context context, AttributeSet attrs){
        super(context, attrs);

        pointsToDraw = new ArrayList<>();
        pointsToDraw.add(new Point(0, 0));
        pointsToDraw.add(new Point(100, 100));
        pointsToDraw.add(new Point(100, 200));
        pointsToDraw.add(new Point(500, 500));

        index = 0;
        previousPoint = pointsToDraw.get(0);
        nextPoint = pointsToDraw.get(1);
        currentPosition = 0;
    }

    public void setPointsToDraw(ArrayList<Point> points){
        pointsToDraw = points;
        int i = 0;
        previousPoint = pointsToDraw.get(0);
        nextPoint = pointsToDraw.get(1);
        currentPosition = 0;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!fired){
            return;
        }

        drawFromPoints(canvas);

        if (nextPoint != null) {
            currentPosition += 0.1; //fiddle factor here
            canvas.drawLine(previousPoint.x, previousPoint.y,
                    previousPoint.x + currentPosition * (nextPoint.x - previousPoint.x),
                    previousPoint.y + currentPosition * (nextPoint.y - previousPoint.y),
                    paint);
            if (currentPosition >= 1) {
                currentPosition = 0;
                previousPoint = new Point(nextPoint.x, nextPoint.y);
                index++;
                if (index < pointsToDraw.size() - 1) {
                    nextPoint = pointsToDraw.get(index+1);
                } else {
                    nextPoint = null;
                }
            }

            postInvalidateDelayed(300); // set time here
        }
    }

    private void drawFromPoints(Canvas canvas){
        for(int i = 0; i < index; i++){
            Point start = pointsToDraw.get(i);
            Point end = pointsToDraw.get(i+1);
            canvas.drawLine(start.x, start.y, end.x, end.y, paint);
        }
    }

    private void drawCurrent(Canvas canvas){
        currentPosition += 0.1; //fiddle factor here
        canvas.drawLine(previousPoint.x, previousPoint.y,
                previousPoint.x + currentPosition * (nextPoint.x - previousPoint.x),
                previousPoint.y + currentPosition * (nextPoint.y - previousPoint.y),
                paint);
        if (currentPosition == 1){
            previousPoint = nextPoint;
            index++;
            if (index < pointsToDraw.size()) {
                nextPoint = pointsToDraw.get(index);
            } else {
                nextPoint = null;
            }
        }
    }

}
