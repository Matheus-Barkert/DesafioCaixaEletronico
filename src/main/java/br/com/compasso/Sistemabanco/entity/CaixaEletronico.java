package br.com.compasso.Sistemabanco.entity;

import br.com.compasso.Sistemabanco.entity.notas.*;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class CaixaEletronico {

    @Getter
    private List<Nota> listaNotas = Arrays.asList(new CemReais(), new CinquentaReais(),
            new VinteReais(), new DezReais(), new CincoReais());

    public Long getValorMenorNota() {
        return listaNotas.get(listaNotas.size() - 1).getValor();
    }
}
