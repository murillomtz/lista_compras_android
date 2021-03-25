package br.ucsal.lista_compras_v2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ProdutoAdapter extends BaseAdapter {

    private List<Produto> lista;
    private Context contexto;

    public ProdutoAdapter() {
    }

    public ProdutoAdapter(Context contexto, List<Produto> lista) {
        this.lista = lista;
        this.contexto = contexto;
    }


    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Produto getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        if (view == null) {
            view = LayoutInflater.from(contexto).inflate(R.layout.produto_list_item, parent, false);
        }

        TextView nome = view.findViewById(R.id.list_produto_nome);
        TextView quantidade = view.findViewById(R.id.list_produto_quantidade);
        TextView valorUnitario = view.findViewById(R.id.list_produto_valorUnitario);

        Produto produto = getItem(position);

        nome.setText(produto.getNome());
        quantidade.setText(produto.getQuantidade() + "");
        valorUnitario.setText(produto.getValor() + "");


        return view;
    }
}
