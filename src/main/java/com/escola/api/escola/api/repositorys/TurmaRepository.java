package com.escola.api.escola.api.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escola.api.escola.api.models.Turma;

public interface TurmaRepository extends JpaRepository<Turma, Long> {
    
    List<Turma> findAll();


}
