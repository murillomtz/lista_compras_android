package br.ucsal.lista_compras_v2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class FormActivity extends AppCompatActivity {

    private TextInputEditText nome;
    private TextInputEditText quantidade;
    private TextInputEditText valor;

    private Produto produto;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        nome = findViewById(R.id.form_text_nome);
        quantidade = findViewById(R.id.form_text_quantidade);
        valor = findViewById(R.id.form_text_valor);

        Intent intent = getIntent();
        if (intent.hasExtra("PRODUTO")) {
            setTitle("Alterar Produto");
            produto = (Produto) intent.getSerializableExtra("PRODUTO");
            nome.setText(produto.getNome());
            quantidade.setText(produto.getQuantidade()+ "");
            valor.setText(produto.getValor() + "");

        } else {
            setTitle("Novo Produto");
            produto = new Produto();
        }
    }


    public void salvar(View view) {
        if (!MainActivity.produtos.contains(produto)) {
            MainActivity.produtos.add(produto);
        } else {
            int index = MainActivity.produtos.indexOf(produto);
            produto = MainActivity.produtos.get(index);
        }
        produto.setNome(nome.getText().toString());
        produto.setQuantidade(Integer.parseInt(quantidade.getText().toString()));
        produto.setValor(Double.parseDouble(valor.getText().toString()));
        finish();
    }
}
