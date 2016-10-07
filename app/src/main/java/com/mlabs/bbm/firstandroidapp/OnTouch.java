package com.mlabs.bbm.firstandroidapp;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by androidstudio on 10/09/16.
 */
public class OnTouch extends AppCompatActivity {

    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ontouch);
        image = (ImageView)findViewById(R.id.imageView);

        final TextView tv1 = (TextView) findViewById(R.id.textview1);
        final TextView tv2 = (TextView) findViewById(R.id.textview2);
        final TextView tv3 = (TextView) findViewById(R.id.textview3);
        final TextView tv4 = (TextView) findViewById(R.id.textview4);
        final TextView tv5 = (TextView) findViewById(R.id.textview5);
        final TextView tv6 = (TextView) findViewById(R.id.textview6);

        image.setOnTouchListener(new View.OnTouchListener() {
            float x,y,x1,y1;
            @Override
            public boolean onTouch(View v, MotionEvent e) {

                String actionX = "", actionY = "";
                String quadrant = "";

                switch (e.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        x = e.getX();
                        y = e.getY();
                        return true;
                    case MotionEvent.ACTION_UP:
                        float X = image.getRight()/2;
                        float Y = image.getBottom()/2;

                        x1=e.getX();
                        y1=e.getY();

                        actionX = "";
                        actionY = "";
                        quadrant = "";

                        if (x<x1){
                            actionX = "Swiped right. ";
                        }
                        if (x>x1){
                            actionX = "Swiped left. ";
                        }
                        if (y<y1){
                            actionY = "Swiped down. ";
                        }
                        if (y>y1)
                        {
                            actionY = "Swiped up. ";
                        }

                        if(x1>X && y1>Y){
                            quadrant = "Quadrant 4";
                        }
                        if(x1<X && y1>Y){
                            quadrant = "Quadrant 3";
                        }
                        if(x1<X && y1<Y){
                            quadrant = "Quadrant 2";
                        }
                        if(x1>X && y1<Y){
                            quadrant = "Quadrant 1";
                        }

                        tv1.setText("X1, X2: " + x + ", " + x1);
                        tv2.setText("Y1, Y2: " + y + ", " + y1);
                        tv3.setText("X1-X2: " + (Math.abs(x1-x)));
                        tv4.setText("Y1-Y2:" + (Math.abs(y1-y)));
                        tv5.setText("ACTION: " + actionX + actionY);
                        tv6.setText("QUADRANT: " + quadrant );

                }
                return  false;
            }

        });


    }

}