package org.soulcodeacademy.empresa.domain.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class DependenteDTO {
    @NotBlank(message = "Campo nome é obrigatório")
    private String nome;
    @NotBlank(message = "Campo idade é obrigatório")
    private Integer idade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }
}
