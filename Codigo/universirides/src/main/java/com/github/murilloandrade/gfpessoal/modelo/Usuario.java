package com.github.murilloandrade.gfpessoal.modelo;

import javax.persistence.*;
import java.util.*;

@Entity
public class Usuario extends ObjetoPadrao {
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<GastoGanho> gastoGanhosList = new ArrayList<>();

    private String nome;
    private String whatsApp;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getWhatsApp() {
        return whatsApp;
    }

    public void setWhatsApp(String whatsApp) {
        this.whatsApp = whatsApp;
    }

    public List<GastoGanho> getGastoGanhosList() {
        return gastoGanhosList;
    }

    public void setGastoGanhosList(List<GastoGanho> gastoGanhosList) {
        this.gastoGanhosList = gastoGanhosList;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + this.getId() +
                ", nome='" + nome + '\'' +
                ", whatsApp='" + whatsApp + '\'' +
                ", gastoGanhosList=" + gastoGanhosList +
                '}';
    }
}
