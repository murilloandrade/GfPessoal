package com.github.murilloandrade.gfpessoal.modelo;

import javax.persistence.*;

@MappedSuperclass
public abstract class ObjetoPadrao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
