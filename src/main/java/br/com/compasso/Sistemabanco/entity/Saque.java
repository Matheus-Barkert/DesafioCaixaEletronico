package br.com.compasso.Sistemabanco.entity;

import br.com.compasso.Sistemabanco.dto.SaqueDto;
import br.com.compasso.Sistemabanco.entity.notas.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Saque {

    private Long valor;
    private List<Notas> listaNotas = Arrays.asList(new CemReais(), new CinquentaReais(),
                                                    new VinteReais(), new DezReais());

    public Saque(Long valor, List<Integer> valores){
        this.valor = valor;
        listaNotas.get(0).setQuantidade(valores.get(0));
        listaNotas.get(1).setQuantidade(valores.get(1));
        listaNotas.get(2).setQuantidade(valores.get(2));
        listaNotas.get(3).setQuantidade(valores.get(3));
    }

    public Long getValor() {
        return valor;
    }

    public List<Notas> getListaNotas() {
        return Collections.unmodifiableList(listaNotas);
    }

}
