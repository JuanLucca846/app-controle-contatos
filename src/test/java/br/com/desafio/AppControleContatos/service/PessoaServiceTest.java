package br.com.desafio.AppControleContatos.service;

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

public class PessoaServiceTest {

    @Mock
    PessoaServiceImpl pessoaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Deve criar uma usuário")
    void saveCase1() throws Exception {
        Pessoa pessoa = new Pessoa(null, "Juan Lucca", "Rua Manuel", "00000-000", "São Paulo", "SP", null);

        when(pessoaService.save(Pessoa.class.newInstance())).thenReturn(pessoa);

        Pessoa newPessoa = pessoaService.save(pessoa);

        assertThat(newPessoa).isNotNull();
    }

    @Test
    @DisplayName("Deve buscar um usuário por ID")
    void findByIdCase1() throws Exception {
        Pessoa pessoa = new Pessoa(null, "Juan Lucca", "Rua Manuel", "00000-000", "São Paulo", "SP", null);

        when(pessoaService.save(Pessoa.class.newInstance())).thenReturn(pessoa);

        Optional<Pessoa> findPessoa = pessoaService.findById(pessoa.getId());


        assertThat(findPessoa).isNotNull();
    }

    @Test
    @DisplayName("Deve buscar um usuário por ID com maladireita")
    void findByIdAndMalaDireitaCase1() throws Exception {
        Pessoa pessoa = new Pessoa(null, "Juan Lucca", "Rua Manuel", "00000-000", "São Paulo", "SP", null);

        when(pessoaService.save(Pessoa.class.newInstance())).thenReturn(pessoa);

        Optional<Pessoa> findPessoa = pessoaService.findById(pessoa.getId());

        assertThat(findPessoa).isNotNull();
        assertThat(pessoa.getNome()).isEqualTo("Juan Lucca");
    }

    @Test
    @DisplayName("Deve buscar todos os usuários")
    void findAllCase1() throws Exception {
        Pessoa pessoa1 = new Pessoa(null, "Juan Lucca", "Rua Manuel", "00000-000", "São Paulo", "SP", null);
        Pessoa pessoa2 = new Pessoa(null, "Lucca", "Rua Manuel", "00000-000", "São Paulo", "SP", null);

        List<Pessoa> pessoas = Arrays.asList(pessoa1, pessoa2);
        when(pessoaService.findAll()).thenReturn(pessoas);


        List<Pessoa> findPessoas = pessoaService.findAll();

        assertThat(findPessoas).isNotNull();
        assertThat(findPessoas.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("Deve deletar um usuário")
    void deleteCase1() throws Exception {
        Pessoa pessoa = new Pessoa(null, "Juan Lucca", "Rua Manuel", "00000-000", "São Paulo", "SP", null);

        when(pessoaService.save(Pessoa.class.newInstance())).thenReturn(pessoa);

        Pessoa newPessoa = pessoaService.save(pessoa);

        pessoaService.delete(newPessoa.getId());


        verify(pessoaService, times(1)).delete(newPessoa.getId());
    }
}

