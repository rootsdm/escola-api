package com.escola.api.escola.api.services;

import java.time.LocalDate;
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

    public Aluno findById(Long id) {
        Optional<Aluno> aluno = alunoRepository.findById(id);
        return aluno.orElseThrow();
    }

    public Aluno save(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public Aluno update(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public void delete(Long id) {
        findById(id);
        alunoRepository.deleteById(id);
    }

    public void DB() {
        Aluno aluno1 = new Aluno();
        aluno1.setNome("sergio");
        aluno1.setSobrenome("diniz");
        aluno1.setEmail("sergio@gmail.com");
        aluno1.setDtNascimento(LocalDate.now());
        alunoRepository.save(aluno1);
    }

}
