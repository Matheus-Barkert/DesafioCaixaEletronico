package br.com.compasso.Sistemabanco.service;

import br.com.compasso.Sistemabanco.entity.CaixaEletronico;
import br.com.compasso.Sistemabanco.entity.Saque;
import br.com.compasso.Sistemabanco.entity.notas.Nota;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CaixaEletronicoService {

    private final List<Nota> listaNotas = new CaixaEletronico().getListaNotas();
    private List<Integer> retorno = new ArrayList<>();

    public Saque realizarSaque(Long valorSaque) {

        retorno.clear();

        if (verificaValor(valorSaque)) {
            Long valor = valorSaque;

            for (Nota nota : listaNotas) {
                valor = retornaValor(valor, nota);
            }
            return new Saque(valorSaque, retorno);

        }
        throw new IllegalArgumentException("O valor deve ser divisivel por 10!(Service)");

    }

    private boolean verificaValor(Long valorSaque) {

        if (valorSaque > 0 && ehDivisivelPor(valorSaque)) return true;
        return false;
    }

    private boolean ehDivisivelPor(Long valor) {
        return valor % listaNotas.get(listaNotas.size() - 1).getValor() == 0;
    }

    private Long retornaValor(Long valor, Nota nota) {
        int qtdNota = (int) (valor / nota.getValor());
        adicionaNaListaRetorno(qtdNota);
        return valor - (qtdNota * nota.getValor());
    }

    private void adicionaNaListaRetorno(int qtdNota) {
        retorno.add(qtdNota);
    }
}
