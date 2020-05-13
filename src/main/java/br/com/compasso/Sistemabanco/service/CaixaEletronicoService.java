package br.com.compasso.Sistemabanco.service;

import br.com.compasso.Sistemabanco.entity.CaixaEletronico;
import br.com.compasso.Sistemabanco.entity.Saque;
import br.com.compasso.Sistemabanco.entity.notas.Nota;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CaixaEletronicoService {

    private final List<Nota> notasNoCaixa = new CaixaEletronico().getListaNotas();
    private List<Integer> quantidadeParaCadaNota = new ArrayList<>();
    private Verificador verificador = new Verificador();

    public Saque realizarSaque(Long valorSaque) {

        quantidadeParaCadaNota.clear();

        if (verificador.verificaValor(valorSaque)) {

            Long valor = valorSaque;
            for (Nota nota : notasNoCaixa) {
                valor = realizaCalculoEMontaQuantidadeParaCadaNota(valor, nota.getValor());
            }
            return new Saque(valorSaque, quantidadeParaCadaNota);
        }
        throw new IllegalArgumentException("O valor deve ser positivo e divisivel por ?!(Service)");
    }

    private Long realizaCalculoEMontaQuantidadeParaCadaNota(Long valor, Long valorNota) {
        int quantidadeParaNota = (int) (valor / valorNota);
        quantidadeParaCadaNota.add(quantidadeParaNota);
        return valor - (quantidadeParaNota * valorNota);
    }


    public List<Nota> listaNotas() {
        return notasNoCaixa;
    }
}
