package br.com.desafio.AppControleContatos.model;


public enum TipoContato {
    TELEFONE(0),
    CELULAR(1);

    public final int tipo;

    TipoContato(int tipo) {
        this.tipo = tipo;
    }


}
