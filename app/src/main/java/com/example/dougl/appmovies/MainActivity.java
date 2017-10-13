package com.example.dougl.appmovies;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private Button botao;
    private EditText edtTexto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botao = (Button) findViewById(R.id.btn_buscar);
        edtTexto = (EditText) findViewById(R.id.editText);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texto = edtTexto.getText().toString();
                Bundle bundle = new Bundle();

                bundle.putString("txt", texto);
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtras(bundle);

                startActivity(intent);
            }
        });
    }


}
