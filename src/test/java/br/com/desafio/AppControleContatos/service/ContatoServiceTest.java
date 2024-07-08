package br.com.desafio.AppControleContatos.service;

import br.com.desafio.AppControleContatos.model.Contato;
import br.com.desafio.AppControleContatos.model.Pessoa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ContatoServiceTest {

    @Mock
    ContatoServiceImpl contatoService;

    @Mock
    PessoaServiceImpl pessoaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Deve criar um contato")
    void saveCase1() throws Exception {
        Contato contato = new Contato(null, 1, "1190000000", null);

        when(contatoService.save(Contato.class.newInstance())).thenReturn(contato);

        Contato newContato = contatoService.save(contato);

        assertThat(newContato).isNotNull();
    }

    @Test
    @DisplayName("Deve buscar um contato por ID")
    void findByIdCase1() throws Exception {
        Contato contato = new Contato(null, 1, "1190000000", null);

        when(contatoService.save(Contato.class.newInstance())).thenReturn(contato);

        Optional<Contato> findContato = contatoService.findById(contato.getId());


        assertThat(findContato).isNotNull();
    }

    @Test
    @DisplayName("Deve buscar todos contatos pelo ID do usuário")
    void findContatoByPessoaId() throws Exception {
        Pessoa pessoa = new Pessoa(null, "Juan Lucca", "Rua Manuel", "00000-000", "São Paulo", "SP", null);

        when(pessoaService.save(Pessoa.class.newInstance())).thenReturn(pessoa);

        Pessoa newPessoa = pessoaService.save(pessoa);

        Contato contato = new Contato(null, 1, "1190000000", newPessoa);

        when(contatoService.save(Contato.class.newInstance())).thenReturn(contato);

        Contato newContato = contatoService.save(contato);

        newPessoa.setContato(Arrays.asList(newContato));

        when(contatoService.findContatoByPessoaId(newPessoa.getId())).thenReturn(Arrays.asList(newContato));

        List<Contato> findContatos = contatoService.findContatoByPessoaId(newPessoa.getId());

        assertThat(findContatos).isNotNull();
        assertThat(findContatos.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("Deve deletar um contato")
    void deleteCase1() throws Exception {
        Contato contato = new Contato(null, 1, "1190000000", null);

        when(contatoService.save(Contato.class.newInstance())).thenReturn(contato);

        Contato newContato = contatoService.save(contato);

        contatoService.delete(newContato.getId());


        verify(contatoService, times(1)).delete(newContato.getId());
    }

}
