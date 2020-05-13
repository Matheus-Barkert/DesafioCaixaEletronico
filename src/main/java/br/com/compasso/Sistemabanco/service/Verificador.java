package br.com.compasso.Sistemabanco.service;

import br.com.compasso.Sistemabanco.entity.CaixaEletronico;
import br.com.compasso.Sistemabanco.entity.notas.Nota;

import java.util.List;

public class Verificador {

    private List<Nota> listaNotas = new CaixaEletronico().getListaNotas();

    public boolean verificaValor(Long valorSaque) {
        return listaNotas.stream().anyMatch(nota -> valorSaque % nota.getValor() == 0);
    }

}
