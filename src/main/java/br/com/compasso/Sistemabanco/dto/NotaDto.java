package br.com.compasso.Sistemabanco.dto;

import br.com.compasso.Sistemabanco.entity.notas.Nota;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class NotaDto {

    @Getter
    private Long valor;

    public NotaDto(Nota nota) {
        this.valor = nota.getValor();
    }

}
