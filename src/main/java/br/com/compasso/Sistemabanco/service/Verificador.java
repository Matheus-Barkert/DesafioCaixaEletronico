package br.com.compasso.Sistemabanco.service;

import br.com.compasso.Sistemabanco.entity.CaixaEletronico;
import br.com.compasso.Sistemabanco.entity.notas.Nota;

import java.util.List;

public class Verificador {

    private List<Nota> listaNotas = new CaixaEletronico().getListaNotas();

    public boolean verificaValor(Long valorSaque) {
        if (ehDivisivelPor(valorSaque)) return true;
        return false;
//        if (valorSaque > 0 && ehDivisivelPor(valorSaque)) return true;
//        return false;
    }

    private boolean ehDivisivelPor(Long valor) {
        return listaNotas.stream().anyMatch(nota -> valor % nota.getValor() == 0);
    }

}
