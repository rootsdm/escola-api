package com.escola.api.escola.api.services;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escola.api.escola.api.models.Turma;
import com.escola.api.escola.api.repositorys.TurmaRepository;

@Service
public class TurmaService {

    @Autowired
    TurmaRepository turmaRepository;

    public java.util.List<Turma> findAll() {
        return turmaRepository.findAll();
    }

    public Turma findById(Long id) {
        Optional<Turma> turma = turmaRepository.findById(id);
        return turma.orElseThrow();
    }

    public Turma save(Turma turma) {
        return turmaRepository.save(turma);
    }

    public Turma update(Turma turma) {
        return turmaRepository.save(turma);
    }

    public void delete(Long id) {
        findById(id);
        turmaRepository.deleteById(id);
    }

    public void DB() {
        Turma turma1 = new Turma();
        turma1.setNome("Turma Git e GitHub");
        turma1.setCargaHoraria(360);
        turma1.setDataInicio(LocalDate.now());
        turma1.setDataTermino(LocalDate.now());
        turmaRepository.save(turma1);
    }

}
