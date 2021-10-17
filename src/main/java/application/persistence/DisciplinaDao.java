package application.persistence;

import application.model.Disciplina;
import application.model.Professor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DisciplinaDao implements IDisciplinaDao{

    private Connection c;

    public DisciplinaDao() throws SQLException, ClassNotFoundException {
        GenericDao gDao = new GenericDao();
        c= gDao.getConnection();
    }

    @Override
    public void inserirDisciplina(Disciplina d) throws SQLException {
        String sql="INSER INTO professor VALUES (?,?,?)";
        PreparedStatement ps=c.prepareStatement(sql);
        ps.setInt(1,d.getCodigo());
        ps.setString(2, d.getNome());
        ps.setInt(3,d.getCodigo());

        ps.execute();
        ps.close();
    }

    @Override
    public void atualizaDisciplina(Disciplina d) throws SQLException {
        String sql="UPDATE professor SET nome = ?, codigoProfessor = ? WHERE codigo = ?";
        PreparedStatement ps=c.prepareStatement(sql);

        ps.setString(1, d.getNome());
        ps.setInt(2,d.getProfessor().getCodigo());
        ps.setInt(3,d.getCodigo());
        ps.execute();
        ps.close();

    }

    @Override
    public void excluiDisciplina(Disciplina d) throws SQLException {
        String sql="DELETE professor WHERE codigo = ?";
        PreparedStatement ps=c.prepareStatement(sql);
        ps.setInt(1,d.getCodigo());
        ps.execute();
        ps.close();

    }

    @Override
    public Disciplina buscaDisciplina(Disciplina d) throws SQLException {
        StringBuffer sql= new StringBuffer();
        sql.append("SELECT d.codigo AS codigoDisciplina, d.nome AS nomeDisciplina");
        sql.append("p.codigo AS codigoProfessor, p.nome AS nomeProfessor, p.Titulacao");
        sql.append("FROM disciplina d INNER JOIN professor p");
        sql.append("ON d.codigoProfessor = p.codigo");
        sql.append("WHERE d.codigo=?");
        PreparedStatement ps=c.prepareStatement(sql.toString());
        ps.setInt(1,d.getCodigo());
        ResultSet rs=ps.executeQuery();
        int cont=0;
        if (rs.next()){
            Professor p=new Professor();
            p.setCodigo(rs.getInt("codigoProfessor"));
            p.setNome(rs.getString("nomeProfessor"));
            p.setTitulacao(rs.getString("titulacao"));
            d.setNome(rs.getString("nomeDisciplina"));
            d.setProfessor(p);
            cont++;
        }
        if(cont==0){
            d=new Disciplina();
            Professor p=new Professor();
            d.setProfessor(p);
        }
        rs.close();
        ps.close();
        return d;
    }

    @Override
    public List<Disciplina> buscaDisciplinas() throws SQLException {
        String sql= "SELECT codigo, nome, professor FROM disciplina";
        PreparedStatement ps=c.prepareStatement(sql.toString());
        List<Disciplina> listaDisciplina=new ArrayList<Disciplina>();
        StringBuffer sqlB= new StringBuffer();
        sqlB.append("SELECT d.codigo AS codigoDisciplina, d.nome AS nomeDisciplina");
        sqlB.append("p.codigo AS codigoProfessor, p.nome AS nomeProfessor, p.Titulacao");
        sqlB.append("FROM disciplina d INNER JOIN professor p");
        sqlB.append("ON d.codigoProfessor = p.codigo");
        ResultSet rs=ps.executeQuery();
        while (rs.next()){
            Professor p=new Professor();
            p.setCodigo(rs.getInt("codigoProfessor"));
            p.setNome(rs.getString("nomeProfessor"));
            p.setTitulacao(rs.getString("titulacao"));
            Disciplina d= new Disciplina();
            d.setCodigo(rs.getInt("codigoDisciplina"));
            d.setNome(rs.getString("nomeDisciplina"));
            d.setProfessor(p);
            listaDisciplina.add(d);
        }
        rs.close();
        ps.close();
        return listaDisciplina;
    }
}
