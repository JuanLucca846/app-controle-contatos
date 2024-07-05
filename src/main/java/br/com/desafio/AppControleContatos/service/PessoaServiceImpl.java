package br.com.desafio.AppControleContatos.service;

import br.com.desafio.AppControleContatos.dto.PessoaMalaDireitaDTO;
import br.com.desafio.AppControleContatos.model.Pessoa;
import br.com.desafio.AppControleContatos.repository.PessoaRepository;
import br.com.desafio.AppControleContatos.service.interfaces.PessoaServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaServiceImpl implements PessoaServiceInterface {

    @Autowired
    private PessoaRepository pessoaRepository;


    @Override
    public Pessoa save(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    @Override
    public Optional<Pessoa> findById(Long id) {
        return pessoaRepository.findById(id);
    }

    @Override
    public Optional<PessoaMalaDireitaDTO> findByIdAndMalaDireita(Long id) {
        Optional<Pessoa> pessoa = pessoaRepository.findByIdAndMalaDireita(id);

        return pessoa.map(PessoaMalaDireitaDTO::fromPessoa);
    }

    @Override
    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    @Override
    public Pessoa update(Pessoa pessoa) {
        Optional<Pessoa> findPessoa = pessoaRepository.findById(pessoa.getId());

        if (findPessoa.isPresent()) {
            Pessoa atualizarPessoa = findPessoa.get();
            atualizarPessoa.setNome(pessoa.getNome());
            atualizarPessoa.setEndereco(pessoa.getEndereco());
            atualizarPessoa.setCep(pessoa.getCep());
            atualizarPessoa.setCidade(pessoa.getCidade());
            atualizarPessoa.setUf(pessoa.getUf());
            atualizarPessoa.setContato(pessoa.getContato());

            return pessoaRepository.save(atualizarPessoa);
        }
        return pessoaRepository.save(pessoa);
    }

    @Override
    public void delete(Long id) {
        pessoaRepository.deleteById(id);
    }
}
