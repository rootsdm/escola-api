package com.escola.api.escola.api.models;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_turma")
public class Turma implements Serializable {

    @Serial
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTurma", nullable = false)
    private Long idTurma;

    @Column(name = "nome", unique = true)
    private String nome;

    @Column(name = "cargaHoraria")
    private Integer cargaHoraria;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "dataInicio")
    private LocalDate dataInicio;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "dataTermino")
    private LocalDate dataTermino;

    @ManyToMany
    private List<Aluno> alunosList;

    public Turma() {
    }

    public Turma(Long idTurma, String nome, Integer cargaHoraria, LocalDate dataInicio, LocalDate dataTermino,
            List<Aluno> alunosList) {
        this.idTurma = idTurma;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.alunosList = alunosList;
    }

    public Long getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(Long idTurma) {
        this.idTurma = idTurma;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(LocalDate dataTermino) {
        this.dataTermino = dataTermino;
    }

    public List<Aluno> getAlunosList() {
        return alunosList;
    }

    public void setAlunosList(List<Aluno> alunosList) {
        this.alunosList = alunosList;
    }

  

}
