package br.com.ifpe.oxefood.api.produto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.ifpe.oxefood.modelo.produto.Produto;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoRequest {
    
    @NotNull(message = "O Nome é de preenchimento obrigatório")
    @NotEmpty(message = "O Nome é de preenchimento obrigatório")
    @Length(max = 100, message = "O Nome deverá ter no máximo {max} caracteres")
    private String codigo;

    private String produto;

    private String titulo;

    private String descricao;

    @Min(value = 20, message = "Valor não pode ser menor que 20.00")
    @Max(value = 100, message = "Valor não pode ser maior que 100")
    private double valorUnitario;

    private int tempoEntregaMaximo;

    private int tempoEntregaMinimo;

    public Produto build() {

        return Produto.builder()

                .codigo(codigo)
                .titulo(titulo)
                .descricao(descricao)
                .valorUnitario(valorUnitario)
                .tempoEntregaMinimo(tempoEntregaMinimo)
                .tempoEntregaMaximo(tempoEntregaMaximo)
                .build();
    }

}
