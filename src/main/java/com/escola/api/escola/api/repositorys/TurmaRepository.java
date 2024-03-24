package com.escola.api.escola.api.repositorys;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.escola.api.escola.api.models.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {
    
    List<Turma> findAll();


}
