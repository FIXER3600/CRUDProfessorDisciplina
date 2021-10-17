package com.application.crudprofessordisciplina;
import application.controller.DisciplinaController;
import application.controller.ProfessorController;
import application.model.Disciplina;
import application.model.Professor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class PrincipalController {
    @FXML
    private TextField tfCodigoProfessor;
    @FXML
    private TextField tfNomeProfessor;
    @FXML
    private TextField tfTitulacaoProfessor;
    @FXML
    private Button btnBuscarProfessor;
    @FXML
    private Button btnInserirProfessor;
    @FXML
    private Button btnAtualizaProfessor;
    @FXML
    private Button btnExcluiProfessor;
    @FXML
    private Button btnListarProfessor;
    @FXML
    private TextArea taListaProfessor;
    @FXML
    private Button btnCopiaProfessor;
    @FXML
    private TextField tfCodigoDisciplina;
    @FXML
    private TextField tfNomeDisciplina;
    @FXML
    private TextField tfCodigoProfessorDisciplina;
    @FXML
    private Button btnBuscarDisciplina;
    @FXML
    private Button btnInserirDisciplina;
    @FXML
    private Button btnAtualizarDisciplina;
    @FXML
    private Button btnExcluirDisciplina;
    @FXML
    private Button btnListarDisciplina;
    @FXML
    private TextArea taListaDisciplina;
    @FXML
    private Label lblNomeProfessor;
    private javax.swing.JOptionPane JOptionPane;

    @FXML
    public void acaoProfessor(ActionEvent event){
        String cmd=event.getSource().toString();
        ProfessorController professorController = new ProfessorController(tfCodigoProfessor,tfNomeProfessor,tfTitulacaoProfessor,taListaProfessor);
        if ((cmd.contains("Inserir")||cmd.contains("Atualizar"))
        && (tfCodigoProfessor.getText().isEmpty() || tfNomeProfessor.getText().isEmpty()
        || tfTitulacaoProfessor.getText().isEmpty())){
            JOptionPane.showMessageDialog(null,"Preencha os campos","ERRO",JOptionPane.ERROR_MESSAGE);
        }else{
            if(cmd.contains("Excluir")||cmd.contains("Buscar")||cmd.contains("tfCodigoProfessor")
            && tfCodigoProfessor.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Preencha o código","ERRO",JOptionPane.ERROR_MESSAGE);
            }else {
                try {
                    if (cmd.contains("Listar")){
                        professorController.buscarProfessores();
                    } else{
                        Professor professor = new Professor();
                        professor.setCodigo(Integer.parseInt(tfCodigoProfessor.getText()));
                        professor.setNome(tfNomeProfessor.getText());
                        professor.setTitulacao(tfTitulacaoProfessor.getText());
                        if (cmd.contains("Inserir")){
                            professorController.inserirProfessor(professor);
                        }else if (cmd.contains("Atualizar")){
                            professorController.atualizarProfessor(professor);
                        }else if (cmd.contains("Excluir")){
                            professorController.excluirProfessor(professor);
                        }else if(cmd.contains("Buscar") || cmd.contains("tfCodigoProfessor")){
                            professorController.buscarProfessor(professor);
                        }
                    }
                }catch (ClassNotFoundException | SQLException e){
                    JOptionPane.showMessageDialog(null,e.getMessage(),"ERRO",JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                }
            }
        }

    }
    @FXML
    public void copiaProfessor(ActionEvent event){
        if(tfCodigoProfessor.getText().isEmpty() || tfNomeProfessor.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Preencha os campos","ERRO",JOptionPane.ERROR_MESSAGE);
        }else{
            tfCodigoProfessorDisciplina.setText(tfCodigoProfessor.getText());
            lblNomeProfessor.setText(tfNomeProfessor.getText());
        }
    }
    @FXML
    public void acaoDisciplina(ActionEvent event) throws SQLException, ClassNotFoundException {
        DisciplinaController disciplinaController = new DisciplinaController(tfCodigoDisciplina,tfNomeDisciplina,tfCodigoProfessorDisciplina,lblNomeProfessor,taListaDisciplina);
        String cmd=event.getSource().toString();
        if ((cmd.contains("Inserir")||cmd.contains("Atualizar")) &&
                (tfCodigoDisciplina.getText().isEmpty() || tfNomeDisciplina.getText().isEmpty()
                || tfCodigoProfessorDisciplina.getText().isEmpty())){
            JOptionPane.showMessageDialog(null,"Preencha os campos","ERRO",JOptionPane.ERROR_MESSAGE);
        }else{
            if((cmd.contains("Excluir")||cmd.contains("Buscar")||cmd.contains("tfCodigoProfessorDisciplina"))
            && tfCodigoDisciplina.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Preencha o código","ERRO",JOptionPane.ERROR_MESSAGE);
            }else{
                try{
                if (cmd.contains("Listar")){
                    disciplinaController.buscarDisciplinas();
                }else{
                    Disciplina disciplina = new Disciplina();
                    disciplina.setCodigo(Integer.parseInt(tfCodigoDisciplina.getText()));
                    disciplina.setNome(tfNomeDisciplina.getText());
                    if (!tfCodigoProfessorDisciplina.getText().isEmpty()){
                        Professor professor = new Professor();
                        professor.setCodigo(Integer.parseInt(tfCodigoProfessorDisciplina.getText()));
                        disciplina.setProfessor(professor);
                    }
                    if (cmd.contains("Inserir")){
                        disciplinaController.inserirDisciplina(disciplina);
                    }else if(cmd.contains("Atualizar")){
                        disciplinaController.atualizarDisciplina(disciplina);
                    }else if(cmd.contains("Excluir")){
                        disciplinaController.excluirDisciplina(disciplina);
                    }else if(cmd.contains("Buscar") || cmd.contains("tfCodigoDisciplina")){
                        disciplinaController.buscarDisciplina(disciplina);
                    }
                }
                }catch (ClassNotFoundException | SQLException e){
                    JOptionPane.showMessageDialog(null,e.getMessage(),"ERRO",JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
            }
        }

    }
}}
