/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inatel.autoboss.model;

/**
 *
 * @author Sinara
 */

//classe para declarar o relacionamento projetohasconhecimento
public class ProjetoHasConhecimento {
    
    private int id_projeto;
    private int id_conhecimento;
    
    public ProjetoHasConhecimento(int proj, int conhe){
        id_projeto = proj;
        id_conhecimento = conhe;
    }

    public int getId_projeto() {
        return id_projeto;
    }

    public void setId_projeto(int id_projeto) {
        this.id_projeto = id_projeto;
    }

    public int getId_conhecimento() {
        return id_conhecimento;
    }

    public void setId_conhecimento(int id_conhecimento) {
        this.id_conhecimento = id_conhecimento;
    }
}
