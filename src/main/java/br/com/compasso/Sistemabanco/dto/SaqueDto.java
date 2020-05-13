package br.com.compasso.Sistemabanco.dto;

import br.com.compasso.Sistemabanco.entity.Saque;
import br.com.compasso.Sistemabanco.entity.notas.Nota;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

@Getter
@NoArgsConstructor
public class SaqueDto {

    private Long valor;
    private List<Nota> listaNotas;

    public SaqueDto(Saque saque) {
        this.valor = saque.getValor();
        this.listaNotas = saque.getListaNotas();
    }

}
