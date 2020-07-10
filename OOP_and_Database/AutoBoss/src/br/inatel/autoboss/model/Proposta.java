package br.inatel.autoboss.model;

//classe para declarar proposta e seus atributos
public class Proposta {
    private String propostaRealizada;
    private float valorProposta;
    private int idUsuario;
    private int idProjeto;
    private int idCliente;

    public Proposta(String propostaRealizada, float valorProposta, int usuario, int projeto, int cliente){
        this.propostaRealizada = propostaRealizada;
        this.valorProposta = valorProposta;
        this.idUsuario = usuario;
        this.idProjeto = projeto;
        this.idCliente = cliente;
    }

    public float getValorProposta() {
        return valorProposta;
    }

    public void setValorProposta(float valorProposta) {
        this.valorProposta = valorProposta;
    }

    public String getPropostaRealizada() {
        return propostaRealizada;
    }

    public void setPropostaRealizada(String propostaRealizada) {
        this.propostaRealizada = propostaRealizada;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdProjeto() {
        return idProjeto;
    }

    public void setIdProjeto(int idProjeto) {
        this.idProjeto = idProjeto;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
}
