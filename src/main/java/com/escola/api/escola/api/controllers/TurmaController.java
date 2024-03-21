package com.escola.api.escola.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/turma")
public class TurmaController {

    @Autowired
    TurmaService turmaService;

    @GetMapping("/listagem")
    public ResponseEntity<List<Turma>> findAll() {
        List<Turma> turmaList = turmaService.findAll();
        //turmaService.DB(); - carga no banco para teste e validação dos registros
    
        return ResponseEntity.ok().body(turmaList);
    }


    @PostMapping("/save")
     public ResponseEntity<Turma> save(@RequestBody Turma turma) {
        turmaService.save(turma);
        return ResponseEntity.ok().body(turma);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Turma> update(@PathVariable Long id, @RequestBody Turma turma) {
        turma.setIdTurma(id);
        turmaService.save(turma);
        return ResponseEntity.ok().body(turma);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Turma> delete(@PathVariable Long id) {
        turmaService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
