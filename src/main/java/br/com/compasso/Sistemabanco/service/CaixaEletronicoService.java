package br.com.compasso.Sistemabanco.service;

import br.com.compasso.Sistemabanco.dto.SaqueDto;
import br.com.compasso.Sistemabanco.entity.Saque;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.naming.AuthenticationException;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class CaixaEletronicoService {

    private final List<Integer> listaNotas = Arrays.asList(100, 50, 20, 10);
    private List<Integer> retorno = new ArrayList<>();

    public Saque realizarSaque(Long valorSaque){
        retorno.clear();
        Long valor = valorSaque;

        if (ehDivisivelPor10(valor)) {
            for (Integer nota : listaNotas) {
                valor = retornaNotas(valor, nota);
            }
            return new Saque(valorSaque, retorno);
        }
        throw new IllegalArgumentException("O valor deve ser divisivel por 10!(Service)");

    }

    private boolean ehDivisivelPor10(Long valor) {
        return valor % 10 == 0;
    }

    private Long retornaNotas(Long valor, Integer nota) {
        int qtdNota = (int) (valor / nota);
        retorno.add(qtdNota);
        return valor - (qtdNota * nota);
    }
}
