package br.com.desafio.AppControleContatos.controller;

import br.com.desafio.AppControleContatos.dto.PessoaMalaDireitaDTO;
import br.com.desafio.AppControleContatos.model.Pessoa;
import br.com.desafio.AppControleContatos.service.PessoaServiceImpl;
import br.com.desafio.AppControleContatos.service.interfaces.PessoaServiceInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {

    @Autowired
    PessoaServiceImpl pessoaService;

    @PostMapping
    public ResponseEntity<Pessoa> save(@Valid @RequestBody Pessoa pessoa) {
        Pessoa newPessoa = pessoaService.save(pessoa);
        if (newPessoa == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(newPessoa);
    }

    @GetMapping("/{id}")
    public ResponseEntity<
            Optional<Pessoa>> findById(@PathVariable Long id) {
        Optional<Pessoa> pessoa = pessoaService.findById(id);
        if (pessoa.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pessoa);
    }

    @GetMapping("/maladireita/{id}")
    public ResponseEntity<Optional<PessoaMalaDireitaDTO>> findByMaladireita(@PathVariable Long id) {
        Optional<PessoaMalaDireitaDTO> pessoaDTO = pessoaService.findByIdAndMalaDireita(id);
        if (pessoaDTO.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pessoaDTO);
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> findAll() {
        List<Pessoa> pessoas = pessoaService.findAll();
        if (pessoas == null) {
            return ResponseEntity.notFound().build();
        }
        if (pessoas.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pessoas);
    }

    @PutMapping
    public ResponseEntity<Pessoa> update(@Valid @RequestBody Pessoa pessoa) {
        Pessoa atualizarPessoa = pessoaService.update(pessoa);
        if (atualizarPessoa == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(atualizarPessoa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Pessoa> delete(@PathVariable Long id) {
        pessoaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
