package com.caiojacinthodev.patrimonio.domain.patrimonio;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatriminioRepository extends JpaRepository<Patrimonio,String> {
    List<Patrimonio> findBySetor(String setor);
}
