package br.com.desafio.AppControleContatos.controller;

import br.com.desafio.AppControleContatos.model.Contato;
import br.com.desafio.AppControleContatos.service.ContatoServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contatos")
public class ContatoController {

    @Autowired
    ContatoServiceImpl contatoService;

    @Operation(summary = "Cria um novo contato.")
    @PostMapping
    public ResponseEntity<Contato> save(@Valid @RequestBody Contato contato) {
        Contato newContato = contatoService.save(contato);
        if (newContato == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(newContato);
    }

    @Operation(summary = "Realiza a busca de um contato pelo ID.")
    @GetMapping("/{id}")
    public ResponseEntity<Contato> findById(@PathVariable Long id) {
        Optional<Contato> contato = contatoService.findById(id);
        if (contato.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(contato.get());
    }

    @Operation(summary = "Realiza a busca de todos os contatos de um usuário pelo ID do usuário.")
    @GetMapping("/pessoa/{id}")
    public ResponseEntity<List<Contato>> findContatoByPessoaId(@PathVariable Long id) {
        List<Contato> contatos = contatoService.findContatoByPessoaId(id);
        return ResponseEntity.ok(contatos);
    }

    @Operation(summary = "Atualiza um contato.")
    @PutMapping
    public ResponseEntity<Contato> update(@Valid @RequestBody Contato contato) {
        Contato atualizarContato = contatoService.update(contato);
        if (atualizarContato == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(atualizarContato);
    }

    @Operation(summary = "Apaga o registro de um contato pelo ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Contato> delete(@PathVariable Long id) {
        contatoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
