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

import com.escola.api.escola.api.models.Aluno;
import com.escola.api.escola.api.repositorys.AlunoRepository;
import com.escola.api.escola.api.services.AlunoService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    AlunoService alunoService;

    @Autowired
    AlunoRepository alunoRepository;

    @Operation(summary = "Lista todos os Alunos")
    @GetMapping("/lista")
    public ResponseEntity<List<Aluno>> findAll() {
        List<Aluno> alunoList = alunoService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(alunoList);
    }

    @Operation(summary = "Busca Aluno por ID")
    @GetMapping("/{id}")
    public ResponseEntity<Aluno> findById(@PathVariable("id") Long id) {
        Optional<Aluno> optionalAluno = alunoRepository.findById(id);
        alunoService.isEmpty(optionalAluno);
        return ResponseEntity.status(HttpStatus.OK).body(optionalAluno.get());

    }

    @Operation(summary = "Salva o Aluno")
    @PostMapping("/save")
    public ResponseEntity<Aluno> save(@RequestBody Aluno aluno) {
        alunoService.save(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(aluno);
    }

    @Operation(summary = "Atualiza o Aluno")
    @PutMapping("/update/{id}")
    public ResponseEntity<Aluno> update(@PathVariable("id") Long id, @RequestBody Aluno aluno) {
        Optional<Aluno> optionalAluno = alunoRepository.findById(id);
        alunoService.isEmpty(optionalAluno);

        Aluno alunoExistente = optionalAluno.get();
        alunoExistente.setNome(aluno.getNome());
        alunoExistente.setDtNascimento(aluno.getDtNascimento());
        alunoExistente.setEmail(aluno.getEmail());
        alunoExistente.setSobrenome(aluno.getSobrenome());

        return ResponseEntity.status(HttpStatus.OK).body(alunoRepository.save(alunoExistente));

    }

    @Operation(summary = "Deleta  o Aluno")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Aluno> delete(@PathVariable("id") Long id) {
        Optional<Aluno> optionalAluno = alunoRepository.findById(id);
        alunoService.isEmpty(optionalAluno);
        alunoService.deleteById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Operation(summary = "Busca Aluno por E-mail")
    @GetMapping("/email/{email}")
    public ResponseEntity<Aluno> findByEmail(@PathVariable("email") String email) {
        Optional<Aluno> optionalAluno = alunoRepository.findByEmail(email);
        alunoService.isEmpty(optionalAluno);

        return ResponseEntity.status(HttpStatus.OK).body(optionalAluno.get());

    }
    @Operation(summary = "Busca Aluno por Nome")
    @GetMapping("/nome/{nome}")
    public ResponseEntity<Optional<List<Aluno>>> findByNome(@PathVariable("nome") String nome) {
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.findByNome(nome));
    }

    @Operation(summary = "Busca Aluno por parte do Nome")
    @GetMapping("/busca/nome/{nome}")
    public ResponseEntity<Optional<List<Aluno>>> findByNomeLike(@PathVariable("nome") String nome) {
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.findByNomeLike("%" + nome + "%"));
    }

}
