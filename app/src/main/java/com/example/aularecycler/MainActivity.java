package com.example.aularecycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Produto> listaProdutos = new ArrayList<>();
    RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        cadastroInicial();
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
        Produto p2 = new Produto("Batata", "GOSTOSA", (float) 10.99);
        Produto p3 = new Produto("Geladeira", "METALZIN", (float) 4358.00);
        Produto p4 = new Produto("Lampada", "HMMMMERCURIO", (float) 10.25);
        Produto p5 = new Produto("Chupisco", "SERVIÇOS", (float) 999.99);
        Produto p6 = new Produto("DuziaOvo", "GOSTOSA", (float) 12);
        Produto p7 = new Produto("Java", "DEV", (float) 999.98);
        Produto p8 = new Produto("DuziaQueijo", "GOSTOSA", (float) 30.00);
        listaProdutos.add(p1);
        listaProdutos.add(p2);
        listaProdutos.add(p3);
        listaProdutos.add(p4);
        listaProdutos.add(p5);
        listaProdutos.add(p6);
        listaProdutos.add(p7);
        listaProdutos.add(p8);
    }
}