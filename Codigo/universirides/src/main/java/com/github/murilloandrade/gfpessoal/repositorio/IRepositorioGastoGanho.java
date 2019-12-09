package com.github.murilloandrade.gfpessoal.repositorio;

import com.github.murilloandrade.gfpessoal.modelo.GastoGanho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRepositorioGastoGanho extends JpaRepository<GastoGanho, Long> {
    List<GastoGanho> findByDescricaoContainingIgnoreCase(String texto);
}
