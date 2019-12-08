package com.github.murilloandrade.gfpessoal.modelo;

import com.github.murilloandrade.gfpessoal.modelo.enums.*;
import javax.persistence.*;

@Entity
public class Carona extends ObjetoPadrao {
    private String bairro;

    private String descricao;

    private Status status;

    private Tipo tipo;

    private Turno turno;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }


    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Carona{" +
                "descricao='" + descricao + '\'' +
                ", tipo=" + tipo +
                ", turno=" + turno +
                ", bairro='" + bairro + '\'' +
                ", usuario=" + usuario.getNome() +
                '}';
    }

}
