package dev.zenetodev.fightclub.controller;

import dev.zenetodev.fightclub.doc.AlunoControllerDoc;
import dev.zenetodev.fightclub.dto.AlunoFiltroRequest;
import dev.zenetodev.fightclub.dto.AlunoRequest;
import dev.zenetodev.fightclub.dto.AlunoResponse;
import dev.zenetodev.fightclub.service.AlunoService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alunos")
public class AlunoController implements AlunoControllerDoc {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping
    public AlunoResponse cadastrar(@RequestBody @Valid AlunoRequest alunoRequest){
        return alunoService.cadastrar(alunoRequest);
    }

    @GetMapping
    public Page<AlunoResponse> listar(AlunoFiltroRequest filtro, Pageable pageable){
        return alunoService.listar(filtro, pageable);
    }

    @GetMapping("/{id}")
    public AlunoResponse buscarPorId(@PathVariable Long id){
        return alunoService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public AlunoResponse atualizar(@PathVariable Long id, @RequestBody @Valid AlunoRequest alunoRequest){
        return alunoService.atualizar(id, alunoRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id){
        alunoService.excluir(id);
    }

}
