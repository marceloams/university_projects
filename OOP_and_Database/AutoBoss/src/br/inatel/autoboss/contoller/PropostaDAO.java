package br.inatel.autoboss.contoller;

import br.inatel.autoboss.model.Proposta;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PropostaDAO {

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
    //metodo para inserir propostas no banco
    public boolean inserirProposta(Proposta novaProposta) {

        conectarnoBanco();

        String sql = "INSERT INTO proposta (propostaRealizada,valorProposta,id_usuario,id_projeto,id_client) values (?,?,?,?,?)";

        try {
            pst = con.prepareStatement(sql);
            
            pst.setString(1, novaProposta.getPropostaRealizada());
            String prop = Float.toString(novaProposta.getValorProposta());
            pst.setString(2, prop);
            String usuario = Integer.toString(novaProposta.getIdUsuario());
            pst.setString(3, usuario);
            String proj = Integer.toString(novaProposta.getIdProjeto());
            pst.setString(4, proj);
            String cliente = Integer.toString(novaProposta.getIdCliente());
            pst.setString(5, cliente);
            pst.execute();

            sucesso = true;

        } catch (SQLException ex) {
            System.out.println("Erro ao inserir proposta = " + ex.getMessage());
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
    //metodo para buscar propostas no banco
    public ArrayList<Proposta> buscarPropostasSemFiltro() {

        ArrayList<Proposta> listaDePropostas = new ArrayList<>();

        conectarnoBanco();

        String sql = "SELECT * FROM proposta";

        try {

            st = con.createStatement();

            rs = st.executeQuery(sql);

            System.out.println("Lista de propostas: ");

            while (rs.next()) {

                Proposta propostaTemp = new Proposta(rs.getString("propostaRealizada"), rs.getFloat("valorProposta"), rs.getInt("id_usuario"), rs.getInt("id_projeto"),rs.getInt("id_client"));

                System.out.println("Proposta = " + propostaTemp.getPropostaRealizada());
                System.out.println("Valor da Proposta = " + propostaTemp.getValorProposta());

                System.out.println("---------------------------------");

                listaDePropostas.add(propostaTemp);

                sucesso = true;
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao buscar propostas = " + ex.getMessage());
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

        return listaDePropostas;
    }
    //método para atualizar propostas pelo id
    public boolean atualizarPropostaPeloId(int proposta_id, String novoValor) {
        conectarnoBanco();

        String sql = "UPDATE proposta SET valorProposta = ? WHERE proposta_id = ?";

        try {
            pst = con.prepareStatement(sql);
            String prop = Integer.toString(proposta_id);
            pst.setString(1, prop);
            pst.setString(2, novoValor);
            pst.execute();
            sucesso = true;

        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar proposta = " + ex.getMessage());
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
    //metodo para deletar proposta pelo id do projeto
    public boolean deletePropostaPeloIdProjeto(int projeto_id) {

        conectarnoBanco();

        String sql = "DELETE FROM proposta WHERE id_projeto = ?";

        try {
            pst = con.prepareStatement(sql);
            String prop = Integer.toString(projeto_id);
            pst.setString(1, prop);
            pst.execute();

            sucesso = true;

        } catch (SQLException ex) {
            System.out.println("Erro ao deletar proposta pelo id do projeto = " + ex.getMessage());
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
    //metodo para deletar proposta pelo id
    public boolean deletePropostaPeloId(int proposta_id) {

        conectarnoBanco();

        String sql = "DELETE FROM proposta WHERE proposta_id = ?";

        try {
            pst = con.prepareStatement(sql);
            String prop = Integer.toString(proposta_id);
            pst.setString(1, prop);
            pst.execute();

            sucesso = true;

        } catch (SQLException ex) {
            System.out.println("Erro ao deletar proposta pelo id = " + ex.getMessage());
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
    //metodo para retornar proposta pelo id do cliente
    public ArrayList<Proposta> retornaPropostasPeloIdCliente(int idCliente) {

        ArrayList<Proposta> listaDePropostas = new ArrayList<>();

        conectarnoBanco();

        String sql = "SELECT * FROM proposta";

        try {

            st = con.createStatement();

            rs = st.executeQuery(sql);

            while (rs.next()) {

                if(idCliente == rs.getInt("id_client")){
                    Proposta propostaTemp = new Proposta(rs.getString("propostaRealizada"), rs.getFloat("valorProposta"), rs.getInt("id_usuario"), rs.getInt("id_projeto"),rs.getInt("id_client"));

                    listaDePropostas.add(propostaTemp);
                }
                
                sucesso = true;
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao retornar propostas pelo id do cliente = " + ex.getMessage());
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

        return listaDePropostas;
    }
    //metono para retornar propostas pelo id do freelancer
    public ArrayList<Proposta> retornaPropostasPeloIdFreela(int idUsuario) {

        ArrayList<Proposta> listaDePropostas = new ArrayList<>();

        conectarnoBanco();

        String sql = "SELECT * FROM proposta";

        try {

            st = con.createStatement();

            rs = st.executeQuery(sql);

            while (rs.next()) {

                if(idUsuario == rs.getInt("id_usuario")){
                    Proposta propostaTemp = new Proposta(rs.getString("propostaRealizada"), rs.getFloat("valorProposta"), rs.getInt("id_usuario"), rs.getInt("id_projeto"),rs.getInt("id_client"));

                    listaDePropostas.add(propostaTemp);
                }
                
                sucesso = true;
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao retornar propostas pelo id do Freelancer = " + ex.getMessage());
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

        return listaDePropostas;
    }
    //metodo para retornar o id do freelancer
    public int retornaIdFreela(int idProjeto) {

        int idFreela = -1;

        conectarnoBanco();

        String sql = "SELECT * FROM proposta";

        try {

            st = con.createStatement();

            rs = st.executeQuery(sql);

            while (rs.next()) {

                if(idProjeto == rs.getInt("id_projeto")){
                    idFreela = rs.getInt("id_usuario");
                }
                
                sucesso = true;
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao retornar id do freelancer pelo id do projeto = " + ex.getMessage());
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

        return idFreela;
    }
    
    public int retornaIdPropostaPelaPropostaRealizada(String realizada) {

        int idProp = -1;

        conectarnoBanco();

        String sql = "SELECT * FROM proposta";

        try {

            st = con.createStatement();

            rs = st.executeQuery(sql);

            while (rs.next()) {

                if(realizada.equals(rs.getString("propostaRealizada"))){
                    idProp = rs.getInt("proposta_id");
                }
                
                sucesso = true;
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao retornar id da proposta pela porposta realizada = " + ex.getMessage());
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

        return idProp;
    }
    //metodo para retornar o orçamento da proposta realizada
    public float retornaOrcamentoPelaPropostaRealizada(String realizada) {

        float orcamento = -1;

        conectarnoBanco();

        String sql = "SELECT * FROM proposta";

        try {

            st = con.createStatement();

            rs = st.executeQuery(sql);

            while (rs.next()) {

                if(realizada.equals(rs.getString("propostaRealizada"))){
                    orcamento = rs.getFloat("valorProposta");
                }
                
                sucesso = true;
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao retornar id da proposta pela porposta realizada = " + ex.getMessage());
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

        return orcamento;
    }
}
