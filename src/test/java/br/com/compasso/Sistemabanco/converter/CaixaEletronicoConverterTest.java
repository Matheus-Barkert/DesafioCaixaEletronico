package br.com.compasso.Sistemabanco.converter;

import br.com.compasso.Sistemabanco.dto.SaqueDto;
import br.com.compasso.Sistemabanco.entity.Saque;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CaixaEletronicoConverterTest {

    CaixaEletronicoConverter caixaEletronicoConverter = new CaixaEletronicoConverter();

    @Test
    public void testandoSaqueToSaqueDto() {
        Saque saque = new Saque(10L, Arrays.asList(1));
        SaqueDto saqueDto = caixaEletronicoConverter.saqueToSaqueDto(saque);

        assertEquals(10L, saqueDto.getValor());
    }

    @Test
    public void testaSeDevolveObjetoDoTipoSaqueDto() {
        Saque saque = new Saque(1L, Arrays.asList(1));

        assertSame(SaqueDto.class, caixaEletronicoConverter.saqueToSaqueDto(saque).getClass());
    }

}