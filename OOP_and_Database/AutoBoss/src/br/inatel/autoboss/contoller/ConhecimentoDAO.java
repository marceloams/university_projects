package br.inatel.autoboss.contoller;

import br.inatel.autoboss.model.Conhecimento;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ConhecimentoDAO {

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
    //metodo para inserir os conhecimentos no banco de dados
    public boolean inserirConhecimento(Conhecimento novoConhecimento) {

        conectarnoBanco();

        String sql = "INSERT INTO Conhecimento (nomeConhecimento) values (?)";

        try {
            pst = con.prepareStatement(sql);
            
            pst.setString(1, novoConhecimento.getNomeConhecimento());
            pst.execute();

            sucesso = true;

        } catch (SQLException ex) {
            System.out.println("Erro ao inserir conhecimento = " + ex.getMessage());
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
    //metodo para buscar os conhecimentos no banco
    public ArrayList<Conhecimento> buscarConhecimentosSemFiltro() {

        ArrayList<Conhecimento> listaDeConhecimentos = new ArrayList<>();

        conectarnoBanco();

        String sql = "SELECT * FROM conhecimento";

        try {

            st = con.createStatement();

            rs = st.executeQuery(sql);

            System.out.println("Lista de conhecimentos: ");

            while (rs.next()) {

                Conhecimento conhecimentoTemp = new Conhecimento(rs.getString("nomeConhecimento"));

                System.out.println("Conhecimento = " + conhecimentoTemp.getNomeConhecimento());

                System.out.println("---------------------------------");

                listaDeConhecimentos.add(conhecimentoTemp);

                sucesso = true;
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao buscar conhecimentos = " + ex.getMessage());
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
    //metodo para atualizar os conhecimentos pelo id
    public boolean atualizarConhecimentoPeloId(int conhecimento_id, String novoNome) {
        conectarnoBanco();

        String sql = "UPDATE conhecimento SET nomeConhecimento = ? WHERE conhecimento_id = ?";

        try {
            pst = con.prepareStatement(sql);
            String conhe = Integer.toString(conhecimento_id);
            pst.setString(1, conhe);
            pst.setString(2, novoNome);
            pst.execute();
            sucesso = true;

        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar conhecimento = " + ex.getMessage());
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
    //metodo para deletar o conhecimento pelo id
    public boolean deleteConhecimentoPeloId(int conhecimento_id) {

        conectarnoBanco();

        String sql = "DELETE FROM conhecimento WHERE conhecimento_id = ?";

        try {
            pst = con.prepareStatement(sql);
            String prop = Integer.toString(conhecimento_id);
            pst.setString(1, prop);
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

}
