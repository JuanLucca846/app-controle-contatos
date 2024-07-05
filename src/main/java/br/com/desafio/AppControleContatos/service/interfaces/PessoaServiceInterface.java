package br.com.desafio.AppControleContatos.service.interfaces;

import br.com.desafio.AppControleContatos.dto.PessoaMalaDireitaDTO;
import br.com.desafio.AppControleContatos.model.Pessoa;


import java.util.List;
import java.util.Optional;

public interface PessoaServiceInterface {

    Pessoa save(Pessoa pessoa);

    Optional<Pessoa> findById(Long id);

    Optional<PessoaMalaDireitaDTO> findByIdAndMalaDireita(Long id);

    List<Pessoa> findAll();

    Pessoa update(Pessoa pessoa);

    void delete(Long id);


}
