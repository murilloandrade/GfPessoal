package com.github.murilloandrade.gfpessoal.modelo;

import com.github.murilloandrade.gfpessoal.modelo.enums.*;
import javax.persistence.*;
import java.time.LocalDateTime; // Import the LocalDateTime class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class

@Entity
public class GastoGanho extends ObjetoPadrao {
    private LocalDateTime dataHora;

    private String descricao;

    private double valor;

    private Tipo tipo;

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

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "GastoGanho{" +
                "descricao='" + descricao + '\'' +
                ", tipo=" + tipo +
                ", valor=" + valor +
                ", usuario=" + usuario.getNome() +
                '}';
    }

    public String retornaHoraFormatada(LocalDateTime dataHora) {
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = dataHora.format(formater);
        return formattedDate;
    }
}
