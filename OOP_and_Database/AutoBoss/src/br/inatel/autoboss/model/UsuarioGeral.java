package br.inatel.autoboss.model;

//classe para declarar usuariogeral e seus atributos
public class UsuarioGeral {
    //DECLARANDO OS ATRIBUTOS DA TABLE USUARIO GERAL
    private String nome;
    private String email;
    private String cpf;
    private String cnpj;
    private String senha;
    private String telefone;
    private String imagem;
    
    public UsuarioGeral (String nome, String email,String cpf,String cnpj, String senha, String telefone, String imagem){
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.senha = senha;
        this.telefone = telefone;
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    public String getSenha() {
        return senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
    
    
    
    
}
