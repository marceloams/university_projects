/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inatel.autoboss.contoller;

import br.inatel.autoboss.model.ProjetoHasConhecimento;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Sinara
 */
public class ProjetoHasConhecimentoDAO {
    // objeto responsável pela conexão com o servidor do banco de dados
    Connection con;
    // objeto responsável por preparar as consultas DINAMICAS
    PreparedStatement pst;
    // objeto responsável por executar as consultas STATICAS
    Statement st;
    // objeto responsável por referencia a tabela resultante da busca
    ResultSet rs;

    String banco = "freelancer";
    // TimeZone apartir do MySql 8.0
    String url = "jdbc:mysql://localhost:3306/" + banco + "?useTimezone=true&serverTimezone=UTC&useSSL=false";
    String usuario = "root";
    String senha = "root";

    boolean sucesso = false;

    public void conectarnoBanco() {
        try {
            con = DriverManager.getConnection(url, usuario, senha);

            System.out.println("Conexão feita com sucesso!");

        } catch (SQLException ex) {

            System.out.println("Erro de conexão: " + ex.getMessage());

        }
    }

    public boolean inserirProjetoHasConhecimento(ProjetoHasConhecimento novoProjetoConhecimento) {

        conectarnoBanco();

        String sql = "INSERT INTO projeto_has_conhecimento (id_projeto, id_conhecimento_projeto) values (?,?)";

        try {
            pst = con.prepareStatement(sql);
            
            pst.setInt(1, novoProjetoConhecimento.getId_projeto());
            pst.setInt(2, novoProjetoConhecimento.getId_conhecimento());
            pst.execute();

            sucesso = true;

        } catch (SQLException ex) {
            System.out.println("Erro ao inserir ProjetoGeralHasConhecimento = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {

                if (con != null && pst != null) {
                    con.close();
                    pst.close();
                }

            } catch (SQLException ex) {
                System.out.println("Erro ao fechar o bd = " + ex.getMessage());
            }

        }

        return sucesso;
    }

    public ArrayList<ProjetoHasConhecimento> buscarProjetosHasConhecimentosSemFiltro() {

        ArrayList<ProjetoHasConhecimento> listaDeProjetosConhecimentos = new ArrayList<>();

        conectarnoBanco();

        String sql = "SELECT * FROM projeto_has_conhecimento";

        try {

            st = con.createStatement();

            rs = st.executeQuery(sql);

            System.out.println("Lista de projetoGeralHasConhecimentos: ");

            while (rs.next()) {

                ProjetoHasConhecimento projetoConhecimentoTemp = new ProjetoHasConhecimento(rs.getInt("id_projeto"),rs.getInt("id_conhecimento_projeto"));

                System.out.println("Projeto = " + projetoConhecimentoTemp.getId_projeto());
                System.out.println("Conhecimento = " + projetoConhecimentoTemp.getId_conhecimento());

                System.out.println("---------------------------------");

                listaDeProjetosConhecimentos.add(projetoConhecimentoTemp);

                sucesso = true;
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao buscar UsuarioHasConhecimentos = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {

                if (con != null && pst != null) {
                    con.close();
                    pst.close();
                }

            } catch (SQLException ex) {
                System.out.println("Erro ao fechar o bd = " + ex.getMessage());
            }

        }

        return listaDeProjetosConhecimentos;
    }

    public boolean deleteUsuariosHasConhecimentosPeloId(int id_projeto, int id_conhecimento) {

        conectarnoBanco();

        String sql = "DELETE FROM projeto_has_conhecimento WHERE id_projeto = ? AND id_conhecimento_projeto = ?";

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id_projeto);
            pst.setInt(2, id_conhecimento);
            pst.execute();

            sucesso = true;

        } catch (SQLException ex) {
            System.out.println("Erro ao deletar conhecimento = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {

                if (con != null && pst != null) {
                    con.close();
                    pst.close();
                }

            } catch (SQLException ex) {
                System.out.println("Erro ao fechar o bd = " + ex.getMessage());
            }

        }

        return sucesso;
    }
    
    public ArrayList<ProjetoHasConhecimento> retornaConhecimentoPeloIdProjeto(int idProjeto) {

        ArrayList<ProjetoHasConhecimento> listaDeProjetosConhecimentos = new ArrayList<>();

        conectarnoBanco();

        String sql = "SELECT * FROM projeto_has_conhecimento";

        try {

            st = con.createStatement();

            rs = st.executeQuery(sql);

            while (rs.next()) {

                
                if(rs.getInt("id_projeto") == idProjeto)
                {
                    ProjetoHasConhecimento projetoConhecimentoTemp = new ProjetoHasConhecimento(rs.getInt("id_projeto"),rs.getInt("id_conhecimento_projeto"));

                    listaDeProjetosConhecimentos.add(projetoConhecimentoTemp);
                }

                sucesso = true;
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao buscar UsuarioHasConhecimentos = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {

                if (con != null && pst != null) {
                    con.close();
                    pst.close();
                }

            } catch (SQLException ex) {
                System.out.println("Erro ao fechar o bd = " + ex.getMessage());
            }

        }

        return listaDeProjetosConhecimentos;
    }
}
