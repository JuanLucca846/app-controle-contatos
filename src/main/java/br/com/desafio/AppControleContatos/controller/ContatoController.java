package br.com.desafio.AppControleContatos.controller;

import br.com.desafio.AppControleContatos.model.Contato;
import br.com.desafio.AppControleContatos.service.ContatoServiceImpl;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
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

    @PostMapping
    public ResponseEntity<Contato> save(@Valid @RequestBody Contato contato) {
        Contato newContato = contatoService.save(contato);
        if (newContato == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(newContato);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contato> findById(@PathVariable Long id) {
        Optional<Contato> contato = contatoService.findById(id);
        if (contato.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(contato.get());
    }

    @GetMapping("/pessoa/{id}")
    public ResponseEntity<List<Contato>> findContatoByPessoaId(@PathVariable Long id) {
        List<Contato> contatos = contatoService.findContatoByPessoaId(id);
        return ResponseEntity.ok(contatos);
    }

    @PutMapping
    public ResponseEntity<Contato> update(@Valid @RequestBody Contato contato) {
        Contato atualizarContato = contatoService.update(contato);
        if (atualizarContato == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(atualizarContato);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Contato> delete(@PathVariable Long id) {
        contatoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
