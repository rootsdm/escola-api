package com.escola.api.escola.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escola.api.escola.api.models.Turma;
import com.escola.api.escola.api.services.TurmaService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/turma")
public class TurmaController {

    @Autowired
    TurmaService turmaService;

    @Operation(summary = "Lista todas as Turmas")
    @GetMapping("/lista")
    public ResponseEntity<List<Turma>> findAll() {
        List<Turma> turmaList = turmaService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(turmaList);
    }

    @Operation(summary = "Busca Turma por ID")
    @GetMapping("/{idTurma}")
    public ResponseEntity<Turma> findById(@PathVariable("idTurma") Long idTurma) {
        Optional<Turma> turmaBd = turmaService.findById(idTurma);
        turmaService.isEmpty(turmaBd);

        return ResponseEntity.status(HttpStatus.OK).body(turmaBd.get());
    }

    @Operation(summary = "Salva a Turma")
    @PostMapping("/save")
    public ResponseEntity<Turma> save(@RequestBody Turma turma) {
        turmaService.save(turma);
        return ResponseEntity.status(HttpStatus.CREATED).body(turma);
    }

    @Operation(summary = "Atualiza a Turma")
    @PutMapping("/update/{id}")
    public ResponseEntity<Turma> update(@PathVariable Long id, @RequestBody Turma turma) {

        Optional<Turma> optionalTurma = turmaService.findById(id);
        turmaService.isEmpty(optionalTurma);

        Turma turmaExistente = optionalTurma.get();
        turmaExistente.setNome(turma.getNome());
        turmaExistente.setCargaHoraria(turma.getCargaHoraria());
        turmaExistente.setDataInicio(turma.getDataInicio());
        turmaExistente.setDataTermino(turma.getDataTermino());

        return ResponseEntity.status(HttpStatus.OK).body(turmaService.save(turmaExistente));

    }

    @Operation(summary = "Delete a Turma")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Turma> delete(@PathVariable Long id) {
        Optional<Turma> optionalTurma = turmaService.findById(id);
        turmaService.isEmpty(optionalTurma);
        turmaService.deleteById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
