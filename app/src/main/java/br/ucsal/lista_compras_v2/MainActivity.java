package br.ucsal.lista_compras_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    public static ArrayList<Produto> produtos = new ArrayList<Produto>();

    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Lista de compras");

        produtos.addAll(
                Arrays.asList(
                        new Produto("Farinha", 5, 12.0),
                        new Produto("Arroz", 1, 1.0),
                        new Produto("Farinha", 3, 2.0),
                        new Produto("Farinha", 15, 150.0)
                )
        );
        lista = findViewById(R.id.main_list_produtos);

        ListAdapter adapter = new ProdutoAdapter(this, produtos);

        lista.setAdapter(adapter);
    }

    public void formulario(View view){

        Intent intent = new Intent(this, FormActivity.class);
        startActivity(intent);
    }
}