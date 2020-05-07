package br.com.compasso.Sistemabanco.entity;

import br.com.compasso.Sistemabanco.entity.notas.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Saque {

    private Long valor;
    private List<Nota> listaNotas = new CaixaEletronico().getListaNotas();

    //todo revisar
    public Saque(Long valor, List<Integer> quantidades){
        this.valor = valor;
        for (int i = 0; i < quantidades.size() ; i++) {
            listaNotas.get(i).setQuantidade(quantidades.get(i));
        }
//        listaNotas.get(0).setQuantidade(quantidades.get(0));
//        listaNotas.get(1).setQuantidade(quantidades.get(1));
//        listaNotas.get(2).setQuantidade(quantidades.get(2));
//        listaNotas.get(3).setQuantidade(quantidades.get(3));
    }

    public Long getValor() {
        return valor;
    }

    public List<Nota> getListaNotas() {
        return Collections.unmodifiableList(listaNotas);
    }

}
