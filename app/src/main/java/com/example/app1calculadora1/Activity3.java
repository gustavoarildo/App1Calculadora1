package com.example.app1calculadora1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.example.app1calculadora1.R.id.buttonDe3Para2;

public class Activity3 extends AppCompatActivity {
    Button btDe3Para2;

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
            }
        });
    }
}
