package com.github.murilloandrade.gfpessoal.configuracao;

import com.github.murilloandrade.gfpessoal.modelo.*;
import com.github.murilloandrade.gfpessoal.modelo.enums.*;
import com.github.murilloandrade.gfpessoal.repositorio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class Instanciacao implements CommandLineRunner {
    @Autowired
    IRepositorioGastoGanho iRepositorioGastoGanho;

    @Autowired
    IRepositorioUsuario iRepositorioUsuario;

    @Override
    public void run(String... args) throws Exception {
        Usuario usuario = new Usuario();
        usuario.setNome("Joao");
        usuario.setWhatsApp("62111111111");

        GastoGanho gastoGanho = new GastoGanho();
        gastoGanho.setTipo(Tipo.Ganho);
        gastoGanho.setUsuario(usuario);
        gastoGanho.setDescricao("Almoço");
        gastoGanho.setValor(12.99);
        gastoGanho.setDataHora(LocalDateTime.now());

        System.out.println(iRepositorioUsuario.save(usuario));
        System.out.println(iRepositorioGastoGanho.save(gastoGanho));
    }
}
