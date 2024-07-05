package br.com.desafio.AppControleContatos.dto;

import br.com.desafio.AppControleContatos.model.Pessoa;

public record PessoaMalaDireitaDTO
        (Long id,
         String nome,
         String malaDireita) {
    public static PessoaMalaDireitaDTO fromPessoa(Pessoa pessoa) {
        String malaDireita = pessoa.getEndereco() + " - " + pessoa.getCep() + " - " + pessoa.getCidade() + "/" + pessoa.getUf();
        return new PessoaMalaDireitaDTO(pessoa.getId(), pessoa.getNome(), malaDireita);
    }
}
