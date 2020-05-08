package br.com.compasso.Sistemabanco.entity;

import br.com.compasso.Sistemabanco.entity.notas.*;

import java.util.Arrays;
import java.util.List;

public class CaixaEletronico {

    private List<Nota> listaNotas = Arrays.asList(new CemReais(), new CinquentaReais(),
            new VinteReais(), new DezReais());

    public List<Nota> getListaNotas() {
        return listaNotas;
    }

    public Nota getMenorNota() {
        return listaNotas.get(listaNotas.size() - 1);
    }
}
