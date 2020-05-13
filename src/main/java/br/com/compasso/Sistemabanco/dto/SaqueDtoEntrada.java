package br.com.compasso.Sistemabanco.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SaqueDtoEntrada {

    @NotNull(message = "Valor nao pode ser nulo!")
    @Positive(message = "O valor deve ser positivo!")
    @Min(value = 5)
    private Long valor;

}
