package br.com.desafio.AppControleContatos.service;

import br.com.desafio.AppControleContatos.exception.GlobalNotFoundException;
import br.com.desafio.AppControleContatos.model.Contato;
import br.com.desafio.AppControleContatos.repository.ContatoRepository;
import br.com.desafio.AppControleContatos.repository.PessoaRepository;
import br.com.desafio.AppControleContatos.service.interfaces.ContatoServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContatoServiceImpl implements ContatoServiceInterface {

    @Autowired
    ContatoRepository contatoRepository;
    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public Contato save(Contato contato) {
        return contatoRepository.save(contato);
    }

    @Override
    public Optional<Contato> findById(Long id) {
        Optional<Contato> contato = contatoRepository.findById(id);
        if (contato.isEmpty()) {
            throw new GlobalNotFoundException("Contato com ID:" + id + " não encontrado");
        }
        return contato;
    }

    @Override
    public List<Contato> findContatoByPessoaId(Long id) {
        List<Contato> contato = contatoRepository.findContatoByPessoaId(id);
        if (contato.isEmpty()) {
            throw new GlobalNotFoundException("Contatos da pessoa com ID:" + id + " não encontrados");
        }
        return contato;
    }

    @Override
    public Contato update(Contato contato) throws GlobalNotFoundException {
        Optional<Contato> findContato = contatoRepository.findById(contato.getId());

        if (findContato.isEmpty()) {
            throw new GlobalNotFoundException("Contato não encontrada");
        }

        if (findContato.isPresent()) {
            Contato atualizarContato = findContato.get();
            atualizarContato.setTipo(contato.getTipo());
            atualizarContato.setContato(contato.getContato());
            atualizarContato.setPessoa(contato.getPessoa());

            return contatoRepository.save(atualizarContato);
        }

        return contatoRepository.save(contato);
    }

    @Override
    public void delete(Long id) {
        contatoRepository.deleteById(id);
    }
}
