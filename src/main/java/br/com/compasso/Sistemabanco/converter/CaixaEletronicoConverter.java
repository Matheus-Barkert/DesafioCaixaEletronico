package br.com.compasso.Sistemabanco.converter;

import br.com.compasso.Sistemabanco.dto.NotaDto;
import br.com.compasso.Sistemabanco.dto.SaqueDto;
import br.com.compasso.Sistemabanco.entity.Saque;
import br.com.compasso.Sistemabanco.entity.notas.Nota;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CaixaEletronicoConverter {

    public SaqueDto saqueParaSaqueDto(Saque saque) {
        return new SaqueDto(saque);
    }

    public List<NotaDto> notasParaNotasDto(List<Nota> notas) {
        return notas.stream().map(nota -> new NotaDto(nota.getValor())).collect(Collectors.toList());
    }
}
