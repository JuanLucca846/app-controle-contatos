package br.com.desafio.AppControleContatos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_pessoas")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Atributo nome é obrigatório")
    @Size(min = 2, max = 50)
    private String nome;

    @Size(min = 2, max = 100)
    private String endereco;

    @Size(min = 2, max = 50)
    private String cep;

    @Size(min = 2, max = 50)
    private String cidade;

    @Size(min = 2, max = 50)
    private String uf;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pessoa", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("pessoa")
    private List<Contato> contato;

    public Pessoa() {
    }

    public Pessoa(Long id, String nome, String endereco, String cep, String cidade, String uf, List<Contato> contato) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.cep = cep;
        this.cidade = cidade;
        this.uf = uf;
        this.contato = contato;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "Atributo nome é obrigatório") @Size(min = 2, max = 50) String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "Atributo nome é obrigatório") @Size(min = 2, max = 50) String nome) {
        this.nome = nome;
    }

    public @Size(min = 2, max = 100) String getEndereco() {
        return endereco;
    }

    public void setEndereco(@Size(min = 2, max = 100) String endereco) {
        this.endereco = endereco;
    }

    public @Size(min = 2, max = 50) String getCep() {
        return cep;
    }

    public void setCep(@Size(min = 2, max = 50) String cep) {
        this.cep = cep;
    }

    public @Size(min = 2, max = 50) String getCidade() {
        return cidade;
    }

    public void setCidade(@Size(min = 2, max = 50) String cidade) {
        this.cidade = cidade;
    }

    public @Size(min = 2, max = 50) String getUf() {
        return uf;
    }

    public void setUf(@Size(min = 2, max = 50) String uf) {
        this.uf = uf;
    }

    public List<Contato> getContato() {
        return contato;
    }

    public void setContato(List<Contato> contato) {
        this.contato = contato;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(id, pessoa.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "[id = " + this.id + ", " +
                "nome = " + this.nome + ", " +
                "Endereço = " + this.endereco + ", " +
                "Cep = " + this.cep + ", " +
                "Cidade = " + this.cidade + ", " +
                "Uf = " + this.uf + "," +
                "Contato = " + this.contato + "]";
    }
}
