package com.escola.api.escola.api.controllers;

import java.util.List;
import java.util.stream.Collectors;

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

import com.escola.api.escola.api.models.Aluno;
import com.escola.api.escola.api.services.AlunoService;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    AlunoService alunoService;

    @GetMapping("/listagem")
    public ResponseEntity<List<Aluno>> findAll() {
        List<Aluno> alunoList = alunoService.findAll();
        //alunoService.DB();
    
        return ResponseEntity.ok().body(alunoList);
    }


    @PostMapping("/save")
     public ResponseEntity<Aluno> save(@RequestBody Aluno aluno) {
        alunoService.save(aluno);
        return ResponseEntity.ok().body(aluno);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Aluno> update(@PathVariable Long id, @RequestBody Aluno aluno) {
        aluno.setId(id);
        return ResponseEntity.ok().body(aluno);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Aluno> delete(@PathVariable Long id) {
        alunoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
