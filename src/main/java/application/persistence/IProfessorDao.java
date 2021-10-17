package application.persistence;

import application.model.Professor;

import java.sql.SQLException;
import java.util.List;

public interface IProfessorDao {
    public void inserirProfessor(Professor p) throws SQLException;
    public void atualizaProfessor(Professor p) throws SQLException;
    public void excluiProfessor(Professor p) throws SQLException;
    public Professor buscaProfessor(Professor p) throws SQLException;
    public List<Professor> buscaProfessores() throws SQLException;
}
