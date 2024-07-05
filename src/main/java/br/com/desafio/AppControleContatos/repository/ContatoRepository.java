package br.com.desafio.AppControleContatos.repository;

import br.com.desafio.AppControleContatos.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {

    @Query(value = "select * from tb_contatos tbc where tbc.pessoa_id = ?1",
            nativeQuery = true)
    List<Contato> findContatoByPessoaId(Long id);
}
