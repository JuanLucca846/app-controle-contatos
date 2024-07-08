package br.com.desafio.AppControleContatos.model;

import br.com.desafio.AppControleContatos.exception.GlobalEnumException;

public enum TipoContato {
    TELEFONE(0),
    CELULAR(1);

    public final int tipo;

    TipoContato(int tipo) {
        this.tipo = tipo;
    }


}
