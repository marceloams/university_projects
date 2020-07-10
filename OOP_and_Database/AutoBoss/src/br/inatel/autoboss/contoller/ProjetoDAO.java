package br.inatel.autoboss.contoller;

import br.inatel.autoboss.model.Projetos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

//classe para a conexão de projetos com o banco
public class ProjetoDAO {

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
    //método para inserir projetos no banco de dados
    public boolean inserirProjeto(Projetos novoUsuario) {

        conectarnoBanco();

        String sql = "INSERT INTO projeto (nomeProjeto,descricaoProjeto,categoria,precoMin,precoMax,statusProjeto,id_cliente,id_usuarioo) values (?,?,?,?,?,?,?,?)";

        try {
            pst = con.prepareStatement(sql);

            pst.setString(1, novoUsuario.getNomeProjeto());
            pst.setString(2, novoUsuario.getDescricaoProjeto());
            pst.setString(3, novoUsuario.getCategoria());
            String pmin = Float.toString(novoUsuario.getPrecoMin());
            pst.setString(4, pmin);
            String pmax = Float.toString(novoUsuario.getPrecoMax());
            pst.setString(5, pmax);
            String status = Integer.toString(novoUsuario.getStatus());
            pst.setString(6, status);
            String cliente = Integer.toString(novoUsuario.getCliente());
            pst.setString(7, cliente);
            String freelancer = Integer.toString(novoUsuario.getFreela());
            pst.setString(8, freelancer);
            pst.execute();

            sucesso = true;

        } catch (SQLException ex) {
            System.out.println("Erro ao inserir projeto = " + ex.getMessage());
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
    //método para buscar projetos no banco de dados
    public ArrayList<Projetos> buscarProjetosSemFiltro() {

        ArrayList<Projetos> listaDeUsuarios = new ArrayList<>();

        conectarnoBanco();

        String sql = "SELECT * FROM projeto";

        try {

            st = con.createStatement();

            rs = st.executeQuery(sql);

            while (rs.next()) {

                Projetos projetosTemp = new Projetos(rs.getString("nomeProjeto"), rs.getString("descricaoProjeto"),
                        rs.getString("categoria"), rs.getInt("precoMin"), rs.getInt("precoMax"), rs.getInt("statusProjeto"), rs.getInt("id_cliente"),rs.getInt("id_usuarioo"));

                System.out.println("Nome do projeto = " + projetosTemp.getNomeProjeto());
                System.out.println("Descricao do projeto = " + projetosTemp.getDescricaoProjeto());

                System.out.println("---------------------------------");

                listaDeUsuarios.add(projetosTemp);

                sucesso = true;
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao buscar projetos = " + ex.getMessage());
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

        return listaDeUsuarios;
    }
    //método para alterar o status do projeto pelo id 
    public boolean AlteraStatusPeloId(int projeto_id, String status) {
        conectarnoBanco();

        String sql = "UPDATE projeto SET statusProjeto = ? WHERE projeto_id = ?";

        try {
            pst = con.prepareStatement(sql);
            String proj = Integer.toString(projeto_id);
            pst.setString(1, status);
            pst.setString(2, proj);
            pst.execute();
            sucesso = true;

        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar status do projeto para em desenvolvimento = " + ex.getMessage());
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
    //método para atualizar o freelancer de um projeto pelo id
    public boolean AlteraFreelancerPeloId(int projeto_id, int freela_id) {
        conectarnoBanco();

        String sql = "UPDATE projeto SET id_usuarioo = ? WHERE projeto_id = ?";

        try {
            pst = con.prepareStatement(sql);
            String proj = Integer.toString(projeto_id);
            String usuario = Integer.toString(freela_id);
            pst.setString(1, usuario);
            pst.setString(2, proj);
            pst.execute();
            sucesso = true;

        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar o freelancer do projeto = " + ex.getMessage());
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
    //metodo para alterar o preco do projeto pelo id
    public boolean AlteraPrecoPeloId(int projeto_id, float orcamento) {
        conectarnoBanco();

        String sql = "UPDATE projeto SET precoMin = ? , precoMax = ?  WHERE projeto_id = ?";

        try {
            pst = con.prepareStatement(sql);
            String proj = Integer.toString(projeto_id);
            String orca = Float.toString(orcamento);
            pst.setString(1, orca);
            pst.setString(2, orca);
            pst.setString(3, proj);
            pst.execute();
            sucesso = true;

        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar precos do projeto para o orcamento aceito = " + ex.getMessage());
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
    //método para deletar o projeto pelo id
    public boolean deleteprojetoPeloId(int projeto_id) {

        conectarnoBanco();

        String sql = "DELETE FROM projeto WHERE projeto_id = ?";

        try {
            pst = con.prepareStatement(sql);
            String user = Integer.toString(projeto_id);
            pst.setString(1, user);
            pst.execute();

            sucesso = true;

        } catch (SQLException ex) {
            System.out.println("Erro ao deletar projeto = " + ex.getMessage());
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
    //metodo para retornar id
    public int retornaId(String projeto) {

        conectarnoBanco();

        String sql = "SELECT * FROM projeto";
        boolean achou = false;
        int id = -1;
        
        try {

            st = con.createStatement();

            rs = st.executeQuery(sql);

            while (rs.next()) {

                if(projeto.equals(rs.getString("nomeProjeto"))){
                    achou = true;
                    id = rs.getInt("projeto_id");
                }
                    
                sucesso = true;
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao buscar usuarios = " + ex.getMessage());
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
        
            
        return id;
    }
    //metodo para retornar nome pelo id
    public String retornaNomePeloId(int idProjeto) {

        conectarnoBanco();

        String sql = "SELECT * FROM projeto";
        String nome = "vazia";
        
        try {

            st = con.createStatement();

            rs = st.executeQuery(sql);

            while (rs.next()) {

                if(idProjeto == rs.getInt("projeto_id")){
                    nome = rs.getString("nomeProjeto");
                }
                    
                sucesso = true;
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao buscar usuarios = " + ex.getMessage());
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
            
        return nome;
    }
    //metodo para retornar projetos pelo id do cliente
    public ArrayList<Projetos> retornaProjetosPeloIdCliente(int idCliente) {

        ArrayList<Projetos> listaDeProjetos = new ArrayList<>();

        conectarnoBanco();

        String sql = "SELECT * FROM projeto";

        try {

            st = con.createStatement();

            rs = st.executeQuery(sql);

            while (rs.next()) {

                if(idCliente == rs.getInt("id_cliente") && rs.getInt("statusProjeto")!=2){
                    Projetos projetosTemp = new Projetos(rs.getString("nomeProjeto"), rs.getString("descricaoProjeto"),
                        rs.getString("categoria"), rs.getInt("precoMin"), rs.getInt("precoMax"), rs.getInt("statusProjeto"), rs.getInt("id_cliente"), rs.getInt("id_usuarioo"));

                    listaDeProjetos.add(projetosTemp);
                }
                
                sucesso = true;
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao retornar projetos pelo id do cliente = " + ex.getMessage());
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

        return listaDeProjetos;
    }
    //metodo para retornar projetos pelo id do freelancer
    public ArrayList<Projetos> retornaProjetosPeloIdFreelancer(int idFreela) {

        ArrayList<Projetos> listaDeProjetos = new ArrayList<>();

        conectarnoBanco();

        String sql = "SELECT * FROM projeto";

        try {

            st = con.createStatement();

            rs = st.executeQuery(sql);

            while (rs.next()) {

                if(idFreela == rs.getInt("id_usuarioo") && rs.getInt("statusProjeto")!=2){
                    Projetos projetosTemp = new Projetos(rs.getString("nomeProjeto"), rs.getString("descricaoProjeto"),
                        rs.getString("categoria"), rs.getInt("precoMin"), rs.getInt("precoMax"), rs.getInt("statusProjeto"), rs.getInt("id_cliente"), rs.getInt("id_usuarioo"));

                    listaDeProjetos.add(projetosTemp);
                }
                
                sucesso = true;
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao retornar projetos pelo id do freelancer = " + ex.getMessage());
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

        return listaDeProjetos;
    }
    //metodo para retornar projetos pelo id do usuario
    public ArrayList<Projetos> retornaProjetosPeloIdUsuario(int idUsuario) {

        ArrayList<Projetos> listaDeProjetos = new ArrayList<>();

        conectarnoBanco();

        String sql = "SELECT * FROM projeto";

        try {

            st = con.createStatement();

            rs = st.executeQuery(sql);

            while (rs.next()) {

                if(idUsuario == rs.getInt("id_usuarioo") && rs.getInt("statusProjeto")==2){
                    Projetos projetosTemp = new Projetos(rs.getString("nomeProjeto"), rs.getString("descricaoProjeto"),
                        rs.getString("categoria"), rs.getInt("precoMin"), rs.getInt("precoMax"), rs.getInt("statusProjeto"), rs.getInt("id_cliente"), rs.getInt("id_usuarioo"));

                    listaDeProjetos.add(projetosTemp);
                }
                
                sucesso = true;
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao retornar projetos pelo id do freelancer = " + ex.getMessage());
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

        return listaDeProjetos;
    }
    //metodo para retornar projetos pela categoria
    public ArrayList<Projetos> retornaProjetosPelaCategoria(String categoria) {

        ArrayList<Projetos> listaDeProjetos = new ArrayList<>();

        conectarnoBanco();

        String sql = "SELECT * FROM projeto";

        try {

            st = con.createStatement();

            rs = st.executeQuery(sql);

            while (rs.next()) {

                if(categoria.equals(rs.getString("categoria")) && rs.getInt("statusProjeto")!=2 && rs.getInt("statusProjeto")!=1){
                    Projetos projetosTemp = new Projetos(rs.getString("nomeProjeto"), rs.getString("descricaoProjeto"),
                        rs.getString("categoria"), rs.getInt("precoMin"), rs.getInt("precoMax"), rs.getInt("statusProjeto"), rs.getInt("id_cliente"), rs.getInt("id_usuarioo"));

                    listaDeProjetos.add(projetosTemp);
                }
                
                sucesso = true;
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao retornar projetos pela categoria = " + ex.getMessage());
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

        return listaDeProjetos;
    }
    //método para retornar o id do cliente pelo id do projeto
    public int retornaIdClientePeloIdProjeto(int idProjeto) {

        conectarnoBanco();

        String sql = "SELECT * FROM projeto";
        int id = -1;
        
        try {

            st = con.createStatement();

            rs = st.executeQuery(sql);

            while (rs.next()) {
                if(rs.getInt("projeto_id")==idProjeto){
                    id = rs.getInt("id_cliente");
                }
                    
                sucesso = true;
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao buscar cliente pelo id do projeto = " + ex.getMessage());
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
            
        return id;
    }
    //metodo para rettornar se tem projetos por categoria
    public boolean retornaSeTemProjetoPelaCategoria(String categoria) {

        ArrayList<Projetos> listaDeProjetos = new ArrayList<>();

        boolean vazio = false;
        
        conectarnoBanco();

        String sql = "SELECT * FROM projeto";

        try {

            st = con.createStatement();

            rs = st.executeQuery(sql);

            while (rs.next()) {

                if(categoria.equals(rs.getString("categoria")) && rs.getInt("statusProjeto")!=2 && rs.getInt("statusProjeto")!=1){
                    Projetos projetosTemp = new Projetos(rs.getString("nomeProjeto"), rs.getString("descricaoProjeto"),
                        rs.getString("categoria"), rs.getInt("precoMin"), rs.getInt("precoMax"), rs.getInt("statusProjeto"), rs.getInt("id_cliente"), rs.getInt("id_usuarioo"));

                    listaDeProjetos.add(projetosTemp);
                }
                
                sucesso = true;
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao retornar se tem projeto pela categoria = " + ex.getMessage());
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

        if(listaDeProjetos.isEmpty()){
            vazio = true;
        }
        
        return vazio;
    }
    
}
