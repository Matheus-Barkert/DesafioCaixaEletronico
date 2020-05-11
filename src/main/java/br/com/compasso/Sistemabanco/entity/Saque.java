package br.com.compasso.Sistemabanco.entity;

import br.com.compasso.Sistemabanco.entity.notas.Nota;

import java.util.Collections;
import java.util.List;

public class Saque {

    private Long valor;
    private List<Nota> listaNotas = new CaixaEletronico().getListaNotas();

    public Saque(Long valor, List<Integer> quantidadeParaCadaNota) {
        this.valor = valor;
        for (int i = 0; i < quantidadeParaCadaNota.size(); i++) {
            listaNotas.get(i).setQuantidade(quantidadeParaCadaNota.get(i));
        }
    }

    public Long getValor() {
        return valor;
    }

    public List<Nota> getListaNotas() {
        return Collections.unmodifiableList(listaNotas);
    }

}
