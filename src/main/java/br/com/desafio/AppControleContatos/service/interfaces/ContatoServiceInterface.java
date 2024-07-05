package br.com.desafio.AppControleContatos.service.interfaces;

import br.com.desafio.AppControleContatos.model.Contato;


import java.util.List;
import java.util.Optional;

public interface ContatoServiceInterface {
    Contato save(Contato contato);

    Optional<Contato> findById(Long id);

    List<Contato> findContatoByPessoaId(Long id);

    Contato update(Contato contato);

    void delete(Long id);
}
