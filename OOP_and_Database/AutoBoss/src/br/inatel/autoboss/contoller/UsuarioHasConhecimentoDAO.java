/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inatel.autoboss.contoller;

import br.inatel.autoboss.model.UsuarioHasConhecimento;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sinara
 */
public class UsuarioHasConhecimentoDAO {
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

    public boolean inserirUsuarioHasConhecimento(UsuarioHasConhecimento novoUsuarioConhecimento) {

        conectarnoBanco();

        String sql = "INSERT INTO usuarioGeral_has_conhecimento (id_usuariooo, id_conhecimentooo) values (?,?)";

        try {
            pst = con.prepareStatement(sql);
            
            pst.setInt(1, novoUsuarioConhecimento.getId_usuario());
            pst.setInt(2, novoUsuarioConhecimento.getId_conhecimento());
            pst.execute();

            sucesso = true;

        } catch (SQLException ex) {
            System.out.println("Erro ao inserir usuarioGeralHasConhecimento = " + ex.getMessage());
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

    public ArrayList<UsuarioHasConhecimento> buscarUsuariosHasConhecimentosSemFiltro() {

        ArrayList<UsuarioHasConhecimento> listaDeUsuariosConhecimentos = new ArrayList<>();

        conectarnoBanco();

        String sql = "SELECT * FROM usuarioGeral_has_conhecimento";

        try {

            st = con.createStatement();

            rs = st.executeQuery(sql);

            System.out.println("Lista de usuarioGeralHasConhecimentos: ");

            while (rs.next()) {

                UsuarioHasConhecimento UsuarioConhecimentoTemp = new UsuarioHasConhecimento(rs.getInt("id_usuariooo"),rs.getInt("id_conhecimentooo"));

                System.out.println("Usuario = " + UsuarioConhecimentoTemp.getId_usuario());
                System.out.println("Conhecimento = " + UsuarioConhecimentoTemp.getId_conhecimento());

                System.out.println("---------------------------------");

                listaDeUsuariosConhecimentos.add(UsuarioConhecimentoTemp);

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

        return listaDeUsuariosConhecimentos;
    }

    public boolean deleteUsuariosHasConhecimentosPeloId(int id_usuariooo, int id_conhecimentooo) {

        conectarnoBanco();

        String sql = "DELETE FROM usuarioGeral_has_conhecimento WHERE id_usuariooo = ? AND id_conhecimentooo = ?";

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id_usuariooo);
            pst.setInt(2, id_conhecimentooo);
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
    
    public List<Integer> retornaUsuarioConhecimento(int id) {

        List<Integer> listaDeConhecimentos = new ArrayList<>();

        conectarnoBanco();

        String sql = "SELECT * FROM usuarioGeral_has_conhecimento";

        try {

            st = con.createStatement();

            rs = st.executeQuery(sql);

            while (rs.next()) {

                if(id == rs.getInt("id_usuariooo"))
                    listaDeConhecimentos.add(rs.getInt("id_conhecimentooo"));

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

        return listaDeConhecimentos;
    }
}
