package com.example.app1calculadora1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static com.example.app1calculadora1.R.id.buttonDe3Para2;

public class Activity3 extends AppCompatActivity {
    Button btDe3Para2;


    private GestureDetectorCompat gestureDetectorCompat;

    @Override
    public boolean
    onTouchEvent(MotionEvent event) {
        this.gestureDetectorCompat.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        btDe3Para2 = (Button)findViewById(buttonDe3Para2);

        //açao do botao Trocar Activity de 3 para 2
        btDe3Para2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Activity3.this, Activity2.class);
                startActivity(i);

                overridePendingTransition(R.transition.fade_in,
                        R.transition.fade_out);

            }
        });


        gestureDetectorCompat = new GestureDetectorCompat(this, new MyGestureListener());


    }


    class MyGestureListener extends
            GestureDetector.SimpleOnGestureListener {
        //handle 'swipe right' action only
        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2,
                               float velocityX, float velocityY) {
            if (event2.getX() > event1.getX()) {
                Toast.makeText(getBaseContext(),
                        "Swipe direita - startActivity(2)" ,
                        Toast.LENGTH_SHORT).show();
                //switch anoter activity
                Intent intent = new Intent(
                        Activity3.this, Activity2.class);

                startActivity(intent);

                overridePendingTransition(R.transition.fade_in,
                        R.transition.fade_out);

            }
            return true;
        }
    }



}
