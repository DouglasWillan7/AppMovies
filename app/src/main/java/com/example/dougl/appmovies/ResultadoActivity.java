package com.example.dougl.appmovies;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by dougl on 12/10/2017.
 */

public class ResultadoActivity extends Activity {


    RequestQueue rq;

    TextView nomer, lancamentor, diretorr, tempor, notar, atoresr, producaor, sinopser;


    String title, released, diretor, runtime, imdbrating, actors, production, plot;


    String url = "http://www.omdbapi.com/?apikey=86c36815&t=frozen";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rq = Volley.newRequestQueue(this);

        nomer = (TextView) findViewById(R.id.nome_result);
        lancamentor = (TextView) findViewById(R.id.lancamento_result);
        diretorr = (TextView) findViewById(R.id.diretor_result);
        tempor = (TextView) findViewById(R.id.tempo_result);
        notar = (TextView) findViewById(R.id.nota_result);
        atoresr = (TextView) findViewById(R.id.atores_result);
        producaor = (TextView) findViewById(R.id.producao_result);
        sinopser = (TextView) findViewById(R.id.sinopse_result);

        sendjsonrequest();
    }

    public void sendjsonrequest(){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    title = response.getString("Title");
                    released = response.getString("Released");
                    diretor = response.getString("Director");
                    runtime = response.getString("Runtime");
                    imdbrating = response.getString("imdbRating");
                    actors = response.getString("Actors");
                    production = response.getString("Production");
                    plot = response.getString("Plot");


                    nomer.setText(title);
                    lancamentor.setText(released);
                    diretorr.setText(diretor);
                    tempor.setText(runtime);
                    notar.setText(imdbrating);
                    atoresr.setText(actors);
                    producaor.setText(production);
                    sinopser.setText(plot);

                } catch (JSONException e) {
                    e.printStackTrace();
                }




            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        rq.add(jsonObjectRequest);

    }
}
