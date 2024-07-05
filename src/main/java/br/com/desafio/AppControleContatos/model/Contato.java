package br.com.desafio.AppControleContatos.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Entity
@Table(name = "tb_contatos")
public class Contato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Atributo tipo é obrigatório")
    private int tipo;

    @NotBlank(message = "Atributo contato é obrigatório")
    @Size(min = 2, max = 50)
    private String contato;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    @JsonBackReference
    private Pessoa pessoa;

    public Contato() {
    }

    public Contato(Long id, int tipo, String contato, Pessoa pessoa) {
        this.id = id;
        this.tipo = tipo;
        this.contato = contato;
        this.pessoa = pessoa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    public int getTipo() {
        return tipo;
    }

    public void setTipo(@NotNull int tipo) {
        this.tipo = tipo;
    }

    public @NotBlank(message = "Atributo contato é obrigatório") @Size(min = 2, max = 50) String getContato() {
        return contato;
    }

    public void setContato(@NotBlank(message = "Atributo contato é obrigatório") @Size(min = 2, max = 50) String contato) {
        this.contato = contato;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contato contato = (Contato) o;
        return Objects.equals(id, contato.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "[id = " + this.id + ", " +
                "Tipo = " + this.tipo + ", " +
                "Contato = " + this.contato + ", " +
                "Pessoa = " + this.pessoa + "]";
    }
}
