package br.com.compasso.Sistemabanco.converter;

import br.com.compasso.Sistemabanco.dto.SaqueDto;
import br.com.compasso.Sistemabanco.entity.Saque;
import org.springframework.stereotype.Component;

@Component
public class CaixaEletronicoConverter {

    public SaqueDto saqueToSaqueDto(Saque saque) {
        return new SaqueDto(saque);
    }
}
