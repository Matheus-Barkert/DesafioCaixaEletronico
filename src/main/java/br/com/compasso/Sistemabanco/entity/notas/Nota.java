package br.com.compasso.Sistemabanco.entity.notas;

public abstract class Nota {

    protected Long valor;
    protected int quantidade;

    public void setQuantidade(Integer quantidade){
        this.quantidade = quantidade;
    }

    public int getQuantidade(){
        return quantidade;
    }

    public Long getValor(){
        return valor;
    }
}
