package br.inatel.autoboss.contoller;

import br.inatel.autoboss.model.UsuarioGeral;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class UsuarioGeralDAO {

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

    public boolean inserirUsuario(UsuarioGeral novoUsuario) {

        conectarnoBanco();

        String sql = "INSERT INTO usuarioGeral (nome,email,cpf,cnpj,senha,telefone,imagem) values (?,?,?,?,?,?,?)";

        try {
            pst = con.prepareStatement(sql);

            pst.setString(1, novoUsuario.getNome());
            pst.setString(2, novoUsuario.getEmail());
            pst.setString(3, novoUsuario.getCpf());
            pst.setString(4, novoUsuario.getCnpj());
            pst.setString(5, novoUsuario.getSenha());
            pst.setString(6, novoUsuario.getTelefone());
            pst.setString(7, novoUsuario.getImagem());
            pst.execute();

            sucesso = true;

        } catch (SQLException ex) {
            System.out.println("Erro ao inserir usuario = " + ex.getMessage());
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

    public ArrayList<UsuarioGeral> buscarUsuariosSemFiltro() {

        ArrayList<UsuarioGeral> listaDeUsuarios = new ArrayList<>();

        conectarnoBanco();

        String sql = "SELECT * FROM usuarioGeral";

        try {

            st = con.createStatement();

            rs = st.executeQuery(sql);

            System.out.println("Lista de usuarios: ");

            while (rs.next()) {

                UsuarioGeral usuarioTemp = new UsuarioGeral(rs.getString("nome"), rs.getString("email"),
                        rs.getString("cpf"), rs.getString("cnpj"), rs.getString("senha"), rs.getString("telefone"), rs.getString("imagem"));

                System.out.println("Nome = " + usuarioTemp.getNome());
                System.out.println("CPF = " + usuarioTemp.getCpf());
                System.out.println("Senha = " + usuarioTemp.getSenha());
                
                System.out.println("---------------------------------");

                listaDeUsuarios.add(usuarioTemp);

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

        return listaDeUsuarios;
    }

    public boolean atualizarUsuarioPeloId(int usuario_id, String novoNome, String novoEmail, String novaSenha, String novoTelefone, String novaImagem) {
        conectarnoBanco();

        String sql = "UPDATE usuarioGeral SET nome=?, email=?, senha=?, telefone=?, imagem=? WHERE usuario_id = ?";

        try {
            pst = con.prepareStatement(sql);
            String user = Integer.toString(usuario_id);
            pst.setString(6, user);
            pst.setString(1, novoNome);
            pst.setString(2, novoEmail);
            pst.setString(3, novaSenha);
            pst.setString(4, novoTelefone);
            pst.setString(5, novaImagem);
            pst.execute();
            sucesso = true;

        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar usuario = " + ex.getMessage());
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

    public boolean deleteUsuarioPeloId(int usuario_id) {

        conectarnoBanco();

        String sql = "DELETE FROM usuarioGeral WHERE usuario_id = ?";

        try {
            pst = con.prepareStatement(sql);
            String user = Integer.toString(usuario_id);
            pst.setString(1, user);
            pst.execute();

            sucesso = true;

        } catch (SQLException ex) {
            System.out.println("Erro ao deletar usuario = " + ex.getMessage());
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
    
    public boolean verificaUsuarioEmailSenha(String email, String senha) {

        conectarnoBanco();

        String sql = "SELECT * FROM usuarioGeral";
        boolean achou = false;

        try {

            st = con.createStatement();

            rs = st.executeQuery(sql);

            while (rs.next()) {

                UsuarioGeral usuarioTemp = new UsuarioGeral(rs.getString("nome"), rs.getString("email"),
                        rs.getString("cpf"), rs.getString("cnpj"), rs.getString("senha"), rs.getString("telefone"), rs.getString("imagem"));

                if(email.equals(usuarioTemp.getEmail()) && senha.equals(usuarioTemp.getSenha())){
                    achou = true;
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
        
        if(!achou)
            JOptionPane.showMessageDialog(null, "E-mail ou/e senha incorreto(s)!");
            
        return achou;
    }
    
    public int retornaId(String email) {

        conectarnoBanco();

        String sql = "SELECT * FROM usuarioGeral";
        boolean achou = false;
        int id = -1;
        
        try {

            st = con.createStatement();

            rs = st.executeQuery(sql);

            while (rs.next()) {

                UsuarioGeral usuarioTemp = new UsuarioGeral(rs.getString("nome"), rs.getString("email"),
                        rs.getString("cpf"), rs.getString("cnpj"), rs.getString("senha"), rs.getString("telefone"), rs.getString("imagem"));

                if(email.equals(usuarioTemp.getEmail())){
                    achou = true;
                    id = rs.getInt("usuario_id");
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
        
        if(!achou)
            JOptionPane.showMessageDialog(null, "E-mail ou/e senha incorreto(s)!");
            
        return id;
    }
    
    public String retornaNome(int id) {

        conectarnoBanco();

        String sql = "SELECT * FROM usuarioGeral";
        boolean achou = false;
        String nome = "vazio";
        
        try {

            st = con.createStatement();

            rs = st.executeQuery(sql);

            while (rs.next()) {

                if(id == rs.getInt("usuario_id")){
                    nome = rs.getString("nome");
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
    
    public String retornaEmail(int id) {

        conectarnoBanco();

        String sql = "SELECT * FROM usuarioGeral";
        boolean achou = false;
        String email = "vazio";
        
        try {

            st = con.createStatement();

            rs = st.executeQuery(sql);

            while (rs.next()) {

                if(id == rs.getInt("usuario_id")){
                    email = rs.getString("email");
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
      
        return email;
    }
    
    public String retornaSenha(int id) {

        conectarnoBanco();

        String sql = "SELECT * FROM usuarioGeral";
        boolean achou = false;
        String senha = "vazio";
        
        try {

            st = con.createStatement();

            rs = st.executeQuery(sql);

            while (rs.next()) {

                if(id == rs.getInt("usuario_id")){
                    senha = rs.getString("senha");
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
      
        return senha;
    }
    
    public String retornaTelefone(int id) {

        conectarnoBanco();

        String sql = "SELECT * FROM usuarioGeral";
        boolean achou = false;
        String telefone = "vazio";
        
        try {

            st = con.createStatement();

            rs = st.executeQuery(sql);

            while (rs.next()) {

                if(id == rs.getInt("usuario_id")){
                    telefone = rs.getString("telefone");
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
      
        return telefone;
    }
    
    public String retornaImagem(int id) {

        conectarnoBanco();

        String sql = "SELECT * FROM usuarioGeral";
        boolean achou = false;
        String imagem = "vazio";
        
        try {

            st = con.createStatement();

            rs = st.executeQuery(sql);

            while (rs.next()) {

                if(id == rs.getInt("usuario_id")){
                    imagem = rs.getString("imagem");
                }
                    
                sucesso = true;
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao retornar imagem = " + ex.getMessage());
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
      
        return imagem;
    }
    
}
