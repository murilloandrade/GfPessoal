package com.github.murilloandrade.gfpessoal.repositorio;

import com.github.murilloandrade.gfpessoal.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositorioUsuario extends JpaRepository<Usuario, Long> {
}
