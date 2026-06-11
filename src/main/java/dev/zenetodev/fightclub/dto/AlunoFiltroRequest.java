package dev.zenetodev.fightclub.dto;

public record AlunoFiltroRequest(
        String nome,
        String email,
        String celular,
        String cidade,
        String estado
) {
}
