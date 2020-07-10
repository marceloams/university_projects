package br.inatel.autoboss.model;

//classe para declarar projetos e seus atributos
public class Projetos {
    
    private String nomeProjeto;
    private String descricaoProjeto;
    private String categoria;
    private float precoMin;
    private float precoMax;
    private int status;
    private int cliente;
    private int freela;
    
    public Projetos(String nomeProjeto, String descricaoProjeto, String categoria, float precoMin, float precoMax, int status, int cli, int free){
        this.nomeProjeto = nomeProjeto;
        this.descricaoProjeto = descricaoProjeto;
        this.precoMin = precoMin;
        this.precoMax = precoMax;
        this.status =  status;
        this.categoria = categoria;
        this.cliente = cli;
        this.freela = free;
    }
    public String getNomeProjeto() {
        return nomeProjeto;
    }

    public void setNomeProjeto(String nomeProjeto) {
        this.nomeProjeto = nomeProjeto;
    }

    public String getDescricaoProjeto() {
        return descricaoProjeto;
    }

    public void setDescricaoProjeto(String descricaoProjeto) {
        this.descricaoProjeto = descricaoProjeto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
       
    public float getPrecoMin() {
        return precoMin;
    }

    public void setPrecoMin(int precoMin) {
        this.precoMin = precoMin;
    }

    public float getPrecoMax() {
        return precoMax;
    }

    public void setPrecoMax(int precoMax) {
        this.precoMax = precoMax;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }    

    public int getFreela() {
        return freela;
    }

    public void setFreela(int freela) {
        this.freela = freela;
    }
}
