package com.escola.api.escola.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.escola.api.escola.api.models.Aluno;
import com.escola.api.escola.api.repositorys.AlunoRepository;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository alunoRepository;

    public java.util.List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    public Optional<Aluno> findById(Long id) {
        return alunoRepository.findById(id);

    }

    public Aluno save(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public Aluno update(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public void deleteById(Long id) {
        findById(id);
        alunoRepository.deleteById(id);
    }

    public Boolean isEmpty(Optional<Aluno> aluno) {
        if (aluno.isEmpty()) {
            return true;
        }
        return false;
    }

    public Optional<List<Aluno>> findByNome(String nome) {
        return alunoRepository.findByNome(nome);

    }

    public Optional<List<Aluno>> findByNomeLike(String nome) {
        return alunoRepository.findByNomeLike(nome);

    }



}
