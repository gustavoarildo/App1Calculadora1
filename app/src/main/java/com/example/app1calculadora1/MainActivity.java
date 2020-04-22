package com.example.app1calculadora1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.GestureDetectorCompat;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ed1;
    EditText ed2;
    Button bt;
    Button btSub;
    Button btMult;
    Button btDiv;
    Button btRaizQ;
    Button btPot;
    Button btLog;
    Button btMemoRecuperar;
    Button btMemoAdd;
    Button btMemoSub;
    Button btDe1Para2;

    double memoria;
    String resultadoIntent = null;
    String valorUmIntent = null;
    String valorDoisIntent = null;
    String memoriaIntent = null;

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
        setContentView(R.layout.activity_main);

        ed1 = (EditText)findViewById(R.id.editText1Valor1);
        ed2 = (EditText)findViewById(R.id.editText2Valor2);
        bt = (Button)findViewById(R.id.buttonSoma);
        btSub = (Button)findViewById(R.id.buttonSub);
        btMult = (Button)findViewById(R.id.buttonMult);
        btDiv = (Button)findViewById(R.id.buttonDiv);
        btRaizQ = (Button)findViewById(R.id.buttonRaizQ);
        btPot = (Button)findViewById(R.id.buttonPot);
        btLog = (Button)findViewById(R.id.buttonLog);
        btMemoRecuperar = (Button)findViewById(R.id.buttonMemoRecuperar);
        btMemoAdd = (Button)findViewById(R.id.buttonMemoAdd);
        btMemoSub = (Button)findViewById(R.id.buttonMemoSub);
        btDe1Para2 = (Button)findViewById(R.id.buttonDe1Para2);



        String resultadoIntentRecebe;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                resultadoIntentRecebe= null;
            } else {
                resultadoIntentRecebe= extras.getString("RESULTADO");
            }
        } else {
            resultadoIntentRecebe= (String) savedInstanceState.getSerializable("RESULTADO");
        }
        resultadoIntent = resultadoIntentRecebe;

        String valorUmIntentRecebe;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                valorUmIntentRecebe= null;
            } else {
                valorUmIntentRecebe= extras.getString("VALOR1");
            }
        } else {
            valorUmIntentRecebe= (String) savedInstanceState.getSerializable("VALOR1");
        }
        ed1.setText(valorUmIntentRecebe);

        String valorDoisIntentRecebe;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                valorDoisIntentRecebe= null;
            } else {
                valorDoisIntentRecebe= extras.getString("VALOR2");
            }
        } else {
            valorDoisIntentRecebe= (String) savedInstanceState.getSerializable("VALOR2");
        }
        ed2.setText(valorDoisIntentRecebe);


        String memoriaIntentRecebe;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                memoriaIntentRecebe= null;
            } else {
                memoriaIntentRecebe= extras.getString("MEMORIA");
            }
        } else {
            memoriaIntentRecebe= (String) savedInstanceState.getSerializable("MEMORIA");
        }

        try {
            memoria = Double.parseDouble(memoriaIntentRecebe);
        }
        catch (Exception e) {
            memoria = Double.parseDouble("00.00");
        }









        //açao do botao soma
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double v1;
                Double v2;
                Double res;
                v1 = Double.parseDouble(ed1.getText().toString());
                v2 = Double.parseDouble(ed2.getText().toString());
                res = v1 + v2;
                Intent i = new Intent(MainActivity.this, Activity2.class);
                resultadoIntent = res.toString();
                i.putExtra("RESULTADO", resultadoIntent);
                valorUmIntent = v1.toString();
                i.putExtra("VALOR1", valorUmIntent);
                valorDoisIntent = v2.toString();
                i.putExtra("VALOR2", valorDoisIntent);
                memoriaIntent = String.valueOf(memoria);
                i.putExtra("MEMORIA", memoriaIntent);
                startActivity(i);

                overridePendingTransition(R.transition.slide_in, R.transition.slide_out);
            }
        });

        //açao do botao subtraçao
        btSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double v1;
                Double v2;
                Double res;
                v1 = Double.parseDouble(ed1.getText().toString());
                v2 = Double.parseDouble(ed2.getText().toString());
                res = v1 - v2;
                Intent i = new Intent(MainActivity.this, Activity2.class);
                resultadoIntent = res.toString();
                i.putExtra("RESULTADO", resultadoIntent);
                valorUmIntent = v1.toString();
                i.putExtra("VALOR1", valorUmIntent);
                valorDoisIntent = v2.toString();
                i.putExtra("VALOR2", valorDoisIntent);
                memoriaIntent = String.valueOf(memoria);
                i.putExtra("MEMORIA", memoriaIntent);
                startActivity(i);

                overridePendingTransition(R.transition.slide_in, R.transition.slide_out);
            }
        });

        //açao do botao multiplicaçao
        btMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double v1;
                Double v2;
                Double res;
                v1 = Double.parseDouble(ed1.getText().toString());
                v2 = Double.parseDouble(ed2.getText().toString());
                res = v1 * v2;
                Intent i = new Intent(MainActivity.this, Activity2.class);
                resultadoIntent = res.toString();
                i.putExtra("RESULTADO", resultadoIntent);
                valorUmIntent = v1.toString();
                i.putExtra("VALOR1", valorUmIntent);
                valorDoisIntent = v2.toString();
                i.putExtra("VALOR2", valorDoisIntent);
                memoriaIntent = String.valueOf(memoria);
                i.putExtra("MEMORIA", memoriaIntent);
                startActivity(i);

                overridePendingTransition(R.transition.slide_in, R.transition.slide_out);
            }
        });

        //açao do botao divisao
        btDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double v1;
                Double v2;
                Double res;
                v1 = Double.parseDouble(ed1.getText().toString());
                v2 = Double.parseDouble(ed2.getText().toString());
                res = v1 / v2;
                Intent i = new Intent(MainActivity.this, Activity2.class);
                resultadoIntent = res.toString();
                i.putExtra("RESULTADO", resultadoIntent);
                valorUmIntent = v1.toString();
                i.putExtra("VALOR1", valorUmIntent);
                valorDoisIntent = v2.toString();
                i.putExtra("VALOR2", valorDoisIntent);
                memoriaIntent = String.valueOf(memoria);
                i.putExtra("MEMORIA", memoriaIntent);
                startActivity(i);

                overridePendingTransition(R.transition.slide_in, R.transition.slide_out);
            }
        });

        //açao do botao raiz quadrada
        btRaizQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double v1;
                Double res;
                v1 = Double.parseDouble(ed1.getText().toString());

                res = Math.sqrt(v1);

                Intent i = new Intent(MainActivity.this, Activity2.class);
                resultadoIntent = res.toString();
                i.putExtra("RESULTADO", resultadoIntent);
                valorUmIntent = v1.toString();
                i.putExtra("VALOR1", valorUmIntent);
                valorDoisIntent = ed2.getText().toString();
                i.putExtra("VALOR2", valorDoisIntent);
                memoriaIntent = String.valueOf(memoria);
                i.putExtra("MEMORIA", memoriaIntent);
                startActivity(i);

                overridePendingTransition(R.transition.slide_in, R.transition.slide_out);
            }
        });

        //açao do botao potencia
        btPot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double v1;
                Double v2;
                Double res;
                v1 = Double.parseDouble(ed1.getText().toString());
                v2 = Double.parseDouble(ed2.getText().toString());

                res = v1; // Inicia pot
                for (int i = 1; i < v2; i++ ) // Comeca em 1 pois 'pot' ja foi inicializado
                {
                    res *= v1; // Multiplica pot por i*x
                }

                Intent i = new Intent(MainActivity.this, Activity2.class);
                resultadoIntent = res.toString();
                i.putExtra("RESULTADO", resultadoIntent);
                valorUmIntent = v1.toString();
                i.putExtra("VALOR1", valorUmIntent);
                valorDoisIntent = v2.toString();
                i.putExtra("VALOR2", valorDoisIntent);
                memoriaIntent = String.valueOf(memoria);
                i.putExtra("MEMORIA", memoriaIntent);
                startActivity(i);

                overridePendingTransition(R.transition.slide_in, R.transition.slide_out);
            }
        });

        //açao do botao logaritimo
        btLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double v1;
                Double v2;
                Double res;
                v1 = Double.parseDouble(ed1.getText().toString());
                v2 = Double.parseDouble(ed2.getText().toString());

                res = Math.log(v1)/Math.log(v2);

                Intent i = new Intent(MainActivity.this, Activity2.class);
                resultadoIntent = res.toString();
                i.putExtra("RESULTADO", resultadoIntent);
                valorUmIntent = v1.toString();
                i.putExtra("VALOR1", valorUmIntent);
                valorDoisIntent = v2.toString();
                i.putExtra("VALOR2", valorDoisIntent);
                memoriaIntent = String.valueOf(memoria);
                i.putExtra("MEMORIA", memoriaIntent);
                startActivity(i);

                overridePendingTransition(R.transition.slide_in, R.transition.slide_out);
            }
        });

        //açao do botao Memoria Recuperar
        btMemoRecuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double v1;

                v1 = memoria;

                ed1.setText(v1.toString());
            }
        });

        //açao do botao Memoria Adicionar
        btMemoAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double v1;

                v1 = Double.parseDouble(ed1.getText().toString());
                memoria += v1;
            }
        });

        //açao do botao Memoria Subtrair
        btMemoSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double v1;

                v1 = Double.parseDouble(ed1.getText().toString());
                memoria -= v1;
            }
        });

        //açao do botao Trocar Activity de 1 para 2
        btDe1Para2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Activity2.class);
                i.putExtra("RESULTADO", resultadoIntent);
                valorUmIntent = ed1.getText().toString();
                i.putExtra("VALOR1", valorUmIntent);
                valorDoisIntent = ed2.getText().toString();
                i.putExtra("VALOR2", valorDoisIntent);
                memoriaIntent = String.valueOf(memoria);
                i.putExtra("MEMORIA", memoriaIntent);

                //ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(getApplicationContext(),R.transition.fade_in, R.transition.mover_direita);
                //ActivityCompat.startActivity(MainActivity.this, i, activityOptionsCompat.toBundle());
                startActivity(i);
                //finish();
                overridePendingTransition(R.transition.slide_in, R.transition.slide_out);//TRAVA/CONGELA/TELAPRETA
                //setContentView(R.layout.activity_2);

            }
        });

        gestureDetectorCompat = new GestureDetectorCompat(this, new MyGestureListener());
    }


    class MyGestureListener extends
            GestureDetector.SimpleOnGestureListener {
        //handle 'swipe left' action only
        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2,
                               float velocityX, float velocityY) {
            if (event2.getX() < event1.getX()) {
                Toast.makeText(getBaseContext(),
                        "Swipe esquerda - startActivity(2)" ,
                        Toast.LENGTH_SHORT).show();
                //switch anoter activity
                Intent intent = new Intent(
                        MainActivity.this, Activity2.class);

                intent.putExtra("RESULTADO", resultadoIntent);
                valorUmIntent = ed1.getText().toString();
                intent.putExtra("VALOR1", valorUmIntent);
                valorDoisIntent = ed2.getText().toString();
                intent.putExtra("VALOR2", valorDoisIntent);
                memoriaIntent = String.valueOf(memoria);
                intent.putExtra("MEMORIA", memoriaIntent);



                startActivity(intent);
                overridePendingTransition(R.transition.slide_in,
                        R.transition.slide_out);
            }
            return true;
        }
    }

}
