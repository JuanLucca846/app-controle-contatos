package br.com.desafio.AppControleContatos.repository;

import br.com.desafio.AppControleContatos.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    @Query(value = "select tbp.id, tbp.nome, tbp.endereco, tbp.cep, tbp.cidade, tbp.uf from tb_pessoas tbp where id = ?1",
            nativeQuery = true)
    Optional<Pessoa> findByIdAndMalaDireita(Long id);
}
