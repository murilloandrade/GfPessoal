package com.github.gavioesdoforro.universirides.repositorio;

import com.github.gavioesdoforro.universirides.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositorioUsuario extends JpaRepository<Usuario, Long> {
}
