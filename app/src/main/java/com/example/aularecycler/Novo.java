package com.example.aularecycler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class Novo extends AppCompatActivity {
    static ArrayList<Produto> listaProdutos;
    Button categ, relat, pesquisa, cadastrar;
    TextView Preco, Nome;
    EditText categoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo);
        getSupportActionBar().hide();
        Preco = findViewById(R.id.Preco);
        Nome = findViewById(R.id.Nome);
        categoria = findViewById(R.id.categoria);
        categ = findViewById(R.id.categ);
        relat = findViewById(R.id.relat);
        pesquisa = findViewById(R.id.pesquisa);
        cadastrar = findViewById(R.id.cadastrar);
        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cadastrar();
            }
        });
        categ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent criarintent = new Intent(Novo.this, MainActivity.class); //vai mudar a tela
                //startActivity(criarintent);
                Novo.super.onBackPressed();
            }
        });
        relat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        pesquisa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent criarintent = new Intent(Novo.this, Pesquisa.class); //vai mudar a tela
                startActivity(criarintent);

            }
        });
    }
    public void cadastrar(){
        String textnome = Nome.getText().toString();
        String textcateg = categoria.getText().toString();

        if (textnome.isEmpty() && textcateg.isEmpty() && Preco.getText().toString() != null){
            float floatpreco = Float.parseFloat(Preco.getText().toString());
            Produto i = new Produto(textnome, textcateg, floatpreco);
            listaProdutos.add(i);
        }
    }
}