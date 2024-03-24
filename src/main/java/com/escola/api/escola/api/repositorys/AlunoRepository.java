package com.escola.api.escola.api.repositorys;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escola.api.escola.api.models.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{

    List<Aluno> findAll();

    Optional<Aluno> findByEmail(String email);



}
