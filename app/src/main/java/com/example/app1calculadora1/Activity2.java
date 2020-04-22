package com.example.app1calculadora1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.app1calculadora1.R.id.buttonDe2Para1;
import static com.example.app1calculadora1.R.id.buttonDe2Para3;
import static com.example.app1calculadora1.R.id.editText1Resultado2;

public class Activity2 extends AppCompatActivity {
    Button btDe2Para1;
    Button btDe2Para3;
    EditText edR2;

    String resultadoIntentGlob;
    String valor1IntentGlob;
    String valor2IntentGlob;
    String memoriaIntentGlob;

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
        setContentView(R.layout.activity_2);

        btDe2Para1 = (Button)findViewById(buttonDe2Para1);
        btDe2Para3 = (Button)findViewById(buttonDe2Para3);
        edR2 = (EditText)findViewById(editText1Resultado2);

        String resultadoIntent;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                resultadoIntent= null;
            } else {
                resultadoIntent= extras.getString("RESULTADO");
            }
        } else {
            resultadoIntent= (String) savedInstanceState.getSerializable("RESULTADO");
        }
        edR2.setText(resultadoIntent);
        resultadoIntentGlob = resultadoIntent;

        String valorUmIntent;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                valorUmIntent= null;
            } else {
                valorUmIntent= extras.getString("VALOR1");
            }
        } else {
            valorUmIntent= (String) savedInstanceState.getSerializable("VALOR1");
        }
        valor1IntentGlob=valorUmIntent;

        String valorDoisIntent;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                valorDoisIntent= null;
            } else {
                valorDoisIntent= extras.getString("VALOR2");
            }
        } else {
            valorDoisIntent= (String) savedInstanceState.getSerializable("VALOR2");
        }
        valor2IntentGlob=valorDoisIntent;

        String memoriaIntent;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                memoriaIntent= null;
            } else {
                memoriaIntent= extras.getString("MEMORIA");
            }
        } else {
            memoriaIntent= (String) savedInstanceState.getSerializable("MEMORIA");
        }
        memoriaIntentGlob=memoriaIntent;

        //açao do botao Trocar Activity de 2 para 1
        btDe2Para1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Activity2.this, MainActivity.class);
                i.putExtra("RESULTADO", resultadoIntentGlob);
                i.putExtra("VALOR1", valor1IntentGlob);
                i.putExtra("VALOR2", valor2IntentGlob);
                i.putExtra("MEMORIA", memoriaIntentGlob);
                startActivity(i);

                overridePendingTransition(R.transition.slide2_in_dir,
                        R.transition.slide2_out_esq);

            }
        });

        //açao do botao Trocar Activity de 2 para 3
        btDe2Para3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Activity2.this, Activity3.class);
                startActivity(i);

                overridePendingTransition(R.transition.mover_direita,
                        R.transition.mover_esquerda);

            }
        });

        gestureDetectorCompat = new GestureDetectorCompat(this, new MyGestureListener());

    }
/*
    @Override
    public void finish(){
        super.finish();
        overridePendingTransition(R.transition.mover_esquerda, R.transition.fade_out);
    }

 */


    class MyGestureListener extends
            GestureDetector.SimpleOnGestureListener {
        //handle 'swipe right' action only
        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2,
                               float velocityX, float velocityY) {
            if (event2.getX() > event1.getX()) {
                Toast.makeText(getBaseContext(),
                        "Swipe direita - startActivity(1)" ,
                        Toast.LENGTH_SHORT).show();
                //switch anoter activity
                Intent intent = new Intent(
                        Activity2.this, MainActivity.class);

                intent.putExtra("RESULTADO", resultadoIntentGlob);
                intent.putExtra("VALOR1", valor1IntentGlob);
                intent.putExtra("VALOR2", valor2IntentGlob);
                intent.putExtra("MEMORIA", memoriaIntentGlob);



                startActivity(intent);
                overridePendingTransition(R.transition.slide2_in_dir,
                        R.transition.slide2_out_esq);
            }
            if (event2.getX() < event1.getX()) {
                Toast.makeText(getBaseContext(),
                        "Swipe esquerda - startActivity(3)" ,
                        Toast.LENGTH_SHORT).show();
                //switch anoter activity
                Intent intent = new Intent(
                        Activity2.this, Activity3.class);

                startActivity(intent);
                overridePendingTransition(R.transition.mover_direita,
                 R.transition.mover_esquerda);
            }
            return true;
        }
    }


}
