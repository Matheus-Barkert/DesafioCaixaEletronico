package br.com.compasso.Sistemabanco.service;

import br.com.compasso.Sistemabanco.dto.SaqueDto;
import br.com.compasso.Sistemabanco.entity.Saque;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class CaixaEletronicoService {

    private final List<Integer> listaNotas = Arrays.asList(100, 50, 20, 10);
    private List<Integer> retorno = new ArrayList<>();

    public Saque realizarSaque(@Valid SaqueDto saqueDto) throws Exception {
        retorno.clear();
        Long valor = saqueDto.getValor();

        if (valor % 10 == 0) {

            for (Integer nota : listaNotas) {
                valor = retornaNotas(valor, nota);
            }
            Saque saque = new Saque(saqueDto.getValor(), retorno);

            return saque;
        }
        throw new Exception("O valor deve ser um divisor de 10");
    }

    private Long retornaNotas(Long valor, Integer nota) {

        int qtdNota = (int) (valor / nota);
        retorno.add(qtdNota);
        return valor - (qtdNota * nota);
    }
}
