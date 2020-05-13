package br.com.compasso.Sistemabanco.entity.notas;

import lombok.Getter;
import lombok.Setter;

public abstract class Nota {

    @Getter
    protected Long valor;
    @Getter @Setter
    protected int quantidade;

}
