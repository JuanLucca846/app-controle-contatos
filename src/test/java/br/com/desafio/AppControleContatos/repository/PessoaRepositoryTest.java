package br.com.desafio.AppControleContatos.repository;

import br.com.desafio.AppControleContatos.model.Pessoa;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
public class PessoaRepositoryTest {

    @Autowired
    PessoaRepository pessoaRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    @DisplayName("Deve retornar um usuário com maladireita")
    void findByIdAndMalaDireitaCase1() {

        Pessoa pessoa = new Pessoa(null, "Juan Lucca", "Rua Manuel", "00000-000", "São Paulo", "SP", null);
        this.criarPessoa(pessoa);

        Optional<Pessoa> resultado = this.pessoaRepository.findByIdAndMalaDireita(pessoa.getId());
        assertThat(resultado.isEmpty()).isFalse();
    }

    private Pessoa criarPessoa(Pessoa pessoa) {
        this.entityManager.persist(pessoa);
        return pessoa;
    }
}
