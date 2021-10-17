package application.controller;

import application.model.Disciplina;

import java.sql.SQLException;

public interface IDisciplinaController {
    public void inserirDisciplina(Disciplina d) throws ClassNotFoundException, SQLException;
    public void atualizarDisciplina(Disciplina d) throws ClassNotFoundException, SQLException;
    public void excluirDisciplina(Disciplina d) throws ClassNotFoundException, SQLException;
    public void buscarDisciplina(Disciplina d) throws ClassNotFoundException, SQLException;
    public void buscarDisciplinas() throws ClassNotFoundException, SQLException;
}
