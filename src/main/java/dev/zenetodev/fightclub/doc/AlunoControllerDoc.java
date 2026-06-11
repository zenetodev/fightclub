package dev.zenetodev.fightclub.doc;

import dev.zenetodev.fightclub.dto.AlunoFiltroRequest;
import dev.zenetodev.fightclub.dto.AlunoRequest;
import dev.zenetodev.fightclub.dto.AlunoResponse;
import io.micrometer.observation.transport.ResponseContext;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(
        name = "Alunos",
        description = "Operaçoes para cadastro, consulta, atualização, exclusão" +
                      " e filtragem de alunos"
)
public interface AlunoControllerDoc {

    @Operation(
            summary = "Cadastrar aluno",
            description = "Cria um novo aluno no sistema",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Aluno cadastrado com sucesso!"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "erro de valiacao ou regra de negocio",
                            content = @Content(schema = @Schema(implementation =  ErrorResponse.class))
                    )
            }
    )
    AlunoResponse cadastrar
                    (
                            @RequestBody
                            @Valid
                            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                                    description = "Dados necessarios para cadastrar um aluno",
                                    required = true,
                                    content =  @Content(schema = @Schema(implementation = AlunoRequest.class),
                                    examples = @ExampleObject(
                                            name = "Aluno valido",
                                            value = """
                                                    {
                                                            "nome": "Vanessa Oliveira",
                                                            "dataNascimento": "2002-08-15",
                                                            "sexo": "F",
                                                            "telefone": "4833334444",
                                                            "celular": "48991645543",
                                                            "email": "vanessaoli@gmail.com",
                                                            "observacao": "Aluna Ja possui boa avaliacao",
                                                            "endereco": "Rua das flores",
                                                            "numero": "123",
                                                            "complemento": "Apartamento 202",
                                                            "bairro": "Centro",
                                                            "cidade": "Criciuma",
                                                            "estado": "SC",
                                                            "cep": "8880"
                                                    }
                                                    """
                                    ))
                            )
                            AlunoRequest request
                    );
    @Operation(
            summary = "Listar alunos",
            description = "Lista alunos de forma paginada permitindo filtros opcionais por " +
                          "nome, email, celular, cidade e estado",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Lista de alunos retornada com sucesso")
            }
    )
    Page<AlunoResponse> listar(
            @Parameter(description = "Filtros opcionais para busca de alunos")
            AlunoFiltroRequest filtro,

            @Parameter(description = "Informacoes de paginacao e ordenacao")
            Pageable pageable
    );

    @Operation(
            summary = "Buscar aluno por ID",
            description = "Retorna os dados resumidos de um aluno especifico " +
                    "nome, email, celular, cidade e estado",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Aluno encontrado"),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Aluno não encontrado",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class))
                    )
            }
    )
    AlunoResponse buscarPorId(
            @Parameter(description = "ID do aluno", example = "2", required = true)
            Long id
    );
}
