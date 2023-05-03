package com.example.aularecycler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Pesquisa extends AppCompatActivity {
    ArrayList<Produto> listaProdutos;
    Button categ, relat, novo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisa);
        getSupportActionBar().hide();
        categ = findViewById(R.id.categ);
        relat = findViewById(R.id.relat);
        novo = findViewById(R.id.novo);
        categ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent criarintent = new Intent(Pesquisa.this, MainActivity.class); //vai mudar a tela
                startActivity(criarintent);
            }
        });
        relat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        novo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent criarintent = new Intent(Pesquisa.this, Novo.class); //vai mudar a tela
                startActivity(criarintent);
            }
        });
    }
}