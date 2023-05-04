package com.example.aularecycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Pesquisa extends AppCompatActivity {
    static ArrayList<Produto> listaProdutos;
    ArrayList<Produto> listaTemp = new ArrayList<>();
    Button categ, relat, novo, pesquisar;
    RecyclerView recycler;

    TextView Preco, Nome;
    EditText categoria;
    Adaptador adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisa);
        getSupportActionBar().hide();
        Preco = findViewById(R.id.Preco);
        Nome = findViewById(R.id.Nome);
        categoria = findViewById(R.id.categoria);
        categ = findViewById(R.id.categ2);
        relat = findViewById(R.id.relat2);
        novo = findViewById(R.id.novo2);
        pesquisar = findViewById(R.id.pesquisar);
        recycler = findViewById(R.id.rv);
        pesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pesquisar();
            }
        });
        categ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent criarintent = new Intent(Pesquisa.this, MainActivity.class); //vai mudar a tela
                //startActivity(criarintent);
                onBackPressed();
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
        recycler.setHasFixedSize(true); //terá um tamanho fixo
        recycler.setLayoutManager(new LinearLayoutManager(this)); //uma em cima da outra, linear
        adapter = new Adaptador(this, listaProdutos, new Adaptador.OnItemClickListener() {//isso aqui é a interface criada
            @Override
            public void onItemClick(Produto p) { //onclick de cada cartão, num geral
                Toast.makeText(Pesquisa.this, p.getNome(), Toast.LENGTH_SHORT).show();
            }
        });
        recycler.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public void pesquisar() {
        String textnome = Nome.getText().toString();
        String textcateg = categoria.getText().toString();
        float floatpreco = 0;
        if (!Preco.getText().toString().isEmpty()) {
            floatpreco = Float.parseFloat(Preco.getText().toString());
        }
        for (int i = 0; i < listaProdutos.size(); i++) {
            Produto p = listaProdutos.get(i);
            if (textnome.equals(p.getNome()) || textcateg.equals(p.getSabor()) || floatpreco == p.getPreco()) {
                listaTemp.add(p);
            }
        }
        adapter = new Adaptador(this, listaTemp, new Adaptador.OnItemClickListener() {//isso aqui é a interface criada
            @Override
            public void onItemClick(Produto p) { //onclick de cada cartão, num geral
                Toast.makeText(Pesquisa.this, p.getNome(), Toast.LENGTH_SHORT).show();
            }
        });
        recycler.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}