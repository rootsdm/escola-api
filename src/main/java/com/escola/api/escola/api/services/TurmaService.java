package com.escola.api.escola.api.services;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escola.api.escola.api.models.Aluno;
import com.escola.api.escola.api.models.Turma;
import com.escola.api.escola.api.repositorys.TurmaRepository;

@Service
public class TurmaService {

    @Autowired
    TurmaRepository turmaRepository;

    public java.util.List<Turma> findAll() {
        return turmaRepository.findAll();
    }

    public Optional<Turma> findById(Long id) {
        Optional<Turma> turmaBd = turmaRepository.findById(id);
        return turmaRepository.findById(id);
    }

    public Turma save(Turma turma) {
        return turmaRepository.save(turma);
    }

    public Turma update(Turma turma) {
        return turmaRepository.save(turma);
    }

    public void deleteById(Long id) {
        findById(id);
        turmaRepository.deleteById(id);
    }

    public Boolean isEmpty(Optional<Turma> turma) {
        if (turma.isEmpty()) {
            return true;
        }
        return false;
    }

}
