package com.github.murilloandrade.gfpessoal.repositorio;

import com.github.murilloandrade.gfpessoal.modelo.Carona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRepositorioCarona extends JpaRepository<Carona, Long> {
    List<Carona> findByBairroContainingIgnoreCaseOrDescricaoContainingIgnoreCase(String texto, String texto1);
}
