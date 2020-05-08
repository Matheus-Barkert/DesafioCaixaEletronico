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
    private List<Integer> quantidadeNotas = new ArrayList<>();
    private Verificador verificador = new Verificador();

    public Saque realizarSaque(Long valorSaque) {

        quantidadeNotas.clear();
        Long valor = valorSaque;

        if (verificador.verificaValor(valorSaque)) {
            for (Nota nota : listaNotas) {
                valor = retornaValor(valor, nota);
            }
            return new Saque(valorSaque, quantidadeNotas);
        }
        throw new IllegalArgumentException("O valor deve ser positivo e divisivel por ?!(Service)");
    }

    private Long retornaValor(Long valor, Nota nota) {
        int qtdNota = (int) (valor / nota.getValor());
        adicionaNaListaQuantidadeNotas(qtdNota);
        return valor - (qtdNota * nota.getValor());
    }

    private void adicionaNaListaQuantidadeNotas(int qtdNota) {
        quantidadeNotas.add(qtdNota);
    }
}
