package application.controller;

import application.model.Disciplina;
import application.persistence.DisciplinaDao;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.util.List;

public class DisciplinaController implements IDisciplinaController{
    private TextField tfCodigoDisciplina;
    private TextField tfNomeDisciplina;
    private TextField tfCodigoProfessorDisciplina;
    private Label lblProfessor;
    private TextArea taListaDisciplina;

    public DisciplinaController(TextField tfCodigoDisciplina, TextField tfNomeDisciplina, TextField getTfCodigoProfessor, Label lblProfessor, TextArea taListaDisciplina) {
        this.tfCodigoDisciplina = tfCodigoDisciplina;
        this.tfNomeDisciplina = tfNomeDisciplina;
        this.tfCodigoProfessorDisciplina = tfCodigoProfessorDisciplina;
        this.lblProfessor = lblProfessor;
        this.taListaDisciplina = taListaDisciplina;
    }

    @Override
    public void inserirDisciplina(Disciplina d) throws ClassNotFoundException, SQLException {
        DisciplinaDao dDao = new DisciplinaDao();
        dDao.inserirDisciplina(d);
        limpaCamposDisciplina();
        buscarDisciplinas();
    }

    @Override
    public void atualizarDisciplina(Disciplina d) throws ClassNotFoundException, SQLException {
        DisciplinaDao dDao = new DisciplinaDao();
        dDao.atualizaDisciplina(d);
        limpaCamposDisciplina();
        buscarDisciplinas();
    }

    @Override
    public void excluirDisciplina(Disciplina d) throws ClassNotFoundException, SQLException {
        DisciplinaDao dDao = new DisciplinaDao();
        dDao.excluiDisciplina(d);
        limpaCamposDisciplina();
        buscarDisciplinas();
    }

    @Override
    public void buscarDisciplina(Disciplina d) throws ClassNotFoundException, SQLException {
    limpaCamposDisciplina();
        DisciplinaDao dDao = new DisciplinaDao();
        d=dDao.buscaDisciplina(d);
        tfCodigoDisciplina.setText(String.valueOf(d.getCodigo()));
        tfNomeDisciplina.setText(d.getNome());
        tfCodigoProfessorDisciplina.setText(String.valueOf(d.getProfessor()));
        lblProfessor.setText(d.getProfessor().getNome());
    }

    @Override
    public void buscarDisciplinas() throws ClassNotFoundException, SQLException {
    limpaCamposDisciplina();
        DisciplinaDao dDao = new DisciplinaDao();
        List<Disciplina> listaDisciplinas=dDao.buscaDisciplinas();
        taListaDisciplina.setText("");
        StringBuffer buffer=new StringBuffer("Código\t\t\t\tNome\t\t\t\tProfessor\n");
        for(Disciplina d:listaDisciplinas){
            buffer.append(d.getCodigo()+"\t\t\t\t\t"+d.getNome()+"\t\t\t\t"+d.getProfessor()+"\n");
        }
        taListaDisciplina.setText(buffer.toString());

    }
    private void limpaCamposDisciplina(){
        tfCodigoDisciplina.setText("");
        tfNomeDisciplina.setText("");
        tfCodigoProfessorDisciplina.setText("");
        lblProfessor.setText("");
    }
}
