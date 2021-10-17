package application.controller;

import application.model.Professor;

import java.sql.SQLException;

public interface IProfessorController {
    public void inserirProfessor(Professor p) throws ClassNotFoundException, SQLException;
    public void atualizarProfessor(Professor p) throws ClassNotFoundException, SQLException;
    public void excluirProfessor(Professor p) throws ClassNotFoundException, SQLException;
    public void buscarProfessor(Professor p) throws ClassNotFoundException, SQLException;
    public void buscarProfessores() throws ClassNotFoundException, SQLException;
}
