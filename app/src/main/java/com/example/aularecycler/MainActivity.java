package com.example.aularecycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Produto> listaProdutos = new ArrayList<>();
    RecyclerView recycler;
    Button pesquisa, relat, novo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        cadastroInicial();
        pesquisa = findViewById(R.id.pesquisa);
        relat = findViewById(R.id.relat);
        novo = findViewById(R.id.novo);
        pesquisa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent criarintent = new Intent(MainActivity.this, Pesquisa.class); //vai mudar a tela
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
                Intent criarintent = new Intent(MainActivity.this, Novo.class); //vai mudar a tela
                startActivity(criarintent);
                Novo.listaProdutos = listaProdutos;
            }
        });
        recycler = findViewById(R.id.rv);
        recycler.setHasFixedSize(true); //terá um tamanho fixo
        recycler.setLayoutManager(new LinearLayoutManager(this)); //uma em cima da outra, linear
        Adaptador adapter = new Adaptador(this, listaProdutos, new Adaptador.OnItemClickListener() {//isso aqui é a interface criada
            @Override
            public void onItemClick(Produto p) { //onclick de cada cartão, num geral
                Toast.makeText(MainActivity.this, p.getNome(), Toast.LENGTH_SHORT).show();
            }
        });
        recycler.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public void cadastroInicial() {
        Produto p1 = new Produto("Arroz", "GOSTOSA", (float) 7.49);
        listaProdutos.add(p1);
    }

}