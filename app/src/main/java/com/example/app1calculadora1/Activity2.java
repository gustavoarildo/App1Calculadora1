package com.example.app1calculadora1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
            }
        });

        //açao do botao Trocar Activity de 2 para 3
        btDe2Para3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Activity2.this, Activity3.class);
                startActivity(i);
            }
        });
    }
/*
    @Override
    public void finish(){
        super.finish();
        overridePendingTransition(R.transition.mover_esquerda, R.transition.fade_out);
    }

 */


}
