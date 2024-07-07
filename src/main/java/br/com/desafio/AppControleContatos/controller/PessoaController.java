package br.com.desafio.AppControleContatos.controller;

import br.com.desafio.AppControleContatos.dto.PessoaMalaDireitaDTO;
import br.com.desafio.AppControleContatos.exception.GlobalNotFoundException;
import br.com.desafio.AppControleContatos.model.Pessoa;
import br.com.desafio.AppControleContatos.service.PessoaServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "Cria uma nova pessoa.")
    @PostMapping
    public ResponseEntity<Pessoa> save(@Valid @RequestBody Pessoa pessoa) {
        Pessoa newPessoa = pessoaService.save(pessoa);
        if (newPessoa == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(newPessoa);
    }

    @Operation(summary = "Realiza a busca de uma pessoa pelo ID.")
    @GetMapping("/{id}")
    public ResponseEntity<
            Optional<Pessoa>> findById(@PathVariable Long id) throws GlobalNotFoundException {
        Optional<Pessoa> pessoa = pessoaService.findById(id);
        if (pessoa.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pessoa);
    }

    @Operation(summary = "Realiza a busca de uma pessoa pelo ID, trazendo as informações de endereço, cep, cidade e uf de maneira concatenada.")
    @GetMapping("/maladireita/{id}")
    public ResponseEntity<Optional<PessoaMalaDireitaDTO>> findByMaladireita(@PathVariable Long id) throws GlobalNotFoundException {
        Optional<PessoaMalaDireitaDTO> pessoaDTO = pessoaService.findByIdAndMalaDireita(id);
        if (pessoaDTO.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pessoaDTO);
    }

    @Operation(summary = "Realiza a busca de todas as pessoas registradas.")
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

    @Operation(summary = "Atualiza uma pessoa.")
    @PutMapping
    public ResponseEntity<Pessoa> update(@Valid @RequestBody Pessoa pessoa) throws GlobalNotFoundException {
        Pessoa atualizarPessoa = pessoaService.update(pessoa);
        if (atualizarPessoa == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(atualizarPessoa);
    }

    @Operation(summary = "Apaga o registro de uma pessoa pelo ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Pessoa> delete(@PathVariable Long id) {
        pessoaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
