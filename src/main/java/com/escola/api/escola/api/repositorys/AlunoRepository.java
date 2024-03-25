package com.escola.api.escola.api.repositorys;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.escola.api.escola.api.models.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    List<Aluno> findAll();

    Optional<Aluno> findByEmail(String email);

    Optional<List<Aluno>> findByNome(String nome);

    Optional<List<Aluno>> findByNomeLike(String nome);

}
