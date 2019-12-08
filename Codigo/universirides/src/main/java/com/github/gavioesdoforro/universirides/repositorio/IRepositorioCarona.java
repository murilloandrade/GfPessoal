package com.github.gavioesdoforro.universirides.repositorio;

import com.github.gavioesdoforro.universirides.modelo.Carona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRepositorioCarona extends JpaRepository<Carona, Long> {
    List<Carona> findByBairroContainingIgnoreCaseOrDescricaoContainingIgnoreCase(String texto, String texto1);
}
