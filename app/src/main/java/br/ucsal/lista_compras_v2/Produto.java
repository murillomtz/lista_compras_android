package br.ucsal.lista_compras_v2;

import java.io.Serializable;
import java.util.Objects;

public class Produto implements Serializable {

    private String nome;
    private Integer quantidade;
    private Double valor;

    public Produto() {
    }

    public Produto(String nome, Integer quantidade, Double valor) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(nome, produto.nome) &&
                Objects.equals(quantidade, produto.quantidade) &&
                Objects.equals(valor, produto.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, quantidade, valor);
    }
}
