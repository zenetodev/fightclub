package dev.zenetodev.fightclub.dto;

import dev.zenetodev.fightclub.domain.Aluno;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record AlunoRequest(
        @NotBlank(message = "O nome é obrigatório!")
        @Size(max = 150, message = "o nome deve ter no maximo 150 caracteres")
        String nome,

        @Past(message = "data de nascimento deve estar no passado")
        LocalDate dataNascimento,

        @Size(max = 1, message = "O sexo deve ter no maximo 1 caractere")
        String sexo,

        @Size(max = 30, message = "o telefone deve conter no maximo 30 caracteres")
        String telefone,

        @Size(max = 30, message = "o celular deve conter no maximo 30 caracteres")
        String celular,

        @Email(message = "Email invalido")
        @Size(max = 150, message = "O email deve ter no maximo 150 caracteres")
        String email,

        String observacao,

        @Size(max = 150, message = "O endereço deve ter no maximo 150 caracteres")
        String endereco,

        @Size(max = 20, message = "O numero deve ter no maximo 20 caracteres")
        String numero,

        @Size(max = 100, message = "o complemento deve ter no maximo 100 caracteres")
        String complemento,

        @Size(max = 100, message = "o bairro deve ter no maximo 100 caracteres")
        String bairro,

        @Size(max = 2, message = "o estado deve ter no maximo 2 caracteres")
        String estado,

        @Size(max = 20, message = "o cep deve ter no maximo 20 caracteres")
        String cep,

        @Size(max = 100, message = "A cidade deve ter no maximo 100 caracteres")
        String cidade) {

    public Aluno toEntity() {
        Aluno aluno = new Aluno();
        preencher(aluno);

        return aluno;
    }

    public void preencher(Aluno aluno) {
        aluno.setNome(nome);
        aluno.setDataNascimento(dataNascimento);
        aluno.setSexo(sexo);
        aluno.setTelefone(telefone);
        aluno.setCelular(celular);
        aluno.setEmail(email);
        aluno.setObservacao(observacao);
        aluno.setEndereco(endereco);
        aluno.setNumero(numero);
        aluno.setComplemento(complemento);
        aluno.setBairro(bairro);
        aluno.setCidade(cidade);
        aluno.setEstado(estado);
        aluno.setCep(cep);
    }
}
