package br.ucsal.lista_compras_v2;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    public static ArrayList<Produto> produtos = new ArrayList<Produto>();

    private ListView lista;
    private ProdutoAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Lista de compras");

        produtos.addAll(
                Arrays.asList(
                        new Produto("Farinha", 5, 12.0),
                        new Produto("Arroz", 1, 1.0),
                        new Produto("Trigo", 3, 2.0),
                        new Produto("Peira", 15, 150.0)
                )
        );
        lista = findViewById(R.id.main_list_produtos);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int posicao, long id) {
                Produto produto = (Produto) adapter.getItemAtPosition(posicao);
                Toast.makeText(MainActivity.this, "Item " + produto.getNome(),
                        Toast.LENGTH_SHORT).show();

                //Alterar
                Intent intent = new Intent(MainActivity.this, FormActivity.class);
                intent.putExtra("PRODUTO", produto);
                startActivity(intent);

            }
        });

        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapter, View view, int posicao, long id) {


                Produto produto = (Produto) adapter.getItemAtPosition(posicao);
                Toast.makeText(MainActivity.this, produto.getNome() + "Excluido",
                        Toast.LENGTH_SHORT).show();
                //Excluir
                produtos.remove(produto);
                //TODO Precisa da um refresh na pagina, ele delete mais nao att a view
                onResume();//Acho q nao é uma boa!!
                return false;
            }
        });

        registerForContextMenu(lista);

    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter = new ProdutoAdapter(this, produtos);
        //adapter.notifyDataSetChanged();
        lista.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_ordenacao, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_ordenacao_ordenar:
                //TODO criar ordenação, ordem de preco e nome do produto
        }

        return super.onOptionsItemSelected(item);
    }

   /* @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_ordenacao, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)
                item.getMenuInfo();
        switch (item.getItemId()){
            case R.id.menu_ordenacao_ordenar:
                Toast.makeText(this,
                        this.adapter.getItem(info.position).getNome()
                        ,Toast.LENGTH_SHORT).show();
        }


        return super.onContextItemSelected(item);
    }*/

    public void formulario(View view) {

        Intent intent = new Intent(this, FormActivity.class);
        startActivity(intent);
    }
}