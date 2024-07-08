package br.com.desafio.AppControleContatos.repository;

import br.com.desafio.AppControleContatos.model.Contato;
import br.com.desafio.AppControleContatos.model.Pessoa;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

@DataJpaTest
@ActiveProfiles("test")
public class ContatoRepositoryTest {

    @Autowired
    ContatoRepository contatoRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    @DisplayName("Deve retornar todos contatos de um usuário")
    void findContatoByPessoaIdCase1() {

        Pessoa pessoa = new Pessoa(null, "Juan Lucca", "Rua Manuel", "00000-000", "São Paulo", "SP", null);
        this.criarPessoa(pessoa);

        Contato contato = new Contato(null, 1, "119000-0000", pessoa);
        this.criarContato(contato);

        List<Contato> contatos = Arrays.asList(contato);

        pessoa.setContato(contatos);

        List<Contato> resultado = this.contatoRepository.findContatoByPessoaId(pessoa.getId());
        assertThat(resultado.isEmpty()).isFalse();

    }

    @Test
    @DisplayName("Não deve retornar todos contatos de um usuário")
    void findContatoByPessoaIdCase2() {

        Pessoa pessoa = new Pessoa(null, "Juan Lucca", "Rua Manuel", "00000-000", "São Paulo", "SP", null);
        this.criarPessoa(pessoa);

        List<Contato> resultado = this.contatoRepository.findContatoByPessoaId(pessoa.getId());
        assertThat(resultado.isEmpty()).isTrue();

    }

    private Pessoa criarPessoa(Pessoa pessoa) {
        this.entityManager.persist(pessoa);
        return pessoa;
    }

    private Contato criarContato(Contato contato) {
        this.entityManager.persist(contato);
        return contato;
    }

}
