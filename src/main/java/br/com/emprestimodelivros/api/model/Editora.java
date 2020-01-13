package br.com.emprestimodelivros.api.model;

import javax.persistence.Entity;

@Entity
public class Editora extends AbstractEntity{
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
